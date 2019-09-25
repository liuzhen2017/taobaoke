package com.ruoyi.taoke.category.mapper;

import com.ruoyi.taoke.category.domain.Category;
import java.util.List;

/**
 * 分类Mapper接口
 * 
 * @author XRZ
 * @date 2019-09-10
 */
public interface CategoryMapper 
{
    /**
     * 查询分类
     * 
     * @param id 分类ID
     * @return 分类
     */
    public Category selectCategoryById(String id);

    /**
     * 查询分类列表
     * 
     * @param category 分类
     * @return 分类集合
     */
    public List<Category> selectCategoryList(Category category);

    /**
     * 新增分类
     * 
     * @param category 分类
     * @return 结果
     */
    public int insertCategory(Category category);

    /**
     * 修改分类
     * 
     * @param category 分类
     * @return 结果
     */
    public int updateCategory(Category category);

    /**
     * 删除分类
     * 
     * @param id 分类ID
     * @return 结果
     */
    public int deleteCategoryById(String id);

    /**
     * 批量删除分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCategoryByIds(String[] ids);
}
