package com.ruoyi.taoke.commodity.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.springframework.web.jsf.FacesContextUtils;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品信息对象 commodity
 * 
 * @author XRZ
 * @date 2019-09-08
 */
@Data
public class Commodity implements Serializable {

    /** ID */
    private String id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String uId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private String cId;

    /** 创建时间 */
    @Excel(name = "创建时间")
    private String createdDate;

    /** 最后修改时间 */
    @Excel(name = "最后修改时间")
    private String updatedDate;

    /** 分类ID */
    @Excel(name = "分类ID")
    private String categoryId;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String categoryName;

    /** 优惠券领取URL */
    @Excel(name = "优惠券领取URL")
    private String couponUrl;

    /** 优惠券价格 */
    @Excel(name = "优惠券价格")
    private BigDecimal couponPrice;

    /** 标签 */
    @Excel(name = "标签")
    private String label;

    /**
     * 商品名字
     */
    private String comName;

    /**
     * 商品主图
     */
    private String comImg;

    /**
     * 商品价格
     */
    private String comPrice;

}
