package com.litbo.hospital.lifemanage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SgDxyxzbkcExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgDxyxzbkcExample() {
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

        public Criteria andDxzbIdIsNull() {
            addCriterion("dxzb_id is null");
            return (Criteria) this;
        }

        public Criteria andDxzbIdIsNotNull() {
            addCriterion("dxzb_id is not null");
            return (Criteria) this;
        }

        public Criteria andDxzbIdEqualTo(String value) {
            addCriterion("dxzb_id =", value, "dxzbId");
            return (Criteria) this;
        }

        public Criteria andDxzbIdNotEqualTo(String value) {
            addCriterion("dxzb_id <>", value, "dxzbId");
            return (Criteria) this;
        }

        public Criteria andDxzbIdGreaterThan(String value) {
            addCriterion("dxzb_id >", value, "dxzbId");
            return (Criteria) this;
        }

        public Criteria andDxzbIdGreaterThanOrEqualTo(String value) {
            addCriterion("dxzb_id >=", value, "dxzbId");
            return (Criteria) this;
        }

        public Criteria andDxzbIdLessThan(String value) {
            addCriterion("dxzb_id <", value, "dxzbId");
            return (Criteria) this;
        }

        public Criteria andDxzbIdLessThanOrEqualTo(String value) {
            addCriterion("dxzb_id <=", value, "dxzbId");
            return (Criteria) this;
        }

        public Criteria andDxzbIdLike(String value) {
            addCriterion("dxzb_id like", value, "dxzbId");
            return (Criteria) this;
        }

        public Criteria andDxzbIdNotLike(String value) {
            addCriterion("dxzb_id not like", value, "dxzbId");
            return (Criteria) this;
        }

        public Criteria andDxzbIdIn(List<String> values) {
            addCriterion("dxzb_id in", values, "dxzbId");
            return (Criteria) this;
        }

        public Criteria andDxzbIdNotIn(List<String> values) {
            addCriterion("dxzb_id not in", values, "dxzbId");
            return (Criteria) this;
        }

        public Criteria andDxzbIdBetween(String value1, String value2) {
            addCriterion("dxzb_id between", value1, value2, "dxzbId");
            return (Criteria) this;
        }

        public Criteria andDxzbIdNotBetween(String value1, String value2) {
            addCriterion("dxzb_id not between", value1, value2, "dxzbId");
            return (Criteria) this;
        }

        public Criteria andDxzbSjIsNull() {
            addCriterion("dxzb_sj is null");
            return (Criteria) this;
        }

        public Criteria andDxzbSjIsNotNull() {
            addCriterion("dxzb_sj is not null");
            return (Criteria) this;
        }

        public Criteria andDxzbSjEqualTo(Date value) {
            addCriterion("dxzb_sj =", value, "dxzbSj");
            return (Criteria) this;
        }

        public Criteria andDxzbSjNotEqualTo(Date value) {
            addCriterion("dxzb_sj <>", value, "dxzbSj");
            return (Criteria) this;
        }

        public Criteria andDxzbSjGreaterThan(Date value) {
            addCriterion("dxzb_sj >", value, "dxzbSj");
            return (Criteria) this;
        }

        public Criteria andDxzbSjGreaterThanOrEqualTo(Date value) {
            addCriterion("dxzb_sj >=", value, "dxzbSj");
            return (Criteria) this;
        }

        public Criteria andDxzbSjLessThan(Date value) {
            addCriterion("dxzb_sj <", value, "dxzbSj");
            return (Criteria) this;
        }

        public Criteria andDxzbSjLessThanOrEqualTo(Date value) {
            addCriterion("dxzb_sj <=", value, "dxzbSj");
            return (Criteria) this;
        }

        public Criteria andDxzbSjIn(List<Date> values) {
            addCriterion("dxzb_sj in", values, "dxzbSj");
            return (Criteria) this;
        }

        public Criteria andDxzbSjNotIn(List<Date> values) {
            addCriterion("dxzb_sj not in", values, "dxzbSj");
            return (Criteria) this;
        }

        public Criteria andDxzbSjBetween(Date value1, Date value2) {
            addCriterion("dxzb_sj between", value1, value2, "dxzbSj");
            return (Criteria) this;
        }

        public Criteria andDxzbSjNotBetween(Date value1, Date value2) {
            addCriterion("dxzb_sj not between", value1, value2, "dxzbSj");
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