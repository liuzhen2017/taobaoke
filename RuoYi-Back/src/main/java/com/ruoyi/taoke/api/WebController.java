package com.ruoyi.taoke.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.taoke.api.dto.comm.ComDto;
import com.ruoyi.taoke.api.dto.comm.N_tbk_item;
import com.ruoyi.taoke.api.dto.comm.TbkCommGetResponseDto;
import com.ruoyi.taoke.api.service.CommdityService;
import com.ruoyi.taoke.category.domain.Category;
import com.ruoyi.taoke.category.service.ICategoryService;
import com.ruoyi.taoke.commodity.domain.Commodity;
import com.ruoyi.taoke.commodity.service.ICommodityService;
import com.ruoyi.taoke.poster.domain.Poster;
import com.ruoyi.taoke.poster.service.IPosterService;
import com.ruoyi.taoke.term.domain.Term;
import com.ruoyi.taoke.term.service.ITermService;
import com.ruoyi.taoke.webset.domain.Webset;
import com.ruoyi.taoke.webset.service.IWebsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author XRZ
 * @date 2019/9/9
 * @Description : 提供给前端的接口
 */
@RestController
@CrossOrigin
@RequestMapping("/web")
public class WebController {

    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private ICommodityService iCommodityService;
    @Autowired
    private CommdityService commdityService;
    @Autowired
    private ITermService iTermService;
    @Autowired
    private IWebsetService iWebsetService;
    @Autowired
    private IPosterService iPosterService;

    /**
     * 根据用户ID 获取 用户的海报
     * @param uid
     * @return
     */
    @GetMapping("/getPosterByUid/{uid}")
    public List<Poster> getPosterByUid(@PathVariable("uid") String uid){
        Poster poster = new Poster();
        poster.setUId(uid);
        return iPosterService.selectPosterList(poster);
    }

    /**
     * 根据 用户ID 获取 用户 的标题
     * @param uid
     * @return
     */
    @GetMapping("/getWebSetByUid/{uid}")
    public Webset getWebSetByUid(@PathVariable("uid") String uid){
        return iWebsetService.selectWebsetById(Long.valueOf(uid));
    }

    /**
     * 根据 用户ID 获取该 用户 下的所有商品 的分类列表
     * @param uid 用户ID
     * @return
     */
    @GetMapping("/getCategoryListByUid/{uid}")
    public List<Category> getCategoryListByUid(@PathVariable("uid") String uid){
        Category category = new Category();
        category.setUserId(uid);
        category.setEnable(1);
        return iCategoryService.selectCategoryList(category);
    }

    /**
     *  根据用户ID 和 分类ID 获取 商品信息列表
     * @param uid    用户ID
     * @param cid    分类ID
     * @param page   当前页
     * @param pageSize  每页展示大小
     * @return
     */
    @GetMapping("/getComInfoList")
    public Object getComInfoList(@RequestParam("uid") String uid,
                                 @RequestParam("cid") String cid,
                                 @RequestParam("page") Integer page,
                                 @RequestParam("pageSize") Integer pageSize){
        Commodity commodity = new Commodity();
        commodity.setUId(uid);
        commodity.setCategoryId(cid);
        PageHelper.startPage(page,pageSize);
        List<Commodity> list = iCommodityService.selectCommodityList(commodity);
        if(list.size() < 1) return null;
        List<ComDto> collect = list.stream().map(c -> {
            ComDto comDto = new ComDto();
            comDto.setCommodity(c);
            TbkCommGetResponseDto commGetResponseDto = commdityService.getComInfoById(c.getCId());
            if(commGetResponseDto.getTbk_item_info_get_response() != null){
                N_tbk_item item = commGetResponseDto.getTbk_item_info_get_response().getResults().getN_tbk_item().get(0);
                comDto.getCommodity().setComPrice(item.getZk_final_price()); //重新赋值折扣价格，确保是最新的
                comDto.setItem(item);
            }
            return comDto;
        }).collect(Collectors.toList());
        return new PageInfo<ComDto>(collect);
    }

    /**
     * 根据用户ID 商品ID 获取 优惠券url校验是否在有使用权限
     * @param uid   用户ID
     * @param id   ID
     * @return
     */
    @GetMapping("/checkTime")
    public Object checkTime(@RequestParam("uid") String uid,
                            @RequestParam("cid") String id){
        Map<String,String> map = new HashMap<>();
        Term term = iTermService.selectTermById(Long.valueOf(uid));
        //获取创建时间的 时间戳
        long time = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(term.getCreatedDate(), new ParsePosition(0)).getTime();
        //创建时间戳 + 可用时限 > 当前时间戳  ? true:false
        if(Long.valueOf(term.getAvailableTime()) + time > System.currentTimeMillis()){
            //根据商品ID获取优惠卷URL
            Commodity commodity = iCommodityService.selectCommodityById(id);
            map.put("code","0000");
            map.put("message",commodity.getCouponUrl()); //优惠券领取的URL
            return map;
        }
        map.put("code","9999");
        map.put("message","期限已过");
        return map;
    }


}
