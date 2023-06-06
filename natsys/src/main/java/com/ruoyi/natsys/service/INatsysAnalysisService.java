package com.ruoyi.natsys.service;

import java.util.List;
import com.ruoyi.natsys.domain.NatsysAnalysis;

/**
 * 管理数据Service接口
 * 
 * @author yuezhi
 * @date 2023-05-14
 */
public interface INatsysAnalysisService 
{
    /**
     * 查询管理数据
     * 
     * @param analysisId 管理数据主键
     * @return 管理数据
     */
    public NatsysAnalysis selectNatsysAnalysisByAnalysisId(Long analysisId);

    /**
     * 查询管理数据列表
     * 
     * @param natsysAnalysis 管理数据
     * @return 管理数据集合
     */
    public List<NatsysAnalysis> selectNatsysAnalysisList(NatsysAnalysis natsysAnalysis);

    /**
     * 新增管理数据
     * 
     * @param natsysAnalysis 管理数据
     * @return 结果
     */
    public int insertNatsysAnalysis(NatsysAnalysis natsysAnalysis);

    /**
     * 修改管理数据
     * 
     * @param natsysAnalysis 管理数据
     * @return 结果
     */
    public int updateNatsysAnalysis(NatsysAnalysis natsysAnalysis);

    /**
     * 批量删除管理数据
     * 
     * @param analysisIds 需要删除的管理数据主键集合
     * @return 结果
     */
    public int deleteNatsysAnalysisByAnalysisIds(Long[] analysisIds);

    /**
     * 删除管理数据信息
     * 
     * @param analysisId 管理数据主键
     * @return 结果
     */
    public int deleteNatsysAnalysisByAnalysisId(Long analysisId);
}
