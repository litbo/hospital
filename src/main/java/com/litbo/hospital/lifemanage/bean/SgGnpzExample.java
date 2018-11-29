package com.litbo.hospital.lifemanage.bean;

import java.util.ArrayList;
import java.util.List;

public class SgGnpzExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgGnpzExample() {
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

        public Criteria andGnpzIdIsNull() {
            addCriterion("gnpz_id is null");
            return (Criteria) this;
        }

        public Criteria andGnpzIdIsNotNull() {
            addCriterion("gnpz_id is not null");
            return (Criteria) this;
        }

        public Criteria andGnpzIdEqualTo(String value) {
            addCriterion("gnpz_id =", value, "gnpzId");
            return (Criteria) this;
        }

        public Criteria andGnpzIdNotEqualTo(String value) {
            addCriterion("gnpz_id <>", value, "gnpzId");
            return (Criteria) this;
        }

        public Criteria andGnpzIdGreaterThan(String value) {
            addCriterion("gnpz_id >", value, "gnpzId");
            return (Criteria) this;
        }

        public Criteria andGnpzIdGreaterThanOrEqualTo(String value) {
            addCriterion("gnpz_id >=", value, "gnpzId");
            return (Criteria) this;
        }

        public Criteria andGnpzIdLessThan(String value) {
            addCriterion("gnpz_id <", value, "gnpzId");
            return (Criteria) this;
        }

        public Criteria andGnpzIdLessThanOrEqualTo(String value) {
            addCriterion("gnpz_id <=", value, "gnpzId");
            return (Criteria) this;
        }

        public Criteria andGnpzIdLike(String value) {
            addCriterion("gnpz_id like", value, "gnpzId");
            return (Criteria) this;
        }

        public Criteria andGnpzIdNotLike(String value) {
            addCriterion("gnpz_id not like", value, "gnpzId");
            return (Criteria) this;
        }

        public Criteria andGnpzIdIn(List<String> values) {
            addCriterion("gnpz_id in", values, "gnpzId");
            return (Criteria) this;
        }

        public Criteria andGnpzIdNotIn(List<String> values) {
            addCriterion("gnpz_id not in", values, "gnpzId");
            return (Criteria) this;
        }

        public Criteria andGnpzIdBetween(String value1, String value2) {
            addCriterion("gnpz_id between", value1, value2, "gnpzId");
            return (Criteria) this;
        }

        public Criteria andGnpzIdNotBetween(String value1, String value2) {
            addCriterion("gnpz_id not between", value1, value2, "gnpzId");
            return (Criteria) this;
        }

        public Criteria andCkcssbIdIsNull() {
            addCriterion("ckcssb_id is null");
            return (Criteria) this;
        }

        public Criteria andCkcssbIdIsNotNull() {
            addCriterion("ckcssb_id is not null");
            return (Criteria) this;
        }

        public Criteria andCkcssbIdEqualTo(String value) {
            addCriterion("ckcssb_id =", value, "ckcssbId");
            return (Criteria) this;
        }

        public Criteria andCkcssbIdNotEqualTo(String value) {
            addCriterion("ckcssb_id <>", value, "ckcssbId");
            return (Criteria) this;
        }

        public Criteria andCkcssbIdGreaterThan(String value) {
            addCriterion("ckcssb_id >", value, "ckcssbId");
            return (Criteria) this;
        }

        public Criteria andCkcssbIdGreaterThanOrEqualTo(String value) {
            addCriterion("ckcssb_id >=", value, "ckcssbId");
            return (Criteria) this;
        }

        public Criteria andCkcssbIdLessThan(String value) {
            addCriterion("ckcssb_id <", value, "ckcssbId");
            return (Criteria) this;
        }

        public Criteria andCkcssbIdLessThanOrEqualTo(String value) {
            addCriterion("ckcssb_id <=", value, "ckcssbId");
            return (Criteria) this;
        }

        public Criteria andCkcssbIdLike(String value) {
            addCriterion("ckcssb_id like", value, "ckcssbId");
            return (Criteria) this;
        }

        public Criteria andCkcssbIdNotLike(String value) {
            addCriterion("ckcssb_id not like", value, "ckcssbId");
            return (Criteria) this;
        }

        public Criteria andCkcssbIdIn(List<String> values) {
            addCriterion("ckcssb_id in", values, "ckcssbId");
            return (Criteria) this;
        }

        public Criteria andCkcssbIdNotIn(List<String> values) {
            addCriterion("ckcssb_id not in", values, "ckcssbId");
            return (Criteria) this;
        }

        public Criteria andCkcssbIdBetween(String value1, String value2) {
            addCriterion("ckcssb_id between", value1, value2, "ckcssbId");
            return (Criteria) this;
        }

        public Criteria andCkcssbIdNotBetween(String value1, String value2) {
            addCriterion("ckcssb_id not between", value1, value2, "ckcssbId");
            return (Criteria) this;
        }

        public Criteria andGnpzMcIsNull() {
            addCriterion("gnpz_mc is null");
            return (Criteria) this;
        }

        public Criteria andGnpzMcIsNotNull() {
            addCriterion("gnpz_mc is not null");
            return (Criteria) this;
        }

        public Criteria andGnpzMcEqualTo(String value) {
            addCriterion("gnpz_mc =", value, "gnpzMc");
            return (Criteria) this;
        }

        public Criteria andGnpzMcNotEqualTo(String value) {
            addCriterion("gnpz_mc <>", value, "gnpzMc");
            return (Criteria) this;
        }

        public Criteria andGnpzMcGreaterThan(String value) {
            addCriterion("gnpz_mc >", value, "gnpzMc");
            return (Criteria) this;
        }

        public Criteria andGnpzMcGreaterThanOrEqualTo(String value) {
            addCriterion("gnpz_mc >=", value, "gnpzMc");
            return (Criteria) this;
        }

        public Criteria andGnpzMcLessThan(String value) {
            addCriterion("gnpz_mc <", value, "gnpzMc");
            return (Criteria) this;
        }

        public Criteria andGnpzMcLessThanOrEqualTo(String value) {
            addCriterion("gnpz_mc <=", value, "gnpzMc");
            return (Criteria) this;
        }

        public Criteria andGnpzMcLike(String value) {
            addCriterion("gnpz_mc like", value, "gnpzMc");
            return (Criteria) this;
        }

        public Criteria andGnpzMcNotLike(String value) {
            addCriterion("gnpz_mc not like", value, "gnpzMc");
            return (Criteria) this;
        }

        public Criteria andGnpzMcIn(List<String> values) {
            addCriterion("gnpz_mc in", values, "gnpzMc");
            return (Criteria) this;
        }

        public Criteria andGnpzMcNotIn(List<String> values) {
            addCriterion("gnpz_mc not in", values, "gnpzMc");
            return (Criteria) this;
        }

        public Criteria andGnpzMcBetween(String value1, String value2) {
            addCriterion("gnpz_mc between", value1, value2, "gnpzMc");
            return (Criteria) this;
        }

        public Criteria andGnpzMcNotBetween(String value1, String value2) {
            addCriterion("gnpz_mc not between", value1, value2, "gnpzMc");
            return (Criteria) this;
        }

        public Criteria andGnpzMsIsNull() {
            addCriterion("gnpz_ms is null");
            return (Criteria) this;
        }

        public Criteria andGnpzMsIsNotNull() {
            addCriterion("gnpz_ms is not null");
            return (Criteria) this;
        }

        public Criteria andGnpzMsEqualTo(String value) {
            addCriterion("gnpz_ms =", value, "gnpzMs");
            return (Criteria) this;
        }

        public Criteria andGnpzMsNotEqualTo(String value) {
            addCriterion("gnpz_ms <>", value, "gnpzMs");
            return (Criteria) this;
        }

        public Criteria andGnpzMsGreaterThan(String value) {
            addCriterion("gnpz_ms >", value, "gnpzMs");
            return (Criteria) this;
        }

        public Criteria andGnpzMsGreaterThanOrEqualTo(String value) {
            addCriterion("gnpz_ms >=", value, "gnpzMs");
            return (Criteria) this;
        }

        public Criteria andGnpzMsLessThan(String value) {
            addCriterion("gnpz_ms <", value, "gnpzMs");
            return (Criteria) this;
        }

        public Criteria andGnpzMsLessThanOrEqualTo(String value) {
            addCriterion("gnpz_ms <=", value, "gnpzMs");
            return (Criteria) this;
        }

        public Criteria andGnpzMsLike(String value) {
            addCriterion("gnpz_ms like", value, "gnpzMs");
            return (Criteria) this;
        }

        public Criteria andGnpzMsNotLike(String value) {
            addCriterion("gnpz_ms not like", value, "gnpzMs");
            return (Criteria) this;
        }

        public Criteria andGnpzMsIn(List<String> values) {
            addCriterion("gnpz_ms in", values, "gnpzMs");
            return (Criteria) this;
        }

        public Criteria andGnpzMsNotIn(List<String> values) {
            addCriterion("gnpz_ms not in", values, "gnpzMs");
            return (Criteria) this;
        }

        public Criteria andGnpzMsBetween(String value1, String value2) {
            addCriterion("gnpz_ms between", value1, value2, "gnpzMs");
            return (Criteria) this;
        }

        public Criteria andGnpzMsNotBetween(String value1, String value2) {
            addCriterion("gnpz_ms not between", value1, value2, "gnpzMs");
            return (Criteria) this;
        }

        public Criteria andGnpzIssyIsNull() {
            addCriterion("gnpz_issy is null");
            return (Criteria) this;
        }

        public Criteria andGnpzIssyIsNotNull() {
            addCriterion("gnpz_issy is not null");
            return (Criteria) this;
        }

        public Criteria andGnpzIssyEqualTo(String value) {
            addCriterion("gnpz_issy =", value, "gnpzIssy");
            return (Criteria) this;
        }

        public Criteria andGnpzIssyNotEqualTo(String value) {
            addCriterion("gnpz_issy <>", value, "gnpzIssy");
            return (Criteria) this;
        }

        public Criteria andGnpzIssyGreaterThan(String value) {
            addCriterion("gnpz_issy >", value, "gnpzIssy");
            return (Criteria) this;
        }

        public Criteria andGnpzIssyGreaterThanOrEqualTo(String value) {
            addCriterion("gnpz_issy >=", value, "gnpzIssy");
            return (Criteria) this;
        }

        public Criteria andGnpzIssyLessThan(String value) {
            addCriterion("gnpz_issy <", value, "gnpzIssy");
            return (Criteria) this;
        }

        public Criteria andGnpzIssyLessThanOrEqualTo(String value) {
            addCriterion("gnpz_issy <=", value, "gnpzIssy");
            return (Criteria) this;
        }

        public Criteria andGnpzIssyLike(String value) {
            addCriterion("gnpz_issy like", value, "gnpzIssy");
            return (Criteria) this;
        }

        public Criteria andGnpzIssyNotLike(String value) {
            addCriterion("gnpz_issy not like", value, "gnpzIssy");
            return (Criteria) this;
        }

        public Criteria andGnpzIssyIn(List<String> values) {
            addCriterion("gnpz_issy in", values, "gnpzIssy");
            return (Criteria) this;
        }

        public Criteria andGnpzIssyNotIn(List<String> values) {
            addCriterion("gnpz_issy not in", values, "gnpzIssy");
            return (Criteria) this;
        }

        public Criteria andGnpzIssyBetween(String value1, String value2) {
            addCriterion("gnpz_issy between", value1, value2, "gnpzIssy");
            return (Criteria) this;
        }

        public Criteria andGnpzIssyNotBetween(String value1, String value2) {
            addCriterion("gnpz_issy not between", value1, value2, "gnpzIssy");
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