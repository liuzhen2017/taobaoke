package com.ruoyi.taoke.webset.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 网页配置对象 webset
 * 
 * @author XRZ
 * @date 2019-09-02
 */
@Data
public class Webset implements Serializable {

    /** 用户id */
    private String uId;

    /** 网页标题 */
    private String title;

    /** 视频封面 */
    private String videoImg;

    /** 视频地址 */
    private String videoUrl;

    /** 创建时间 */
    private String createdDate;

    /** 最后修改时间 */
    private String updatedDate;


}
