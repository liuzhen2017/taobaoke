package com.ruoyi.taoke.api.dto.error;

import lombok.Data;

/**
 * @author XRZ
 * @date 2019/9/8
 * @Description :
 */
@Data
public class error_response {

    private String code;
    private String msg;
    private String sub_code;
    private String sub_msg;

}
