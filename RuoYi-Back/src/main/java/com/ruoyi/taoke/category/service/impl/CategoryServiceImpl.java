package com.ruoyi.taoke.category.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.taoke.category.mapper.CategoryMapper;
import com.ruoyi.taoke.category.domain.Category;
import com.ruoyi.taoke.category.service.ICategoryService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 分类Service业务层处理
 * 
 * @author XRZ
 * @date 2019-09-10
 */
@Service
public class CategoryServiceImpl implements ICategoryService 
{
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询分类
     * 
     * @param id 分类ID
     * @return 分类
     */
    @Override
    public Category selectCategoryById(String id)
    {
        return categoryMapper.selectCategoryById(id);
    }

    /**
     * 查询分类列表
     * 
     * @param category 分类
     * @return 分类
     */
    @Override
    public List<Category> selectCategoryList(Category category)
    {
        return categoryMapper.selectCategoryList(category);
    }

    /**
     * 新增分类
     * 
     * @param category 分类
     * @return 结果
     */
    @Override
    public int insertCategory(Category category)
    {
        return categoryMapper.insertCategory(category);
    }

    /**
     * 修改分类
     * 
     * @param category 分类
     * @return 结果
     */
    @Override
    public int updateCategory(Category category)
    {
        return categoryMapper.updateCategory(category);
    }

    /**
     * 删除分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCategoryByIds(String ids)
    {
        return categoryMapper.deleteCategoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除分类信息
     * 
     * @param id 分类ID
     * @return 结果
     */
    public int deleteCategoryById(String id)
    {
        return categoryMapper.deleteCategoryById(id);
    }
}
