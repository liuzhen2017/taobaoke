package com.ruoyi.taoke.category.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.io.Serializable;

/**
 * 分类对象 category
 * 
 * @author XRZ
 * @date 2019-09-10
 */
@Data
public class Category implements Serializable {

    /** 分类ID */
    private String id;

    /** 分类名字 */
    private String categoryName;

    /** 分类备注 */
    private String categoryRemarks;

    /** 用户ID */
    private String userId;

    /** 是否启用（1=启用，0=禁用） 默认为1 */
    private Integer enable;
}
