package com.ruoyi.taoke.term.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 时限管理对象 term
 * 
 * @author XRZ
 * @date 2019-09-02
 */
@Data
public class Term implements Serializable {

    /** 用户id */
    private Long uId;

    /** 可用时间，单位：毫秒（默认7天） */
    private String availableTime;

    /** 创建时间 */
    private String createdDate;

    /** 最后修改时间 */
    private String updatedDate;


}
