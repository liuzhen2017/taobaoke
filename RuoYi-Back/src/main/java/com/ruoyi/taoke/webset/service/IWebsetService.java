package com.ruoyi.taoke.webset.service;

import com.ruoyi.taoke.webset.domain.Webset;
import java.util.List;

/**
 * 网页配置Service接口
 * 
 * @author XRZ
 * @date 2019-09-02
 */
public interface IWebsetService 
{
    /**
     * 查询网页配置
     * 
     * @param uId 网页配置ID
     * @return 网页配置
     */
    public Webset selectWebsetById(Long uId);

    /**
     * 查询网页配置列表
     * 
     * @param webset 网页配置
     * @return 网页配置集合
     */
    public List<Webset> selectWebsetList(Webset webset);

    /**
     * 新增网页配置
     * 
     * @param webset 网页配置
     * @return 结果
     */
    public int insertWebset(Webset webset);

    /**
     * 修改网页配置
     * 
     * @param webset 网页配置
     * @return 结果
     */
    public int updateWebset(Webset webset);

    /**
     * 批量删除网页配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWebsetByIds(String ids);

    /**
     * 删除网页配置信息
     * 
     * @param uId 网页配置ID
     * @return 结果
     */
    public int deleteWebsetById(Long uId);
}
