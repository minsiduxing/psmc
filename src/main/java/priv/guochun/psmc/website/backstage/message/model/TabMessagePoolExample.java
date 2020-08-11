package priv.guochun.psmc.website.backstage.message.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TabMessagePoolExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabMessagePoolExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMsgUuidIsNull() {
            addCriterion("msg_uuid is null");
            return (Criteria) this;
        }

        public Criteria andMsgUuidIsNotNull() {
            addCriterion("msg_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andMsgUuidEqualTo(String value) {
            addCriterion("msg_uuid =", value, "msgUuid");
            return (Criteria) this;
        }

        public Criteria andMsgUuidNotEqualTo(String value) {
            addCriterion("msg_uuid <>", value, "msgUuid");
            return (Criteria) this;
        }

        public Criteria andMsgUuidGreaterThan(String value) {
            addCriterion("msg_uuid >", value, "msgUuid");
            return (Criteria) this;
        }

        public Criteria andMsgUuidGreaterThanOrEqualTo(String value) {
            addCriterion("msg_uuid >=", value, "msgUuid");
            return (Criteria) this;
        }

        public Criteria andMsgUuidLessThan(String value) {
            addCriterion("msg_uuid <", value, "msgUuid");
            return (Criteria) this;
        }

        public Criteria andMsgUuidLessThanOrEqualTo(String value) {
            addCriterion("msg_uuid <=", value, "msgUuid");
            return (Criteria) this;
        }

        public Criteria andMsgUuidLike(String value) {
            addCriterion("msg_uuid like", value, "msgUuid");
            return (Criteria) this;
        }

        public Criteria andMsgUuidNotLike(String value) {
            addCriterion("msg_uuid not like", value, "msgUuid");
            return (Criteria) this;
        }

        public Criteria andMsgUuidIn(List<String> values) {
            addCriterion("msg_uuid in", values, "msgUuid");
            return (Criteria) this;
        }

        public Criteria andMsgUuidNotIn(List<String> values) {
            addCriterion("msg_uuid not in", values, "msgUuid");
            return (Criteria) this;
        }

        public Criteria andMsgUuidBetween(String value1, String value2) {
            addCriterion("msg_uuid between", value1, value2, "msgUuid");
            return (Criteria) this;
        }

        public Criteria andMsgUuidNotBetween(String value1, String value2) {
            addCriterion("msg_uuid not between", value1, value2, "msgUuid");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andTempCodeIsNull() {
            addCriterion("temp_code is null");
            return (Criteria) this;
        }

        public Criteria andTempCodeIsNotNull() {
            addCriterion("temp_code is not null");
            return (Criteria) this;
        }

        public Criteria andTempCodeEqualTo(String value) {
            addCriterion("temp_code =", value, "tempCode");
            return (Criteria) this;
        }

        public Criteria andTempCodeNotEqualTo(String value) {
            addCriterion("temp_code <>", value, "tempCode");
            return (Criteria) this;
        }

        public Criteria andTempCodeGreaterThan(String value) {
            addCriterion("temp_code >", value, "tempCode");
            return (Criteria) this;
        }

        public Criteria andTempCodeGreaterThanOrEqualTo(String value) {
            addCriterion("temp_code >=", value, "tempCode");
            return (Criteria) this;
        }

        public Criteria andTempCodeLessThan(String value) {
            addCriterion("temp_code <", value, "tempCode");
            return (Criteria) this;
        }

        public Criteria andTempCodeLessThanOrEqualTo(String value) {
            addCriterion("temp_code <=", value, "tempCode");
            return (Criteria) this;
        }

        public Criteria andTempCodeLike(String value) {
            addCriterion("temp_code like", value, "tempCode");
            return (Criteria) this;
        }

        public Criteria andTempCodeNotLike(String value) {
            addCriterion("temp_code not like", value, "tempCode");
            return (Criteria) this;
        }

        public Criteria andTempCodeIn(List<String> values) {
            addCriterion("temp_code in", values, "tempCode");
            return (Criteria) this;
        }

        public Criteria andTempCodeNotIn(List<String> values) {
            addCriterion("temp_code not in", values, "tempCode");
            return (Criteria) this;
        }

        public Criteria andTempCodeBetween(String value1, String value2) {
            addCriterion("temp_code between", value1, value2, "tempCode");
            return (Criteria) this;
        }

        public Criteria andTempCodeNotBetween(String value1, String value2) {
            addCriterion("temp_code not between", value1, value2, "tempCode");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}