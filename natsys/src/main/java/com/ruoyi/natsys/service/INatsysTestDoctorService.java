package com.ruoyi.natsys.service;

import java.util.List;
import com.ruoyi.natsys.domain.NatsysTestDoctor;

/**
 * 检测记录Service接口
 * 
 * @author yuezhi
 * @date 2023-04-19
 */
public interface INatsysTestDoctorService 
{
    /**
     * 查询检测记录
     * 
     * @param testId 检测记录主键
     * @return 检测记录
     */
    public NatsysTestDoctor selectNatsysTestDoctorByTestId(Long testId);

    /**
     * 查询检测记录列表
     * 
     * @param natsysTestDoctor 检测记录
     * @return 检测记录集合
     */
    public List<NatsysTestDoctor> selectNatsysTestDoctorList(NatsysTestDoctor natsysTestDoctor);

    /**
     * 新增检测记录
     * 
     * @param natsysTestDoctor 检测记录
     * @return 结果
     */
    public int insertNatsysTestDoctor(NatsysTestDoctor natsysTestDoctor);

    /**
     * 修改检测记录
     * 
     * @param natsysTestDoctor 检测记录
     * @return 结果
     */
    public int updateNatsysTestDoctor(NatsysTestDoctor natsysTestDoctor);

    /**
     * 批量删除检测记录
     * 
     * @param testIds 需要删除的检测记录主键集合
     * @return 结果
     */
    public int deleteNatsysTestDoctorByTestIds(Long[] testIds);

    /**
     * 删除检测记录信息
     * 
     * @param testId 检测记录主键
     * @return 结果
     */
    public int deleteNatsysTestDoctorByTestId(Long testId);
}
