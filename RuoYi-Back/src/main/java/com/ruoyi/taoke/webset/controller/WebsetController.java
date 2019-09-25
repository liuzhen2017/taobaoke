package com.ruoyi.taoke.webset.controller;

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
import com.ruoyi.taoke.webset.domain.Webset;
import com.ruoyi.taoke.webset.service.IWebsetService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 网页配置Controller
 * 
 * @author XRZ
 * @date 2019-09-02
 */
@Controller
@RequestMapping("/taoke/webset")
public class WebsetController extends BaseController
{
    private String prefix = "taoke/webset";

    @Autowired
    private IWebsetService websetService;

    @RequiresPermissions("taoke:webset:view")
    @GetMapping()
    public String webset()
    {
        return prefix + "/webset";
    }

    /**
     * 查询网页配置列表
     */
    @RequiresPermissions("taoke:webset:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Webset webset)
    {
        if (ShiroUtils.getUserId() != 1) {
            webset.setUId(String.valueOf(ShiroUtils.getUserId()));
        }
        startPage();
        List<Webset> list = websetService.selectWebsetList(webset);
        return getDataTable(list);
    }

    /**
     * 修改网页配置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        Webset webset = websetService.selectWebsetById(Long.valueOf(id));
        mmap.put("webset", webset);
        return "taoke/webset/edit";
    }

    /**
     * 修改保存网页配置
     */
    @RequiresPermissions("taoke:webset:edit")
    @Log(title = "网页配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Webset webset)
    {
        return toAjax(websetService.updateWebset(webset));
    }


}
