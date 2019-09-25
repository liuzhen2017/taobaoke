package com.ruoyi.taoke.api.dto.comm;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.taoke.commodity.domain.Commodity;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author XRZ
 * @date 2019/9/9
 * @Description : 商品信息DTO
 */
@Data
public class ComDto implements Serializable {

    /**
     * 简版商品信息
     */
    private Commodity commodity;

    /**
     * 所有商品信息
     */
    private N_tbk_item item;


}
