package com.litbo.hospital.lifemanage.bean;

import java.util.ArrayList;
import java.util.List;

public class SgLzfxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgLzfxExample() {
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

        public Criteria andSgIdIsNull() {
            addCriterion("sg_id is null");
            return (Criteria) this;
        }

        public Criteria andSgIdIsNotNull() {
            addCriterion("sg_id is not null");
            return (Criteria) this;
        }

        public Criteria andSgIdEqualTo(String value) {
            addCriterion("sg_id =", value, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdNotEqualTo(String value) {
            addCriterion("sg_id <>", value, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdGreaterThan(String value) {
            addCriterion("sg_id >", value, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdGreaterThanOrEqualTo(String value) {
            addCriterion("sg_id >=", value, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdLessThan(String value) {
            addCriterion("sg_id <", value, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdLessThanOrEqualTo(String value) {
            addCriterion("sg_id <=", value, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdLike(String value) {
            addCriterion("sg_id like", value, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdNotLike(String value) {
            addCriterion("sg_id not like", value, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdIn(List<String> values) {
            addCriterion("sg_id in", values, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdNotIn(List<String> values) {
            addCriterion("sg_id not in", values, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdBetween(String value1, String value2) {
            addCriterion("sg_id between", value1, value2, "sgId");
            return (Criteria) this;
        }

        public Criteria andSgIdNotBetween(String value1, String value2) {
            addCriterion("sg_id not between", value1, value2, "sgId");
            return (Criteria) this;
        }

        public Criteria andLzfxYldqzIsNull() {
            addCriterion("lzfx_yldqz is null");
            return (Criteria) this;
        }

        public Criteria andLzfxYldqzIsNotNull() {
            addCriterion("lzfx_yldqz is not null");
            return (Criteria) this;
        }

        public Criteria andLzfxYldqzEqualTo(String value) {
            addCriterion("lzfx_yldqz =", value, "lzfxYldqz");
            return (Criteria) this;
        }

        public Criteria andLzfxYldqzNotEqualTo(String value) {
            addCriterion("lzfx_yldqz <>", value, "lzfxYldqz");
            return (Criteria) this;
        }

        public Criteria andLzfxYldqzGreaterThan(String value) {
            addCriterion("lzfx_yldqz >", value, "lzfxYldqz");
            return (Criteria) this;
        }

        public Criteria andLzfxYldqzGreaterThanOrEqualTo(String value) {
            addCriterion("lzfx_yldqz >=", value, "lzfxYldqz");
            return (Criteria) this;
        }

        public Criteria andLzfxYldqzLessThan(String value) {
            addCriterion("lzfx_yldqz <", value, "lzfxYldqz");
            return (Criteria) this;
        }

        public Criteria andLzfxYldqzLessThanOrEqualTo(String value) {
            addCriterion("lzfx_yldqz <=", value, "lzfxYldqz");
            return (Criteria) this;
        }

        public Criteria andLzfxYldqzLike(String value) {
            addCriterion("lzfx_yldqz like", value, "lzfxYldqz");
            return (Criteria) this;
        }

        public Criteria andLzfxYldqzNotLike(String value) {
            addCriterion("lzfx_yldqz not like", value, "lzfxYldqz");
            return (Criteria) this;
        }

        public Criteria andLzfxYldqzIn(List<String> values) {
            addCriterion("lzfx_yldqz in", values, "lzfxYldqz");
            return (Criteria) this;
        }

        public Criteria andLzfxYldqzNotIn(List<String> values) {
            addCriterion("lzfx_yldqz not in", values, "lzfxYldqz");
            return (Criteria) this;
        }

        public Criteria andLzfxYldqzBetween(String value1, String value2) {
            addCriterion("lzfx_yldqz between", value1, value2, "lzfxYldqz");
            return (Criteria) this;
        }

        public Criteria andLzfxYldqzNotBetween(String value1, String value2) {
            addCriterion("lzfx_yldqz not between", value1, value2, "lzfxYldqz");
            return (Criteria) this;
        }

        public Criteria andLzfxZjqzIsNull() {
            addCriterion("lzfx_zjqz is null");
            return (Criteria) this;
        }

        public Criteria andLzfxZjqzIsNotNull() {
            addCriterion("lzfx_zjqz is not null");
            return (Criteria) this;
        }

        public Criteria andLzfxZjqzEqualTo(String value) {
            addCriterion("lzfx_zjqz =", value, "lzfxZjqz");
            return (Criteria) this;
        }

        public Criteria andLzfxZjqzNotEqualTo(String value) {
            addCriterion("lzfx_zjqz <>", value, "lzfxZjqz");
            return (Criteria) this;
        }

        public Criteria andLzfxZjqzGreaterThan(String value) {
            addCriterion("lzfx_zjqz >", value, "lzfxZjqz");
            return (Criteria) this;
        }

        public Criteria andLzfxZjqzGreaterThanOrEqualTo(String value) {
            addCriterion("lzfx_zjqz >=", value, "lzfxZjqz");
            return (Criteria) this;
        }

        public Criteria andLzfxZjqzLessThan(String value) {
            addCriterion("lzfx_zjqz <", value, "lzfxZjqz");
            return (Criteria) this;
        }

        public Criteria andLzfxZjqzLessThanOrEqualTo(String value) {
            addCriterion("lzfx_zjqz <=", value, "lzfxZjqz");
            return (Criteria) this;
        }

        public Criteria andLzfxZjqzLike(String value) {
            addCriterion("lzfx_zjqz like", value, "lzfxZjqz");
            return (Criteria) this;
        }

        public Criteria andLzfxZjqzNotLike(String value) {
            addCriterion("lzfx_zjqz not like", value, "lzfxZjqz");
            return (Criteria) this;
        }

        public Criteria andLzfxZjqzIn(List<String> values) {
            addCriterion("lzfx_zjqz in", values, "lzfxZjqz");
            return (Criteria) this;
        }

        public Criteria andLzfxZjqzNotIn(List<String> values) {
            addCriterion("lzfx_zjqz not in", values, "lzfxZjqz");
            return (Criteria) this;
        }

        public Criteria andLzfxZjqzBetween(String value1, String value2) {
            addCriterion("lzfx_zjqz between", value1, value2, "lzfxZjqz");
            return (Criteria) this;
        }

        public Criteria andLzfxZjqzNotBetween(String value1, String value2) {
            addCriterion("lzfx_zjqz not between", value1, value2, "lzfxZjqz");
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