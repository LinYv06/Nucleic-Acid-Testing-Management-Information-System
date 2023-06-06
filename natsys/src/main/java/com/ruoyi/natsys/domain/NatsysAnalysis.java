package com.ruoyi.natsys.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 管理数据对象 natsys_analysis
 * 
 * @author yuezhi
 * @date 2023-05-14
 */
public class NatsysAnalysis extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分析数据 */
    private Long analysisId;

    /** 统计日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "统计日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statisticDate;

    /** 统计地区 */
    @Excel(name = "统计地区")
    private String statisticArea;

    /** 统计地点 */
    @Excel(name = "统计地点")
    private String statisticLocation;

    /** 阳性数量 */
    @Excel(name = "阳性数量")
    private Long positiveNum;

    /** 阴性数量 */
    @Excel(name = "阴性数量")
    private Long negativeNum;

    public void setAnalysisId(Long analysisId) 
    {
        this.analysisId = analysisId;
    }

    public Long getAnalysisId() 
    {
        return analysisId;
    }
    public void setStatisticDate(Date statisticDate) 
    {
        this.statisticDate = statisticDate;
    }

    public Date getStatisticDate() 
    {
        return statisticDate;
    }
    public void setStatisticArea(String statisticArea) 
    {
        this.statisticArea = statisticArea;
    }

    public String getStatisticArea() 
    {
        return statisticArea;
    }
    public void setStatisticLocation(String statisticLocation) 
    {
        this.statisticLocation = statisticLocation;
    }

    public String getStatisticLocation() 
    {
        return statisticLocation;
    }
    public void setPositiveNum(Long positiveNum) 
    {
        this.positiveNum = positiveNum;
    }

    public Long getPositiveNum() 
    {
        return positiveNum;
    }
    public void setNegativeNum(Long negativeNum) 
    {
        this.negativeNum = negativeNum;
    }

    public Long getNegativeNum() 
    {
        return negativeNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("analysisId", getAnalysisId())
            .append("statisticDate", getStatisticDate())
            .append("statisticArea", getStatisticArea())
            .append("statisticLocation", getStatisticLocation())
            .append("positiveNum", getPositiveNum())
            .append("negativeNum", getNegativeNum())
            .toString();
    }
}
