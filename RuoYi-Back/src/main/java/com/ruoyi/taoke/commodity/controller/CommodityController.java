package com.ruoyi.taoke.commodity.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.taoke.api.dto.comm.N_tbk_item;
import com.ruoyi.taoke.api.dto.comm.TbkCommGetResponseDto;
import com.ruoyi.taoke.api.service.CommdityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.taoke.commodity.domain.Commodity;
import com.ruoyi.taoke.commodity.service.ICommodityService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 商品信息Controller
 * 
 * @author XRZ
 * @date 2019-09-08
 */
@Controller
@RequestMapping("/taoke/commodity")
public class CommodityController extends BaseController {
    private String prefix = "taoke/commodity";

    @Autowired
    private ICommodityService commodityService;
    @Autowired
    private CommdityService commdityService;

    @RequiresPermissions("taoke:commodity:view")
    @GetMapping()
    public String commodity()
    {
        return prefix + "/commodity";
    }

    /**
     * 查询商品信息列表
     */
    @RequiresPermissions("taoke:commodity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Commodity commodity) {
        if (ShiroUtils.getUserId() != 1) {
            commodity.setUId(String.valueOf(ShiroUtils.getUserId()));
        }
        startPage();
        List<Commodity> list = commodityService.selectCommodityList(commodity);
        return getDataTable(list);
    }


    /**
     * 新增商品信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品信息
     */
    @RequiresPermissions("taoke:commodity:add")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Commodity commodity) {
        commodity.setUId(String.valueOf(ShiroUtils.getUserId()));
        String[] split = commodity.getCategoryId().split(";");
        commodity.setCategoryId(split[0]);
        commodity.setCategoryName(split[1]);
        //调用淘宝客API获取商品信息 保存基本商品信息
        TbkCommGetResponseDto res = commdityService.getComInfoById(commodity.getCId());
        if(res.getTbk_item_info_get_response() == null) return error("很抱歉，该商品信息无法获取！");
        //获取商品信息
        N_tbk_item item = res.getTbk_item_info_get_response().getResults().getN_tbk_item().get(0);
        commodity.setComName(item.getTitle());           //设置商品标题
        commodity.setComPrice(item.getZk_final_price()); //设置商品价格（取折扣价）
        commodity.setComImg(item.getPict_url());         //设置商品主图
        return toAjax(commodityService.insertCommodity(commodity));
    }
    /**
     * 删除商品信息
     */
    @RequiresPermissions("taoke:commodity:remove")
    @Log(title = "商品信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(commodityService.deleteCommodityByIds(ids));
    }
}
