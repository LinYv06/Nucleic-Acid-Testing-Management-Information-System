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
import com.ruoyi.natsys.domain.NatsysAnalysis;
import com.ruoyi.natsys.service.INatsysAnalysisService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 管理数据Controller
 * 
 * @author yuezhi
 * @date 2023-05-14
 */
@RestController
@RequestMapping("/natsys/analysis")
public class NatsysAnalysisController extends BaseController
{
    @Autowired
    private INatsysAnalysisService natsysAnalysisService;

    /**
     * 查询管理数据列表
     */
    @PreAuthorize("@ss.hasPermi('natsys:analysis:list')")
    @GetMapping("/list")
    public TableDataInfo list(NatsysAnalysis natsysAnalysis)
    {
        startPage();
        List<NatsysAnalysis> list = natsysAnalysisService.selectNatsysAnalysisList(natsysAnalysis);
        return getDataTable(list);
    }

    /**
     * 导出管理数据列表
     */
    @PreAuthorize("@ss.hasPermi('natsys:analysis:export')")
    @Log(title = "管理数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NatsysAnalysis natsysAnalysis)
    {
        List<NatsysAnalysis> list = natsysAnalysisService.selectNatsysAnalysisList(natsysAnalysis);
        ExcelUtil<NatsysAnalysis> util = new ExcelUtil<NatsysAnalysis>(NatsysAnalysis.class);
        util.exportExcel(response, list, "管理数据数据");
    }

    /**
     * 获取管理数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('natsys:analysis:query')")
    @GetMapping(value = "/{analysisId}")
    public AjaxResult getInfo(@PathVariable("analysisId") Long analysisId)
    {
        return success(natsysAnalysisService.selectNatsysAnalysisByAnalysisId(analysisId));
    }

    /**
     * 新增管理数据
     */
    @PreAuthorize("@ss.hasPermi('natsys:analysis:add')")
    @Log(title = "管理数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NatsysAnalysis natsysAnalysis)
    {
        return toAjax(natsysAnalysisService.insertNatsysAnalysis(natsysAnalysis));
    }

    /**
     * 修改管理数据
     */
    @PreAuthorize("@ss.hasPermi('natsys:analysis:edit')")
    @Log(title = "管理数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NatsysAnalysis natsysAnalysis)
    {
        return toAjax(natsysAnalysisService.updateNatsysAnalysis(natsysAnalysis));
    }

    /**
     * 删除管理数据
     */
    @PreAuthorize("@ss.hasPermi('natsys:analysis:remove')")
    @Log(title = "管理数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{analysisIds}")
    public AjaxResult remove(@PathVariable Long[] analysisIds)
    {
        return toAjax(natsysAnalysisService.deleteNatsysAnalysisByAnalysisIds(analysisIds));
    }
}
