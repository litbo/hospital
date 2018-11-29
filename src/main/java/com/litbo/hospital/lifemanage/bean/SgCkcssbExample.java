package com.litbo.hospital.lifemanage.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SgCkcssbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgCkcssbExample() {
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

        public Criteria andCkcssbXhIsNull() {
            addCriterion("ckcssb_xh is null");
            return (Criteria) this;
        }

        public Criteria andCkcssbXhIsNotNull() {
            addCriterion("ckcssb_xh is not null");
            return (Criteria) this;
        }

        public Criteria andCkcssbXhEqualTo(String value) {
            addCriterion("ckcssb_xh =", value, "ckcssbXh");
            return (Criteria) this;
        }

        public Criteria andCkcssbXhNotEqualTo(String value) {
            addCriterion("ckcssb_xh <>", value, "ckcssbXh");
            return (Criteria) this;
        }

        public Criteria andCkcssbXhGreaterThan(String value) {
            addCriterion("ckcssb_xh >", value, "ckcssbXh");
            return (Criteria) this;
        }

        public Criteria andCkcssbXhGreaterThanOrEqualTo(String value) {
            addCriterion("ckcssb_xh >=", value, "ckcssbXh");
            return (Criteria) this;
        }

        public Criteria andCkcssbXhLessThan(String value) {
            addCriterion("ckcssb_xh <", value, "ckcssbXh");
            return (Criteria) this;
        }

        public Criteria andCkcssbXhLessThanOrEqualTo(String value) {
            addCriterion("ckcssb_xh <=", value, "ckcssbXh");
            return (Criteria) this;
        }

        public Criteria andCkcssbXhLike(String value) {
            addCriterion("ckcssb_xh like", value, "ckcssbXh");
            return (Criteria) this;
        }

        public Criteria andCkcssbXhNotLike(String value) {
            addCriterion("ckcssb_xh not like", value, "ckcssbXh");
            return (Criteria) this;
        }

        public Criteria andCkcssbXhIn(List<String> values) {
            addCriterion("ckcssb_xh in", values, "ckcssbXh");
            return (Criteria) this;
        }

        public Criteria andCkcssbXhNotIn(List<String> values) {
            addCriterion("ckcssb_xh not in", values, "ckcssbXh");
            return (Criteria) this;
        }

        public Criteria andCkcssbXhBetween(String value1, String value2) {
            addCriterion("ckcssb_xh between", value1, value2, "ckcssbXh");
            return (Criteria) this;
        }

        public Criteria andCkcssbXhNotBetween(String value1, String value2) {
            addCriterion("ckcssb_xh not between", value1, value2, "ckcssbXh");
            return (Criteria) this;
        }

        public Criteria andCkcssbGgIsNull() {
            addCriterion("ckcssb_gg is null");
            return (Criteria) this;
        }

        public Criteria andCkcssbGgIsNotNull() {
            addCriterion("ckcssb_gg is not null");
            return (Criteria) this;
        }

        public Criteria andCkcssbGgEqualTo(String value) {
            addCriterion("ckcssb_gg =", value, "ckcssbGg");
            return (Criteria) this;
        }

        public Criteria andCkcssbGgNotEqualTo(String value) {
            addCriterion("ckcssb_gg <>", value, "ckcssbGg");
            return (Criteria) this;
        }

        public Criteria andCkcssbGgGreaterThan(String value) {
            addCriterion("ckcssb_gg >", value, "ckcssbGg");
            return (Criteria) this;
        }

        public Criteria andCkcssbGgGreaterThanOrEqualTo(String value) {
            addCriterion("ckcssb_gg >=", value, "ckcssbGg");
            return (Criteria) this;
        }

        public Criteria andCkcssbGgLessThan(String value) {
            addCriterion("ckcssb_gg <", value, "ckcssbGg");
            return (Criteria) this;
        }

        public Criteria andCkcssbGgLessThanOrEqualTo(String value) {
            addCriterion("ckcssb_gg <=", value, "ckcssbGg");
            return (Criteria) this;
        }

        public Criteria andCkcssbGgLike(String value) {
            addCriterion("ckcssb_gg like", value, "ckcssbGg");
            return (Criteria) this;
        }

        public Criteria andCkcssbGgNotLike(String value) {
            addCriterion("ckcssb_gg not like", value, "ckcssbGg");
            return (Criteria) this;
        }

        public Criteria andCkcssbGgIn(List<String> values) {
            addCriterion("ckcssb_gg in", values, "ckcssbGg");
            return (Criteria) this;
        }

        public Criteria andCkcssbGgNotIn(List<String> values) {
            addCriterion("ckcssb_gg not in", values, "ckcssbGg");
            return (Criteria) this;
        }

        public Criteria andCkcssbGgBetween(String value1, String value2) {
            addCriterion("ckcssb_gg between", value1, value2, "ckcssbGg");
            return (Criteria) this;
        }

        public Criteria andCkcssbGgNotBetween(String value1, String value2) {
            addCriterion("ckcssb_gg not between", value1, value2, "ckcssbGg");
            return (Criteria) this;
        }

        public Criteria andCkcssbSlIsNull() {
            addCriterion("ckcssb_sl is null");
            return (Criteria) this;
        }

        public Criteria andCkcssbSlIsNotNull() {
            addCriterion("ckcssb_sl is not null");
            return (Criteria) this;
        }

        public Criteria andCkcssbSlEqualTo(Integer value) {
            addCriterion("ckcssb_sl =", value, "ckcssbSl");
            return (Criteria) this;
        }

        public Criteria andCkcssbSlNotEqualTo(Integer value) {
            addCriterion("ckcssb_sl <>", value, "ckcssbSl");
            return (Criteria) this;
        }

        public Criteria andCkcssbSlGreaterThan(Integer value) {
            addCriterion("ckcssb_sl >", value, "ckcssbSl");
            return (Criteria) this;
        }

        public Criteria andCkcssbSlGreaterThanOrEqualTo(Integer value) {
            addCriterion("ckcssb_sl >=", value, "ckcssbSl");
            return (Criteria) this;
        }

        public Criteria andCkcssbSlLessThan(Integer value) {
            addCriterion("ckcssb_sl <", value, "ckcssbSl");
            return (Criteria) this;
        }

        public Criteria andCkcssbSlLessThanOrEqualTo(Integer value) {
            addCriterion("ckcssb_sl <=", value, "ckcssbSl");
            return (Criteria) this;
        }

        public Criteria andCkcssbSlIn(List<Integer> values) {
            addCriterion("ckcssb_sl in", values, "ckcssbSl");
            return (Criteria) this;
        }

        public Criteria andCkcssbSlNotIn(List<Integer> values) {
            addCriterion("ckcssb_sl not in", values, "ckcssbSl");
            return (Criteria) this;
        }

        public Criteria andCkcssbSlBetween(Integer value1, Integer value2) {
            addCriterion("ckcssb_sl between", value1, value2, "ckcssbSl");
            return (Criteria) this;
        }

        public Criteria andCkcssbSlNotBetween(Integer value1, Integer value2) {
            addCriterion("ckcssb_sl not between", value1, value2, "ckcssbSl");
            return (Criteria) this;
        }

        public Criteria andCkcssbGjIsNull() {
            addCriterion("ckcssb_gj is null");
            return (Criteria) this;
        }

        public Criteria andCkcssbGjIsNotNull() {
            addCriterion("ckcssb_gj is not null");
            return (Criteria) this;
        }

        public Criteria andCkcssbGjEqualTo(BigDecimal value) {
            addCriterion("ckcssb_gj =", value, "ckcssbGj");
            return (Criteria) this;
        }

        public Criteria andCkcssbGjNotEqualTo(BigDecimal value) {
            addCriterion("ckcssb_gj <>", value, "ckcssbGj");
            return (Criteria) this;
        }

        public Criteria andCkcssbGjGreaterThan(BigDecimal value) {
            addCriterion("ckcssb_gj >", value, "ckcssbGj");
            return (Criteria) this;
        }

        public Criteria andCkcssbGjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ckcssb_gj >=", value, "ckcssbGj");
            return (Criteria) this;
        }

        public Criteria andCkcssbGjLessThan(BigDecimal value) {
            addCriterion("ckcssb_gj <", value, "ckcssbGj");
            return (Criteria) this;
        }

        public Criteria andCkcssbGjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ckcssb_gj <=", value, "ckcssbGj");
            return (Criteria) this;
        }

        public Criteria andCkcssbGjIn(List<BigDecimal> values) {
            addCriterion("ckcssb_gj in", values, "ckcssbGj");
            return (Criteria) this;
        }

        public Criteria andCkcssbGjNotIn(List<BigDecimal> values) {
            addCriterion("ckcssb_gj not in", values, "ckcssbGj");
            return (Criteria) this;
        }

        public Criteria andCkcssbGjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ckcssb_gj between", value1, value2, "ckcssbGj");
            return (Criteria) this;
        }

        public Criteria andCkcssbGjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ckcssb_gj not between", value1, value2, "ckcssbGj");
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