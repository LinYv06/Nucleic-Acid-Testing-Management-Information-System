package com.ruoyi.natsys.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 检测结果对象 natsys_test
 * 
 * @author yuezhi
 * @date 2023-05-09
 */
public class NatsysTestPatient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 检测记录id */
    private Long testId;

    /** 受检人id */
    private Long patientId;

    /** 检测方案id */
    private Long schemeId;

    /** 采样地区（省市） */
    private String testArea;

    /** 采样地点（医院等采样点） */
    private String testLocation;

    /** 采样时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采样时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date testTime;

    /** 是否已人脸识别（0代表否 */
    private String ifRecognition;

    /** 检测结果（0代表阴性 */
    @Excel(name = "检测结果", readConverterExp = "检测结果（0代表阴性")
    private String testResult;

    /** 检测人员id */
    private Long auditorId;

    /** 检测时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "检测时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditTime;

    /** 删除标志（0代表存在 */
    private String delFlag;

    /** 患者 */
    @Excel(name = "受检人员")
    private String patientName;

    /** 检测人员 */
    @Excel(name = "检测人员")
    private String doctorName;

    public void setTestId(Long testId) 
    {
        this.testId = testId;
    }

    public Long getTestId() 
    {
        return testId;
    }
    public void setPatientId(Long patientId) 
    {
        this.patientId = patientId;
    }

    public Long getPatientId() 
    {
        return patientId;
    }
    public void setSchemeId(Long schemeId) 
    {
        this.schemeId = schemeId;
    }

    public Long getSchemeId() 
    {
        return schemeId;
    }
    public void setTestArea(String testArea) 
    {
        this.testArea = testArea;
    }

    public String getTestArea() 
    {
        return testArea;
    }
    public void setTestLocation(String testLocation) 
    {
        this.testLocation = testLocation;
    }

    public String getTestLocation() 
    {
        return testLocation;
    }
    public void setTestTime(Date testTime) 
    {
        this.testTime = testTime;
    }

    public Date getTestTime() 
    {
        return testTime;
    }
    public void setIfRecognition(String ifRecognition) 
    {
        this.ifRecognition = ifRecognition;
    }

    public String getIfRecognition() 
    {
        return ifRecognition;
    }
    public void setTestResult(String testResult) 
    {
        this.testResult = testResult;
    }

    public String getTestResult() 
    {
        return testResult;
    }
    public void setAuditorId(Long auditorId) 
    {
        this.auditorId = auditorId;
    }

    public Long getAuditorId() 
    {
        return auditorId;
    }
    public void setAuditTime(Date auditTime) 
    {
        this.auditTime = auditTime;
    }

    public Date getAuditTime() 
    {
        return auditTime;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientName() {
        return patientName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("testId", getTestId())
            .append("patientId", getPatientId())
            .append("schemeId", getSchemeId())
            .append("testArea", getTestArea())
            .append("testLocation", getTestLocation())
            .append("testTime", getTestTime())
            .append("ifRecognition", getIfRecognition())
            .append("testResult", getTestResult())
            .append("auditorId", getAuditorId())
            .append("auditTime", getAuditTime())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("patient", getPatientName())
            .append("doctor", getDoctorName())
            .toString();
    }
}
