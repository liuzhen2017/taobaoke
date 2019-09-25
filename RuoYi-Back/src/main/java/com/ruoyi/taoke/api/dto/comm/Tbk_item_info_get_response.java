package com.ruoyi.taoke.api.dto.comm;

import lombok.Data;

import java.io.Serializable;

/**
 * @author XRZ
 * @date 2019/9/8
 * @Description :
 */
@Data
public class Tbk_item_info_get_response implements Serializable {

    /**
     * 淘宝客商品
     */
    private Results results;
    private String request_id;

}