package com.litbo.hospital.lifemanage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SgZbwyhhyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SgZbwyhhyExample() {
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

        public Criteria andZbwyhhyNdIsNull() {
            addCriterion("zbwyhhy_nd is null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyNdIsNotNull() {
            addCriterion("zbwyhhy_nd is not null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyNdEqualTo(String value) {
            addCriterion("zbwyhhy_nd =", value, "zbwyhhyNd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyNdNotEqualTo(String value) {
            addCriterion("zbwyhhy_nd <>", value, "zbwyhhyNd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyNdGreaterThan(String value) {
            addCriterion("zbwyhhy_nd >", value, "zbwyhhyNd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyNdGreaterThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_nd >=", value, "zbwyhhyNd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyNdLessThan(String value) {
            addCriterion("zbwyhhy_nd <", value, "zbwyhhyNd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyNdLessThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_nd <=", value, "zbwyhhyNd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyNdLike(String value) {
            addCriterion("zbwyhhy_nd like", value, "zbwyhhyNd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyNdNotLike(String value) {
            addCriterion("zbwyhhy_nd not like", value, "zbwyhhyNd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyNdIn(List<String> values) {
            addCriterion("zbwyhhy_nd in", values, "zbwyhhyNd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyNdNotIn(List<String> values) {
            addCriterion("zbwyhhy_nd not in", values, "zbwyhhyNd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyNdBetween(String value1, String value2) {
            addCriterion("zbwyhhy_nd between", value1, value2, "zbwyhhyNd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyNdNotBetween(String value1, String value2) {
            addCriterion("zbwyhhy_nd not between", value1, value2, "zbwyhhyNd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyChryIsNull() {
            addCriterion("zbwyhhy_chry is null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyChryIsNotNull() {
            addCriterion("zbwyhhy_chry is not null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyChryEqualTo(String value) {
            addCriterion("zbwyhhy_chry =", value, "zbwyhhyChry");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyChryNotEqualTo(String value) {
            addCriterion("zbwyhhy_chry <>", value, "zbwyhhyChry");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyChryGreaterThan(String value) {
            addCriterion("zbwyhhy_chry >", value, "zbwyhhyChry");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyChryGreaterThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_chry >=", value, "zbwyhhyChry");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyChryLessThan(String value) {
            addCriterion("zbwyhhy_chry <", value, "zbwyhhyChry");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyChryLessThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_chry <=", value, "zbwyhhyChry");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyChryLike(String value) {
            addCriterion("zbwyhhy_chry like", value, "zbwyhhyChry");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyChryNotLike(String value) {
            addCriterion("zbwyhhy_chry not like", value, "zbwyhhyChry");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyChryIn(List<String> values) {
            addCriterion("zbwyhhy_chry in", values, "zbwyhhyChry");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyChryNotIn(List<String> values) {
            addCriterion("zbwyhhy_chry not in", values, "zbwyhhyChry");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyChryBetween(String value1, String value2) {
            addCriterion("zbwyhhy_chry between", value1, value2, "zbwyhhyChry");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyChryNotBetween(String value1, String value2) {
            addCriterion("zbwyhhy_chry not between", value1, value2, "zbwyhhyChry");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldIsNull() {
            addCriterion("zbwyhhy_fgld is null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldIsNotNull() {
            addCriterion("zbwyhhy_fgld is not null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldEqualTo(String value) {
            addCriterion("zbwyhhy_fgld =", value, "zbwyhhyFgld");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldNotEqualTo(String value) {
            addCriterion("zbwyhhy_fgld <>", value, "zbwyhhyFgld");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldGreaterThan(String value) {
            addCriterion("zbwyhhy_fgld >", value, "zbwyhhyFgld");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldGreaterThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_fgld >=", value, "zbwyhhyFgld");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldLessThan(String value) {
            addCriterion("zbwyhhy_fgld <", value, "zbwyhhyFgld");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldLessThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_fgld <=", value, "zbwyhhyFgld");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldLike(String value) {
            addCriterion("zbwyhhy_fgld like", value, "zbwyhhyFgld");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldNotLike(String value) {
            addCriterion("zbwyhhy_fgld not like", value, "zbwyhhyFgld");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldIn(List<String> values) {
            addCriterion("zbwyhhy_fgld in", values, "zbwyhhyFgld");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldNotIn(List<String> values) {
            addCriterion("zbwyhhy_fgld not in", values, "zbwyhhyFgld");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldBetween(String value1, String value2) {
            addCriterion("zbwyhhy_fgld between", value1, value2, "zbwyhhyFgld");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldNotBetween(String value1, String value2) {
            addCriterion("zbwyhhy_fgld not between", value1, value2, "zbwyhhyFgld");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldyjIsNull() {
            addCriterion("zbwyhhy_fgldyj is null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldyjIsNotNull() {
            addCriterion("zbwyhhy_fgldyj is not null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldyjEqualTo(String value) {
            addCriterion("zbwyhhy_fgldyj =", value, "zbwyhhyFgldyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldyjNotEqualTo(String value) {
            addCriterion("zbwyhhy_fgldyj <>", value, "zbwyhhyFgldyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldyjGreaterThan(String value) {
            addCriterion("zbwyhhy_fgldyj >", value, "zbwyhhyFgldyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldyjGreaterThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_fgldyj >=", value, "zbwyhhyFgldyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldyjLessThan(String value) {
            addCriterion("zbwyhhy_fgldyj <", value, "zbwyhhyFgldyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldyjLessThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_fgldyj <=", value, "zbwyhhyFgldyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldyjLike(String value) {
            addCriterion("zbwyhhy_fgldyj like", value, "zbwyhhyFgldyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldyjNotLike(String value) {
            addCriterion("zbwyhhy_fgldyj not like", value, "zbwyhhyFgldyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldyjIn(List<String> values) {
            addCriterion("zbwyhhy_fgldyj in", values, "zbwyhhyFgldyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldyjNotIn(List<String> values) {
            addCriterion("zbwyhhy_fgldyj not in", values, "zbwyhhyFgldyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldyjBetween(String value1, String value2) {
            addCriterion("zbwyhhy_fgldyj between", value1, value2, "zbwyhhyFgldyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyFgldyjNotBetween(String value1, String value2) {
            addCriterion("zbwyhhy_fgldyj not between", value1, value2, "zbwyhhyFgldyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhySjIsNull() {
            addCriterion("zbwyhhy_sj is null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhySjIsNotNull() {
            addCriterion("zbwyhhy_sj is not null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhySjEqualTo(Date value) {
            addCriterion("zbwyhhy_sj =", value, "zbwyhhySj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhySjNotEqualTo(Date value) {
            addCriterion("zbwyhhy_sj <>", value, "zbwyhhySj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhySjGreaterThan(Date value) {
            addCriterion("zbwyhhy_sj >", value, "zbwyhhySj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhySjGreaterThanOrEqualTo(Date value) {
            addCriterion("zbwyhhy_sj >=", value, "zbwyhhySj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhySjLessThan(Date value) {
            addCriterion("zbwyhhy_sj <", value, "zbwyhhySj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhySjLessThanOrEqualTo(Date value) {
            addCriterion("zbwyhhy_sj <=", value, "zbwyhhySj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhySjIn(List<Date> values) {
            addCriterion("zbwyhhy_sj in", values, "zbwyhhySj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhySjNotIn(List<Date> values) {
            addCriterion("zbwyhhy_sj not in", values, "zbwyhhySj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhySjBetween(Date value1, Date value2) {
            addCriterion("zbwyhhy_sj between", value1, value2, "zbwyhhySj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhySjNotBetween(Date value1, Date value2) {
            addCriterion("zbwyhhy_sj not between", value1, value2, "zbwyhhySj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyDdIsNull() {
            addCriterion("zbwyhhy_dd is null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyDdIsNotNull() {
            addCriterion("zbwyhhy_dd is not null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyDdEqualTo(String value) {
            addCriterion("zbwyhhy_dd =", value, "zbwyhhyDd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyDdNotEqualTo(String value) {
            addCriterion("zbwyhhy_dd <>", value, "zbwyhhyDd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyDdGreaterThan(String value) {
            addCriterion("zbwyhhy_dd >", value, "zbwyhhyDd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyDdGreaterThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_dd >=", value, "zbwyhhyDd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyDdLessThan(String value) {
            addCriterion("zbwyhhy_dd <", value, "zbwyhhyDd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyDdLessThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_dd <=", value, "zbwyhhyDd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyDdLike(String value) {
            addCriterion("zbwyhhy_dd like", value, "zbwyhhyDd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyDdNotLike(String value) {
            addCriterion("zbwyhhy_dd not like", value, "zbwyhhyDd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyDdIn(List<String> values) {
            addCriterion("zbwyhhy_dd in", values, "zbwyhhyDd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyDdNotIn(List<String> values) {
            addCriterion("zbwyhhy_dd not in", values, "zbwyhhyDd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyDdBetween(String value1, String value2) {
            addCriterion("zbwyhhy_dd between", value1, value2, "zbwyhhyDd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyDdNotBetween(String value1, String value2) {
            addCriterion("zbwyhhy_dd not between", value1, value2, "zbwyhhyDd");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmIsNull() {
            addCriterion("zbwyhhy_zgbm is null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmIsNotNull() {
            addCriterion("zbwyhhy_zgbm is not null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmEqualTo(String value) {
            addCriterion("zbwyhhy_zgbm =", value, "zbwyhhyZgbm");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmNotEqualTo(String value) {
            addCriterion("zbwyhhy_zgbm <>", value, "zbwyhhyZgbm");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmGreaterThan(String value) {
            addCriterion("zbwyhhy_zgbm >", value, "zbwyhhyZgbm");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmGreaterThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_zgbm >=", value, "zbwyhhyZgbm");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmLessThan(String value) {
            addCriterion("zbwyhhy_zgbm <", value, "zbwyhhyZgbm");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmLessThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_zgbm <=", value, "zbwyhhyZgbm");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmLike(String value) {
            addCriterion("zbwyhhy_zgbm like", value, "zbwyhhyZgbm");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmNotLike(String value) {
            addCriterion("zbwyhhy_zgbm not like", value, "zbwyhhyZgbm");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmIn(List<String> values) {
            addCriterion("zbwyhhy_zgbm in", values, "zbwyhhyZgbm");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmNotIn(List<String> values) {
            addCriterion("zbwyhhy_zgbm not in", values, "zbwyhhyZgbm");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmBetween(String value1, String value2) {
            addCriterion("zbwyhhy_zgbm between", value1, value2, "zbwyhhyZgbm");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmNotBetween(String value1, String value2) {
            addCriterion("zbwyhhy_zgbm not between", value1, value2, "zbwyhhyZgbm");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmyjIsNull() {
            addCriterion("zbwyhhy_zgbmyj is null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmyjIsNotNull() {
            addCriterion("zbwyhhy_zgbmyj is not null");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmyjEqualTo(String value) {
            addCriterion("zbwyhhy_zgbmyj =", value, "zbwyhhyZgbmyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmyjNotEqualTo(String value) {
            addCriterion("zbwyhhy_zgbmyj <>", value, "zbwyhhyZgbmyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmyjGreaterThan(String value) {
            addCriterion("zbwyhhy_zgbmyj >", value, "zbwyhhyZgbmyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmyjGreaterThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_zgbmyj >=", value, "zbwyhhyZgbmyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmyjLessThan(String value) {
            addCriterion("zbwyhhy_zgbmyj <", value, "zbwyhhyZgbmyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmyjLessThanOrEqualTo(String value) {
            addCriterion("zbwyhhy_zgbmyj <=", value, "zbwyhhyZgbmyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmyjLike(String value) {
            addCriterion("zbwyhhy_zgbmyj like", value, "zbwyhhyZgbmyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmyjNotLike(String value) {
            addCriterion("zbwyhhy_zgbmyj not like", value, "zbwyhhyZgbmyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmyjIn(List<String> values) {
            addCriterion("zbwyhhy_zgbmyj in", values, "zbwyhhyZgbmyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmyjNotIn(List<String> values) {
            addCriterion("zbwyhhy_zgbmyj not in", values, "zbwyhhyZgbmyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmyjBetween(String value1, String value2) {
            addCriterion("zbwyhhy_zgbmyj between", value1, value2, "zbwyhhyZgbmyj");
            return (Criteria) this;
        }

        public Criteria andZbwyhhyZgbmyjNotBetween(String value1, String value2) {
            addCriterion("zbwyhhy_zgbmyj not between", value1, value2, "zbwyhhyZgbmyj");
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