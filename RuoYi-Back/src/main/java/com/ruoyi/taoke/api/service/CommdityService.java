package com.ruoyi.taoke.api.service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.taoke.api.dto.comm.TbkCommGetResponseDto;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.request.TbkItemRecommendGetRequest;
import com.taobao.api.response.TbkItemInfoGetResponse;
import com.taobao.api.response.TbkItemRecommendGetResponse;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author XRZ
 * @date 2019/9/8
 * @Description :
 */
@Data
@Service
public class CommdityService {

    private static String appkey = "27844716";
    private static String secret = "dc26231aa9069a0718d2767cd04698ae";
    private static TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", appkey, secret);
    private static TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();

    static {
        req.setPlatform(2L); //链接形式：1：PC，2：无线，默认：１
    }

    /**
     * 通过 URL获取 商品ID 获取商品的信息
     * @param url 请求
     * @return
     */
    public TbkCommGetResponseDto getComInfoByUrl(String url){
        req.setNumIids(getParamByUrl(url,"id"));
        try {
            return JSONObject.parseObject(client.execute(req).getBody(),TbkCommGetResponseDto.class);
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过 商品ID 获取商品的信息
     * @param id id
     * @return
     */
    public TbkCommGetResponseDto getComInfoById(String id){
        req.setNumIids(id);
        try {
            return JSONObject.parseObject(client.execute(req).getBody(),TbkCommGetResponseDto.class);
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 获取指定url中的某个参数
     * @param url
     * @param name
     * @return
     */
    private  String getParamByUrl(String url, String name) {
        url += "&";
        String pattern = "(\\?|&){1}#{0,1}" + name + "=[a-zA-Z0-9]*(&{1})";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(url);
        if (m.find( )) {
            return m.group(0).split("=")[1].replace("&", "");
        } else {
            return null;
        }
    }

//    public static void main(String[] args) {
//        System.out.println(new CommdityService().getComInfoById("41416705409"));
//        System.out.println(new CommdityService().getComInfoByUrl("https://detail.tmall.com/item.htm?spm=a230r.1.14.6.6c1c36a6NSEN8I&id=41416705409&cm_id=140105335569ed55e27b&abbucket=3&sku_properties=5919063:6536025"));
//
//    }


}
