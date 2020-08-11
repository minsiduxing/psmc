package priv.guochun.psmc.website.backstage.message.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TabMessageTempExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabMessageTempExample() {
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

        public Criteria andTempUuidIsNull() {
            addCriterion("temp_uuid is null");
            return (Criteria) this;
        }

        public Criteria andTempUuidIsNotNull() {
            addCriterion("temp_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andTempUuidEqualTo(String value) {
            addCriterion("temp_uuid =", value, "tempUuid");
            return (Criteria) this;
        }

        public Criteria andTempUuidNotEqualTo(String value) {
            addCriterion("temp_uuid <>", value, "tempUuid");
            return (Criteria) this;
        }

        public Criteria andTempUuidGreaterThan(String value) {
            addCriterion("temp_uuid >", value, "tempUuid");
            return (Criteria) this;
        }

        public Criteria andTempUuidGreaterThanOrEqualTo(String value) {
            addCriterion("temp_uuid >=", value, "tempUuid");
            return (Criteria) this;
        }

        public Criteria andTempUuidLessThan(String value) {
            addCriterion("temp_uuid <", value, "tempUuid");
            return (Criteria) this;
        }

        public Criteria andTempUuidLessThanOrEqualTo(String value) {
            addCriterion("temp_uuid <=", value, "tempUuid");
            return (Criteria) this;
        }

        public Criteria andTempUuidLike(String value) {
            addCriterion("temp_uuid like", value, "tempUuid");
            return (Criteria) this;
        }

        public Criteria andTempUuidNotLike(String value) {
            addCriterion("temp_uuid not like", value, "tempUuid");
            return (Criteria) this;
        }

        public Criteria andTempUuidIn(List<String> values) {
            addCriterion("temp_uuid in", values, "tempUuid");
            return (Criteria) this;
        }

        public Criteria andTempUuidNotIn(List<String> values) {
            addCriterion("temp_uuid not in", values, "tempUuid");
            return (Criteria) this;
        }

        public Criteria andTempUuidBetween(String value1, String value2) {
            addCriterion("temp_uuid between", value1, value2, "tempUuid");
            return (Criteria) this;
        }

        public Criteria andTempUuidNotBetween(String value1, String value2) {
            addCriterion("temp_uuid not between", value1, value2, "tempUuid");
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

        public Criteria andTempContentIsNull() {
            addCriterion("temp_content is null");
            return (Criteria) this;
        }

        public Criteria andTempContentIsNotNull() {
            addCriterion("temp_content is not null");
            return (Criteria) this;
        }

        public Criteria andTempContentEqualTo(String value) {
            addCriterion("temp_content =", value, "tempContent");
            return (Criteria) this;
        }

        public Criteria andTempContentNotEqualTo(String value) {
            addCriterion("temp_content <>", value, "tempContent");
            return (Criteria) this;
        }

        public Criteria andTempContentGreaterThan(String value) {
            addCriterion("temp_content >", value, "tempContent");
            return (Criteria) this;
        }

        public Criteria andTempContentGreaterThanOrEqualTo(String value) {
            addCriterion("temp_content >=", value, "tempContent");
            return (Criteria) this;
        }

        public Criteria andTempContentLessThan(String value) {
            addCriterion("temp_content <", value, "tempContent");
            return (Criteria) this;
        }

        public Criteria andTempContentLessThanOrEqualTo(String value) {
            addCriterion("temp_content <=", value, "tempContent");
            return (Criteria) this;
        }

        public Criteria andTempContentLike(String value) {
            addCriterion("temp_content like", value, "tempContent");
            return (Criteria) this;
        }

        public Criteria andTempContentNotLike(String value) {
            addCriterion("temp_content not like", value, "tempContent");
            return (Criteria) this;
        }

        public Criteria andTempContentIn(List<String> values) {
            addCriterion("temp_content in", values, "tempContent");
            return (Criteria) this;
        }

        public Criteria andTempContentNotIn(List<String> values) {
            addCriterion("temp_content not in", values, "tempContent");
            return (Criteria) this;
        }

        public Criteria andTempContentBetween(String value1, String value2) {
            addCriterion("temp_content between", value1, value2, "tempContent");
            return (Criteria) this;
        }

        public Criteria andTempContentNotBetween(String value1, String value2) {
            addCriterion("temp_content not between", value1, value2, "tempContent");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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