package com.litbo.hospital.lifemanage.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SgLzfxxhbjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgLzfxxhbjExample() {
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

        public Criteria andXhbjIdIsNull() {
            addCriterion("xhbj_id is null");
            return (Criteria) this;
        }

        public Criteria andXhbjIdIsNotNull() {
            addCriterion("xhbj_id is not null");
            return (Criteria) this;
        }

        public Criteria andXhbjIdEqualTo(String value) {
            addCriterion("xhbj_id =", value, "xhbjId");
            return (Criteria) this;
        }

        public Criteria andXhbjIdNotEqualTo(String value) {
            addCriterion("xhbj_id <>", value, "xhbjId");
            return (Criteria) this;
        }

        public Criteria andXhbjIdGreaterThan(String value) {
            addCriterion("xhbj_id >", value, "xhbjId");
            return (Criteria) this;
        }

        public Criteria andXhbjIdGreaterThanOrEqualTo(String value) {
            addCriterion("xhbj_id >=", value, "xhbjId");
            return (Criteria) this;
        }

        public Criteria andXhbjIdLessThan(String value) {
            addCriterion("xhbj_id <", value, "xhbjId");
            return (Criteria) this;
        }

        public Criteria andXhbjIdLessThanOrEqualTo(String value) {
            addCriterion("xhbj_id <=", value, "xhbjId");
            return (Criteria) this;
        }

        public Criteria andXhbjIdLike(String value) {
            addCriterion("xhbj_id like", value, "xhbjId");
            return (Criteria) this;
        }

        public Criteria andXhbjIdNotLike(String value) {
            addCriterion("xhbj_id not like", value, "xhbjId");
            return (Criteria) this;
        }

        public Criteria andXhbjIdIn(List<String> values) {
            addCriterion("xhbj_id in", values, "xhbjId");
            return (Criteria) this;
        }

        public Criteria andXhbjIdNotIn(List<String> values) {
            addCriterion("xhbj_id not in", values, "xhbjId");
            return (Criteria) this;
        }

        public Criteria andXhbjIdBetween(String value1, String value2) {
            addCriterion("xhbj_id between", value1, value2, "xhbjId");
            return (Criteria) this;
        }

        public Criteria andXhbjIdNotBetween(String value1, String value2) {
            addCriterion("xhbj_id not between", value1, value2, "xhbjId");
            return (Criteria) this;
        }

        public Criteria andLzfxIdIsNull() {
            addCriterion("lzfx_id is null");
            return (Criteria) this;
        }

        public Criteria andLzfxIdIsNotNull() {
            addCriterion("lzfx_id is not null");
            return (Criteria) this;
        }

        public Criteria andLzfxIdEqualTo(String value) {
            addCriterion("lzfx_id =", value, "lzfxId");
            return (Criteria) this;
        }

        public Criteria andLzfxIdNotEqualTo(String value) {
            addCriterion("lzfx_id <>", value, "lzfxId");
            return (Criteria) this;
        }

        public Criteria andLzfxIdGreaterThan(String value) {
            addCriterion("lzfx_id >", value, "lzfxId");
            return (Criteria) this;
        }

        public Criteria andLzfxIdGreaterThanOrEqualTo(String value) {
            addCriterion("lzfx_id >=", value, "lzfxId");
            return (Criteria) this;
        }

        public Criteria andLzfxIdLessThan(String value) {
            addCriterion("lzfx_id <", value, "lzfxId");
            return (Criteria) this;
        }

        public Criteria andLzfxIdLessThanOrEqualTo(String value) {
            addCriterion("lzfx_id <=", value, "lzfxId");
            return (Criteria) this;
        }

        public Criteria andLzfxIdLike(String value) {
            addCriterion("lzfx_id like", value, "lzfxId");
            return (Criteria) this;
        }

        public Criteria andLzfxIdNotLike(String value) {
            addCriterion("lzfx_id not like", value, "lzfxId");
            return (Criteria) this;
        }

        public Criteria andLzfxIdIn(List<String> values) {
            addCriterion("lzfx_id in", values, "lzfxId");
            return (Criteria) this;
        }

        public Criteria andLzfxIdNotIn(List<String> values) {
            addCriterion("lzfx_id not in", values, "lzfxId");
            return (Criteria) this;
        }

        public Criteria andLzfxIdBetween(String value1, String value2) {
            addCriterion("lzfx_id between", value1, value2, "lzfxId");
            return (Criteria) this;
        }

        public Criteria andLzfxIdNotBetween(String value1, String value2) {
            addCriterion("lzfx_id not between", value1, value2, "lzfxId");
            return (Criteria) this;
        }

        public Criteria andSbcsIdIsNull() {
            addCriterion("sbcs_id is null");
            return (Criteria) this;
        }

        public Criteria andSbcsIdIsNotNull() {
            addCriterion("sbcs_id is not null");
            return (Criteria) this;
        }

        public Criteria andSbcsIdEqualTo(Integer value) {
            addCriterion("sbcs_id =", value, "sbcsId");
            return (Criteria) this;
        }

        public Criteria andSbcsIdNotEqualTo(Integer value) {
            addCriterion("sbcs_id <>", value, "sbcsId");
            return (Criteria) this;
        }

        public Criteria andSbcsIdGreaterThan(Integer value) {
            addCriterion("sbcs_id >", value, "sbcsId");
            return (Criteria) this;
        }

        public Criteria andSbcsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sbcs_id >=", value, "sbcsId");
            return (Criteria) this;
        }

        public Criteria andSbcsIdLessThan(Integer value) {
            addCriterion("sbcs_id <", value, "sbcsId");
            return (Criteria) this;
        }

        public Criteria andSbcsIdLessThanOrEqualTo(Integer value) {
            addCriterion("sbcs_id <=", value, "sbcsId");
            return (Criteria) this;
        }

        public Criteria andSbcsIdIn(List<Integer> values) {
            addCriterion("sbcs_id in", values, "sbcsId");
            return (Criteria) this;
        }

        public Criteria andSbcsIdNotIn(List<Integer> values) {
            addCriterion("sbcs_id not in", values, "sbcsId");
            return (Criteria) this;
        }

        public Criteria andSbcsIdBetween(Integer value1, Integer value2) {
            addCriterion("sbcs_id between", value1, value2, "sbcsId");
            return (Criteria) this;
        }

        public Criteria andSbcsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sbcs_id not between", value1, value2, "sbcsId");
            return (Criteria) this;
        }

        public Criteria andXhbjXhIsNull() {
            addCriterion("xhbj_xh is null");
            return (Criteria) this;
        }

        public Criteria andXhbjXhIsNotNull() {
            addCriterion("xhbj_xh is not null");
            return (Criteria) this;
        }

        public Criteria andXhbjXhEqualTo(String value) {
            addCriterion("xhbj_xh =", value, "xhbjXh");
            return (Criteria) this;
        }

        public Criteria andXhbjXhNotEqualTo(String value) {
            addCriterion("xhbj_xh <>", value, "xhbjXh");
            return (Criteria) this;
        }

        public Criteria andXhbjXhGreaterThan(String value) {
            addCriterion("xhbj_xh >", value, "xhbjXh");
            return (Criteria) this;
        }

        public Criteria andXhbjXhGreaterThanOrEqualTo(String value) {
            addCriterion("xhbj_xh >=", value, "xhbjXh");
            return (Criteria) this;
        }

        public Criteria andXhbjXhLessThan(String value) {
            addCriterion("xhbj_xh <", value, "xhbjXh");
            return (Criteria) this;
        }

        public Criteria andXhbjXhLessThanOrEqualTo(String value) {
            addCriterion("xhbj_xh <=", value, "xhbjXh");
            return (Criteria) this;
        }

        public Criteria andXhbjXhLike(String value) {
            addCriterion("xhbj_xh like", value, "xhbjXh");
            return (Criteria) this;
        }

        public Criteria andXhbjXhNotLike(String value) {
            addCriterion("xhbj_xh not like", value, "xhbjXh");
            return (Criteria) this;
        }

        public Criteria andXhbjXhIn(List<String> values) {
            addCriterion("xhbj_xh in", values, "xhbjXh");
            return (Criteria) this;
        }

        public Criteria andXhbjXhNotIn(List<String> values) {
            addCriterion("xhbj_xh not in", values, "xhbjXh");
            return (Criteria) this;
        }

        public Criteria andXhbjXhBetween(String value1, String value2) {
            addCriterion("xhbj_xh between", value1, value2, "xhbjXh");
            return (Criteria) this;
        }

        public Criteria andXhbjXhNotBetween(String value1, String value2) {
            addCriterion("xhbj_xh not between", value1, value2, "xhbjXh");
            return (Criteria) this;
        }

        public Criteria andXhbjBjIsNull() {
            addCriterion("xhbj_bj is null");
            return (Criteria) this;
        }

        public Criteria andXhbjBjIsNotNull() {
            addCriterion("xhbj_bj is not null");
            return (Criteria) this;
        }

        public Criteria andXhbjBjEqualTo(BigDecimal value) {
            addCriterion("xhbj_bj =", value, "xhbjBj");
            return (Criteria) this;
        }

        public Criteria andXhbjBjNotEqualTo(BigDecimal value) {
            addCriterion("xhbj_bj <>", value, "xhbjBj");
            return (Criteria) this;
        }

        public Criteria andXhbjBjGreaterThan(BigDecimal value) {
            addCriterion("xhbj_bj >", value, "xhbjBj");
            return (Criteria) this;
        }

        public Criteria andXhbjBjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("xhbj_bj >=", value, "xhbjBj");
            return (Criteria) this;
        }

        public Criteria andXhbjBjLessThan(BigDecimal value) {
            addCriterion("xhbj_bj <", value, "xhbjBj");
            return (Criteria) this;
        }

        public Criteria andXhbjBjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("xhbj_bj <=", value, "xhbjBj");
            return (Criteria) this;
        }

        public Criteria andXhbjBjIn(List<BigDecimal> values) {
            addCriterion("xhbj_bj in", values, "xhbjBj");
            return (Criteria) this;
        }

        public Criteria andXhbjBjNotIn(List<BigDecimal> values) {
            addCriterion("xhbj_bj not in", values, "xhbjBj");
            return (Criteria) this;
        }

        public Criteria andXhbjBjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xhbj_bj between", value1, value2, "xhbjBj");
            return (Criteria) this;
        }

        public Criteria andXhbjBjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("xhbj_bj not between", value1, value2, "xhbjBj");
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