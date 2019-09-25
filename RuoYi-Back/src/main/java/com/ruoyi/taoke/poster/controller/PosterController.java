package com.ruoyi.taoke.poster.controller;

import java.util.List;

import com.ruoyi.common.utils.security.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.taoke.poster.domain.Poster;
import com.ruoyi.taoke.poster.service.IPosterService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 海报配置Controller
 * 
 * @author XRZ
 * @date 2019-09-02
 */
@Controller
@RequestMapping("/taoke/poster")
public class PosterController extends BaseController
{
    private String prefix = "taoke/poster";

    @Autowired
    private IPosterService posterService;

    @RequiresPermissions("taoke:poster:view")
    @GetMapping()
    public String poster()
    {
        return prefix + "/poster";
    }

    /**
     * 查询海报配置列表
     */
    @RequiresPermissions("taoke:poster:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Poster poster){
        if (ShiroUtils.getUserId() != 1) {
            poster.setUId(String.valueOf(ShiroUtils.getUserId()));
        }
        startPage();
        List<Poster> list = posterService.selectPosterList(poster);
        return getDataTable(list);
    }

    /**
     * 新增海报配置
     */
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("id",ShiroUtils.getUserId());
        return prefix + "/add";
    }

    /**
     * 新增保存海报配置
     */
    @RequiresPermissions("taoke:poster:add")
    @Log(title = "海报配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Poster poster)
    {
        poster.setUId(String.valueOf(ShiroUtils.getUserId()));
        return toAjax(posterService.insertPoster(poster));
    }


    /**
     * 删除海报配置
     */
    @RequiresPermissions("taoke:poster:remove")
    @Log(title = "海报配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(posterService.deletePosterByIds(ids));
    }
}
