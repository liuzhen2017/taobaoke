package com.ruoyi.taoke.term.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.taoke.term.mapper.TermMapper;
import com.ruoyi.taoke.term.domain.Term;
import com.ruoyi.taoke.term.service.ITermService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 时限管理Service业务层处理
 * 
 * @author XRZ
 * @date 2019-09-02
 */
@Service
public class TermServiceImpl implements ITermService 
{
    @Autowired
    private TermMapper termMapper;

    /**
     * 查询时限管理
     * 
     * @param uId 时限管理ID
     * @return 时限管理
     */
    @Override
    public Term selectTermById(Long uId)
    {
        return termMapper.selectTermById(uId);
    }

    /**
     * 查询时限管理列表
     * 
     * @param term 时限管理
     * @return 时限管理
     */
    @Override
    public List<Term> selectTermList(Term term)
    {
        return termMapper.selectTermList(term);
    }

    /**
     * 新增时限管理
     * 
     * @param term 时限管理
     * @return 结果
     */
    @Override
    public int insertTerm(Term term)
    {
        return termMapper.insertTerm(term);
    }

    /**
     * 修改时限管理
     * 
     * @param term 时限管理
     * @return 结果
     */
    @Override
    public int updateTerm(Term term)
    {
        return termMapper.updateTerm(term);
    }

    /**
     * 删除时限管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTermByIds(String ids)
    {
        return termMapper.deleteTermByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除时限管理信息
     * 
     * @param uId 时限管理ID
     * @return 结果
     */
    public int deleteTermById(Long uId)
    {
        return termMapper.deleteTermById(uId);
    }
}
