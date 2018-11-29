package com.litbo.hospital.lifemanage.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SgKxxfxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgKxxfxExample() {
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

        public Criteria andKxfxSyrqIsNull() {
            addCriterion("kxfx_syrq is null");
            return (Criteria) this;
        }

        public Criteria andKxfxSyrqIsNotNull() {
            addCriterion("kxfx_syrq is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxSyrqEqualTo(Date value) {
            addCriterion("kxfx_syrq =", value, "kxfxSyrq");
            return (Criteria) this;
        }

        public Criteria andKxfxSyrqNotEqualTo(Date value) {
            addCriterion("kxfx_syrq <>", value, "kxfxSyrq");
            return (Criteria) this;
        }

        public Criteria andKxfxSyrqGreaterThan(Date value) {
            addCriterion("kxfx_syrq >", value, "kxfxSyrq");
            return (Criteria) this;
        }

        public Criteria andKxfxSyrqGreaterThanOrEqualTo(Date value) {
            addCriterion("kxfx_syrq >=", value, "kxfxSyrq");
            return (Criteria) this;
        }

        public Criteria andKxfxSyrqLessThan(Date value) {
            addCriterion("kxfx_syrq <", value, "kxfxSyrq");
            return (Criteria) this;
        }

        public Criteria andKxfxSyrqLessThanOrEqualTo(Date value) {
            addCriterion("kxfx_syrq <=", value, "kxfxSyrq");
            return (Criteria) this;
        }

        public Criteria andKxfxSyrqIn(List<Date> values) {
            addCriterion("kxfx_syrq in", values, "kxfxSyrq");
            return (Criteria) this;
        }

        public Criteria andKxfxSyrqNotIn(List<Date> values) {
            addCriterion("kxfx_syrq not in", values, "kxfxSyrq");
            return (Criteria) this;
        }

        public Criteria andKxfxSyrqBetween(Date value1, Date value2) {
            addCriterion("kxfx_syrq between", value1, value2, "kxfxSyrq");
            return (Criteria) this;
        }

        public Criteria andKxfxSyrqNotBetween(Date value1, Date value2) {
            addCriterion("kxfx_syrq not between", value1, value2, "kxfxSyrq");
            return (Criteria) this;
        }

        public Criteria andKxfxSyqxIsNull() {
            addCriterion("kxfx_syqx is null");
            return (Criteria) this;
        }

        public Criteria andKxfxSyqxIsNotNull() {
            addCriterion("kxfx_syqx is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxSyqxEqualTo(Integer value) {
            addCriterion("kxfx_syqx =", value, "kxfxSyqx");
            return (Criteria) this;
        }

        public Criteria andKxfxSyqxNotEqualTo(Integer value) {
            addCriterion("kxfx_syqx <>", value, "kxfxSyqx");
            return (Criteria) this;
        }

        public Criteria andKxfxSyqxGreaterThan(Integer value) {
            addCriterion("kxfx_syqx >", value, "kxfxSyqx");
            return (Criteria) this;
        }

        public Criteria andKxfxSyqxGreaterThanOrEqualTo(Integer value) {
            addCriterion("kxfx_syqx >=", value, "kxfxSyqx");
            return (Criteria) this;
        }

        public Criteria andKxfxSyqxLessThan(Integer value) {
            addCriterion("kxfx_syqx <", value, "kxfxSyqx");
            return (Criteria) this;
        }

        public Criteria andKxfxSyqxLessThanOrEqualTo(Integer value) {
            addCriterion("kxfx_syqx <=", value, "kxfxSyqx");
            return (Criteria) this;
        }

        public Criteria andKxfxSyqxIn(List<Integer> values) {
            addCriterion("kxfx_syqx in", values, "kxfxSyqx");
            return (Criteria) this;
        }

        public Criteria andKxfxSyqxNotIn(List<Integer> values) {
            addCriterion("kxfx_syqx not in", values, "kxfxSyqx");
            return (Criteria) this;
        }

        public Criteria andKxfxSyqxBetween(Integer value1, Integer value2) {
            addCriterion("kxfx_syqx between", value1, value2, "kxfxSyqx");
            return (Criteria) this;
        }

        public Criteria andKxfxSyqxNotBetween(Integer value1, Integer value2) {
            addCriterion("kxfx_syqx not between", value1, value2, "kxfxSyqx");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqxIsNull() {
            addCriterion("kxfx_hbqx is null");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqxIsNotNull() {
            addCriterion("kxfx_hbqx is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqxEqualTo(Integer value) {
            addCriterion("kxfx_hbqx =", value, "kxfxHbqx");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqxNotEqualTo(Integer value) {
            addCriterion("kxfx_hbqx <>", value, "kxfxHbqx");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqxGreaterThan(Integer value) {
            addCriterion("kxfx_hbqx >", value, "kxfxHbqx");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqxGreaterThanOrEqualTo(Integer value) {
            addCriterion("kxfx_hbqx >=", value, "kxfxHbqx");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqxLessThan(Integer value) {
            addCriterion("kxfx_hbqx <", value, "kxfxHbqx");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqxLessThanOrEqualTo(Integer value) {
            addCriterion("kxfx_hbqx <=", value, "kxfxHbqx");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqxIn(List<Integer> values) {
            addCriterion("kxfx_hbqx in", values, "kxfxHbqx");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqxNotIn(List<Integer> values) {
            addCriterion("kxfx_hbqx not in", values, "kxfxHbqx");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqxBetween(Integer value1, Integer value2) {
            addCriterion("kxfx_hbqx between", value1, value2, "kxfxHbqx");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqxNotBetween(Integer value1, Integer value2) {
            addCriterion("kxfx_hbqx not between", value1, value2, "kxfxHbqx");
            return (Criteria) this;
        }

        public Criteria andKxfxSfxmIsNull() {
            addCriterion("kxfx_sfxm is null");
            return (Criteria) this;
        }

        public Criteria andKxfxSfxmIsNotNull() {
            addCriterion("kxfx_sfxm is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxSfxmEqualTo(String value) {
            addCriterion("kxfx_sfxm =", value, "kxfxSfxm");
            return (Criteria) this;
        }

        public Criteria andKxfxSfxmNotEqualTo(String value) {
            addCriterion("kxfx_sfxm <>", value, "kxfxSfxm");
            return (Criteria) this;
        }

        public Criteria andKxfxSfxmGreaterThan(String value) {
            addCriterion("kxfx_sfxm >", value, "kxfxSfxm");
            return (Criteria) this;
        }

        public Criteria andKxfxSfxmGreaterThanOrEqualTo(String value) {
            addCriterion("kxfx_sfxm >=", value, "kxfxSfxm");
            return (Criteria) this;
        }

        public Criteria andKxfxSfxmLessThan(String value) {
            addCriterion("kxfx_sfxm <", value, "kxfxSfxm");
            return (Criteria) this;
        }

        public Criteria andKxfxSfxmLessThanOrEqualTo(String value) {
            addCriterion("kxfx_sfxm <=", value, "kxfxSfxm");
            return (Criteria) this;
        }

        public Criteria andKxfxSfxmLike(String value) {
            addCriterion("kxfx_sfxm like", value, "kxfxSfxm");
            return (Criteria) this;
        }

        public Criteria andKxfxSfxmNotLike(String value) {
            addCriterion("kxfx_sfxm not like", value, "kxfxSfxm");
            return (Criteria) this;
        }

        public Criteria andKxfxSfxmIn(List<String> values) {
            addCriterion("kxfx_sfxm in", values, "kxfxSfxm");
            return (Criteria) this;
        }

        public Criteria andKxfxSfxmNotIn(List<String> values) {
            addCriterion("kxfx_sfxm not in", values, "kxfxSfxm");
            return (Criteria) this;
        }

        public Criteria andKxfxSfxmBetween(String value1, String value2) {
            addCriterion("kxfx_sfxm between", value1, value2, "kxfxSfxm");
            return (Criteria) this;
        }

        public Criteria andKxfxSfxmNotBetween(String value1, String value2) {
            addCriterion("kxfx_sfxm not between", value1, value2, "kxfxSfxm");
            return (Criteria) this;
        }

        public Criteria andKxfxPjsfIsNull() {
            addCriterion("kxfx_pjsf is null");
            return (Criteria) this;
        }

        public Criteria andKxfxPjsfIsNotNull() {
            addCriterion("kxfx_pjsf is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxPjsfEqualTo(BigDecimal value) {
            addCriterion("kxfx_pjsf =", value, "kxfxPjsf");
            return (Criteria) this;
        }

        public Criteria andKxfxPjsfNotEqualTo(BigDecimal value) {
            addCriterion("kxfx_pjsf <>", value, "kxfxPjsf");
            return (Criteria) this;
        }

        public Criteria andKxfxPjsfGreaterThan(BigDecimal value) {
            addCriterion("kxfx_pjsf >", value, "kxfxPjsf");
            return (Criteria) this;
        }

        public Criteria andKxfxPjsfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_pjsf >=", value, "kxfxPjsf");
            return (Criteria) this;
        }

        public Criteria andKxfxPjsfLessThan(BigDecimal value) {
            addCriterion("kxfx_pjsf <", value, "kxfxPjsf");
            return (Criteria) this;
        }

        public Criteria andKxfxPjsfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_pjsf <=", value, "kxfxPjsf");
            return (Criteria) this;
        }

        public Criteria andKxfxPjsfIn(List<BigDecimal> values) {
            addCriterion("kxfx_pjsf in", values, "kxfxPjsf");
            return (Criteria) this;
        }

        public Criteria andKxfxPjsfNotIn(List<BigDecimal> values) {
            addCriterion("kxfx_pjsf not in", values, "kxfxPjsf");
            return (Criteria) this;
        }

        public Criteria andKxfxPjsfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_pjsf between", value1, value2, "kxfxPjsf");
            return (Criteria) this;
        }

        public Criteria andKxfxPjsfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_pjsf not between", value1, value2, "kxfxPjsf");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyrcIsNull() {
            addCriterion("kxfx_yjyrc is null");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyrcIsNotNull() {
            addCriterion("kxfx_yjyrc is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyrcEqualTo(Integer value) {
            addCriterion("kxfx_yjyrc =", value, "kxfxYjyrc");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyrcNotEqualTo(Integer value) {
            addCriterion("kxfx_yjyrc <>", value, "kxfxYjyrc");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyrcGreaterThan(Integer value) {
            addCriterion("kxfx_yjyrc >", value, "kxfxYjyrc");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyrcGreaterThanOrEqualTo(Integer value) {
            addCriterion("kxfx_yjyrc >=", value, "kxfxYjyrc");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyrcLessThan(Integer value) {
            addCriterion("kxfx_yjyrc <", value, "kxfxYjyrc");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyrcLessThanOrEqualTo(Integer value) {
            addCriterion("kxfx_yjyrc <=", value, "kxfxYjyrc");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyrcIn(List<Integer> values) {
            addCriterion("kxfx_yjyrc in", values, "kxfxYjyrc");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyrcNotIn(List<Integer> values) {
            addCriterion("kxfx_yjyrc not in", values, "kxfxYjyrc");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyrcBetween(Integer value1, Integer value2) {
            addCriterion("kxfx_yjyrc between", value1, value2, "kxfxYjyrc");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyrcNotBetween(Integer value1, Integer value2) {
            addCriterion("kxfx_yjyrc not between", value1, value2, "kxfxYjyrc");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyzeIsNull() {
            addCriterion("kxfx_yjyze is null");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyzeIsNotNull() {
            addCriterion("kxfx_yjyze is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyzeEqualTo(BigDecimal value) {
            addCriterion("kxfx_yjyze =", value, "kxfxYjyze");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyzeNotEqualTo(BigDecimal value) {
            addCriterion("kxfx_yjyze <>", value, "kxfxYjyze");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyzeGreaterThan(BigDecimal value) {
            addCriterion("kxfx_yjyze >", value, "kxfxYjyze");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyzeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_yjyze >=", value, "kxfxYjyze");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyzeLessThan(BigDecimal value) {
            addCriterion("kxfx_yjyze <", value, "kxfxYjyze");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyzeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_yjyze <=", value, "kxfxYjyze");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyzeIn(List<BigDecimal> values) {
            addCriterion("kxfx_yjyze in", values, "kxfxYjyze");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyzeNotIn(List<BigDecimal> values) {
            addCriterion("kxfx_yjyze not in", values, "kxfxYjyze");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyzeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_yjyze between", value1, value2, "kxfxYjyze");
            return (Criteria) this;
        }

        public Criteria andKxfxYjyzeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_yjyze not between", value1, value2, "kxfxYjyze");
            return (Criteria) this;
        }

        public Criteria andKxfxYjwcysrIsNull() {
            addCriterion("kxfx_yjwcysr is null");
            return (Criteria) this;
        }

        public Criteria andKxfxYjwcysrIsNotNull() {
            addCriterion("kxfx_yjwcysr is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxYjwcysrEqualTo(BigDecimal value) {
            addCriterion("kxfx_yjwcysr =", value, "kxfxYjwcysr");
            return (Criteria) this;
        }

        public Criteria andKxfxYjwcysrNotEqualTo(BigDecimal value) {
            addCriterion("kxfx_yjwcysr <>", value, "kxfxYjwcysr");
            return (Criteria) this;
        }

        public Criteria andKxfxYjwcysrGreaterThan(BigDecimal value) {
            addCriterion("kxfx_yjwcysr >", value, "kxfxYjwcysr");
            return (Criteria) this;
        }

        public Criteria andKxfxYjwcysrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_yjwcysr >=", value, "kxfxYjwcysr");
            return (Criteria) this;
        }

        public Criteria andKxfxYjwcysrLessThan(BigDecimal value) {
            addCriterion("kxfx_yjwcysr <", value, "kxfxYjwcysr");
            return (Criteria) this;
        }

        public Criteria andKxfxYjwcysrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_yjwcysr <=", value, "kxfxYjwcysr");
            return (Criteria) this;
        }

        public Criteria andKxfxYjwcysrIn(List<BigDecimal> values) {
            addCriterion("kxfx_yjwcysr in", values, "kxfxYjwcysr");
            return (Criteria) this;
        }

        public Criteria andKxfxYjwcysrNotIn(List<BigDecimal> values) {
            addCriterion("kxfx_yjwcysr not in", values, "kxfxYjwcysr");
            return (Criteria) this;
        }

        public Criteria andKxfxYjwcysrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_yjwcysr between", value1, value2, "kxfxYjwcysr");
            return (Criteria) this;
        }

        public Criteria andKxfxYjwcysrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_yjwcysr not between", value1, value2, "kxfxYjwcysr");
            return (Criteria) this;
        }

        public Criteria andKxfxZxsbtzIsNull() {
            addCriterion("kxfx_zxsbtz is null");
            return (Criteria) this;
        }

        public Criteria andKxfxZxsbtzIsNotNull() {
            addCriterion("kxfx_zxsbtz is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxZxsbtzEqualTo(BigDecimal value) {
            addCriterion("kxfx_zxsbtz =", value, "kxfxZxsbtz");
            return (Criteria) this;
        }

        public Criteria andKxfxZxsbtzNotEqualTo(BigDecimal value) {
            addCriterion("kxfx_zxsbtz <>", value, "kxfxZxsbtz");
            return (Criteria) this;
        }

        public Criteria andKxfxZxsbtzGreaterThan(BigDecimal value) {
            addCriterion("kxfx_zxsbtz >", value, "kxfxZxsbtz");
            return (Criteria) this;
        }

        public Criteria andKxfxZxsbtzGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_zxsbtz >=", value, "kxfxZxsbtz");
            return (Criteria) this;
        }

        public Criteria andKxfxZxsbtzLessThan(BigDecimal value) {
            addCriterion("kxfx_zxsbtz <", value, "kxfxZxsbtz");
            return (Criteria) this;
        }

        public Criteria andKxfxZxsbtzLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_zxsbtz <=", value, "kxfxZxsbtz");
            return (Criteria) this;
        }

        public Criteria andKxfxZxsbtzIn(List<BigDecimal> values) {
            addCriterion("kxfx_zxsbtz in", values, "kxfxZxsbtz");
            return (Criteria) this;
        }

        public Criteria andKxfxZxsbtzNotIn(List<BigDecimal> values) {
            addCriterion("kxfx_zxsbtz not in", values, "kxfxZxsbtz");
            return (Criteria) this;
        }

        public Criteria andKxfxZxsbtzBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_zxsbtz between", value1, value2, "kxfxZxsbtz");
            return (Criteria) this;
        }

        public Criteria andKxfxZxsbtzNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_zxsbtz not between", value1, value2, "kxfxZxsbtz");
            return (Criteria) this;
        }

        public Criteria andKxfxPtssIsNull() {
            addCriterion("kxfx_ptss is null");
            return (Criteria) this;
        }

        public Criteria andKxfxPtssIsNotNull() {
            addCriterion("kxfx_ptss is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxPtssEqualTo(BigDecimal value) {
            addCriterion("kxfx_ptss =", value, "kxfxPtss");
            return (Criteria) this;
        }

        public Criteria andKxfxPtssNotEqualTo(BigDecimal value) {
            addCriterion("kxfx_ptss <>", value, "kxfxPtss");
            return (Criteria) this;
        }

        public Criteria andKxfxPtssGreaterThan(BigDecimal value) {
            addCriterion("kxfx_ptss >", value, "kxfxPtss");
            return (Criteria) this;
        }

        public Criteria andKxfxPtssGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_ptss >=", value, "kxfxPtss");
            return (Criteria) this;
        }

        public Criteria andKxfxPtssLessThan(BigDecimal value) {
            addCriterion("kxfx_ptss <", value, "kxfxPtss");
            return (Criteria) this;
        }

        public Criteria andKxfxPtssLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_ptss <=", value, "kxfxPtss");
            return (Criteria) this;
        }

        public Criteria andKxfxPtssIn(List<BigDecimal> values) {
            addCriterion("kxfx_ptss in", values, "kxfxPtss");
            return (Criteria) this;
        }

        public Criteria andKxfxPtssNotIn(List<BigDecimal> values) {
            addCriterion("kxfx_ptss not in", values, "kxfxPtss");
            return (Criteria) this;
        }

        public Criteria andKxfxPtssBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_ptss between", value1, value2, "kxfxPtss");
            return (Criteria) this;
        }

        public Criteria andKxfxPtssNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_ptss not between", value1, value2, "kxfxPtss");
            return (Criteria) this;
        }

        public Criteria andKxfxYjcwxfyIsNull() {
            addCriterion("kxfx_yjcwxfy is null");
            return (Criteria) this;
        }

        public Criteria andKxfxYjcwxfyIsNotNull() {
            addCriterion("kxfx_yjcwxfy is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxYjcwxfyEqualTo(BigDecimal value) {
            addCriterion("kxfx_yjcwxfy =", value, "kxfxYjcwxfy");
            return (Criteria) this;
        }

        public Criteria andKxfxYjcwxfyNotEqualTo(BigDecimal value) {
            addCriterion("kxfx_yjcwxfy <>", value, "kxfxYjcwxfy");
            return (Criteria) this;
        }

        public Criteria andKxfxYjcwxfyGreaterThan(BigDecimal value) {
            addCriterion("kxfx_yjcwxfy >", value, "kxfxYjcwxfy");
            return (Criteria) this;
        }

        public Criteria andKxfxYjcwxfyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_yjcwxfy >=", value, "kxfxYjcwxfy");
            return (Criteria) this;
        }

        public Criteria andKxfxYjcwxfyLessThan(BigDecimal value) {
            addCriterion("kxfx_yjcwxfy <", value, "kxfxYjcwxfy");
            return (Criteria) this;
        }

        public Criteria andKxfxYjcwxfyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_yjcwxfy <=", value, "kxfxYjcwxfy");
            return (Criteria) this;
        }

        public Criteria andKxfxYjcwxfyIn(List<BigDecimal> values) {
            addCriterion("kxfx_yjcwxfy in", values, "kxfxYjcwxfy");
            return (Criteria) this;
        }

        public Criteria andKxfxYjcwxfyNotIn(List<BigDecimal> values) {
            addCriterion("kxfx_yjcwxfy not in", values, "kxfxYjcwxfy");
            return (Criteria) this;
        }

        public Criteria andKxfxYjcwxfyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_yjcwxfy between", value1, value2, "kxfxYjcwxfy");
            return (Criteria) this;
        }

        public Criteria andKxfxYjcwxfyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_yjcwxfy not between", value1, value2, "kxfxYjcwxfy");
            return (Criteria) this;
        }

        public Criteria andKxfxYclfIsNull() {
            addCriterion("kxfx_yclf is null");
            return (Criteria) this;
        }

        public Criteria andKxfxYclfIsNotNull() {
            addCriterion("kxfx_yclf is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxYclfEqualTo(BigDecimal value) {
            addCriterion("kxfx_yclf =", value, "kxfxYclf");
            return (Criteria) this;
        }

        public Criteria andKxfxYclfNotEqualTo(BigDecimal value) {
            addCriterion("kxfx_yclf <>", value, "kxfxYclf");
            return (Criteria) this;
        }

        public Criteria andKxfxYclfGreaterThan(BigDecimal value) {
            addCriterion("kxfx_yclf >", value, "kxfxYclf");
            return (Criteria) this;
        }

        public Criteria andKxfxYclfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_yclf >=", value, "kxfxYclf");
            return (Criteria) this;
        }

        public Criteria andKxfxYclfLessThan(BigDecimal value) {
            addCriterion("kxfx_yclf <", value, "kxfxYclf");
            return (Criteria) this;
        }

        public Criteria andKxfxYclfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_yclf <=", value, "kxfxYclf");
            return (Criteria) this;
        }

        public Criteria andKxfxYclfIn(List<BigDecimal> values) {
            addCriterion("kxfx_yclf in", values, "kxfxYclf");
            return (Criteria) this;
        }

        public Criteria andKxfxYclfNotIn(List<BigDecimal> values) {
            addCriterion("kxfx_yclf not in", values, "kxfxYclf");
            return (Criteria) this;
        }

        public Criteria andKxfxYclfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_yclf between", value1, value2, "kxfxYclf");
            return (Criteria) this;
        }

        public Criteria andKxfxYclfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_yclf not between", value1, value2, "kxfxYclf");
            return (Criteria) this;
        }

        public Criteria andKxfxSbzjfIsNull() {
            addCriterion("kxfx_sbzjf is null");
            return (Criteria) this;
        }

        public Criteria andKxfxSbzjfIsNotNull() {
            addCriterion("kxfx_sbzjf is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxSbzjfEqualTo(BigDecimal value) {
            addCriterion("kxfx_sbzjf =", value, "kxfxSbzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxSbzjfNotEqualTo(BigDecimal value) {
            addCriterion("kxfx_sbzjf <>", value, "kxfxSbzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxSbzjfGreaterThan(BigDecimal value) {
            addCriterion("kxfx_sbzjf >", value, "kxfxSbzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxSbzjfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_sbzjf >=", value, "kxfxSbzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxSbzjfLessThan(BigDecimal value) {
            addCriterion("kxfx_sbzjf <", value, "kxfxSbzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxSbzjfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_sbzjf <=", value, "kxfxSbzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxSbzjfIn(List<BigDecimal> values) {
            addCriterion("kxfx_sbzjf in", values, "kxfxSbzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxSbzjfNotIn(List<BigDecimal> values) {
            addCriterion("kxfx_sbzjf not in", values, "kxfxSbzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxSbzjfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_sbzjf between", value1, value2, "kxfxSbzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxSbzjfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_sbzjf not between", value1, value2, "kxfxSbzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxQtzjfIsNull() {
            addCriterion("kxfx_qtzjf is null");
            return (Criteria) this;
        }

        public Criteria andKxfxQtzjfIsNotNull() {
            addCriterion("kxfx_qtzjf is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxQtzjfEqualTo(BigDecimal value) {
            addCriterion("kxfx_qtzjf =", value, "kxfxQtzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxQtzjfNotEqualTo(BigDecimal value) {
            addCriterion("kxfx_qtzjf <>", value, "kxfxQtzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxQtzjfGreaterThan(BigDecimal value) {
            addCriterion("kxfx_qtzjf >", value, "kxfxQtzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxQtzjfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_qtzjf >=", value, "kxfxQtzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxQtzjfLessThan(BigDecimal value) {
            addCriterion("kxfx_qtzjf <", value, "kxfxQtzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxQtzjfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_qtzjf <=", value, "kxfxQtzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxQtzjfIn(List<BigDecimal> values) {
            addCriterion("kxfx_qtzjf in", values, "kxfxQtzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxQtzjfNotIn(List<BigDecimal> values) {
            addCriterion("kxfx_qtzjf not in", values, "kxfxQtzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxQtzjfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_qtzjf between", value1, value2, "kxfxQtzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxQtzjfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_qtzjf not between", value1, value2, "kxfxQtzjf");
            return (Criteria) this;
        }

        public Criteria andKxfxRyglfIsNull() {
            addCriterion("kxfx_ryglf is null");
            return (Criteria) this;
        }

        public Criteria andKxfxRyglfIsNotNull() {
            addCriterion("kxfx_ryglf is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxRyglfEqualTo(BigDecimal value) {
            addCriterion("kxfx_ryglf =", value, "kxfxRyglf");
            return (Criteria) this;
        }

        public Criteria andKxfxRyglfNotEqualTo(BigDecimal value) {
            addCriterion("kxfx_ryglf <>", value, "kxfxRyglf");
            return (Criteria) this;
        }

        public Criteria andKxfxRyglfGreaterThan(BigDecimal value) {
            addCriterion("kxfx_ryglf >", value, "kxfxRyglf");
            return (Criteria) this;
        }

        public Criteria andKxfxRyglfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_ryglf >=", value, "kxfxRyglf");
            return (Criteria) this;
        }

        public Criteria andKxfxRyglfLessThan(BigDecimal value) {
            addCriterion("kxfx_ryglf <", value, "kxfxRyglf");
            return (Criteria) this;
        }

        public Criteria andKxfxRyglfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_ryglf <=", value, "kxfxRyglf");
            return (Criteria) this;
        }

        public Criteria andKxfxRyglfIn(List<BigDecimal> values) {
            addCriterion("kxfx_ryglf in", values, "kxfxRyglf");
            return (Criteria) this;
        }

        public Criteria andKxfxRyglfNotIn(List<BigDecimal> values) {
            addCriterion("kxfx_ryglf not in", values, "kxfxRyglf");
            return (Criteria) this;
        }

        public Criteria andKxfxRyglfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_ryglf between", value1, value2, "kxfxRyglf");
            return (Criteria) this;
        }

        public Criteria andKxfxRyglfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_ryglf not between", value1, value2, "kxfxRyglf");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqsqIsNull() {
            addCriterion("kxfx_hbqsq is null");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqsqIsNotNull() {
            addCriterion("kxfx_hbqsq is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqsqEqualTo(Date value) {
            addCriterion("kxfx_hbqsq =", value, "kxfxHbqsq");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqsqNotEqualTo(Date value) {
            addCriterion("kxfx_hbqsq <>", value, "kxfxHbqsq");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqsqGreaterThan(Date value) {
            addCriterion("kxfx_hbqsq >", value, "kxfxHbqsq");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqsqGreaterThanOrEqualTo(Date value) {
            addCriterion("kxfx_hbqsq >=", value, "kxfxHbqsq");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqsqLessThan(Date value) {
            addCriterion("kxfx_hbqsq <", value, "kxfxHbqsq");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqsqLessThanOrEqualTo(Date value) {
            addCriterion("kxfx_hbqsq <=", value, "kxfxHbqsq");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqsqIn(List<Date> values) {
            addCriterion("kxfx_hbqsq in", values, "kxfxHbqsq");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqsqNotIn(List<Date> values) {
            addCriterion("kxfx_hbqsq not in", values, "kxfxHbqsq");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqsqBetween(Date value1, Date value2) {
            addCriterion("kxfx_hbqsq between", value1, value2, "kxfxHbqsq");
            return (Criteria) this;
        }

        public Criteria andKxfxHbqsqNotBetween(Date value1, Date value2) {
            addCriterion("kxfx_hbqsq not between", value1, value2, "kxfxHbqsq");
            return (Criteria) this;
        }

        public Criteria andKxfxHbzysIsNull() {
            addCriterion("kxfx_hbzys is null");
            return (Criteria) this;
        }

        public Criteria andKxfxHbzysIsNotNull() {
            addCriterion("kxfx_hbzys is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxHbzysEqualTo(Integer value) {
            addCriterion("kxfx_hbzys =", value, "kxfxHbzys");
            return (Criteria) this;
        }

        public Criteria andKxfxHbzysNotEqualTo(Integer value) {
            addCriterion("kxfx_hbzys <>", value, "kxfxHbzys");
            return (Criteria) this;
        }

        public Criteria andKxfxHbzysGreaterThan(Integer value) {
            addCriterion("kxfx_hbzys >", value, "kxfxHbzys");
            return (Criteria) this;
        }

        public Criteria andKxfxHbzysGreaterThanOrEqualTo(Integer value) {
            addCriterion("kxfx_hbzys >=", value, "kxfxHbzys");
            return (Criteria) this;
        }

        public Criteria andKxfxHbzysLessThan(Integer value) {
            addCriterion("kxfx_hbzys <", value, "kxfxHbzys");
            return (Criteria) this;
        }

        public Criteria andKxfxHbzysLessThanOrEqualTo(Integer value) {
            addCriterion("kxfx_hbzys <=", value, "kxfxHbzys");
            return (Criteria) this;
        }

        public Criteria andKxfxHbzysIn(List<Integer> values) {
            addCriterion("kxfx_hbzys in", values, "kxfxHbzys");
            return (Criteria) this;
        }

        public Criteria andKxfxHbzysNotIn(List<Integer> values) {
            addCriterion("kxfx_hbzys not in", values, "kxfxHbzys");
            return (Criteria) this;
        }

        public Criteria andKxfxHbzysBetween(Integer value1, Integer value2) {
            addCriterion("kxfx_hbzys between", value1, value2, "kxfxHbzys");
            return (Criteria) this;
        }

        public Criteria andKxfxHbzysNotBetween(Integer value1, Integer value2) {
            addCriterion("kxfx_hbzys not between", value1, value2, "kxfxHbzys");
            return (Criteria) this;
        }

        public Criteria andKxfxMyhbIsNull() {
            addCriterion("kxfx_myhb is null");
            return (Criteria) this;
        }

        public Criteria andKxfxMyhbIsNotNull() {
            addCriterion("kxfx_myhb is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxMyhbEqualTo(BigDecimal value) {
            addCriterion("kxfx_myhb =", value, "kxfxMyhb");
            return (Criteria) this;
        }

        public Criteria andKxfxMyhbNotEqualTo(BigDecimal value) {
            addCriterion("kxfx_myhb <>", value, "kxfxMyhb");
            return (Criteria) this;
        }

        public Criteria andKxfxMyhbGreaterThan(BigDecimal value) {
            addCriterion("kxfx_myhb >", value, "kxfxMyhb");
            return (Criteria) this;
        }

        public Criteria andKxfxMyhbGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_myhb >=", value, "kxfxMyhb");
            return (Criteria) this;
        }

        public Criteria andKxfxMyhbLessThan(BigDecimal value) {
            addCriterion("kxfx_myhb <", value, "kxfxMyhb");
            return (Criteria) this;
        }

        public Criteria andKxfxMyhbLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_myhb <=", value, "kxfxMyhb");
            return (Criteria) this;
        }

        public Criteria andKxfxMyhbIn(List<BigDecimal> values) {
            addCriterion("kxfx_myhb in", values, "kxfxMyhb");
            return (Criteria) this;
        }

        public Criteria andKxfxMyhbNotIn(List<BigDecimal> values) {
            addCriterion("kxfx_myhb not in", values, "kxfxMyhb");
            return (Criteria) this;
        }

        public Criteria andKxfxMyhbBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_myhb between", value1, value2, "kxfxMyhb");
            return (Criteria) this;
        }

        public Criteria andKxfxMyhbNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_myhb not between", value1, value2, "kxfxMyhb");
            return (Criteria) this;
        }

        public Criteria andKxfxXhbzeIsNull() {
            addCriterion("kxfx_xhbze is null");
            return (Criteria) this;
        }

        public Criteria andKxfxXhbzeIsNotNull() {
            addCriterion("kxfx_xhbze is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxXhbzeEqualTo(BigDecimal value) {
            addCriterion("kxfx_xhbze =", value, "kxfxXhbze");
            return (Criteria) this;
        }

        public Criteria andKxfxXhbzeNotEqualTo(BigDecimal value) {
            addCriterion("kxfx_xhbze <>", value, "kxfxXhbze");
            return (Criteria) this;
        }

        public Criteria andKxfxXhbzeGreaterThan(BigDecimal value) {
            addCriterion("kxfx_xhbze >", value, "kxfxXhbze");
            return (Criteria) this;
        }

        public Criteria andKxfxXhbzeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_xhbze >=", value, "kxfxXhbze");
            return (Criteria) this;
        }

        public Criteria andKxfxXhbzeLessThan(BigDecimal value) {
            addCriterion("kxfx_xhbze <", value, "kxfxXhbze");
            return (Criteria) this;
        }

        public Criteria andKxfxXhbzeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("kxfx_xhbze <=", value, "kxfxXhbze");
            return (Criteria) this;
        }

        public Criteria andKxfxXhbzeIn(List<BigDecimal> values) {
            addCriterion("kxfx_xhbze in", values, "kxfxXhbze");
            return (Criteria) this;
        }

        public Criteria andKxfxXhbzeNotIn(List<BigDecimal> values) {
            addCriterion("kxfx_xhbze not in", values, "kxfxXhbze");
            return (Criteria) this;
        }

        public Criteria andKxfxXhbzeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_xhbze between", value1, value2, "kxfxXhbze");
            return (Criteria) this;
        }

        public Criteria andKxfxXhbzeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("kxfx_xhbze not between", value1, value2, "kxfxXhbze");
            return (Criteria) this;
        }

        public Criteria andKxfxKsfzrIsNull() {
            addCriterion("kxfx_ksfzr is null");
            return (Criteria) this;
        }

        public Criteria andKxfxKsfzrIsNotNull() {
            addCriterion("kxfx_ksfzr is not null");
            return (Criteria) this;
        }

        public Criteria andKxfxKsfzrEqualTo(String value) {
            addCriterion("kxfx_ksfzr =", value, "kxfxKsfzr");
            return (Criteria) this;
        }

        public Criteria andKxfxKsfzrNotEqualTo(String value) {
            addCriterion("kxfx_ksfzr <>", value, "kxfxKsfzr");
            return (Criteria) this;
        }

        public Criteria andKxfxKsfzrGreaterThan(String value) {
            addCriterion("kxfx_ksfzr >", value, "kxfxKsfzr");
            return (Criteria) this;
        }

        public Criteria andKxfxKsfzrGreaterThanOrEqualTo(String value) {
            addCriterion("kxfx_ksfzr >=", value, "kxfxKsfzr");
            return (Criteria) this;
        }

        public Criteria andKxfxKsfzrLessThan(String value) {
            addCriterion("kxfx_ksfzr <", value, "kxfxKsfzr");
            return (Criteria) this;
        }

        public Criteria andKxfxKsfzrLessThanOrEqualTo(String value) {
            addCriterion("kxfx_ksfzr <=", value, "kxfxKsfzr");
            return (Criteria) this;
        }

        public Criteria andKxfxKsfzrLike(String value) {
            addCriterion("kxfx_ksfzr like", value, "kxfxKsfzr");
            return (Criteria) this;
        }

        public Criteria andKxfxKsfzrNotLike(String value) {
            addCriterion("kxfx_ksfzr not like", value, "kxfxKsfzr");
            return (Criteria) this;
        }

        public Criteria andKxfxKsfzrIn(List<String> values) {
            addCriterion("kxfx_ksfzr in", values, "kxfxKsfzr");
            return (Criteria) this;
        }

        public Criteria andKxfxKsfzrNotIn(List<String> values) {
            addCriterion("kxfx_ksfzr not in", values, "kxfxKsfzr");
            return (Criteria) this;
        }

        public Criteria andKxfxKsfzrBetween(String value1, String value2) {
            addCriterion("kxfx_ksfzr between", value1, value2, "kxfxKsfzr");
            return (Criteria) this;
        }

        public Criteria andKxfxKsfzrNotBetween(String value1, String value2) {
            addCriterion("kxfx_ksfzr not between", value1, value2, "kxfxKsfzr");
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