package com.ruoyi.taoke.commodity.service;

import com.ruoyi.taoke.commodity.domain.Commodity;
import java.util.List;

/**
 * 商品信息Service接口
 * 
 * @author XRZ
 * @date 2019-09-08
 */
public interface ICommodityService {

    /**
     * 查询商品信息
     * 
     * @param id 商品信息ID
     * @return 商品信息
     */
    public Commodity selectCommodityById(String id);

    /**
     * 查询商品信息列表
     * 
     * @param commodity 商品信息
     * @return 商品信息集合
     */
    public List<Commodity> selectCommodityList(Commodity commodity);

    /**
     * 新增商品信息
     * 
     * @param commodity 商品信息
     * @return 结果
     */
    public int insertCommodity(Commodity commodity);

    /**
     * 修改商品信息
     * 
     * @param commodity 商品信息
     * @return 结果
     */
    public int updateCommodity(Commodity commodity);

    /**
     * 批量删除商品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCommodityByIds(String ids);

    /**
     * 删除商品信息信息
     * 
     * @param id 商品信息ID
     * @return 结果
     */
    public int deleteCommodityById(String id);
}
