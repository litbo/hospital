package com.litbo.hospital.security.specialequipment.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SpecialEquipmentRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpecialEquipmentRecordExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSpeqJglridIsNull() {
            addCriterion("speq_jglrid is null");
            return (Criteria) this;
        }

        public Criteria andSpeqJglridIsNotNull() {
            addCriterion("speq_jglrid is not null");
            return (Criteria) this;
        }

        public Criteria andSpeqJglridEqualTo(String value) {
            addCriterion("speq_jglrid =", value, "speqJglrid");
            return (Criteria) this;
        }

        public Criteria andSpeqJglridNotEqualTo(String value) {
            addCriterion("speq_jglrid <>", value, "speqJglrid");
            return (Criteria) this;
        }

        public Criteria andSpeqJglridGreaterThan(String value) {
            addCriterion("speq_jglrid >", value, "speqJglrid");
            return (Criteria) this;
        }

        public Criteria andSpeqJglridGreaterThanOrEqualTo(String value) {
            addCriterion("speq_jglrid >=", value, "speqJglrid");
            return (Criteria) this;
        }

        public Criteria andSpeqJglridLessThan(String value) {
            addCriterion("speq_jglrid <", value, "speqJglrid");
            return (Criteria) this;
        }

        public Criteria andSpeqJglridLessThanOrEqualTo(String value) {
            addCriterion("speq_jglrid <=", value, "speqJglrid");
            return (Criteria) this;
        }

        public Criteria andSpeqJglridLike(String value) {
            addCriterion("speq_jglrid like", value, "speqJglrid");
            return (Criteria) this;
        }

        public Criteria andSpeqJglridNotLike(String value) {
            addCriterion("speq_jglrid not like", value, "speqJglrid");
            return (Criteria) this;
        }

        public Criteria andSpeqJglridIn(List<String> values) {
            addCriterion("speq_jglrid in", values, "speqJglrid");
            return (Criteria) this;
        }

        public Criteria andSpeqJglridNotIn(List<String> values) {
            addCriterion("speq_jglrid not in", values, "speqJglrid");
            return (Criteria) this;
        }

        public Criteria andSpeqJglridBetween(String value1, String value2) {
            addCriterion("speq_jglrid between", value1, value2, "speqJglrid");
            return (Criteria) this;
        }

        public Criteria andSpeqJglridNotBetween(String value1, String value2) {
            addCriterion("speq_jglrid not between", value1, value2, "speqJglrid");
            return (Criteria) this;
        }

        public Criteria andSpeqIdIsNull() {
            addCriterion("speq_id is null");
            return (Criteria) this;
        }

        public Criteria andSpeqIdIsNotNull() {
            addCriterion("speq_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpeqIdEqualTo(String value) {
            addCriterion("speq_id =", value, "speqId");
            return (Criteria) this;
        }

        public Criteria andSpeqIdNotEqualTo(String value) {
            addCriterion("speq_id <>", value, "speqId");
            return (Criteria) this;
        }

        public Criteria andSpeqIdGreaterThan(String value) {
            addCriterion("speq_id >", value, "speqId");
            return (Criteria) this;
        }

        public Criteria andSpeqIdGreaterThanOrEqualTo(String value) {
            addCriterion("speq_id >=", value, "speqId");
            return (Criteria) this;
        }

        public Criteria andSpeqIdLessThan(String value) {
            addCriterion("speq_id <", value, "speqId");
            return (Criteria) this;
        }

        public Criteria andSpeqIdLessThanOrEqualTo(String value) {
            addCriterion("speq_id <=", value, "speqId");
            return (Criteria) this;
        }

        public Criteria andSpeqIdLike(String value) {
            addCriterion("speq_id like", value, "speqId");
            return (Criteria) this;
        }

        public Criteria andSpeqIdNotLike(String value) {
            addCriterion("speq_id not like", value, "speqId");
            return (Criteria) this;
        }

        public Criteria andSpeqIdIn(List<String> values) {
            addCriterion("speq_id in", values, "speqId");
            return (Criteria) this;
        }

        public Criteria andSpeqIdNotIn(List<String> values) {
            addCriterion("speq_id not in", values, "speqId");
            return (Criteria) this;
        }

        public Criteria andSpeqIdBetween(String value1, String value2) {
            addCriterion("speq_id between", value1, value2, "speqId");
            return (Criteria) this;
        }

        public Criteria andSpeqIdNotBetween(String value1, String value2) {
            addCriterion("speq_id not between", value1, value2, "speqId");
            return (Criteria) this;
        }

        public Criteria andSpeqJczbhIsNull() {
            addCriterion("speq_jczbh is null");
            return (Criteria) this;
        }

        public Criteria andSpeqJczbhIsNotNull() {
            addCriterion("speq_jczbh is not null");
            return (Criteria) this;
        }

        public Criteria andSpeqJczbhEqualTo(String value) {
            addCriterion("speq_jczbh =", value, "speqJczbh");
            return (Criteria) this;
        }

        public Criteria andSpeqJczbhNotEqualTo(String value) {
            addCriterion("speq_jczbh <>", value, "speqJczbh");
            return (Criteria) this;
        }

        public Criteria andSpeqJczbhGreaterThan(String value) {
            addCriterion("speq_jczbh >", value, "speqJczbh");
            return (Criteria) this;
        }

        public Criteria andSpeqJczbhGreaterThanOrEqualTo(String value) {
            addCriterion("speq_jczbh >=", value, "speqJczbh");
            return (Criteria) this;
        }

        public Criteria andSpeqJczbhLessThan(String value) {
            addCriterion("speq_jczbh <", value, "speqJczbh");
            return (Criteria) this;
        }

        public Criteria andSpeqJczbhLessThanOrEqualTo(String value) {
            addCriterion("speq_jczbh <=", value, "speqJczbh");
            return (Criteria) this;
        }

        public Criteria andSpeqJczbhLike(String value) {
            addCriterion("speq_jczbh like", value, "speqJczbh");
            return (Criteria) this;
        }

        public Criteria andSpeqJczbhNotLike(String value) {
            addCriterion("speq_jczbh not like", value, "speqJczbh");
            return (Criteria) this;
        }

        public Criteria andSpeqJczbhIn(List<String> values) {
            addCriterion("speq_jczbh in", values, "speqJczbh");
            return (Criteria) this;
        }

        public Criteria andSpeqJczbhNotIn(List<String> values) {
            addCriterion("speq_jczbh not in", values, "speqJczbh");
            return (Criteria) this;
        }

        public Criteria andSpeqJczbhBetween(String value1, String value2) {
            addCriterion("speq_jczbh between", value1, value2, "speqJczbh");
            return (Criteria) this;
        }

        public Criteria andSpeqJczbhNotBetween(String value1, String value2) {
            addCriterion("speq_jczbh not between", value1, value2, "speqJczbh");
            return (Criteria) this;
        }

        public Criteria andSpeqJcsjIsNull() {
            addCriterion("speq_jcsj is null");
            return (Criteria) this;
        }

        public Criteria andSpeqJcsjIsNotNull() {
            addCriterion("speq_jcsj is not null");
            return (Criteria) this;
        }

        public Criteria andSpeqJcsjEqualTo(Date value) {
            addCriterionForJDBCDate("speq_jcsj =", value, "speqJcsj");
            return (Criteria) this;
        }

        public Criteria andSpeqJcsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("speq_jcsj <>", value, "speqJcsj");
            return (Criteria) this;
        }

        public Criteria andSpeqJcsjGreaterThan(Date value) {
            addCriterionForJDBCDate("speq_jcsj >", value, "speqJcsj");
            return (Criteria) this;
        }

        public Criteria andSpeqJcsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("speq_jcsj >=", value, "speqJcsj");
            return (Criteria) this;
        }

        public Criteria andSpeqJcsjLessThan(Date value) {
            addCriterionForJDBCDate("speq_jcsj <", value, "speqJcsj");
            return (Criteria) this;
        }

        public Criteria andSpeqJcsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("speq_jcsj <=", value, "speqJcsj");
            return (Criteria) this;
        }

        public Criteria andSpeqJcsjIn(List<Date> values) {
            addCriterionForJDBCDate("speq_jcsj in", values, "speqJcsj");
            return (Criteria) this;
        }

        public Criteria andSpeqJcsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("speq_jcsj not in", values, "speqJcsj");
            return (Criteria) this;
        }

        public Criteria andSpeqJcsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("speq_jcsj between", value1, value2, "speqJcsj");
            return (Criteria) this;
        }

        public Criteria andSpeqJcsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("speq_jcsj not between", value1, value2, "speqJcsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqrIsNull() {
            addCriterion("speq_sjsqr is null");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqrIsNotNull() {
            addCriterion("speq_sjsqr is not null");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqrEqualTo(String value) {
            addCriterion("speq_sjsqr =", value, "speqSjsqr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqrNotEqualTo(String value) {
            addCriterion("speq_sjsqr <>", value, "speqSjsqr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqrGreaterThan(String value) {
            addCriterion("speq_sjsqr >", value, "speqSjsqr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqrGreaterThanOrEqualTo(String value) {
            addCriterion("speq_sjsqr >=", value, "speqSjsqr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqrLessThan(String value) {
            addCriterion("speq_sjsqr <", value, "speqSjsqr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqrLessThanOrEqualTo(String value) {
            addCriterion("speq_sjsqr <=", value, "speqSjsqr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqrLike(String value) {
            addCriterion("speq_sjsqr like", value, "speqSjsqr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqrNotLike(String value) {
            addCriterion("speq_sjsqr not like", value, "speqSjsqr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqrIn(List<String> values) {
            addCriterion("speq_sjsqr in", values, "speqSjsqr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqrNotIn(List<String> values) {
            addCriterion("speq_sjsqr not in", values, "speqSjsqr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqrBetween(String value1, String value2) {
            addCriterion("speq_sjsqr between", value1, value2, "speqSjsqr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqrNotBetween(String value1, String value2) {
            addCriterion("speq_sjsqr not between", value1, value2, "speqSjsqr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqsjIsNull() {
            addCriterion("speq_sjsqsj is null");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqsjIsNotNull() {
            addCriterion("speq_sjsqsj is not null");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqsjEqualTo(Date value) {
            addCriterionForJDBCDate("speq_sjsqsj =", value, "speqSjsqsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("speq_sjsqsj <>", value, "speqSjsqsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqsjGreaterThan(Date value) {
            addCriterionForJDBCDate("speq_sjsqsj >", value, "speqSjsqsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("speq_sjsqsj >=", value, "speqSjsqsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqsjLessThan(Date value) {
            addCriterionForJDBCDate("speq_sjsqsj <", value, "speqSjsqsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("speq_sjsqsj <=", value, "speqSjsqsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqsjIn(List<Date> values) {
            addCriterionForJDBCDate("speq_sjsqsj in", values, "speqSjsqsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("speq_sjsqsj not in", values, "speqSjsqsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("speq_sjsqsj between", value1, value2, "speqSjsqsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsqsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("speq_sjsqsj not between", value1, value2, "speqSjsqsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsprIsNull() {
            addCriterion("speq_sjspr is null");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsprIsNotNull() {
            addCriterion("speq_sjspr is not null");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsprEqualTo(String value) {
            addCriterion("speq_sjspr =", value, "speqSjspr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsprNotEqualTo(String value) {
            addCriterion("speq_sjspr <>", value, "speqSjspr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsprGreaterThan(String value) {
            addCriterion("speq_sjspr >", value, "speqSjspr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsprGreaterThanOrEqualTo(String value) {
            addCriterion("speq_sjspr >=", value, "speqSjspr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsprLessThan(String value) {
            addCriterion("speq_sjspr <", value, "speqSjspr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsprLessThanOrEqualTo(String value) {
            addCriterion("speq_sjspr <=", value, "speqSjspr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsprLike(String value) {
            addCriterion("speq_sjspr like", value, "speqSjspr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsprNotLike(String value) {
            addCriterion("speq_sjspr not like", value, "speqSjspr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsprIn(List<String> values) {
            addCriterion("speq_sjspr in", values, "speqSjspr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsprNotIn(List<String> values) {
            addCriterion("speq_sjspr not in", values, "speqSjspr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsprBetween(String value1, String value2) {
            addCriterion("speq_sjspr between", value1, value2, "speqSjspr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjsprNotBetween(String value1, String value2) {
            addCriterion("speq_sjspr not between", value1, value2, "speqSjspr");
            return (Criteria) this;
        }

        public Criteria andSpeqSjspsjIsNull() {
            addCriterion("speq_sjspsj is null");
            return (Criteria) this;
        }

        public Criteria andSpeqSjspsjIsNotNull() {
            addCriterion("speq_sjspsj is not null");
            return (Criteria) this;
        }

        public Criteria andSpeqSjspsjEqualTo(Date value) {
            addCriterionForJDBCDate("speq_sjspsj =", value, "speqSjspsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjspsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("speq_sjspsj <>", value, "speqSjspsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjspsjGreaterThan(Date value) {
            addCriterionForJDBCDate("speq_sjspsj >", value, "speqSjspsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjspsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("speq_sjspsj >=", value, "speqSjspsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjspsjLessThan(Date value) {
            addCriterionForJDBCDate("speq_sjspsj <", value, "speqSjspsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjspsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("speq_sjspsj <=", value, "speqSjspsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjspsjIn(List<Date> values) {
            addCriterionForJDBCDate("speq_sjspsj in", values, "speqSjspsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjspsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("speq_sjspsj not in", values, "speqSjspsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjspsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("speq_sjspsj between", value1, value2, "speqSjspsj");
            return (Criteria) this;
        }

        public Criteria andSpeqSjspsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("speq_sjspsj not between", value1, value2, "speqSjspsj");
            return (Criteria) this;
        }

        public Criteria andSpeqRunIsNull() {
            addCriterion("speq_run is null");
            return (Criteria) this;
        }

        public Criteria andSpeqRunIsNotNull() {
            addCriterion("speq_run is not null");
            return (Criteria) this;
        }

        public Criteria andSpeqRunEqualTo(Integer value) {
            addCriterion("speq_run =", value, "speqRun");
            return (Criteria) this;
        }

        public Criteria andSpeqRunNotEqualTo(Integer value) {
            addCriterion("speq_run <>", value, "speqRun");
            return (Criteria) this;
        }

        public Criteria andSpeqRunGreaterThan(Integer value) {
            addCriterion("speq_run >", value, "speqRun");
            return (Criteria) this;
        }

        public Criteria andSpeqRunGreaterThanOrEqualTo(Integer value) {
            addCriterion("speq_run >=", value, "speqRun");
            return (Criteria) this;
        }

        public Criteria andSpeqRunLessThan(Integer value) {
            addCriterion("speq_run <", value, "speqRun");
            return (Criteria) this;
        }

        public Criteria andSpeqRunLessThanOrEqualTo(Integer value) {
            addCriterion("speq_run <=", value, "speqRun");
            return (Criteria) this;
        }

        public Criteria andSpeqRunIn(List<Integer> values) {
            addCriterion("speq_run in", values, "speqRun");
            return (Criteria) this;
        }

        public Criteria andSpeqRunNotIn(List<Integer> values) {
            addCriterion("speq_run not in", values, "speqRun");
            return (Criteria) this;
        }

        public Criteria andSpeqRunBetween(Integer value1, Integer value2) {
            addCriterion("speq_run between", value1, value2, "speqRun");
            return (Criteria) this;
        }

        public Criteria andSpeqRunNotBetween(Integer value1, Integer value2) {
            addCriterion("speq_run not between", value1, value2, "speqRun");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare1IsNull() {
            addCriterion("speq_spare1 is null");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare1IsNotNull() {
            addCriterion("speq_spare1 is not null");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare1EqualTo(String value) {
            addCriterion("speq_spare1 =", value, "speqSpare1");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare1NotEqualTo(String value) {
            addCriterion("speq_spare1 <>", value, "speqSpare1");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare1GreaterThan(String value) {
            addCriterion("speq_spare1 >", value, "speqSpare1");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare1GreaterThanOrEqualTo(String value) {
            addCriterion("speq_spare1 >=", value, "speqSpare1");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare1LessThan(String value) {
            addCriterion("speq_spare1 <", value, "speqSpare1");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare1LessThanOrEqualTo(String value) {
            addCriterion("speq_spare1 <=", value, "speqSpare1");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare1Like(String value) {
            addCriterion("speq_spare1 like", value, "speqSpare1");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare1NotLike(String value) {
            addCriterion("speq_spare1 not like", value, "speqSpare1");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare1In(List<String> values) {
            addCriterion("speq_spare1 in", values, "speqSpare1");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare1NotIn(List<String> values) {
            addCriterion("speq_spare1 not in", values, "speqSpare1");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare1Between(String value1, String value2) {
            addCriterion("speq_spare1 between", value1, value2, "speqSpare1");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare1NotBetween(String value1, String value2) {
            addCriterion("speq_spare1 not between", value1, value2, "speqSpare1");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare2IsNull() {
            addCriterion("speq_spare2 is null");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare2IsNotNull() {
            addCriterion("speq_spare2 is not null");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare2EqualTo(String value) {
            addCriterion("speq_spare2 =", value, "speqSpare2");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare2NotEqualTo(String value) {
            addCriterion("speq_spare2 <>", value, "speqSpare2");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare2GreaterThan(String value) {
            addCriterion("speq_spare2 >", value, "speqSpare2");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare2GreaterThanOrEqualTo(String value) {
            addCriterion("speq_spare2 >=", value, "speqSpare2");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare2LessThan(String value) {
            addCriterion("speq_spare2 <", value, "speqSpare2");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare2LessThanOrEqualTo(String value) {
            addCriterion("speq_spare2 <=", value, "speqSpare2");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare2Like(String value) {
            addCriterion("speq_spare2 like", value, "speqSpare2");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare2NotLike(String value) {
            addCriterion("speq_spare2 not like", value, "speqSpare2");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare2In(List<String> values) {
            addCriterion("speq_spare2 in", values, "speqSpare2");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare2NotIn(List<String> values) {
            addCriterion("speq_spare2 not in", values, "speqSpare2");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare2Between(String value1, String value2) {
            addCriterion("speq_spare2 between", value1, value2, "speqSpare2");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare2NotBetween(String value1, String value2) {
            addCriterion("speq_spare2 not between", value1, value2, "speqSpare2");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare3IsNull() {
            addCriterion("speq_spare3 is null");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare3IsNotNull() {
            addCriterion("speq_spare3 is not null");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare3EqualTo(String value) {
            addCriterion("speq_spare3 =", value, "speqSpare3");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare3NotEqualTo(String value) {
            addCriterion("speq_spare3 <>", value, "speqSpare3");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare3GreaterThan(String value) {
            addCriterion("speq_spare3 >", value, "speqSpare3");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare3GreaterThanOrEqualTo(String value) {
            addCriterion("speq_spare3 >=", value, "speqSpare3");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare3LessThan(String value) {
            addCriterion("speq_spare3 <", value, "speqSpare3");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare3LessThanOrEqualTo(String value) {
            addCriterion("speq_spare3 <=", value, "speqSpare3");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare3Like(String value) {
            addCriterion("speq_spare3 like", value, "speqSpare3");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare3NotLike(String value) {
            addCriterion("speq_spare3 not like", value, "speqSpare3");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare3In(List<String> values) {
            addCriterion("speq_spare3 in", values, "speqSpare3");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare3NotIn(List<String> values) {
            addCriterion("speq_spare3 not in", values, "speqSpare3");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare3Between(String value1, String value2) {
            addCriterion("speq_spare3 between", value1, value2, "speqSpare3");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare3NotBetween(String value1, String value2) {
            addCriterion("speq_spare3 not between", value1, value2, "speqSpare3");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare4IsNull() {
            addCriterion("speq_spare4 is null");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare4IsNotNull() {
            addCriterion("speq_spare4 is not null");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare4EqualTo(String value) {
            addCriterion("speq_spare4 =", value, "speqSpare4");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare4NotEqualTo(String value) {
            addCriterion("speq_spare4 <>", value, "speqSpare4");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare4GreaterThan(String value) {
            addCriterion("speq_spare4 >", value, "speqSpare4");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare4GreaterThanOrEqualTo(String value) {
            addCriterion("speq_spare4 >=", value, "speqSpare4");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare4LessThan(String value) {
            addCriterion("speq_spare4 <", value, "speqSpare4");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare4LessThanOrEqualTo(String value) {
            addCriterion("speq_spare4 <=", value, "speqSpare4");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare4Like(String value) {
            addCriterion("speq_spare4 like", value, "speqSpare4");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare4NotLike(String value) {
            addCriterion("speq_spare4 not like", value, "speqSpare4");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare4In(List<String> values) {
            addCriterion("speq_spare4 in", values, "speqSpare4");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare4NotIn(List<String> values) {
            addCriterion("speq_spare4 not in", values, "speqSpare4");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare4Between(String value1, String value2) {
            addCriterion("speq_spare4 between", value1, value2, "speqSpare4");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare4NotBetween(String value1, String value2) {
            addCriterion("speq_spare4 not between", value1, value2, "speqSpare4");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare5IsNull() {
            addCriterion("speq_spare5 is null");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare5IsNotNull() {
            addCriterion("speq_spare5 is not null");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare5EqualTo(String value) {
            addCriterion("speq_spare5 =", value, "speqSpare5");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare5NotEqualTo(String value) {
            addCriterion("speq_spare5 <>", value, "speqSpare5");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare5GreaterThan(String value) {
            addCriterion("speq_spare5 >", value, "speqSpare5");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare5GreaterThanOrEqualTo(String value) {
            addCriterion("speq_spare5 >=", value, "speqSpare5");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare5LessThan(String value) {
            addCriterion("speq_spare5 <", value, "speqSpare5");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare5LessThanOrEqualTo(String value) {
            addCriterion("speq_spare5 <=", value, "speqSpare5");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare5Like(String value) {
            addCriterion("speq_spare5 like", value, "speqSpare5");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare5NotLike(String value) {
            addCriterion("speq_spare5 not like", value, "speqSpare5");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare5In(List<String> values) {
            addCriterion("speq_spare5 in", values, "speqSpare5");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare5NotIn(List<String> values) {
            addCriterion("speq_spare5 not in", values, "speqSpare5");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare5Between(String value1, String value2) {
            addCriterion("speq_spare5 between", value1, value2, "speqSpare5");
            return (Criteria) this;
        }

        public Criteria andSpeqSpare5NotBetween(String value1, String value2) {
            addCriterion("speq_spare5 not between", value1, value2, "speqSpare5");
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