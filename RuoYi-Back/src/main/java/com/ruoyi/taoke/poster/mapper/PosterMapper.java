package com.ruoyi.taoke.poster.mapper;

import com.ruoyi.taoke.poster.domain.Poster;
import java.util.List;

/**
 * 海报配置Mapper接口
 * 
 * @author XRZ
 * @date 2019-09-02
 */
public interface PosterMapper 
{
    /**
     * 查询海报配置
     * 
     * @param uId 海报配置ID
     * @return 海报配置
     */
    public Poster selectPosterById(Long uId);

    /**
     * 查询海报配置列表
     * 
     * @param poster 海报配置
     * @return 海报配置集合
     */
    public List<Poster> selectPosterList(Poster poster);

    /**
     * 新增海报配置
     * 
     * @param poster 海报配置
     * @return 结果
     */
    public int insertPoster(Poster poster);

    /**
     * 修改海报配置
     * 
     * @param poster 海报配置
     * @return 结果
     */
    public int updatePoster(Poster poster);

    /**
     * 删除海报配置
     * 
     * @param uId 海报配置ID
     * @return 结果
     */
    public int deletePosterById(Long uId);

    /**
     * 批量删除海报配置
     * 
     * @param uIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePosterByIds(String[] uIds);
}
