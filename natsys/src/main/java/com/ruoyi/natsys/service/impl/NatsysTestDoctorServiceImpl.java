package com.ruoyi.natsys.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.natsys.mapper.NatsysTestDoctorMapper;
import com.ruoyi.natsys.domain.NatsysTestDoctor;
import com.ruoyi.natsys.service.INatsysTestDoctorService;

/**
 * 检测记录Service业务层处理
 * 
 * @author yuezhi
 * @date 2023-04-19
 */
@Service
public class NatsysTestDoctorServiceImpl implements INatsysTestDoctorService 
{
    @Autowired
    private NatsysTestDoctorMapper natsysTestDoctorMapper;

    /**
     * 查询检测记录
     * 
     * @param testId 检测记录主键
     * @return 检测记录
     */
    @Override
    public NatsysTestDoctor selectNatsysTestDoctorByTestId(Long testId)
    {
        return natsysTestDoctorMapper.selectNatsysTestDoctorByTestId(testId);
    }

    /**
     * 查询检测记录列表
     * 
     * @param natsysTestDoctor 检测记录
     * @return 检测记录
     */
    @Override
    public List<NatsysTestDoctor> selectNatsysTestDoctorList(NatsysTestDoctor natsysTestDoctor)
    {
        return natsysTestDoctorMapper.selectNatsysTestDoctorList(natsysTestDoctor);
    }

    /**
     * 新增检测记录
     * 
     * @param natsysTestDoctor 检测记录
     * @return 结果
     */
    @Override
    public int insertNatsysTestDoctor(NatsysTestDoctor natsysTestDoctor)
    {
        natsysTestDoctor.setCreateBy(SecurityUtils.getUsername());
        natsysTestDoctor.setCreateTime(DateUtils.getNowDate());
        return natsysTestDoctorMapper.insertNatsysTestDoctor(natsysTestDoctor);
    }

    /**
     * 修改检测记录
     * 
     * @param natsysTestDoctor 检测记录
     * @return 结果
     */
    @Override
    public int updateNatsysTestDoctor(NatsysTestDoctor natsysTestDoctor)
    {
        natsysTestDoctor.setAuditorId(SecurityUtils.getUserId());
        natsysTestDoctor.setAuditTime(DateUtils.getNowDate());
        natsysTestDoctor.setUpdateBy(SecurityUtils.getUsername());
        natsysTestDoctor.setUpdateTime(DateUtils.getNowDate());
        return natsysTestDoctorMapper.updateNatsysTestDoctor(natsysTestDoctor);
    }

    /**
     * 批量删除检测记录
     * 
     * @param testIds 需要删除的检测记录主键
     * @return 结果
     */
    @Override
    public int deleteNatsysTestDoctorByTestIds(Long[] testIds)
    {
        return natsysTestDoctorMapper.deleteNatsysTestDoctorByTestIds(testIds);
    }

    /**
     * 删除检测记录信息
     * 
     * @param testId 检测记录主键
     * @return 结果
     */
    @Override
    public int deleteNatsysTestDoctorByTestId(Long testId)
    {
        return natsysTestDoctorMapper.deleteNatsysTestDoctorByTestId(testId);
    }
}
