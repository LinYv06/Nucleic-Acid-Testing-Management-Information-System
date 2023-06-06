package com.ruoyi.natsys.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.natsys.mapper.NatsysAnalysisMapper;
import com.ruoyi.natsys.domain.NatsysAnalysis;
import com.ruoyi.natsys.service.INatsysAnalysisService;

/**
 * 管理数据Service业务层处理
 * 
 * @author yuezhi
 * @date 2023-05-14
 */
@Service
public class NatsysAnalysisServiceImpl implements INatsysAnalysisService 
{
    @Autowired
    private NatsysAnalysisMapper natsysAnalysisMapper;

    /**
     * 查询管理数据
     * 
     * @param analysisId 管理数据主键
     * @return 管理数据
     */
    @Override
    public NatsysAnalysis selectNatsysAnalysisByAnalysisId(Long analysisId)
    {
        return natsysAnalysisMapper.selectNatsysAnalysisByAnalysisId(analysisId);
    }

    /**
     * 查询管理数据列表
     * 
     * @param natsysAnalysis 管理数据
     * @return 管理数据
     */
    @Override
    public List<NatsysAnalysis> selectNatsysAnalysisList(NatsysAnalysis natsysAnalysis)
    {
        return natsysAnalysisMapper.selectNatsysAnalysisList(natsysAnalysis);
    }

    /**
     * 新增管理数据
     * 
     * @param natsysAnalysis 管理数据
     * @return 结果
     */
    @Override
    public int insertNatsysAnalysis(NatsysAnalysis natsysAnalysis)
    {
        return natsysAnalysisMapper.insertNatsysAnalysis(natsysAnalysis);
    }

    /**
     * 修改管理数据
     * 
     * @param natsysAnalysis 管理数据
     * @return 结果
     */
    @Override
    public int updateNatsysAnalysis(NatsysAnalysis natsysAnalysis)
    {
        return natsysAnalysisMapper.updateNatsysAnalysis(natsysAnalysis);
    }

    /**
     * 批量删除管理数据
     * 
     * @param analysisIds 需要删除的管理数据主键
     * @return 结果
     */
    @Override
    public int deleteNatsysAnalysisByAnalysisIds(Long[] analysisIds)
    {
        return natsysAnalysisMapper.deleteNatsysAnalysisByAnalysisIds(analysisIds);
    }

    /**
     * 删除管理数据信息
     * 
     * @param analysisId 管理数据主键
     * @return 结果
     */
    @Override
    public int deleteNatsysAnalysisByAnalysisId(Long analysisId)
    {
        return natsysAnalysisMapper.deleteNatsysAnalysisByAnalysisId(analysisId);
    }
}
