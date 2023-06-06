package com.ruoyi.natsys.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.natsys.mapper.NatsysTestPatientMapper;
import com.ruoyi.natsys.domain.NatsysTestPatient;
import com.ruoyi.natsys.service.INatsysTestPatientService;

/**
 * 检测结果Service业务层处理
 * 
 * @author yuezhi
 * @date 2023-05-09
 */
@Service
public class NatsysTestPatientServiceImpl implements INatsysTestPatientService 
{
    @Autowired
    private NatsysTestPatientMapper natsysTestPatientMapper;

    /**
     * 查询检测结果
     * 
     * @param testId 检测结果主键
     * @return 检测结果
     */
    @Override
    public NatsysTestPatient selectNatsysTestPatientByTestId(Long testId)
    {
        return natsysTestPatientMapper.selectNatsysTestPatientByTestId(testId);
    }

    /**
     * 查询检测结果列表
     * 
     * @param natsysTestPatient 检测结果
     * @return 检测结果
     */
    @Override
    public List<NatsysTestPatient> selectNatsysTestPatientList(NatsysTestPatient natsysTestPatient)
    {
        if(SecurityUtils.getUserId() != null && SecurityUtils.getUserId() != 1){
            natsysTestPatient.setPatientId(SecurityUtils.getUserId());
        }
        return natsysTestPatientMapper.selectNatsysTestPatientList(natsysTestPatient);
    }

    /**
     * 新增检测结果
     * 
     * @param natsysTestPatient 检测结果
     * @return 结果
     */
    @Override
    public int insertNatsysTestPatient(NatsysTestPatient natsysTestPatient)
    {
        natsysTestPatient.setPatientId(SecurityUtils.getUserId());
        natsysTestPatient.setCreateBy(SecurityUtils.getUsername());
        natsysTestPatient.setCreateTime(DateUtils.getNowDate());
        return natsysTestPatientMapper.insertNatsysTestPatient(natsysTestPatient);
    }

    /**
     * 修改检测结果
     * 
     * @param natsysTestPatient 检测结果
     * @return 结果
     */
    @Override
    public int updateNatsysTestPatient(NatsysTestPatient natsysTestPatient)
    {
        natsysTestPatient.setUpdateBy(SecurityUtils.getUsername());
        natsysTestPatient.setUpdateTime(DateUtils.getNowDate());
        return natsysTestPatientMapper.updateNatsysTestPatient(natsysTestPatient);
    }

    /**
     * 批量删除检测结果
     * 
     * @param testIds 需要删除的检测结果主键
     * @return 结果
     */
    @Override
    public int deleteNatsysTestPatientByTestIds(Long[] testIds)
    {
        return natsysTestPatientMapper.deleteNatsysTestPatientByTestIds(testIds);
    }

    /**
     * 删除检测结果信息
     * 
     * @param testId 检测结果主键
     * @return 结果
     */
    @Override
    public int deleteNatsysTestPatientByTestId(Long testId)
    {
        return natsysTestPatientMapper.deleteNatsysTestPatientByTestId(testId);
    }
}
