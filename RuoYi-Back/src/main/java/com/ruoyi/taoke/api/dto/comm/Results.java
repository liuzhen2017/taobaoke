
package com.ruoyi.taoke.api.dto.comm;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author XRZ
 * @date 2019/9/8
 * @Description :
 */
@Data
public class Results implements Serializable {

    private List<N_tbk_item> n_tbk_item;

}