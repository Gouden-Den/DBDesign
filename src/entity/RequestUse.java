package entity;

import java.sql.Date;

public class RequestUse {
    private String departmentID;
    private String deviceID;
    private Integer status;
    private Date requestDate;
    private Date answerDate;
    private String remark;

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String userID) {
        this.departmentID = userID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
