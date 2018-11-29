package com.litbo.hospital.lifemanage.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SgDhdjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgDhdjExample() {
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

        public Criteria andDhdjIdIsNull() {
            addCriterion("dhdj_id is null");
            return (Criteria) this;
        }

        public Criteria andDhdjIdIsNotNull() {
            addCriterion("dhdj_id is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjIdEqualTo(String value) {
            addCriterion("dhdj_id =", value, "dhdjId");
            return (Criteria) this;
        }

        public Criteria andDhdjIdNotEqualTo(String value) {
            addCriterion("dhdj_id <>", value, "dhdjId");
            return (Criteria) this;
        }

        public Criteria andDhdjIdGreaterThan(String value) {
            addCriterion("dhdj_id >", value, "dhdjId");
            return (Criteria) this;
        }

        public Criteria andDhdjIdGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_id >=", value, "dhdjId");
            return (Criteria) this;
        }

        public Criteria andDhdjIdLessThan(String value) {
            addCriterion("dhdj_id <", value, "dhdjId");
            return (Criteria) this;
        }

        public Criteria andDhdjIdLessThanOrEqualTo(String value) {
            addCriterion("dhdj_id <=", value, "dhdjId");
            return (Criteria) this;
        }

        public Criteria andDhdjIdLike(String value) {
            addCriterion("dhdj_id like", value, "dhdjId");
            return (Criteria) this;
        }

        public Criteria andDhdjIdNotLike(String value) {
            addCriterion("dhdj_id not like", value, "dhdjId");
            return (Criteria) this;
        }

        public Criteria andDhdjIdIn(List<String> values) {
            addCriterion("dhdj_id in", values, "dhdjId");
            return (Criteria) this;
        }

        public Criteria andDhdjIdNotIn(List<String> values) {
            addCriterion("dhdj_id not in", values, "dhdjId");
            return (Criteria) this;
        }

        public Criteria andDhdjIdBetween(String value1, String value2) {
            addCriterion("dhdj_id between", value1, value2, "dhdjId");
            return (Criteria) this;
        }

        public Criteria andDhdjIdNotBetween(String value1, String value2) {
            addCriterion("dhdj_id not between", value1, value2, "dhdjId");
            return (Criteria) this;
        }

        public Criteria andDhdjShdwIsNull() {
            addCriterion("dhdj_shdw is null");
            return (Criteria) this;
        }

        public Criteria andDhdjShdwIsNotNull() {
            addCriterion("dhdj_shdw is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjShdwEqualTo(String value) {
            addCriterion("dhdj_shdw =", value, "dhdjShdw");
            return (Criteria) this;
        }

        public Criteria andDhdjShdwNotEqualTo(String value) {
            addCriterion("dhdj_shdw <>", value, "dhdjShdw");
            return (Criteria) this;
        }

        public Criteria andDhdjShdwGreaterThan(String value) {
            addCriterion("dhdj_shdw >", value, "dhdjShdw");
            return (Criteria) this;
        }

        public Criteria andDhdjShdwGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_shdw >=", value, "dhdjShdw");
            return (Criteria) this;
        }

        public Criteria andDhdjShdwLessThan(String value) {
            addCriterion("dhdj_shdw <", value, "dhdjShdw");
            return (Criteria) this;
        }

        public Criteria andDhdjShdwLessThanOrEqualTo(String value) {
            addCriterion("dhdj_shdw <=", value, "dhdjShdw");
            return (Criteria) this;
        }

        public Criteria andDhdjShdwLike(String value) {
            addCriterion("dhdj_shdw like", value, "dhdjShdw");
            return (Criteria) this;
        }

        public Criteria andDhdjShdwNotLike(String value) {
            addCriterion("dhdj_shdw not like", value, "dhdjShdw");
            return (Criteria) this;
        }

        public Criteria andDhdjShdwIn(List<String> values) {
            addCriterion("dhdj_shdw in", values, "dhdjShdw");
            return (Criteria) this;
        }

        public Criteria andDhdjShdwNotIn(List<String> values) {
            addCriterion("dhdj_shdw not in", values, "dhdjShdw");
            return (Criteria) this;
        }

        public Criteria andDhdjShdwBetween(String value1, String value2) {
            addCriterion("dhdj_shdw between", value1, value2, "dhdjShdw");
            return (Criteria) this;
        }

        public Criteria andDhdjShdwNotBetween(String value1, String value2) {
            addCriterion("dhdj_shdw not between", value1, value2, "dhdjShdw");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdwIsNull() {
            addCriterion("dhdj_fhdw is null");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdwIsNotNull() {
            addCriterion("dhdj_fhdw is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdwEqualTo(String value) {
            addCriterion("dhdj_fhdw =", value, "dhdjFhdw");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdwNotEqualTo(String value) {
            addCriterion("dhdj_fhdw <>", value, "dhdjFhdw");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdwGreaterThan(String value) {
            addCriterion("dhdj_fhdw >", value, "dhdjFhdw");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdwGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_fhdw >=", value, "dhdjFhdw");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdwLessThan(String value) {
            addCriterion("dhdj_fhdw <", value, "dhdjFhdw");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdwLessThanOrEqualTo(String value) {
            addCriterion("dhdj_fhdw <=", value, "dhdjFhdw");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdwLike(String value) {
            addCriterion("dhdj_fhdw like", value, "dhdjFhdw");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdwNotLike(String value) {
            addCriterion("dhdj_fhdw not like", value, "dhdjFhdw");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdwIn(List<String> values) {
            addCriterion("dhdj_fhdw in", values, "dhdjFhdw");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdwNotIn(List<String> values) {
            addCriterion("dhdj_fhdw not in", values, "dhdjFhdw");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdwBetween(String value1, String value2) {
            addCriterion("dhdj_fhdw between", value1, value2, "dhdjFhdw");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdwNotBetween(String value1, String value2) {
            addCriterion("dhdj_fhdw not between", value1, value2, "dhdjFhdw");
            return (Criteria) this;
        }

        public Criteria andDhdjShrIsNull() {
            addCriterion("dhdj_shr is null");
            return (Criteria) this;
        }

        public Criteria andDhdjShrIsNotNull() {
            addCriterion("dhdj_shr is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjShrEqualTo(String value) {
            addCriterion("dhdj_shr =", value, "dhdjShr");
            return (Criteria) this;
        }

        public Criteria andDhdjShrNotEqualTo(String value) {
            addCriterion("dhdj_shr <>", value, "dhdjShr");
            return (Criteria) this;
        }

        public Criteria andDhdjShrGreaterThan(String value) {
            addCriterion("dhdj_shr >", value, "dhdjShr");
            return (Criteria) this;
        }

        public Criteria andDhdjShrGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_shr >=", value, "dhdjShr");
            return (Criteria) this;
        }

        public Criteria andDhdjShrLessThan(String value) {
            addCriterion("dhdj_shr <", value, "dhdjShr");
            return (Criteria) this;
        }

        public Criteria andDhdjShrLessThanOrEqualTo(String value) {
            addCriterion("dhdj_shr <=", value, "dhdjShr");
            return (Criteria) this;
        }

        public Criteria andDhdjShrLike(String value) {
            addCriterion("dhdj_shr like", value, "dhdjShr");
            return (Criteria) this;
        }

        public Criteria andDhdjShrNotLike(String value) {
            addCriterion("dhdj_shr not like", value, "dhdjShr");
            return (Criteria) this;
        }

        public Criteria andDhdjShrIn(List<String> values) {
            addCriterion("dhdj_shr in", values, "dhdjShr");
            return (Criteria) this;
        }

        public Criteria andDhdjShrNotIn(List<String> values) {
            addCriterion("dhdj_shr not in", values, "dhdjShr");
            return (Criteria) this;
        }

        public Criteria andDhdjShrBetween(String value1, String value2) {
            addCriterion("dhdj_shr between", value1, value2, "dhdjShr");
            return (Criteria) this;
        }

        public Criteria andDhdjShrNotBetween(String value1, String value2) {
            addCriterion("dhdj_shr not between", value1, value2, "dhdjShr");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrIsNull() {
            addCriterion("dhdj_fhr is null");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrIsNotNull() {
            addCriterion("dhdj_fhr is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrEqualTo(String value) {
            addCriterion("dhdj_fhr =", value, "dhdjFhr");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrNotEqualTo(String value) {
            addCriterion("dhdj_fhr <>", value, "dhdjFhr");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrGreaterThan(String value) {
            addCriterion("dhdj_fhr >", value, "dhdjFhr");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_fhr >=", value, "dhdjFhr");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrLessThan(String value) {
            addCriterion("dhdj_fhr <", value, "dhdjFhr");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrLessThanOrEqualTo(String value) {
            addCriterion("dhdj_fhr <=", value, "dhdjFhr");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrLike(String value) {
            addCriterion("dhdj_fhr like", value, "dhdjFhr");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrNotLike(String value) {
            addCriterion("dhdj_fhr not like", value, "dhdjFhr");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrIn(List<String> values) {
            addCriterion("dhdj_fhr in", values, "dhdjFhr");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrNotIn(List<String> values) {
            addCriterion("dhdj_fhr not in", values, "dhdjFhr");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrBetween(String value1, String value2) {
            addCriterion("dhdj_fhr between", value1, value2, "dhdjFhr");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrNotBetween(String value1, String value2) {
            addCriterion("dhdj_fhr not between", value1, value2, "dhdjFhr");
            return (Criteria) this;
        }

        public Criteria andDhdjShrdhIsNull() {
            addCriterion("dhdj_shrdh is null");
            return (Criteria) this;
        }

        public Criteria andDhdjShrdhIsNotNull() {
            addCriterion("dhdj_shrdh is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjShrdhEqualTo(String value) {
            addCriterion("dhdj_shrdh =", value, "dhdjShrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjShrdhNotEqualTo(String value) {
            addCriterion("dhdj_shrdh <>", value, "dhdjShrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjShrdhGreaterThan(String value) {
            addCriterion("dhdj_shrdh >", value, "dhdjShrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjShrdhGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_shrdh >=", value, "dhdjShrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjShrdhLessThan(String value) {
            addCriterion("dhdj_shrdh <", value, "dhdjShrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjShrdhLessThanOrEqualTo(String value) {
            addCriterion("dhdj_shrdh <=", value, "dhdjShrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjShrdhLike(String value) {
            addCriterion("dhdj_shrdh like", value, "dhdjShrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjShrdhNotLike(String value) {
            addCriterion("dhdj_shrdh not like", value, "dhdjShrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjShrdhIn(List<String> values) {
            addCriterion("dhdj_shrdh in", values, "dhdjShrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjShrdhNotIn(List<String> values) {
            addCriterion("dhdj_shrdh not in", values, "dhdjShrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjShrdhBetween(String value1, String value2) {
            addCriterion("dhdj_shrdh between", value1, value2, "dhdjShrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjShrdhNotBetween(String value1, String value2) {
            addCriterion("dhdj_shrdh not between", value1, value2, "dhdjShrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrdhIsNull() {
            addCriterion("dhdj_fhrdh is null");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrdhIsNotNull() {
            addCriterion("dhdj_fhrdh is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrdhEqualTo(String value) {
            addCriterion("dhdj_fhrdh =", value, "dhdjFhrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrdhNotEqualTo(String value) {
            addCriterion("dhdj_fhrdh <>", value, "dhdjFhrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrdhGreaterThan(String value) {
            addCriterion("dhdj_fhrdh >", value, "dhdjFhrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrdhGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_fhrdh >=", value, "dhdjFhrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrdhLessThan(String value) {
            addCriterion("dhdj_fhrdh <", value, "dhdjFhrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrdhLessThanOrEqualTo(String value) {
            addCriterion("dhdj_fhrdh <=", value, "dhdjFhrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrdhLike(String value) {
            addCriterion("dhdj_fhrdh like", value, "dhdjFhrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrdhNotLike(String value) {
            addCriterion("dhdj_fhrdh not like", value, "dhdjFhrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrdhIn(List<String> values) {
            addCriterion("dhdj_fhrdh in", values, "dhdjFhrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrdhNotIn(List<String> values) {
            addCriterion("dhdj_fhrdh not in", values, "dhdjFhrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrdhBetween(String value1, String value2) {
            addCriterion("dhdj_fhrdh between", value1, value2, "dhdjFhrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjFhrdhNotBetween(String value1, String value2) {
            addCriterion("dhdj_fhrdh not between", value1, value2, "dhdjFhrdh");
            return (Criteria) this;
        }

        public Criteria andDhdjMddIsNull() {
            addCriterion("dhdj_mdd is null");
            return (Criteria) this;
        }

        public Criteria andDhdjMddIsNotNull() {
            addCriterion("dhdj_mdd is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjMddEqualTo(String value) {
            addCriterion("dhdj_mdd =", value, "dhdjMdd");
            return (Criteria) this;
        }

        public Criteria andDhdjMddNotEqualTo(String value) {
            addCriterion("dhdj_mdd <>", value, "dhdjMdd");
            return (Criteria) this;
        }

        public Criteria andDhdjMddGreaterThan(String value) {
            addCriterion("dhdj_mdd >", value, "dhdjMdd");
            return (Criteria) this;
        }

        public Criteria andDhdjMddGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_mdd >=", value, "dhdjMdd");
            return (Criteria) this;
        }

        public Criteria andDhdjMddLessThan(String value) {
            addCriterion("dhdj_mdd <", value, "dhdjMdd");
            return (Criteria) this;
        }

        public Criteria andDhdjMddLessThanOrEqualTo(String value) {
            addCriterion("dhdj_mdd <=", value, "dhdjMdd");
            return (Criteria) this;
        }

        public Criteria andDhdjMddLike(String value) {
            addCriterion("dhdj_mdd like", value, "dhdjMdd");
            return (Criteria) this;
        }

        public Criteria andDhdjMddNotLike(String value) {
            addCriterion("dhdj_mdd not like", value, "dhdjMdd");
            return (Criteria) this;
        }

        public Criteria andDhdjMddIn(List<String> values) {
            addCriterion("dhdj_mdd in", values, "dhdjMdd");
            return (Criteria) this;
        }

        public Criteria andDhdjMddNotIn(List<String> values) {
            addCriterion("dhdj_mdd not in", values, "dhdjMdd");
            return (Criteria) this;
        }

        public Criteria andDhdjMddBetween(String value1, String value2) {
            addCriterion("dhdj_mdd between", value1, value2, "dhdjMdd");
            return (Criteria) this;
        }

        public Criteria andDhdjMddNotBetween(String value1, String value2) {
            addCriterion("dhdj_mdd not between", value1, value2, "dhdjMdd");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdIsNull() {
            addCriterion("dhdj_fhd is null");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdIsNotNull() {
            addCriterion("dhdj_fhd is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdEqualTo(String value) {
            addCriterion("dhdj_fhd =", value, "dhdjFhd");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdNotEqualTo(String value) {
            addCriterion("dhdj_fhd <>", value, "dhdjFhd");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdGreaterThan(String value) {
            addCriterion("dhdj_fhd >", value, "dhdjFhd");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_fhd >=", value, "dhdjFhd");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdLessThan(String value) {
            addCriterion("dhdj_fhd <", value, "dhdjFhd");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdLessThanOrEqualTo(String value) {
            addCriterion("dhdj_fhd <=", value, "dhdjFhd");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdLike(String value) {
            addCriterion("dhdj_fhd like", value, "dhdjFhd");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdNotLike(String value) {
            addCriterion("dhdj_fhd not like", value, "dhdjFhd");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdIn(List<String> values) {
            addCriterion("dhdj_fhd in", values, "dhdjFhd");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdNotIn(List<String> values) {
            addCriterion("dhdj_fhd not in", values, "dhdjFhd");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdBetween(String value1, String value2) {
            addCriterion("dhdj_fhd between", value1, value2, "dhdjFhd");
            return (Criteria) this;
        }

        public Criteria andDhdjFhdNotBetween(String value1, String value2) {
            addCriterion("dhdj_fhd not between", value1, value2, "dhdjFhd");
            return (Criteria) this;
        }

        public Criteria andDhdjShxxdzIsNull() {
            addCriterion("dhdj_shxxdz is null");
            return (Criteria) this;
        }

        public Criteria andDhdjShxxdzIsNotNull() {
            addCriterion("dhdj_shxxdz is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjShxxdzEqualTo(String value) {
            addCriterion("dhdj_shxxdz =", value, "dhdjShxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjShxxdzNotEqualTo(String value) {
            addCriterion("dhdj_shxxdz <>", value, "dhdjShxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjShxxdzGreaterThan(String value) {
            addCriterion("dhdj_shxxdz >", value, "dhdjShxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjShxxdzGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_shxxdz >=", value, "dhdjShxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjShxxdzLessThan(String value) {
            addCriterion("dhdj_shxxdz <", value, "dhdjShxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjShxxdzLessThanOrEqualTo(String value) {
            addCriterion("dhdj_shxxdz <=", value, "dhdjShxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjShxxdzLike(String value) {
            addCriterion("dhdj_shxxdz like", value, "dhdjShxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjShxxdzNotLike(String value) {
            addCriterion("dhdj_shxxdz not like", value, "dhdjShxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjShxxdzIn(List<String> values) {
            addCriterion("dhdj_shxxdz in", values, "dhdjShxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjShxxdzNotIn(List<String> values) {
            addCriterion("dhdj_shxxdz not in", values, "dhdjShxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjShxxdzBetween(String value1, String value2) {
            addCriterion("dhdj_shxxdz between", value1, value2, "dhdjShxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjShxxdzNotBetween(String value1, String value2) {
            addCriterion("dhdj_shxxdz not between", value1, value2, "dhdjShxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxxdzIsNull() {
            addCriterion("dhdj_fhxxdz is null");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxxdzIsNotNull() {
            addCriterion("dhdj_fhxxdz is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxxdzEqualTo(String value) {
            addCriterion("dhdj_fhxxdz =", value, "dhdjFhxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxxdzNotEqualTo(String value) {
            addCriterion("dhdj_fhxxdz <>", value, "dhdjFhxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxxdzGreaterThan(String value) {
            addCriterion("dhdj_fhxxdz >", value, "dhdjFhxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxxdzGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_fhxxdz >=", value, "dhdjFhxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxxdzLessThan(String value) {
            addCriterion("dhdj_fhxxdz <", value, "dhdjFhxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxxdzLessThanOrEqualTo(String value) {
            addCriterion("dhdj_fhxxdz <=", value, "dhdjFhxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxxdzLike(String value) {
            addCriterion("dhdj_fhxxdz like", value, "dhdjFhxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxxdzNotLike(String value) {
            addCriterion("dhdj_fhxxdz not like", value, "dhdjFhxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxxdzIn(List<String> values) {
            addCriterion("dhdj_fhxxdz in", values, "dhdjFhxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxxdzNotIn(List<String> values) {
            addCriterion("dhdj_fhxxdz not in", values, "dhdjFhxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxxdzBetween(String value1, String value2) {
            addCriterion("dhdj_fhxxdz between", value1, value2, "dhdjFhxxdz");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxxdzNotBetween(String value1, String value2) {
            addCriterion("dhdj_fhxxdz not between", value1, value2, "dhdjFhxxdz");
            return (Criteria) this;
        }

        public Criteria andDhsjIsNull() {
            addCriterion("dhsj is null");
            return (Criteria) this;
        }

        public Criteria andDhsjIsNotNull() {
            addCriterion("dhsj is not null");
            return (Criteria) this;
        }

        public Criteria andDhsjEqualTo(Date value) {
            addCriterion("dhsj =", value, "dhsj");
            return (Criteria) this;
        }

        public Criteria andDhsjNotEqualTo(Date value) {
            addCriterion("dhsj <>", value, "dhsj");
            return (Criteria) this;
        }

        public Criteria andDhsjGreaterThan(Date value) {
            addCriterion("dhsj >", value, "dhsj");
            return (Criteria) this;
        }

        public Criteria andDhsjGreaterThanOrEqualTo(Date value) {
            addCriterion("dhsj >=", value, "dhsj");
            return (Criteria) this;
        }

        public Criteria andDhsjLessThan(Date value) {
            addCriterion("dhsj <", value, "dhsj");
            return (Criteria) this;
        }

        public Criteria andDhsjLessThanOrEqualTo(Date value) {
            addCriterion("dhsj <=", value, "dhsj");
            return (Criteria) this;
        }

        public Criteria andDhsjIn(List<Date> values) {
            addCriterion("dhsj in", values, "dhsj");
            return (Criteria) this;
        }

        public Criteria andDhsjNotIn(List<Date> values) {
            addCriterion("dhsj not in", values, "dhsj");
            return (Criteria) this;
        }

        public Criteria andDhsjBetween(Date value1, Date value2) {
            addCriterion("dhsj between", value1, value2, "dhsj");
            return (Criteria) this;
        }

        public Criteria andDhsjNotBetween(Date value1, Date value2) {
            addCriterion("dhsj not between", value1, value2, "dhsj");
            return (Criteria) this;
        }

        public Criteria andDhdjWlgsIsNull() {
            addCriterion("dhdj_wlgs is null");
            return (Criteria) this;
        }

        public Criteria andDhdjWlgsIsNotNull() {
            addCriterion("dhdj_wlgs is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjWlgsEqualTo(String value) {
            addCriterion("dhdj_wlgs =", value, "dhdjWlgs");
            return (Criteria) this;
        }

        public Criteria andDhdjWlgsNotEqualTo(String value) {
            addCriterion("dhdj_wlgs <>", value, "dhdjWlgs");
            return (Criteria) this;
        }

        public Criteria andDhdjWlgsGreaterThan(String value) {
            addCriterion("dhdj_wlgs >", value, "dhdjWlgs");
            return (Criteria) this;
        }

        public Criteria andDhdjWlgsGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_wlgs >=", value, "dhdjWlgs");
            return (Criteria) this;
        }

        public Criteria andDhdjWlgsLessThan(String value) {
            addCriterion("dhdj_wlgs <", value, "dhdjWlgs");
            return (Criteria) this;
        }

        public Criteria andDhdjWlgsLessThanOrEqualTo(String value) {
            addCriterion("dhdj_wlgs <=", value, "dhdjWlgs");
            return (Criteria) this;
        }

        public Criteria andDhdjWlgsLike(String value) {
            addCriterion("dhdj_wlgs like", value, "dhdjWlgs");
            return (Criteria) this;
        }

        public Criteria andDhdjWlgsNotLike(String value) {
            addCriterion("dhdj_wlgs not like", value, "dhdjWlgs");
            return (Criteria) this;
        }

        public Criteria andDhdjWlgsIn(List<String> values) {
            addCriterion("dhdj_wlgs in", values, "dhdjWlgs");
            return (Criteria) this;
        }

        public Criteria andDhdjWlgsNotIn(List<String> values) {
            addCriterion("dhdj_wlgs not in", values, "dhdjWlgs");
            return (Criteria) this;
        }

        public Criteria andDhdjWlgsBetween(String value1, String value2) {
            addCriterion("dhdj_wlgs between", value1, value2, "dhdjWlgs");
            return (Criteria) this;
        }

        public Criteria andDhdjWlgsNotBetween(String value1, String value2) {
            addCriterion("dhdj_wlgs not between", value1, value2, "dhdjWlgs");
            return (Criteria) this;
        }

        public Criteria andDhdjBjgsIsNull() {
            addCriterion("dhdj_bjgs is null");
            return (Criteria) this;
        }

        public Criteria andDhdjBjgsIsNotNull() {
            addCriterion("dhdj_bjgs is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjBjgsEqualTo(String value) {
            addCriterion("dhdj_bjgs =", value, "dhdjBjgs");
            return (Criteria) this;
        }

        public Criteria andDhdjBjgsNotEqualTo(String value) {
            addCriterion("dhdj_bjgs <>", value, "dhdjBjgs");
            return (Criteria) this;
        }

        public Criteria andDhdjBjgsGreaterThan(String value) {
            addCriterion("dhdj_bjgs >", value, "dhdjBjgs");
            return (Criteria) this;
        }

        public Criteria andDhdjBjgsGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_bjgs >=", value, "dhdjBjgs");
            return (Criteria) this;
        }

        public Criteria andDhdjBjgsLessThan(String value) {
            addCriterion("dhdj_bjgs <", value, "dhdjBjgs");
            return (Criteria) this;
        }

        public Criteria andDhdjBjgsLessThanOrEqualTo(String value) {
            addCriterion("dhdj_bjgs <=", value, "dhdjBjgs");
            return (Criteria) this;
        }

        public Criteria andDhdjBjgsLike(String value) {
            addCriterion("dhdj_bjgs like", value, "dhdjBjgs");
            return (Criteria) this;
        }

        public Criteria andDhdjBjgsNotLike(String value) {
            addCriterion("dhdj_bjgs not like", value, "dhdjBjgs");
            return (Criteria) this;
        }

        public Criteria andDhdjBjgsIn(List<String> values) {
            addCriterion("dhdj_bjgs in", values, "dhdjBjgs");
            return (Criteria) this;
        }

        public Criteria andDhdjBjgsNotIn(List<String> values) {
            addCriterion("dhdj_bjgs not in", values, "dhdjBjgs");
            return (Criteria) this;
        }

        public Criteria andDhdjBjgsBetween(String value1, String value2) {
            addCriterion("dhdj_bjgs between", value1, value2, "dhdjBjgs");
            return (Criteria) this;
        }

        public Criteria andDhdjBjgsNotBetween(String value1, String value2) {
            addCriterion("dhdj_bjgs not between", value1, value2, "dhdjBjgs");
            return (Criteria) this;
        }

        public Criteria andDhdjYsdhIsNull() {
            addCriterion("dhdj_ysdh is null");
            return (Criteria) this;
        }

        public Criteria andDhdjYsdhIsNotNull() {
            addCriterion("dhdj_ysdh is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjYsdhEqualTo(Integer value) {
            addCriterion("dhdj_ysdh =", value, "dhdjYsdh");
            return (Criteria) this;
        }

        public Criteria andDhdjYsdhNotEqualTo(Integer value) {
            addCriterion("dhdj_ysdh <>", value, "dhdjYsdh");
            return (Criteria) this;
        }

        public Criteria andDhdjYsdhGreaterThan(Integer value) {
            addCriterion("dhdj_ysdh >", value, "dhdjYsdh");
            return (Criteria) this;
        }

        public Criteria andDhdjYsdhGreaterThanOrEqualTo(Integer value) {
            addCriterion("dhdj_ysdh >=", value, "dhdjYsdh");
            return (Criteria) this;
        }

        public Criteria andDhdjYsdhLessThan(Integer value) {
            addCriterion("dhdj_ysdh <", value, "dhdjYsdh");
            return (Criteria) this;
        }

        public Criteria andDhdjYsdhLessThanOrEqualTo(Integer value) {
            addCriterion("dhdj_ysdh <=", value, "dhdjYsdh");
            return (Criteria) this;
        }

        public Criteria andDhdjYsdhIn(List<Integer> values) {
            addCriterion("dhdj_ysdh in", values, "dhdjYsdh");
            return (Criteria) this;
        }

        public Criteria andDhdjYsdhNotIn(List<Integer> values) {
            addCriterion("dhdj_ysdh not in", values, "dhdjYsdh");
            return (Criteria) this;
        }

        public Criteria andDhdjYsdhBetween(Integer value1, Integer value2) {
            addCriterion("dhdj_ysdh between", value1, value2, "dhdjYsdh");
            return (Criteria) this;
        }

        public Criteria andDhdjYsdhNotBetween(Integer value1, Integer value2) {
            addCriterion("dhdj_ysdh not between", value1, value2, "dhdjYsdh");
            return (Criteria) this;
        }

        public Criteria andDhdjByfyIsNull() {
            addCriterion("dhdj_byfy is null");
            return (Criteria) this;
        }

        public Criteria andDhdjByfyIsNotNull() {
            addCriterion("dhdj_byfy is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjByfyEqualTo(BigDecimal value) {
            addCriterion("dhdj_byfy =", value, "dhdjByfy");
            return (Criteria) this;
        }

        public Criteria andDhdjByfyNotEqualTo(BigDecimal value) {
            addCriterion("dhdj_byfy <>", value, "dhdjByfy");
            return (Criteria) this;
        }

        public Criteria andDhdjByfyGreaterThan(BigDecimal value) {
            addCriterion("dhdj_byfy >", value, "dhdjByfy");
            return (Criteria) this;
        }

        public Criteria andDhdjByfyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dhdj_byfy >=", value, "dhdjByfy");
            return (Criteria) this;
        }

        public Criteria andDhdjByfyLessThan(BigDecimal value) {
            addCriterion("dhdj_byfy <", value, "dhdjByfy");
            return (Criteria) this;
        }

        public Criteria andDhdjByfyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dhdj_byfy <=", value, "dhdjByfy");
            return (Criteria) this;
        }

        public Criteria andDhdjByfyIn(List<BigDecimal> values) {
            addCriterion("dhdj_byfy in", values, "dhdjByfy");
            return (Criteria) this;
        }

        public Criteria andDhdjByfyNotIn(List<BigDecimal> values) {
            addCriterion("dhdj_byfy not in", values, "dhdjByfy");
            return (Criteria) this;
        }

        public Criteria andDhdjByfyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dhdj_byfy between", value1, value2, "dhdjByfy");
            return (Criteria) this;
        }

        public Criteria andDhdjByfyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dhdj_byfy not between", value1, value2, "dhdjByfy");
            return (Criteria) this;
        }

        public Criteria andDhdjYsfsIsNull() {
            addCriterion("dhdj_ysfs is null");
            return (Criteria) this;
        }

        public Criteria andDhdjYsfsIsNotNull() {
            addCriterion("dhdj_ysfs is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjYsfsEqualTo(String value) {
            addCriterion("dhdj_ysfs =", value, "dhdjYsfs");
            return (Criteria) this;
        }

        public Criteria andDhdjYsfsNotEqualTo(String value) {
            addCriterion("dhdj_ysfs <>", value, "dhdjYsfs");
            return (Criteria) this;
        }

        public Criteria andDhdjYsfsGreaterThan(String value) {
            addCriterion("dhdj_ysfs >", value, "dhdjYsfs");
            return (Criteria) this;
        }

        public Criteria andDhdjYsfsGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_ysfs >=", value, "dhdjYsfs");
            return (Criteria) this;
        }

        public Criteria andDhdjYsfsLessThan(String value) {
            addCriterion("dhdj_ysfs <", value, "dhdjYsfs");
            return (Criteria) this;
        }

        public Criteria andDhdjYsfsLessThanOrEqualTo(String value) {
            addCriterion("dhdj_ysfs <=", value, "dhdjYsfs");
            return (Criteria) this;
        }

        public Criteria andDhdjYsfsLike(String value) {
            addCriterion("dhdj_ysfs like", value, "dhdjYsfs");
            return (Criteria) this;
        }

        public Criteria andDhdjYsfsNotLike(String value) {
            addCriterion("dhdj_ysfs not like", value, "dhdjYsfs");
            return (Criteria) this;
        }

        public Criteria andDhdjYsfsIn(List<String> values) {
            addCriterion("dhdj_ysfs in", values, "dhdjYsfs");
            return (Criteria) this;
        }

        public Criteria andDhdjYsfsNotIn(List<String> values) {
            addCriterion("dhdj_ysfs not in", values, "dhdjYsfs");
            return (Criteria) this;
        }

        public Criteria andDhdjYsfsBetween(String value1, String value2) {
            addCriterion("dhdj_ysfs between", value1, value2, "dhdjYsfs");
            return (Criteria) this;
        }

        public Criteria andDhdjYsfsNotBetween(String value1, String value2) {
            addCriterion("dhdj_ysfs not between", value1, value2, "dhdjYsfs");
            return (Criteria) this;
        }

        public Criteria andDhdjJsrIsNull() {
            addCriterion("dhdj_jsr is null");
            return (Criteria) this;
        }

        public Criteria andDhdjJsrIsNotNull() {
            addCriterion("dhdj_jsr is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjJsrEqualTo(String value) {
            addCriterion("dhdj_jsr =", value, "dhdjJsr");
            return (Criteria) this;
        }

        public Criteria andDhdjJsrNotEqualTo(String value) {
            addCriterion("dhdj_jsr <>", value, "dhdjJsr");
            return (Criteria) this;
        }

        public Criteria andDhdjJsrGreaterThan(String value) {
            addCriterion("dhdj_jsr >", value, "dhdjJsr");
            return (Criteria) this;
        }

        public Criteria andDhdjJsrGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_jsr >=", value, "dhdjJsr");
            return (Criteria) this;
        }

        public Criteria andDhdjJsrLessThan(String value) {
            addCriterion("dhdj_jsr <", value, "dhdjJsr");
            return (Criteria) this;
        }

        public Criteria andDhdjJsrLessThanOrEqualTo(String value) {
            addCriterion("dhdj_jsr <=", value, "dhdjJsr");
            return (Criteria) this;
        }

        public Criteria andDhdjJsrLike(String value) {
            addCriterion("dhdj_jsr like", value, "dhdjJsr");
            return (Criteria) this;
        }

        public Criteria andDhdjJsrNotLike(String value) {
            addCriterion("dhdj_jsr not like", value, "dhdjJsr");
            return (Criteria) this;
        }

        public Criteria andDhdjJsrIn(List<String> values) {
            addCriterion("dhdj_jsr in", values, "dhdjJsr");
            return (Criteria) this;
        }

        public Criteria andDhdjJsrNotIn(List<String> values) {
            addCriterion("dhdj_jsr not in", values, "dhdjJsr");
            return (Criteria) this;
        }

        public Criteria andDhdjJsrBetween(String value1, String value2) {
            addCriterion("dhdj_jsr between", value1, value2, "dhdjJsr");
            return (Criteria) this;
        }

        public Criteria andDhdjJsrNotBetween(String value1, String value2) {
            addCriterion("dhdj_jsr not between", value1, value2, "dhdjJsr");
            return (Criteria) this;
        }

        public Criteria andDhdjCfddIsNull() {
            addCriterion("dhdj_cfdd is null");
            return (Criteria) this;
        }

        public Criteria andDhdjCfddIsNotNull() {
            addCriterion("dhdj_cfdd is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjCfddEqualTo(String value) {
            addCriterion("dhdj_cfdd =", value, "dhdjCfdd");
            return (Criteria) this;
        }

        public Criteria andDhdjCfddNotEqualTo(String value) {
            addCriterion("dhdj_cfdd <>", value, "dhdjCfdd");
            return (Criteria) this;
        }

        public Criteria andDhdjCfddGreaterThan(String value) {
            addCriterion("dhdj_cfdd >", value, "dhdjCfdd");
            return (Criteria) this;
        }

        public Criteria andDhdjCfddGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_cfdd >=", value, "dhdjCfdd");
            return (Criteria) this;
        }

        public Criteria andDhdjCfddLessThan(String value) {
            addCriterion("dhdj_cfdd <", value, "dhdjCfdd");
            return (Criteria) this;
        }

        public Criteria andDhdjCfddLessThanOrEqualTo(String value) {
            addCriterion("dhdj_cfdd <=", value, "dhdjCfdd");
            return (Criteria) this;
        }

        public Criteria andDhdjCfddLike(String value) {
            addCriterion("dhdj_cfdd like", value, "dhdjCfdd");
            return (Criteria) this;
        }

        public Criteria andDhdjCfddNotLike(String value) {
            addCriterion("dhdj_cfdd not like", value, "dhdjCfdd");
            return (Criteria) this;
        }

        public Criteria andDhdjCfddIn(List<String> values) {
            addCriterion("dhdj_cfdd in", values, "dhdjCfdd");
            return (Criteria) this;
        }

        public Criteria andDhdjCfddNotIn(List<String> values) {
            addCriterion("dhdj_cfdd not in", values, "dhdjCfdd");
            return (Criteria) this;
        }

        public Criteria andDhdjCfddBetween(String value1, String value2) {
            addCriterion("dhdj_cfdd between", value1, value2, "dhdjCfdd");
            return (Criteria) this;
        }

        public Criteria andDhdjCfddNotBetween(String value1, String value2) {
            addCriterion("dhdj_cfdd not between", value1, value2, "dhdjCfdd");
            return (Criteria) this;
        }

        public Criteria andHtIdIsNull() {
            addCriterion("ht_id is null");
            return (Criteria) this;
        }

        public Criteria andHtIdIsNotNull() {
            addCriterion("ht_id is not null");
            return (Criteria) this;
        }

        public Criteria andHtIdEqualTo(String value) {
            addCriterion("ht_id =", value, "htId");
            return (Criteria) this;
        }

        public Criteria andHtIdNotEqualTo(String value) {
            addCriterion("ht_id <>", value, "htId");
            return (Criteria) this;
        }

        public Criteria andHtIdGreaterThan(String value) {
            addCriterion("ht_id >", value, "htId");
            return (Criteria) this;
        }

        public Criteria andHtIdGreaterThanOrEqualTo(String value) {
            addCriterion("ht_id >=", value, "htId");
            return (Criteria) this;
        }

        public Criteria andHtIdLessThan(String value) {
            addCriterion("ht_id <", value, "htId");
            return (Criteria) this;
        }

        public Criteria andHtIdLessThanOrEqualTo(String value) {
            addCriterion("ht_id <=", value, "htId");
            return (Criteria) this;
        }

        public Criteria andHtIdLike(String value) {
            addCriterion("ht_id like", value, "htId");
            return (Criteria) this;
        }

        public Criteria andHtIdNotLike(String value) {
            addCriterion("ht_id not like", value, "htId");
            return (Criteria) this;
        }

        public Criteria andHtIdIn(List<String> values) {
            addCriterion("ht_id in", values, "htId");
            return (Criteria) this;
        }

        public Criteria andHtIdNotIn(List<String> values) {
            addCriterion("ht_id not in", values, "htId");
            return (Criteria) this;
        }

        public Criteria andHtIdBetween(String value1, String value2) {
            addCriterion("ht_id between", value1, value2, "htId");
            return (Criteria) this;
        }

        public Criteria andHtIdNotBetween(String value1, String value2) {
            addCriterion("ht_id not between", value1, value2, "htId");
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

        public Criteria andDhdjFhxsIsNull() {
            addCriterion("dhdj_fhxs is null");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxsIsNotNull() {
            addCriterion("dhdj_fhxs is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxsEqualTo(Integer value) {
            addCriterion("dhdj_fhxs =", value, "dhdjFhxs");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxsNotEqualTo(Integer value) {
            addCriterion("dhdj_fhxs <>", value, "dhdjFhxs");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxsGreaterThan(Integer value) {
            addCriterion("dhdj_fhxs >", value, "dhdjFhxs");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxsGreaterThanOrEqualTo(Integer value) {
            addCriterion("dhdj_fhxs >=", value, "dhdjFhxs");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxsLessThan(Integer value) {
            addCriterion("dhdj_fhxs <", value, "dhdjFhxs");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxsLessThanOrEqualTo(Integer value) {
            addCriterion("dhdj_fhxs <=", value, "dhdjFhxs");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxsIn(List<Integer> values) {
            addCriterion("dhdj_fhxs in", values, "dhdjFhxs");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxsNotIn(List<Integer> values) {
            addCriterion("dhdj_fhxs not in", values, "dhdjFhxs");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxsBetween(Integer value1, Integer value2) {
            addCriterion("dhdj_fhxs between", value1, value2, "dhdjFhxs");
            return (Criteria) this;
        }

        public Criteria andDhdjFhxsNotBetween(Integer value1, Integer value2) {
            addCriterion("dhdj_fhxs not between", value1, value2, "dhdjFhxs");
            return (Criteria) this;
        }

        public Criteria andDhdjSdxsIsNull() {
            addCriterion("dhdj_sdxs is null");
            return (Criteria) this;
        }

        public Criteria andDhdjSdxsIsNotNull() {
            addCriterion("dhdj_sdxs is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjSdxsEqualTo(Integer value) {
            addCriterion("dhdj_sdxs =", value, "dhdjSdxs");
            return (Criteria) this;
        }

        public Criteria andDhdjSdxsNotEqualTo(Integer value) {
            addCriterion("dhdj_sdxs <>", value, "dhdjSdxs");
            return (Criteria) this;
        }

        public Criteria andDhdjSdxsGreaterThan(Integer value) {
            addCriterion("dhdj_sdxs >", value, "dhdjSdxs");
            return (Criteria) this;
        }

        public Criteria andDhdjSdxsGreaterThanOrEqualTo(Integer value) {
            addCriterion("dhdj_sdxs >=", value, "dhdjSdxs");
            return (Criteria) this;
        }

        public Criteria andDhdjSdxsLessThan(Integer value) {
            addCriterion("dhdj_sdxs <", value, "dhdjSdxs");
            return (Criteria) this;
        }

        public Criteria andDhdjSdxsLessThanOrEqualTo(Integer value) {
            addCriterion("dhdj_sdxs <=", value, "dhdjSdxs");
            return (Criteria) this;
        }

        public Criteria andDhdjSdxsIn(List<Integer> values) {
            addCriterion("dhdj_sdxs in", values, "dhdjSdxs");
            return (Criteria) this;
        }

        public Criteria andDhdjSdxsNotIn(List<Integer> values) {
            addCriterion("dhdj_sdxs not in", values, "dhdjSdxs");
            return (Criteria) this;
        }

        public Criteria andDhdjSdxsBetween(Integer value1, Integer value2) {
            addCriterion("dhdj_sdxs between", value1, value2, "dhdjSdxs");
            return (Criteria) this;
        }

        public Criteria andDhdjSdxsNotBetween(Integer value1, Integer value2) {
            addCriterion("dhdj_sdxs not between", value1, value2, "dhdjSdxs");
            return (Criteria) this;
        }

        public Criteria andDhdjCsxsIsNull() {
            addCriterion("dhdj_csxs is null");
            return (Criteria) this;
        }

        public Criteria andDhdjCsxsIsNotNull() {
            addCriterion("dhdj_csxs is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjCsxsEqualTo(Integer value) {
            addCriterion("dhdj_csxs =", value, "dhdjCsxs");
            return (Criteria) this;
        }

        public Criteria andDhdjCsxsNotEqualTo(Integer value) {
            addCriterion("dhdj_csxs <>", value, "dhdjCsxs");
            return (Criteria) this;
        }

        public Criteria andDhdjCsxsGreaterThan(Integer value) {
            addCriterion("dhdj_csxs >", value, "dhdjCsxs");
            return (Criteria) this;
        }

        public Criteria andDhdjCsxsGreaterThanOrEqualTo(Integer value) {
            addCriterion("dhdj_csxs >=", value, "dhdjCsxs");
            return (Criteria) this;
        }

        public Criteria andDhdjCsxsLessThan(Integer value) {
            addCriterion("dhdj_csxs <", value, "dhdjCsxs");
            return (Criteria) this;
        }

        public Criteria andDhdjCsxsLessThanOrEqualTo(Integer value) {
            addCriterion("dhdj_csxs <=", value, "dhdjCsxs");
            return (Criteria) this;
        }

        public Criteria andDhdjCsxsIn(List<Integer> values) {
            addCriterion("dhdj_csxs in", values, "dhdjCsxs");
            return (Criteria) this;
        }

        public Criteria andDhdjCsxsNotIn(List<Integer> values) {
            addCriterion("dhdj_csxs not in", values, "dhdjCsxs");
            return (Criteria) this;
        }

        public Criteria andDhdjCsxsBetween(Integer value1, Integer value2) {
            addCriterion("dhdj_csxs between", value1, value2, "dhdjCsxs");
            return (Criteria) this;
        }

        public Criteria andDhdjCsxsNotBetween(Integer value1, Integer value2) {
            addCriterion("dhdj_csxs not between", value1, value2, "dhdjCsxs");
            return (Criteria) this;
        }

        public Criteria andDhdjBzIsNull() {
            addCriterion("dhdj_bz is null");
            return (Criteria) this;
        }

        public Criteria andDhdjBzIsNotNull() {
            addCriterion("dhdj_bz is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjBzEqualTo(String value) {
            addCriterion("dhdj_bz =", value, "dhdjBz");
            return (Criteria) this;
        }

        public Criteria andDhdjBzNotEqualTo(String value) {
            addCriterion("dhdj_bz <>", value, "dhdjBz");
            return (Criteria) this;
        }

        public Criteria andDhdjBzGreaterThan(String value) {
            addCriterion("dhdj_bz >", value, "dhdjBz");
            return (Criteria) this;
        }

        public Criteria andDhdjBzGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_bz >=", value, "dhdjBz");
            return (Criteria) this;
        }

        public Criteria andDhdjBzLessThan(String value) {
            addCriterion("dhdj_bz <", value, "dhdjBz");
            return (Criteria) this;
        }

        public Criteria andDhdjBzLessThanOrEqualTo(String value) {
            addCriterion("dhdj_bz <=", value, "dhdjBz");
            return (Criteria) this;
        }

        public Criteria andDhdjBzLike(String value) {
            addCriterion("dhdj_bz like", value, "dhdjBz");
            return (Criteria) this;
        }

        public Criteria andDhdjBzNotLike(String value) {
            addCriterion("dhdj_bz not like", value, "dhdjBz");
            return (Criteria) this;
        }

        public Criteria andDhdjBzIn(List<String> values) {
            addCriterion("dhdj_bz in", values, "dhdjBz");
            return (Criteria) this;
        }

        public Criteria andDhdjBzNotIn(List<String> values) {
            addCriterion("dhdj_bz not in", values, "dhdjBz");
            return (Criteria) this;
        }

        public Criteria andDhdjBzBetween(String value1, String value2) {
            addCriterion("dhdj_bz between", value1, value2, "dhdjBz");
            return (Criteria) this;
        }

        public Criteria andDhdjBzNotBetween(String value1, String value2) {
            addCriterion("dhdj_bz not between", value1, value2, "dhdjBz");
            return (Criteria) this;
        }

        public Criteria andDhdjIsqbdhIsNull() {
            addCriterion("dhdj_isqbdh is null");
            return (Criteria) this;
        }

        public Criteria andDhdjIsqbdhIsNotNull() {
            addCriterion("dhdj_isqbdh is not null");
            return (Criteria) this;
        }

        public Criteria andDhdjIsqbdhEqualTo(String value) {
            addCriterion("dhdj_isqbdh =", value, "dhdjIsqbdh");
            return (Criteria) this;
        }

        public Criteria andDhdjIsqbdhNotEqualTo(String value) {
            addCriterion("dhdj_isqbdh <>", value, "dhdjIsqbdh");
            return (Criteria) this;
        }

        public Criteria andDhdjIsqbdhGreaterThan(String value) {
            addCriterion("dhdj_isqbdh >", value, "dhdjIsqbdh");
            return (Criteria) this;
        }

        public Criteria andDhdjIsqbdhGreaterThanOrEqualTo(String value) {
            addCriterion("dhdj_isqbdh >=", value, "dhdjIsqbdh");
            return (Criteria) this;
        }

        public Criteria andDhdjIsqbdhLessThan(String value) {
            addCriterion("dhdj_isqbdh <", value, "dhdjIsqbdh");
            return (Criteria) this;
        }

        public Criteria andDhdjIsqbdhLessThanOrEqualTo(String value) {
            addCriterion("dhdj_isqbdh <=", value, "dhdjIsqbdh");
            return (Criteria) this;
        }

        public Criteria andDhdjIsqbdhLike(String value) {
            addCriterion("dhdj_isqbdh like", value, "dhdjIsqbdh");
            return (Criteria) this;
        }

        public Criteria andDhdjIsqbdhNotLike(String value) {
            addCriterion("dhdj_isqbdh not like", value, "dhdjIsqbdh");
            return (Criteria) this;
        }

        public Criteria andDhdjIsqbdhIn(List<String> values) {
            addCriterion("dhdj_isqbdh in", values, "dhdjIsqbdh");
            return (Criteria) this;
        }

        public Criteria andDhdjIsqbdhNotIn(List<String> values) {
            addCriterion("dhdj_isqbdh not in", values, "dhdjIsqbdh");
            return (Criteria) this;
        }

        public Criteria andDhdjIsqbdhBetween(String value1, String value2) {
            addCriterion("dhdj_isqbdh between", value1, value2, "dhdjIsqbdh");
            return (Criteria) this;
        }

        public Criteria andDhdjIsqbdhNotBetween(String value1, String value2) {
            addCriterion("dhdj_isqbdh not between", value1, value2, "dhdjIsqbdh");
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