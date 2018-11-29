package com.litbo.hospital.lifemanage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SgLssqExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgLssqExample() {
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

        public Criteria andLssqIdIsNull() {
            addCriterion("lssq_id is null");
            return (Criteria) this;
        }

        public Criteria andLssqIdIsNotNull() {
            addCriterion("lssq_id is not null");
            return (Criteria) this;
        }

        public Criteria andLssqIdEqualTo(String value) {
            addCriterion("lssq_id =", value, "lssqId");
            return (Criteria) this;
        }

        public Criteria andLssqIdNotEqualTo(String value) {
            addCriterion("lssq_id <>", value, "lssqId");
            return (Criteria) this;
        }

        public Criteria andLssqIdGreaterThan(String value) {
            addCriterion("lssq_id >", value, "lssqId");
            return (Criteria) this;
        }

        public Criteria andLssqIdGreaterThanOrEqualTo(String value) {
            addCriterion("lssq_id >=", value, "lssqId");
            return (Criteria) this;
        }

        public Criteria andLssqIdLessThan(String value) {
            addCriterion("lssq_id <", value, "lssqId");
            return (Criteria) this;
        }

        public Criteria andLssqIdLessThanOrEqualTo(String value) {
            addCriterion("lssq_id <=", value, "lssqId");
            return (Criteria) this;
        }

        public Criteria andLssqIdLike(String value) {
            addCriterion("lssq_id like", value, "lssqId");
            return (Criteria) this;
        }

        public Criteria andLssqIdNotLike(String value) {
            addCriterion("lssq_id not like", value, "lssqId");
            return (Criteria) this;
        }

        public Criteria andLssqIdIn(List<String> values) {
            addCriterion("lssq_id in", values, "lssqId");
            return (Criteria) this;
        }

        public Criteria andLssqIdNotIn(List<String> values) {
            addCriterion("lssq_id not in", values, "lssqId");
            return (Criteria) this;
        }

        public Criteria andLssqIdBetween(String value1, String value2) {
            addCriterion("lssq_id between", value1, value2, "lssqId");
            return (Criteria) this;
        }

        public Criteria andLssqIdNotBetween(String value1, String value2) {
            addCriterion("lssq_id not between", value1, value2, "lssqId");
            return (Criteria) this;
        }

        public Criteria andLssqSqrIsNull() {
            addCriterion("lssq_sqr is null");
            return (Criteria) this;
        }

        public Criteria andLssqSqrIsNotNull() {
            addCriterion("lssq_sqr is not null");
            return (Criteria) this;
        }

        public Criteria andLssqSqrEqualTo(String value) {
            addCriterion("lssq_sqr =", value, "lssqSqr");
            return (Criteria) this;
        }

        public Criteria andLssqSqrNotEqualTo(String value) {
            addCriterion("lssq_sqr <>", value, "lssqSqr");
            return (Criteria) this;
        }

        public Criteria andLssqSqrGreaterThan(String value) {
            addCriterion("lssq_sqr >", value, "lssqSqr");
            return (Criteria) this;
        }

        public Criteria andLssqSqrGreaterThanOrEqualTo(String value) {
            addCriterion("lssq_sqr >=", value, "lssqSqr");
            return (Criteria) this;
        }

        public Criteria andLssqSqrLessThan(String value) {
            addCriterion("lssq_sqr <", value, "lssqSqr");
            return (Criteria) this;
        }

        public Criteria andLssqSqrLessThanOrEqualTo(String value) {
            addCriterion("lssq_sqr <=", value, "lssqSqr");
            return (Criteria) this;
        }

        public Criteria andLssqSqrLike(String value) {
            addCriterion("lssq_sqr like", value, "lssqSqr");
            return (Criteria) this;
        }

        public Criteria andLssqSqrNotLike(String value) {
            addCriterion("lssq_sqr not like", value, "lssqSqr");
            return (Criteria) this;
        }

        public Criteria andLssqSqrIn(List<String> values) {
            addCriterion("lssq_sqr in", values, "lssqSqr");
            return (Criteria) this;
        }

        public Criteria andLssqSqrNotIn(List<String> values) {
            addCriterion("lssq_sqr not in", values, "lssqSqr");
            return (Criteria) this;
        }

        public Criteria andLssqSqrBetween(String value1, String value2) {
            addCriterion("lssq_sqr between", value1, value2, "lssqSqr");
            return (Criteria) this;
        }

        public Criteria andLssqSqrNotBetween(String value1, String value2) {
            addCriterion("lssq_sqr not between", value1, value2, "lssqSqr");
            return (Criteria) this;
        }

        public Criteria andLssqBsqrIsNull() {
            addCriterion("lssq_bsqr is null");
            return (Criteria) this;
        }

        public Criteria andLssqBsqrIsNotNull() {
            addCriterion("lssq_bsqr is not null");
            return (Criteria) this;
        }

        public Criteria andLssqBsqrEqualTo(String value) {
            addCriterion("lssq_bsqr =", value, "lssqBsqr");
            return (Criteria) this;
        }

        public Criteria andLssqBsqrNotEqualTo(String value) {
            addCriterion("lssq_bsqr <>", value, "lssqBsqr");
            return (Criteria) this;
        }

        public Criteria andLssqBsqrGreaterThan(String value) {
            addCriterion("lssq_bsqr >", value, "lssqBsqr");
            return (Criteria) this;
        }

        public Criteria andLssqBsqrGreaterThanOrEqualTo(String value) {
            addCriterion("lssq_bsqr >=", value, "lssqBsqr");
            return (Criteria) this;
        }

        public Criteria andLssqBsqrLessThan(String value) {
            addCriterion("lssq_bsqr <", value, "lssqBsqr");
            return (Criteria) this;
        }

        public Criteria andLssqBsqrLessThanOrEqualTo(String value) {
            addCriterion("lssq_bsqr <=", value, "lssqBsqr");
            return (Criteria) this;
        }

        public Criteria andLssqBsqrLike(String value) {
            addCriterion("lssq_bsqr like", value, "lssqBsqr");
            return (Criteria) this;
        }

        public Criteria andLssqBsqrNotLike(String value) {
            addCriterion("lssq_bsqr not like", value, "lssqBsqr");
            return (Criteria) this;
        }

        public Criteria andLssqBsqrIn(List<String> values) {
            addCriterion("lssq_bsqr in", values, "lssqBsqr");
            return (Criteria) this;
        }

        public Criteria andLssqBsqrNotIn(List<String> values) {
            addCriterion("lssq_bsqr not in", values, "lssqBsqr");
            return (Criteria) this;
        }

        public Criteria andLssqBsqrBetween(String value1, String value2) {
            addCriterion("lssq_bsqr between", value1, value2, "lssqBsqr");
            return (Criteria) this;
        }

        public Criteria andLssqBsqrNotBetween(String value1, String value2) {
            addCriterion("lssq_bsqr not between", value1, value2, "lssqBsqr");
            return (Criteria) this;
        }

        public Criteria andLssqSqrqIsNull() {
            addCriterion("lssq_sqrq is null");
            return (Criteria) this;
        }

        public Criteria andLssqSqrqIsNotNull() {
            addCriterion("lssq_sqrq is not null");
            return (Criteria) this;
        }

        public Criteria andLssqSqrqEqualTo(Date value) {
            addCriterion("lssq_sqrq =", value, "lssqSqrq");
            return (Criteria) this;
        }

        public Criteria andLssqSqrqNotEqualTo(Date value) {
            addCriterion("lssq_sqrq <>", value, "lssqSqrq");
            return (Criteria) this;
        }

        public Criteria andLssqSqrqGreaterThan(Date value) {
            addCriterion("lssq_sqrq >", value, "lssqSqrq");
            return (Criteria) this;
        }

        public Criteria andLssqSqrqGreaterThanOrEqualTo(Date value) {
            addCriterion("lssq_sqrq >=", value, "lssqSqrq");
            return (Criteria) this;
        }

        public Criteria andLssqSqrqLessThan(Date value) {
            addCriterion("lssq_sqrq <", value, "lssqSqrq");
            return (Criteria) this;
        }

        public Criteria andLssqSqrqLessThanOrEqualTo(Date value) {
            addCriterion("lssq_sqrq <=", value, "lssqSqrq");
            return (Criteria) this;
        }

        public Criteria andLssqSqrqIn(List<Date> values) {
            addCriterion("lssq_sqrq in", values, "lssqSqrq");
            return (Criteria) this;
        }

        public Criteria andLssqSqrqNotIn(List<Date> values) {
            addCriterion("lssq_sqrq not in", values, "lssqSqrq");
            return (Criteria) this;
        }

        public Criteria andLssqSqrqBetween(Date value1, Date value2) {
            addCriterion("lssq_sqrq between", value1, value2, "lssqSqrq");
            return (Criteria) this;
        }

        public Criteria andLssqSqrqNotBetween(Date value1, Date value2) {
            addCriterion("lssq_sqrq not between", value1, value2, "lssqSqrq");
            return (Criteria) this;
        }

        public Criteria andLssqKsrqIsNull() {
            addCriterion("lssq_ksrq is null");
            return (Criteria) this;
        }

        public Criteria andLssqKsrqIsNotNull() {
            addCriterion("lssq_ksrq is not null");
            return (Criteria) this;
        }

        public Criteria andLssqKsrqEqualTo(Date value) {
            addCriterion("lssq_ksrq =", value, "lssqKsrq");
            return (Criteria) this;
        }

        public Criteria andLssqKsrqNotEqualTo(Date value) {
            addCriterion("lssq_ksrq <>", value, "lssqKsrq");
            return (Criteria) this;
        }

        public Criteria andLssqKsrqGreaterThan(Date value) {
            addCriterion("lssq_ksrq >", value, "lssqKsrq");
            return (Criteria) this;
        }

        public Criteria andLssqKsrqGreaterThanOrEqualTo(Date value) {
            addCriterion("lssq_ksrq >=", value, "lssqKsrq");
            return (Criteria) this;
        }

        public Criteria andLssqKsrqLessThan(Date value) {
            addCriterion("lssq_ksrq <", value, "lssqKsrq");
            return (Criteria) this;
        }

        public Criteria andLssqKsrqLessThanOrEqualTo(Date value) {
            addCriterion("lssq_ksrq <=", value, "lssqKsrq");
            return (Criteria) this;
        }

        public Criteria andLssqKsrqIn(List<Date> values) {
            addCriterion("lssq_ksrq in", values, "lssqKsrq");
            return (Criteria) this;
        }

        public Criteria andLssqKsrqNotIn(List<Date> values) {
            addCriterion("lssq_ksrq not in", values, "lssqKsrq");
            return (Criteria) this;
        }

        public Criteria andLssqKsrqBetween(Date value1, Date value2) {
            addCriterion("lssq_ksrq between", value1, value2, "lssqKsrq");
            return (Criteria) this;
        }

        public Criteria andLssqKsrqNotBetween(Date value1, Date value2) {
            addCriterion("lssq_ksrq not between", value1, value2, "lssqKsrq");
            return (Criteria) this;
        }

        public Criteria andLssqJsrqIsNull() {
            addCriterion("lssq_jsrq is null");
            return (Criteria) this;
        }

        public Criteria andLssqJsrqIsNotNull() {
            addCriterion("lssq_jsrq is not null");
            return (Criteria) this;
        }

        public Criteria andLssqJsrqEqualTo(Date value) {
            addCriterion("lssq_jsrq =", value, "lssqJsrq");
            return (Criteria) this;
        }

        public Criteria andLssqJsrqNotEqualTo(Date value) {
            addCriterion("lssq_jsrq <>", value, "lssqJsrq");
            return (Criteria) this;
        }

        public Criteria andLssqJsrqGreaterThan(Date value) {
            addCriterion("lssq_jsrq >", value, "lssqJsrq");
            return (Criteria) this;
        }

        public Criteria andLssqJsrqGreaterThanOrEqualTo(Date value) {
            addCriterion("lssq_jsrq >=", value, "lssqJsrq");
            return (Criteria) this;
        }

        public Criteria andLssqJsrqLessThan(Date value) {
            addCriterion("lssq_jsrq <", value, "lssqJsrq");
            return (Criteria) this;
        }

        public Criteria andLssqJsrqLessThanOrEqualTo(Date value) {
            addCriterion("lssq_jsrq <=", value, "lssqJsrq");
            return (Criteria) this;
        }

        public Criteria andLssqJsrqIn(List<Date> values) {
            addCriterion("lssq_jsrq in", values, "lssqJsrq");
            return (Criteria) this;
        }

        public Criteria andLssqJsrqNotIn(List<Date> values) {
            addCriterion("lssq_jsrq not in", values, "lssqJsrq");
            return (Criteria) this;
        }

        public Criteria andLssqJsrqBetween(Date value1, Date value2) {
            addCriterion("lssq_jsrq between", value1, value2, "lssqJsrq");
            return (Criteria) this;
        }

        public Criteria andLssqJsrqNotBetween(Date value1, Date value2) {
            addCriterion("lssq_jsrq not between", value1, value2, "lssqJsrq");
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