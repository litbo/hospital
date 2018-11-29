package com.litbo.hospital.lifemanage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SgZrpjbgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgZrpjbgExample() {
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

        public Criteria andPjbgIdIsNull() {
            addCriterion("pjbg_id is null");
            return (Criteria) this;
        }

        public Criteria andPjbgIdIsNotNull() {
            addCriterion("pjbg_id is not null");
            return (Criteria) this;
        }

        public Criteria andPjbgIdEqualTo(String value) {
            addCriterion("pjbg_id =", value, "pjbgId");
            return (Criteria) this;
        }

        public Criteria andPjbgIdNotEqualTo(String value) {
            addCriterion("pjbg_id <>", value, "pjbgId");
            return (Criteria) this;
        }

        public Criteria andPjbgIdGreaterThan(String value) {
            addCriterion("pjbg_id >", value, "pjbgId");
            return (Criteria) this;
        }

        public Criteria andPjbgIdGreaterThanOrEqualTo(String value) {
            addCriterion("pjbg_id >=", value, "pjbgId");
            return (Criteria) this;
        }

        public Criteria andPjbgIdLessThan(String value) {
            addCriterion("pjbg_id <", value, "pjbgId");
            return (Criteria) this;
        }

        public Criteria andPjbgIdLessThanOrEqualTo(String value) {
            addCriterion("pjbg_id <=", value, "pjbgId");
            return (Criteria) this;
        }

        public Criteria andPjbgIdLike(String value) {
            addCriterion("pjbg_id like", value, "pjbgId");
            return (Criteria) this;
        }

        public Criteria andPjbgIdNotLike(String value) {
            addCriterion("pjbg_id not like", value, "pjbgId");
            return (Criteria) this;
        }

        public Criteria andPjbgIdIn(List<String> values) {
            addCriterion("pjbg_id in", values, "pjbgId");
            return (Criteria) this;
        }

        public Criteria andPjbgIdNotIn(List<String> values) {
            addCriterion("pjbg_id not in", values, "pjbgId");
            return (Criteria) this;
        }

        public Criteria andPjbgIdBetween(String value1, String value2) {
            addCriterion("pjbg_id between", value1, value2, "pjbgId");
            return (Criteria) this;
        }

        public Criteria andPjbgIdNotBetween(String value1, String value2) {
            addCriterion("pjbg_id not between", value1, value2, "pjbgId");
            return (Criteria) this;
        }

        public Criteria andPjbgDwIsNull() {
            addCriterion("pjbg_dw is null");
            return (Criteria) this;
        }

        public Criteria andPjbgDwIsNotNull() {
            addCriterion("pjbg_dw is not null");
            return (Criteria) this;
        }

        public Criteria andPjbgDwEqualTo(String value) {
            addCriterion("pjbg_dw =", value, "pjbgDw");
            return (Criteria) this;
        }

        public Criteria andPjbgDwNotEqualTo(String value) {
            addCriterion("pjbg_dw <>", value, "pjbgDw");
            return (Criteria) this;
        }

        public Criteria andPjbgDwGreaterThan(String value) {
            addCriterion("pjbg_dw >", value, "pjbgDw");
            return (Criteria) this;
        }

        public Criteria andPjbgDwGreaterThanOrEqualTo(String value) {
            addCriterion("pjbg_dw >=", value, "pjbgDw");
            return (Criteria) this;
        }

        public Criteria andPjbgDwLessThan(String value) {
            addCriterion("pjbg_dw <", value, "pjbgDw");
            return (Criteria) this;
        }

        public Criteria andPjbgDwLessThanOrEqualTo(String value) {
            addCriterion("pjbg_dw <=", value, "pjbgDw");
            return (Criteria) this;
        }

        public Criteria andPjbgDwLike(String value) {
            addCriterion("pjbg_dw like", value, "pjbgDw");
            return (Criteria) this;
        }

        public Criteria andPjbgDwNotLike(String value) {
            addCriterion("pjbg_dw not like", value, "pjbgDw");
            return (Criteria) this;
        }

        public Criteria andPjbgDwIn(List<String> values) {
            addCriterion("pjbg_dw in", values, "pjbgDw");
            return (Criteria) this;
        }

        public Criteria andPjbgDwNotIn(List<String> values) {
            addCriterion("pjbg_dw not in", values, "pjbgDw");
            return (Criteria) this;
        }

        public Criteria andPjbgDwBetween(String value1, String value2) {
            addCriterion("pjbg_dw between", value1, value2, "pjbgDw");
            return (Criteria) this;
        }

        public Criteria andPjbgDwNotBetween(String value1, String value2) {
            addCriterion("pjbg_dw not between", value1, value2, "pjbgDw");
            return (Criteria) this;
        }

        public Criteria andPjbgZbxmIsNull() {
            addCriterion("pjbg_zbxm is null");
            return (Criteria) this;
        }

        public Criteria andPjbgZbxmIsNotNull() {
            addCriterion("pjbg_zbxm is not null");
            return (Criteria) this;
        }

        public Criteria andPjbgZbxmEqualTo(String value) {
            addCriterion("pjbg_zbxm =", value, "pjbgZbxm");
            return (Criteria) this;
        }

        public Criteria andPjbgZbxmNotEqualTo(String value) {
            addCriterion("pjbg_zbxm <>", value, "pjbgZbxm");
            return (Criteria) this;
        }

        public Criteria andPjbgZbxmGreaterThan(String value) {
            addCriterion("pjbg_zbxm >", value, "pjbgZbxm");
            return (Criteria) this;
        }

        public Criteria andPjbgZbxmGreaterThanOrEqualTo(String value) {
            addCriterion("pjbg_zbxm >=", value, "pjbgZbxm");
            return (Criteria) this;
        }

        public Criteria andPjbgZbxmLessThan(String value) {
            addCriterion("pjbg_zbxm <", value, "pjbgZbxm");
            return (Criteria) this;
        }

        public Criteria andPjbgZbxmLessThanOrEqualTo(String value) {
            addCriterion("pjbg_zbxm <=", value, "pjbgZbxm");
            return (Criteria) this;
        }

        public Criteria andPjbgZbxmLike(String value) {
            addCriterion("pjbg_zbxm like", value, "pjbgZbxm");
            return (Criteria) this;
        }

        public Criteria andPjbgZbxmNotLike(String value) {
            addCriterion("pjbg_zbxm not like", value, "pjbgZbxm");
            return (Criteria) this;
        }

        public Criteria andPjbgZbxmIn(List<String> values) {
            addCriterion("pjbg_zbxm in", values, "pjbgZbxm");
            return (Criteria) this;
        }

        public Criteria andPjbgZbxmNotIn(List<String> values) {
            addCriterion("pjbg_zbxm not in", values, "pjbgZbxm");
            return (Criteria) this;
        }

        public Criteria andPjbgZbxmBetween(String value1, String value2) {
            addCriterion("pjbg_zbxm between", value1, value2, "pjbgZbxm");
            return (Criteria) this;
        }

        public Criteria andPjbgZbxmNotBetween(String value1, String value2) {
            addCriterion("pjbg_zbxm not between", value1, value2, "pjbgZbxm");
            return (Criteria) this;
        }

        public Criteria andPjbgBmfzrIsNull() {
            addCriterion("pjbg_bmfzr is null");
            return (Criteria) this;
        }

        public Criteria andPjbgBmfzrIsNotNull() {
            addCriterion("pjbg_bmfzr is not null");
            return (Criteria) this;
        }

        public Criteria andPjbgBmfzrEqualTo(String value) {
            addCriterion("pjbg_bmfzr =", value, "pjbgBmfzr");
            return (Criteria) this;
        }

        public Criteria andPjbgBmfzrNotEqualTo(String value) {
            addCriterion("pjbg_bmfzr <>", value, "pjbgBmfzr");
            return (Criteria) this;
        }

        public Criteria andPjbgBmfzrGreaterThan(String value) {
            addCriterion("pjbg_bmfzr >", value, "pjbgBmfzr");
            return (Criteria) this;
        }

        public Criteria andPjbgBmfzrGreaterThanOrEqualTo(String value) {
            addCriterion("pjbg_bmfzr >=", value, "pjbgBmfzr");
            return (Criteria) this;
        }

        public Criteria andPjbgBmfzrLessThan(String value) {
            addCriterion("pjbg_bmfzr <", value, "pjbgBmfzr");
            return (Criteria) this;
        }

        public Criteria andPjbgBmfzrLessThanOrEqualTo(String value) {
            addCriterion("pjbg_bmfzr <=", value, "pjbgBmfzr");
            return (Criteria) this;
        }

        public Criteria andPjbgBmfzrLike(String value) {
            addCriterion("pjbg_bmfzr like", value, "pjbgBmfzr");
            return (Criteria) this;
        }

        public Criteria andPjbgBmfzrNotLike(String value) {
            addCriterion("pjbg_bmfzr not like", value, "pjbgBmfzr");
            return (Criteria) this;
        }

        public Criteria andPjbgBmfzrIn(List<String> values) {
            addCriterion("pjbg_bmfzr in", values, "pjbgBmfzr");
            return (Criteria) this;
        }

        public Criteria andPjbgBmfzrNotIn(List<String> values) {
            addCriterion("pjbg_bmfzr not in", values, "pjbgBmfzr");
            return (Criteria) this;
        }

        public Criteria andPjbgBmfzrBetween(String value1, String value2) {
            addCriterion("pjbg_bmfzr between", value1, value2, "pjbgBmfzr");
            return (Criteria) this;
        }

        public Criteria andPjbgBmfzrNotBetween(String value1, String value2) {
            addCriterion("pjbg_bmfzr not between", value1, value2, "pjbgBmfzr");
            return (Criteria) this;
        }

        public Criteria andPjbgZbdwIsNull() {
            addCriterion("pjbg_zbdw is null");
            return (Criteria) this;
        }

        public Criteria andPjbgZbdwIsNotNull() {
            addCriterion("pjbg_zbdw is not null");
            return (Criteria) this;
        }

        public Criteria andPjbgZbdwEqualTo(String value) {
            addCriterion("pjbg_zbdw =", value, "pjbgZbdw");
            return (Criteria) this;
        }

        public Criteria andPjbgZbdwNotEqualTo(String value) {
            addCriterion("pjbg_zbdw <>", value, "pjbgZbdw");
            return (Criteria) this;
        }

        public Criteria andPjbgZbdwGreaterThan(String value) {
            addCriterion("pjbg_zbdw >", value, "pjbgZbdw");
            return (Criteria) this;
        }

        public Criteria andPjbgZbdwGreaterThanOrEqualTo(String value) {
            addCriterion("pjbg_zbdw >=", value, "pjbgZbdw");
            return (Criteria) this;
        }

        public Criteria andPjbgZbdwLessThan(String value) {
            addCriterion("pjbg_zbdw <", value, "pjbgZbdw");
            return (Criteria) this;
        }

        public Criteria andPjbgZbdwLessThanOrEqualTo(String value) {
            addCriterion("pjbg_zbdw <=", value, "pjbgZbdw");
            return (Criteria) this;
        }

        public Criteria andPjbgZbdwLike(String value) {
            addCriterion("pjbg_zbdw like", value, "pjbgZbdw");
            return (Criteria) this;
        }

        public Criteria andPjbgZbdwNotLike(String value) {
            addCriterion("pjbg_zbdw not like", value, "pjbgZbdw");
            return (Criteria) this;
        }

        public Criteria andPjbgZbdwIn(List<String> values) {
            addCriterion("pjbg_zbdw in", values, "pjbgZbdw");
            return (Criteria) this;
        }

        public Criteria andPjbgZbdwNotIn(List<String> values) {
            addCriterion("pjbg_zbdw not in", values, "pjbgZbdw");
            return (Criteria) this;
        }

        public Criteria andPjbgZbdwBetween(String value1, String value2) {
            addCriterion("pjbg_zbdw between", value1, value2, "pjbgZbdw");
            return (Criteria) this;
        }

        public Criteria andPjbgZbdwNotBetween(String value1, String value2) {
            addCriterion("pjbg_zbdw not between", value1, value2, "pjbgZbdw");
            return (Criteria) this;
        }

        public Criteria andPjbgRqIsNull() {
            addCriterion("pjbg_rq is null");
            return (Criteria) this;
        }

        public Criteria andPjbgRqIsNotNull() {
            addCriterion("pjbg_rq is not null");
            return (Criteria) this;
        }

        public Criteria andPjbgRqEqualTo(Date value) {
            addCriterion("pjbg_rq =", value, "pjbgRq");
            return (Criteria) this;
        }

        public Criteria andPjbgRqNotEqualTo(Date value) {
            addCriterion("pjbg_rq <>", value, "pjbgRq");
            return (Criteria) this;
        }

        public Criteria andPjbgRqGreaterThan(Date value) {
            addCriterion("pjbg_rq >", value, "pjbgRq");
            return (Criteria) this;
        }

        public Criteria andPjbgRqGreaterThanOrEqualTo(Date value) {
            addCriterion("pjbg_rq >=", value, "pjbgRq");
            return (Criteria) this;
        }

        public Criteria andPjbgRqLessThan(Date value) {
            addCriterion("pjbg_rq <", value, "pjbgRq");
            return (Criteria) this;
        }

        public Criteria andPjbgRqLessThanOrEqualTo(Date value) {
            addCriterion("pjbg_rq <=", value, "pjbgRq");
            return (Criteria) this;
        }

        public Criteria andPjbgRqIn(List<Date> values) {
            addCriterion("pjbg_rq in", values, "pjbgRq");
            return (Criteria) this;
        }

        public Criteria andPjbgRqNotIn(List<Date> values) {
            addCriterion("pjbg_rq not in", values, "pjbgRq");
            return (Criteria) this;
        }

        public Criteria andPjbgRqBetween(Date value1, Date value2) {
            addCriterion("pjbg_rq between", value1, value2, "pjbgRq");
            return (Criteria) this;
        }

        public Criteria andPjbgRqNotBetween(Date value1, Date value2) {
            addCriterion("pjbg_rq not between", value1, value2, "pjbgRq");
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