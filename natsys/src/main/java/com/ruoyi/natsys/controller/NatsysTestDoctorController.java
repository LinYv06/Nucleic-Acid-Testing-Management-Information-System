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
import com.ruoyi.natsys.domain.NatsysTestDoctor;
import com.ruoyi.natsys.service.INatsysTestDoctorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 检测记录Controller
 * 
 * @author yuezhi
 * @date 2023-04-19
 */
@RestController
@RequestMapping("/natsys/testDoctor")
public class NatsysTestDoctorController extends BaseController
{
    @Autowired
    private INatsysTestDoctorService natsysTestDoctorService;

    /**
     * 查询检测记录列表
     */
    @PreAuthorize("@ss.hasPermi('natsys:testDoctor:list')")
    @GetMapping("/list")
    public TableDataInfo list(NatsysTestDoctor natsysTestDoctor)
    {
        startPage();
        List<NatsysTestDoctor> list = natsysTestDoctorService.selectNatsysTestDoctorList(natsysTestDoctor);
        return getDataTable(list);
    }

    /**
     * 导出检测记录列表
     */
    @PreAuthorize("@ss.hasPermi('natsys:testDoctor:export')")
    @Log(title = "检测记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NatsysTestDoctor natsysTestDoctor)
    {
        List<NatsysTestDoctor> list = natsysTestDoctorService.selectNatsysTestDoctorList(natsysTestDoctor);
        ExcelUtil<NatsysTestDoctor> util = new ExcelUtil<NatsysTestDoctor>(NatsysTestDoctor.class);
        util.exportExcel(response, list, "检测记录数据");
    }

    /**
     * 获取检测记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('natsys:testDoctor:query')")
    @GetMapping(value = "/{testId}")
    public AjaxResult getInfo(@PathVariable("testId") Long testId)
    {
        return success(natsysTestDoctorService.selectNatsysTestDoctorByTestId(testId));
    }

    /**
     * 新增检测记录
     */
    @PreAuthorize("@ss.hasPermi('natsys:testDoctor:add')")
    @Log(title = "检测记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NatsysTestDoctor natsysTestDoctor)
    {
        return toAjax(natsysTestDoctorService.insertNatsysTestDoctor(natsysTestDoctor));
    }

    /**
     * 修改检测记录
     */
    @PreAuthorize("@ss.hasPermi('natsys:testDoctor:edit')")
    @Log(title = "检测记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NatsysTestDoctor natsysTestDoctor)
    {
        return toAjax(natsysTestDoctorService.updateNatsysTestDoctor(natsysTestDoctor));
    }

    /**
     * 删除检测记录
     */
    @PreAuthorize("@ss.hasPermi('natsys:testDoctor:remove')")
    @Log(title = "检测记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{testIds}")
    public AjaxResult remove(@PathVariable Long[] testIds)
    {
        return toAjax(natsysTestDoctorService.deleteNatsysTestDoctorByTestIds(testIds));
    }
}
