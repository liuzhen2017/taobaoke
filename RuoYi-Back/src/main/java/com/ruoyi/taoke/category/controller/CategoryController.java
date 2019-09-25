package com.ruoyi.taoke.category.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.taoke.category.domain.Category;
import com.ruoyi.taoke.category.service.ICategoryService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 分类Controller
 * 
 * @author XRZ
 * @date 2019-09-10
 */
@Controller
@RequestMapping("/taoke/category")
public class CategoryController extends BaseController
{
    private String prefix = "taoke/category";

    @Autowired
    private ICategoryService categoryService;

    @RequiresPermissions("taoke:category:view")
    @GetMapping()
    public String category()
    {
        return prefix + "/category";
    }

    /**
     * 查询分类列表
     */
    @RequiresPermissions("taoke:category:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Category category) {
        if (ShiroUtils.getUserId() != 1) {
            category.setUserId(String.valueOf(ShiroUtils.getUserId()));
        }
        startPage();
        List<Category> list = categoryService.selectCategoryList(category);
        return getDataTable(list);
    }

    /**
     * 获取当前用户的分类列表
     * @return
     */
    @ResponseBody
    @GetMapping("/getList")
    public List<Category> getList(){
        Category category = new Category();
        category.setUserId(String.valueOf(ShiroUtils.getUserId()));
        category.setEnable(1);
        return categoryService.selectCategoryList(category);
    }

    /**
     * 导出分类列表
     */
    @RequiresPermissions("taoke:category:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Category category) {
        List<Category> list = categoryService.selectCategoryList(category);
        ExcelUtil<Category> util = new ExcelUtil<Category>(Category.class);
        return util.exportExcel(list, "category");
    }

    /**
     * 新增分类
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存分类
     */
    @RequiresPermissions("taoke:category:add")
    @Log(title = "分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Category category) {
        category.setUserId(String.valueOf(ShiroUtils.getUserId()));
        return toAjax(categoryService.insertCategory(category));
    }

    /**
     * 修改分类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        Category category = categoryService.selectCategoryById(id);
        mmap.put("category", category);
        return prefix + "/edit";
    }

    /**
     * 修改保存分类
     */
    @RequiresPermissions("taoke:category:edit")
    @Log(title = "分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Category category)
    {
        return toAjax(categoryService.updateCategory(category));
    }

    /**
     * 删除分类
     */
    @RequiresPermissions("taoke:category:remove")
    @Log(title = "分类", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(categoryService.deleteCategoryByIds(ids));
    }

    /**
     * 启用分类
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/enable/{id}")
    public AjaxResult enable(@PathVariable("id") String id){
        Category category = new Category();
        category.setId(id);
        category.setEnable(1);
        return toAjax(categoryService.updateCategory(category));
    }
}
