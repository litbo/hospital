package com.litbo.hospital.lifemanage.bean.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EqTjjjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EqTjjjExample() {
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

        public Criteria andTjjjBianmaIsNull() {
            addCriterion("tjjj_bianma is null");
            return (Criteria) this;
        }

        public Criteria andTjjjBianmaIsNotNull() {
            addCriterion("tjjj_bianma is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjBianmaEqualTo(String value) {
            addCriterion("tjjj_bianma =", value, "tjjjBianma");
            return (Criteria) this;
        }

        public Criteria andTjjjBianmaNotEqualTo(String value) {
            addCriterion("tjjj_bianma <>", value, "tjjjBianma");
            return (Criteria) this;
        }

        public Criteria andTjjjBianmaGreaterThan(String value) {
            addCriterion("tjjj_bianma >", value, "tjjjBianma");
            return (Criteria) this;
        }

        public Criteria andTjjjBianmaGreaterThanOrEqualTo(String value) {
            addCriterion("tjjj_bianma >=", value, "tjjjBianma");
            return (Criteria) this;
        }

        public Criteria andTjjjBianmaLessThan(String value) {
            addCriterion("tjjj_bianma <", value, "tjjjBianma");
            return (Criteria) this;
        }

        public Criteria andTjjjBianmaLessThanOrEqualTo(String value) {
            addCriterion("tjjj_bianma <=", value, "tjjjBianma");
            return (Criteria) this;
        }

        public Criteria andTjjjBianmaLike(String value) {
            addCriterion("tjjj_bianma like", value, "tjjjBianma");
            return (Criteria) this;
        }

        public Criteria andTjjjBianmaNotLike(String value) {
            addCriterion("tjjj_bianma not like", value, "tjjjBianma");
            return (Criteria) this;
        }

        public Criteria andTjjjBianmaIn(List<String> values) {
            addCriterion("tjjj_bianma in", values, "tjjjBianma");
            return (Criteria) this;
        }

        public Criteria andTjjjBianmaNotIn(List<String> values) {
            addCriterion("tjjj_bianma not in", values, "tjjjBianma");
            return (Criteria) this;
        }

        public Criteria andTjjjBianmaBetween(String value1, String value2) {
            addCriterion("tjjj_bianma between", value1, value2, "tjjjBianma");
            return (Criteria) this;
        }

        public Criteria andTjjjBianmaNotBetween(String value1, String value2) {
            addCriterion("tjjj_bianma not between", value1, value2, "tjjjBianma");
            return (Criteria) this;
        }

        public Criteria andTjjjCountIsNull() {
            addCriterion("tjjj_count is null");
            return (Criteria) this;
        }

        public Criteria andTjjjCountIsNotNull() {
            addCriterion("tjjj_count is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjCountEqualTo(Integer value) {
            addCriterion("tjjj_count =", value, "tjjjCount");
            return (Criteria) this;
        }

        public Criteria andTjjjCountNotEqualTo(Integer value) {
            addCriterion("tjjj_count <>", value, "tjjjCount");
            return (Criteria) this;
        }

        public Criteria andTjjjCountGreaterThan(Integer value) {
            addCriterion("tjjj_count >", value, "tjjjCount");
            return (Criteria) this;
        }

        public Criteria andTjjjCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("tjjj_count >=", value, "tjjjCount");
            return (Criteria) this;
        }

        public Criteria andTjjjCountLessThan(Integer value) {
            addCriterion("tjjj_count <", value, "tjjjCount");
            return (Criteria) this;
        }

        public Criteria andTjjjCountLessThanOrEqualTo(Integer value) {
            addCriterion("tjjj_count <=", value, "tjjjCount");
            return (Criteria) this;
        }

        public Criteria andTjjjCountIn(List<Integer> values) {
            addCriterion("tjjj_count in", values, "tjjjCount");
            return (Criteria) this;
        }

        public Criteria andTjjjCountNotIn(List<Integer> values) {
            addCriterion("tjjj_count not in", values, "tjjjCount");
            return (Criteria) this;
        }

        public Criteria andTjjjCountBetween(Integer value1, Integer value2) {
            addCriterion("tjjj_count between", value1, value2, "tjjjCount");
            return (Criteria) this;
        }

        public Criteria andTjjjCountNotBetween(Integer value1, Integer value2) {
            addCriterion("tjjj_count not between", value1, value2, "tjjjCount");
            return (Criteria) this;
        }

        public Criteria andTjjjTprqIsNull() {
            addCriterion("tjjj_tprq is null");
            return (Criteria) this;
        }

        public Criteria andTjjjTprqIsNotNull() {
            addCriterion("tjjj_tprq is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjTprqEqualTo(Date value) {
            addCriterionForJDBCDate("tjjj_tprq =", value, "tjjjTprq");
            return (Criteria) this;
        }

        public Criteria andTjjjTprqNotEqualTo(Date value) {
            addCriterionForJDBCDate("tjjj_tprq <>", value, "tjjjTprq");
            return (Criteria) this;
        }

        public Criteria andTjjjTprqGreaterThan(Date value) {
            addCriterionForJDBCDate("tjjj_tprq >", value, "tjjjTprq");
            return (Criteria) this;
        }

        public Criteria andTjjjTprqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tjjj_tprq >=", value, "tjjjTprq");
            return (Criteria) this;
        }

        public Criteria andTjjjTprqLessThan(Date value) {
            addCriterionForJDBCDate("tjjj_tprq <", value, "tjjjTprq");
            return (Criteria) this;
        }

        public Criteria andTjjjTprqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tjjj_tprq <=", value, "tjjjTprq");
            return (Criteria) this;
        }

        public Criteria andTjjjTprqIn(List<Date> values) {
            addCriterionForJDBCDate("tjjj_tprq in", values, "tjjjTprq");
            return (Criteria) this;
        }

        public Criteria andTjjjTprqNotIn(List<Date> values) {
            addCriterionForJDBCDate("tjjj_tprq not in", values, "tjjjTprq");
            return (Criteria) this;
        }

        public Criteria andTjjjTprqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tjjj_tprq between", value1, value2, "tjjjTprq");
            return (Criteria) this;
        }

        public Criteria andTjjjTprqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tjjj_tprq not between", value1, value2, "tjjjTprq");
            return (Criteria) this;
        }

        public Criteria andTjjjTpsjIsNull() {
            addCriterion("tjjj_tpsj is null");
            return (Criteria) this;
        }

        public Criteria andTjjjTpsjIsNotNull() {
            addCriterion("tjjj_tpsj is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjTpsjEqualTo(Date value) {
            addCriterionForJDBCDate("tjjj_tpsj =", value, "tjjjTpsj");
            return (Criteria) this;
        }

        public Criteria andTjjjTpsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("tjjj_tpsj <>", value, "tjjjTpsj");
            return (Criteria) this;
        }

        public Criteria andTjjjTpsjGreaterThan(Date value) {
            addCriterionForJDBCDate("tjjj_tpsj >", value, "tjjjTpsj");
            return (Criteria) this;
        }

        public Criteria andTjjjTpsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tjjj_tpsj >=", value, "tjjjTpsj");
            return (Criteria) this;
        }

        public Criteria andTjjjTpsjLessThan(Date value) {
            addCriterionForJDBCDate("tjjj_tpsj <", value, "tjjjTpsj");
            return (Criteria) this;
        }

        public Criteria andTjjjTpsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tjjj_tpsj <=", value, "tjjjTpsj");
            return (Criteria) this;
        }

        public Criteria andTjjjTpsjIn(List<Date> values) {
            addCriterionForJDBCDate("tjjj_tpsj in", values, "tjjjTpsj");
            return (Criteria) this;
        }

        public Criteria andTjjjTpsjNotIn(List<Date> values) {
            addCriterionForJDBCDate("tjjj_tpsj not in", values, "tjjjTpsj");
            return (Criteria) this;
        }

        public Criteria andTjjjTpsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tjjj_tpsj between", value1, value2, "tjjjTpsj");
            return (Criteria) this;
        }

        public Criteria andTjjjTpsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tjjj_tpsj not between", value1, value2, "tjjjTpsj");
            return (Criteria) this;
        }

        public Criteria andTjjjDpgcIsNull() {
            addCriterion("tjjj_dpgc is null");
            return (Criteria) this;
        }

        public Criteria andTjjjDpgcIsNotNull() {
            addCriterion("tjjj_dpgc is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjDpgcEqualTo(String value) {
            addCriterion("tjjj_dpgc =", value, "tjjjDpgc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpgcNotEqualTo(String value) {
            addCriterion("tjjj_dpgc <>", value, "tjjjDpgc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpgcGreaterThan(String value) {
            addCriterion("tjjj_dpgc >", value, "tjjjDpgc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpgcGreaterThanOrEqualTo(String value) {
            addCriterion("tjjj_dpgc >=", value, "tjjjDpgc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpgcLessThan(String value) {
            addCriterion("tjjj_dpgc <", value, "tjjjDpgc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpgcLessThanOrEqualTo(String value) {
            addCriterion("tjjj_dpgc <=", value, "tjjjDpgc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpgcLike(String value) {
            addCriterion("tjjj_dpgc like", value, "tjjjDpgc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpgcNotLike(String value) {
            addCriterion("tjjj_dpgc not like", value, "tjjjDpgc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpgcIn(List<String> values) {
            addCriterion("tjjj_dpgc in", values, "tjjjDpgc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpgcNotIn(List<String> values) {
            addCriterion("tjjj_dpgc not in", values, "tjjjDpgc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpgcBetween(String value1, String value2) {
            addCriterion("tjjj_dpgc between", value1, value2, "tjjjDpgc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpgcNotBetween(String value1, String value2) {
            addCriterion("tjjj_dpgc not between", value1, value2, "tjjjDpgc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpfztjcIsNull() {
            addCriterion("tjjj_dpfztjc is null");
            return (Criteria) this;
        }

        public Criteria andTjjjDpfztjcIsNotNull() {
            addCriterion("tjjj_dpfztjc is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjDpfztjcEqualTo(String value) {
            addCriterion("tjjj_dpfztjc =", value, "tjjjDpfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpfztjcNotEqualTo(String value) {
            addCriterion("tjjj_dpfztjc <>", value, "tjjjDpfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpfztjcGreaterThan(String value) {
            addCriterion("tjjj_dpfztjc >", value, "tjjjDpfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpfztjcGreaterThanOrEqualTo(String value) {
            addCriterion("tjjj_dpfztjc >=", value, "tjjjDpfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpfztjcLessThan(String value) {
            addCriterion("tjjj_dpfztjc <", value, "tjjjDpfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpfztjcLessThanOrEqualTo(String value) {
            addCriterion("tjjj_dpfztjc <=", value, "tjjjDpfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpfztjcLike(String value) {
            addCriterion("tjjj_dpfztjc like", value, "tjjjDpfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpfztjcNotLike(String value) {
            addCriterion("tjjj_dpfztjc not like", value, "tjjjDpfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpfztjcIn(List<String> values) {
            addCriterion("tjjj_dpfztjc in", values, "tjjjDpfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpfztjcNotIn(List<String> values) {
            addCriterion("tjjj_dpfztjc not in", values, "tjjjDpfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpfztjcBetween(String value1, String value2) {
            addCriterion("tjjj_dpfztjc between", value1, value2, "tjjjDpfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpfztjcNotBetween(String value1, String value2) {
            addCriterion("tjjj_dpfztjc not between", value1, value2, "tjjjDpfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpffjjcIsNull() {
            addCriterion("tjjj_dpffjjc is null");
            return (Criteria) this;
        }

        public Criteria andTjjjDpffjjcIsNotNull() {
            addCriterion("tjjj_dpffjjc is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjDpffjjcEqualTo(String value) {
            addCriterion("tjjj_dpffjjc =", value, "tjjjDpffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpffjjcNotEqualTo(String value) {
            addCriterion("tjjj_dpffjjc <>", value, "tjjjDpffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpffjjcGreaterThan(String value) {
            addCriterion("tjjj_dpffjjc >", value, "tjjjDpffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpffjjcGreaterThanOrEqualTo(String value) {
            addCriterion("tjjj_dpffjjc >=", value, "tjjjDpffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpffjjcLessThan(String value) {
            addCriterion("tjjj_dpffjjc <", value, "tjjjDpffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpffjjcLessThanOrEqualTo(String value) {
            addCriterion("tjjj_dpffjjc <=", value, "tjjjDpffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpffjjcLike(String value) {
            addCriterion("tjjj_dpffjjc like", value, "tjjjDpffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpffjjcNotLike(String value) {
            addCriterion("tjjj_dpffjjc not like", value, "tjjjDpffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpffjjcIn(List<String> values) {
            addCriterion("tjjj_dpffjjc in", values, "tjjjDpffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpffjjcNotIn(List<String> values) {
            addCriterion("tjjj_dpffjjc not in", values, "tjjjDpffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpffjjcBetween(String value1, String value2) {
            addCriterion("tjjj_dpffjjc between", value1, value2, "tjjjDpffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpffjjcNotBetween(String value1, String value2) {
            addCriterion("tjjj_dpffjjc not between", value1, value2, "tjjjDpffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjDrksIsNull() {
            addCriterion("tjjj_drks is null");
            return (Criteria) this;
        }

        public Criteria andTjjjDrksIsNotNull() {
            addCriterion("tjjj_drks is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjDrksEqualTo(String value) {
            addCriterion("tjjj_drks =", value, "tjjjDrks");
            return (Criteria) this;
        }

        public Criteria andTjjjDrksNotEqualTo(String value) {
            addCriterion("tjjj_drks <>", value, "tjjjDrks");
            return (Criteria) this;
        }

        public Criteria andTjjjDrksGreaterThan(String value) {
            addCriterion("tjjj_drks >", value, "tjjjDrks");
            return (Criteria) this;
        }

        public Criteria andTjjjDrksGreaterThanOrEqualTo(String value) {
            addCriterion("tjjj_drks >=", value, "tjjjDrks");
            return (Criteria) this;
        }

        public Criteria andTjjjDrksLessThan(String value) {
            addCriterion("tjjj_drks <", value, "tjjjDrks");
            return (Criteria) this;
        }

        public Criteria andTjjjDrksLessThanOrEqualTo(String value) {
            addCriterion("tjjj_drks <=", value, "tjjjDrks");
            return (Criteria) this;
        }

        public Criteria andTjjjDrksLike(String value) {
            addCriterion("tjjj_drks like", value, "tjjjDrks");
            return (Criteria) this;
        }

        public Criteria andTjjjDrksNotLike(String value) {
            addCriterion("tjjj_drks not like", value, "tjjjDrks");
            return (Criteria) this;
        }

        public Criteria andTjjjDrksIn(List<String> values) {
            addCriterion("tjjj_drks in", values, "tjjjDrks");
            return (Criteria) this;
        }

        public Criteria andTjjjDrksNotIn(List<String> values) {
            addCriterion("tjjj_drks not in", values, "tjjjDrks");
            return (Criteria) this;
        }

        public Criteria andTjjjDrksBetween(String value1, String value2) {
            addCriterion("tjjj_drks between", value1, value2, "tjjjDrks");
            return (Criteria) this;
        }

        public Criteria andTjjjDrksNotBetween(String value1, String value2) {
            addCriterion("tjjj_drks not between", value1, value2, "tjjjDrks");
            return (Criteria) this;
        }

        public Criteria andTjjjDcksIsNull() {
            addCriterion("tjjj_dcks is null");
            return (Criteria) this;
        }

        public Criteria andTjjjDcksIsNotNull() {
            addCriterion("tjjj_dcks is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjDcksEqualTo(String value) {
            addCriterion("tjjj_dcks =", value, "tjjjDcks");
            return (Criteria) this;
        }

        public Criteria andTjjjDcksNotEqualTo(String value) {
            addCriterion("tjjj_dcks <>", value, "tjjjDcks");
            return (Criteria) this;
        }

        public Criteria andTjjjDcksGreaterThan(String value) {
            addCriterion("tjjj_dcks >", value, "tjjjDcks");
            return (Criteria) this;
        }

        public Criteria andTjjjDcksGreaterThanOrEqualTo(String value) {
            addCriterion("tjjj_dcks >=", value, "tjjjDcks");
            return (Criteria) this;
        }

        public Criteria andTjjjDcksLessThan(String value) {
            addCriterion("tjjj_dcks <", value, "tjjjDcks");
            return (Criteria) this;
        }

        public Criteria andTjjjDcksLessThanOrEqualTo(String value) {
            addCriterion("tjjj_dcks <=", value, "tjjjDcks");
            return (Criteria) this;
        }

        public Criteria andTjjjDcksLike(String value) {
            addCriterion("tjjj_dcks like", value, "tjjjDcks");
            return (Criteria) this;
        }

        public Criteria andTjjjDcksNotLike(String value) {
            addCriterion("tjjj_dcks not like", value, "tjjjDcks");
            return (Criteria) this;
        }

        public Criteria andTjjjDcksIn(List<String> values) {
            addCriterion("tjjj_dcks in", values, "tjjjDcks");
            return (Criteria) this;
        }

        public Criteria andTjjjDcksNotIn(List<String> values) {
            addCriterion("tjjj_dcks not in", values, "tjjjDcks");
            return (Criteria) this;
        }

        public Criteria andTjjjDcksBetween(String value1, String value2) {
            addCriterion("tjjj_dcks between", value1, value2, "tjjjDcks");
            return (Criteria) this;
        }

        public Criteria andTjjjDcksNotBetween(String value1, String value2) {
            addCriterion("tjjj_dcks not between", value1, value2, "tjjjDcks");
            return (Criteria) this;
        }

        public Criteria andTjjjDrjbrIsNull() {
            addCriterion("tjjj_drjbr is null");
            return (Criteria) this;
        }

        public Criteria andTjjjDrjbrIsNotNull() {
            addCriterion("tjjj_drjbr is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjDrjbrEqualTo(String value) {
            addCriterion("tjjj_drjbr =", value, "tjjjDrjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDrjbrNotEqualTo(String value) {
            addCriterion("tjjj_drjbr <>", value, "tjjjDrjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDrjbrGreaterThan(String value) {
            addCriterion("tjjj_drjbr >", value, "tjjjDrjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDrjbrGreaterThanOrEqualTo(String value) {
            addCriterion("tjjj_drjbr >=", value, "tjjjDrjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDrjbrLessThan(String value) {
            addCriterion("tjjj_drjbr <", value, "tjjjDrjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDrjbrLessThanOrEqualTo(String value) {
            addCriterion("tjjj_drjbr <=", value, "tjjjDrjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDrjbrLike(String value) {
            addCriterion("tjjj_drjbr like", value, "tjjjDrjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDrjbrNotLike(String value) {
            addCriterion("tjjj_drjbr not like", value, "tjjjDrjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDrjbrIn(List<String> values) {
            addCriterion("tjjj_drjbr in", values, "tjjjDrjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDrjbrNotIn(List<String> values) {
            addCriterion("tjjj_drjbr not in", values, "tjjjDrjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDrjbrBetween(String value1, String value2) {
            addCriterion("tjjj_drjbr between", value1, value2, "tjjjDrjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDrjbrNotBetween(String value1, String value2) {
            addCriterion("tjjj_drjbr not between", value1, value2, "tjjjDrjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDcjbrIsNull() {
            addCriterion("tjjj_dcjbr is null");
            return (Criteria) this;
        }

        public Criteria andTjjjDcjbrIsNotNull() {
            addCriterion("tjjj_dcjbr is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjDcjbrEqualTo(String value) {
            addCriterion("tjjj_dcjbr =", value, "tjjjDcjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDcjbrNotEqualTo(String value) {
            addCriterion("tjjj_dcjbr <>", value, "tjjjDcjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDcjbrGreaterThan(String value) {
            addCriterion("tjjj_dcjbr >", value, "tjjjDcjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDcjbrGreaterThanOrEqualTo(String value) {
            addCriterion("tjjj_dcjbr >=", value, "tjjjDcjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDcjbrLessThan(String value) {
            addCriterion("tjjj_dcjbr <", value, "tjjjDcjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDcjbrLessThanOrEqualTo(String value) {
            addCriterion("tjjj_dcjbr <=", value, "tjjjDcjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDcjbrLike(String value) {
            addCriterion("tjjj_dcjbr like", value, "tjjjDcjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDcjbrNotLike(String value) {
            addCriterion("tjjj_dcjbr not like", value, "tjjjDcjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDcjbrIn(List<String> values) {
            addCriterion("tjjj_dcjbr in", values, "tjjjDcjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDcjbrNotIn(List<String> values) {
            addCriterion("tjjj_dcjbr not in", values, "tjjjDcjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDcjbrBetween(String value1, String value2) {
            addCriterion("tjjj_dcjbr between", value1, value2, "tjjjDcjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjDcjbrNotBetween(String value1, String value2) {
            addCriterion("tjjj_dcjbr not between", value1, value2, "tjjjDcjbr");
            return (Criteria) this;
        }

        public Criteria andTjjjJllxIsNull() {
            addCriterion("tjjj_jllx is null");
            return (Criteria) this;
        }

        public Criteria andTjjjJllxIsNotNull() {
            addCriterion("tjjj_jllx is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjJllxEqualTo(String value) {
            addCriterion("tjjj_jllx =", value, "tjjjJllx");
            return (Criteria) this;
        }

        public Criteria andTjjjJllxNotEqualTo(String value) {
            addCriterion("tjjj_jllx <>", value, "tjjjJllx");
            return (Criteria) this;
        }

        public Criteria andTjjjJllxGreaterThan(String value) {
            addCriterion("tjjj_jllx >", value, "tjjjJllx");
            return (Criteria) this;
        }

        public Criteria andTjjjJllxGreaterThanOrEqualTo(String value) {
            addCriterion("tjjj_jllx >=", value, "tjjjJllx");
            return (Criteria) this;
        }

        public Criteria andTjjjJllxLessThan(String value) {
            addCriterion("tjjj_jllx <", value, "tjjjJllx");
            return (Criteria) this;
        }

        public Criteria andTjjjJllxLessThanOrEqualTo(String value) {
            addCriterion("tjjj_jllx <=", value, "tjjjJllx");
            return (Criteria) this;
        }

        public Criteria andTjjjJllxLike(String value) {
            addCriterion("tjjj_jllx like", value, "tjjjJllx");
            return (Criteria) this;
        }

        public Criteria andTjjjJllxNotLike(String value) {
            addCriterion("tjjj_jllx not like", value, "tjjjJllx");
            return (Criteria) this;
        }

        public Criteria andTjjjJllxIn(List<String> values) {
            addCriterion("tjjj_jllx in", values, "tjjjJllx");
            return (Criteria) this;
        }

        public Criteria andTjjjJllxNotIn(List<String> values) {
            addCriterion("tjjj_jllx not in", values, "tjjjJllx");
            return (Criteria) this;
        }

        public Criteria andTjjjJllxBetween(String value1, String value2) {
            addCriterion("tjjj_jllx between", value1, value2, "tjjjJllx");
            return (Criteria) this;
        }

        public Criteria andTjjjJllxNotBetween(String value1, String value2) {
            addCriterion("tjjj_jllx not between", value1, value2, "tjjjJllx");
            return (Criteria) this;
        }

        public Criteria andTjjjZbdcidIsNull() {
            addCriterion("tjjj_zbdcid is null");
            return (Criteria) this;
        }

        public Criteria andTjjjZbdcidIsNotNull() {
            addCriterion("tjjj_zbdcid is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjZbdcidEqualTo(String value) {
            addCriterion("tjjj_zbdcid =", value, "tjjjZbdcid");
            return (Criteria) this;
        }

        public Criteria andTjjjZbdcidNotEqualTo(String value) {
            addCriterion("tjjj_zbdcid <>", value, "tjjjZbdcid");
            return (Criteria) this;
        }

        public Criteria andTjjjZbdcidGreaterThan(String value) {
            addCriterion("tjjj_zbdcid >", value, "tjjjZbdcid");
            return (Criteria) this;
        }

        public Criteria andTjjjZbdcidGreaterThanOrEqualTo(String value) {
            addCriterion("tjjj_zbdcid >=", value, "tjjjZbdcid");
            return (Criteria) this;
        }

        public Criteria andTjjjZbdcidLessThan(String value) {
            addCriterion("tjjj_zbdcid <", value, "tjjjZbdcid");
            return (Criteria) this;
        }

        public Criteria andTjjjZbdcidLessThanOrEqualTo(String value) {
            addCriterion("tjjj_zbdcid <=", value, "tjjjZbdcid");
            return (Criteria) this;
        }

        public Criteria andTjjjZbdcidLike(String value) {
            addCriterion("tjjj_zbdcid like", value, "tjjjZbdcid");
            return (Criteria) this;
        }

        public Criteria andTjjjZbdcidNotLike(String value) {
            addCriterion("tjjj_zbdcid not like", value, "tjjjZbdcid");
            return (Criteria) this;
        }

        public Criteria andTjjjZbdcidIn(List<String> values) {
            addCriterion("tjjj_zbdcid in", values, "tjjjZbdcid");
            return (Criteria) this;
        }

        public Criteria andTjjjZbdcidNotIn(List<String> values) {
            addCriterion("tjjj_zbdcid not in", values, "tjjjZbdcid");
            return (Criteria) this;
        }

        public Criteria andTjjjZbdcidBetween(String value1, String value2) {
            addCriterion("tjjj_zbdcid between", value1, value2, "tjjjZbdcid");
            return (Criteria) this;
        }

        public Criteria andTjjjZbdcidNotBetween(String value1, String value2) {
            addCriterion("tjjj_zbdcid not between", value1, value2, "tjjjZbdcid");
            return (Criteria) this;
        }

        public Criteria andTjjjQitaIsNull() {
            addCriterion("tjjj_qita is null");
            return (Criteria) this;
        }

        public Criteria andTjjjQitaIsNotNull() {
            addCriterion("tjjj_qita is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjQitaEqualTo(String value) {
            addCriterion("tjjj_qita =", value, "tjjjQita");
            return (Criteria) this;
        }

        public Criteria andTjjjQitaNotEqualTo(String value) {
            addCriterion("tjjj_qita <>", value, "tjjjQita");
            return (Criteria) this;
        }

        public Criteria andTjjjQitaGreaterThan(String value) {
            addCriterion("tjjj_qita >", value, "tjjjQita");
            return (Criteria) this;
        }

        public Criteria andTjjjQitaGreaterThanOrEqualTo(String value) {
            addCriterion("tjjj_qita >=", value, "tjjjQita");
            return (Criteria) this;
        }

        public Criteria andTjjjQitaLessThan(String value) {
            addCriterion("tjjj_qita <", value, "tjjjQita");
            return (Criteria) this;
        }

        public Criteria andTjjjQitaLessThanOrEqualTo(String value) {
            addCriterion("tjjj_qita <=", value, "tjjjQita");
            return (Criteria) this;
        }

        public Criteria andTjjjQitaLike(String value) {
            addCriterion("tjjj_qita like", value, "tjjjQita");
            return (Criteria) this;
        }

        public Criteria andTjjjQitaNotLike(String value) {
            addCriterion("tjjj_qita not like", value, "tjjjQita");
            return (Criteria) this;
        }

        public Criteria andTjjjQitaIn(List<String> values) {
            addCriterion("tjjj_qita in", values, "tjjjQita");
            return (Criteria) this;
        }

        public Criteria andTjjjQitaNotIn(List<String> values) {
            addCriterion("tjjj_qita not in", values, "tjjjQita");
            return (Criteria) this;
        }

        public Criteria andTjjjQitaBetween(String value1, String value2) {
            addCriterion("tjjj_qita between", value1, value2, "tjjjQita");
            return (Criteria) this;
        }

        public Criteria andTjjjQitaNotBetween(String value1, String value2) {
            addCriterion("tjjj_qita not between", value1, value2, "tjjjQita");
            return (Criteria) this;
        }

        public Criteria andTjjjJsrqIsNull() {
            addCriterion("tjjj_jsrq is null");
            return (Criteria) this;
        }

        public Criteria andTjjjJsrqIsNotNull() {
            addCriterion("tjjj_jsrq is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjJsrqEqualTo(Date value) {
            addCriterionForJDBCDate("tjjj_jsrq =", value, "tjjjJsrq");
            return (Criteria) this;
        }

        public Criteria andTjjjJsrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("tjjj_jsrq <>", value, "tjjjJsrq");
            return (Criteria) this;
        }

        public Criteria andTjjjJsrqGreaterThan(Date value) {
            addCriterionForJDBCDate("tjjj_jsrq >", value, "tjjjJsrq");
            return (Criteria) this;
        }

        public Criteria andTjjjJsrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tjjj_jsrq >=", value, "tjjjJsrq");
            return (Criteria) this;
        }

        public Criteria andTjjjJsrqLessThan(Date value) {
            addCriterionForJDBCDate("tjjj_jsrq <", value, "tjjjJsrq");
            return (Criteria) this;
        }

        public Criteria andTjjjJsrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tjjj_jsrq <=", value, "tjjjJsrq");
            return (Criteria) this;
        }

        public Criteria andTjjjJsrqIn(List<Date> values) {
            addCriterionForJDBCDate("tjjj_jsrq in", values, "tjjjJsrq");
            return (Criteria) this;
        }

        public Criteria andTjjjJsrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("tjjj_jsrq not in", values, "tjjjJsrq");
            return (Criteria) this;
        }

        public Criteria andTjjjJsrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tjjj_jsrq between", value1, value2, "tjjjJsrq");
            return (Criteria) this;
        }

        public Criteria andTjjjJsrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tjjj_jsrq not between", value1, value2, "tjjjJsrq");
            return (Criteria) this;
        }

        public Criteria andTjjjDpscIsNull() {
            addCriterion("tjjj_dpsc is null");
            return (Criteria) this;
        }

        public Criteria andTjjjDpscIsNotNull() {
            addCriterion("tjjj_dpsc is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjDpscEqualTo(Integer value) {
            addCriterion("tjjj_dpsc =", value, "tjjjDpsc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpscNotEqualTo(Integer value) {
            addCriterion("tjjj_dpsc <>", value, "tjjjDpsc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpscGreaterThan(Integer value) {
            addCriterion("tjjj_dpsc >", value, "tjjjDpsc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpscGreaterThanOrEqualTo(Integer value) {
            addCriterion("tjjj_dpsc >=", value, "tjjjDpsc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpscLessThan(Integer value) {
            addCriterion("tjjj_dpsc <", value, "tjjjDpsc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpscLessThanOrEqualTo(Integer value) {
            addCriterion("tjjj_dpsc <=", value, "tjjjDpsc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpscIn(List<Integer> values) {
            addCriterion("tjjj_dpsc in", values, "tjjjDpsc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpscNotIn(List<Integer> values) {
            addCriterion("tjjj_dpsc not in", values, "tjjjDpsc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpscBetween(Integer value1, Integer value2) {
            addCriterion("tjjj_dpsc between", value1, value2, "tjjjDpsc");
            return (Criteria) this;
        }

        public Criteria andTjjjDpscNotBetween(Integer value1, Integer value2) {
            addCriterion("tjjj_dpsc not between", value1, value2, "tjjjDpsc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsfztjcIsNull() {
            addCriterion("tjjj_jsfztjc is null");
            return (Criteria) this;
        }

        public Criteria andTjjjJsfztjcIsNotNull() {
            addCriterion("tjjj_jsfztjc is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjJsfztjcEqualTo(String value) {
            addCriterion("tjjj_jsfztjc =", value, "tjjjJsfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsfztjcNotEqualTo(String value) {
            addCriterion("tjjj_jsfztjc <>", value, "tjjjJsfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsfztjcGreaterThan(String value) {
            addCriterion("tjjj_jsfztjc >", value, "tjjjJsfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsfztjcGreaterThanOrEqualTo(String value) {
            addCriterion("tjjj_jsfztjc >=", value, "tjjjJsfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsfztjcLessThan(String value) {
            addCriterion("tjjj_jsfztjc <", value, "tjjjJsfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsfztjcLessThanOrEqualTo(String value) {
            addCriterion("tjjj_jsfztjc <=", value, "tjjjJsfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsfztjcLike(String value) {
            addCriterion("tjjj_jsfztjc like", value, "tjjjJsfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsfztjcNotLike(String value) {
            addCriterion("tjjj_jsfztjc not like", value, "tjjjJsfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsfztjcIn(List<String> values) {
            addCriterion("tjjj_jsfztjc in", values, "tjjjJsfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsfztjcNotIn(List<String> values) {
            addCriterion("tjjj_jsfztjc not in", values, "tjjjJsfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsfztjcBetween(String value1, String value2) {
            addCriterion("tjjj_jsfztjc between", value1, value2, "tjjjJsfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsfztjcNotBetween(String value1, String value2) {
            addCriterion("tjjj_jsfztjc not between", value1, value2, "tjjjJsfztjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsffjjcIsNull() {
            addCriterion("tjjj_jsffjjc is null");
            return (Criteria) this;
        }

        public Criteria andTjjjJsffjjcIsNotNull() {
            addCriterion("tjjj_jsffjjc is not null");
            return (Criteria) this;
        }

        public Criteria andTjjjJsffjjcEqualTo(String value) {
            addCriterion("tjjj_jsffjjc =", value, "tjjjJsffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsffjjcNotEqualTo(String value) {
            addCriterion("tjjj_jsffjjc <>", value, "tjjjJsffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsffjjcGreaterThan(String value) {
            addCriterion("tjjj_jsffjjc >", value, "tjjjJsffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsffjjcGreaterThanOrEqualTo(String value) {
            addCriterion("tjjj_jsffjjc >=", value, "tjjjJsffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsffjjcLessThan(String value) {
            addCriterion("tjjj_jsffjjc <", value, "tjjjJsffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsffjjcLessThanOrEqualTo(String value) {
            addCriterion("tjjj_jsffjjc <=", value, "tjjjJsffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsffjjcLike(String value) {
            addCriterion("tjjj_jsffjjc like", value, "tjjjJsffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsffjjcNotLike(String value) {
            addCriterion("tjjj_jsffjjc not like", value, "tjjjJsffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsffjjcIn(List<String> values) {
            addCriterion("tjjj_jsffjjc in", values, "tjjjJsffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsffjjcNotIn(List<String> values) {
            addCriterion("tjjj_jsffjjc not in", values, "tjjjJsffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsffjjcBetween(String value1, String value2) {
            addCriterion("tjjj_jsffjjc between", value1, value2, "tjjjJsffjjc");
            return (Criteria) this;
        }

        public Criteria andTjjjJsffjjcNotBetween(String value1, String value2) {
            addCriterion("tjjj_jsffjjc not between", value1, value2, "tjjjJsffjjc");
            return (Criteria) this;
        }

        public Criteria andEqSfqbghIsNull() {
            addCriterion("eq_sfqbgh is null");
            return (Criteria) this;
        }

        public Criteria andEqSfqbghIsNotNull() {
            addCriterion("eq_sfqbgh is not null");
            return (Criteria) this;
        }

        public Criteria andEqSfqbghEqualTo(String value) {
            addCriterion("eq_sfqbgh =", value, "eqSfqbgh");
            return (Criteria) this;
        }

        public Criteria andEqSfqbghNotEqualTo(String value) {
            addCriterion("eq_sfqbgh <>", value, "eqSfqbgh");
            return (Criteria) this;
        }

        public Criteria andEqSfqbghGreaterThan(String value) {
            addCriterion("eq_sfqbgh >", value, "eqSfqbgh");
            return (Criteria) this;
        }

        public Criteria andEqSfqbghGreaterThanOrEqualTo(String value) {
            addCriterion("eq_sfqbgh >=", value, "eqSfqbgh");
            return (Criteria) this;
        }

        public Criteria andEqSfqbghLessThan(String value) {
            addCriterion("eq_sfqbgh <", value, "eqSfqbgh");
            return (Criteria) this;
        }

        public Criteria andEqSfqbghLessThanOrEqualTo(String value) {
            addCriterion("eq_sfqbgh <=", value, "eqSfqbgh");
            return (Criteria) this;
        }

        public Criteria andEqSfqbghLike(String value) {
            addCriterion("eq_sfqbgh like", value, "eqSfqbgh");
            return (Criteria) this;
        }

        public Criteria andEqSfqbghNotLike(String value) {
            addCriterion("eq_sfqbgh not like", value, "eqSfqbgh");
            return (Criteria) this;
        }

        public Criteria andEqSfqbghIn(List<String> values) {
            addCriterion("eq_sfqbgh in", values, "eqSfqbgh");
            return (Criteria) this;
        }

        public Criteria andEqSfqbghNotIn(List<String> values) {
            addCriterion("eq_sfqbgh not in", values, "eqSfqbgh");
            return (Criteria) this;
        }

        public Criteria andEqSfqbghBetween(String value1, String value2) {
            addCriterion("eq_sfqbgh between", value1, value2, "eqSfqbgh");
            return (Criteria) this;
        }

        public Criteria andEqSfqbghNotBetween(String value1, String value2) {
            addCriterion("eq_sfqbgh not between", value1, value2, "eqSfqbgh");
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