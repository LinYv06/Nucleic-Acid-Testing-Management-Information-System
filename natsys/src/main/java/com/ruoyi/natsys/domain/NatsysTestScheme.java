package com.ruoyi.natsys.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 检测方案对象 natsys_test_scheme
 * 
 * @author yuezhi
 * @date 2023-04-17
 */
public class NatsysTestScheme extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 检测方案id */
    private Long schemeId;

    /** 采样方式 */
    @Excel(name = "采样方式")
    private String samplingMethod;

    /** 检测方式 */
    @Excel(name = "检测方式")
    private String testingMethod;

    /** 检测流程 */
    @Excel(name = "检测流程")
    private String inspectionProcess;

    /** 删除标志（0代表存在 */
    private String delFlag;

    public void setSchemeId(Long schemeId) 
    {
        this.schemeId = schemeId;
    }

    public Long getSchemeId() 
    {
        return schemeId;
    }
    public void setSamplingMethod(String samplingMethod) 
    {
        this.samplingMethod = samplingMethod;
    }

    public String getSamplingMethod() 
    {
        return samplingMethod;
    }
    public void setTestingMethod(String testingMethod) 
    {
        this.testingMethod = testingMethod;
    }

    public String getTestingMethod() 
    {
        return testingMethod;
    }
    public void setInspectionProcess(String inspectionProcess) 
    {
        this.inspectionProcess = inspectionProcess;
    }

    public String getInspectionProcess() 
    {
        return inspectionProcess;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("schemeId", getSchemeId())
            .append("samplingMethod", getSamplingMethod())
            .append("testingMethod", getTestingMethod())
            .append("inspectionProcess", getInspectionProcess())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
