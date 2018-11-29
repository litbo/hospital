package com.litbo.hospital.lifemanage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SgYbghhyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgYbghhyExample() {
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

        public Criteria andYbghhyIdIsNull() {
            addCriterion("ybghhy_id is null");
            return (Criteria) this;
        }

        public Criteria andYbghhyIdIsNotNull() {
            addCriterion("ybghhy_id is not null");
            return (Criteria) this;
        }

        public Criteria andYbghhyIdEqualTo(String value) {
            addCriterion("ybghhy_id =", value, "ybghhyId");
            return (Criteria) this;
        }

        public Criteria andYbghhyIdNotEqualTo(String value) {
            addCriterion("ybghhy_id <>", value, "ybghhyId");
            return (Criteria) this;
        }

        public Criteria andYbghhyIdGreaterThan(String value) {
            addCriterion("ybghhy_id >", value, "ybghhyId");
            return (Criteria) this;
        }

        public Criteria andYbghhyIdGreaterThanOrEqualTo(String value) {
            addCriterion("ybghhy_id >=", value, "ybghhyId");
            return (Criteria) this;
        }

        public Criteria andYbghhyIdLessThan(String value) {
            addCriterion("ybghhy_id <", value, "ybghhyId");
            return (Criteria) this;
        }

        public Criteria andYbghhyIdLessThanOrEqualTo(String value) {
            addCriterion("ybghhy_id <=", value, "ybghhyId");
            return (Criteria) this;
        }

        public Criteria andYbghhyIdLike(String value) {
            addCriterion("ybghhy_id like", value, "ybghhyId");
            return (Criteria) this;
        }

        public Criteria andYbghhyIdNotLike(String value) {
            addCriterion("ybghhy_id not like", value, "ybghhyId");
            return (Criteria) this;
        }

        public Criteria andYbghhyIdIn(List<String> values) {
            addCriterion("ybghhy_id in", values, "ybghhyId");
            return (Criteria) this;
        }

        public Criteria andYbghhyIdNotIn(List<String> values) {
            addCriterion("ybghhy_id not in", values, "ybghhyId");
            return (Criteria) this;
        }

        public Criteria andYbghhyIdBetween(String value1, String value2) {
            addCriterion("ybghhy_id between", value1, value2, "ybghhyId");
            return (Criteria) this;
        }

        public Criteria andYbghhyIdNotBetween(String value1, String value2) {
            addCriterion("ybghhy_id not between", value1, value2, "ybghhyId");
            return (Criteria) this;
        }

        public Criteria andYbghhySjyIsNull() {
            addCriterion("ybghhy_sjy is null");
            return (Criteria) this;
        }

        public Criteria andYbghhySjyIsNotNull() {
            addCriterion("ybghhy_sjy is not null");
            return (Criteria) this;
        }

        public Criteria andYbghhySjyEqualTo(String value) {
            addCriterion("ybghhy_sjy =", value, "ybghhySjy");
            return (Criteria) this;
        }

        public Criteria andYbghhySjyNotEqualTo(String value) {
            addCriterion("ybghhy_sjy <>", value, "ybghhySjy");
            return (Criteria) this;
        }

        public Criteria andYbghhySjyGreaterThan(String value) {
            addCriterion("ybghhy_sjy >", value, "ybghhySjy");
            return (Criteria) this;
        }

        public Criteria andYbghhySjyGreaterThanOrEqualTo(String value) {
            addCriterion("ybghhy_sjy >=", value, "ybghhySjy");
            return (Criteria) this;
        }

        public Criteria andYbghhySjyLessThan(String value) {
            addCriterion("ybghhy_sjy <", value, "ybghhySjy");
            return (Criteria) this;
        }

        public Criteria andYbghhySjyLessThanOrEqualTo(String value) {
            addCriterion("ybghhy_sjy <=", value, "ybghhySjy");
            return (Criteria) this;
        }

        public Criteria andYbghhySjyLike(String value) {
            addCriterion("ybghhy_sjy like", value, "ybghhySjy");
            return (Criteria) this;
        }

        public Criteria andYbghhySjyNotLike(String value) {
            addCriterion("ybghhy_sjy not like", value, "ybghhySjy");
            return (Criteria) this;
        }

        public Criteria andYbghhySjyIn(List<String> values) {
            addCriterion("ybghhy_sjy in", values, "ybghhySjy");
            return (Criteria) this;
        }

        public Criteria andYbghhySjyNotIn(List<String> values) {
            addCriterion("ybghhy_sjy not in", values, "ybghhySjy");
            return (Criteria) this;
        }

        public Criteria andYbghhySjyBetween(String value1, String value2) {
            addCriterion("ybghhy_sjy between", value1, value2, "ybghhySjy");
            return (Criteria) this;
        }

        public Criteria andYbghhySjyNotBetween(String value1, String value2) {
            addCriterion("ybghhy_sjy not between", value1, value2, "ybghhySjy");
            return (Criteria) this;
        }

        public Criteria andYbghhySjIsNull() {
            addCriterion("ybghhy_sj is null");
            return (Criteria) this;
        }

        public Criteria andYbghhySjIsNotNull() {
            addCriterion("ybghhy_sj is not null");
            return (Criteria) this;
        }

        public Criteria andYbghhySjEqualTo(Date value) {
            addCriterion("ybghhy_sj =", value, "ybghhySj");
            return (Criteria) this;
        }

        public Criteria andYbghhySjNotEqualTo(Date value) {
            addCriterion("ybghhy_sj <>", value, "ybghhySj");
            return (Criteria) this;
        }

        public Criteria andYbghhySjGreaterThan(Date value) {
            addCriterion("ybghhy_sj >", value, "ybghhySj");
            return (Criteria) this;
        }

        public Criteria andYbghhySjGreaterThanOrEqualTo(Date value) {
            addCriterion("ybghhy_sj >=", value, "ybghhySj");
            return (Criteria) this;
        }

        public Criteria andYbghhySjLessThan(Date value) {
            addCriterion("ybghhy_sj <", value, "ybghhySj");
            return (Criteria) this;
        }

        public Criteria andYbghhySjLessThanOrEqualTo(Date value) {
            addCriterion("ybghhy_sj <=", value, "ybghhySj");
            return (Criteria) this;
        }

        public Criteria andYbghhySjIn(List<Date> values) {
            addCriterion("ybghhy_sj in", values, "ybghhySj");
            return (Criteria) this;
        }

        public Criteria andYbghhySjNotIn(List<Date> values) {
            addCriterion("ybghhy_sj not in", values, "ybghhySj");
            return (Criteria) this;
        }

        public Criteria andYbghhySjBetween(Date value1, Date value2) {
            addCriterion("ybghhy_sj between", value1, value2, "ybghhySj");
            return (Criteria) this;
        }

        public Criteria andYbghhySjNotBetween(Date value1, Date value2) {
            addCriterion("ybghhy_sj not between", value1, value2, "ybghhySj");
            return (Criteria) this;
        }

        public Criteria andYbghhyDdIsNull() {
            addCriterion("ybghhy_dd is null");
            return (Criteria) this;
        }

        public Criteria andYbghhyDdIsNotNull() {
            addCriterion("ybghhy_dd is not null");
            return (Criteria) this;
        }

        public Criteria andYbghhyDdEqualTo(String value) {
            addCriterion("ybghhy_dd =", value, "ybghhyDd");
            return (Criteria) this;
        }

        public Criteria andYbghhyDdNotEqualTo(String value) {
            addCriterion("ybghhy_dd <>", value, "ybghhyDd");
            return (Criteria) this;
        }

        public Criteria andYbghhyDdGreaterThan(String value) {
            addCriterion("ybghhy_dd >", value, "ybghhyDd");
            return (Criteria) this;
        }

        public Criteria andYbghhyDdGreaterThanOrEqualTo(String value) {
            addCriterion("ybghhy_dd >=", value, "ybghhyDd");
            return (Criteria) this;
        }

        public Criteria andYbghhyDdLessThan(String value) {
            addCriterion("ybghhy_dd <", value, "ybghhyDd");
            return (Criteria) this;
        }

        public Criteria andYbghhyDdLessThanOrEqualTo(String value) {
            addCriterion("ybghhy_dd <=", value, "ybghhyDd");
            return (Criteria) this;
        }

        public Criteria andYbghhyDdLike(String value) {
            addCriterion("ybghhy_dd like", value, "ybghhyDd");
            return (Criteria) this;
        }

        public Criteria andYbghhyDdNotLike(String value) {
            addCriterion("ybghhy_dd not like", value, "ybghhyDd");
            return (Criteria) this;
        }

        public Criteria andYbghhyDdIn(List<String> values) {
            addCriterion("ybghhy_dd in", values, "ybghhyDd");
            return (Criteria) this;
        }

        public Criteria andYbghhyDdNotIn(List<String> values) {
            addCriterion("ybghhy_dd not in", values, "ybghhyDd");
            return (Criteria) this;
        }

        public Criteria andYbghhyDdBetween(String value1, String value2) {
            addCriterion("ybghhy_dd between", value1, value2, "ybghhyDd");
            return (Criteria) this;
        }

        public Criteria andYbghhyDdNotBetween(String value1, String value2) {
            addCriterion("ybghhy_dd not between", value1, value2, "ybghhyDd");
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