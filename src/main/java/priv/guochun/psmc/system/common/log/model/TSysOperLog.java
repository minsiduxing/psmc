package priv.guochun.psmc.system.common.log.model;

import java.math.BigDecimal;
import java.util.Date;

public class TSysOperLog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_oper_log.uuid
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    private String uuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_oper_log.log_sub_type_name
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    private String logSubTypeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_oper_log.log_sub_type
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    private BigDecimal logSubType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_oper_log.log_type_name
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    private String logTypeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_oper_log.log_type
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    private BigDecimal logType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_oper_log.bussiness_uuid
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    private String bussinessUuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_oper_log.operid
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    private String operid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_oper_log.opername
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    private String opername;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_oper_log.oper_date
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    private Date operDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_oper_log.oper_input
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    private String operInput;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_oper_log.oper_output
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    private String operOutput;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_oper_log.oper_result_desc
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    private String operResultDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_oper_log.oper_result
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    private Short operResult;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_oper_log.uuid
     *
     * @return the value of t_sys_oper_log.uuid
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_oper_log.uuid
     *
     * @param uuid the value for t_sys_oper_log.uuid
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_oper_log.log_sub_type_name
     *
     * @return the value of t_sys_oper_log.log_sub_type_name
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public String getLogSubTypeName() {
        return logSubTypeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_oper_log.log_sub_type_name
     *
     * @param logSubTypeName the value for t_sys_oper_log.log_sub_type_name
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public void setLogSubTypeName(String logSubTypeName) {
        this.logSubTypeName = logSubTypeName == null ? null : logSubTypeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_oper_log.log_sub_type
     *
     * @return the value of t_sys_oper_log.log_sub_type
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public BigDecimal getLogSubType() {
        return logSubType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_oper_log.log_sub_type
     *
     * @param logSubType the value for t_sys_oper_log.log_sub_type
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public void setLogSubType(BigDecimal logSubType) {
        this.logSubType = logSubType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_oper_log.log_type_name
     *
     * @return the value of t_sys_oper_log.log_type_name
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public String getLogTypeName() {
        return logTypeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_oper_log.log_type_name
     *
     * @param logTypeName the value for t_sys_oper_log.log_type_name
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public void setLogTypeName(String logTypeName) {
        this.logTypeName = logTypeName == null ? null : logTypeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_oper_log.log_type
     *
     * @return the value of t_sys_oper_log.log_type
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public BigDecimal getLogType() {
        return logType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_oper_log.log_type
     *
     * @param logType the value for t_sys_oper_log.log_type
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public void setLogType(BigDecimal logType) {
        this.logType = logType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_oper_log.bussiness_uuid
     *
     * @return the value of t_sys_oper_log.bussiness_uuid
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public String getBussinessUuid() {
        return bussinessUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_oper_log.bussiness_uuid
     *
     * @param bussinessUuid the value for t_sys_oper_log.bussiness_uuid
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public void setBussinessUuid(String bussinessUuid) {
        this.bussinessUuid = bussinessUuid == null ? null : bussinessUuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_oper_log.operid
     *
     * @return the value of t_sys_oper_log.operid
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public String getOperid() {
        return operid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_oper_log.operid
     *
     * @param operid the value for t_sys_oper_log.operid
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public void setOperid(String operid) {
        this.operid = operid == null ? null : operid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_oper_log.opername
     *
     * @return the value of t_sys_oper_log.opername
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public String getOpername() {
        return opername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_oper_log.opername
     *
     * @param opername the value for t_sys_oper_log.opername
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public void setOpername(String opername) {
        this.opername = opername == null ? null : opername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_oper_log.oper_date
     *
     * @return the value of t_sys_oper_log.oper_date
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public Date getOperDate() {
        return operDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_oper_log.oper_date
     *
     * @param operDate the value for t_sys_oper_log.oper_date
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public void setOperDate(Date operDate) {
        this.operDate = operDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_oper_log.oper_input
     *
     * @return the value of t_sys_oper_log.oper_input
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public String getOperInput() {
        return operInput;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_oper_log.oper_input
     *
     * @param operInput the value for t_sys_oper_log.oper_input
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public void setOperInput(String operInput) {
        this.operInput = operInput == null ? null : operInput.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_oper_log.oper_output
     *
     * @return the value of t_sys_oper_log.oper_output
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public String getOperOutput() {
        return operOutput;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_oper_log.oper_output
     *
     * @param operOutput the value for t_sys_oper_log.oper_output
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public void setOperOutput(String operOutput) {
        this.operOutput = operOutput == null ? null : operOutput.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_oper_log.oper_result_desc
     *
     * @return the value of t_sys_oper_log.oper_result_desc
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public String getOperResultDesc() {
        return operResultDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_oper_log.oper_result_desc
     *
     * @param operResultDesc the value for t_sys_oper_log.oper_result_desc
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public void setOperResultDesc(String operResultDesc) {
        this.operResultDesc = operResultDesc == null ? null : operResultDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_oper_log.oper_result
     *
     * @return the value of t_sys_oper_log.oper_result
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public Short getOperResult() {
        return operResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_oper_log.oper_result
     *
     * @param operResult the value for t_sys_oper_log.oper_result
     *
     * @mbg.generated Tue Apr 10 16:51:46 CST 2018
     */
    public void setOperResult(Short operResult) {
        this.operResult = operResult;
    }
}