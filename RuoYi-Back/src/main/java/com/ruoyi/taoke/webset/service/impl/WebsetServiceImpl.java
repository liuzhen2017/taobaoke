package com.ruoyi.taoke.webset.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.taoke.webset.mapper.WebsetMapper;
import com.ruoyi.taoke.webset.domain.Webset;
import com.ruoyi.taoke.webset.service.IWebsetService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 网页配置Service业务层处理
 * 
 * @author XRZ
 * @date 2019-09-02
 */
@Service
public class WebsetServiceImpl implements IWebsetService 
{
    @Autowired
    private WebsetMapper websetMapper;

    /**
     * 查询网页配置
     * 
     * @param uId 网页配置ID
     * @return 网页配置
     */
    @Override
    public Webset selectWebsetById(Long uId)
    {
        return websetMapper.selectWebsetById(uId);
    }

    /**
     * 查询网页配置列表
     * 
     * @param webset 网页配置
     * @return 网页配置
     */
    @Override
    public List<Webset> selectWebsetList(Webset webset)
    {
        return websetMapper.selectWebsetList(webset);
    }

    /**
     * 新增网页配置
     * 
     * @param webset 网页配置
     * @return 结果
     */
    @Override
    public int insertWebset(Webset webset)
    {
        return websetMapper.insertWebset(webset);
    }

    /**
     * 修改网页配置
     * 
     * @param webset 网页配置
     * @return 结果
     */
    @Override
    public int updateWebset(Webset webset)
    {
        return websetMapper.updateWebset(webset);
    }

    /**
     * 删除网页配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWebsetByIds(String ids)
    {
        return websetMapper.deleteWebsetByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除网页配置信息
     * 
     * @param uId 网页配置ID
     * @return 结果
     */
    public int deleteWebsetById(Long uId)
    {
        return websetMapper.deleteWebsetById(uId);
    }
}
