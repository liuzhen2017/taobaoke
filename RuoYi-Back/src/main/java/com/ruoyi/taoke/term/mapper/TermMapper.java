package com.ruoyi.taoke.term.mapper;

import com.ruoyi.taoke.term.domain.Term;
import java.util.List;

/**
 * 时限管理Mapper接口
 * 
 * @author XRZ
 * @date 2019-09-02
 */
public interface TermMapper 
{
    /**
     * 查询时限管理
     * 
     * @param uId 时限管理ID
     * @return 时限管理
     */
    public Term selectTermById(Long uId);

    /**
     * 查询时限管理列表
     * 
     * @param term 时限管理
     * @return 时限管理集合
     */
    public List<Term> selectTermList(Term term);

    /**
     * 新增时限管理
     * 
     * @param term 时限管理
     * @return 结果
     */
    public int insertTerm(Term term);

    /**
     * 修改时限管理
     * 
     * @param term 时限管理
     * @return 结果
     */
    public int updateTerm(Term term);

    /**
     * 删除时限管理
     * 
     * @param uId 时限管理ID
     * @return 结果
     */
    public int deleteTermById(Long uId);

    /**
     * 批量删除时限管理
     * 
     * @param uIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTermByIds(String[] uIds);
}
