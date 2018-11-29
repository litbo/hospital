package com.litbo.hospital.lifemanage.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SgDjhwExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgDjhwExample() {
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

        public Criteria andDjhwIdIsNull() {
            addCriterion("djhw_id is null");
            return (Criteria) this;
        }

        public Criteria andDjhwIdIsNotNull() {
            addCriterion("djhw_id is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwIdEqualTo(String value) {
            addCriterion("djhw_id =", value, "djhwId");
            return (Criteria) this;
        }

        public Criteria andDjhwIdNotEqualTo(String value) {
            addCriterion("djhw_id <>", value, "djhwId");
            return (Criteria) this;
        }

        public Criteria andDjhwIdGreaterThan(String value) {
            addCriterion("djhw_id >", value, "djhwId");
            return (Criteria) this;
        }

        public Criteria andDjhwIdGreaterThanOrEqualTo(String value) {
            addCriterion("djhw_id >=", value, "djhwId");
            return (Criteria) this;
        }

        public Criteria andDjhwIdLessThan(String value) {
            addCriterion("djhw_id <", value, "djhwId");
            return (Criteria) this;
        }

        public Criteria andDjhwIdLessThanOrEqualTo(String value) {
            addCriterion("djhw_id <=", value, "djhwId");
            return (Criteria) this;
        }

        public Criteria andDjhwIdLike(String value) {
            addCriterion("djhw_id like", value, "djhwId");
            return (Criteria) this;
        }

        public Criteria andDjhwIdNotLike(String value) {
            addCriterion("djhw_id not like", value, "djhwId");
            return (Criteria) this;
        }

        public Criteria andDjhwIdIn(List<String> values) {
            addCriterion("djhw_id in", values, "djhwId");
            return (Criteria) this;
        }

        public Criteria andDjhwIdNotIn(List<String> values) {
            addCriterion("djhw_id not in", values, "djhwId");
            return (Criteria) this;
        }

        public Criteria andDjhwIdBetween(String value1, String value2) {
            addCriterion("djhw_id between", value1, value2, "djhwId");
            return (Criteria) this;
        }

        public Criteria andDjhwIdNotBetween(String value1, String value2) {
            addCriterion("djhw_id not between", value1, value2, "djhwId");
            return (Criteria) this;
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

        public Criteria andDjhwDwIsNull() {
            addCriterion("djhw_dw is null");
            return (Criteria) this;
        }

        public Criteria andDjhwDwIsNotNull() {
            addCriterion("djhw_dw is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwDwEqualTo(String value) {
            addCriterion("djhw_dw =", value, "djhwDw");
            return (Criteria) this;
        }

        public Criteria andDjhwDwNotEqualTo(String value) {
            addCriterion("djhw_dw <>", value, "djhwDw");
            return (Criteria) this;
        }

        public Criteria andDjhwDwGreaterThan(String value) {
            addCriterion("djhw_dw >", value, "djhwDw");
            return (Criteria) this;
        }

        public Criteria andDjhwDwGreaterThanOrEqualTo(String value) {
            addCriterion("djhw_dw >=", value, "djhwDw");
            return (Criteria) this;
        }

        public Criteria andDjhwDwLessThan(String value) {
            addCriterion("djhw_dw <", value, "djhwDw");
            return (Criteria) this;
        }

        public Criteria andDjhwDwLessThanOrEqualTo(String value) {
            addCriterion("djhw_dw <=", value, "djhwDw");
            return (Criteria) this;
        }

        public Criteria andDjhwDwLike(String value) {
            addCriterion("djhw_dw like", value, "djhwDw");
            return (Criteria) this;
        }

        public Criteria andDjhwDwNotLike(String value) {
            addCriterion("djhw_dw not like", value, "djhwDw");
            return (Criteria) this;
        }

        public Criteria andDjhwDwIn(List<String> values) {
            addCriterion("djhw_dw in", values, "djhwDw");
            return (Criteria) this;
        }

        public Criteria andDjhwDwNotIn(List<String> values) {
            addCriterion("djhw_dw not in", values, "djhwDw");
            return (Criteria) this;
        }

        public Criteria andDjhwDwBetween(String value1, String value2) {
            addCriterion("djhw_dw between", value1, value2, "djhwDw");
            return (Criteria) this;
        }

        public Criteria andDjhwDwNotBetween(String value1, String value2) {
            addCriterion("djhw_dw not between", value1, value2, "djhwDw");
            return (Criteria) this;
        }

        public Criteria andDjhwBzxhIsNull() {
            addCriterion("djhw_bzxh is null");
            return (Criteria) this;
        }

        public Criteria andDjhwBzxhIsNotNull() {
            addCriterion("djhw_bzxh is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwBzxhEqualTo(Integer value) {
            addCriterion("djhw_bzxh =", value, "djhwBzxh");
            return (Criteria) this;
        }

        public Criteria andDjhwBzxhNotEqualTo(Integer value) {
            addCriterion("djhw_bzxh <>", value, "djhwBzxh");
            return (Criteria) this;
        }

        public Criteria andDjhwBzxhGreaterThan(Integer value) {
            addCriterion("djhw_bzxh >", value, "djhwBzxh");
            return (Criteria) this;
        }

        public Criteria andDjhwBzxhGreaterThanOrEqualTo(Integer value) {
            addCriterion("djhw_bzxh >=", value, "djhwBzxh");
            return (Criteria) this;
        }

        public Criteria andDjhwBzxhLessThan(Integer value) {
            addCriterion("djhw_bzxh <", value, "djhwBzxh");
            return (Criteria) this;
        }

        public Criteria andDjhwBzxhLessThanOrEqualTo(Integer value) {
            addCriterion("djhw_bzxh <=", value, "djhwBzxh");
            return (Criteria) this;
        }

        public Criteria andDjhwBzxhIn(List<Integer> values) {
            addCriterion("djhw_bzxh in", values, "djhwBzxh");
            return (Criteria) this;
        }

        public Criteria andDjhwBzxhNotIn(List<Integer> values) {
            addCriterion("djhw_bzxh not in", values, "djhwBzxh");
            return (Criteria) this;
        }

        public Criteria andDjhwBzxhBetween(Integer value1, Integer value2) {
            addCriterion("djhw_bzxh between", value1, value2, "djhwBzxh");
            return (Criteria) this;
        }

        public Criteria andDjhwBzxhNotBetween(Integer value1, Integer value2) {
            addCriterion("djhw_bzxh not between", value1, value2, "djhwBzxh");
            return (Criteria) this;
        }

        public Criteria andDjhwPpIsNull() {
            addCriterion("djhw_pp is null");
            return (Criteria) this;
        }

        public Criteria andDjhwPpIsNotNull() {
            addCriterion("djhw_pp is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwPpEqualTo(String value) {
            addCriterion("djhw_pp =", value, "djhwPp");
            return (Criteria) this;
        }

        public Criteria andDjhwPpNotEqualTo(String value) {
            addCriterion("djhw_pp <>", value, "djhwPp");
            return (Criteria) this;
        }

        public Criteria andDjhwPpGreaterThan(String value) {
            addCriterion("djhw_pp >", value, "djhwPp");
            return (Criteria) this;
        }

        public Criteria andDjhwPpGreaterThanOrEqualTo(String value) {
            addCriterion("djhw_pp >=", value, "djhwPp");
            return (Criteria) this;
        }

        public Criteria andDjhwPpLessThan(String value) {
            addCriterion("djhw_pp <", value, "djhwPp");
            return (Criteria) this;
        }

        public Criteria andDjhwPpLessThanOrEqualTo(String value) {
            addCriterion("djhw_pp <=", value, "djhwPp");
            return (Criteria) this;
        }

        public Criteria andDjhwPpLike(String value) {
            addCriterion("djhw_pp like", value, "djhwPp");
            return (Criteria) this;
        }

        public Criteria andDjhwPpNotLike(String value) {
            addCriterion("djhw_pp not like", value, "djhwPp");
            return (Criteria) this;
        }

        public Criteria andDjhwPpIn(List<String> values) {
            addCriterion("djhw_pp in", values, "djhwPp");
            return (Criteria) this;
        }

        public Criteria andDjhwPpNotIn(List<String> values) {
            addCriterion("djhw_pp not in", values, "djhwPp");
            return (Criteria) this;
        }

        public Criteria andDjhwPpBetween(String value1, String value2) {
            addCriterion("djhw_pp between", value1, value2, "djhwPp");
            return (Criteria) this;
        }

        public Criteria andDjhwPpNotBetween(String value1, String value2) {
            addCriterion("djhw_pp not between", value1, value2, "djhwPp");
            return (Criteria) this;
        }

        public Criteria andDjhwXnsbIsNull() {
            addCriterion("djhw_xnsb is null");
            return (Criteria) this;
        }

        public Criteria andDjhwXnsbIsNotNull() {
            addCriterion("djhw_xnsb is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwXnsbEqualTo(String value) {
            addCriterion("djhw_xnsb =", value, "djhwXnsb");
            return (Criteria) this;
        }

        public Criteria andDjhwXnsbNotEqualTo(String value) {
            addCriterion("djhw_xnsb <>", value, "djhwXnsb");
            return (Criteria) this;
        }

        public Criteria andDjhwXnsbGreaterThan(String value) {
            addCriterion("djhw_xnsb >", value, "djhwXnsb");
            return (Criteria) this;
        }

        public Criteria andDjhwXnsbGreaterThanOrEqualTo(String value) {
            addCriterion("djhw_xnsb >=", value, "djhwXnsb");
            return (Criteria) this;
        }

        public Criteria andDjhwXnsbLessThan(String value) {
            addCriterion("djhw_xnsb <", value, "djhwXnsb");
            return (Criteria) this;
        }

        public Criteria andDjhwXnsbLessThanOrEqualTo(String value) {
            addCriterion("djhw_xnsb <=", value, "djhwXnsb");
            return (Criteria) this;
        }

        public Criteria andDjhwXnsbLike(String value) {
            addCriterion("djhw_xnsb like", value, "djhwXnsb");
            return (Criteria) this;
        }

        public Criteria andDjhwXnsbNotLike(String value) {
            addCriterion("djhw_xnsb not like", value, "djhwXnsb");
            return (Criteria) this;
        }

        public Criteria andDjhwXnsbIn(List<String> values) {
            addCriterion("djhw_xnsb in", values, "djhwXnsb");
            return (Criteria) this;
        }

        public Criteria andDjhwXnsbNotIn(List<String> values) {
            addCriterion("djhw_xnsb not in", values, "djhwXnsb");
            return (Criteria) this;
        }

        public Criteria andDjhwXnsbBetween(String value1, String value2) {
            addCriterion("djhw_xnsb between", value1, value2, "djhwXnsb");
            return (Criteria) this;
        }

        public Criteria andDjhwXnsbNotBetween(String value1, String value2) {
            addCriterion("djhw_xnsb not between", value1, value2, "djhwXnsb");
            return (Criteria) this;
        }

        public Criteria andDjhwGgIsNull() {
            addCriterion("djhw_gg is null");
            return (Criteria) this;
        }

        public Criteria andDjhwGgIsNotNull() {
            addCriterion("djhw_gg is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwGgEqualTo(String value) {
            addCriterion("djhw_gg =", value, "djhwGg");
            return (Criteria) this;
        }

        public Criteria andDjhwGgNotEqualTo(String value) {
            addCriterion("djhw_gg <>", value, "djhwGg");
            return (Criteria) this;
        }

        public Criteria andDjhwGgGreaterThan(String value) {
            addCriterion("djhw_gg >", value, "djhwGg");
            return (Criteria) this;
        }

        public Criteria andDjhwGgGreaterThanOrEqualTo(String value) {
            addCriterion("djhw_gg >=", value, "djhwGg");
            return (Criteria) this;
        }

        public Criteria andDjhwGgLessThan(String value) {
            addCriterion("djhw_gg <", value, "djhwGg");
            return (Criteria) this;
        }

        public Criteria andDjhwGgLessThanOrEqualTo(String value) {
            addCriterion("djhw_gg <=", value, "djhwGg");
            return (Criteria) this;
        }

        public Criteria andDjhwGgLike(String value) {
            addCriterion("djhw_gg like", value, "djhwGg");
            return (Criteria) this;
        }

        public Criteria andDjhwGgNotLike(String value) {
            addCriterion("djhw_gg not like", value, "djhwGg");
            return (Criteria) this;
        }

        public Criteria andDjhwGgIn(List<String> values) {
            addCriterion("djhw_gg in", values, "djhwGg");
            return (Criteria) this;
        }

        public Criteria andDjhwGgNotIn(List<String> values) {
            addCriterion("djhw_gg not in", values, "djhwGg");
            return (Criteria) this;
        }

        public Criteria andDjhwGgBetween(String value1, String value2) {
            addCriterion("djhw_gg between", value1, value2, "djhwGg");
            return (Criteria) this;
        }

        public Criteria andDjhwGgNotBetween(String value1, String value2) {
            addCriterion("djhw_gg not between", value1, value2, "djhwGg");
            return (Criteria) this;
        }

        public Criteria andDjhwXhIsNull() {
            addCriterion("djhw_xh is null");
            return (Criteria) this;
        }

        public Criteria andDjhwXhIsNotNull() {
            addCriterion("djhw_xh is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwXhEqualTo(String value) {
            addCriterion("djhw_xh =", value, "djhwXh");
            return (Criteria) this;
        }

        public Criteria andDjhwXhNotEqualTo(String value) {
            addCriterion("djhw_xh <>", value, "djhwXh");
            return (Criteria) this;
        }

        public Criteria andDjhwXhGreaterThan(String value) {
            addCriterion("djhw_xh >", value, "djhwXh");
            return (Criteria) this;
        }

        public Criteria andDjhwXhGreaterThanOrEqualTo(String value) {
            addCriterion("djhw_xh >=", value, "djhwXh");
            return (Criteria) this;
        }

        public Criteria andDjhwXhLessThan(String value) {
            addCriterion("djhw_xh <", value, "djhwXh");
            return (Criteria) this;
        }

        public Criteria andDjhwXhLessThanOrEqualTo(String value) {
            addCriterion("djhw_xh <=", value, "djhwXh");
            return (Criteria) this;
        }

        public Criteria andDjhwXhLike(String value) {
            addCriterion("djhw_xh like", value, "djhwXh");
            return (Criteria) this;
        }

        public Criteria andDjhwXhNotLike(String value) {
            addCriterion("djhw_xh not like", value, "djhwXh");
            return (Criteria) this;
        }

        public Criteria andDjhwXhIn(List<String> values) {
            addCriterion("djhw_xh in", values, "djhwXh");
            return (Criteria) this;
        }

        public Criteria andDjhwXhNotIn(List<String> values) {
            addCriterion("djhw_xh not in", values, "djhwXh");
            return (Criteria) this;
        }

        public Criteria andDjhwXhBetween(String value1, String value2) {
            addCriterion("djhw_xh between", value1, value2, "djhwXh");
            return (Criteria) this;
        }

        public Criteria andDjhwXhNotBetween(String value1, String value2) {
            addCriterion("djhw_xh not between", value1, value2, "djhwXh");
            return (Criteria) this;
        }

        public Criteria andDjhwSlIsNull() {
            addCriterion("djhw_sl is null");
            return (Criteria) this;
        }

        public Criteria andDjhwSlIsNotNull() {
            addCriterion("djhw_sl is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwSlEqualTo(Integer value) {
            addCriterion("djhw_sl =", value, "djhwSl");
            return (Criteria) this;
        }

        public Criteria andDjhwSlNotEqualTo(Integer value) {
            addCriterion("djhw_sl <>", value, "djhwSl");
            return (Criteria) this;
        }

        public Criteria andDjhwSlGreaterThan(Integer value) {
            addCriterion("djhw_sl >", value, "djhwSl");
            return (Criteria) this;
        }

        public Criteria andDjhwSlGreaterThanOrEqualTo(Integer value) {
            addCriterion("djhw_sl >=", value, "djhwSl");
            return (Criteria) this;
        }

        public Criteria andDjhwSlLessThan(Integer value) {
            addCriterion("djhw_sl <", value, "djhwSl");
            return (Criteria) this;
        }

        public Criteria andDjhwSlLessThanOrEqualTo(Integer value) {
            addCriterion("djhw_sl <=", value, "djhwSl");
            return (Criteria) this;
        }

        public Criteria andDjhwSlIn(List<Integer> values) {
            addCriterion("djhw_sl in", values, "djhwSl");
            return (Criteria) this;
        }

        public Criteria andDjhwSlNotIn(List<Integer> values) {
            addCriterion("djhw_sl not in", values, "djhwSl");
            return (Criteria) this;
        }

        public Criteria andDjhwSlBetween(Integer value1, Integer value2) {
            addCriterion("djhw_sl between", value1, value2, "djhwSl");
            return (Criteria) this;
        }

        public Criteria andDjhwSlNotBetween(Integer value1, Integer value2) {
            addCriterion("djhw_sl not between", value1, value2, "djhwSl");
            return (Criteria) this;
        }

        public Criteria andDjhwGysIsNull() {
            addCriterion("djhw_gys is null");
            return (Criteria) this;
        }

        public Criteria andDjhwGysIsNotNull() {
            addCriterion("djhw_gys is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwGysEqualTo(String value) {
            addCriterion("djhw_gys =", value, "djhwGys");
            return (Criteria) this;
        }

        public Criteria andDjhwGysNotEqualTo(String value) {
            addCriterion("djhw_gys <>", value, "djhwGys");
            return (Criteria) this;
        }

        public Criteria andDjhwGysGreaterThan(String value) {
            addCriterion("djhw_gys >", value, "djhwGys");
            return (Criteria) this;
        }

        public Criteria andDjhwGysGreaterThanOrEqualTo(String value) {
            addCriterion("djhw_gys >=", value, "djhwGys");
            return (Criteria) this;
        }

        public Criteria andDjhwGysLessThan(String value) {
            addCriterion("djhw_gys <", value, "djhwGys");
            return (Criteria) this;
        }

        public Criteria andDjhwGysLessThanOrEqualTo(String value) {
            addCriterion("djhw_gys <=", value, "djhwGys");
            return (Criteria) this;
        }

        public Criteria andDjhwGysLike(String value) {
            addCriterion("djhw_gys like", value, "djhwGys");
            return (Criteria) this;
        }

        public Criteria andDjhwGysNotLike(String value) {
            addCriterion("djhw_gys not like", value, "djhwGys");
            return (Criteria) this;
        }

        public Criteria andDjhwGysIn(List<String> values) {
            addCriterion("djhw_gys in", values, "djhwGys");
            return (Criteria) this;
        }

        public Criteria andDjhwGysNotIn(List<String> values) {
            addCriterion("djhw_gys not in", values, "djhwGys");
            return (Criteria) this;
        }

        public Criteria andDjhwGysBetween(String value1, String value2) {
            addCriterion("djhw_gys between", value1, value2, "djhwGys");
            return (Criteria) this;
        }

        public Criteria andDjhwGysNotBetween(String value1, String value2) {
            addCriterion("djhw_gys not between", value1, value2, "djhwGys");
            return (Criteria) this;
        }

        public Criteria andDjhwBzIsNull() {
            addCriterion("djhw_bz is null");
            return (Criteria) this;
        }

        public Criteria andDjhwBzIsNotNull() {
            addCriterion("djhw_bz is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwBzEqualTo(String value) {
            addCriterion("djhw_bz =", value, "djhwBz");
            return (Criteria) this;
        }

        public Criteria andDjhwBzNotEqualTo(String value) {
            addCriterion("djhw_bz <>", value, "djhwBz");
            return (Criteria) this;
        }

        public Criteria andDjhwBzGreaterThan(String value) {
            addCriterion("djhw_bz >", value, "djhwBz");
            return (Criteria) this;
        }

        public Criteria andDjhwBzGreaterThanOrEqualTo(String value) {
            addCriterion("djhw_bz >=", value, "djhwBz");
            return (Criteria) this;
        }

        public Criteria andDjhwBzLessThan(String value) {
            addCriterion("djhw_bz <", value, "djhwBz");
            return (Criteria) this;
        }

        public Criteria andDjhwBzLessThanOrEqualTo(String value) {
            addCriterion("djhw_bz <=", value, "djhwBz");
            return (Criteria) this;
        }

        public Criteria andDjhwBzLike(String value) {
            addCriterion("djhw_bz like", value, "djhwBz");
            return (Criteria) this;
        }

        public Criteria andDjhwBzNotLike(String value) {
            addCriterion("djhw_bz not like", value, "djhwBz");
            return (Criteria) this;
        }

        public Criteria andDjhwBzIn(List<String> values) {
            addCriterion("djhw_bz in", values, "djhwBz");
            return (Criteria) this;
        }

        public Criteria andDjhwBzNotIn(List<String> values) {
            addCriterion("djhw_bz not in", values, "djhwBz");
            return (Criteria) this;
        }

        public Criteria andDjhwBzBetween(String value1, String value2) {
            addCriterion("djhw_bz between", value1, value2, "djhwBz");
            return (Criteria) this;
        }

        public Criteria andDjhwBzNotBetween(String value1, String value2) {
            addCriterion("djhw_bz not between", value1, value2, "djhwBz");
            return (Criteria) this;
        }

        public Criteria andDjhwTjIsNull() {
            addCriterion("djhw_tj is null");
            return (Criteria) this;
        }

        public Criteria andDjhwTjIsNotNull() {
            addCriterion("djhw_tj is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwTjEqualTo(Double value) {
            addCriterion("djhw_tj =", value, "djhwTj");
            return (Criteria) this;
        }

        public Criteria andDjhwTjNotEqualTo(Double value) {
            addCriterion("djhw_tj <>", value, "djhwTj");
            return (Criteria) this;
        }

        public Criteria andDjhwTjGreaterThan(Double value) {
            addCriterion("djhw_tj >", value, "djhwTj");
            return (Criteria) this;
        }

        public Criteria andDjhwTjGreaterThanOrEqualTo(Double value) {
            addCriterion("djhw_tj >=", value, "djhwTj");
            return (Criteria) this;
        }

        public Criteria andDjhwTjLessThan(Double value) {
            addCriterion("djhw_tj <", value, "djhwTj");
            return (Criteria) this;
        }

        public Criteria andDjhwTjLessThanOrEqualTo(Double value) {
            addCriterion("djhw_tj <=", value, "djhwTj");
            return (Criteria) this;
        }

        public Criteria andDjhwTjIn(List<Double> values) {
            addCriterion("djhw_tj in", values, "djhwTj");
            return (Criteria) this;
        }

        public Criteria andDjhwTjNotIn(List<Double> values) {
            addCriterion("djhw_tj not in", values, "djhwTj");
            return (Criteria) this;
        }

        public Criteria andDjhwTjBetween(Double value1, Double value2) {
            addCriterion("djhw_tj between", value1, value2, "djhwTj");
            return (Criteria) this;
        }

        public Criteria andDjhwTjNotBetween(Double value1, Double value2) {
            addCriterion("djhw_tj not between", value1, value2, "djhwTj");
            return (Criteria) this;
        }

        public Criteria andDjhwBsbqIsNull() {
            addCriterion("djhw_bsbq is null");
            return (Criteria) this;
        }

        public Criteria andDjhwBsbqIsNotNull() {
            addCriterion("djhw_bsbq is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwBsbqEqualTo(String value) {
            addCriterion("djhw_bsbq =", value, "djhwBsbq");
            return (Criteria) this;
        }

        public Criteria andDjhwBsbqNotEqualTo(String value) {
            addCriterion("djhw_bsbq <>", value, "djhwBsbq");
            return (Criteria) this;
        }

        public Criteria andDjhwBsbqGreaterThan(String value) {
            addCriterion("djhw_bsbq >", value, "djhwBsbq");
            return (Criteria) this;
        }

        public Criteria andDjhwBsbqGreaterThanOrEqualTo(String value) {
            addCriterion("djhw_bsbq >=", value, "djhwBsbq");
            return (Criteria) this;
        }

        public Criteria andDjhwBsbqLessThan(String value) {
            addCriterion("djhw_bsbq <", value, "djhwBsbq");
            return (Criteria) this;
        }

        public Criteria andDjhwBsbqLessThanOrEqualTo(String value) {
            addCriterion("djhw_bsbq <=", value, "djhwBsbq");
            return (Criteria) this;
        }

        public Criteria andDjhwBsbqLike(String value) {
            addCriterion("djhw_bsbq like", value, "djhwBsbq");
            return (Criteria) this;
        }

        public Criteria andDjhwBsbqNotLike(String value) {
            addCriterion("djhw_bsbq not like", value, "djhwBsbq");
            return (Criteria) this;
        }

        public Criteria andDjhwBsbqIn(List<String> values) {
            addCriterion("djhw_bsbq in", values, "djhwBsbq");
            return (Criteria) this;
        }

        public Criteria andDjhwBsbqNotIn(List<String> values) {
            addCriterion("djhw_bsbq not in", values, "djhwBsbq");
            return (Criteria) this;
        }

        public Criteria andDjhwBsbqBetween(String value1, String value2) {
            addCriterion("djhw_bsbq between", value1, value2, "djhwBsbq");
            return (Criteria) this;
        }

        public Criteria andDjhwBsbqNotBetween(String value1, String value2) {
            addCriterion("djhw_bsbq not between", value1, value2, "djhwBsbq");
            return (Criteria) this;
        }

        public Criteria andDjhwHwjzIsNull() {
            addCriterion("djhw_hwjz is null");
            return (Criteria) this;
        }

        public Criteria andDjhwHwjzIsNotNull() {
            addCriterion("djhw_hwjz is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwHwjzEqualTo(BigDecimal value) {
            addCriterion("djhw_hwjz =", value, "djhwHwjz");
            return (Criteria) this;
        }

        public Criteria andDjhwHwjzNotEqualTo(BigDecimal value) {
            addCriterion("djhw_hwjz <>", value, "djhwHwjz");
            return (Criteria) this;
        }

        public Criteria andDjhwHwjzGreaterThan(BigDecimal value) {
            addCriterion("djhw_hwjz >", value, "djhwHwjz");
            return (Criteria) this;
        }

        public Criteria andDjhwHwjzGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("djhw_hwjz >=", value, "djhwHwjz");
            return (Criteria) this;
        }

        public Criteria andDjhwHwjzLessThan(BigDecimal value) {
            addCriterion("djhw_hwjz <", value, "djhwHwjz");
            return (Criteria) this;
        }

        public Criteria andDjhwHwjzLessThanOrEqualTo(BigDecimal value) {
            addCriterion("djhw_hwjz <=", value, "djhwHwjz");
            return (Criteria) this;
        }

        public Criteria andDjhwHwjzIn(List<BigDecimal> values) {
            addCriterion("djhw_hwjz in", values, "djhwHwjz");
            return (Criteria) this;
        }

        public Criteria andDjhwHwjzNotIn(List<BigDecimal> values) {
            addCriterion("djhw_hwjz not in", values, "djhwHwjz");
            return (Criteria) this;
        }

        public Criteria andDjhwHwjzBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("djhw_hwjz between", value1, value2, "djhwHwjz");
            return (Criteria) this;
        }

        public Criteria andDjhwHwjzNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("djhw_hwjz not between", value1, value2, "djhwHwjz");
            return (Criteria) this;
        }

        public Criteria andDjhwSccjIsNull() {
            addCriterion("djhw_sccj is null");
            return (Criteria) this;
        }

        public Criteria andDjhwSccjIsNotNull() {
            addCriterion("djhw_sccj is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwSccjEqualTo(String value) {
            addCriterion("djhw_sccj =", value, "djhwSccj");
            return (Criteria) this;
        }

        public Criteria andDjhwSccjNotEqualTo(String value) {
            addCriterion("djhw_sccj <>", value, "djhwSccj");
            return (Criteria) this;
        }

        public Criteria andDjhwSccjGreaterThan(String value) {
            addCriterion("djhw_sccj >", value, "djhwSccj");
            return (Criteria) this;
        }

        public Criteria andDjhwSccjGreaterThanOrEqualTo(String value) {
            addCriterion("djhw_sccj >=", value, "djhwSccj");
            return (Criteria) this;
        }

        public Criteria andDjhwSccjLessThan(String value) {
            addCriterion("djhw_sccj <", value, "djhwSccj");
            return (Criteria) this;
        }

        public Criteria andDjhwSccjLessThanOrEqualTo(String value) {
            addCriterion("djhw_sccj <=", value, "djhwSccj");
            return (Criteria) this;
        }

        public Criteria andDjhwSccjLike(String value) {
            addCriterion("djhw_sccj like", value, "djhwSccj");
            return (Criteria) this;
        }

        public Criteria andDjhwSccjNotLike(String value) {
            addCriterion("djhw_sccj not like", value, "djhwSccj");
            return (Criteria) this;
        }

        public Criteria andDjhwSccjIn(List<String> values) {
            addCriterion("djhw_sccj in", values, "djhwSccj");
            return (Criteria) this;
        }

        public Criteria andDjhwSccjNotIn(List<String> values) {
            addCriterion("djhw_sccj not in", values, "djhwSccj");
            return (Criteria) this;
        }

        public Criteria andDjhwSccjBetween(String value1, String value2) {
            addCriterion("djhw_sccj between", value1, value2, "djhwSccj");
            return (Criteria) this;
        }

        public Criteria andDjhwSccjNotBetween(String value1, String value2) {
            addCriterion("djhw_sccj not between", value1, value2, "djhwSccj");
            return (Criteria) this;
        }

        public Criteria andDjhwZlIsNull() {
            addCriterion("djhw_zl is null");
            return (Criteria) this;
        }

        public Criteria andDjhwZlIsNotNull() {
            addCriterion("djhw_zl is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwZlEqualTo(Double value) {
            addCriterion("djhw_zl =", value, "djhwZl");
            return (Criteria) this;
        }

        public Criteria andDjhwZlNotEqualTo(Double value) {
            addCriterion("djhw_zl <>", value, "djhwZl");
            return (Criteria) this;
        }

        public Criteria andDjhwZlGreaterThan(Double value) {
            addCriterion("djhw_zl >", value, "djhwZl");
            return (Criteria) this;
        }

        public Criteria andDjhwZlGreaterThanOrEqualTo(Double value) {
            addCriterion("djhw_zl >=", value, "djhwZl");
            return (Criteria) this;
        }

        public Criteria andDjhwZlLessThan(Double value) {
            addCriterion("djhw_zl <", value, "djhwZl");
            return (Criteria) this;
        }

        public Criteria andDjhwZlLessThanOrEqualTo(Double value) {
            addCriterion("djhw_zl <=", value, "djhwZl");
            return (Criteria) this;
        }

        public Criteria andDjhwZlIn(List<Double> values) {
            addCriterion("djhw_zl in", values, "djhwZl");
            return (Criteria) this;
        }

        public Criteria andDjhwZlNotIn(List<Double> values) {
            addCriterion("djhw_zl not in", values, "djhwZl");
            return (Criteria) this;
        }

        public Criteria andDjhwZlBetween(Double value1, Double value2) {
            addCriterion("djhw_zl between", value1, value2, "djhwZl");
            return (Criteria) this;
        }

        public Criteria andDjhwZlNotBetween(Double value1, Double value2) {
            addCriterion("djhw_zl not between", value1, value2, "djhwZl");
            return (Criteria) this;
        }

        public Criteria andDjhwYsbsIsNull() {
            addCriterion("djhw_ysbs is null");
            return (Criteria) this;
        }

        public Criteria andDjhwYsbsIsNotNull() {
            addCriterion("djhw_ysbs is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwYsbsEqualTo(String value) {
            addCriterion("djhw_ysbs =", value, "djhwYsbs");
            return (Criteria) this;
        }

        public Criteria andDjhwYsbsNotEqualTo(String value) {
            addCriterion("djhw_ysbs <>", value, "djhwYsbs");
            return (Criteria) this;
        }

        public Criteria andDjhwYsbsGreaterThan(String value) {
            addCriterion("djhw_ysbs >", value, "djhwYsbs");
            return (Criteria) this;
        }

        public Criteria andDjhwYsbsGreaterThanOrEqualTo(String value) {
            addCriterion("djhw_ysbs >=", value, "djhwYsbs");
            return (Criteria) this;
        }

        public Criteria andDjhwYsbsLessThan(String value) {
            addCriterion("djhw_ysbs <", value, "djhwYsbs");
            return (Criteria) this;
        }

        public Criteria andDjhwYsbsLessThanOrEqualTo(String value) {
            addCriterion("djhw_ysbs <=", value, "djhwYsbs");
            return (Criteria) this;
        }

        public Criteria andDjhwYsbsLike(String value) {
            addCriterion("djhw_ysbs like", value, "djhwYsbs");
            return (Criteria) this;
        }

        public Criteria andDjhwYsbsNotLike(String value) {
            addCriterion("djhw_ysbs not like", value, "djhwYsbs");
            return (Criteria) this;
        }

        public Criteria andDjhwYsbsIn(List<String> values) {
            addCriterion("djhw_ysbs in", values, "djhwYsbs");
            return (Criteria) this;
        }

        public Criteria andDjhwYsbsNotIn(List<String> values) {
            addCriterion("djhw_ysbs not in", values, "djhwYsbs");
            return (Criteria) this;
        }

        public Criteria andDjhwYsbsBetween(String value1, String value2) {
            addCriterion("djhw_ysbs between", value1, value2, "djhwYsbs");
            return (Criteria) this;
        }

        public Criteria andDjhwYsbsNotBetween(String value1, String value2) {
            addCriterion("djhw_ysbs not between", value1, value2, "djhwYsbs");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andDjhwJssjIsNull() {
            addCriterion("djhw_jssj is null");
            return (Criteria) this;
        }

        public Criteria andDjhwJssjIsNotNull() {
            addCriterion("djhw_jssj is not null");
            return (Criteria) this;
        }

        public Criteria andDjhwJssjEqualTo(Date value) {
            addCriterion("djhw_jssj =", value, "djhwJssj");
            return (Criteria) this;
        }

        public Criteria andDjhwJssjNotEqualTo(Date value) {
            addCriterion("djhw_jssj <>", value, "djhwJssj");
            return (Criteria) this;
        }

        public Criteria andDjhwJssjGreaterThan(Date value) {
            addCriterion("djhw_jssj >", value, "djhwJssj");
            return (Criteria) this;
        }

        public Criteria andDjhwJssjGreaterThanOrEqualTo(Date value) {
            addCriterion("djhw_jssj >=", value, "djhwJssj");
            return (Criteria) this;
        }

        public Criteria andDjhwJssjLessThan(Date value) {
            addCriterion("djhw_jssj <", value, "djhwJssj");
            return (Criteria) this;
        }

        public Criteria andDjhwJssjLessThanOrEqualTo(Date value) {
            addCriterion("djhw_jssj <=", value, "djhwJssj");
            return (Criteria) this;
        }

        public Criteria andDjhwJssjIn(List<Date> values) {
            addCriterion("djhw_jssj in", values, "djhwJssj");
            return (Criteria) this;
        }

        public Criteria andDjhwJssjNotIn(List<Date> values) {
            addCriterion("djhw_jssj not in", values, "djhwJssj");
            return (Criteria) this;
        }

        public Criteria andDjhwJssjBetween(Date value1, Date value2) {
            addCriterion("djhw_jssj between", value1, value2, "djhwJssj");
            return (Criteria) this;
        }

        public Criteria andDjhwJssjNotBetween(Date value1, Date value2) {
            addCriterion("djhw_jssj not between", value1, value2, "djhwJssj");
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