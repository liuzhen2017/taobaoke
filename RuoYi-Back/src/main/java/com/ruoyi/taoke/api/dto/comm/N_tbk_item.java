/**
  * Copyright 2019 bejson.com 
  */
package com.ruoyi.taoke.api.dto.comm;

import lombok.Data;

import java.io.Serializable;

/**
 * @author XRZ
 * @date 2019/9/8
 * @Description :
 */
@Data
public class N_tbk_item implements Serializable {

    /**
     * 叶子类目名称
     */
    private String cat_leaf_name;
    /**
     * 一级类目名称
     */
    private String cat_name;
    /**
     * 商品链接
     */
    private String item_url;
    /**
     * 商品库类型，支持多库类型输出，以英文逗号分隔“,”分隔，1:营销商品主推库，2. 内容商品库，如果值为空则不属于1，2这两种商品类型
     */
    private String material_lib_type;
    /**
     * 店铺名称
     */
    private String nick;
    /**
     * 商品ID
     */
    private long num_iid;
    /**
     * 商品主图
     */
    private String pict_url;
    /**
     * 商品所在地
     */
    private String provcity;
    /**
     * 商品一口价格
     */
    private String reserve_price;
    /**
     * 卖家id
     */
    private long seller_id;
    /**
     * 商品小图列表
     */
    private Small_images small_images;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 卖家类型，0表示集市，1表示商城
     */
    private int user_type;
    /**
     * 30天销量
     */
    private int volume;
    /**
     * 商品折扣价格
     */
    private String zk_final_price;

}