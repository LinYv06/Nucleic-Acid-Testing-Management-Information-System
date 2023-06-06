package com.ruoyi.natsys.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.natsys.mapper.NatsysTestSchemeMapper;
import com.ruoyi.natsys.domain.NatsysTestScheme;
import com.ruoyi.natsys.service.INatsysTestSchemeService;

/**
 * 检测方案Service业务层处理
 * 
 * @author yuezhi
 * @date 2023-04-17
 */
@Service
public class NatsysTestSchemeServiceImpl implements INatsysTestSchemeService 
{
    @Autowired
    private NatsysTestSchemeMapper natsysTestSchemeMapper;

    /**
     * 查询检测方案
     * 
     * @param schemeId 检测方案主键
     * @return 检测方案
     */
    @Override
    public NatsysTestScheme selectNatsysTestSchemeBySchemeId(Long schemeId)
    {
        return natsysTestSchemeMapper.selectNatsysTestSchemeBySchemeId(schemeId);
    }

    /**
     * 查询检测方案列表
     * 
     * @param natsysTestScheme 检测方案
     * @return 检测方案
     */
    @Override
    public List<NatsysTestScheme> selectNatsysTestSchemeList(NatsysTestScheme natsysTestScheme)
    {
        return natsysTestSchemeMapper.selectNatsysTestSchemeList(natsysTestScheme);
    }

    /**
     * 新增检测方案
     * 
     * @param natsysTestScheme 检测方案
     * @return 结果
     */
    @Override
    public int insertNatsysTestScheme(NatsysTestScheme natsysTestScheme)
    {
        natsysTestScheme.setCreateBy(SecurityUtils.getUsername());
        natsysTestScheme.setCreateTime(DateUtils.getNowDate());
        return natsysTestSchemeMapper.insertNatsysTestScheme(natsysTestScheme);
    }

    /**
     * 修改检测方案
     * 
     * @param natsysTestScheme 检测方案
     * @return 结果
     */
    @Override
    public int updateNatsysTestScheme(NatsysTestScheme natsysTestScheme)
    {
        natsysTestScheme.setUpdateBy(SecurityUtils.getUsername());
        natsysTestScheme.setUpdateTime(DateUtils.getNowDate());
        return natsysTestSchemeMapper.updateNatsysTestScheme(natsysTestScheme);
    }

    /**
     * 批量删除检测方案
     * 
     * @param schemeIds 需要删除的检测方案主键
     * @return 结果
     */
    @Override
    public int deleteNatsysTestSchemeBySchemeIds(Long[] schemeIds)
    {
        return natsysTestSchemeMapper.deleteNatsysTestSchemeBySchemeIds(schemeIds);
    }

    /**
     * 删除检测方案信息
     * 
     * @param schemeId 检测方案主键
     * @return 结果
     */
    @Override
    public int deleteNatsysTestSchemeBySchemeId(Long schemeId)
    {
        return natsysTestSchemeMapper.deleteNatsysTestSchemeBySchemeId(schemeId);
    }
}
