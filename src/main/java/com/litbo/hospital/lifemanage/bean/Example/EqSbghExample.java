package com.litbo.hospital.lifemanage.bean.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EqSbghExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EqSbghExample() {
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

        public Criteria andEqZbbmIsNull() {
            addCriterion("eq_zbbm is null");
            return (Criteria) this;
        }

        public Criteria andEqZbbmIsNotNull() {
            addCriterion("eq_zbbm is not null");
            return (Criteria) this;
        }

        public Criteria andEqZbbmEqualTo(String value) {
            addCriterion("eq_zbbm =", value, "eqZbbm");
            return (Criteria) this;
        }

        public Criteria andEqZbbmNotEqualTo(String value) {
            addCriterion("eq_zbbm <>", value, "eqZbbm");
            return (Criteria) this;
        }

        public Criteria andEqZbbmGreaterThan(String value) {
            addCriterion("eq_zbbm >", value, "eqZbbm");
            return (Criteria) this;
        }

        public Criteria andEqZbbmGreaterThanOrEqualTo(String value) {
            addCriterion("eq_zbbm >=", value, "eqZbbm");
            return (Criteria) this;
        }

        public Criteria andEqZbbmLessThan(String value) {
            addCriterion("eq_zbbm <", value, "eqZbbm");
            return (Criteria) this;
        }

        public Criteria andEqZbbmLessThanOrEqualTo(String value) {
            addCriterion("eq_zbbm <=", value, "eqZbbm");
            return (Criteria) this;
        }

        public Criteria andEqZbbmLike(String value) {
            addCriterion("eq_zbbm like", value, "eqZbbm");
            return (Criteria) this;
        }

        public Criteria andEqZbbmNotLike(String value) {
            addCriterion("eq_zbbm not like", value, "eqZbbm");
            return (Criteria) this;
        }

        public Criteria andEqZbbmIn(List<String> values) {
            addCriterion("eq_zbbm in", values, "eqZbbm");
            return (Criteria) this;
        }

        public Criteria andEqZbbmNotIn(List<String> values) {
            addCriterion("eq_zbbm not in", values, "eqZbbm");
            return (Criteria) this;
        }

        public Criteria andEqZbbmBetween(String value1, String value2) {
            addCriterion("eq_zbbm between", value1, value2, "eqZbbm");
            return (Criteria) this;
        }

        public Criteria andEqZbbmNotBetween(String value1, String value2) {
            addCriterion("eq_zbbm not between", value1, value2, "eqZbbm");
            return (Criteria) this;
        }

        public Criteria andEqCountIsNull() {
            addCriterion("eq_count is null");
            return (Criteria) this;
        }

        public Criteria andEqCountIsNotNull() {
            addCriterion("eq_count is not null");
            return (Criteria) this;
        }

        public Criteria andEqCountEqualTo(Integer value) {
            addCriterion("eq_count =", value, "eqCount");
            return (Criteria) this;
        }

        public Criteria andEqCountNotEqualTo(Integer value) {
            addCriterion("eq_count <>", value, "eqCount");
            return (Criteria) this;
        }

        public Criteria andEqCountGreaterThan(Integer value) {
            addCriterion("eq_count >", value, "eqCount");
            return (Criteria) this;
        }

        public Criteria andEqCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("eq_count >=", value, "eqCount");
            return (Criteria) this;
        }

        public Criteria andEqCountLessThan(Integer value) {
            addCriterion("eq_count <", value, "eqCount");
            return (Criteria) this;
        }

        public Criteria andEqCountLessThanOrEqualTo(Integer value) {
            addCriterion("eq_count <=", value, "eqCount");
            return (Criteria) this;
        }

        public Criteria andEqCountIn(List<Integer> values) {
            addCriterion("eq_count in", values, "eqCount");
            return (Criteria) this;
        }

        public Criteria andEqCountNotIn(List<Integer> values) {
            addCriterion("eq_count not in", values, "eqCount");
            return (Criteria) this;
        }

        public Criteria andEqCountBetween(Integer value1, Integer value2) {
            addCriterion("eq_count between", value1, value2, "eqCount");
            return (Criteria) this;
        }

        public Criteria andEqCountNotBetween(Integer value1, Integer value2) {
            addCriterion("eq_count not between", value1, value2, "eqCount");
            return (Criteria) this;
        }

        public Criteria andEqGhrqIsNull() {
            addCriterion("eq_ghrq is null");
            return (Criteria) this;
        }

        public Criteria andEqGhrqIsNotNull() {
            addCriterion("eq_ghrq is not null");
            return (Criteria) this;
        }

        public Criteria andEqGhrqEqualTo(Date value) {
            addCriterionForJDBCDate("eq_ghrq =", value, "eqGhrq");
            return (Criteria) this;
        }

        public Criteria andEqGhrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("eq_ghrq <>", value, "eqGhrq");
            return (Criteria) this;
        }

        public Criteria andEqGhrqGreaterThan(Date value) {
            addCriterionForJDBCDate("eq_ghrq >", value, "eqGhrq");
            return (Criteria) this;
        }

        public Criteria andEqGhrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("eq_ghrq >=", value, "eqGhrq");
            return (Criteria) this;
        }

        public Criteria andEqGhrqLessThan(Date value) {
            addCriterionForJDBCDate("eq_ghrq <", value, "eqGhrq");
            return (Criteria) this;
        }

        public Criteria andEqGhrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("eq_ghrq <=", value, "eqGhrq");
            return (Criteria) this;
        }

        public Criteria andEqGhrqIn(List<Date> values) {
            addCriterionForJDBCDate("eq_ghrq in", values, "eqGhrq");
            return (Criteria) this;
        }

        public Criteria andEqGhrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("eq_ghrq not in", values, "eqGhrq");
            return (Criteria) this;
        }

        public Criteria andEqGhrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("eq_ghrq between", value1, value2, "eqGhrq");
            return (Criteria) this;
        }

        public Criteria andEqGhrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("eq_ghrq not between", value1, value2, "eqGhrq");
            return (Criteria) this;
        }

        public Criteria andEqZbjcIsNull() {
            addCriterion("eq_zbjc is null");
            return (Criteria) this;
        }

        public Criteria andEqZbjcIsNotNull() {
            addCriterion("eq_zbjc is not null");
            return (Criteria) this;
        }

        public Criteria andEqZbjcEqualTo(String value) {
            addCriterion("eq_zbjc =", value, "eqZbjc");
            return (Criteria) this;
        }

        public Criteria andEqZbjcNotEqualTo(String value) {
            addCriterion("eq_zbjc <>", value, "eqZbjc");
            return (Criteria) this;
        }

        public Criteria andEqZbjcGreaterThan(String value) {
            addCriterion("eq_zbjc >", value, "eqZbjc");
            return (Criteria) this;
        }

        public Criteria andEqZbjcGreaterThanOrEqualTo(String value) {
            addCriterion("eq_zbjc >=", value, "eqZbjc");
            return (Criteria) this;
        }

        public Criteria andEqZbjcLessThan(String value) {
            addCriterion("eq_zbjc <", value, "eqZbjc");
            return (Criteria) this;
        }

        public Criteria andEqZbjcLessThanOrEqualTo(String value) {
            addCriterion("eq_zbjc <=", value, "eqZbjc");
            return (Criteria) this;
        }

        public Criteria andEqZbjcLike(String value) {
            addCriterion("eq_zbjc like", value, "eqZbjc");
            return (Criteria) this;
        }

        public Criteria andEqZbjcNotLike(String value) {
            addCriterion("eq_zbjc not like", value, "eqZbjc");
            return (Criteria) this;
        }

        public Criteria andEqZbjcIn(List<String> values) {
            addCriterion("eq_zbjc in", values, "eqZbjc");
            return (Criteria) this;
        }

        public Criteria andEqZbjcNotIn(List<String> values) {
            addCriterion("eq_zbjc not in", values, "eqZbjc");
            return (Criteria) this;
        }

        public Criteria andEqZbjcBetween(String value1, String value2) {
            addCriterion("eq_zbjc between", value1, value2, "eqZbjc");
            return (Criteria) this;
        }

        public Criteria andEqZbjcNotBetween(String value1, String value2) {
            addCriterion("eq_zbjc not between", value1, value2, "eqZbjc");
            return (Criteria) this;
        }

        public Criteria andEqGhksIsNull() {
            addCriterion("eq_ghks is null");
            return (Criteria) this;
        }

        public Criteria andEqGhksIsNotNull() {
            addCriterion("eq_ghks is not null");
            return (Criteria) this;
        }

        public Criteria andEqGhksEqualTo(String value) {
            addCriterion("eq_ghks =", value, "eqGhks");
            return (Criteria) this;
        }

        public Criteria andEqGhksNotEqualTo(String value) {
            addCriterion("eq_ghks <>", value, "eqGhks");
            return (Criteria) this;
        }

        public Criteria andEqGhksGreaterThan(String value) {
            addCriterion("eq_ghks >", value, "eqGhks");
            return (Criteria) this;
        }

        public Criteria andEqGhksGreaterThanOrEqualTo(String value) {
            addCriterion("eq_ghks >=", value, "eqGhks");
            return (Criteria) this;
        }

        public Criteria andEqGhksLessThan(String value) {
            addCriterion("eq_ghks <", value, "eqGhks");
            return (Criteria) this;
        }

        public Criteria andEqGhksLessThanOrEqualTo(String value) {
            addCriterion("eq_ghks <=", value, "eqGhks");
            return (Criteria) this;
        }

        public Criteria andEqGhksLike(String value) {
            addCriterion("eq_ghks like", value, "eqGhks");
            return (Criteria) this;
        }

        public Criteria andEqGhksNotLike(String value) {
            addCriterion("eq_ghks not like", value, "eqGhks");
            return (Criteria) this;
        }

        public Criteria andEqGhksIn(List<String> values) {
            addCriterion("eq_ghks in", values, "eqGhks");
            return (Criteria) this;
        }

        public Criteria andEqGhksNotIn(List<String> values) {
            addCriterion("eq_ghks not in", values, "eqGhks");
            return (Criteria) this;
        }

        public Criteria andEqGhksBetween(String value1, String value2) {
            addCriterion("eq_ghks between", value1, value2, "eqGhks");
            return (Criteria) this;
        }

        public Criteria andEqGhksNotBetween(String value1, String value2) {
            addCriterion("eq_ghks not between", value1, value2, "eqGhks");
            return (Criteria) this;
        }

        public Criteria andEqJsksIsNull() {
            addCriterion("eq_jsks is null");
            return (Criteria) this;
        }

        public Criteria andEqJsksIsNotNull() {
            addCriterion("eq_jsks is not null");
            return (Criteria) this;
        }

        public Criteria andEqJsksEqualTo(String value) {
            addCriterion("eq_jsks =", value, "eqJsks");
            return (Criteria) this;
        }

        public Criteria andEqJsksNotEqualTo(String value) {
            addCriterion("eq_jsks <>", value, "eqJsks");
            return (Criteria) this;
        }

        public Criteria andEqJsksGreaterThan(String value) {
            addCriterion("eq_jsks >", value, "eqJsks");
            return (Criteria) this;
        }

        public Criteria andEqJsksGreaterThanOrEqualTo(String value) {
            addCriterion("eq_jsks >=", value, "eqJsks");
            return (Criteria) this;
        }

        public Criteria andEqJsksLessThan(String value) {
            addCriterion("eq_jsks <", value, "eqJsks");
            return (Criteria) this;
        }

        public Criteria andEqJsksLessThanOrEqualTo(String value) {
            addCriterion("eq_jsks <=", value, "eqJsks");
            return (Criteria) this;
        }

        public Criteria andEqJsksLike(String value) {
            addCriterion("eq_jsks like", value, "eqJsks");
            return (Criteria) this;
        }

        public Criteria andEqJsksNotLike(String value) {
            addCriterion("eq_jsks not like", value, "eqJsks");
            return (Criteria) this;
        }

        public Criteria andEqJsksIn(List<String> values) {
            addCriterion("eq_jsks in", values, "eqJsks");
            return (Criteria) this;
        }

        public Criteria andEqJsksNotIn(List<String> values) {
            addCriterion("eq_jsks not in", values, "eqJsks");
            return (Criteria) this;
        }

        public Criteria andEqJsksBetween(String value1, String value2) {
            addCriterion("eq_jsks between", value1, value2, "eqJsks");
            return (Criteria) this;
        }

        public Criteria andEqJsksNotBetween(String value1, String value2) {
            addCriterion("eq_jsks not between", value1, value2, "eqJsks");
            return (Criteria) this;
        }

        public Criteria andEqGhjbrIsNull() {
            addCriterion("eq_ghjbr is null");
            return (Criteria) this;
        }

        public Criteria andEqGhjbrIsNotNull() {
            addCriterion("eq_ghjbr is not null");
            return (Criteria) this;
        }

        public Criteria andEqGhjbrEqualTo(String value) {
            addCriterion("eq_ghjbr =", value, "eqGhjbr");
            return (Criteria) this;
        }

        public Criteria andEqGhjbrNotEqualTo(String value) {
            addCriterion("eq_ghjbr <>", value, "eqGhjbr");
            return (Criteria) this;
        }

        public Criteria andEqGhjbrGreaterThan(String value) {
            addCriterion("eq_ghjbr >", value, "eqGhjbr");
            return (Criteria) this;
        }

        public Criteria andEqGhjbrGreaterThanOrEqualTo(String value) {
            addCriterion("eq_ghjbr >=", value, "eqGhjbr");
            return (Criteria) this;
        }

        public Criteria andEqGhjbrLessThan(String value) {
            addCriterion("eq_ghjbr <", value, "eqGhjbr");
            return (Criteria) this;
        }

        public Criteria andEqGhjbrLessThanOrEqualTo(String value) {
            addCriterion("eq_ghjbr <=", value, "eqGhjbr");
            return (Criteria) this;
        }

        public Criteria andEqGhjbrLike(String value) {
            addCriterion("eq_ghjbr like", value, "eqGhjbr");
            return (Criteria) this;
        }

        public Criteria andEqGhjbrNotLike(String value) {
            addCriterion("eq_ghjbr not like", value, "eqGhjbr");
            return (Criteria) this;
        }

        public Criteria andEqGhjbrIn(List<String> values) {
            addCriterion("eq_ghjbr in", values, "eqGhjbr");
            return (Criteria) this;
        }

        public Criteria andEqGhjbrNotIn(List<String> values) {
            addCriterion("eq_ghjbr not in", values, "eqGhjbr");
            return (Criteria) this;
        }

        public Criteria andEqGhjbrBetween(String value1, String value2) {
            addCriterion("eq_ghjbr between", value1, value2, "eqGhjbr");
            return (Criteria) this;
        }

        public Criteria andEqGhjbrNotBetween(String value1, String value2) {
            addCriterion("eq_ghjbr not between", value1, value2, "eqGhjbr");
            return (Criteria) this;
        }

        public Criteria andEqJsjbrIsNull() {
            addCriterion("eq_jsjbr is null");
            return (Criteria) this;
        }

        public Criteria andEqJsjbrIsNotNull() {
            addCriterion("eq_jsjbr is not null");
            return (Criteria) this;
        }

        public Criteria andEqJsjbrEqualTo(String value) {
            addCriterion("eq_jsjbr =", value, "eqJsjbr");
            return (Criteria) this;
        }

        public Criteria andEqJsjbrNotEqualTo(String value) {
            addCriterion("eq_jsjbr <>", value, "eqJsjbr");
            return (Criteria) this;
        }

        public Criteria andEqJsjbrGreaterThan(String value) {
            addCriterion("eq_jsjbr >", value, "eqJsjbr");
            return (Criteria) this;
        }

        public Criteria andEqJsjbrGreaterThanOrEqualTo(String value) {
            addCriterion("eq_jsjbr >=", value, "eqJsjbr");
            return (Criteria) this;
        }

        public Criteria andEqJsjbrLessThan(String value) {
            addCriterion("eq_jsjbr <", value, "eqJsjbr");
            return (Criteria) this;
        }

        public Criteria andEqJsjbrLessThanOrEqualTo(String value) {
            addCriterion("eq_jsjbr <=", value, "eqJsjbr");
            return (Criteria) this;
        }

        public Criteria andEqJsjbrLike(String value) {
            addCriterion("eq_jsjbr like", value, "eqJsjbr");
            return (Criteria) this;
        }

        public Criteria andEqJsjbrNotLike(String value) {
            addCriterion("eq_jsjbr not like", value, "eqJsjbr");
            return (Criteria) this;
        }

        public Criteria andEqJsjbrIn(List<String> values) {
            addCriterion("eq_jsjbr in", values, "eqJsjbr");
            return (Criteria) this;
        }

        public Criteria andEqJsjbrNotIn(List<String> values) {
            addCriterion("eq_jsjbr not in", values, "eqJsjbr");
            return (Criteria) this;
        }

        public Criteria andEqJsjbrBetween(String value1, String value2) {
            addCriterion("eq_jsjbr between", value1, value2, "eqJsjbr");
            return (Criteria) this;
        }

        public Criteria andEqJsjbrNotBetween(String value1, String value2) {
            addCriterion("eq_jsjbr not between", value1, value2, "eqJsjbr");
            return (Criteria) this;
        }

        public Criteria andEqDpjjidIsNull() {
            addCriterion("eq_dpjjid is null");
            return (Criteria) this;
        }

        public Criteria andEqDpjjidIsNotNull() {
            addCriterion("eq_dpjjid is not null");
            return (Criteria) this;
        }

        public Criteria andEqDpjjidEqualTo(String value) {
            addCriterion("eq_dpjjid =", value, "eqDpjjid");
            return (Criteria) this;
        }

        public Criteria andEqDpjjidNotEqualTo(String value) {
            addCriterion("eq_dpjjid <>", value, "eqDpjjid");
            return (Criteria) this;
        }

        public Criteria andEqDpjjidGreaterThan(String value) {
            addCriterion("eq_dpjjid >", value, "eqDpjjid");
            return (Criteria) this;
        }

        public Criteria andEqDpjjidGreaterThanOrEqualTo(String value) {
            addCriterion("eq_dpjjid >=", value, "eqDpjjid");
            return (Criteria) this;
        }

        public Criteria andEqDpjjidLessThan(String value) {
            addCriterion("eq_dpjjid <", value, "eqDpjjid");
            return (Criteria) this;
        }

        public Criteria andEqDpjjidLessThanOrEqualTo(String value) {
            addCriterion("eq_dpjjid <=", value, "eqDpjjid");
            return (Criteria) this;
        }

        public Criteria andEqDpjjidLike(String value) {
            addCriterion("eq_dpjjid like", value, "eqDpjjid");
            return (Criteria) this;
        }

        public Criteria andEqDpjjidNotLike(String value) {
            addCriterion("eq_dpjjid not like", value, "eqDpjjid");
            return (Criteria) this;
        }

        public Criteria andEqDpjjidIn(List<String> values) {
            addCriterion("eq_dpjjid in", values, "eqDpjjid");
            return (Criteria) this;
        }

        public Criteria andEqDpjjidNotIn(List<String> values) {
            addCriterion("eq_dpjjid not in", values, "eqDpjjid");
            return (Criteria) this;
        }

        public Criteria andEqDpjjidBetween(String value1, String value2) {
            addCriterion("eq_dpjjid between", value1, value2, "eqDpjjid");
            return (Criteria) this;
        }

        public Criteria andEqDpjjidNotBetween(String value1, String value2) {
            addCriterion("eq_dpjjid not between", value1, value2, "eqDpjjid");
            return (Criteria) this;
        }

        public Criteria andEqGhlxIsNull() {
            addCriterion("eq_ghlx is null");
            return (Criteria) this;
        }

        public Criteria andEqGhlxIsNotNull() {
            addCriterion("eq_ghlx is not null");
            return (Criteria) this;
        }

        public Criteria andEqGhlxEqualTo(String value) {
            addCriterion("eq_ghlx =", value, "eqGhlx");
            return (Criteria) this;
        }

        public Criteria andEqGhlxNotEqualTo(String value) {
            addCriterion("eq_ghlx <>", value, "eqGhlx");
            return (Criteria) this;
        }

        public Criteria andEqGhlxGreaterThan(String value) {
            addCriterion("eq_ghlx >", value, "eqGhlx");
            return (Criteria) this;
        }

        public Criteria andEqGhlxGreaterThanOrEqualTo(String value) {
            addCriterion("eq_ghlx >=", value, "eqGhlx");
            return (Criteria) this;
        }

        public Criteria andEqGhlxLessThan(String value) {
            addCriterion("eq_ghlx <", value, "eqGhlx");
            return (Criteria) this;
        }

        public Criteria andEqGhlxLessThanOrEqualTo(String value) {
            addCriterion("eq_ghlx <=", value, "eqGhlx");
            return (Criteria) this;
        }

        public Criteria andEqGhlxLike(String value) {
            addCriterion("eq_ghlx like", value, "eqGhlx");
            return (Criteria) this;
        }

        public Criteria andEqGhlxNotLike(String value) {
            addCriterion("eq_ghlx not like", value, "eqGhlx");
            return (Criteria) this;
        }

        public Criteria andEqGhlxIn(List<String> values) {
            addCriterion("eq_ghlx in", values, "eqGhlx");
            return (Criteria) this;
        }

        public Criteria andEqGhlxNotIn(List<String> values) {
            addCriterion("eq_ghlx not in", values, "eqGhlx");
            return (Criteria) this;
        }

        public Criteria andEqGhlxBetween(String value1, String value2) {
            addCriterion("eq_ghlx between", value1, value2, "eqGhlx");
            return (Criteria) this;
        }

        public Criteria andEqGhlxNotBetween(String value1, String value2) {
            addCriterion("eq_ghlx not between", value1, value2, "eqGhlx");
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