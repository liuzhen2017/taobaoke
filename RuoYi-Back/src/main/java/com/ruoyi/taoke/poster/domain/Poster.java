package com.ruoyi.taoke.poster.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 海报配置对象 poster
 * 
 * @author XRZ
 * @date 2019-09-02
 */
@Data
public class Poster implements Serializable {

    private String id;

    /** 用户id */
    private String uId;

    /** 海报标题 */
    private String title;

    /** 展示图片 */
    private String imgUrl;

    /** 海报类型(0=轮播图/1=主播精选/2=其他推荐) */
    private Integer type;

    /** 创建时间 */
    private String createdDate;

    /** 最后修改时间 */
    private String updatedDate;

}
