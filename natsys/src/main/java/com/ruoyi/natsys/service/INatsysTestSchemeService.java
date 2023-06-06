package com.ruoyi.natsys.service;

import java.util.List;
import com.ruoyi.natsys.domain.NatsysTestScheme;

/**
 * 检测方案Service接口
 * 
 * @author yuezhi
 * @date 2023-04-17
 */
public interface INatsysTestSchemeService 
{
    /**
     * 查询检测方案
     * 
     * @param schemeId 检测方案主键
     * @return 检测方案
     */
    public NatsysTestScheme selectNatsysTestSchemeBySchemeId(Long schemeId);

    /**
     * 查询检测方案列表
     * 
     * @param natsysTestScheme 检测方案
     * @return 检测方案集合
     */
    public List<NatsysTestScheme> selectNatsysTestSchemeList(NatsysTestScheme natsysTestScheme);

    /**
     * 新增检测方案
     * 
     * @param natsysTestScheme 检测方案
     * @return 结果
     */
    public int insertNatsysTestScheme(NatsysTestScheme natsysTestScheme);

    /**
     * 修改检测方案
     * 
     * @param natsysTestScheme 检测方案
     * @return 结果
     */
    public int updateNatsysTestScheme(NatsysTestScheme natsysTestScheme);

    /**
     * 批量删除检测方案
     * 
     * @param schemeIds 需要删除的检测方案主键集合
     * @return 结果
     */
    public int deleteNatsysTestSchemeBySchemeIds(Long[] schemeIds);

    /**
     * 删除检测方案信息
     * 
     * @param schemeId 检测方案主键
     * @return 结果
     */
    public int deleteNatsysTestSchemeBySchemeId(Long schemeId);
}
