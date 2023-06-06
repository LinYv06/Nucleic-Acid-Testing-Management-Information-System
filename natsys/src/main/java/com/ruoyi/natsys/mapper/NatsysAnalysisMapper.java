package com.ruoyi.natsys.mapper;

import java.util.List;
import com.ruoyi.natsys.domain.NatsysAnalysis;

/**
 * 管理数据Mapper接口
 * 
 * @author yuezhi
 * @date 2023-05-14
 */
public interface NatsysAnalysisMapper 
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
     * 删除管理数据
     * 
     * @param analysisId 管理数据主键
     * @return 结果
     */
    public int deleteNatsysAnalysisByAnalysisId(Long analysisId);

    /**
     * 批量删除管理数据
     * 
     * @param analysisIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNatsysAnalysisByAnalysisIds(Long[] analysisIds);
}
