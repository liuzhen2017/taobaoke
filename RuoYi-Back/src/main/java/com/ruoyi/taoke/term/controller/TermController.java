package com.ruoyi.taoke.term.controller;

import java.util.List;
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
import com.ruoyi.taoke.term.domain.Term;
import com.ruoyi.taoke.term.service.ITermService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 时限管理Controller
 * 
 * @author XRZ
 * @date 2019-09-02
 */
@Controller
@RequestMapping("/taoke/term")
public class TermController extends BaseController
{
    private String prefix = "taoke/term";

    @Autowired
    private ITermService termService;

    @RequiresPermissions("taoke:term:view")
    @GetMapping()
    public String term()
    {
        return prefix + "/term";
    }

    @GetMapping("/user")
    public String user(){
        return prefix + "/user";
    }

    /**
     * 查询时限管理列表
     */
    @RequiresPermissions("taoke:term:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Term term)
    {
        startPage();
        List<Term> list = termService.selectTermList(term);
        return getDataTable(list);
    }

    /**
     * 修改时限管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String uId, ModelMap mmap)
    {
        Term term = termService.selectTermById(Long.valueOf(uId));
        mmap.put("term", term);
        return prefix + "/edit";
    }

    /**
     * 修改保存时限管理
     */
    @RequiresPermissions("taoke:term:edit")
    @Log(title = "时限管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Term term)
    {
        return toAjax(termService.updateTerm(term));
    }


}
