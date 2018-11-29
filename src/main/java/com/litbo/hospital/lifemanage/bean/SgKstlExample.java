package com.litbo.hospital.lifemanage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SgKstlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgKstlExample() {
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

        public Criteria andKstlIdIsNull() {
            addCriterion("kstl_id is null");
            return (Criteria) this;
        }

        public Criteria andKstlIdIsNotNull() {
            addCriterion("kstl_id is not null");
            return (Criteria) this;
        }

        public Criteria andKstlIdEqualTo(String value) {
            addCriterion("kstl_id =", value, "kstlId");
            return (Criteria) this;
        }

        public Criteria andKstlIdNotEqualTo(String value) {
            addCriterion("kstl_id <>", value, "kstlId");
            return (Criteria) this;
        }

        public Criteria andKstlIdGreaterThan(String value) {
            addCriterion("kstl_id >", value, "kstlId");
            return (Criteria) this;
        }

        public Criteria andKstlIdGreaterThanOrEqualTo(String value) {
            addCriterion("kstl_id >=", value, "kstlId");
            return (Criteria) this;
        }

        public Criteria andKstlIdLessThan(String value) {
            addCriterion("kstl_id <", value, "kstlId");
            return (Criteria) this;
        }

        public Criteria andKstlIdLessThanOrEqualTo(String value) {
            addCriterion("kstl_id <=", value, "kstlId");
            return (Criteria) this;
        }

        public Criteria andKstlIdLike(String value) {
            addCriterion("kstl_id like", value, "kstlId");
            return (Criteria) this;
        }

        public Criteria andKstlIdNotLike(String value) {
            addCriterion("kstl_id not like", value, "kstlId");
            return (Criteria) this;
        }

        public Criteria andKstlIdIn(List<String> values) {
            addCriterion("kstl_id in", values, "kstlId");
            return (Criteria) this;
        }

        public Criteria andKstlIdNotIn(List<String> values) {
            addCriterion("kstl_id not in", values, "kstlId");
            return (Criteria) this;
        }

        public Criteria andKstlIdBetween(String value1, String value2) {
            addCriterion("kstl_id between", value1, value2, "kstlId");
            return (Criteria) this;
        }

        public Criteria andKstlIdNotBetween(String value1, String value2) {
            addCriterion("kstl_id not between", value1, value2, "kstlId");
            return (Criteria) this;
        }

        public Criteria andUserIdJlIsNull() {
            addCriterion("user_id_jl is null");
            return (Criteria) this;
        }

        public Criteria andUserIdJlIsNotNull() {
            addCriterion("user_id_jl is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdJlEqualTo(String value) {
            addCriterion("user_id_jl =", value, "userIdJl");
            return (Criteria) this;
        }

        public Criteria andUserIdJlNotEqualTo(String value) {
            addCriterion("user_id_jl <>", value, "userIdJl");
            return (Criteria) this;
        }

        public Criteria andUserIdJlGreaterThan(String value) {
            addCriterion("user_id_jl >", value, "userIdJl");
            return (Criteria) this;
        }

        public Criteria andUserIdJlGreaterThanOrEqualTo(String value) {
            addCriterion("user_id_jl >=", value, "userIdJl");
            return (Criteria) this;
        }

        public Criteria andUserIdJlLessThan(String value) {
            addCriterion("user_id_jl <", value, "userIdJl");
            return (Criteria) this;
        }

        public Criteria andUserIdJlLessThanOrEqualTo(String value) {
            addCriterion("user_id_jl <=", value, "userIdJl");
            return (Criteria) this;
        }

        public Criteria andUserIdJlLike(String value) {
            addCriterion("user_id_jl like", value, "userIdJl");
            return (Criteria) this;
        }

        public Criteria andUserIdJlNotLike(String value) {
            addCriterion("user_id_jl not like", value, "userIdJl");
            return (Criteria) this;
        }

        public Criteria andUserIdJlIn(List<String> values) {
            addCriterion("user_id_jl in", values, "userIdJl");
            return (Criteria) this;
        }

        public Criteria andUserIdJlNotIn(List<String> values) {
            addCriterion("user_id_jl not in", values, "userIdJl");
            return (Criteria) this;
        }

        public Criteria andUserIdJlBetween(String value1, String value2) {
            addCriterion("user_id_jl between", value1, value2, "userIdJl");
            return (Criteria) this;
        }

        public Criteria andUserIdJlNotBetween(String value1, String value2) {
            addCriterion("user_id_jl not between", value1, value2, "userIdJl");
            return (Criteria) this;
        }

        public Criteria andBmIdIsNull() {
            addCriterion("bm_id is null");
            return (Criteria) this;
        }

        public Criteria andBmIdIsNotNull() {
            addCriterion("bm_id is not null");
            return (Criteria) this;
        }

        public Criteria andBmIdEqualTo(String value) {
            addCriterion("bm_id =", value, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdNotEqualTo(String value) {
            addCriterion("bm_id <>", value, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdGreaterThan(String value) {
            addCriterion("bm_id >", value, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdGreaterThanOrEqualTo(String value) {
            addCriterion("bm_id >=", value, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdLessThan(String value) {
            addCriterion("bm_id <", value, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdLessThanOrEqualTo(String value) {
            addCriterion("bm_id <=", value, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdLike(String value) {
            addCriterion("bm_id like", value, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdNotLike(String value) {
            addCriterion("bm_id not like", value, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdIn(List<String> values) {
            addCriterion("bm_id in", values, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdNotIn(List<String> values) {
            addCriterion("bm_id not in", values, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdBetween(String value1, String value2) {
            addCriterion("bm_id between", value1, value2, "bmId");
            return (Criteria) this;
        }

        public Criteria andBmIdNotBetween(String value1, String value2) {
            addCriterion("bm_id not between", value1, value2, "bmId");
            return (Criteria) this;
        }

        public Criteria andKstlTimeIsNull() {
            addCriterion("kstl_time is null");
            return (Criteria) this;
        }

        public Criteria andKstlTimeIsNotNull() {
            addCriterion("kstl_time is not null");
            return (Criteria) this;
        }

        public Criteria andKstlTimeEqualTo(Date value) {
            addCriterion("kstl_time =", value, "kstlTime");
            return (Criteria) this;
        }

        public Criteria andKstlTimeNotEqualTo(Date value) {
            addCriterion("kstl_time <>", value, "kstlTime");
            return (Criteria) this;
        }

        public Criteria andKstlTimeGreaterThan(Date value) {
            addCriterion("kstl_time >", value, "kstlTime");
            return (Criteria) this;
        }

        public Criteria andKstlTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("kstl_time >=", value, "kstlTime");
            return (Criteria) this;
        }

        public Criteria andKstlTimeLessThan(Date value) {
            addCriterion("kstl_time <", value, "kstlTime");
            return (Criteria) this;
        }

        public Criteria andKstlTimeLessThanOrEqualTo(Date value) {
            addCriterion("kstl_time <=", value, "kstlTime");
            return (Criteria) this;
        }

        public Criteria andKstlTimeIn(List<Date> values) {
            addCriterion("kstl_time in", values, "kstlTime");
            return (Criteria) this;
        }

        public Criteria andKstlTimeNotIn(List<Date> values) {
            addCriterion("kstl_time not in", values, "kstlTime");
            return (Criteria) this;
        }

        public Criteria andKstlTimeBetween(Date value1, Date value2) {
            addCriterion("kstl_time between", value1, value2, "kstlTime");
            return (Criteria) this;
        }

        public Criteria andKstlTimeNotBetween(Date value1, Date value2) {
            addCriterion("kstl_time not between", value1, value2, "kstlTime");
            return (Criteria) this;
        }

        public Criteria andKstlAddrIsNull() {
            addCriterion("kstl_addr is null");
            return (Criteria) this;
        }

        public Criteria andKstlAddrIsNotNull() {
            addCriterion("kstl_addr is not null");
            return (Criteria) this;
        }

        public Criteria andKstlAddrEqualTo(String value) {
            addCriterion("kstl_addr =", value, "kstlAddr");
            return (Criteria) this;
        }

        public Criteria andKstlAddrNotEqualTo(String value) {
            addCriterion("kstl_addr <>", value, "kstlAddr");
            return (Criteria) this;
        }

        public Criteria andKstlAddrGreaterThan(String value) {
            addCriterion("kstl_addr >", value, "kstlAddr");
            return (Criteria) this;
        }

        public Criteria andKstlAddrGreaterThanOrEqualTo(String value) {
            addCriterion("kstl_addr >=", value, "kstlAddr");
            return (Criteria) this;
        }

        public Criteria andKstlAddrLessThan(String value) {
            addCriterion("kstl_addr <", value, "kstlAddr");
            return (Criteria) this;
        }

        public Criteria andKstlAddrLessThanOrEqualTo(String value) {
            addCriterion("kstl_addr <=", value, "kstlAddr");
            return (Criteria) this;
        }

        public Criteria andKstlAddrLike(String value) {
            addCriterion("kstl_addr like", value, "kstlAddr");
            return (Criteria) this;
        }

        public Criteria andKstlAddrNotLike(String value) {
            addCriterion("kstl_addr not like", value, "kstlAddr");
            return (Criteria) this;
        }

        public Criteria andKstlAddrIn(List<String> values) {
            addCriterion("kstl_addr in", values, "kstlAddr");
            return (Criteria) this;
        }

        public Criteria andKstlAddrNotIn(List<String> values) {
            addCriterion("kstl_addr not in", values, "kstlAddr");
            return (Criteria) this;
        }

        public Criteria andKstlAddrBetween(String value1, String value2) {
            addCriterion("kstl_addr between", value1, value2, "kstlAddr");
            return (Criteria) this;
        }

        public Criteria andKstlAddrNotBetween(String value1, String value2) {
            addCriterion("kstl_addr not between", value1, value2, "kstlAddr");
            return (Criteria) this;
        }

        public Criteria andExtendOneIsNull() {
            addCriterion("extend_one is null");
            return (Criteria) this;
        }

        public Criteria andExtendOneIsNotNull() {
            addCriterion("extend_one is not null");
            return (Criteria) this;
        }

        public Criteria andExtendOneEqualTo(String value) {
            addCriterion("extend_one =", value, "extendOne");
            return (Criteria) this;
        }

        public Criteria andExtendOneNotEqualTo(String value) {
            addCriterion("extend_one <>", value, "extendOne");
            return (Criteria) this;
        }

        public Criteria andExtendOneGreaterThan(String value) {
            addCriterion("extend_one >", value, "extendOne");
            return (Criteria) this;
        }

        public Criteria andExtendOneGreaterThanOrEqualTo(String value) {
            addCriterion("extend_one >=", value, "extendOne");
            return (Criteria) this;
        }

        public Criteria andExtendOneLessThan(String value) {
            addCriterion("extend_one <", value, "extendOne");
            return (Criteria) this;
        }

        public Criteria andExtendOneLessThanOrEqualTo(String value) {
            addCriterion("extend_one <=", value, "extendOne");
            return (Criteria) this;
        }

        public Criteria andExtendOneLike(String value) {
            addCriterion("extend_one like", value, "extendOne");
            return (Criteria) this;
        }

        public Criteria andExtendOneNotLike(String value) {
            addCriterion("extend_one not like", value, "extendOne");
            return (Criteria) this;
        }

        public Criteria andExtendOneIn(List<String> values) {
            addCriterion("extend_one in", values, "extendOne");
            return (Criteria) this;
        }

        public Criteria andExtendOneNotIn(List<String> values) {
            addCriterion("extend_one not in", values, "extendOne");
            return (Criteria) this;
        }

        public Criteria andExtendOneBetween(String value1, String value2) {
            addCriterion("extend_one between", value1, value2, "extendOne");
            return (Criteria) this;
        }

        public Criteria andExtendOneNotBetween(String value1, String value2) {
            addCriterion("extend_one not between", value1, value2, "extendOne");
            return (Criteria) this;
        }

        public Criteria andExtendTwoIsNull() {
            addCriterion("extend_two is null");
            return (Criteria) this;
        }

        public Criteria andExtendTwoIsNotNull() {
            addCriterion("extend_two is not null");
            return (Criteria) this;
        }

        public Criteria andExtendTwoEqualTo(String value) {
            addCriterion("extend_two =", value, "extendTwo");
            return (Criteria) this;
        }

        public Criteria andExtendTwoNotEqualTo(String value) {
            addCriterion("extend_two <>", value, "extendTwo");
            return (Criteria) this;
        }

        public Criteria andExtendTwoGreaterThan(String value) {
            addCriterion("extend_two >", value, "extendTwo");
            return (Criteria) this;
        }

        public Criteria andExtendTwoGreaterThanOrEqualTo(String value) {
            addCriterion("extend_two >=", value, "extendTwo");
            return (Criteria) this;
        }

        public Criteria andExtendTwoLessThan(String value) {
            addCriterion("extend_two <", value, "extendTwo");
            return (Criteria) this;
        }

        public Criteria andExtendTwoLessThanOrEqualTo(String value) {
            addCriterion("extend_two <=", value, "extendTwo");
            return (Criteria) this;
        }

        public Criteria andExtendTwoLike(String value) {
            addCriterion("extend_two like", value, "extendTwo");
            return (Criteria) this;
        }

        public Criteria andExtendTwoNotLike(String value) {
            addCriterion("extend_two not like", value, "extendTwo");
            return (Criteria) this;
        }

        public Criteria andExtendTwoIn(List<String> values) {
            addCriterion("extend_two in", values, "extendTwo");
            return (Criteria) this;
        }

        public Criteria andExtendTwoNotIn(List<String> values) {
            addCriterion("extend_two not in", values, "extendTwo");
            return (Criteria) this;
        }

        public Criteria andExtendTwoBetween(String value1, String value2) {
            addCriterion("extend_two between", value1, value2, "extendTwo");
            return (Criteria) this;
        }

        public Criteria andExtendTwoNotBetween(String value1, String value2) {
            addCriterion("extend_two not between", value1, value2, "extendTwo");
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