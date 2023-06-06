package com.ruoyi.natsys.service;

import java.util.List;
import com.ruoyi.natsys.domain.NatsysTestPatient;

/**
 * 检测结果Service接口
 * 
 * @author yuezhi
 * @date 2023-05-09
 */
public interface INatsysTestPatientService 
{
    /**
     * 查询检测结果
     * 
     * @param testId 检测结果主键
     * @return 检测结果
     */
    public NatsysTestPatient selectNatsysTestPatientByTestId(Long testId);

    /**
     * 查询检测结果列表
     * 
     * @param natsysTestPatient 检测结果
     * @return 检测结果集合
     */
    public List<NatsysTestPatient> selectNatsysTestPatientList(NatsysTestPatient natsysTestPatient);

    /**
     * 新增检测结果
     * 
     * @param natsysTestPatient 检测结果
     * @return 结果
     */
    public int insertNatsysTestPatient(NatsysTestPatient natsysTestPatient);

    /**
     * 修改检测结果
     * 
     * @param natsysTestPatient 检测结果
     * @return 结果
     */
    public int updateNatsysTestPatient(NatsysTestPatient natsysTestPatient);

    /**
     * 批量删除检测结果
     * 
     * @param testIds 需要删除的检测结果主键集合
     * @return 结果
     */
    public int deleteNatsysTestPatientByTestIds(Long[] testIds);

    /**
     * 删除检测结果信息
     * 
     * @param testId 检测结果主键
     * @return 结果
     */
    public int deleteNatsysTestPatientByTestId(Long testId);
}
