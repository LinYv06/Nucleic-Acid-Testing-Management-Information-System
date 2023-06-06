package com.ruoyi.natsys.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.natsys.domain.NatsysTestScheme;
import com.ruoyi.natsys.service.INatsysTestSchemeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 检测方案Controller
 * 
 * @author yuezhi
 * @date 2023-04-17
 */
@RestController
@RequestMapping("/natsys/scheme")
public class NatsysTestSchemeController extends BaseController
{
    @Autowired
    private INatsysTestSchemeService natsysTestSchemeService;

    /**
     * 查询检测方案列表
     */
    @PreAuthorize("@ss.hasPermi('natsys:scheme:list')")
    @GetMapping("/list")
    public TableDataInfo list(NatsysTestScheme natsysTestScheme)
    {
        startPage();
        List<NatsysTestScheme> list = natsysTestSchemeService.selectNatsysTestSchemeList(natsysTestScheme);
        return getDataTable(list);
    }

    /**
     * 导出检测方案列表
     */
    @PreAuthorize("@ss.hasPermi('natsys:scheme:export')")
    @Log(title = "检测方案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NatsysTestScheme natsysTestScheme)
    {
        List<NatsysTestScheme> list = natsysTestSchemeService.selectNatsysTestSchemeList(natsysTestScheme);
        ExcelUtil<NatsysTestScheme> util = new ExcelUtil<NatsysTestScheme>(NatsysTestScheme.class);
        util.exportExcel(response, list, "检测方案数据");
    }

    /**
     * 获取检测方案详细信息
     */
    @PreAuthorize("@ss.hasPermi('natsys:scheme:query')")
    @GetMapping(value = "/{schemeId}")
    public AjaxResult getInfo(@PathVariable("schemeId") Long schemeId)
    {
        return success(natsysTestSchemeService.selectNatsysTestSchemeBySchemeId(schemeId));
    }

    /**
     * 新增检测方案
     */
    @PreAuthorize("@ss.hasPermi('natsys:scheme:add')")
    @Log(title = "检测方案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NatsysTestScheme natsysTestScheme)
    {
        return toAjax(natsysTestSchemeService.insertNatsysTestScheme(natsysTestScheme));
    }

    /**
     * 修改检测方案
     */
    @PreAuthorize("@ss.hasPermi('natsys:scheme:edit')")
    @Log(title = "检测方案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NatsysTestScheme natsysTestScheme)
    {
        return toAjax(natsysTestSchemeService.updateNatsysTestScheme(natsysTestScheme));
    }

    /**
     * 删除检测方案
     */
    @PreAuthorize("@ss.hasPermi('natsys:scheme:remove')")
    @Log(title = "检测方案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{schemeIds}")
    public AjaxResult remove(@PathVariable Long[] schemeIds)
    {
        return toAjax(natsysTestSchemeService.deleteNatsysTestSchemeBySchemeIds(schemeIds));
    }
}
