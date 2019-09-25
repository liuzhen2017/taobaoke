package com.ruoyi.taoke.poster.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.taoke.poster.mapper.PosterMapper;
import com.ruoyi.taoke.poster.domain.Poster;
import com.ruoyi.taoke.poster.service.IPosterService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 海报配置Service业务层处理
 * 
 * @author XRZ
 * @date 2019-09-02
 */
@Service
public class PosterServiceImpl implements IPosterService 
{
    @Autowired
    private PosterMapper posterMapper;

    /**
     * 查询海报配置
     * 
     * @param uId 海报配置ID
     * @return 海报配置
     */
    @Override
    public Poster selectPosterById(Long uId)
    {
        return posterMapper.selectPosterById(uId);
    }

    /**
     * 查询海报配置列表
     * 
     * @param poster 海报配置
     * @return 海报配置
     */
    @Override
    public List<Poster> selectPosterList(Poster poster)
    {
        return posterMapper.selectPosterList(poster);
    }

    /**
     * 新增海报配置
     * 
     * @param poster 海报配置
     * @return 结果
     */
    @Override
    public int insertPoster(Poster poster)
    {
        return posterMapper.insertPoster(poster);
    }

    /**
     * 修改海报配置
     * 
     * @param poster 海报配置
     * @return 结果
     */
    @Override
    public int updatePoster(Poster poster)
    {
        return posterMapper.updatePoster(poster);
    }

    /**
     * 删除海报配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePosterByIds(String ids)
    {
        return posterMapper.deletePosterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除海报配置信息
     * 
     * @param uId 海报配置ID
     * @return 结果
     */
    public int deletePosterById(Long uId)
    {
        return posterMapper.deletePosterById(uId);
    }
}
