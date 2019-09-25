package com.ruoyi.taoke.commodity.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.taoke.commodity.mapper.CommodityMapper;
import com.ruoyi.taoke.commodity.domain.Commodity;
import com.ruoyi.taoke.commodity.service.ICommodityService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 商品信息Service业务层处理
 * 
 * @author XRZ
 * @date 2019-09-08
 */
@Service
public class CommodityServiceImpl implements ICommodityService 
{
    @Autowired
    private CommodityMapper commodityMapper;

    /**
     * 查询商品信息
     * 
     * @param id 商品信息ID
     * @return 商品信息
     */
    @Override
    public Commodity selectCommodityById(String id)
    {
        return commodityMapper.selectCommodityById(id);
    }

    /**
     * 查询商品信息列表
     * 
     * @param commodity 商品信息
     * @return 商品信息
     */
    @Override
    public List<Commodity> selectCommodityList(Commodity commodity)
    {
        return commodityMapper.selectCommodityList(commodity);
    }

    /**
     * 新增商品信息
     * 
     * @param commodity 商品信息
     * @return 结果
     */
    @Override
    public int insertCommodity(Commodity commodity)
    {
        return commodityMapper.insertCommodity(commodity);
    }

    /**
     * 修改商品信息
     * 
     * @param commodity 商品信息
     * @return 结果
     */
    @Override
    public int updateCommodity(Commodity commodity)
    {
        return commodityMapper.updateCommodity(commodity);
    }

    /**
     * 删除商品信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCommodityByIds(String ids)
    {
        return commodityMapper.deleteCommodityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品信息信息
     * 
     * @param id 商品信息ID
     * @return 结果
     */
    public int deleteCommodityById(String id)
    {
        return commodityMapper.deleteCommodityById(id);
    }
}
