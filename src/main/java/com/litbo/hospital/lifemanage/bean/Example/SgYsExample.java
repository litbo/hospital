package com.litbo.hospital.lifemanage.bean.Example;

import lombok.Data;

import java.math.BigDecimal;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

@Data
public class SgYsExample {
    protected String orderByClause;

    protected boolean distinct;
    protected String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    protected List<Criteria> oredCriteria;

    public SgYsExample() {
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

        public Criteria andYsIdIsNull() {
            addCriterion("ys_id is null");
            return (Criteria) this;
        }

        public Criteria andYsIdIsNotNull() {
            addCriterion("ys_id is not null");
            return (Criteria) this;
        }

        public Criteria andYsIdEqualTo(String value) {
            addCriterion("ys_id =", value, "ysId");
            return (Criteria) this;
        }

        public Criteria andYsIdNotEqualTo(String value) {
            addCriterion("ys_id <>", value, "ysId");
            return (Criteria) this;
        }

        public Criteria andYsIdGreaterThan(String value) {
            addCriterion("ys_id >", value, "ysId");
            return (Criteria) this;
        }

        public Criteria andYsIdGreaterThanOrEqualTo(String value) {
            addCriterion("ys_id >=", value, "ysId");
            return (Criteria) this;
        }

        public Criteria andYsIdLessThan(String value) {
            addCriterion("ys_id <", value, "ysId");
            return (Criteria) this;
        }

        public Criteria andYsIdLessThanOrEqualTo(String value) {
            addCriterion("ys_id <=", value, "ysId");
            return (Criteria) this;
        }

        public Criteria andYsIdLike(String value) {
            addCriterion("ys_id like", value, "ysId");
            return (Criteria) this;
        }

        public Criteria andYsIdNotLike(String value) {
            addCriterion("ys_id not like", value, "ysId");
            return (Criteria) this;
        }

        public Criteria andYsIdIn(List<String> values) {
            addCriterion("ys_id in", values, "ysId");
            return (Criteria) this;
        }

        public Criteria andYsIdNotIn(List<String> values) {
            addCriterion("ys_id not in", values, "ysId");
            return (Criteria) this;
        }

        public Criteria andYsIdBetween(String value1, String value2) {
            addCriterion("ys_id between", value1, value2, "ysId");
            return (Criteria) this;
        }

        public Criteria andYsIdNotBetween(String value1, String value2) {
            addCriterion("ys_id not between", value1, value2, "ysId");
            return (Criteria) this;
        }

        public Criteria andYsDabhIsNull() {
            addCriterion("ys_dabh is null");
            return (Criteria) this;
        }

        public Criteria andYsDabhIsNotNull() {
            addCriterion("ys_dabh is not null");
            return (Criteria) this;
        }

        public Criteria andYsDabhEqualTo(String value) {
            addCriterion("ys_dabh =", value, "ysDabh");
            return (Criteria) this;
        }

        public Criteria andYsDabhNotEqualTo(String value) {
            addCriterion("ys_dabh <>", value, "ysDabh");
            return (Criteria) this;
        }

        public Criteria andYsDabhGreaterThan(String value) {
            addCriterion("ys_dabh >", value, "ysDabh");
            return (Criteria) this;
        }

        public Criteria andYsDabhGreaterThanOrEqualTo(String value) {
            addCriterion("ys_dabh >=", value, "ysDabh");
            return (Criteria) this;
        }

        public Criteria andYsDabhLessThan(String value) {
            addCriterion("ys_dabh <", value, "ysDabh");
            return (Criteria) this;
        }

        public Criteria andYsDabhLessThanOrEqualTo(String value) {
            addCriterion("ys_dabh <=", value, "ysDabh");
            return (Criteria) this;
        }

        public Criteria andYsDabhLike(String value) {
            addCriterion("ys_dabh like", value, "ysDabh");
            return (Criteria) this;
        }

        public Criteria andYsDabhNotLike(String value) {
            addCriterion("ys_dabh not like", value, "ysDabh");
            return (Criteria) this;
        }

        public Criteria andYsDabhIn(List<String> values) {
            addCriterion("ys_dabh in", values, "ysDabh");
            return (Criteria) this;
        }

        public Criteria andYsDabhNotIn(List<String> values) {
            addCriterion("ys_dabh not in", values, "ysDabh");
            return (Criteria) this;
        }

        public Criteria andYsDabhBetween(String value1, String value2) {
            addCriterion("ys_dabh between", value1, value2, "ysDabh");
            return (Criteria) this;
        }

        public Criteria andYsDabhNotBetween(String value1, String value2) {
            addCriterion("ys_dabh not between", value1, value2, "ysDabh");
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

        public Criteria andYsZzshjgIsNull() {
            addCriterion("ys_zzshjg is null");
            return (Criteria) this;
        }

        public Criteria andYsZzshjgIsNotNull() {
            addCriterion("ys_zzshjg is not null");
            return (Criteria) this;
        }

        public Criteria andYsZzshjgEqualTo(String value) {
            addCriterion("ys_zzshjg =", value, "ysZzshjg");
            return (Criteria) this;
        }

        public Criteria andYsZzshjgNotEqualTo(String value) {
            addCriterion("ys_zzshjg <>", value, "ysZzshjg");
            return (Criteria) this;
        }

        public Criteria andYsZzshjgGreaterThan(String value) {
            addCriterion("ys_zzshjg >", value, "ysZzshjg");
            return (Criteria) this;
        }

        public Criteria andYsZzshjgGreaterThanOrEqualTo(String value) {
            addCriterion("ys_zzshjg >=", value, "ysZzshjg");
            return (Criteria) this;
        }

        public Criteria andYsZzshjgLessThan(String value) {
            addCriterion("ys_zzshjg <", value, "ysZzshjg");
            return (Criteria) this;
        }

        public Criteria andYsZzshjgLessThanOrEqualTo(String value) {
            addCriterion("ys_zzshjg <=", value, "ysZzshjg");
            return (Criteria) this;
        }

        public Criteria andYsZzshjgLike(String value) {
            addCriterion("ys_zzshjg like", value, "ysZzshjg");
            return (Criteria) this;
        }

        public Criteria andYsZzshjgNotLike(String value) {
            addCriterion("ys_zzshjg not like", value, "ysZzshjg");
            return (Criteria) this;
        }

        public Criteria andYsZzshjgIn(List<String> values) {
            addCriterion("ys_zzshjg in", values, "ysZzshjg");
            return (Criteria) this;
        }

        public Criteria andYsZzshjgNotIn(List<String> values) {
            addCriterion("ys_zzshjg not in", values, "ysZzshjg");
            return (Criteria) this;
        }

        public Criteria andYsZzshjgBetween(String value1, String value2) {
            addCriterion("ys_zzshjg between", value1, value2, "ysZzshjg");
            return (Criteria) this;
        }

        public Criteria andYsZzshjgNotBetween(String value1, String value2) {
            addCriterion("ys_zzshjg not between", value1, value2, "ysZzshjg");
            return (Criteria) this;
        }

        public Criteria andYsZzshrIsNull() {
            addCriterion("ys_zzshr is null");
            return (Criteria) this;
        }

        public Criteria andYsZzshrIsNotNull() {
            addCriterion("ys_zzshr is not null");
            return (Criteria) this;
        }

        public Criteria andYsZzshrEqualTo(String value) {
            addCriterion("ys_zzshr =", value, "ysZzshr");
            return (Criteria) this;
        }

        public Criteria andYsZzshrNotEqualTo(String value) {
            addCriterion("ys_zzshr <>", value, "ysZzshr");
            return (Criteria) this;
        }

        public Criteria andYsZzshrGreaterThan(String value) {
            addCriterion("ys_zzshr >", value, "ysZzshr");
            return (Criteria) this;
        }

        public Criteria andYsZzshrGreaterThanOrEqualTo(String value) {
            addCriterion("ys_zzshr >=", value, "ysZzshr");
            return (Criteria) this;
        }

        public Criteria andYsZzshrLessThan(String value) {
            addCriterion("ys_zzshr <", value, "ysZzshr");
            return (Criteria) this;
        }

        public Criteria andYsZzshrLessThanOrEqualTo(String value) {
            addCriterion("ys_zzshr <=", value, "ysZzshr");
            return (Criteria) this;
        }

        public Criteria andYsZzshrLike(String value) {
            addCriterion("ys_zzshr like", value, "ysZzshr");
            return (Criteria) this;
        }

        public Criteria andYsZzshrNotLike(String value) {
            addCriterion("ys_zzshr not like", value, "ysZzshr");
            return (Criteria) this;
        }

        public Criteria andYsZzshrIn(List<String> values) {
            addCriterion("ys_zzshr in", values, "ysZzshr");
            return (Criteria) this;
        }

        public Criteria andYsZzshrNotIn(List<String> values) {
            addCriterion("ys_zzshr not in", values, "ysZzshr");
            return (Criteria) this;
        }

        public Criteria andYsZzshrBetween(String value1, String value2) {
            addCriterion("ys_zzshr between", value1, value2, "ysZzshr");
            return (Criteria) this;
        }

        public Criteria andYsZzshrNotBetween(String value1, String value2) {
            addCriterion("ys_zzshr not between", value1, value2, "ysZzshr");
            return (Criteria) this;
        }

        public Criteria andYsZxdIsNull() {
            addCriterion("ys_zxd is null");
            return (Criteria) this;
        }

        public Criteria andYsZxdIsNotNull() {
            addCriterion("ys_zxd is not null");
            return (Criteria) this;
        }

        public Criteria andYsZxdEqualTo(String value) {
            addCriterion("ys_zxd =", value, "ysZxd");
            return (Criteria) this;
        }

        public Criteria andYsZxdNotEqualTo(String value) {
            addCriterion("ys_zxd <>", value, "ysZxd");
            return (Criteria) this;
        }

        public Criteria andYsZxdGreaterThan(String value) {
            addCriterion("ys_zxd >", value, "ysZxd");
            return (Criteria) this;
        }

        public Criteria andYsZxdGreaterThanOrEqualTo(String value) {
            addCriterion("ys_zxd >=", value, "ysZxd");
            return (Criteria) this;
        }

        public Criteria andYsZxdLessThan(String value) {
            addCriterion("ys_zxd <", value, "ysZxd");
            return (Criteria) this;
        }

        public Criteria andYsZxdLessThanOrEqualTo(String value) {
            addCriterion("ys_zxd <=", value, "ysZxd");
            return (Criteria) this;
        }

        public Criteria andYsZxdLike(String value) {
            addCriterion("ys_zxd like", value, "ysZxd");
            return (Criteria) this;
        }

        public Criteria andYsZxdNotLike(String value) {
            addCriterion("ys_zxd not like", value, "ysZxd");
            return (Criteria) this;
        }

        public Criteria andYsZxdIn(List<String> values) {
            addCriterion("ys_zxd in", values, "ysZxd");
            return (Criteria) this;
        }

        public Criteria andYsZxdNotIn(List<String> values) {
            addCriterion("ys_zxd not in", values, "ysZxd");
            return (Criteria) this;
        }

        public Criteria andYsZxdBetween(String value1, String value2) {
            addCriterion("ys_zxd between", value1, value2, "ysZxd");
            return (Criteria) this;
        }

        public Criteria andYsZxdNotBetween(String value1, String value2) {
            addCriterion("ys_zxd not between", value1, value2, "ysZxd");
            return (Criteria) this;
        }

        public Criteria andYsSmsIsNull() {
            addCriterion("ys_sms is null");
            return (Criteria) this;
        }

        public Criteria andYsSmsIsNotNull() {
            addCriterion("ys_sms is not null");
            return (Criteria) this;
        }

        public Criteria andYsSmsEqualTo(String value) {
            addCriterion("ys_sms =", value, "ysSms");
            return (Criteria) this;
        }

        public Criteria andYsSmsNotEqualTo(String value) {
            addCriterion("ys_sms <>", value, "ysSms");
            return (Criteria) this;
        }

        public Criteria andYsSmsGreaterThan(String value) {
            addCriterion("ys_sms >", value, "ysSms");
            return (Criteria) this;
        }

        public Criteria andYsSmsGreaterThanOrEqualTo(String value) {
            addCriterion("ys_sms >=", value, "ysSms");
            return (Criteria) this;
        }

        public Criteria andYsSmsLessThan(String value) {
            addCriterion("ys_sms <", value, "ysSms");
            return (Criteria) this;
        }

        public Criteria andYsSmsLessThanOrEqualTo(String value) {
            addCriterion("ys_sms <=", value, "ysSms");
            return (Criteria) this;
        }

        public Criteria andYsSmsLike(String value) {
            addCriterion("ys_sms like", value, "ysSms");
            return (Criteria) this;
        }

        public Criteria andYsSmsNotLike(String value) {
            addCriterion("ys_sms not like", value, "ysSms");
            return (Criteria) this;
        }

        public Criteria andYsSmsIn(List<String> values) {
            addCriterion("ys_sms in", values, "ysSms");
            return (Criteria) this;
        }

        public Criteria andYsSmsNotIn(List<String> values) {
            addCriterion("ys_sms not in", values, "ysSms");
            return (Criteria) this;
        }

        public Criteria andYsSmsBetween(String value1, String value2) {
            addCriterion("ys_sms between", value1, value2, "ysSms");
            return (Criteria) this;
        }

        public Criteria andYsSmsNotBetween(String value1, String value2) {
            addCriterion("ys_sms not between", value1, value2, "ysSms");
            return (Criteria) this;
        }

        public Criteria andYsCzscIsNull() {
            addCriterion("ys_czsc is null");
            return (Criteria) this;
        }

        public Criteria andYsCzscIsNotNull() {
            addCriterion("ys_czsc is not null");
            return (Criteria) this;
        }

        public Criteria andYsCzscEqualTo(String value) {
            addCriterion("ys_czsc =", value, "ysCzsc");
            return (Criteria) this;
        }

        public Criteria andYsCzscNotEqualTo(String value) {
            addCriterion("ys_czsc <>", value, "ysCzsc");
            return (Criteria) this;
        }

        public Criteria andYsCzscGreaterThan(String value) {
            addCriterion("ys_czsc >", value, "ysCzsc");
            return (Criteria) this;
        }

        public Criteria andYsCzscGreaterThanOrEqualTo(String value) {
            addCriterion("ys_czsc >=", value, "ysCzsc");
            return (Criteria) this;
        }

        public Criteria andYsCzscLessThan(String value) {
            addCriterion("ys_czsc <", value, "ysCzsc");
            return (Criteria) this;
        }

        public Criteria andYsCzscLessThanOrEqualTo(String value) {
            addCriterion("ys_czsc <=", value, "ysCzsc");
            return (Criteria) this;
        }

        public Criteria andYsCzscLike(String value) {
            addCriterion("ys_czsc like", value, "ysCzsc");
            return (Criteria) this;
        }

        public Criteria andYsCzscNotLike(String value) {
            addCriterion("ys_czsc not like", value, "ysCzsc");
            return (Criteria) this;
        }

        public Criteria andYsCzscIn(List<String> values) {
            addCriterion("ys_czsc in", values, "ysCzsc");
            return (Criteria) this;
        }

        public Criteria andYsCzscNotIn(List<String> values) {
            addCriterion("ys_czsc not in", values, "ysCzsc");
            return (Criteria) this;
        }

        public Criteria andYsCzscBetween(String value1, String value2) {
            addCriterion("ys_czsc between", value1, value2, "ysCzsc");
            return (Criteria) this;
        }

        public Criteria andYsCzscNotBetween(String value1, String value2) {
            addCriterion("ys_czsc not between", value1, value2, "ysCzsc");
            return (Criteria) this;
        }

        public Criteria andYsWxscIsNull() {
            addCriterion("ys_wxsc is null");
            return (Criteria) this;
        }

        public Criteria andYsWxscIsNotNull() {
            addCriterion("ys_wxsc is not null");
            return (Criteria) this;
        }

        public Criteria andYsWxscEqualTo(String value) {
            addCriterion("ys_wxsc =", value, "ysWxsc");
            return (Criteria) this;
        }

        public Criteria andYsWxscNotEqualTo(String value) {
            addCriterion("ys_wxsc <>", value, "ysWxsc");
            return (Criteria) this;
        }

        public Criteria andYsWxscGreaterThan(String value) {
            addCriterion("ys_wxsc >", value, "ysWxsc");
            return (Criteria) this;
        }

        public Criteria andYsWxscGreaterThanOrEqualTo(String value) {
            addCriterion("ys_wxsc >=", value, "ysWxsc");
            return (Criteria) this;
        }

        public Criteria andYsWxscLessThan(String value) {
            addCriterion("ys_wxsc <", value, "ysWxsc");
            return (Criteria) this;
        }

        public Criteria andYsWxscLessThanOrEqualTo(String value) {
            addCriterion("ys_wxsc <=", value, "ysWxsc");
            return (Criteria) this;
        }

        public Criteria andYsWxscLike(String value) {
            addCriterion("ys_wxsc like", value, "ysWxsc");
            return (Criteria) this;
        }

        public Criteria andYsWxscNotLike(String value) {
            addCriterion("ys_wxsc not like", value, "ysWxsc");
            return (Criteria) this;
        }

        public Criteria andYsWxscIn(List<String> values) {
            addCriterion("ys_wxsc in", values, "ysWxsc");
            return (Criteria) this;
        }

        public Criteria andYsWxscNotIn(List<String> values) {
            addCriterion("ys_wxsc not in", values, "ysWxsc");
            return (Criteria) this;
        }

        public Criteria andYsWxscBetween(String value1, String value2) {
            addCriterion("ys_wxsc between", value1, value2, "ysWxsc");
            return (Criteria) this;
        }

        public Criteria andYsWxscNotBetween(String value1, String value2) {
            addCriterion("ys_wxsc not between", value1, value2, "ysWxsc");
            return (Criteria) this;
        }

        public Criteria andYsQtjszlIsNull() {
            addCriterion("ys_qtjszl is null");
            return (Criteria) this;
        }

        public Criteria andYsQtjszlIsNotNull() {
            addCriterion("ys_qtjszl is not null");
            return (Criteria) this;
        }

        public Criteria andYsQtjszlEqualTo(String value) {
            addCriterion("ys_qtjszl =", value, "ysQtjszl");
            return (Criteria) this;
        }

        public Criteria andYsQtjszlNotEqualTo(String value) {
            addCriterion("ys_qtjszl <>", value, "ysQtjszl");
            return (Criteria) this;
        }

        public Criteria andYsQtjszlGreaterThan(String value) {
            addCriterion("ys_qtjszl >", value, "ysQtjszl");
            return (Criteria) this;
        }

        public Criteria andYsQtjszlGreaterThanOrEqualTo(String value) {
            addCriterion("ys_qtjszl >=", value, "ysQtjszl");
            return (Criteria) this;
        }

        public Criteria andYsQtjszlLessThan(String value) {
            addCriterion("ys_qtjszl <", value, "ysQtjszl");
            return (Criteria) this;
        }

        public Criteria andYsQtjszlLessThanOrEqualTo(String value) {
            addCriterion("ys_qtjszl <=", value, "ysQtjszl");
            return (Criteria) this;
        }

        public Criteria andYsQtjszlLike(String value) {
            addCriterion("ys_qtjszl like", value, "ysQtjszl");
            return (Criteria) this;
        }

        public Criteria andYsQtjszlNotLike(String value) {
            addCriterion("ys_qtjszl not like", value, "ysQtjszl");
            return (Criteria) this;
        }

        public Criteria andYsQtjszlIn(List<String> values) {
            addCriterion("ys_qtjszl in", values, "ysQtjszl");
            return (Criteria) this;
        }

        public Criteria andYsQtjszlNotIn(List<String> values) {
            addCriterion("ys_qtjszl not in", values, "ysQtjszl");
            return (Criteria) this;
        }

        public Criteria andYsQtjszlBetween(String value1, String value2) {
            addCriterion("ys_qtjszl between", value1, value2, "ysQtjszl");
            return (Criteria) this;
        }

        public Criteria andYsQtjszlNotBetween(String value1, String value2) {
            addCriterion("ys_qtjszl not between", value1, value2, "ysQtjszl");
            return (Criteria) this;
        }

        public Criteria andYsCphgzmIsNull() {
            addCriterion("ys_cphgzm is null");
            return (Criteria) this;
        }

        public Criteria andYsCphgzmIsNotNull() {
            addCriterion("ys_cphgzm is not null");
            return (Criteria) this;
        }

        public Criteria andYsCphgzmEqualTo(String value) {
            addCriterion("ys_cphgzm =", value, "ysCphgzm");
            return (Criteria) this;
        }

        public Criteria andYsCphgzmNotEqualTo(String value) {
            addCriterion("ys_cphgzm <>", value, "ysCphgzm");
            return (Criteria) this;
        }

        public Criteria andYsCphgzmGreaterThan(String value) {
            addCriterion("ys_cphgzm >", value, "ysCphgzm");
            return (Criteria) this;
        }

        public Criteria andYsCphgzmGreaterThanOrEqualTo(String value) {
            addCriterion("ys_cphgzm >=", value, "ysCphgzm");
            return (Criteria) this;
        }

        public Criteria andYsCphgzmLessThan(String value) {
            addCriterion("ys_cphgzm <", value, "ysCphgzm");
            return (Criteria) this;
        }

        public Criteria andYsCphgzmLessThanOrEqualTo(String value) {
            addCriterion("ys_cphgzm <=", value, "ysCphgzm");
            return (Criteria) this;
        }

        public Criteria andYsCphgzmLike(String value) {
            addCriterion("ys_cphgzm like", value, "ysCphgzm");
            return (Criteria) this;
        }

        public Criteria andYsCphgzmNotLike(String value) {
            addCriterion("ys_cphgzm not like", value, "ysCphgzm");
            return (Criteria) this;
        }

        public Criteria andYsCphgzmIn(List<String> values) {
            addCriterion("ys_cphgzm in", values, "ysCphgzm");
            return (Criteria) this;
        }

        public Criteria andYsCphgzmNotIn(List<String> values) {
            addCriterion("ys_cphgzm not in", values, "ysCphgzm");
            return (Criteria) this;
        }

        public Criteria andYsCphgzmBetween(String value1, String value2) {
            addCriterion("ys_cphgzm between", value1, value2, "ysCphgzm");
            return (Criteria) this;
        }

        public Criteria andYsCphgzmNotBetween(String value1, String value2) {
            addCriterion("ys_cphgzm not between", value1, value2, "ysCphgzm");
            return (Criteria) this;
        }

        public Criteria andYsBxkIsNull() {
            addCriterion("ys_bxk is null");
            return (Criteria) this;
        }

        public Criteria andYsBxkIsNotNull() {
            addCriterion("ys_bxk is not null");
            return (Criteria) this;
        }

        public Criteria andYsBxkEqualTo(String value) {
            addCriterion("ys_bxk =", value, "ysBxk");
            return (Criteria) this;
        }

        public Criteria andYsBxkNotEqualTo(String value) {
            addCriterion("ys_bxk <>", value, "ysBxk");
            return (Criteria) this;
        }

        public Criteria andYsBxkGreaterThan(String value) {
            addCriterion("ys_bxk >", value, "ysBxk");
            return (Criteria) this;
        }

        public Criteria andYsBxkGreaterThanOrEqualTo(String value) {
            addCriterion("ys_bxk >=", value, "ysBxk");
            return (Criteria) this;
        }

        public Criteria andYsBxkLessThan(String value) {
            addCriterion("ys_bxk <", value, "ysBxk");
            return (Criteria) this;
        }

        public Criteria andYsBxkLessThanOrEqualTo(String value) {
            addCriterion("ys_bxk <=", value, "ysBxk");
            return (Criteria) this;
        }

        public Criteria andYsBxkLike(String value) {
            addCriterion("ys_bxk like", value, "ysBxk");
            return (Criteria) this;
        }

        public Criteria andYsBxkNotLike(String value) {
            addCriterion("ys_bxk not like", value, "ysBxk");
            return (Criteria) this;
        }

        public Criteria andYsBxkIn(List<String> values) {
            addCriterion("ys_bxk in", values, "ysBxk");
            return (Criteria) this;
        }

        public Criteria andYsBxkNotIn(List<String> values) {
            addCriterion("ys_bxk not in", values, "ysBxk");
            return (Criteria) this;
        }

        public Criteria andYsBxkBetween(String value1, String value2) {
            addCriterion("ys_bxk between", value1, value2, "ysBxk");
            return (Criteria) this;
        }

        public Criteria andYsBxkNotBetween(String value1, String value2) {
            addCriterion("ys_bxk not between", value1, value2, "ysBxk");
            return (Criteria) this;
        }

        public Criteria andYs3crzIsNull() {
            addCriterion("ys_3crz is null");
            return (Criteria) this;
        }

        public Criteria andYs3crzIsNotNull() {
            addCriterion("ys_3crz is not null");
            return (Criteria) this;
        }

        public Criteria andYs3crzEqualTo(String value) {
            addCriterion("ys_3crz =", value, "ys3crz");
            return (Criteria) this;
        }

        public Criteria andYs3crzNotEqualTo(String value) {
            addCriterion("ys_3crz <>", value, "ys3crz");
            return (Criteria) this;
        }

        public Criteria andYs3crzGreaterThan(String value) {
            addCriterion("ys_3crz >", value, "ys3crz");
            return (Criteria) this;
        }

        public Criteria andYs3crzGreaterThanOrEqualTo(String value) {
            addCriterion("ys_3crz >=", value, "ys3crz");
            return (Criteria) this;
        }

        public Criteria andYs3crzLessThan(String value) {
            addCriterion("ys_3crz <", value, "ys3crz");
            return (Criteria) this;
        }

        public Criteria andYs3crzLessThanOrEqualTo(String value) {
            addCriterion("ys_3crz <=", value, "ys3crz");
            return (Criteria) this;
        }

        public Criteria andYs3crzLike(String value) {
            addCriterion("ys_3crz like", value, "ys3crz");
            return (Criteria) this;
        }

        public Criteria andYs3crzNotLike(String value) {
            addCriterion("ys_3crz not like", value, "ys3crz");
            return (Criteria) this;
        }

        public Criteria andYs3crzIn(List<String> values) {
            addCriterion("ys_3crz in", values, "ys3crz");
            return (Criteria) this;
        }

        public Criteria andYs3crzNotIn(List<String> values) {
            addCriterion("ys_3crz not in", values, "ys3crz");
            return (Criteria) this;
        }

        public Criteria andYs3crzBetween(String value1, String value2) {
            addCriterion("ys_3crz between", value1, value2, "ys3crz");
            return (Criteria) this;
        }

        public Criteria andYs3crzNotBetween(String value1, String value2) {
            addCriterion("ys_3crz not between", value1, value2, "ys3crz");
            return (Criteria) this;
        }

        public Criteria andYsJlqjrzIsNull() {
            addCriterion("ys_jlqjrz is null");
            return (Criteria) this;
        }

        public Criteria andYsJlqjrzIsNotNull() {
            addCriterion("ys_jlqjrz is not null");
            return (Criteria) this;
        }

        public Criteria andYsJlqjrzEqualTo(String value) {
            addCriterion("ys_jlqjrz =", value, "ysJlqjrz");
            return (Criteria) this;
        }

        public Criteria andYsJlqjrzNotEqualTo(String value) {
            addCriterion("ys_jlqjrz <>", value, "ysJlqjrz");
            return (Criteria) this;
        }

        public Criteria andYsJlqjrzGreaterThan(String value) {
            addCriterion("ys_jlqjrz >", value, "ysJlqjrz");
            return (Criteria) this;
        }

        public Criteria andYsJlqjrzGreaterThanOrEqualTo(String value) {
            addCriterion("ys_jlqjrz >=", value, "ysJlqjrz");
            return (Criteria) this;
        }

        public Criteria andYsJlqjrzLessThan(String value) {
            addCriterion("ys_jlqjrz <", value, "ysJlqjrz");
            return (Criteria) this;
        }

        public Criteria andYsJlqjrzLessThanOrEqualTo(String value) {
            addCriterion("ys_jlqjrz <=", value, "ysJlqjrz");
            return (Criteria) this;
        }

        public Criteria andYsJlqjrzLike(String value) {
            addCriterion("ys_jlqjrz like", value, "ysJlqjrz");
            return (Criteria) this;
        }

        public Criteria andYsJlqjrzNotLike(String value) {
            addCriterion("ys_jlqjrz not like", value, "ysJlqjrz");
            return (Criteria) this;
        }

        public Criteria andYsJlqjrzIn(List<String> values) {
            addCriterion("ys_jlqjrz in", values, "ysJlqjrz");
            return (Criteria) this;
        }

        public Criteria andYsJlqjrzNotIn(List<String> values) {
            addCriterion("ys_jlqjrz not in", values, "ysJlqjrz");
            return (Criteria) this;
        }

        public Criteria andYsJlqjrzBetween(String value1, String value2) {
            addCriterion("ys_jlqjrz between", value1, value2, "ysJlqjrz");
            return (Criteria) this;
        }

        public Criteria andYsJlqjrzNotBetween(String value1, String value2) {
            addCriterion("ys_jlqjrz not between", value1, value2, "ysJlqjrz");
            return (Criteria) this;
        }

        public Criteria andYsBgdIsNull() {
            addCriterion("ys_bgd is null");
            return (Criteria) this;
        }

        public Criteria andYsBgdIsNotNull() {
            addCriterion("ys_bgd is not null");
            return (Criteria) this;
        }

        public Criteria andYsBgdEqualTo(String value) {
            addCriterion("ys_bgd =", value, "ysBgd");
            return (Criteria) this;
        }

        public Criteria andYsBgdNotEqualTo(String value) {
            addCriterion("ys_bgd <>", value, "ysBgd");
            return (Criteria) this;
        }

        public Criteria andYsBgdGreaterThan(String value) {
            addCriterion("ys_bgd >", value, "ysBgd");
            return (Criteria) this;
        }

        public Criteria andYsBgdGreaterThanOrEqualTo(String value) {
            addCriterion("ys_bgd >=", value, "ysBgd");
            return (Criteria) this;
        }

        public Criteria andYsBgdLessThan(String value) {
            addCriterion("ys_bgd <", value, "ysBgd");
            return (Criteria) this;
        }

        public Criteria andYsBgdLessThanOrEqualTo(String value) {
            addCriterion("ys_bgd <=", value, "ysBgd");
            return (Criteria) this;
        }

        public Criteria andYsBgdLike(String value) {
            addCriterion("ys_bgd like", value, "ysBgd");
            return (Criteria) this;
        }

        public Criteria andYsBgdNotLike(String value) {
            addCriterion("ys_bgd not like", value, "ysBgd");
            return (Criteria) this;
        }

        public Criteria andYsBgdIn(List<String> values) {
            addCriterion("ys_bgd in", values, "ysBgd");
            return (Criteria) this;
        }

        public Criteria andYsBgdNotIn(List<String> values) {
            addCriterion("ys_bgd not in", values, "ysBgd");
            return (Criteria) this;
        }

        public Criteria andYsBgdBetween(String value1, String value2) {
            addCriterion("ys_bgd between", value1, value2, "ysBgd");
            return (Criteria) this;
        }

        public Criteria andYsBgdNotBetween(String value1, String value2) {
            addCriterion("ys_bgd not between", value1, value2, "ysBgd");
            return (Criteria) this;
        }

        public Criteria andYsJyjyzmIsNull() {
            addCriterion("ys_jyjyzm is null");
            return (Criteria) this;
        }

        public Criteria andYsJyjyzmIsNotNull() {
            addCriterion("ys_jyjyzm is not null");
            return (Criteria) this;
        }

        public Criteria andYsJyjyzmEqualTo(String value) {
            addCriterion("ys_jyjyzm =", value, "ysJyjyzm");
            return (Criteria) this;
        }

        public Criteria andYsJyjyzmNotEqualTo(String value) {
            addCriterion("ys_jyjyzm <>", value, "ysJyjyzm");
            return (Criteria) this;
        }

        public Criteria andYsJyjyzmGreaterThan(String value) {
            addCriterion("ys_jyjyzm >", value, "ysJyjyzm");
            return (Criteria) this;
        }

        public Criteria andYsJyjyzmGreaterThanOrEqualTo(String value) {
            addCriterion("ys_jyjyzm >=", value, "ysJyjyzm");
            return (Criteria) this;
        }

        public Criteria andYsJyjyzmLessThan(String value) {
            addCriterion("ys_jyjyzm <", value, "ysJyjyzm");
            return (Criteria) this;
        }

        public Criteria andYsJyjyzmLessThanOrEqualTo(String value) {
            addCriterion("ys_jyjyzm <=", value, "ysJyjyzm");
            return (Criteria) this;
        }

        public Criteria andYsJyjyzmLike(String value) {
            addCriterion("ys_jyjyzm like", value, "ysJyjyzm");
            return (Criteria) this;
        }

        public Criteria andYsJyjyzmNotLike(String value) {
            addCriterion("ys_jyjyzm not like", value, "ysJyjyzm");
            return (Criteria) this;
        }

        public Criteria andYsJyjyzmIn(List<String> values) {
            addCriterion("ys_jyjyzm in", values, "ysJyjyzm");
            return (Criteria) this;
        }

        public Criteria andYsJyjyzmNotIn(List<String> values) {
            addCriterion("ys_jyjyzm not in", values, "ysJyjyzm");
            return (Criteria) this;
        }

        public Criteria andYsJyjyzmBetween(String value1, String value2) {
            addCriterion("ys_jyjyzm between", value1, value2, "ysJyjyzm");
            return (Criteria) this;
        }

        public Criteria andYsJyjyzmNotBetween(String value1, String value2) {
            addCriterion("ys_jyjyzm not between", value1, value2, "ysJyjyzm");
            return (Criteria) this;
        }

        public Criteria andYsIsgfxqxIsNull() {
            addCriterion("ys_isgfxqx is null");
            return (Criteria) this;
        }

        public Criteria andYsIsgfxqxIsNotNull() {
            addCriterion("ys_isgfxqx is not null");
            return (Criteria) this;
        }

        public Criteria andYsIsgfxqxEqualTo(String value) {
            addCriterion("ys_isgfxqx =", value, "ysIsgfxqx");
            return (Criteria) this;
        }

        public Criteria andYsIsgfxqxNotEqualTo(String value) {
            addCriterion("ys_isgfxqx <>", value, "ysIsgfxqx");
            return (Criteria) this;
        }

        public Criteria andYsIsgfxqxGreaterThan(String value) {
            addCriterion("ys_isgfxqx >", value, "ysIsgfxqx");
            return (Criteria) this;
        }

        public Criteria andYsIsgfxqxGreaterThanOrEqualTo(String value) {
            addCriterion("ys_isgfxqx >=", value, "ysIsgfxqx");
            return (Criteria) this;
        }

        public Criteria andYsIsgfxqxLessThan(String value) {
            addCriterion("ys_isgfxqx <", value, "ysIsgfxqx");
            return (Criteria) this;
        }

        public Criteria andYsIsgfxqxLessThanOrEqualTo(String value) {
            addCriterion("ys_isgfxqx <=", value, "ysIsgfxqx");
            return (Criteria) this;
        }

        public Criteria andYsIsgfxqxLike(String value) {
            addCriterion("ys_isgfxqx like", value, "ysIsgfxqx");
            return (Criteria) this;
        }

        public Criteria andYsIsgfxqxNotLike(String value) {
            addCriterion("ys_isgfxqx not like", value, "ysIsgfxqx");
            return (Criteria) this;
        }

        public Criteria andYsIsgfxqxIn(List<String> values) {
            addCriterion("ys_isgfxqx in", values, "ysIsgfxqx");
            return (Criteria) this;
        }

        public Criteria andYsIsgfxqxNotIn(List<String> values) {
            addCriterion("ys_isgfxqx not in", values, "ysIsgfxqx");
            return (Criteria) this;
        }

        public Criteria andYsIsgfxqxBetween(String value1, String value2) {
            addCriterion("ys_isgfxqx between", value1, value2, "ysIsgfxqx");
            return (Criteria) this;
        }

        public Criteria andYsIsgfxqxNotBetween(String value1, String value2) {
            addCriterion("ys_isgfxqx not between", value1, value2, "ysIsgfxqx");
            return (Criteria) this;
        }

        public Criteria andYsBzbsIsNull() {
            addCriterion("ys_bzbs is null");
            return (Criteria) this;
        }

        public Criteria andYsBzbsIsNotNull() {
            addCriterion("ys_bzbs is not null");
            return (Criteria) this;
        }

        public Criteria andYsBzbsEqualTo(String value) {
            addCriterion("ys_bzbs =", value, "ysBzbs");
            return (Criteria) this;
        }

        public Criteria andYsBzbsNotEqualTo(String value) {
            addCriterion("ys_bzbs <>", value, "ysBzbs");
            return (Criteria) this;
        }

        public Criteria andYsBzbsGreaterThan(String value) {
            addCriterion("ys_bzbs >", value, "ysBzbs");
            return (Criteria) this;
        }

        public Criteria andYsBzbsGreaterThanOrEqualTo(String value) {
            addCriterion("ys_bzbs >=", value, "ysBzbs");
            return (Criteria) this;
        }

        public Criteria andYsBzbsLessThan(String value) {
            addCriterion("ys_bzbs <", value, "ysBzbs");
            return (Criteria) this;
        }

        public Criteria andYsBzbsLessThanOrEqualTo(String value) {
            addCriterion("ys_bzbs <=", value, "ysBzbs");
            return (Criteria) this;
        }

        public Criteria andYsBzbsLike(String value) {
            addCriterion("ys_bzbs like", value, "ysBzbs");
            return (Criteria) this;
        }

        public Criteria andYsBzbsNotLike(String value) {
            addCriterion("ys_bzbs not like", value, "ysBzbs");
            return (Criteria) this;
        }

        public Criteria andYsBzbsIn(List<String> values) {
            addCriterion("ys_bzbs in", values, "ysBzbs");
            return (Criteria) this;
        }

        public Criteria andYsBzbsNotIn(List<String> values) {
            addCriterion("ys_bzbs not in", values, "ysBzbs");
            return (Criteria) this;
        }

        public Criteria andYsBzbsBetween(String value1, String value2) {
            addCriterion("ys_bzbs between", value1, value2, "ysBzbs");
            return (Criteria) this;
        }

        public Criteria andYsBzbsNotBetween(String value1, String value2) {
            addCriterion("ys_bzbs not between", value1, value2, "ysBzbs");
            return (Criteria) this;
        }

        public Criteria andYsBqIsNull() {
            addCriterion("ys_bq is null");
            return (Criteria) this;
        }

        public Criteria andYsBqIsNotNull() {
            addCriterion("ys_bq is not null");
            return (Criteria) this;
        }

        public Criteria andYsBqEqualTo(String value) {
            addCriterion("ys_bq =", value, "ysBq");
            return (Criteria) this;
        }

        public Criteria andYsBqNotEqualTo(String value) {
            addCriterion("ys_bq <>", value, "ysBq");
            return (Criteria) this;
        }

        public Criteria andYsBqGreaterThan(String value) {
            addCriterion("ys_bq >", value, "ysBq");
            return (Criteria) this;
        }

        public Criteria andYsBqGreaterThanOrEqualTo(String value) {
            addCriterion("ys_bq >=", value, "ysBq");
            return (Criteria) this;
        }

        public Criteria andYsBqLessThan(String value) {
            addCriterion("ys_bq <", value, "ysBq");
            return (Criteria) this;
        }

        public Criteria andYsBqLessThanOrEqualTo(String value) {
            addCriterion("ys_bq <=", value, "ysBq");
            return (Criteria) this;
        }

        public Criteria andYsBqLike(String value) {
            addCriterion("ys_bq like", value, "ysBq");
            return (Criteria) this;
        }

        public Criteria andYsBqNotLike(String value) {
            addCriterion("ys_bq not like", value, "ysBq");
            return (Criteria) this;
        }

        public Criteria andYsBqIn(List<String> values) {
            addCriterion("ys_bq in", values, "ysBq");
            return (Criteria) this;
        }

        public Criteria andYsBqNotIn(List<String> values) {
            addCriterion("ys_bq not in", values, "ysBq");
            return (Criteria) this;
        }

        public Criteria andYsBqBetween(String value1, String value2) {
            addCriterion("ys_bq between", value1, value2, "ysBq");
            return (Criteria) this;
        }

        public Criteria andYsBqNotBetween(String value1, String value2) {
            addCriterion("ys_bq not between", value1, value2, "ysBq");
            return (Criteria) this;
        }

        public Criteria andYsGfxsmsIsNull() {
            addCriterion("ys_gfxsms is null");
            return (Criteria) this;
        }

        public Criteria andYsGfxsmsIsNotNull() {
            addCriterion("ys_gfxsms is not null");
            return (Criteria) this;
        }

        public Criteria andYsGfxsmsEqualTo(String value) {
            addCriterion("ys_gfxsms =", value, "ysGfxsms");
            return (Criteria) this;
        }

        public Criteria andYsGfxsmsNotEqualTo(String value) {
            addCriterion("ys_gfxsms <>", value, "ysGfxsms");
            return (Criteria) this;
        }

        public Criteria andYsGfxsmsGreaterThan(String value) {
            addCriterion("ys_gfxsms >", value, "ysGfxsms");
            return (Criteria) this;
        }

        public Criteria andYsGfxsmsGreaterThanOrEqualTo(String value) {
            addCriterion("ys_gfxsms >=", value, "ysGfxsms");
            return (Criteria) this;
        }

        public Criteria andYsGfxsmsLessThan(String value) {
            addCriterion("ys_gfxsms <", value, "ysGfxsms");
            return (Criteria) this;
        }

        public Criteria andYsGfxsmsLessThanOrEqualTo(String value) {
            addCriterion("ys_gfxsms <=", value, "ysGfxsms");
            return (Criteria) this;
        }

        public Criteria andYsGfxsmsLike(String value) {
            addCriterion("ys_gfxsms like", value, "ysGfxsms");
            return (Criteria) this;
        }

        public Criteria andYsGfxsmsNotLike(String value) {
            addCriterion("ys_gfxsms not like", value, "ysGfxsms");
            return (Criteria) this;
        }

        public Criteria andYsGfxsmsIn(List<String> values) {
            addCriterion("ys_gfxsms in", values, "ysGfxsms");
            return (Criteria) this;
        }

        public Criteria andYsGfxsmsNotIn(List<String> values) {
            addCriterion("ys_gfxsms not in", values, "ysGfxsms");
            return (Criteria) this;
        }

        public Criteria andYsGfxsmsBetween(String value1, String value2) {
            addCriterion("ys_gfxsms between", value1, value2, "ysGfxsms");
            return (Criteria) this;
        }

        public Criteria andYsGfxsmsNotBetween(String value1, String value2) {
            addCriterion("ys_gfxsms not between", value1, value2, "ysGfxsms");
            return (Criteria) this;
        }

        public Criteria andYsHgzmIsNull() {
            addCriterion("ys_hgzm is null");
            return (Criteria) this;
        }

        public Criteria andYsHgzmIsNotNull() {
            addCriterion("ys_hgzm is not null");
            return (Criteria) this;
        }

        public Criteria andYsHgzmEqualTo(String value) {
            addCriterion("ys_hgzm =", value, "ysHgzm");
            return (Criteria) this;
        }

        public Criteria andYsHgzmNotEqualTo(String value) {
            addCriterion("ys_hgzm <>", value, "ysHgzm");
            return (Criteria) this;
        }

        public Criteria andYsHgzmGreaterThan(String value) {
            addCriterion("ys_hgzm >", value, "ysHgzm");
            return (Criteria) this;
        }

        public Criteria andYsHgzmGreaterThanOrEqualTo(String value) {
            addCriterion("ys_hgzm >=", value, "ysHgzm");
            return (Criteria) this;
        }

        public Criteria andYsHgzmLessThan(String value) {
            addCriterion("ys_hgzm <", value, "ysHgzm");
            return (Criteria) this;
        }

        public Criteria andYsHgzmLessThanOrEqualTo(String value) {
            addCriterion("ys_hgzm <=", value, "ysHgzm");
            return (Criteria) this;
        }

        public Criteria andYsHgzmLike(String value) {
            addCriterion("ys_hgzm like", value, "ysHgzm");
            return (Criteria) this;
        }

        public Criteria andYsHgzmNotLike(String value) {
            addCriterion("ys_hgzm not like", value, "ysHgzm");
            return (Criteria) this;
        }

        public Criteria andYsHgzmIn(List<String> values) {
            addCriterion("ys_hgzm in", values, "ysHgzm");
            return (Criteria) this;
        }

        public Criteria andYsHgzmNotIn(List<String> values) {
            addCriterion("ys_hgzm not in", values, "ysHgzm");
            return (Criteria) this;
        }

        public Criteria andYsHgzmBetween(String value1, String value2) {
            addCriterion("ys_hgzm between", value1, value2, "ysHgzm");
            return (Criteria) this;
        }

        public Criteria andYsHgzmNotBetween(String value1, String value2) {
            addCriterion("ys_hgzm not between", value1, value2, "ysHgzm");
            return (Criteria) this;
        }

        public Criteria andYsQtclIsNull() {
            addCriterion("ys_qtcl is null");
            return (Criteria) this;
        }

        public Criteria andYsQtclIsNotNull() {
            addCriterion("ys_qtcl is not null");
            return (Criteria) this;
        }

        public Criteria andYsQtclEqualTo(String value) {
            addCriterion("ys_qtcl =", value, "ysQtcl");
            return (Criteria) this;
        }

        public Criteria andYsQtclNotEqualTo(String value) {
            addCriterion("ys_qtcl <>", value, "ysQtcl");
            return (Criteria) this;
        }

        public Criteria andYsQtclGreaterThan(String value) {
            addCriterion("ys_qtcl >", value, "ysQtcl");
            return (Criteria) this;
        }

        public Criteria andYsQtclGreaterThanOrEqualTo(String value) {
            addCriterion("ys_qtcl >=", value, "ysQtcl");
            return (Criteria) this;
        }

        public Criteria andYsQtclLessThan(String value) {
            addCriterion("ys_qtcl <", value, "ysQtcl");
            return (Criteria) this;
        }

        public Criteria andYsQtclLessThanOrEqualTo(String value) {
            addCriterion("ys_qtcl <=", value, "ysQtcl");
            return (Criteria) this;
        }

        public Criteria andYsQtclLike(String value) {
            addCriterion("ys_qtcl like", value, "ysQtcl");
            return (Criteria) this;
        }

        public Criteria andYsQtclNotLike(String value) {
            addCriterion("ys_qtcl not like", value, "ysQtcl");
            return (Criteria) this;
        }

        public Criteria andYsQtclIn(List<String> values) {
            addCriterion("ys_qtcl in", values, "ysQtcl");
            return (Criteria) this;
        }

        public Criteria andYsQtclNotIn(List<String> values) {
            addCriterion("ys_qtcl not in", values, "ysQtcl");
            return (Criteria) this;
        }

        public Criteria andYsQtclBetween(String value1, String value2) {
            addCriterion("ys_qtcl between", value1, value2, "ysQtcl");
            return (Criteria) this;
        }

        public Criteria andYsQtclNotBetween(String value1, String value2) {
            addCriterion("ys_qtcl not between", value1, value2, "ysQtcl");
            return (Criteria) this;
        }

        public Criteria andYsSyksIsNull() {
            addCriterion("ys_syks is null");
            return (Criteria) this;
        }

        public Criteria andYsSyksIsNotNull() {
            addCriterion("ys_syks is not null");
            return (Criteria) this;
        }

        public Criteria andYsSyksEqualTo(String value) {
            addCriterion("ys_syks =", value, "ysSyks");
            return (Criteria) this;
        }

        public Criteria andYsSyksNotEqualTo(String value) {
            addCriterion("ys_syks <>", value, "ysSyks");
            return (Criteria) this;
        }

        public Criteria andYsSyksGreaterThan(String value) {
            addCriterion("ys_syks >", value, "ysSyks");
            return (Criteria) this;
        }

        public Criteria andYsSyksGreaterThanOrEqualTo(String value) {
            addCriterion("ys_syks >=", value, "ysSyks");
            return (Criteria) this;
        }

        public Criteria andYsSyksLessThan(String value) {
            addCriterion("ys_syks <", value, "ysSyks");
            return (Criteria) this;
        }

        public Criteria andYsSyksLessThanOrEqualTo(String value) {
            addCriterion("ys_syks <=", value, "ysSyks");
            return (Criteria) this;
        }

        public Criteria andYsSyksLike(String value) {
            addCriterion("ys_syks like", value, "ysSyks");
            return (Criteria) this;
        }

        public Criteria andYsSyksNotLike(String value) {
            addCriterion("ys_syks not like", value, "ysSyks");
            return (Criteria) this;
        }

        public Criteria andYsSyksIn(List<String> values) {
            addCriterion("ys_syks in", values, "ysSyks");
            return (Criteria) this;
        }

        public Criteria andYsSyksNotIn(List<String> values) {
            addCriterion("ys_syks not in", values, "ysSyks");
            return (Criteria) this;
        }

        public Criteria andYsSyksBetween(String value1, String value2) {
            addCriterion("ys_syks between", value1, value2, "ysSyks");
            return (Criteria) this;
        }

        public Criteria andYsSyksNotBetween(String value1, String value2) {
            addCriterion("ys_syks not between", value1, value2, "ysSyks");
            return (Criteria) this;
        }

        public Criteria andYsSbxhIsNull() {
            addCriterion("ys_sbxh is null");
            return (Criteria) this;
        }

        public Criteria andYsSbxhIsNotNull() {
            addCriterion("ys_sbxh is not null");
            return (Criteria) this;
        }

        public Criteria andYsSbxhEqualTo(String value) {
            addCriterion("ys_sbxh =", value, "ysSbxh");
            return (Criteria) this;
        }

        public Criteria andYsSbxhNotEqualTo(String value) {
            addCriterion("ys_sbxh <>", value, "ysSbxh");
            return (Criteria) this;
        }

        public Criteria andYsSbxhGreaterThan(String value) {
            addCriterion("ys_sbxh >", value, "ysSbxh");
            return (Criteria) this;
        }

        public Criteria andYsSbxhGreaterThanOrEqualTo(String value) {
            addCriterion("ys_sbxh >=", value, "ysSbxh");
            return (Criteria) this;
        }

        public Criteria andYsSbxhLessThan(String value) {
            addCriterion("ys_sbxh <", value, "ysSbxh");
            return (Criteria) this;
        }

        public Criteria andYsSbxhLessThanOrEqualTo(String value) {
            addCriterion("ys_sbxh <=", value, "ysSbxh");
            return (Criteria) this;
        }

        public Criteria andYsSbxhLike(String value) {
            addCriterion("ys_sbxh like", value, "ysSbxh");
            return (Criteria) this;
        }

        public Criteria andYsSbxhNotLike(String value) {
            addCriterion("ys_sbxh not like", value, "ysSbxh");
            return (Criteria) this;
        }

        public Criteria andYsSbxhIn(List<String> values) {
            addCriterion("ys_sbxh in", values, "ysSbxh");
            return (Criteria) this;
        }

        public Criteria andYsSbxhNotIn(List<String> values) {
            addCriterion("ys_sbxh not in", values, "ysSbxh");
            return (Criteria) this;
        }

        public Criteria andYsSbxhBetween(String value1, String value2) {
            addCriterion("ys_sbxh between", value1, value2, "ysSbxh");
            return (Criteria) this;
        }

        public Criteria andYsSbxhNotBetween(String value1, String value2) {
            addCriterion("ys_sbxh not between", value1, value2, "ysSbxh");
            return (Criteria) this;
        }

        public Criteria andYsGbIsNull() {
            addCriterion("ys_gb is null");
            return (Criteria) this;
        }

        public Criteria andYsGbIsNotNull() {
            addCriterion("ys_gb is not null");
            return (Criteria) this;
        }

        public Criteria andYsGbEqualTo(String value) {
            addCriterion("ys_gb =", value, "ysGb");
            return (Criteria) this;
        }

        public Criteria andYsGbNotEqualTo(String value) {
            addCriterion("ys_gb <>", value, "ysGb");
            return (Criteria) this;
        }

        public Criteria andYsGbGreaterThan(String value) {
            addCriterion("ys_gb >", value, "ysGb");
            return (Criteria) this;
        }

        public Criteria andYsGbGreaterThanOrEqualTo(String value) {
            addCriterion("ys_gb >=", value, "ysGb");
            return (Criteria) this;
        }

        public Criteria andYsGbLessThan(String value) {
            addCriterion("ys_gb <", value, "ysGb");
            return (Criteria) this;
        }

        public Criteria andYsGbLessThanOrEqualTo(String value) {
            addCriterion("ys_gb <=", value, "ysGb");
            return (Criteria) this;
        }

        public Criteria andYsGbLike(String value) {
            addCriterion("ys_gb like", value, "ysGb");
            return (Criteria) this;
        }

        public Criteria andYsGbNotLike(String value) {
            addCriterion("ys_gb not like", value, "ysGb");
            return (Criteria) this;
        }

        public Criteria andYsGbIn(List<String> values) {
            addCriterion("ys_gb in", values, "ysGb");
            return (Criteria) this;
        }

        public Criteria andYsGbNotIn(List<String> values) {
            addCriterion("ys_gb not in", values, "ysGb");
            return (Criteria) this;
        }

        public Criteria andYsGbBetween(String value1, String value2) {
            addCriterion("ys_gb between", value1, value2, "ysGb");
            return (Criteria) this;
        }

        public Criteria andYsGbNotBetween(String value1, String value2) {
            addCriterion("ys_gb not between", value1, value2, "ysGb");
            return (Criteria) this;
        }

        public Criteria andYsSccsIsNull() {
            addCriterion("ys_sccs is null");
            return (Criteria) this;
        }

        public Criteria andYsSccsIsNotNull() {
            addCriterion("ys_sccs is not null");
            return (Criteria) this;
        }

        public Criteria andYsSccsEqualTo(String value) {
            addCriterion("ys_sccs =", value, "ysSccs");
            return (Criteria) this;
        }

        public Criteria andYsSccsNotEqualTo(String value) {
            addCriterion("ys_sccs <>", value, "ysSccs");
            return (Criteria) this;
        }

        public Criteria andYsSccsGreaterThan(String value) {
            addCriterion("ys_sccs >", value, "ysSccs");
            return (Criteria) this;
        }

        public Criteria andYsSccsGreaterThanOrEqualTo(String value) {
            addCriterion("ys_sccs >=", value, "ysSccs");
            return (Criteria) this;
        }

        public Criteria andYsSccsLessThan(String value) {
            addCriterion("ys_sccs <", value, "ysSccs");
            return (Criteria) this;
        }

        public Criteria andYsSccsLessThanOrEqualTo(String value) {
            addCriterion("ys_sccs <=", value, "ysSccs");
            return (Criteria) this;
        }

        public Criteria andYsSccsLike(String value) {
            addCriterion("ys_sccs like", value, "ysSccs");
            return (Criteria) this;
        }

        public Criteria andYsSccsNotLike(String value) {
            addCriterion("ys_sccs not like", value, "ysSccs");
            return (Criteria) this;
        }

        public Criteria andYsSccsIn(List<String> values) {
            addCriterion("ys_sccs in", values, "ysSccs");
            return (Criteria) this;
        }

        public Criteria andYsSccsNotIn(List<String> values) {
            addCriterion("ys_sccs not in", values, "ysSccs");
            return (Criteria) this;
        }

        public Criteria andYsSccsBetween(String value1, String value2) {
            addCriterion("ys_sccs between", value1, value2, "ysSccs");
            return (Criteria) this;
        }

        public Criteria andYsSccsNotBetween(String value1, String value2) {
            addCriterion("ys_sccs not between", value1, value2, "ysSccs");
            return (Criteria) this;
        }

        public Criteria andYsCdIsNull() {
            addCriterion("ys_cd is null");
            return (Criteria) this;
        }

        public Criteria andYsCdIsNotNull() {
            addCriterion("ys_cd is not null");
            return (Criteria) this;
        }

        public Criteria andYsCdEqualTo(String value) {
            addCriterion("ys_cd =", value, "ysCd");
            return (Criteria) this;
        }

        public Criteria andYsCdNotEqualTo(String value) {
            addCriterion("ys_cd <>", value, "ysCd");
            return (Criteria) this;
        }

        public Criteria andYsCdGreaterThan(String value) {
            addCriterion("ys_cd >", value, "ysCd");
            return (Criteria) this;
        }

        public Criteria andYsCdGreaterThanOrEqualTo(String value) {
            addCriterion("ys_cd >=", value, "ysCd");
            return (Criteria) this;
        }

        public Criteria andYsCdLessThan(String value) {
            addCriterion("ys_cd <", value, "ysCd");
            return (Criteria) this;
        }

        public Criteria andYsCdLessThanOrEqualTo(String value) {
            addCriterion("ys_cd <=", value, "ysCd");
            return (Criteria) this;
        }

        public Criteria andYsCdLike(String value) {
            addCriterion("ys_cd like", value, "ysCd");
            return (Criteria) this;
        }

        public Criteria andYsCdNotLike(String value) {
            addCriterion("ys_cd not like", value, "ysCd");
            return (Criteria) this;
        }

        public Criteria andYsCdIn(List<String> values) {
            addCriterion("ys_cd in", values, "ysCd");
            return (Criteria) this;
        }

        public Criteria andYsCdNotIn(List<String> values) {
            addCriterion("ys_cd not in", values, "ysCd");
            return (Criteria) this;
        }

        public Criteria andYsCdBetween(String value1, String value2) {
            addCriterion("ys_cd between", value1, value2, "ysCd");
            return (Criteria) this;
        }

        public Criteria andYsCdNotBetween(String value1, String value2) {
            addCriterion("ys_cd not between", value1, value2, "ysCd");
            return (Criteria) this;
        }

        public Criteria andYsScrqIsNull() {
            addCriterion("ys_scrq is null");
            return (Criteria) this;
        }

        public Criteria andYsScrqIsNotNull() {
            addCriterion("ys_scrq is not null");
            return (Criteria) this;
        }

        public Criteria andYsScrqEqualTo(Date value) {
            addCriterion("ys_scrq =", value, "ysScrq");
            return (Criteria) this;
        }

        public Criteria andYsScrqNotEqualTo(Date value) {
            addCriterion("ys_scrq <>", value, "ysScrq");
            return (Criteria) this;
        }

        public Criteria andYsScrqGreaterThan(Date value) {
            addCriterion("ys_scrq >", value, "ysScrq");
            return (Criteria) this;
        }

        public Criteria andYsScrqGreaterThanOrEqualTo(Date value) {
            addCriterion("ys_scrq >=", value, "ysScrq");
            return (Criteria) this;
        }

        public Criteria andYsScrqLessThan(Date value) {
            addCriterion("ys_scrq <", value, "ysScrq");
            return (Criteria) this;
        }

        public Criteria andYsScrqLessThanOrEqualTo(Date value) {
            addCriterion("ys_scrq <=", value, "ysScrq");
            return (Criteria) this;
        }

        public Criteria andYsScrqIn(List<Date> values) {
            addCriterion("ys_scrq in", values, "ysScrq");
            return (Criteria) this;
        }

        public Criteria andYsScrqNotIn(List<Date> values) {
            addCriterion("ys_scrq not in", values, "ysScrq");
            return (Criteria) this;
        }

        public Criteria andYsScrqBetween(Date value1, Date value2) {
            addCriterion("ys_scrq between", value1, value2, "ysScrq");
            return (Criteria) this;
        }

        public Criteria andYsScrqNotBetween(Date value1, Date value2) {
            addCriterion("ys_scrq not between", value1, value2, "ysScrq");
            return (Criteria) this;
        }

        public Criteria andYsDjIsNull() {
            addCriterion("ys_dj is null");
            return (Criteria) this;
        }

        public Criteria andYsDjIsNotNull() {
            addCriterion("ys_dj is not null");
            return (Criteria) this;
        }

        public Criteria andYsDjEqualTo(BigDecimal value) {
            addCriterion("ys_dj =", value, "ysDj");
            return (Criteria) this;
        }

        public Criteria andYsDjNotEqualTo(BigDecimal value) {
            addCriterion("ys_dj <>", value, "ysDj");
            return (Criteria) this;
        }

        public Criteria andYsDjGreaterThan(BigDecimal value) {
            addCriterion("ys_dj >", value, "ysDj");
            return (Criteria) this;
        }

        public Criteria andYsDjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ys_dj >=", value, "ysDj");
            return (Criteria) this;
        }

        public Criteria andYsDjLessThan(BigDecimal value) {
            addCriterion("ys_dj <", value, "ysDj");
            return (Criteria) this;
        }

        public Criteria andYsDjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ys_dj <=", value, "ysDj");
            return (Criteria) this;
        }

        public Criteria andYsDjIn(List<BigDecimal> values) {
            addCriterion("ys_dj in", values, "ysDj");
            return (Criteria) this;
        }

        public Criteria andYsDjNotIn(List<BigDecimal> values) {
            addCriterion("ys_dj not in", values, "ysDj");
            return (Criteria) this;
        }

        public Criteria andYsDjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ys_dj between", value1, value2, "ysDj");
            return (Criteria) this;
        }

        public Criteria andYsDjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ys_dj not between", value1, value2, "ysDj");
            return (Criteria) this;
        }

        public Criteria andYsXlhIsNull() {
            addCriterion("ys_xlh is null");
            return (Criteria) this;
        }

        public Criteria andYsXlhIsNotNull() {
            addCriterion("ys_xlh is not null");
            return (Criteria) this;
        }

        public Criteria andYsXlhEqualTo(String value) {
            addCriterion("ys_xlh =", value, "ysXlh");
            return (Criteria) this;
        }

        public Criteria andYsXlhNotEqualTo(String value) {
            addCriterion("ys_xlh <>", value, "ysXlh");
            return (Criteria) this;
        }

        public Criteria andYsXlhGreaterThan(String value) {
            addCriterion("ys_xlh >", value, "ysXlh");
            return (Criteria) this;
        }

        public Criteria andYsXlhGreaterThanOrEqualTo(String value) {
            addCriterion("ys_xlh >=", value, "ysXlh");
            return (Criteria) this;
        }

        public Criteria andYsXlhLessThan(String value) {
            addCriterion("ys_xlh <", value, "ysXlh");
            return (Criteria) this;
        }

        public Criteria andYsXlhLessThanOrEqualTo(String value) {
            addCriterion("ys_xlh <=", value, "ysXlh");
            return (Criteria) this;
        }

        public Criteria andYsXlhLike(String value) {
            addCriterion("ys_xlh like", value, "ysXlh");
            return (Criteria) this;
        }

        public Criteria andYsXlhNotLike(String value) {
            addCriterion("ys_xlh not like", value, "ysXlh");
            return (Criteria) this;
        }

        public Criteria andYsXlhIn(List<String> values) {
            addCriterion("ys_xlh in", values, "ysXlh");
            return (Criteria) this;
        }

        public Criteria andYsXlhNotIn(List<String> values) {
            addCriterion("ys_xlh not in", values, "ysXlh");
            return (Criteria) this;
        }

        public Criteria andYsXlhBetween(String value1, String value2) {
            addCriterion("ys_xlh between", value1, value2, "ysXlh");
            return (Criteria) this;
        }

        public Criteria andYsXlhNotBetween(String value1, String value2) {
            addCriterion("ys_xlh not between", value1, value2, "ysXlh");
            return (Criteria) this;
        }

        public Criteria andYsFjmcxhIsNull() {
            addCriterion("ys_fjmcxh is null");
            return (Criteria) this;
        }

        public Criteria andYsFjmcxhIsNotNull() {
            addCriterion("ys_fjmcxh is not null");
            return (Criteria) this;
        }

        public Criteria andYsFjmcxhEqualTo(String value) {
            addCriterion("ys_fjmcxh =", value, "ysFjmcxh");
            return (Criteria) this;
        }

        public Criteria andYsFjmcxhNotEqualTo(String value) {
            addCriterion("ys_fjmcxh <>", value, "ysFjmcxh");
            return (Criteria) this;
        }

        public Criteria andYsFjmcxhGreaterThan(String value) {
            addCriterion("ys_fjmcxh >", value, "ysFjmcxh");
            return (Criteria) this;
        }

        public Criteria andYsFjmcxhGreaterThanOrEqualTo(String value) {
            addCriterion("ys_fjmcxh >=", value, "ysFjmcxh");
            return (Criteria) this;
        }

        public Criteria andYsFjmcxhLessThan(String value) {
            addCriterion("ys_fjmcxh <", value, "ysFjmcxh");
            return (Criteria) this;
        }

        public Criteria andYsFjmcxhLessThanOrEqualTo(String value) {
            addCriterion("ys_fjmcxh <=", value, "ysFjmcxh");
            return (Criteria) this;
        }

        public Criteria andYsFjmcxhLike(String value) {
            addCriterion("ys_fjmcxh like", value, "ysFjmcxh");
            return (Criteria) this;
        }

        public Criteria andYsFjmcxhNotLike(String value) {
            addCriterion("ys_fjmcxh not like", value, "ysFjmcxh");
            return (Criteria) this;
        }

        public Criteria andYsFjmcxhIn(List<String> values) {
            addCriterion("ys_fjmcxh in", values, "ysFjmcxh");
            return (Criteria) this;
        }

        public Criteria andYsFjmcxhNotIn(List<String> values) {
            addCriterion("ys_fjmcxh not in", values, "ysFjmcxh");
            return (Criteria) this;
        }

        public Criteria andYsFjmcxhBetween(String value1, String value2) {
            addCriterion("ys_fjmcxh between", value1, value2, "ysFjmcxh");
            return (Criteria) this;
        }

        public Criteria andYsFjmcxhNotBetween(String value1, String value2) {
            addCriterion("ys_fjmcxh not between", value1, value2, "ysFjmcxh");
            return (Criteria) this;
        }

        public Criteria andYsFjxlhIsNull() {
            addCriterion("ys_fjxlh is null");
            return (Criteria) this;
        }

        public Criteria andYsFjxlhIsNotNull() {
            addCriterion("ys_fjxlh is not null");
            return (Criteria) this;
        }

        public Criteria andYsFjxlhEqualTo(String value) {
            addCriterion("ys_fjxlh =", value, "ysFjxlh");
            return (Criteria) this;
        }

        public Criteria andYsFjxlhNotEqualTo(String value) {
            addCriterion("ys_fjxlh <>", value, "ysFjxlh");
            return (Criteria) this;
        }

        public Criteria andYsFjxlhGreaterThan(String value) {
            addCriterion("ys_fjxlh >", value, "ysFjxlh");
            return (Criteria) this;
        }

        public Criteria andYsFjxlhGreaterThanOrEqualTo(String value) {
            addCriterion("ys_fjxlh >=", value, "ysFjxlh");
            return (Criteria) this;
        }

        public Criteria andYsFjxlhLessThan(String value) {
            addCriterion("ys_fjxlh <", value, "ysFjxlh");
            return (Criteria) this;
        }

        public Criteria andYsFjxlhLessThanOrEqualTo(String value) {
            addCriterion("ys_fjxlh <=", value, "ysFjxlh");
            return (Criteria) this;
        }

        public Criteria andYsFjxlhLike(String value) {
            addCriterion("ys_fjxlh like", value, "ysFjxlh");
            return (Criteria) this;
        }

        public Criteria andYsFjxlhNotLike(String value) {
            addCriterion("ys_fjxlh not like", value, "ysFjxlh");
            return (Criteria) this;
        }

        public Criteria andYsFjxlhIn(List<String> values) {
            addCriterion("ys_fjxlh in", values, "ysFjxlh");
            return (Criteria) this;
        }

        public Criteria andYsFjxlhNotIn(List<String> values) {
            addCriterion("ys_fjxlh not in", values, "ysFjxlh");
            return (Criteria) this;
        }

        public Criteria andYsFjxlhBetween(String value1, String value2) {
            addCriterion("ys_fjxlh between", value1, value2, "ysFjxlh");
            return (Criteria) this;
        }

        public Criteria andYsFjxlhNotBetween(String value1, String value2) {
            addCriterion("ys_fjxlh not between", value1, value2, "ysFjxlh");
            return (Criteria) this;
        }

        public Criteria andYsYsgcsIsNull() {
            addCriterion("ys_ysgcs is null");
            return (Criteria) this;
        }

        public Criteria andYsYsgcsIsNotNull() {
            addCriterion("ys_ysgcs is not null");
            return (Criteria) this;
        }

        public Criteria andYsYsgcsEqualTo(String value) {
            addCriterion("ys_ysgcs =", value, "ysYsgcs");
            return (Criteria) this;
        }

        public Criteria andYsYsgcsNotEqualTo(String value) {
            addCriterion("ys_ysgcs <>", value, "ysYsgcs");
            return (Criteria) this;
        }

        public Criteria andYsYsgcsGreaterThan(String value) {
            addCriterion("ys_ysgcs >", value, "ysYsgcs");
            return (Criteria) this;
        }

        public Criteria andYsYsgcsGreaterThanOrEqualTo(String value) {
            addCriterion("ys_ysgcs >=", value, "ysYsgcs");
            return (Criteria) this;
        }

        public Criteria andYsYsgcsLessThan(String value) {
            addCriterion("ys_ysgcs <", value, "ysYsgcs");
            return (Criteria) this;
        }

        public Criteria andYsYsgcsLessThanOrEqualTo(String value) {
            addCriterion("ys_ysgcs <=", value, "ysYsgcs");
            return (Criteria) this;
        }

        public Criteria andYsYsgcsLike(String value) {
            addCriterion("ys_ysgcs like", value, "ysYsgcs");
            return (Criteria) this;
        }

        public Criteria andYsYsgcsNotLike(String value) {
            addCriterion("ys_ysgcs not like", value, "ysYsgcs");
            return (Criteria) this;
        }

        public Criteria andYsYsgcsIn(List<String> values) {
            addCriterion("ys_ysgcs in", values, "ysYsgcs");
            return (Criteria) this;
        }

        public Criteria andYsYsgcsNotIn(List<String> values) {
            addCriterion("ys_ysgcs not in", values, "ysYsgcs");
            return (Criteria) this;
        }

        public Criteria andYsYsgcsBetween(String value1, String value2) {
            addCriterion("ys_ysgcs between", value1, value2, "ysYsgcs");
            return (Criteria) this;
        }

        public Criteria andYsYsgcsNotBetween(String value1, String value2) {
            addCriterion("ys_ysgcs not between", value1, value2, "ysYsgcs");
            return (Criteria) this;
        }

        public Criteria andYsCsgcsIsNull() {
            addCriterion("ys_csgcs is null");
            return (Criteria) this;
        }

        public Criteria andYsCsgcsIsNotNull() {
            addCriterion("ys_csgcs is not null");
            return (Criteria) this;
        }

        public Criteria andYsCsgcsEqualTo(String value) {
            addCriterion("ys_csgcs =", value, "ysCsgcs");
            return (Criteria) this;
        }

        public Criteria andYsCsgcsNotEqualTo(String value) {
            addCriterion("ys_csgcs <>", value, "ysCsgcs");
            return (Criteria) this;
        }

        public Criteria andYsCsgcsGreaterThan(String value) {
            addCriterion("ys_csgcs >", value, "ysCsgcs");
            return (Criteria) this;
        }

        public Criteria andYsCsgcsGreaterThanOrEqualTo(String value) {
            addCriterion("ys_csgcs >=", value, "ysCsgcs");
            return (Criteria) this;
        }

        public Criteria andYsCsgcsLessThan(String value) {
            addCriterion("ys_csgcs <", value, "ysCsgcs");
            return (Criteria) this;
        }

        public Criteria andYsCsgcsLessThanOrEqualTo(String value) {
            addCriterion("ys_csgcs <=", value, "ysCsgcs");
            return (Criteria) this;
        }

        public Criteria andYsCsgcsLike(String value) {
            addCriterion("ys_csgcs like", value, "ysCsgcs");
            return (Criteria) this;
        }

        public Criteria andYsCsgcsNotLike(String value) {
            addCriterion("ys_csgcs not like", value, "ysCsgcs");
            return (Criteria) this;
        }

        public Criteria andYsCsgcsIn(List<String> values) {
            addCriterion("ys_csgcs in", values, "ysCsgcs");
            return (Criteria) this;
        }

        public Criteria andYsCsgcsNotIn(List<String> values) {
            addCriterion("ys_csgcs not in", values, "ysCsgcs");
            return (Criteria) this;
        }

        public Criteria andYsCsgcsBetween(String value1, String value2) {
            addCriterion("ys_csgcs between", value1, value2, "ysCsgcs");
            return (Criteria) this;
        }

        public Criteria andYsCsgcsNotBetween(String value1, String value2) {
            addCriterion("ys_csgcs not between", value1, value2, "ysCsgcs");
            return (Criteria) this;
        }

        public Criteria andYsLxdhIsNull() {
            addCriterion("ys_lxdh is null");
            return (Criteria) this;
        }

        public Criteria andYsLxdhIsNotNull() {
            addCriterion("ys_lxdh is not null");
            return (Criteria) this;
        }

        public Criteria andYsLxdhEqualTo(String value) {
            addCriterion("ys_lxdh =", value, "ysLxdh");
            return (Criteria) this;
        }

        public Criteria andYsLxdhNotEqualTo(String value) {
            addCriterion("ys_lxdh <>", value, "ysLxdh");
            return (Criteria) this;
        }

        public Criteria andYsLxdhGreaterThan(String value) {
            addCriterion("ys_lxdh >", value, "ysLxdh");
            return (Criteria) this;
        }

        public Criteria andYsLxdhGreaterThanOrEqualTo(String value) {
            addCriterion("ys_lxdh >=", value, "ysLxdh");
            return (Criteria) this;
        }

        public Criteria andYsLxdhLessThan(String value) {
            addCriterion("ys_lxdh <", value, "ysLxdh");
            return (Criteria) this;
        }

        public Criteria andYsLxdhLessThanOrEqualTo(String value) {
            addCriterion("ys_lxdh <=", value, "ysLxdh");
            return (Criteria) this;
        }

        public Criteria andYsLxdhLike(String value) {
            addCriterion("ys_lxdh like", value, "ysLxdh");
            return (Criteria) this;
        }

        public Criteria andYsLxdhNotLike(String value) {
            addCriterion("ys_lxdh not like", value, "ysLxdh");
            return (Criteria) this;
        }

        public Criteria andYsLxdhIn(List<String> values) {
            addCriterion("ys_lxdh in", values, "ysLxdh");
            return (Criteria) this;
        }

        public Criteria andYsLxdhNotIn(List<String> values) {
            addCriterion("ys_lxdh not in", values, "ysLxdh");
            return (Criteria) this;
        }

        public Criteria andYsLxdhBetween(String value1, String value2) {
            addCriterion("ys_lxdh between", value1, value2, "ysLxdh");
            return (Criteria) this;
        }

        public Criteria andYsLxdhNotBetween(String value1, String value2) {
            addCriterion("ys_lxdh not between", value1, value2, "ysLxdh");
            return (Criteria) this;
        }

        public Criteria andYsXgsxnIsNull() {
            addCriterion("ys_xgsxn is null");
            return (Criteria) this;
        }

        public Criteria andYsXgsxnIsNotNull() {
            addCriterion("ys_xgsxn is not null");
            return (Criteria) this;
        }

        public Criteria andYsXgsxnEqualTo(String value) {
            addCriterion("ys_xgsxn =", value, "ysXgsxn");
            return (Criteria) this;
        }

        public Criteria andYsXgsxnNotEqualTo(String value) {
            addCriterion("ys_xgsxn <>", value, "ysXgsxn");
            return (Criteria) this;
        }

        public Criteria andYsXgsxnGreaterThan(String value) {
            addCriterion("ys_xgsxn >", value, "ysXgsxn");
            return (Criteria) this;
        }

        public Criteria andYsXgsxnGreaterThanOrEqualTo(String value) {
            addCriterion("ys_xgsxn >=", value, "ysXgsxn");
            return (Criteria) this;
        }

        public Criteria andYsXgsxnLessThan(String value) {
            addCriterion("ys_xgsxn <", value, "ysXgsxn");
            return (Criteria) this;
        }

        public Criteria andYsXgsxnLessThanOrEqualTo(String value) {
            addCriterion("ys_xgsxn <=", value, "ysXgsxn");
            return (Criteria) this;
        }

        public Criteria andYsXgsxnLike(String value) {
            addCriterion("ys_xgsxn like", value, "ysXgsxn");
            return (Criteria) this;
        }

        public Criteria andYsXgsxnNotLike(String value) {
            addCriterion("ys_xgsxn not like", value, "ysXgsxn");
            return (Criteria) this;
        }

        public Criteria andYsXgsxnIn(List<String> values) {
            addCriterion("ys_xgsxn in", values, "ysXgsxn");
            return (Criteria) this;
        }

        public Criteria andYsXgsxnNotIn(List<String> values) {
            addCriterion("ys_xgsxn not in", values, "ysXgsxn");
            return (Criteria) this;
        }

        public Criteria andYsXgsxnBetween(String value1, String value2) {
            addCriterion("ys_xgsxn between", value1, value2, "ysXgsxn");
            return (Criteria) this;
        }

        public Criteria andYsXgsxnNotBetween(String value1, String value2) {
            addCriterion("ys_xgsxn not between", value1, value2, "ysXgsxn");
            return (Criteria) this;
        }

        public Criteria andYsYsrqIsNull() {
            addCriterion("ys_ysrq is null");
            return (Criteria) this;
        }

        public Criteria andYsYsrqIsNotNull() {
            addCriterion("ys_ysrq is not null");
            return (Criteria) this;
        }

        public Criteria andYsYsrqEqualTo(Date value) {
            addCriterion("ys_ysrq =", value, "ysYsrq");
            return (Criteria) this;
        }

        public Criteria andYsYsrqNotEqualTo(Date value) {
            addCriterion("ys_ysrq <>", value, "ysYsrq");
            return (Criteria) this;
        }

        public Criteria andYsYsrqGreaterThan(Date value) {
            addCriterion("ys_ysrq >", value, "ysYsrq");
            return (Criteria) this;
        }

        public Criteria andYsYsrqGreaterThanOrEqualTo(Date value) {
            addCriterion("ys_ysrq >=", value, "ysYsrq");
            return (Criteria) this;
        }

        public Criteria andYsYsrqLessThan(Date value) {
            addCriterion("ys_ysrq <", value, "ysYsrq");
            return (Criteria) this;
        }

        public Criteria andYsYsrqLessThanOrEqualTo(Date value) {
            addCriterion("ys_ysrq <=", value, "ysYsrq");
            return (Criteria) this;
        }

        public Criteria andYsYsrqIn(List<Date> values) {
            addCriterion("ys_ysrq in", values, "ysYsrq");
            return (Criteria) this;
        }

        public Criteria andYsYsrqNotIn(List<Date> values) {
            addCriterion("ys_ysrq not in", values, "ysYsrq");
            return (Criteria) this;
        }

        public Criteria andYsYsrqBetween(Date value1, Date value2) {
            addCriterion("ys_ysrq between", value1, value2, "ysYsrq");
            return (Criteria) this;
        }

        public Criteria andYsYsrqNotBetween(Date value1, Date value2) {
            addCriterion("ys_ysrq not between", value1, value2, "ysYsrq");
            return (Criteria) this;
        }

        public Criteria andYsSyqkyjIsNull() {
            addCriterion("ys_syqkyj is null");
            return (Criteria) this;
        }

        public Criteria andYsSyqkyjIsNotNull() {
            addCriterion("ys_syqkyj is not null");
            return (Criteria) this;
        }

        public Criteria andYsSyqkyjEqualTo(String value) {
            addCriterion("ys_syqkyj =", value, "ysSyqkyj");
            return (Criteria) this;
        }

        public Criteria andYsSyqkyjNotEqualTo(String value) {
            addCriterion("ys_syqkyj <>", value, "ysSyqkyj");
            return (Criteria) this;
        }

        public Criteria andYsSyqkyjGreaterThan(String value) {
            addCriterion("ys_syqkyj >", value, "ysSyqkyj");
            return (Criteria) this;
        }

        public Criteria andYsSyqkyjGreaterThanOrEqualTo(String value) {
            addCriterion("ys_syqkyj >=", value, "ysSyqkyj");
            return (Criteria) this;
        }

        public Criteria andYsSyqkyjLessThan(String value) {
            addCriterion("ys_syqkyj <", value, "ysSyqkyj");
            return (Criteria) this;
        }

        public Criteria andYsSyqkyjLessThanOrEqualTo(String value) {
            addCriterion("ys_syqkyj <=", value, "ysSyqkyj");
            return (Criteria) this;
        }

        public Criteria andYsSyqkyjLike(String value) {
            addCriterion("ys_syqkyj like", value, "ysSyqkyj");
            return (Criteria) this;
        }

        public Criteria andYsSyqkyjNotLike(String value) {
            addCriterion("ys_syqkyj not like", value, "ysSyqkyj");
            return (Criteria) this;
        }

        public Criteria andYsSyqkyjIn(List<String> values) {
            addCriterion("ys_syqkyj in", values, "ysSyqkyj");
            return (Criteria) this;
        }

        public Criteria andYsSyqkyjNotIn(List<String> values) {
            addCriterion("ys_syqkyj not in", values, "ysSyqkyj");
            return (Criteria) this;
        }

        public Criteria andYsSyqkyjBetween(String value1, String value2) {
            addCriterion("ys_syqkyj between", value1, value2, "ysSyqkyj");
            return (Criteria) this;
        }

        public Criteria andYsSyqkyjNotBetween(String value1, String value2) {
            addCriterion("ys_syqkyj not between", value1, value2, "ysSyqkyj");
            return (Criteria) this;
        }

        public Criteria andYsSyksfzrIsNull() {
            addCriterion("ys_syksfzr is null");
            return (Criteria) this;
        }

        public Criteria andYsSyksfzrIsNotNull() {
            addCriterion("ys_syksfzr is not null");
            return (Criteria) this;
        }

        public Criteria andYsSyksfzrEqualTo(String value) {
            addCriterion("ys_syksfzr =", value, "ysSyksfzr");
            return (Criteria) this;
        }

        public Criteria andYsSyksfzrNotEqualTo(String value) {
            addCriterion("ys_syksfzr <>", value, "ysSyksfzr");
            return (Criteria) this;
        }

        public Criteria andYsSyksfzrGreaterThan(String value) {
            addCriterion("ys_syksfzr >", value, "ysSyksfzr");
            return (Criteria) this;
        }

        public Criteria andYsSyksfzrGreaterThanOrEqualTo(String value) {
            addCriterion("ys_syksfzr >=", value, "ysSyksfzr");
            return (Criteria) this;
        }

        public Criteria andYsSyksfzrLessThan(String value) {
            addCriterion("ys_syksfzr <", value, "ysSyksfzr");
            return (Criteria) this;
        }

        public Criteria andYsSyksfzrLessThanOrEqualTo(String value) {
            addCriterion("ys_syksfzr <=", value, "ysSyksfzr");
            return (Criteria) this;
        }

        public Criteria andYsSyksfzrLike(String value) {
            addCriterion("ys_syksfzr like", value, "ysSyksfzr");
            return (Criteria) this;
        }

        public Criteria andYsSyksfzrNotLike(String value) {
            addCriterion("ys_syksfzr not like", value, "ysSyksfzr");
            return (Criteria) this;
        }

        public Criteria andYsSyksfzrIn(List<String> values) {
            addCriterion("ys_syksfzr in", values, "ysSyksfzr");
            return (Criteria) this;
        }

        public Criteria andYsSyksfzrNotIn(List<String> values) {
            addCriterion("ys_syksfzr not in", values, "ysSyksfzr");
            return (Criteria) this;
        }

        public Criteria andYsSyksfzrBetween(String value1, String value2) {
            addCriterion("ys_syksfzr between", value1, value2, "ysSyksfzr");
            return (Criteria) this;
        }

        public Criteria andYsSyksfzrNotBetween(String value1, String value2) {
            addCriterion("ys_syksfzr not between", value1, value2, "ysSyksfzr");
            return (Criteria) this;
        }

        public Criteria andYsYsjlIsNull() {
            addCriterion("ys_ysjl is null");
            return (Criteria) this;
        }

        public Criteria andYsYsjlIsNotNull() {
            addCriterion("ys_ysjl is not null");
            return (Criteria) this;
        }

        public Criteria andYsYsjlEqualTo(String value) {
            addCriterion("ys_ysjl =", value, "ysYsjl");
            return (Criteria) this;
        }

        public Criteria andYsYsjlNotEqualTo(String value) {
            addCriterion("ys_ysjl <>", value, "ysYsjl");
            return (Criteria) this;
        }

        public Criteria andYsYsjlGreaterThan(String value) {
            addCriterion("ys_ysjl >", value, "ysYsjl");
            return (Criteria) this;
        }

        public Criteria andYsYsjlGreaterThanOrEqualTo(String value) {
            addCriterion("ys_ysjl >=", value, "ysYsjl");
            return (Criteria) this;
        }

        public Criteria andYsYsjlLessThan(String value) {
            addCriterion("ys_ysjl <", value, "ysYsjl");
            return (Criteria) this;
        }

        public Criteria andYsYsjlLessThanOrEqualTo(String value) {
            addCriterion("ys_ysjl <=", value, "ysYsjl");
            return (Criteria) this;
        }

        public Criteria andYsYsjlLike(String value) {
            addCriterion("ys_ysjl like", value, "ysYsjl");
            return (Criteria) this;
        }

        public Criteria andYsYsjlNotLike(String value) {
            addCriterion("ys_ysjl not like", value, "ysYsjl");
            return (Criteria) this;
        }

        public Criteria andYsYsjlIn(List<String> values) {
            addCriterion("ys_ysjl in", values, "ysYsjl");
            return (Criteria) this;
        }

        public Criteria andYsYsjlNotIn(List<String> values) {
            addCriterion("ys_ysjl not in", values, "ysYsjl");
            return (Criteria) this;
        }

        public Criteria andYsYsjlBetween(String value1, String value2) {
            addCriterion("ys_ysjl between", value1, value2, "ysYsjl");
            return (Criteria) this;
        }

        public Criteria andYsYsjlNotBetween(String value1, String value2) {
            addCriterion("ys_ysjl not between", value1, value2, "ysYsjl");
            return (Criteria) this;
        }

        public Criteria andYsGlsyrIsNull() {
            addCriterion("ys_glsyr is null");
            return (Criteria) this;
        }

        public Criteria andYsGlsyrIsNotNull() {
            addCriterion("ys_glsyr is not null");
            return (Criteria) this;
        }

        public Criteria andYsGlsyrEqualTo(String value) {
            addCriterion("ys_glsyr =", value, "ysGlsyr");
            return (Criteria) this;
        }

        public Criteria andYsGlsyrNotEqualTo(String value) {
            addCriterion("ys_glsyr <>", value, "ysGlsyr");
            return (Criteria) this;
        }

        public Criteria andYsGlsyrGreaterThan(String value) {
            addCriterion("ys_glsyr >", value, "ysGlsyr");
            return (Criteria) this;
        }

        public Criteria andYsGlsyrGreaterThanOrEqualTo(String value) {
            addCriterion("ys_glsyr >=", value, "ysGlsyr");
            return (Criteria) this;
        }

        public Criteria andYsGlsyrLessThan(String value) {
            addCriterion("ys_glsyr <", value, "ysGlsyr");
            return (Criteria) this;
        }

        public Criteria andYsGlsyrLessThanOrEqualTo(String value) {
            addCriterion("ys_glsyr <=", value, "ysGlsyr");
            return (Criteria) this;
        }

        public Criteria andYsGlsyrLike(String value) {
            addCriterion("ys_glsyr like", value, "ysGlsyr");
            return (Criteria) this;
        }

        public Criteria andYsGlsyrNotLike(String value) {
            addCriterion("ys_glsyr not like", value, "ysGlsyr");
            return (Criteria) this;
        }

        public Criteria andYsGlsyrIn(List<String> values) {
            addCriterion("ys_glsyr in", values, "ysGlsyr");
            return (Criteria) this;
        }

        public Criteria andYsGlsyrNotIn(List<String> values) {
            addCriterion("ys_glsyr not in", values, "ysGlsyr");
            return (Criteria) this;
        }

        public Criteria andYsGlsyrBetween(String value1, String value2) {
            addCriterion("ys_glsyr between", value1, value2, "ysGlsyr");
            return (Criteria) this;
        }

        public Criteria andYsGlsyrNotBetween(String value1, String value2) {
            addCriterion("ys_glsyr not between", value1, value2, "ysGlsyr");
            return (Criteria) this;
        }

        public Criteria andYsKsfzrIsNull() {
            addCriterion("ys_ksfzr is null");
            return (Criteria) this;
        }

        public Criteria andYsKsfzrIsNotNull() {
            addCriterion("ys_ksfzr is not null");
            return (Criteria) this;
        }

        public Criteria andYsKsfzrEqualTo(String value) {
            addCriterion("ys_ksfzr =", value, "ysKsfzr");
            return (Criteria) this;
        }

        public Criteria andYsKsfzrNotEqualTo(String value) {
            addCriterion("ys_ksfzr <>", value, "ysKsfzr");
            return (Criteria) this;
        }

        public Criteria andYsKsfzrGreaterThan(String value) {
            addCriterion("ys_ksfzr >", value, "ysKsfzr");
            return (Criteria) this;
        }

        public Criteria andYsKsfzrGreaterThanOrEqualTo(String value) {
            addCriterion("ys_ksfzr >=", value, "ysKsfzr");
            return (Criteria) this;
        }

        public Criteria andYsKsfzrLessThan(String value) {
            addCriterion("ys_ksfzr <", value, "ysKsfzr");
            return (Criteria) this;
        }

        public Criteria andYsKsfzrLessThanOrEqualTo(String value) {
            addCriterion("ys_ksfzr <=", value, "ysKsfzr");
            return (Criteria) this;
        }

        public Criteria andYsKsfzrLike(String value) {
            addCriterion("ys_ksfzr like", value, "ysKsfzr");
            return (Criteria) this;
        }

        public Criteria andYsKsfzrNotLike(String value) {
            addCriterion("ys_ksfzr not like", value, "ysKsfzr");
            return (Criteria) this;
        }

        public Criteria andYsKsfzrIn(List<String> values) {
            addCriterion("ys_ksfzr in", values, "ysKsfzr");
            return (Criteria) this;
        }

        public Criteria andYsKsfzrNotIn(List<String> values) {
            addCriterion("ys_ksfzr not in", values, "ysKsfzr");
            return (Criteria) this;
        }

        public Criteria andYsKsfzrBetween(String value1, String value2) {
            addCriterion("ys_ksfzr between", value1, value2, "ysKsfzr");
            return (Criteria) this;
        }

        public Criteria andYsKsfzrNotBetween(String value1, String value2) {
            addCriterion("ys_ksfzr not between", value1, value2, "ysKsfzr");
            return (Criteria) this;
        }

        public Criteria andYsYsjgIsNull() {
            addCriterion("ys_ysjg is null");
            return (Criteria) this;
        }

        public Criteria andYsYsjgIsNotNull() {
            addCriterion("ys_ysjg is not null");
            return (Criteria) this;
        }

        public Criteria andYsYsjgEqualTo(String value) {
            addCriterion("ys_ysjg =", value, "ysYsjg");
            return (Criteria) this;
        }

        public Criteria andYsYsjgNotEqualTo(String value) {
            addCriterion("ys_ysjg <>", value, "ysYsjg");
            return (Criteria) this;
        }

        public Criteria andYsYsjgGreaterThan(String value) {
            addCriterion("ys_ysjg >", value, "ysYsjg");
            return (Criteria) this;
        }

        public Criteria andYsYsjgGreaterThanOrEqualTo(String value) {
            addCriterion("ys_ysjg >=", value, "ysYsjg");
            return (Criteria) this;
        }

        public Criteria andYsYsjgLessThan(String value) {
            addCriterion("ys_ysjg <", value, "ysYsjg");
            return (Criteria) this;
        }

        public Criteria andYsYsjgLessThanOrEqualTo(String value) {
            addCriterion("ys_ysjg <=", value, "ysYsjg");
            return (Criteria) this;
        }

        public Criteria andYsYsjgLike(String value) {
            addCriterion("ys_ysjg like", value, "ysYsjg");
            return (Criteria) this;
        }

        public Criteria andYsYsjgNotLike(String value) {
            addCriterion("ys_ysjg not like", value, "ysYsjg");
            return (Criteria) this;
        }

        public Criteria andYsYsjgIn(List<String> values) {
            addCriterion("ys_ysjg in", values, "ysYsjg");
            return (Criteria) this;
        }

        public Criteria andYsYsjgNotIn(List<String> values) {
            addCriterion("ys_ysjg not in", values, "ysYsjg");
            return (Criteria) this;
        }

        public Criteria andYsYsjgBetween(String value1, String value2) {
            addCriterion("ys_ysjg between", value1, value2, "ysYsjg");
            return (Criteria) this;
        }

        public Criteria andYsYsjgNotBetween(String value1, String value2) {
            addCriterion("ys_ysjg not between", value1, value2, "ysYsjg");
            return (Criteria) this;
        }

        public Criteria andYsYsqrsjIsNull() {
            addCriterion("ys_ysqrsj is null");
            return (Criteria) this;
        }

        public Criteria andYsYsqrsjIsNotNull() {
            addCriterion("ys_ysqrsj is not null");
            return (Criteria) this;
        }

        public Criteria andYsYsqrsjEqualTo(Date value) {
            addCriterion("ys_ysqrsj =", value, "ysYsqrsj");
            return (Criteria) this;
        }

        public Criteria andYsYsqrsjNotEqualTo(Date value) {
            addCriterion("ys_ysqrsj <>", value, "ysYsqrsj");
            return (Criteria) this;
        }

        public Criteria andYsYsqrsjGreaterThan(Date value) {
            addCriterion("ys_ysqrsj >", value, "ysYsqrsj");
            return (Criteria) this;
        }

        public Criteria andYsYsqrsjGreaterThanOrEqualTo(Date value) {
            addCriterion("ys_ysqrsj >=", value, "ysYsqrsj");
            return (Criteria) this;
        }

        public Criteria andYsYsqrsjLessThan(Date value) {
            addCriterion("ys_ysqrsj <", value, "ysYsqrsj");
            return (Criteria) this;
        }

        public Criteria andYsYsqrsjLessThanOrEqualTo(Date value) {
            addCriterion("ys_ysqrsj <=", value, "ysYsqrsj");
            return (Criteria) this;
        }

        public Criteria andYsYsqrsjIn(List<Date> values) {
            addCriterion("ys_ysqrsj in", values, "ysYsqrsj");
            return (Criteria) this;
        }

        public Criteria andYsYsqrsjNotIn(List<Date> values) {
            addCriterion("ys_ysqrsj not in", values, "ysYsqrsj");
            return (Criteria) this;
        }

        public Criteria andYsYsqrsjBetween(Date value1, Date value2) {
            addCriterion("ys_ysqrsj between", value1, value2, "ysYsqrsj");
            return (Criteria) this;
        }

        public Criteria andYsYsqrsjNotBetween(Date value1, Date value2) {
            addCriterion("ys_ysqrsj not between", value1, value2, "ysYsqrsj");
            return (Criteria) this;
        }

        public Criteria andYsQysjIsNull() {
            addCriterion("ys_qysj is null");
            return (Criteria) this;
        }

        public Criteria andYsQysjIsNotNull() {
            addCriterion("ys_qysj is not null");
            return (Criteria) this;
        }

        public Criteria andYsQysjEqualTo(Date value) {
            addCriterion("ys_qysj =", value, "ysQysj");
            return (Criteria) this;
        }

        public Criteria andYsQysjNotEqualTo(Date value) {
            addCriterion("ys_qysj <>", value, "ysQysj");
            return (Criteria) this;
        }

        public Criteria andYsQysjGreaterThan(Date value) {
            addCriterion("ys_qysj >", value, "ysQysj");
            return (Criteria) this;
        }

        public Criteria andYsQysjGreaterThanOrEqualTo(Date value) {
            addCriterion("ys_qysj >=", value, "ysQysj");
            return (Criteria) this;
        }

        public Criteria andYsQysjLessThan(Date value) {
            addCriterion("ys_qysj <", value, "ysQysj");
            return (Criteria) this;
        }

        public Criteria andYsQysjLessThanOrEqualTo(Date value) {
            addCriterion("ys_qysj <=", value, "ysQysj");
            return (Criteria) this;
        }

        public Criteria andYsQysjIn(List<Date> values) {
            addCriterion("ys_qysj in", values, "ysQysj");
            return (Criteria) this;
        }

        public Criteria andYsQysjNotIn(List<Date> values) {
            addCriterion("ys_qysj not in", values, "ysQysj");
            return (Criteria) this;
        }

        public Criteria andYsQysjBetween(Date value1, Date value2) {
            addCriterion("ys_qysj between", value1, value2, "ysQysj");
            return (Criteria) this;
        }

        public Criteria andYsQysjNotBetween(Date value1, Date value2) {
            addCriterion("ys_qysj not between", value1, value2, "ysQysj");
            return (Criteria) this;
        }

        public Criteria andYsCzgcIsNull() {
            addCriterion("ys_czgc is null");
            return (Criteria) this;
        }

        public Criteria andYsCzgcIsNotNull() {
            addCriterion("ys_czgc is not null");
            return (Criteria) this;
        }

        public Criteria andYsCzgcEqualTo(String value) {
            addCriterion("ys_czgc =", value, "ysCzgc");
            return (Criteria) this;
        }

        public Criteria andYsCzgcNotEqualTo(String value) {
            addCriterion("ys_czgc <>", value, "ysCzgc");
            return (Criteria) this;
        }

        public Criteria andYsCzgcGreaterThan(String value) {
            addCriterion("ys_czgc >", value, "ysCzgc");
            return (Criteria) this;
        }

        public Criteria andYsCzgcGreaterThanOrEqualTo(String value) {
            addCriterion("ys_czgc >=", value, "ysCzgc");
            return (Criteria) this;
        }

        public Criteria andYsCzgcLessThan(String value) {
            addCriterion("ys_czgc <", value, "ysCzgc");
            return (Criteria) this;
        }

        public Criteria andYsCzgcLessThanOrEqualTo(String value) {
            addCriterion("ys_czgc <=", value, "ysCzgc");
            return (Criteria) this;
        }

        public Criteria andYsCzgcLike(String value) {
            addCriterion("ys_czgc like", value, "ysCzgc");
            return (Criteria) this;
        }

        public Criteria andYsCzgcNotLike(String value) {
            addCriterion("ys_czgc not like", value, "ysCzgc");
            return (Criteria) this;
        }

        public Criteria andYsCzgcIn(List<String> values) {
            addCriterion("ys_czgc in", values, "ysCzgc");
            return (Criteria) this;
        }

        public Criteria andYsCzgcNotIn(List<String> values) {
            addCriterion("ys_czgc not in", values, "ysCzgc");
            return (Criteria) this;
        }

        public Criteria andYsCzgcBetween(String value1, String value2) {
            addCriterion("ys_czgc between", value1, value2, "ysCzgc");
            return (Criteria) this;
        }

        public Criteria andYsCzgcNotBetween(String value1, String value2) {
            addCriterion("ys_czgc not between", value1, value2, "ysCzgc");
            return (Criteria) this;
        }

        public Criteria andYsZysxIsNull() {
            addCriterion("ys_zysx is null");
            return (Criteria) this;
        }

        public Criteria andYsZysxIsNotNull() {
            addCriterion("ys_zysx is not null");
            return (Criteria) this;
        }

        public Criteria andYsZysxEqualTo(String value) {
            addCriterion("ys_zysx =", value, "ysZysx");
            return (Criteria) this;
        }

        public Criteria andYsZysxNotEqualTo(String value) {
            addCriterion("ys_zysx <>", value, "ysZysx");
            return (Criteria) this;
        }

        public Criteria andYsZysxGreaterThan(String value) {
            addCriterion("ys_zysx >", value, "ysZysx");
            return (Criteria) this;
        }

        public Criteria andYsZysxGreaterThanOrEqualTo(String value) {
            addCriterion("ys_zysx >=", value, "ysZysx");
            return (Criteria) this;
        }

        public Criteria andYsZysxLessThan(String value) {
            addCriterion("ys_zysx <", value, "ysZysx");
            return (Criteria) this;
        }

        public Criteria andYsZysxLessThanOrEqualTo(String value) {
            addCriterion("ys_zysx <=", value, "ysZysx");
            return (Criteria) this;
        }

        public Criteria andYsZysxLike(String value) {
            addCriterion("ys_zysx like", value, "ysZysx");
            return (Criteria) this;
        }

        public Criteria andYsZysxNotLike(String value) {
            addCriterion("ys_zysx not like", value, "ysZysx");
            return (Criteria) this;
        }

        public Criteria andYsZysxIn(List<String> values) {
            addCriterion("ys_zysx in", values, "ysZysx");
            return (Criteria) this;
        }

        public Criteria andYsZysxNotIn(List<String> values) {
            addCriterion("ys_zysx not in", values, "ysZysx");
            return (Criteria) this;
        }

        public Criteria andYsZysxBetween(String value1, String value2) {
            addCriterion("ys_zysx between", value1, value2, "ysZysx");
            return (Criteria) this;
        }

        public Criteria andYsZysxNotBetween(String value1, String value2) {
            addCriterion("ys_zysx not between", value1, value2, "ysZysx");
            return (Criteria) this;
        }

        public Criteria andYsByzdIsNull() {
            addCriterion("ys_byzd is null");
            return (Criteria) this;
        }

        public Criteria andYsByzdIsNotNull() {
            addCriterion("ys_byzd is not null");
            return (Criteria) this;
        }

        public Criteria andYsByzdEqualTo(String value) {
            addCriterion("ys_byzd =", value, "ysByzd");
            return (Criteria) this;
        }

        public Criteria andYsByzdNotEqualTo(String value) {
            addCriterion("ys_byzd <>", value, "ysByzd");
            return (Criteria) this;
        }

        public Criteria andYsByzdGreaterThan(String value) {
            addCriterion("ys_byzd >", value, "ysByzd");
            return (Criteria) this;
        }

        public Criteria andYsByzdGreaterThanOrEqualTo(String value) {
            addCriterion("ys_byzd >=", value, "ysByzd");
            return (Criteria) this;
        }

        public Criteria andYsByzdLessThan(String value) {
            addCriterion("ys_byzd <", value, "ysByzd");
            return (Criteria) this;
        }

        public Criteria andYsByzdLessThanOrEqualTo(String value) {
            addCriterion("ys_byzd <=", value, "ysByzd");
            return (Criteria) this;
        }

        public Criteria andYsByzdLike(String value) {
            addCriterion("ys_byzd like", value, "ysByzd");
            return (Criteria) this;
        }

        public Criteria andYsByzdNotLike(String value) {
            addCriterion("ys_byzd not like", value, "ysByzd");
            return (Criteria) this;
        }

        public Criteria andYsByzdIn(List<String> values) {
            addCriterion("ys_byzd in", values, "ysByzd");
            return (Criteria) this;
        }

        public Criteria andYsByzdNotIn(List<String> values) {
            addCriterion("ys_byzd not in", values, "ysByzd");
            return (Criteria) this;
        }

        public Criteria andYsByzdBetween(String value1, String value2) {
            addCriterion("ys_byzd between", value1, value2, "ysByzd");
            return (Criteria) this;
        }

        public Criteria andYsByzdNotBetween(String value1, String value2) {
            addCriterion("ys_byzd not between", value1, value2, "ysByzd");
            return (Criteria) this;
        }

        public Criteria andYsCpjjIsNull() {
            addCriterion("ys_cpjj is null");
            return (Criteria) this;
        }

        public Criteria andYsCpjjIsNotNull() {
            addCriterion("ys_cpjj is not null");
            return (Criteria) this;
        }

        public Criteria andYsCpjjEqualTo(String value) {
            addCriterion("ys_cpjj =", value, "ysCpjj");
            return (Criteria) this;
        }

        public Criteria andYsCpjjNotEqualTo(String value) {
            addCriterion("ys_cpjj <>", value, "ysCpjj");
            return (Criteria) this;
        }

        public Criteria andYsCpjjGreaterThan(String value) {
            addCriterion("ys_cpjj >", value, "ysCpjj");
            return (Criteria) this;
        }

        public Criteria andYsCpjjGreaterThanOrEqualTo(String value) {
            addCriterion("ys_cpjj >=", value, "ysCpjj");
            return (Criteria) this;
        }

        public Criteria andYsCpjjLessThan(String value) {
            addCriterion("ys_cpjj <", value, "ysCpjj");
            return (Criteria) this;
        }

        public Criteria andYsCpjjLessThanOrEqualTo(String value) {
            addCriterion("ys_cpjj <=", value, "ysCpjj");
            return (Criteria) this;
        }

        public Criteria andYsCpjjLike(String value) {
            addCriterion("ys_cpjj like", value, "ysCpjj");
            return (Criteria) this;
        }

        public Criteria andYsCpjjNotLike(String value) {
            addCriterion("ys_cpjj not like", value, "ysCpjj");
            return (Criteria) this;
        }

        public Criteria andYsCpjjIn(List<String> values) {
            addCriterion("ys_cpjj in", values, "ysCpjj");
            return (Criteria) this;
        }

        public Criteria andYsCpjjNotIn(List<String> values) {
            addCriterion("ys_cpjj not in", values, "ysCpjj");
            return (Criteria) this;
        }

        public Criteria andYsCpjjBetween(String value1, String value2) {
            addCriterion("ys_cpjj between", value1, value2, "ysCpjj");
            return (Criteria) this;
        }

        public Criteria andYsCpjjNotBetween(String value1, String value2) {
            addCriterion("ys_cpjj not between", value1, value2, "ysCpjj");
            return (Criteria) this;
        }

        public Criteria andYsZlkzIsNull() {
            addCriterion("ys_zlkz is null");
            return (Criteria) this;
        }

        public Criteria andYsZlkzIsNotNull() {
            addCriterion("ys_zlkz is not null");
            return (Criteria) this;
        }

        public Criteria andYsZlkzEqualTo(String value) {
            addCriterion("ys_zlkz =", value, "ysZlkz");
            return (Criteria) this;
        }

        public Criteria andYsZlkzNotEqualTo(String value) {
            addCriterion("ys_zlkz <>", value, "ysZlkz");
            return (Criteria) this;
        }

        public Criteria andYsZlkzGreaterThan(String value) {
            addCriterion("ys_zlkz >", value, "ysZlkz");
            return (Criteria) this;
        }

        public Criteria andYsZlkzGreaterThanOrEqualTo(String value) {
            addCriterion("ys_zlkz >=", value, "ysZlkz");
            return (Criteria) this;
        }

        public Criteria andYsZlkzLessThan(String value) {
            addCriterion("ys_zlkz <", value, "ysZlkz");
            return (Criteria) this;
        }

        public Criteria andYsZlkzLessThanOrEqualTo(String value) {
            addCriterion("ys_zlkz <=", value, "ysZlkz");
            return (Criteria) this;
        }

        public Criteria andYsZlkzLike(String value) {
            addCriterion("ys_zlkz like", value, "ysZlkz");
            return (Criteria) this;
        }

        public Criteria andYsZlkzNotLike(String value) {
            addCriterion("ys_zlkz not like", value, "ysZlkz");
            return (Criteria) this;
        }

        public Criteria andYsZlkzIn(List<String> values) {
            addCriterion("ys_zlkz in", values, "ysZlkz");
            return (Criteria) this;
        }

        public Criteria andYsZlkzNotIn(List<String> values) {
            addCriterion("ys_zlkz not in", values, "ysZlkz");
            return (Criteria) this;
        }

        public Criteria andYsZlkzBetween(String value1, String value2) {
            addCriterion("ys_zlkz between", value1, value2, "ysZlkz");
            return (Criteria) this;
        }

        public Criteria andYsZlkzNotBetween(String value1, String value2) {
            addCriterion("ys_zlkz not between", value1, value2, "ysZlkz");
            return (Criteria) this;
        }

        public Criteria andYsIstgIsNull() {
            addCriterion("ys_istg is null");
            return (Criteria) this;
        }

        public Criteria andYsIstgIsNotNull() {
            addCriterion("ys_istg is not null");
            return (Criteria) this;
        }

        public Criteria andYsIstgEqualTo(String value) {
            addCriterion("ys_istg =", value, "ysIstg");
            return (Criteria) this;
        }

        public Criteria andYsIstgNotEqualTo(String value) {
            addCriterion("ys_istg <>", value, "ysIstg");
            return (Criteria) this;
        }

        public Criteria andYsIstgGreaterThan(String value) {
            addCriterion("ys_istg >", value, "ysIstg");
            return (Criteria) this;
        }

        public Criteria andYsIstgGreaterThanOrEqualTo(String value) {
            addCriterion("ys_istg >=", value, "ysIstg");
            return (Criteria) this;
        }

        public Criteria andYsIstgLessThan(String value) {
            addCriterion("ys_istg <", value, "ysIstg");
            return (Criteria) this;
        }

        public Criteria andYsIstgLessThanOrEqualTo(String value) {
            addCriterion("ys_istg <=", value, "ysIstg");
            return (Criteria) this;
        }

        public Criteria andYsIstgLike(String value) {
            addCriterion("ys_istg like", value, "ysIstg");
            return (Criteria) this;
        }

        public Criteria andYsIstgNotLike(String value) {
            addCriterion("ys_istg not like", value, "ysIstg");
            return (Criteria) this;
        }

        public Criteria andYsIstgIn(List<String> values) {
            addCriterion("ys_istg in", values, "ysIstg");
            return (Criteria) this;
        }

        public Criteria andYsIstgNotIn(List<String> values) {
            addCriterion("ys_istg not in", values, "ysIstg");
            return (Criteria) this;
        }

        public Criteria andYsIstgBetween(String value1, String value2) {
            addCriterion("ys_istg between", value1, value2, "ysIstg");
            return (Criteria) this;
        }

        public Criteria andYsIstgNotBetween(String value1, String value2) {
            addCriterion("ys_istg not between", value1, value2, "ysIstg");
            return (Criteria) this;
        }

        public Criteria andYsThhIsNull() {
            addCriterion("ys_thh is null");
            return (Criteria) this;
        }

        public Criteria andYsThhIsNotNull() {
            addCriterion("ys_thh is not null");
            return (Criteria) this;
        }

        public Criteria andYsThhEqualTo(String value) {
            addCriterion("ys_thh =", value, "ysThh");
            return (Criteria) this;
        }

        public Criteria andYsThhNotEqualTo(String value) {
            addCriterion("ys_thh <>", value, "ysThh");
            return (Criteria) this;
        }

        public Criteria andYsThhGreaterThan(String value) {
            addCriterion("ys_thh >", value, "ysThh");
            return (Criteria) this;
        }

        public Criteria andYsThhGreaterThanOrEqualTo(String value) {
            addCriterion("ys_thh >=", value, "ysThh");
            return (Criteria) this;
        }

        public Criteria andYsThhLessThan(String value) {
            addCriterion("ys_thh <", value, "ysThh");
            return (Criteria) this;
        }

        public Criteria andYsThhLessThanOrEqualTo(String value) {
            addCriterion("ys_thh <=", value, "ysThh");
            return (Criteria) this;
        }

        public Criteria andYsThhLike(String value) {
            addCriterion("ys_thh like", value, "ysThh");
            return (Criteria) this;
        }

        public Criteria andYsThhNotLike(String value) {
            addCriterion("ys_thh not like", value, "ysThh");
            return (Criteria) this;
        }

        public Criteria andYsThhIn(List<String> values) {
            addCriterion("ys_thh in", values, "ysThh");
            return (Criteria) this;
        }

        public Criteria andYsThhNotIn(List<String> values) {
            addCriterion("ys_thh not in", values, "ysThh");
            return (Criteria) this;
        }

        public Criteria andYsThhBetween(String value1, String value2) {
            addCriterion("ys_thh between", value1, value2, "ysThh");
            return (Criteria) this;
        }

        public Criteria andYsThhNotBetween(String value1, String value2) {
            addCriterion("ys_thh not between", value1, value2, "ysThh");
            return (Criteria) this;
        }

        public Criteria andYsThyyIsNull() {
            addCriterion("ys_thyy is null");
            return (Criteria) this;
        }

        public Criteria andYsThyyIsNotNull() {
            addCriterion("ys_thyy is not null");
            return (Criteria) this;
        }

        public Criteria andYsThyyEqualTo(String value) {
            addCriterion("ys_thyy =", value, "ysThyy");
            return (Criteria) this;
        }

        public Criteria andYsThyyNotEqualTo(String value) {
            addCriterion("ys_thyy <>", value, "ysThyy");
            return (Criteria) this;
        }

        public Criteria andYsThyyGreaterThan(String value) {
            addCriterion("ys_thyy >", value, "ysThyy");
            return (Criteria) this;
        }

        public Criteria andYsThyyGreaterThanOrEqualTo(String value) {
            addCriterion("ys_thyy >=", value, "ysThyy");
            return (Criteria) this;
        }

        public Criteria andYsThyyLessThan(String value) {
            addCriterion("ys_thyy <", value, "ysThyy");
            return (Criteria) this;
        }

        public Criteria andYsThyyLessThanOrEqualTo(String value) {
            addCriterion("ys_thyy <=", value, "ysThyy");
            return (Criteria) this;
        }

        public Criteria andYsThyyLike(String value) {
            addCriterion("ys_thyy like", value, "ysThyy");
            return (Criteria) this;
        }

        public Criteria andYsThyyNotLike(String value) {
            addCriterion("ys_thyy not like", value, "ysThyy");
            return (Criteria) this;
        }

        public Criteria andYsThyyIn(List<String> values) {
            addCriterion("ys_thyy in", values, "ysThyy");
            return (Criteria) this;
        }

        public Criteria andYsThyyNotIn(List<String> values) {
            addCriterion("ys_thyy not in", values, "ysThyy");
            return (Criteria) this;
        }

        public Criteria andYsThyyBetween(String value1, String value2) {
            addCriterion("ys_thyy between", value1, value2, "ysThyy");
            return (Criteria) this;
        }

        public Criteria andYsThyyNotBetween(String value1, String value2) {
            addCriterion("ys_thyy not between", value1, value2, "ysThyy");
            return (Criteria) this;
        }

        public Criteria andYsThsjIsNull() {
            addCriterion("ys_thsj is null");
            return (Criteria) this;
        }

        public Criteria andYsThsjIsNotNull() {
            addCriterion("ys_thsj is not null");
            return (Criteria) this;
        }

        public Criteria andYsThsjEqualTo(Date value) {
            addCriterion("ys_thsj =", value, "ysThsj");
            return (Criteria) this;
        }

        public Criteria andYsThsjNotEqualTo(Date value) {
            addCriterion("ys_thsj <>", value, "ysThsj");
            return (Criteria) this;
        }

        public Criteria andYsThsjGreaterThan(Date value) {
            addCriterion("ys_thsj >", value, "ysThsj");
            return (Criteria) this;
        }

        public Criteria andYsThsjGreaterThanOrEqualTo(Date value) {
            addCriterion("ys_thsj >=", value, "ysThsj");
            return (Criteria) this;
        }

        public Criteria andYsThsjLessThan(Date value) {
            addCriterion("ys_thsj <", value, "ysThsj");
            return (Criteria) this;
        }

        public Criteria andYsThsjLessThanOrEqualTo(Date value) {
            addCriterion("ys_thsj <=", value, "ysThsj");
            return (Criteria) this;
        }

        public Criteria andYsThsjIn(List<Date> values) {
            addCriterion("ys_thsj in", values, "ysThsj");
            return (Criteria) this;
        }

        public Criteria andYsThsjNotIn(List<Date> values) {
            addCriterion("ys_thsj not in", values, "ysThsj");
            return (Criteria) this;
        }

        public Criteria andYsThsjBetween(Date value1, Date value2) {
            addCriterion("ys_thsj between", value1, value2, "ysThsj");
            return (Criteria) this;
        }

        public Criteria andYsThsjNotBetween(Date value1, Date value2) {
            addCriterion("ys_thsj not between", value1, value2, "ysThsj");
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