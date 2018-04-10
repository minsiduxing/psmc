package priv.guochun.psmc.system.framework.activiti.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

public class TFlowInstanceExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */public TFlowInstanceExample(){oredCriteria=new ArrayList<Criteria>();}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */public List<Criteria> getOredCriteria(){return oredCriteria;}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */protected abstract static class GeneratedCriteria {protected List<Criterion> criteria;protected GeneratedCriteria(){super();criteria=new ArrayList<Criterion>();}public boolean isValid(){return criteria.size() > 0;}public List<Criterion> getAllCriteria(){return criteria;}public List<Criterion> getCriteria(){return criteria;}protected void addCriterion(String condition){if (condition == null){throw new RuntimeException("Value for condition cannot be null");}criteria.add(new Criterion(condition));}protected void addCriterion(String condition,Object value,String property){if (value == null){throw new RuntimeException("Value for " + property + " cannot be null");}criteria.add(new Criterion(condition,value));}protected void addCriterion(String condition,Object value1,Object value2,String property){if (value1 == null || value2 == null){throw new RuntimeException("Between values for " + property + " cannot be null");}criteria.add(new Criterion(condition,value1,value2));}public Criteria andTfiUuidIsNull(){addCriterion("tfi_uuid is null");return (Criteria)this;}public Criteria andTfiUuidIsNotNull(){addCriterion("tfi_uuid is not null");return (Criteria)this;}public Criteria andTfiUuidEqualTo(String value){addCriterion("tfi_uuid =",value,"tfiUuid");return (Criteria)this;}public Criteria andTfiUuidNotEqualTo(String value){addCriterion("tfi_uuid <>",value,"tfiUuid");return (Criteria)this;}public Criteria andTfiUuidGreaterThan(String value){addCriterion("tfi_uuid >",value,"tfiUuid");return (Criteria)this;}public Criteria andTfiUuidGreaterThanOrEqualTo(String value){addCriterion("tfi_uuid >=",value,"tfiUuid");return (Criteria)this;}public Criteria andTfiUuidLessThan(String value){addCriterion("tfi_uuid <",value,"tfiUuid");return (Criteria)this;}public Criteria andTfiUuidLessThanOrEqualTo(String value){addCriterion("tfi_uuid <=",value,"tfiUuid");return (Criteria)this;}public Criteria andTfiUuidLike(String value){addCriterion("tfi_uuid like",value,"tfiUuid");return (Criteria)this;}public Criteria andTfiUuidNotLike(String value){addCriterion("tfi_uuid not like",value,"tfiUuid");return (Criteria)this;}public Criteria andTfiUuidIn(List<String> values){addCriterion("tfi_uuid in",values,"tfiUuid");return (Criteria)this;}public Criteria andTfiUuidNotIn(List<String> values){addCriterion("tfi_uuid not in",values,"tfiUuid");return (Criteria)this;}public Criteria andTfiUuidBetween(String value1,String value2){addCriterion("tfi_uuid between",value1,value2,"tfiUuid");return (Criteria)this;}public Criteria andTfiUuidNotBetween(String value1,String value2){addCriterion("tfi_uuid not between",value1,value2,"tfiUuid");return (Criteria)this;}public Criteria andTfcUuidIsNull(){addCriterion("tfc_uuid is null");return (Criteria)this;}public Criteria andTfcUuidIsNotNull(){addCriterion("tfc_uuid is not null");return (Criteria)this;}public Criteria andTfcUuidEqualTo(String value){addCriterion("tfc_uuid =",value,"tfcUuid");return (Criteria)this;}public Criteria andTfcUuidNotEqualTo(String value){addCriterion("tfc_uuid <>",value,"tfcUuid");return (Criteria)this;}public Criteria andTfcUuidGreaterThan(String value){addCriterion("tfc_uuid >",value,"tfcUuid");return (Criteria)this;}public Criteria andTfcUuidGreaterThanOrEqualTo(String value){addCriterion("tfc_uuid >=",value,"tfcUuid");return (Criteria)this;}public Criteria andTfcUuidLessThan(String value){addCriterion("tfc_uuid <",value,"tfcUuid");return (Criteria)this;}public Criteria andTfcUuidLessThanOrEqualTo(String value){addCriterion("tfc_uuid <=",value,"tfcUuid");return (Criteria)this;}public Criteria andTfcUuidLike(String value){addCriterion("tfc_uuid like",value,"tfcUuid");return (Criteria)this;}public Criteria andTfcUuidNotLike(String value){addCriterion("tfc_uuid not like",value,"tfcUuid");return (Criteria)this;}public Criteria andTfcUuidIn(List<String> values){addCriterion("tfc_uuid in",values,"tfcUuid");return (Criteria)this;}public Criteria andTfcUuidNotIn(List<String> values){addCriterion("tfc_uuid not in",values,"tfcUuid");return (Criteria)this;}public Criteria andTfcUuidBetween(String value1,String value2){addCriterion("tfc_uuid between",value1,value2,"tfcUuid");return (Criteria)this;}public Criteria andTfcUuidNotBetween(String value1,String value2){addCriterion("tfc_uuid not between",value1,value2,"tfcUuid");return (Criteria)this;}public Criteria andFlowNoIsNull(){addCriterion("flow_no is null");return (Criteria)this;}public Criteria andFlowNoIsNotNull(){addCriterion("flow_no is not null");return (Criteria)this;}public Criteria andFlowNoEqualTo(String value){addCriterion("flow_no =",value,"flowNo");return (Criteria)this;}public Criteria andFlowNoNotEqualTo(String value){addCriterion("flow_no <>",value,"flowNo");return (Criteria)this;}public Criteria andFlowNoGreaterThan(String value){addCriterion("flow_no >",value,"flowNo");return (Criteria)this;}public Criteria andFlowNoGreaterThanOrEqualTo(String value){addCriterion("flow_no >=",value,"flowNo");return (Criteria)this;}public Criteria andFlowNoLessThan(String value){addCriterion("flow_no <",value,"flowNo");return (Criteria)this;}public Criteria andFlowNoLessThanOrEqualTo(String value){addCriterion("flow_no <=",value,"flowNo");return (Criteria)this;}public Criteria andFlowNoLike(String value){addCriterion("flow_no like",value,"flowNo");return (Criteria)this;}public Criteria andFlowNoNotLike(String value){addCriterion("flow_no not like",value,"flowNo");return (Criteria)this;}public Criteria andFlowNoIn(List<String> values){addCriterion("flow_no in",values,"flowNo");return (Criteria)this;}public Criteria andFlowNoNotIn(List<String> values){addCriterion("flow_no not in",values,"flowNo");return (Criteria)this;}public Criteria andFlowNoBetween(String value1,String value2){addCriterion("flow_no between",value1,value2,"flowNo");return (Criteria)this;}public Criteria andFlowNoNotBetween(String value1,String value2){addCriterion("flow_no not between",value1,value2,"flowNo");return (Criteria)this;}public Criteria andFlowCnNameIsNull(){addCriterion("flow_cn_name is null");return (Criteria)this;}public Criteria andFlowCnNameIsNotNull(){addCriterion("flow_cn_name is not null");return (Criteria)this;}public Criteria andFlowCnNameEqualTo(String value){addCriterion("flow_cn_name =",value,"flowCnName");return (Criteria)this;}public Criteria andFlowCnNameNotEqualTo(String value){addCriterion("flow_cn_name <>",value,"flowCnName");return (Criteria)this;}public Criteria andFlowCnNameGreaterThan(String value){addCriterion("flow_cn_name >",value,"flowCnName");return (Criteria)this;}public Criteria andFlowCnNameGreaterThanOrEqualTo(String value){addCriterion("flow_cn_name >=",value,"flowCnName");return (Criteria)this;}public Criteria andFlowCnNameLessThan(String value){addCriterion("flow_cn_name <",value,"flowCnName");return (Criteria)this;}public Criteria andFlowCnNameLessThanOrEqualTo(String value){addCriterion("flow_cn_name <=",value,"flowCnName");return (Criteria)this;}public Criteria andFlowCnNameLike(String value){addCriterion("flow_cn_name like",value,"flowCnName");return (Criteria)this;}public Criteria andFlowCnNameNotLike(String value){addCriterion("flow_cn_name not like",value,"flowCnName");return (Criteria)this;}public Criteria andFlowCnNameIn(List<String> values){addCriterion("flow_cn_name in",values,"flowCnName");return (Criteria)this;}public Criteria andFlowCnNameNotIn(List<String> values){addCriterion("flow_cn_name not in",values,"flowCnName");return (Criteria)this;}public Criteria andFlowCnNameBetween(String value1,String value2){addCriterion("flow_cn_name between",value1,value2,"flowCnName");return (Criteria)this;}public Criteria andFlowCnNameNotBetween(String value1,String value2){addCriterion("flow_cn_name not between",value1,value2,"flowCnName");return (Criteria)this;}public Criteria andFlowEnNameIsNull(){addCriterion("flow_en_name is null");return (Criteria)this;}public Criteria andFlowEnNameIsNotNull(){addCriterion("flow_en_name is not null");return (Criteria)this;}public Criteria andFlowEnNameEqualTo(String value){addCriterion("flow_en_name =",value,"flowEnName");return (Criteria)this;}public Criteria andFlowEnNameNotEqualTo(String value){addCriterion("flow_en_name <>",value,"flowEnName");return (Criteria)this;}public Criteria andFlowEnNameGreaterThan(String value){addCriterion("flow_en_name >",value,"flowEnName");return (Criteria)this;}public Criteria andFlowEnNameGreaterThanOrEqualTo(String value){addCriterion("flow_en_name >=",value,"flowEnName");return (Criteria)this;}public Criteria andFlowEnNameLessThan(String value){addCriterion("flow_en_name <",value,"flowEnName");return (Criteria)this;}public Criteria andFlowEnNameLessThanOrEqualTo(String value){addCriterion("flow_en_name <=",value,"flowEnName");return (Criteria)this;}public Criteria andFlowEnNameLike(String value){addCriterion("flow_en_name like",value,"flowEnName");return (Criteria)this;}public Criteria andFlowEnNameNotLike(String value){addCriterion("flow_en_name not like",value,"flowEnName");return (Criteria)this;}public Criteria andFlowEnNameIn(List<String> values){addCriterion("flow_en_name in",values,"flowEnName");return (Criteria)this;}public Criteria andFlowEnNameNotIn(List<String> values){addCriterion("flow_en_name not in",values,"flowEnName");return (Criteria)this;}public Criteria andFlowEnNameBetween(String value1,String value2){addCriterion("flow_en_name between",value1,value2,"flowEnName");return (Criteria)this;}public Criteria andFlowEnNameNotBetween(String value1,String value2){addCriterion("flow_en_name not between",value1,value2,"flowEnName");return (Criteria)this;}public Criteria andFlowEntranceIsNull(){addCriterion("flow_entrance is null");return (Criteria)this;}public Criteria andFlowEntranceIsNotNull(){addCriterion("flow_entrance is not null");return (Criteria)this;}public Criteria andFlowEntranceEqualTo(String value){addCriterion("flow_entrance =",value,"flowEntrance");return (Criteria)this;}public Criteria andFlowEntranceNotEqualTo(String value){addCriterion("flow_entrance <>",value,"flowEntrance");return (Criteria)this;}public Criteria andFlowEntranceGreaterThan(String value){addCriterion("flow_entrance >",value,"flowEntrance");return (Criteria)this;}public Criteria andFlowEntranceGreaterThanOrEqualTo(String value){addCriterion("flow_entrance >=",value,"flowEntrance");return (Criteria)this;}public Criteria andFlowEntranceLessThan(String value){addCriterion("flow_entrance <",value,"flowEntrance");return (Criteria)this;}public Criteria andFlowEntranceLessThanOrEqualTo(String value){addCriterion("flow_entrance <=",value,"flowEntrance");return (Criteria)this;}public Criteria andFlowEntranceLike(String value){addCriterion("flow_entrance like",value,"flowEntrance");return (Criteria)this;}public Criteria andFlowEntranceNotLike(String value){addCriterion("flow_entrance not like",value,"flowEntrance");return (Criteria)this;}public Criteria andFlowEntranceIn(List<String> values){addCriterion("flow_entrance in",values,"flowEntrance");return (Criteria)this;}public Criteria andFlowEntranceNotIn(List<String> values){addCriterion("flow_entrance not in",values,"flowEntrance");return (Criteria)this;}public Criteria andFlowEntranceBetween(String value1,String value2){addCriterion("flow_entrance between",value1,value2,"flowEntrance");return (Criteria)this;}public Criteria andFlowEntranceNotBetween(String value1,String value2){addCriterion("flow_entrance not between",value1,value2,"flowEntrance");return (Criteria)this;}public Criteria andFlowVersionIsNull(){addCriterion("flow_version is null");return (Criteria)this;}public Criteria andFlowVersionIsNotNull(){addCriterion("flow_version is not null");return (Criteria)this;}public Criteria andFlowVersionEqualTo(Float value){addCriterion("flow_version =",value,"flowVersion");return (Criteria)this;}public Criteria andFlowVersionNotEqualTo(Float value){addCriterion("flow_version <>",value,"flowVersion");return (Criteria)this;}public Criteria andFlowVersionGreaterThan(Float value){addCriterion("flow_version >",value,"flowVersion");return (Criteria)this;}public Criteria andFlowVersionGreaterThanOrEqualTo(Float value){addCriterion("flow_version >=",value,"flowVersion");return (Criteria)this;}public Criteria andFlowVersionLessThan(Float value){addCriterion("flow_version <",value,"flowVersion");return (Criteria)this;}public Criteria andFlowVersionLessThanOrEqualTo(Float value){addCriterion("flow_version <=",value,"flowVersion");return (Criteria)this;}public Criteria andFlowVersionIn(List<Float> values){addCriterion("flow_version in",values,"flowVersion");return (Criteria)this;}public Criteria andFlowVersionNotIn(List<Float> values){addCriterion("flow_version not in",values,"flowVersion");return (Criteria)this;}public Criteria andFlowVersionBetween(Float value1,Float value2){addCriterion("flow_version between",value1,value2,"flowVersion");return (Criteria)this;}public Criteria andFlowVersionNotBetween(Float value1,Float value2){addCriterion("flow_version not between",value1,value2,"flowVersion");return (Criteria)this;}public Criteria andFlowStateIsNull(){addCriterion("flow_state is null");return (Criteria)this;}public Criteria andFlowStateIsNotNull(){addCriterion("flow_state is not null");return (Criteria)this;}public Criteria andFlowStateEqualTo(Integer value){addCriterion("flow_state =",value,"flowState");return (Criteria)this;}public Criteria andFlowStateNotEqualTo(Integer value){addCriterion("flow_state <>",value,"flowState");return (Criteria)this;}public Criteria andFlowStateGreaterThan(Integer value){addCriterion("flow_state >",value,"flowState");return (Criteria)this;}public Criteria andFlowStateGreaterThanOrEqualTo(Integer value){addCriterion("flow_state >=",value,"flowState");return (Criteria)this;}public Criteria andFlowStateLessThan(Integer value){addCriterion("flow_state <",value,"flowState");return (Criteria)this;}public Criteria andFlowStateLessThanOrEqualTo(Integer value){addCriterion("flow_state <=",value,"flowState");return (Criteria)this;}public Criteria andFlowStateIn(List<Integer> values){addCriterion("flow_state in",values,"flowState");return (Criteria)this;}public Criteria andFlowStateNotIn(List<Integer> values){addCriterion("flow_state not in",values,"flowState");return (Criteria)this;}public Criteria andFlowStateBetween(Integer value1,Integer value2){addCriterion("flow_state between",value1,value2,"flowState");return (Criteria)this;}public Criteria andFlowStateNotBetween(Integer value1,Integer value2){addCriterion("flow_state not between",value1,value2,"flowState");return (Criteria)this;}public Criteria andFlowStartTimeIsNull(){addCriterion("flow_start_time is null");return (Criteria)this;}public Criteria andFlowStartTimeIsNotNull(){addCriterion("flow_start_time is not null");return (Criteria)this;}public Criteria andFlowStartTimeEqualTo(Date value){addCriterion("flow_start_time =",value,"flowStartTime");return (Criteria)this;}public Criteria andFlowStartTimeNotEqualTo(Date value){addCriterion("flow_start_time <>",value,"flowStartTime");return (Criteria)this;}public Criteria andFlowStartTimeGreaterThan(Date value){addCriterion("flow_start_time >",value,"flowStartTime");return (Criteria)this;}public Criteria andFlowStartTimeGreaterThanOrEqualTo(Date value){addCriterion("flow_start_time >=",value,"flowStartTime");return (Criteria)this;}public Criteria andFlowStartTimeLessThan(Date value){addCriterion("flow_start_time <",value,"flowStartTime");return (Criteria)this;}public Criteria andFlowStartTimeLessThanOrEqualTo(Date value){addCriterion("flow_start_time <=",value,"flowStartTime");return (Criteria)this;}public Criteria andFlowStartTimeIn(List<Date> values){addCriterion("flow_start_time in",values,"flowStartTime");return (Criteria)this;}public Criteria andFlowStartTimeNotIn(List<Date> values){addCriterion("flow_start_time not in",values,"flowStartTime");return (Criteria)this;}public Criteria andFlowStartTimeBetween(Date value1,Date value2){addCriterion("flow_start_time between",value1,value2,"flowStartTime");return (Criteria)this;}public Criteria andFlowStartTimeNotBetween(Date value1,Date value2){addCriterion("flow_start_time not between",value1,value2,"flowStartTime");return (Criteria)this;}public Criteria andFlowLimitHourIsNull(){addCriterion("flow_limit_hour is null");return (Criteria)this;}public Criteria andFlowLimitHourIsNotNull(){addCriterion("flow_limit_hour is not null");return (Criteria)this;}public Criteria andFlowLimitHourEqualTo(BigDecimal value){addCriterion("flow_limit_hour =",value,"flowLimitHour");return (Criteria)this;}public Criteria andFlowLimitHourNotEqualTo(BigDecimal value){addCriterion("flow_limit_hour <>",value,"flowLimitHour");return (Criteria)this;}public Criteria andFlowLimitHourGreaterThan(BigDecimal value){addCriterion("flow_limit_hour >",value,"flowLimitHour");return (Criteria)this;}public Criteria andFlowLimitHourGreaterThanOrEqualTo(BigDecimal value){addCriterion("flow_limit_hour >=",value,"flowLimitHour");return (Criteria)this;}public Criteria andFlowLimitHourLessThan(BigDecimal value){addCriterion("flow_limit_hour <",value,"flowLimitHour");return (Criteria)this;}public Criteria andFlowLimitHourLessThanOrEqualTo(BigDecimal value){addCriterion("flow_limit_hour <=",value,"flowLimitHour");return (Criteria)this;}public Criteria andFlowLimitHourIn(List<BigDecimal> values){addCriterion("flow_limit_hour in",values,"flowLimitHour");return (Criteria)this;}public Criteria andFlowLimitHourNotIn(List<BigDecimal> values){addCriterion("flow_limit_hour not in",values,"flowLimitHour");return (Criteria)this;}public Criteria andFlowLimitHourBetween(BigDecimal value1,BigDecimal value2){addCriterion("flow_limit_hour between",value1,value2,"flowLimitHour");return (Criteria)this;}public Criteria andFlowLimitHourNotBetween(BigDecimal value1,BigDecimal value2){addCriterion("flow_limit_hour not between",value1,value2,"flowLimitHour");return (Criteria)this;}public Criteria andFlowEndTimeIsNull(){addCriterion("flow_end_time is null");return (Criteria)this;}public Criteria andFlowEndTimeIsNotNull(){addCriterion("flow_end_time is not null");return (Criteria)this;}public Criteria andFlowEndTimeEqualTo(Date value){addCriterion("flow_end_time =",value,"flowEndTime");return (Criteria)this;}public Criteria andFlowEndTimeNotEqualTo(Date value){addCriterion("flow_end_time <>",value,"flowEndTime");return (Criteria)this;}public Criteria andFlowEndTimeGreaterThan(Date value){addCriterion("flow_end_time >",value,"flowEndTime");return (Criteria)this;}public Criteria andFlowEndTimeGreaterThanOrEqualTo(Date value){addCriterion("flow_end_time >=",value,"flowEndTime");return (Criteria)this;}public Criteria andFlowEndTimeLessThan(Date value){addCriterion("flow_end_time <",value,"flowEndTime");return (Criteria)this;}public Criteria andFlowEndTimeLessThanOrEqualTo(Date value){addCriterion("flow_end_time <=",value,"flowEndTime");return (Criteria)this;}public Criteria andFlowEndTimeIn(List<Date> values){addCriterion("flow_end_time in",values,"flowEndTime");return (Criteria)this;}public Criteria andFlowEndTimeNotIn(List<Date> values){addCriterion("flow_end_time not in",values,"flowEndTime");return (Criteria)this;}public Criteria andFlowEndTimeBetween(Date value1,Date value2){addCriterion("flow_end_time between",value1,value2,"flowEndTime");return (Criteria)this;}public Criteria andFlowEndTimeNotBetween(Date value1,Date value2){addCriterion("flow_end_time not between",value1,value2,"flowEndTime");return (Criteria)this;}public Criteria andFlowEndLimitTimeIsNull(){addCriterion("flow_end_limit_time is null");return (Criteria)this;}public Criteria andFlowEndLimitTimeIsNotNull(){addCriterion("flow_end_limit_time is not null");return (Criteria)this;}public Criteria andFlowEndLimitTimeEqualTo(Date value){addCriterion("flow_end_limit_time =",value,"flowEndLimitTime");return (Criteria)this;}public Criteria andFlowEndLimitTimeNotEqualTo(Date value){addCriterion("flow_end_limit_time <>",value,"flowEndLimitTime");return (Criteria)this;}public Criteria andFlowEndLimitTimeGreaterThan(Date value){addCriterion("flow_end_limit_time >",value,"flowEndLimitTime");return (Criteria)this;}public Criteria andFlowEndLimitTimeGreaterThanOrEqualTo(Date value){addCriterion("flow_end_limit_time >=",value,"flowEndLimitTime");return (Criteria)this;}public Criteria andFlowEndLimitTimeLessThan(Date value){addCriterion("flow_end_limit_time <",value,"flowEndLimitTime");return (Criteria)this;}public Criteria andFlowEndLimitTimeLessThanOrEqualTo(Date value){addCriterion("flow_end_limit_time <=",value,"flowEndLimitTime");return (Criteria)this;}public Criteria andFlowEndLimitTimeIn(List<Date> values){addCriterion("flow_end_limit_time in",values,"flowEndLimitTime");return (Criteria)this;}public Criteria andFlowEndLimitTimeNotIn(List<Date> values){addCriterion("flow_end_limit_time not in",values,"flowEndLimitTime");return (Criteria)this;}public Criteria andFlowEndLimitTimeBetween(Date value1,Date value2){addCriterion("flow_end_limit_time between",value1,value2,"flowEndLimitTime");return (Criteria)this;}public Criteria andFlowEndLimitTimeNotBetween(Date value1,Date value2){addCriterion("flow_end_limit_time not between",value1,value2,"flowEndLimitTime");return (Criteria)this;}}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table t_flow_instance
	 * @mbg.generated  Tue Apr 10 16:16:28 CST 2018
	 */public static class Criterion {private String condition;private Object value;private Object secondValue;private boolean noValue;private boolean singleValue;private boolean betweenValue;private boolean listValue;private String typeHandler;public String getCondition(){return condition;}public Object getValue(){return value;}public Object getSecondValue(){return secondValue;}public boolean isNoValue(){return noValue;}public boolean isSingleValue(){return singleValue;}public boolean isBetweenValue(){return betweenValue;}public boolean isListValue(){return listValue;}public String getTypeHandler(){return typeHandler;}protected Criterion(String condition){super();this.condition=condition;this.typeHandler=null;this.noValue=true;}protected Criterion(String condition,Object value,String typeHandler){super();this.condition=condition;this.value=value;this.typeHandler=typeHandler;if (value instanceof List<?>){this.listValue=true;} else {this.singleValue=true;}}protected Criterion(String condition,Object value){this(condition,value,null);}protected Criterion(String condition,Object value,Object secondValue,String typeHandler){super();this.condition=condition;this.value=value;this.secondValue=secondValue;this.typeHandler=typeHandler;this.betweenValue=true;}protected Criterion(String condition,Object value,Object secondValue){this(condition,value,secondValue,null);}}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_flow_instance
     *
     * @mbg.generated do_not_delete_during_merge Mon Apr 09 15:45:49 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}