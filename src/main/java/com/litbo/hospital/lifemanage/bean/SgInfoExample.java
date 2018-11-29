package com.litbo.hospital.lifemanage.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SgInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andBhIsNull() {
            addCriterion("bh is null");
            return (Criteria) this;
        }

        public Criteria andBhIsNotNull() {
            addCriterion("bh is not null");
            return (Criteria) this;
        }

        public Criteria andBhEqualTo(String value) {
            addCriterion("bh =", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotEqualTo(String value) {
            addCriterion("bh <>", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhGreaterThan(String value) {
            addCriterion("bh >", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhGreaterThanOrEqualTo(String value) {
            addCriterion("bh >=", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhLessThan(String value) {
            addCriterion("bh <", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhLessThanOrEqualTo(String value) {
            addCriterion("bh <=", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhLike(String value) {
            addCriterion("bh like", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotLike(String value) {
            addCriterion("bh not like", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhIn(List<String> values) {
            addCriterion("bh in", values, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotIn(List<String> values) {
            addCriterion("bh not in", values, "bh");
            return (Criteria) this;
        }

        public Criteria andBhBetween(String value1, String value2) {
            addCriterion("bh between", value1, value2, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotBetween(String value1, String value2) {
            addCriterion("bh not between", value1, value2, "bh");
            return (Criteria) this;
        }

        public Criteria andEqPmIdIsNull() {
            addCriterion("eq_pm_id is null");
            return (Criteria) this;
        }

        public Criteria andEqPmIdIsNotNull() {
            addCriterion("eq_pm_id is not null");
            return (Criteria) this;
        }

        public Criteria andEqPmIdEqualTo(Integer value) {
            addCriterion("eq_pm_id =", value, "eqPmId");
            return (Criteria) this;
        }

        public Criteria andEqPmIdNotEqualTo(Integer value) {
            addCriterion("eq_pm_id <>", value, "eqPmId");
            return (Criteria) this;
        }

        public Criteria andEqPmIdGreaterThan(Integer value) {
            addCriterion("eq_pm_id >", value, "eqPmId");
            return (Criteria) this;
        }

        public Criteria andEqPmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("eq_pm_id >=", value, "eqPmId");
            return (Criteria) this;
        }

        public Criteria andEqPmIdLessThan(Integer value) {
            addCriterion("eq_pm_id <", value, "eqPmId");
            return (Criteria) this;
        }

        public Criteria andEqPmIdLessThanOrEqualTo(Integer value) {
            addCriterion("eq_pm_id <=", value, "eqPmId");
            return (Criteria) this;
        }

        public Criteria andEqPmIdIn(List<Integer> values) {
            addCriterion("eq_pm_id in", values, "eqPmId");
            return (Criteria) this;
        }

        public Criteria andEqPmIdNotIn(List<Integer> values) {
            addCriterion("eq_pm_id not in", values, "eqPmId");
            return (Criteria) this;
        }

        public Criteria andEqPmIdBetween(Integer value1, Integer value2) {
            addCriterion("eq_pm_id between", value1, value2, "eqPmId");
            return (Criteria) this;
        }

        public Criteria andEqPmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("eq_pm_id not between", value1, value2, "eqPmId");
            return (Criteria) this;
        }

        public Criteria andTgBmIdIsNull() {
            addCriterion("tg_bm_id is null");
            return (Criteria) this;
        }

        public Criteria andTgBmIdIsNotNull() {
            addCriterion("tg_bm_id is not null");
            return (Criteria) this;
        }

        public Criteria andTgBmIdEqualTo(String value) {
            addCriterion("tg_bm_id =", value, "tgBmId");
            return (Criteria) this;
        }

        public Criteria andTgBmIdNotEqualTo(String value) {
            addCriterion("tg_bm_id <>", value, "tgBmId");
            return (Criteria) this;
        }

        public Criteria andTgBmIdGreaterThan(String value) {
            addCriterion("tg_bm_id >", value, "tgBmId");
            return (Criteria) this;
        }

        public Criteria andTgBmIdGreaterThanOrEqualTo(String value) {
            addCriterion("tg_bm_id >=", value, "tgBmId");
            return (Criteria) this;
        }

        public Criteria andTgBmIdLessThan(String value) {
            addCriterion("tg_bm_id <", value, "tgBmId");
            return (Criteria) this;
        }

        public Criteria andTgBmIdLessThanOrEqualTo(String value) {
            addCriterion("tg_bm_id <=", value, "tgBmId");
            return (Criteria) this;
        }

        public Criteria andTgBmIdLike(String value) {
            addCriterion("tg_bm_id like", value, "tgBmId");
            return (Criteria) this;
        }

        public Criteria andTgBmIdNotLike(String value) {
            addCriterion("tg_bm_id not like", value, "tgBmId");
            return (Criteria) this;
        }

        public Criteria andTgBmIdIn(List<String> values) {
            addCriterion("tg_bm_id in", values, "tgBmId");
            return (Criteria) this;
        }

        public Criteria andTgBmIdNotIn(List<String> values) {
            addCriterion("tg_bm_id not in", values, "tgBmId");
            return (Criteria) this;
        }

        public Criteria andTgBmIdBetween(String value1, String value2) {
            addCriterion("tg_bm_id between", value1, value2, "tgBmId");
            return (Criteria) this;
        }

        public Criteria andTgBmIdNotBetween(String value1, String value2) {
            addCriterion("tg_bm_id not between", value1, value2, "tgBmId");
            return (Criteria) this;
        }

        public Criteria andGzlbIdIsNull() {
            addCriterion("gzlb_id is null");
            return (Criteria) this;
        }

        public Criteria andGzlbIdIsNotNull() {
            addCriterion("gzlb_id is not null");
            return (Criteria) this;
        }

        public Criteria andGzlbIdEqualTo(Integer value) {
            addCriterion("gzlb_id =", value, "gzlbId");
            return (Criteria) this;
        }

        public Criteria andGzlbIdNotEqualTo(Integer value) {
            addCriterion("gzlb_id <>", value, "gzlbId");
            return (Criteria) this;
        }

        public Criteria andGzlbIdGreaterThan(Integer value) {
            addCriterion("gzlb_id >", value, "gzlbId");
            return (Criteria) this;
        }

        public Criteria andGzlbIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gzlb_id >=", value, "gzlbId");
            return (Criteria) this;
        }

        public Criteria andGzlbIdLessThan(Integer value) {
            addCriterion("gzlb_id <", value, "gzlbId");
            return (Criteria) this;
        }

        public Criteria andGzlbIdLessThanOrEqualTo(Integer value) {
            addCriterion("gzlb_id <=", value, "gzlbId");
            return (Criteria) this;
        }

        public Criteria andGzlbIdIn(List<Integer> values) {
            addCriterion("gzlb_id in", values, "gzlbId");
            return (Criteria) this;
        }

        public Criteria andGzlbIdNotIn(List<Integer> values) {
            addCriterion("gzlb_id not in", values, "gzlbId");
            return (Criteria) this;
        }

        public Criteria andGzlbIdBetween(Integer value1, Integer value2) {
            addCriterion("gzlb_id between", value1, value2, "gzlbId");
            return (Criteria) this;
        }

        public Criteria andGzlbIdNotBetween(Integer value1, Integer value2) {
            addCriterion("gzlb_id not between", value1, value2, "gzlbId");
            return (Criteria) this;
        }

        public Criteria andZjlyIdIsNull() {
            addCriterion("zjly_id is null");
            return (Criteria) this;
        }

        public Criteria andZjlyIdIsNotNull() {
            addCriterion("zjly_id is not null");
            return (Criteria) this;
        }

        public Criteria andZjlyIdEqualTo(Integer value) {
            addCriterion("zjly_id =", value, "zjlyId");
            return (Criteria) this;
        }

        public Criteria andZjlyIdNotEqualTo(Integer value) {
            addCriterion("zjly_id <>", value, "zjlyId");
            return (Criteria) this;
        }

        public Criteria andZjlyIdGreaterThan(Integer value) {
            addCriterion("zjly_id >", value, "zjlyId");
            return (Criteria) this;
        }

        public Criteria andZjlyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("zjly_id >=", value, "zjlyId");
            return (Criteria) this;
        }

        public Criteria andZjlyIdLessThan(Integer value) {
            addCriterion("zjly_id <", value, "zjlyId");
            return (Criteria) this;
        }

        public Criteria andZjlyIdLessThanOrEqualTo(Integer value) {
            addCriterion("zjly_id <=", value, "zjlyId");
            return (Criteria) this;
        }

        public Criteria andZjlyIdIn(List<Integer> values) {
            addCriterion("zjly_id in", values, "zjlyId");
            return (Criteria) this;
        }

        public Criteria andZjlyIdNotIn(List<Integer> values) {
            addCriterion("zjly_id not in", values, "zjlyId");
            return (Criteria) this;
        }

        public Criteria andZjlyIdBetween(Integer value1, Integer value2) {
            addCriterion("zjly_id between", value1, value2, "zjlyId");
            return (Criteria) this;
        }

        public Criteria andZjlyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("zjly_id not between", value1, value2, "zjlyId");
            return (Criteria) this;
        }

        public Criteria andSyxzIdIsNull() {
            addCriterion("syxz_id is null");
            return (Criteria) this;
        }

        public Criteria andSyxzIdIsNotNull() {
            addCriterion("syxz_id is not null");
            return (Criteria) this;
        }

        public Criteria andSyxzIdEqualTo(Integer value) {
            addCriterion("syxz_id =", value, "syxzId");
            return (Criteria) this;
        }

        public Criteria andSyxzIdNotEqualTo(Integer value) {
            addCriterion("syxz_id <>", value, "syxzId");
            return (Criteria) this;
        }

        public Criteria andSyxzIdGreaterThan(Integer value) {
            addCriterion("syxz_id >", value, "syxzId");
            return (Criteria) this;
        }

        public Criteria andSyxzIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("syxz_id >=", value, "syxzId");
            return (Criteria) this;
        }

        public Criteria andSyxzIdLessThan(Integer value) {
            addCriterion("syxz_id <", value, "syxzId");
            return (Criteria) this;
        }

        public Criteria andSyxzIdLessThanOrEqualTo(Integer value) {
            addCriterion("syxz_id <=", value, "syxzId");
            return (Criteria) this;
        }

        public Criteria andSyxzIdIn(List<Integer> values) {
            addCriterion("syxz_id in", values, "syxzId");
            return (Criteria) this;
        }

        public Criteria andSyxzIdNotIn(List<Integer> values) {
            addCriterion("syxz_id not in", values, "syxzId");
            return (Criteria) this;
        }

        public Criteria andSyxzIdBetween(Integer value1, Integer value2) {
            addCriterion("syxz_id between", value1, value2, "syxzId");
            return (Criteria) this;
        }

        public Criteria andSyxzIdNotBetween(Integer value1, Integer value2) {
            addCriterion("syxz_id not between", value1, value2, "syxzId");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andPriceWdIsNull() {
            addCriterion("price_wd is null");
            return (Criteria) this;
        }

        public Criteria andPriceWdIsNotNull() {
            addCriterion("price_wd is not null");
            return (Criteria) this;
        }

        public Criteria andPriceWdEqualTo(BigDecimal value) {
            addCriterion("price_wd =", value, "priceWd");
            return (Criteria) this;
        }

        public Criteria andPriceWdNotEqualTo(BigDecimal value) {
            addCriterion("price_wd <>", value, "priceWd");
            return (Criteria) this;
        }

        public Criteria andPriceWdGreaterThan(BigDecimal value) {
            addCriterion("price_wd >", value, "priceWd");
            return (Criteria) this;
        }

        public Criteria andPriceWdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_wd >=", value, "priceWd");
            return (Criteria) this;
        }

        public Criteria andPriceWdLessThan(BigDecimal value) {
            addCriterion("price_wd <", value, "priceWd");
            return (Criteria) this;
        }

        public Criteria andPriceWdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_wd <=", value, "priceWd");
            return (Criteria) this;
        }

        public Criteria andPriceWdIn(List<BigDecimal> values) {
            addCriterion("price_wd in", values, "priceWd");
            return (Criteria) this;
        }

        public Criteria andPriceWdNotIn(List<BigDecimal> values) {
            addCriterion("price_wd not in", values, "priceWd");
            return (Criteria) this;
        }

        public Criteria andPriceWdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_wd between", value1, value2, "priceWd");
            return (Criteria) this;
        }

        public Criteria andPriceWdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_wd not between", value1, value2, "priceWd");
            return (Criteria) this;
        }

        public Criteria andPriceSnIsNull() {
            addCriterion("price_sn is null");
            return (Criteria) this;
        }

        public Criteria andPriceSnIsNotNull() {
            addCriterion("price_sn is not null");
            return (Criteria) this;
        }

        public Criteria andPriceSnEqualTo(BigDecimal value) {
            addCriterion("price_sn =", value, "priceSn");
            return (Criteria) this;
        }

        public Criteria andPriceSnNotEqualTo(BigDecimal value) {
            addCriterion("price_sn <>", value, "priceSn");
            return (Criteria) this;
        }

        public Criteria andPriceSnGreaterThan(BigDecimal value) {
            addCriterion("price_sn >", value, "priceSn");
            return (Criteria) this;
        }

        public Criteria andPriceSnGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_sn >=", value, "priceSn");
            return (Criteria) this;
        }

        public Criteria andPriceSnLessThan(BigDecimal value) {
            addCriterion("price_sn <", value, "priceSn");
            return (Criteria) this;
        }

        public Criteria andPriceSnLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_sn <=", value, "priceSn");
            return (Criteria) this;
        }

        public Criteria andPriceSnIn(List<BigDecimal> values) {
            addCriterion("price_sn in", values, "priceSn");
            return (Criteria) this;
        }

        public Criteria andPriceSnNotIn(List<BigDecimal> values) {
            addCriterion("price_sn not in", values, "priceSn");
            return (Criteria) this;
        }

        public Criteria andPriceSnBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_sn between", value1, value2, "priceSn");
            return (Criteria) this;
        }

        public Criteria andPriceSnNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_sn not between", value1, value2, "priceSn");
            return (Criteria) this;
        }

        public Criteria andPriceGjYIsNull() {
            addCriterion("price_gj_y is null");
            return (Criteria) this;
        }

        public Criteria andPriceGjYIsNotNull() {
            addCriterion("price_gj_y is not null");
            return (Criteria) this;
        }

        public Criteria andPriceGjYEqualTo(BigDecimal value) {
            addCriterion("price_gj_y =", value, "priceGjY");
            return (Criteria) this;
        }

        public Criteria andPriceGjYNotEqualTo(BigDecimal value) {
            addCriterion("price_gj_y <>", value, "priceGjY");
            return (Criteria) this;
        }

        public Criteria andPriceGjYGreaterThan(BigDecimal value) {
            addCriterion("price_gj_y >", value, "priceGjY");
            return (Criteria) this;
        }

        public Criteria andPriceGjYGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_gj_y >=", value, "priceGjY");
            return (Criteria) this;
        }

        public Criteria andPriceGjYLessThan(BigDecimal value) {
            addCriterion("price_gj_y <", value, "priceGjY");
            return (Criteria) this;
        }

        public Criteria andPriceGjYLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_gj_y <=", value, "priceGjY");
            return (Criteria) this;
        }

        public Criteria andPriceGjYIn(List<BigDecimal> values) {
            addCriterion("price_gj_y in", values, "priceGjY");
            return (Criteria) this;
        }

        public Criteria andPriceGjYNotIn(List<BigDecimal> values) {
            addCriterion("price_gj_y not in", values, "priceGjY");
            return (Criteria) this;
        }

        public Criteria andPriceGjYBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_gj_y between", value1, value2, "priceGjY");
            return (Criteria) this;
        }

        public Criteria andPriceGjYNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_gj_y not between", value1, value2, "priceGjY");
            return (Criteria) this;
        }

        public Criteria andPriceGjMyIsNull() {
            addCriterion("price_gj_my is null");
            return (Criteria) this;
        }

        public Criteria andPriceGjMyIsNotNull() {
            addCriterion("price_gj_my is not null");
            return (Criteria) this;
        }

        public Criteria andPriceGjMyEqualTo(BigDecimal value) {
            addCriterion("price_gj_my =", value, "priceGjMy");
            return (Criteria) this;
        }

        public Criteria andPriceGjMyNotEqualTo(BigDecimal value) {
            addCriterion("price_gj_my <>", value, "priceGjMy");
            return (Criteria) this;
        }

        public Criteria andPriceGjMyGreaterThan(BigDecimal value) {
            addCriterion("price_gj_my >", value, "priceGjMy");
            return (Criteria) this;
        }

        public Criteria andPriceGjMyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_gj_my >=", value, "priceGjMy");
            return (Criteria) this;
        }

        public Criteria andPriceGjMyLessThan(BigDecimal value) {
            addCriterion("price_gj_my <", value, "priceGjMy");
            return (Criteria) this;
        }

        public Criteria andPriceGjMyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_gj_my <=", value, "priceGjMy");
            return (Criteria) this;
        }

        public Criteria andPriceGjMyIn(List<BigDecimal> values) {
            addCriterion("price_gj_my in", values, "priceGjMy");
            return (Criteria) this;
        }

        public Criteria andPriceGjMyNotIn(List<BigDecimal> values) {
            addCriterion("price_gj_my not in", values, "priceGjMy");
            return (Criteria) this;
        }

        public Criteria andPriceGjMyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_gj_my between", value1, value2, "priceGjMy");
            return (Criteria) this;
        }

        public Criteria andPriceGjMyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_gj_my not between", value1, value2, "priceGjMy");
            return (Criteria) this;
        }

        public Criteria andSylIsNull() {
            addCriterion("syl is null");
            return (Criteria) this;
        }

        public Criteria andSylIsNotNull() {
            addCriterion("syl is not null");
            return (Criteria) this;
        }

        public Criteria andSylEqualTo(String value) {
            addCriterion("syl =", value, "syl");
            return (Criteria) this;
        }

        public Criteria andSylNotEqualTo(String value) {
            addCriterion("syl <>", value, "syl");
            return (Criteria) this;
        }

        public Criteria andSylGreaterThan(String value) {
            addCriterion("syl >", value, "syl");
            return (Criteria) this;
        }

        public Criteria andSylGreaterThanOrEqualTo(String value) {
            addCriterion("syl >=", value, "syl");
            return (Criteria) this;
        }

        public Criteria andSylLessThan(String value) {
            addCriterion("syl <", value, "syl");
            return (Criteria) this;
        }

        public Criteria andSylLessThanOrEqualTo(String value) {
            addCriterion("syl <=", value, "syl");
            return (Criteria) this;
        }

        public Criteria andSylLike(String value) {
            addCriterion("syl like", value, "syl");
            return (Criteria) this;
        }

        public Criteria andSylNotLike(String value) {
            addCriterion("syl not like", value, "syl");
            return (Criteria) this;
        }

        public Criteria andSylIn(List<String> values) {
            addCriterion("syl in", values, "syl");
            return (Criteria) this;
        }

        public Criteria andSylNotIn(List<String> values) {
            addCriterion("syl not in", values, "syl");
            return (Criteria) this;
        }

        public Criteria andSylBetween(String value1, String value2) {
            addCriterion("syl between", value1, value2, "syl");
            return (Criteria) this;
        }

        public Criteria andSylNotBetween(String value1, String value2) {
            addCriterion("syl not between", value1, value2, "syl");
            return (Criteria) this;
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

        public Criteria andKxfxIdIsNull() {
            addCriterion("kxfx_id is null");
            return (Criteria) this;
        }

        public Criteria andKxfxIdIsNotNull() {
            addCriterion("kxfx_id is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxIdEqualTo(String value) {
            addCriterion("kxfx_id =", value, "kxfxId");
            return (Criteria) this;
        }

        public Criteria andKxfxIdNotEqualTo(String value) {
            addCriterion("kxfx_id <>", value, "kxfxId");
            return (Criteria) this;
        }

        public Criteria andKxfxIdGreaterThan(String value) {
            addCriterion("kxfx_id >", value, "kxfxId");
            return (Criteria) this;
        }

        public Criteria andKxfxIdGreaterThanOrEqualTo(String value) {
            addCriterion("kxfx_id >=", value, "kxfxId");
            return (Criteria) this;
        }

        public Criteria andKxfxIdLessThan(String value) {
            addCriterion("kxfx_id <", value, "kxfxId");
            return (Criteria) this;
        }

        public Criteria andKxfxIdLessThanOrEqualTo(String value) {
            addCriterion("kxfx_id <=", value, "kxfxId");
            return (Criteria) this;
        }

        public Criteria andKxfxIdLike(String value) {
            addCriterion("kxfx_id like", value, "kxfxId");
            return (Criteria) this;
        }

        public Criteria andKxfxIdNotLike(String value) {
            addCriterion("kxfx_id not like", value, "kxfxId");
            return (Criteria) this;
        }

        public Criteria andKxfxIdIn(List<String> values) {
            addCriterion("kxfx_id in", values, "kxfxId");
            return (Criteria) this;
        }

        public Criteria andKxfxIdNotIn(List<String> values) {
            addCriterion("kxfx_id not in", values, "kxfxId");
            return (Criteria) this;
        }

        public Criteria andKxfxIdBetween(String value1, String value2) {
            addCriterion("kxfx_id between", value1, value2, "kxfxId");
            return (Criteria) this;
        }

        public Criteria andKxfxIdNotBetween(String value1, String value2) {
            addCriterion("kxfx_id not between", value1, value2, "kxfxId");
            return (Criteria) this;
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

        public Criteria andIsksshIsNull() {
            addCriterion("iskssh is null");
            return (Criteria) this;
        }

        public Criteria andIsksshIsNotNull() {
            addCriterion("iskssh is not null");
            return (Criteria) this;
        }

        public Criteria andIsksshEqualTo(String value) {
            addCriterion("iskssh =", value, "iskssh");
            return (Criteria) this;
        }

        public Criteria andIsksshNotEqualTo(String value) {
            addCriterion("iskssh <>", value, "iskssh");
            return (Criteria) this;
        }

        public Criteria andIsksshGreaterThan(String value) {
            addCriterion("iskssh >", value, "iskssh");
            return (Criteria) this;
        }

        public Criteria andIsksshGreaterThanOrEqualTo(String value) {
            addCriterion("iskssh >=", value, "iskssh");
            return (Criteria) this;
        }

        public Criteria andIsksshLessThan(String value) {
            addCriterion("iskssh <", value, "iskssh");
            return (Criteria) this;
        }

        public Criteria andIsksshLessThanOrEqualTo(String value) {
            addCriterion("iskssh <=", value, "iskssh");
            return (Criteria) this;
        }

        public Criteria andIsksshLike(String value) {
            addCriterion("iskssh like", value, "iskssh");
            return (Criteria) this;
        }

        public Criteria andIsksshNotLike(String value) {
            addCriterion("iskssh not like", value, "iskssh");
            return (Criteria) this;
        }

        public Criteria andIsksshIn(List<String> values) {
            addCriterion("iskssh in", values, "iskssh");
            return (Criteria) this;
        }

        public Criteria andIsksshNotIn(List<String> values) {
            addCriterion("iskssh not in", values, "iskssh");
            return (Criteria) this;
        }

        public Criteria andIsksshBetween(String value1, String value2) {
            addCriterion("iskssh between", value1, value2, "iskssh");
            return (Criteria) this;
        }

        public Criteria andIsksshNotBetween(String value1, String value2) {
            addCriterion("iskssh not between", value1, value2, "iskssh");
            return (Criteria) this;
        }

        public Criteria andIsyxgccshIsNull() {
            addCriterion("isyxgccsh is null");
            return (Criteria) this;
        }

        public Criteria andIsyxgccshIsNotNull() {
            addCriterion("isyxgccsh is not null");
            return (Criteria) this;
        }

        public Criteria andIsyxgccshEqualTo(String value) {
            addCriterion("isyxgccsh =", value, "isyxgccsh");
            return (Criteria) this;
        }

        public Criteria andIsyxgccshNotEqualTo(String value) {
            addCriterion("isyxgccsh <>", value, "isyxgccsh");
            return (Criteria) this;
        }

        public Criteria andIsyxgccshGreaterThan(String value) {
            addCriterion("isyxgccsh >", value, "isyxgccsh");
            return (Criteria) this;
        }

        public Criteria andIsyxgccshGreaterThanOrEqualTo(String value) {
            addCriterion("isyxgccsh >=", value, "isyxgccsh");
            return (Criteria) this;
        }

        public Criteria andIsyxgccshLessThan(String value) {
            addCriterion("isyxgccsh <", value, "isyxgccsh");
            return (Criteria) this;
        }

        public Criteria andIsyxgccshLessThanOrEqualTo(String value) {
            addCriterion("isyxgccsh <=", value, "isyxgccsh");
            return (Criteria) this;
        }

        public Criteria andIsyxgccshLike(String value) {
            addCriterion("isyxgccsh like", value, "isyxgccsh");
            return (Criteria) this;
        }

        public Criteria andIsyxgccshNotLike(String value) {
            addCriterion("isyxgccsh not like", value, "isyxgccsh");
            return (Criteria) this;
        }

        public Criteria andIsyxgccshIn(List<String> values) {
            addCriterion("isyxgccsh in", values, "isyxgccsh");
            return (Criteria) this;
        }

        public Criteria andIsyxgccshNotIn(List<String> values) {
            addCriterion("isyxgccsh not in", values, "isyxgccsh");
            return (Criteria) this;
        }

        public Criteria andIsyxgccshBetween(String value1, String value2) {
            addCriterion("isyxgccsh between", value1, value2, "isyxgccsh");
            return (Criteria) this;
        }

        public Criteria andIsyxgccshNotBetween(String value1, String value2) {
            addCriterion("isyxgccsh not between", value1, value2, "isyxgccsh");
            return (Criteria) this;
        }

        public Criteria andIszbwyhshIsNull() {
            addCriterion("iszbwyhsh is null");
            return (Criteria) this;
        }

        public Criteria andIszbwyhshIsNotNull() {
            addCriterion("iszbwyhsh is not null");
            return (Criteria) this;
        }

        public Criteria andIszbwyhshEqualTo(String value) {
            addCriterion("iszbwyhsh =", value, "iszbwyhsh");
            return (Criteria) this;
        }

        public Criteria andIszbwyhshNotEqualTo(String value) {
            addCriterion("iszbwyhsh <>", value, "iszbwyhsh");
            return (Criteria) this;
        }

        public Criteria andIszbwyhshGreaterThan(String value) {
            addCriterion("iszbwyhsh >", value, "iszbwyhsh");
            return (Criteria) this;
        }

        public Criteria andIszbwyhshGreaterThanOrEqualTo(String value) {
            addCriterion("iszbwyhsh >=", value, "iszbwyhsh");
            return (Criteria) this;
        }

        public Criteria andIszbwyhshLessThan(String value) {
            addCriterion("iszbwyhsh <", value, "iszbwyhsh");
            return (Criteria) this;
        }

        public Criteria andIszbwyhshLessThanOrEqualTo(String value) {
            addCriterion("iszbwyhsh <=", value, "iszbwyhsh");
            return (Criteria) this;
        }

        public Criteria andIszbwyhshLike(String value) {
            addCriterion("iszbwyhsh like", value, "iszbwyhsh");
            return (Criteria) this;
        }

        public Criteria andIszbwyhshNotLike(String value) {
            addCriterion("iszbwyhsh not like", value, "iszbwyhsh");
            return (Criteria) this;
        }

        public Criteria andIszbwyhshIn(List<String> values) {
            addCriterion("iszbwyhsh in", values, "iszbwyhsh");
            return (Criteria) this;
        }

        public Criteria andIszbwyhshNotIn(List<String> values) {
            addCriterion("iszbwyhsh not in", values, "iszbwyhsh");
            return (Criteria) this;
        }

        public Criteria andIszbwyhshBetween(String value1, String value2) {
            addCriterion("iszbwyhsh between", value1, value2, "iszbwyhsh");
            return (Criteria) this;
        }

        public Criteria andIszbwyhshNotBetween(String value1, String value2) {
            addCriterion("iszbwyhsh not between", value1, value2, "iszbwyhsh");
            return (Criteria) this;
        }

        public Criteria andZbwyhyjIsNull() {
            addCriterion("zbwyhyj is null");
            return (Criteria) this;
        }

        public Criteria andZbwyhyjIsNotNull() {
            addCriterion("zbwyhyj is not null");
            return (Criteria) this;
        }

        public Criteria andZbwyhyjEqualTo(String value) {
            addCriterion("zbwyhyj =", value, "zbwyhyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhyjNotEqualTo(String value) {
            addCriterion("zbwyhyj <>", value, "zbwyhyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhyjGreaterThan(String value) {
            addCriterion("zbwyhyj >", value, "zbwyhyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhyjGreaterThanOrEqualTo(String value) {
            addCriterion("zbwyhyj >=", value, "zbwyhyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhyjLessThan(String value) {
            addCriterion("zbwyhyj <", value, "zbwyhyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhyjLessThanOrEqualTo(String value) {
            addCriterion("zbwyhyj <=", value, "zbwyhyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhyjLike(String value) {
            addCriterion("zbwyhyj like", value, "zbwyhyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhyjNotLike(String value) {
            addCriterion("zbwyhyj not like", value, "zbwyhyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhyjIn(List<String> values) {
            addCriterion("zbwyhyj in", values, "zbwyhyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhyjNotIn(List<String> values) {
            addCriterion("zbwyhyj not in", values, "zbwyhyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhyjBetween(String value1, String value2) {
            addCriterion("zbwyhyj between", value1, value2, "zbwyhyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhyjNotBetween(String value1, String value2) {
            addCriterion("zbwyhyj not between", value1, value2, "zbwyhyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyIdIsNull() {
            addCriterion("zbwyhhy_id is null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyIdIsNotNull() {
            addCriterion("zbwyhhy_id is not null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyIdEqualTo(String value) {
            addCriterion("zbwyhhy_id =", value, "zbwyhhyId");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyIdNotEqualTo(String value) {
            addCriterion("zbwyhhy_id <>", value, "zbwyhhyId");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyIdGreaterThan(String value) {
            addCriterion("zbwyhhy_id >", value, "zbwyhhyId");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyIdGreaterThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_id >=", value, "zbwyhhyId");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyIdLessThan(String value) {
            addCriterion("zbwyhhy_id <", value, "zbwyhhyId");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyIdLessThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_id <=", value, "zbwyhhyId");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyIdLike(String value) {
            addCriterion("zbwyhhy_id like", value, "zbwyhhyId");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyIdNotLike(String value) {
            addCriterion("zbwyhhy_id not like", value, "zbwyhhyId");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyIdIn(List<String> values) {
            addCriterion("zbwyhhy_id in", values, "zbwyhhyId");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyIdNotIn(List<String> values) {
            addCriterion("zbwyhhy_id not in", values, "zbwyhhyId");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyIdBetween(String value1, String value2) {
            addCriterion("zbwyhhy_id between", value1, value2, "zbwyhhyId");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyIdNotBetween(String value1, String value2) {
            addCriterion("zbwyhhy_id not between", value1, value2, "zbwyhhyId");
            return (Criteria) this;
        }

        public Criteria andIsybghshIsNull() {
            addCriterion("isybghsh is null");
            return (Criteria) this;
        }

        public Criteria andIsybghshIsNotNull() {
            addCriterion("isybghsh is not null");
            return (Criteria) this;
        }

        public Criteria andIsybghshEqualTo(String value) {
            addCriterion("isybghsh =", value, "isybghsh");
            return (Criteria) this;
        }

        public Criteria andIsybghshNotEqualTo(String value) {
            addCriterion("isybghsh <>", value, "isybghsh");
            return (Criteria) this;
        }

        public Criteria andIsybghshGreaterThan(String value) {
            addCriterion("isybghsh >", value, "isybghsh");
            return (Criteria) this;
        }

        public Criteria andIsybghshGreaterThanOrEqualTo(String value) {
            addCriterion("isybghsh >=", value, "isybghsh");
            return (Criteria) this;
        }

        public Criteria andIsybghshLessThan(String value) {
            addCriterion("isybghsh <", value, "isybghsh");
            return (Criteria) this;
        }

        public Criteria andIsybghshLessThanOrEqualTo(String value) {
            addCriterion("isybghsh <=", value, "isybghsh");
            return (Criteria) this;
        }

        public Criteria andIsybghshLike(String value) {
            addCriterion("isybghsh like", value, "isybghsh");
            return (Criteria) this;
        }

        public Criteria andIsybghshNotLike(String value) {
            addCriterion("isybghsh not like", value, "isybghsh");
            return (Criteria) this;
        }

        public Criteria andIsybghshIn(List<String> values) {
            addCriterion("isybghsh in", values, "isybghsh");
            return (Criteria) this;
        }

        public Criteria andIsybghshNotIn(List<String> values) {
            addCriterion("isybghsh not in", values, "isybghsh");
            return (Criteria) this;
        }

        public Criteria andIsybghshBetween(String value1, String value2) {
            addCriterion("isybghsh between", value1, value2, "isybghsh");
            return (Criteria) this;
        }

        public Criteria andIsybghshNotBetween(String value1, String value2) {
            addCriterion("isybghsh not between", value1, value2, "isybghsh");
            return (Criteria) this;
        }

        public Criteria andYbghyjIsNull() {
            addCriterion("ybghyj is null");
            return (Criteria) this;
        }

        public Criteria andYbghyjIsNotNull() {
            addCriterion("ybghyj is not null");
            return (Criteria) this;
        }

        public Criteria andYbghyjEqualTo(String value) {
            addCriterion("ybghyj =", value, "ybghyj");
            return (Criteria) this;
        }

        public Criteria andYbghyjNotEqualTo(String value) {
            addCriterion("ybghyj <>", value, "ybghyj");
            return (Criteria) this;
        }

        public Criteria andYbghyjGreaterThan(String value) {
            addCriterion("ybghyj >", value, "ybghyj");
            return (Criteria) this;
        }

        public Criteria andYbghyjGreaterThanOrEqualTo(String value) {
            addCriterion("ybghyj >=", value, "ybghyj");
            return (Criteria) this;
        }

        public Criteria andYbghyjLessThan(String value) {
            addCriterion("ybghyj <", value, "ybghyj");
            return (Criteria) this;
        }

        public Criteria andYbghyjLessThanOrEqualTo(String value) {
            addCriterion("ybghyj <=", value, "ybghyj");
            return (Criteria) this;
        }

        public Criteria andYbghyjLike(String value) {
            addCriterion("ybghyj like", value, "ybghyj");
            return (Criteria) this;
        }

        public Criteria andYbghyjNotLike(String value) {
            addCriterion("ybghyj not like", value, "ybghyj");
            return (Criteria) this;
        }

        public Criteria andYbghyjIn(List<String> values) {
            addCriterion("ybghyj in", values, "ybghyj");
            return (Criteria) this;
        }

        public Criteria andYbghyjNotIn(List<String> values) {
            addCriterion("ybghyj not in", values, "ybghyj");
            return (Criteria) this;
        }

        public Criteria andYbghyjBetween(String value1, String value2) {
            addCriterion("ybghyj between", value1, value2, "ybghyj");
            return (Criteria) this;
        }

        public Criteria andYbghyjNotBetween(String value1, String value2) {
            addCriterion("ybghyj not between", value1, value2, "ybghyj");
            return (Criteria) this;
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

        public Criteria andZtIsNull() {
            addCriterion("zt is null");
            return (Criteria) this;
        }

        public Criteria andZtIsNotNull() {
            addCriterion("zt is not null");
            return (Criteria) this;
        }

        public Criteria andZtEqualTo(String value) {
            addCriterion("zt =", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotEqualTo(String value) {
            addCriterion("zt <>", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThan(String value) {
            addCriterion("zt >", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThanOrEqualTo(String value) {
            addCriterion("zt >=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThan(String value) {
            addCriterion("zt <", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThanOrEqualTo(String value) {
            addCriterion("zt <=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLike(String value) {
            addCriterion("zt like", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotLike(String value) {
            addCriterion("zt not like", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtIn(List<String> values) {
            addCriterion("zt in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotIn(List<String> values) {
            addCriterion("zt not in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtBetween(String value1, String value2) {
            addCriterion("zt between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotBetween(String value1, String value2) {
            addCriterion("zt not between", value1, value2, "zt");
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

        public Criteria andYxgccyjIsNull() {
            addCriterion("yxgccyj is null");
            return (Criteria) this;
        }

        public Criteria andYxgccyjIsNotNull() {
            addCriterion("yxgccyj is not null");
            return (Criteria) this;
        }

        public Criteria andYxgccyjEqualTo(String value) {
            addCriterion("yxgccyj =", value, "yxgccyj");
            return (Criteria) this;
        }

        public Criteria andYxgccyjNotEqualTo(String value) {
            addCriterion("yxgccyj <>", value, "yxgccyj");
            return (Criteria) this;
        }

        public Criteria andYxgccyjGreaterThan(String value) {
            addCriterion("yxgccyj >", value, "yxgccyj");
            return (Criteria) this;
        }

        public Criteria andYxgccyjGreaterThanOrEqualTo(String value) {
            addCriterion("yxgccyj >=", value, "yxgccyj");
            return (Criteria) this;
        }

        public Criteria andYxgccyjLessThan(String value) {
            addCriterion("yxgccyj <", value, "yxgccyj");
            return (Criteria) this;
        }

        public Criteria andYxgccyjLessThanOrEqualTo(String value) {
            addCriterion("yxgccyj <=", value, "yxgccyj");
            return (Criteria) this;
        }

        public Criteria andYxgccyjLike(String value) {
            addCriterion("yxgccyj like", value, "yxgccyj");
            return (Criteria) this;
        }

        public Criteria andYxgccyjNotLike(String value) {
            addCriterion("yxgccyj not like", value, "yxgccyj");
            return (Criteria) this;
        }

        public Criteria andYxgccyjIn(List<String> values) {
            addCriterion("yxgccyj in", values, "yxgccyj");
            return (Criteria) this;
        }

        public Criteria andYxgccyjNotIn(List<String> values) {
            addCriterion("yxgccyj not in", values, "yxgccyj");
            return (Criteria) this;
        }

        public Criteria andYxgccyjBetween(String value1, String value2) {
            addCriterion("yxgccyj between", value1, value2, "yxgccyj");
            return (Criteria) this;
        }

        public Criteria andYxgccyjNotBetween(String value1, String value2) {
            addCriterion("yxgccyj not between", value1, value2, "yxgccyj");
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