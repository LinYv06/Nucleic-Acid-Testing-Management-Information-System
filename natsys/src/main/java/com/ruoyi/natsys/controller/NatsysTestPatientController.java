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
import com.ruoyi.natsys.domain.NatsysTestPatient;
import com.ruoyi.natsys.service.INatsysTestPatientService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 检测结果Controller
 * 
 * @author yuezhi
 * @date 2023-05-09
 */
@RestController
@RequestMapping("/natsys/testPatient")
public class NatsysTestPatientController extends BaseController
{
    @Autowired
    private INatsysTestPatientService natsysTestPatientService;

    /**
     * 查询检测结果列表
     */
    @PreAuthorize("@ss.hasPermi('natsys:testPatient:list')")
    @GetMapping("/list")
    public TableDataInfo list(NatsysTestPatient natsysTestPatient)
    {
        startPage();
        List<NatsysTestPatient> list = natsysTestPatientService.selectNatsysTestPatientList(natsysTestPatient);
        return getDataTable(list);
    }

    /**
     * 导出检测结果列表
     */
    @PreAuthorize("@ss.hasPermi('natsys:testPatient:export')")
    @Log(title = "检测结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NatsysTestPatient natsysTestPatient)
    {
        List<NatsysTestPatient> list = natsysTestPatientService.selectNatsysTestPatientList(natsysTestPatient);
        ExcelUtil<NatsysTestPatient> util = new ExcelUtil<NatsysTestPatient>(NatsysTestPatient.class);
        util.exportExcel(response, list, "检测结果数据");
    }

    /**
     * 获取检测结果详细信息
     */
    @PreAuthorize("@ss.hasPermi('natsys:testPatient:query')")
    @GetMapping(value = "/{testId}")
    public AjaxResult getInfo(@PathVariable("testId") Long testId)
    {
        return success(natsysTestPatientService.selectNatsysTestPatientByTestId(testId));
    }

    /**
     * 新增检测结果
     */
    @PreAuthorize("@ss.hasPermi('natsys:testPatient:add')")
    @Log(title = "检测结果", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NatsysTestPatient natsysTestPatient)
    {
        return toAjax(natsysTestPatientService.insertNatsysTestPatient(natsysTestPatient));
    }

    /**
     * 修改检测结果
     */
    @PreAuthorize("@ss.hasPermi('natsys:testPatient:edit')")
    @Log(title = "检测结果", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NatsysTestPatient natsysTestPatient)
    {
        return toAjax(natsysTestPatientService.updateNatsysTestPatient(natsysTestPatient));
    }

    /**
     * 删除检测结果
     */
    @PreAuthorize("@ss.hasPermi('natsys:testPatient:remove')")
    @Log(title = "检测结果", businessType = BusinessType.DELETE)
	@DeleteMapping("/{testIds}")
    public AjaxResult remove(@PathVariable Long[] testIds)
    {
        return toAjax(natsysTestPatientService.deleteNatsysTestPatientByTestIds(testIds));
    }
}
