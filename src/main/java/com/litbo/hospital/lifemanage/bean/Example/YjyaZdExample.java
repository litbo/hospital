package com.litbo.hospital.lifemanage.bean.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class YjyaZdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YjyaZdExample() {
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

        public Criteria andYjyaBhIsNull() {
            addCriterion("yjya_bh is null");
            return (Criteria) this;
        }

        public Criteria andYjyaBhIsNotNull() {
            addCriterion("yjya_bh is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaBhEqualTo(String value) {
            addCriterion("yjya_bh =", value, "yjyaBh");
            return (Criteria) this;
        }

        public Criteria andYjyaBhNotEqualTo(String value) {
            addCriterion("yjya_bh <>", value, "yjyaBh");
            return (Criteria) this;
        }

        public Criteria andYjyaBhGreaterThan(String value) {
            addCriterion("yjya_bh >", value, "yjyaBh");
            return (Criteria) this;
        }

        public Criteria andYjyaBhGreaterThanOrEqualTo(String value) {
            addCriterion("yjya_bh >=", value, "yjyaBh");
            return (Criteria) this;
        }

        public Criteria andYjyaBhLessThan(String value) {
            addCriterion("yjya_bh <", value, "yjyaBh");
            return (Criteria) this;
        }

        public Criteria andYjyaBhLessThanOrEqualTo(String value) {
            addCriterion("yjya_bh <=", value, "yjyaBh");
            return (Criteria) this;
        }

        public Criteria andYjyaBhLike(String value) {
            addCriterion("yjya_bh like", value, "yjyaBh");
            return (Criteria) this;
        }

        public Criteria andYjyaBhNotLike(String value) {
            addCriterion("yjya_bh not like", value, "yjyaBh");
            return (Criteria) this;
        }

        public Criteria andYjyaBhIn(List<String> values) {
            addCriterion("yjya_bh in", values, "yjyaBh");
            return (Criteria) this;
        }

        public Criteria andYjyaBhNotIn(List<String> values) {
            addCriterion("yjya_bh not in", values, "yjyaBh");
            return (Criteria) this;
        }

        public Criteria andYjyaBhBetween(String value1, String value2) {
            addCriterion("yjya_bh between", value1, value2, "yjyaBh");
            return (Criteria) this;
        }

        public Criteria andYjyaBhNotBetween(String value1, String value2) {
            addCriterion("yjya_bh not between", value1, value2, "yjyaBh");
            return (Criteria) this;
        }

        public Criteria andYjyaNameIsNull() {
            addCriterion("yjya_name is null");
            return (Criteria) this;
        }

        public Criteria andYjyaNameIsNotNull() {
            addCriterion("yjya_name is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaNameEqualTo(String value) {
            addCriterion("yjya_name =", value, "yjyaName");
            return (Criteria) this;
        }

        public Criteria andYjyaNameNotEqualTo(String value) {
            addCriterion("yjya_name <>", value, "yjyaName");
            return (Criteria) this;
        }

        public Criteria andYjyaNameGreaterThan(String value) {
            addCriterion("yjya_name >", value, "yjyaName");
            return (Criteria) this;
        }

        public Criteria andYjyaNameGreaterThanOrEqualTo(String value) {
            addCriterion("yjya_name >=", value, "yjyaName");
            return (Criteria) this;
        }

        public Criteria andYjyaNameLessThan(String value) {
            addCriterion("yjya_name <", value, "yjyaName");
            return (Criteria) this;
        }

        public Criteria andYjyaNameLessThanOrEqualTo(String value) {
            addCriterion("yjya_name <=", value, "yjyaName");
            return (Criteria) this;
        }

        public Criteria andYjyaNameLike(String value) {
            addCriterion("yjya_name like", value, "yjyaName");
            return (Criteria) this;
        }

        public Criteria andYjyaNameNotLike(String value) {
            addCriterion("yjya_name not like", value, "yjyaName");
            return (Criteria) this;
        }

        public Criteria andYjyaNameIn(List<String> values) {
            addCriterion("yjya_name in", values, "yjyaName");
            return (Criteria) this;
        }

        public Criteria andYjyaNameNotIn(List<String> values) {
            addCriterion("yjya_name not in", values, "yjyaName");
            return (Criteria) this;
        }

        public Criteria andYjyaNameBetween(String value1, String value2) {
            addCriterion("yjya_name between", value1, value2, "yjyaName");
            return (Criteria) this;
        }

        public Criteria andYjyaNameNotBetween(String value1, String value2) {
            addCriterion("yjya_name not between", value1, value2, "yjyaName");
            return (Criteria) this;
        }

        public Criteria andYjyaLxIsNull() {
            addCriterion("yjya_lx is null");
            return (Criteria) this;
        }

        public Criteria andYjyaLxIsNotNull() {
            addCriterion("yjya_lx is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaLxEqualTo(String value) {
            addCriterion("yjya_lx =", value, "yjyaLx");
            return (Criteria) this;
        }

        public Criteria andYjyaLxNotEqualTo(String value) {
            addCriterion("yjya_lx <>", value, "yjyaLx");
            return (Criteria) this;
        }

        public Criteria andYjyaLxGreaterThan(String value) {
            addCriterion("yjya_lx >", value, "yjyaLx");
            return (Criteria) this;
        }

        public Criteria andYjyaLxGreaterThanOrEqualTo(String value) {
            addCriterion("yjya_lx >=", value, "yjyaLx");
            return (Criteria) this;
        }

        public Criteria andYjyaLxLessThan(String value) {
            addCriterion("yjya_lx <", value, "yjyaLx");
            return (Criteria) this;
        }

        public Criteria andYjyaLxLessThanOrEqualTo(String value) {
            addCriterion("yjya_lx <=", value, "yjyaLx");
            return (Criteria) this;
        }

        public Criteria andYjyaLxLike(String value) {
            addCriterion("yjya_lx like", value, "yjyaLx");
            return (Criteria) this;
        }

        public Criteria andYjyaLxNotLike(String value) {
            addCriterion("yjya_lx not like", value, "yjyaLx");
            return (Criteria) this;
        }

        public Criteria andYjyaLxIn(List<String> values) {
            addCriterion("yjya_lx in", values, "yjyaLx");
            return (Criteria) this;
        }

        public Criteria andYjyaLxNotIn(List<String> values) {
            addCriterion("yjya_lx not in", values, "yjyaLx");
            return (Criteria) this;
        }

        public Criteria andYjyaLxBetween(String value1, String value2) {
            addCriterion("yjya_lx between", value1, value2, "yjyaLx");
            return (Criteria) this;
        }

        public Criteria andYjyaLxNotBetween(String value1, String value2) {
            addCriterion("yjya_lx not between", value1, value2, "yjyaLx");
            return (Criteria) this;
        }

        public Criteria andYjyaZysIsNull() {
            addCriterion("yjya_zys is null");
            return (Criteria) this;
        }

        public Criteria andYjyaZysIsNotNull() {
            addCriterion("yjya_zys is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaZysEqualTo(Integer value) {
            addCriterion("yjya_zys =", value, "yjyaZys");
            return (Criteria) this;
        }

        public Criteria andYjyaZysNotEqualTo(Integer value) {
            addCriterion("yjya_zys <>", value, "yjyaZys");
            return (Criteria) this;
        }

        public Criteria andYjyaZysGreaterThan(Integer value) {
            addCriterion("yjya_zys >", value, "yjyaZys");
            return (Criteria) this;
        }

        public Criteria andYjyaZysGreaterThanOrEqualTo(Integer value) {
            addCriterion("yjya_zys >=", value, "yjyaZys");
            return (Criteria) this;
        }

        public Criteria andYjyaZysLessThan(Integer value) {
            addCriterion("yjya_zys <", value, "yjyaZys");
            return (Criteria) this;
        }

        public Criteria andYjyaZysLessThanOrEqualTo(Integer value) {
            addCriterion("yjya_zys <=", value, "yjyaZys");
            return (Criteria) this;
        }

        public Criteria andYjyaZysIn(List<Integer> values) {
            addCriterion("yjya_zys in", values, "yjyaZys");
            return (Criteria) this;
        }

        public Criteria andYjyaZysNotIn(List<Integer> values) {
            addCriterion("yjya_zys not in", values, "yjyaZys");
            return (Criteria) this;
        }

        public Criteria andYjyaZysBetween(Integer value1, Integer value2) {
            addCriterion("yjya_zys between", value1, value2, "yjyaZys");
            return (Criteria) this;
        }

        public Criteria andYjyaZysNotBetween(Integer value1, Integer value2) {
            addCriterion("yjya_zys not between", value1, value2, "yjyaZys");
            return (Criteria) this;
        }

        public Criteria andYjyaBbhIsNull() {
            addCriterion("yjya_bbh is null");
            return (Criteria) this;
        }

        public Criteria andYjyaBbhIsNotNull() {
            addCriterion("yjya_bbh is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaBbhEqualTo(String value) {
            addCriterion("yjya_bbh =", value, "yjyaBbh");
            return (Criteria) this;
        }

        public Criteria andYjyaBbhNotEqualTo(String value) {
            addCriterion("yjya_bbh <>", value, "yjyaBbh");
            return (Criteria) this;
        }

        public Criteria andYjyaBbhGreaterThan(String value) {
            addCriterion("yjya_bbh >", value, "yjyaBbh");
            return (Criteria) this;
        }

        public Criteria andYjyaBbhGreaterThanOrEqualTo(String value) {
            addCriterion("yjya_bbh >=", value, "yjyaBbh");
            return (Criteria) this;
        }

        public Criteria andYjyaBbhLessThan(String value) {
            addCriterion("yjya_bbh <", value, "yjyaBbh");
            return (Criteria) this;
        }

        public Criteria andYjyaBbhLessThanOrEqualTo(String value) {
            addCriterion("yjya_bbh <=", value, "yjyaBbh");
            return (Criteria) this;
        }

        public Criteria andYjyaBbhLike(String value) {
            addCriterion("yjya_bbh like", value, "yjyaBbh");
            return (Criteria) this;
        }

        public Criteria andYjyaBbhNotLike(String value) {
            addCriterion("yjya_bbh not like", value, "yjyaBbh");
            return (Criteria) this;
        }

        public Criteria andYjyaBbhIn(List<String> values) {
            addCriterion("yjya_bbh in", values, "yjyaBbh");
            return (Criteria) this;
        }

        public Criteria andYjyaBbhNotIn(List<String> values) {
            addCriterion("yjya_bbh not in", values, "yjyaBbh");
            return (Criteria) this;
        }

        public Criteria andYjyaBbhBetween(String value1, String value2) {
            addCriterion("yjya_bbh between", value1, value2, "yjyaBbh");
            return (Criteria) this;
        }

        public Criteria andYjyaBbhNotBetween(String value1, String value2) {
            addCriterion("yjya_bbh not between", value1, value2, "yjyaBbh");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrIsNull() {
            addCriterion("yjya_ngr is null");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrIsNotNull() {
            addCriterion("yjya_ngr is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrEqualTo(String value) {
            addCriterion("yjya_ngr =", value, "yjyaNgr");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrNotEqualTo(String value) {
            addCriterion("yjya_ngr <>", value, "yjyaNgr");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrGreaterThan(String value) {
            addCriterion("yjya_ngr >", value, "yjyaNgr");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrGreaterThanOrEqualTo(String value) {
            addCriterion("yjya_ngr >=", value, "yjyaNgr");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrLessThan(String value) {
            addCriterion("yjya_ngr <", value, "yjyaNgr");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrLessThanOrEqualTo(String value) {
            addCriterion("yjya_ngr <=", value, "yjyaNgr");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrLike(String value) {
            addCriterion("yjya_ngr like", value, "yjyaNgr");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrNotLike(String value) {
            addCriterion("yjya_ngr not like", value, "yjyaNgr");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrIn(List<String> values) {
            addCriterion("yjya_ngr in", values, "yjyaNgr");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrNotIn(List<String> values) {
            addCriterion("yjya_ngr not in", values, "yjyaNgr");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrBetween(String value1, String value2) {
            addCriterion("yjya_ngr between", value1, value2, "yjyaNgr");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrNotBetween(String value1, String value2) {
            addCriterion("yjya_ngr not between", value1, value2, "yjyaNgr");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrqIsNull() {
            addCriterion("yjya_ngrq is null");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrqIsNotNull() {
            addCriterion("yjya_ngrq is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrqEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_ngrq =", value, "yjyaNgrq");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_ngrq <>", value, "yjyaNgrq");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrqGreaterThan(Date value) {
            addCriterionForJDBCDate("yjya_ngrq >", value, "yjyaNgrq");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_ngrq >=", value, "yjyaNgrq");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrqLessThan(Date value) {
            addCriterionForJDBCDate("yjya_ngrq <", value, "yjyaNgrq");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_ngrq <=", value, "yjyaNgrq");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrqIn(List<Date> values) {
            addCriterionForJDBCDate("yjya_ngrq in", values, "yjyaNgrq");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("yjya_ngrq not in", values, "yjyaNgrq");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("yjya_ngrq between", value1, value2, "yjyaNgrq");
            return (Criteria) this;
        }

        public Criteria andYjyaNgrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("yjya_ngrq not between", value1, value2, "yjyaNgrq");
            return (Criteria) this;
        }

        public Criteria andYjyaFbbmIsNull() {
            addCriterion("yjya_fbbm is null");
            return (Criteria) this;
        }

        public Criteria andYjyaFbbmIsNotNull() {
            addCriterion("yjya_fbbm is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaFbbmEqualTo(String value) {
            addCriterion("yjya_fbbm =", value, "yjyaFbbm");
            return (Criteria) this;
        }

        public Criteria andYjyaFbbmNotEqualTo(String value) {
            addCriterion("yjya_fbbm <>", value, "yjyaFbbm");
            return (Criteria) this;
        }

        public Criteria andYjyaFbbmGreaterThan(String value) {
            addCriterion("yjya_fbbm >", value, "yjyaFbbm");
            return (Criteria) this;
        }

        public Criteria andYjyaFbbmGreaterThanOrEqualTo(String value) {
            addCriterion("yjya_fbbm >=", value, "yjyaFbbm");
            return (Criteria) this;
        }

        public Criteria andYjyaFbbmLessThan(String value) {
            addCriterion("yjya_fbbm <", value, "yjyaFbbm");
            return (Criteria) this;
        }

        public Criteria andYjyaFbbmLessThanOrEqualTo(String value) {
            addCriterion("yjya_fbbm <=", value, "yjyaFbbm");
            return (Criteria) this;
        }

        public Criteria andYjyaFbbmLike(String value) {
            addCriterion("yjya_fbbm like", value, "yjyaFbbm");
            return (Criteria) this;
        }

        public Criteria andYjyaFbbmNotLike(String value) {
            addCriterion("yjya_fbbm not like", value, "yjyaFbbm");
            return (Criteria) this;
        }

        public Criteria andYjyaFbbmIn(List<String> values) {
            addCriterion("yjya_fbbm in", values, "yjyaFbbm");
            return (Criteria) this;
        }

        public Criteria andYjyaFbbmNotIn(List<String> values) {
            addCriterion("yjya_fbbm not in", values, "yjyaFbbm");
            return (Criteria) this;
        }

        public Criteria andYjyaFbbmBetween(String value1, String value2) {
            addCriterion("yjya_fbbm between", value1, value2, "yjyaFbbm");
            return (Criteria) this;
        }

        public Criteria andYjyaFbbmNotBetween(String value1, String value2) {
            addCriterion("yjya_fbbm not between", value1, value2, "yjyaFbbm");
            return (Criteria) this;
        }

        public Criteria andYjyaNrIsNull() {
            addCriterion("yjya_nr is null");
            return (Criteria) this;
        }

        public Criteria andYjyaNrIsNotNull() {
            addCriterion("yjya_nr is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaNrEqualTo(String value) {
            addCriterion("yjya_nr =", value, "yjyaNr");
            return (Criteria) this;
        }

        public Criteria andYjyaNrNotEqualTo(String value) {
            addCriterion("yjya_nr <>", value, "yjyaNr");
            return (Criteria) this;
        }

        public Criteria andYjyaNrGreaterThan(String value) {
            addCriterion("yjya_nr >", value, "yjyaNr");
            return (Criteria) this;
        }

        public Criteria andYjyaNrGreaterThanOrEqualTo(String value) {
            addCriterion("yjya_nr >=", value, "yjyaNr");
            return (Criteria) this;
        }

        public Criteria andYjyaNrLessThan(String value) {
            addCriterion("yjya_nr <", value, "yjyaNr");
            return (Criteria) this;
        }

        public Criteria andYjyaNrLessThanOrEqualTo(String value) {
            addCriterion("yjya_nr <=", value, "yjyaNr");
            return (Criteria) this;
        }

        public Criteria andYjyaNrLike(String value) {
            addCriterion("yjya_nr like", value, "yjyaNr");
            return (Criteria) this;
        }

        public Criteria andYjyaNrNotLike(String value) {
            addCriterion("yjya_nr not like", value, "yjyaNr");
            return (Criteria) this;
        }

        public Criteria andYjyaNrIn(List<String> values) {
            addCriterion("yjya_nr in", values, "yjyaNr");
            return (Criteria) this;
        }

        public Criteria andYjyaNrNotIn(List<String> values) {
            addCriterion("yjya_nr not in", values, "yjyaNr");
            return (Criteria) this;
        }

        public Criteria andYjyaNrBetween(String value1, String value2) {
            addCriterion("yjya_nr between", value1, value2, "yjyaNr");
            return (Criteria) this;
        }

        public Criteria andYjyaNrNotBetween(String value1, String value2) {
            addCriterion("yjya_nr not between", value1, value2, "yjyaNr");
            return (Criteria) this;
        }

        public Criteria andYjyaShrIsNull() {
            addCriterion("yjya_shr is null");
            return (Criteria) this;
        }

        public Criteria andYjyaShrIsNotNull() {
            addCriterion("yjya_shr is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaShrEqualTo(String value) {
            addCriterion("yjya_shr =", value, "yjyaShr");
            return (Criteria) this;
        }

        public Criteria andYjyaShrNotEqualTo(String value) {
            addCriterion("yjya_shr <>", value, "yjyaShr");
            return (Criteria) this;
        }

        public Criteria andYjyaShrGreaterThan(String value) {
            addCriterion("yjya_shr >", value, "yjyaShr");
            return (Criteria) this;
        }

        public Criteria andYjyaShrGreaterThanOrEqualTo(String value) {
            addCriterion("yjya_shr >=", value, "yjyaShr");
            return (Criteria) this;
        }

        public Criteria andYjyaShrLessThan(String value) {
            addCriterion("yjya_shr <", value, "yjyaShr");
            return (Criteria) this;
        }

        public Criteria andYjyaShrLessThanOrEqualTo(String value) {
            addCriterion("yjya_shr <=", value, "yjyaShr");
            return (Criteria) this;
        }

        public Criteria andYjyaShrLike(String value) {
            addCriterion("yjya_shr like", value, "yjyaShr");
            return (Criteria) this;
        }

        public Criteria andYjyaShrNotLike(String value) {
            addCriterion("yjya_shr not like", value, "yjyaShr");
            return (Criteria) this;
        }

        public Criteria andYjyaShrIn(List<String> values) {
            addCriterion("yjya_shr in", values, "yjyaShr");
            return (Criteria) this;
        }

        public Criteria andYjyaShrNotIn(List<String> values) {
            addCriterion("yjya_shr not in", values, "yjyaShr");
            return (Criteria) this;
        }

        public Criteria andYjyaShrBetween(String value1, String value2) {
            addCriterion("yjya_shr between", value1, value2, "yjyaShr");
            return (Criteria) this;
        }

        public Criteria andYjyaShrNotBetween(String value1, String value2) {
            addCriterion("yjya_shr not between", value1, value2, "yjyaShr");
            return (Criteria) this;
        }

        public Criteria andYjyaShrqIsNull() {
            addCriterion("yjya_shrq is null");
            return (Criteria) this;
        }

        public Criteria andYjyaShrqIsNotNull() {
            addCriterion("yjya_shrq is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaShrqEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_shrq =", value, "yjyaShrq");
            return (Criteria) this;
        }

        public Criteria andYjyaShrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_shrq <>", value, "yjyaShrq");
            return (Criteria) this;
        }

        public Criteria andYjyaShrqGreaterThan(Date value) {
            addCriterionForJDBCDate("yjya_shrq >", value, "yjyaShrq");
            return (Criteria) this;
        }

        public Criteria andYjyaShrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_shrq >=", value, "yjyaShrq");
            return (Criteria) this;
        }

        public Criteria andYjyaShrqLessThan(Date value) {
            addCriterionForJDBCDate("yjya_shrq <", value, "yjyaShrq");
            return (Criteria) this;
        }

        public Criteria andYjyaShrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_shrq <=", value, "yjyaShrq");
            return (Criteria) this;
        }

        public Criteria andYjyaShrqIn(List<Date> values) {
            addCriterionForJDBCDate("yjya_shrq in", values, "yjyaShrq");
            return (Criteria) this;
        }

        public Criteria andYjyaShrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("yjya_shrq not in", values, "yjyaShrq");
            return (Criteria) this;
        }

        public Criteria andYjyaShrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("yjya_shrq between", value1, value2, "yjyaShrq");
            return (Criteria) this;
        }

        public Criteria andYjyaShrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("yjya_shrq not between", value1, value2, "yjyaShrq");
            return (Criteria) this;
        }

        public Criteria andYjyaShyjIsNull() {
            addCriterion("yjya_shyj is null");
            return (Criteria) this;
        }

        public Criteria andYjyaShyjIsNotNull() {
            addCriterion("yjya_shyj is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaShyjEqualTo(String value) {
            addCriterion("yjya_shyj =", value, "yjyaShyj");
            return (Criteria) this;
        }

        public Criteria andYjyaShyjNotEqualTo(String value) {
            addCriterion("yjya_shyj <>", value, "yjyaShyj");
            return (Criteria) this;
        }

        public Criteria andYjyaShyjGreaterThan(String value) {
            addCriterion("yjya_shyj >", value, "yjyaShyj");
            return (Criteria) this;
        }

        public Criteria andYjyaShyjGreaterThanOrEqualTo(String value) {
            addCriterion("yjya_shyj >=", value, "yjyaShyj");
            return (Criteria) this;
        }

        public Criteria andYjyaShyjLessThan(String value) {
            addCriterion("yjya_shyj <", value, "yjyaShyj");
            return (Criteria) this;
        }

        public Criteria andYjyaShyjLessThanOrEqualTo(String value) {
            addCriterion("yjya_shyj <=", value, "yjyaShyj");
            return (Criteria) this;
        }

        public Criteria andYjyaShyjLike(String value) {
            addCriterion("yjya_shyj like", value, "yjyaShyj");
            return (Criteria) this;
        }

        public Criteria andYjyaShyjNotLike(String value) {
            addCriterion("yjya_shyj not like", value, "yjyaShyj");
            return (Criteria) this;
        }

        public Criteria andYjyaShyjIn(List<String> values) {
            addCriterion("yjya_shyj in", values, "yjyaShyj");
            return (Criteria) this;
        }

        public Criteria andYjyaShyjNotIn(List<String> values) {
            addCriterion("yjya_shyj not in", values, "yjyaShyj");
            return (Criteria) this;
        }

        public Criteria andYjyaShyjBetween(String value1, String value2) {
            addCriterion("yjya_shyj between", value1, value2, "yjyaShyj");
            return (Criteria) this;
        }

        public Criteria andYjyaShyjNotBetween(String value1, String value2) {
            addCriterion("yjya_shyj not between", value1, value2, "yjyaShyj");
            return (Criteria) this;
        }

        public Criteria andYjyaSytsIsNull() {
            addCriterion("yjya_syts is null");
            return (Criteria) this;
        }

        public Criteria andYjyaSytsIsNotNull() {
            addCriterion("yjya_syts is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaSytsEqualTo(Integer value) {
            addCriterion("yjya_syts =", value, "yjyaSyts");
            return (Criteria) this;
        }

        public Criteria andYjyaSytsNotEqualTo(Integer value) {
            addCriterion("yjya_syts <>", value, "yjyaSyts");
            return (Criteria) this;
        }

        public Criteria andYjyaSytsGreaterThan(Integer value) {
            addCriterion("yjya_syts >", value, "yjyaSyts");
            return (Criteria) this;
        }

        public Criteria andYjyaSytsGreaterThanOrEqualTo(Integer value) {
            addCriterion("yjya_syts >=", value, "yjyaSyts");
            return (Criteria) this;
        }

        public Criteria andYjyaSytsLessThan(Integer value) {
            addCriterion("yjya_syts <", value, "yjyaSyts");
            return (Criteria) this;
        }

        public Criteria andYjyaSytsLessThanOrEqualTo(Integer value) {
            addCriterion("yjya_syts <=", value, "yjyaSyts");
            return (Criteria) this;
        }

        public Criteria andYjyaSytsIn(List<Integer> values) {
            addCriterion("yjya_syts in", values, "yjyaSyts");
            return (Criteria) this;
        }

        public Criteria andYjyaSytsNotIn(List<Integer> values) {
            addCriterion("yjya_syts not in", values, "yjyaSyts");
            return (Criteria) this;
        }

        public Criteria andYjyaSytsBetween(Integer value1, Integer value2) {
            addCriterion("yjya_syts between", value1, value2, "yjyaSyts");
            return (Criteria) this;
        }

        public Criteria andYjyaSytsNotBetween(Integer value1, Integer value2) {
            addCriterion("yjya_syts not between", value1, value2, "yjyaSyts");
            return (Criteria) this;
        }

        public Criteria andYjyaZtIsNull() {
            addCriterion("yjya_zt is null");
            return (Criteria) this;
        }

        public Criteria andYjyaZtIsNotNull() {
            addCriterion("yjya_zt is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaZtEqualTo(String value) {
            addCriterion("yjya_zt =", value, "yjyaZt");
            return (Criteria) this;
        }

        public Criteria andYjyaZtNotEqualTo(String value) {
            addCriterion("yjya_zt <>", value, "yjyaZt");
            return (Criteria) this;
        }

        public Criteria andYjyaZtGreaterThan(String value) {
            addCriterion("yjya_zt >", value, "yjyaZt");
            return (Criteria) this;
        }

        public Criteria andYjyaZtGreaterThanOrEqualTo(String value) {
            addCriterion("yjya_zt >=", value, "yjyaZt");
            return (Criteria) this;
        }

        public Criteria andYjyaZtLessThan(String value) {
            addCriterion("yjya_zt <", value, "yjyaZt");
            return (Criteria) this;
        }

        public Criteria andYjyaZtLessThanOrEqualTo(String value) {
            addCriterion("yjya_zt <=", value, "yjyaZt");
            return (Criteria) this;
        }

        public Criteria andYjyaZtLike(String value) {
            addCriterion("yjya_zt like", value, "yjyaZt");
            return (Criteria) this;
        }

        public Criteria andYjyaZtNotLike(String value) {
            addCriterion("yjya_zt not like", value, "yjyaZt");
            return (Criteria) this;
        }

        public Criteria andYjyaZtIn(List<String> values) {
            addCriterion("yjya_zt in", values, "yjyaZt");
            return (Criteria) this;
        }

        public Criteria andYjyaZtNotIn(List<String> values) {
            addCriterion("yjya_zt not in", values, "yjyaZt");
            return (Criteria) this;
        }

        public Criteria andYjyaZtBetween(String value1, String value2) {
            addCriterion("yjya_zt between", value1, value2, "yjyaZt");
            return (Criteria) this;
        }

        public Criteria andYjyaZtNotBetween(String value1, String value2) {
            addCriterion("yjya_zt not between", value1, value2, "yjyaZt");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrIsNull() {
            addCriterion("yjya_zpjsqr is null");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrIsNotNull() {
            addCriterion("yjya_zpjsqr is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrEqualTo(String value) {
            addCriterion("yjya_zpjsqr =", value, "yjyaZpjsqr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrNotEqualTo(String value) {
            addCriterion("yjya_zpjsqr <>", value, "yjyaZpjsqr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrGreaterThan(String value) {
            addCriterion("yjya_zpjsqr >", value, "yjyaZpjsqr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrGreaterThanOrEqualTo(String value) {
            addCriterion("yjya_zpjsqr >=", value, "yjyaZpjsqr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrLessThan(String value) {
            addCriterion("yjya_zpjsqr <", value, "yjyaZpjsqr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrLessThanOrEqualTo(String value) {
            addCriterion("yjya_zpjsqr <=", value, "yjyaZpjsqr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrLike(String value) {
            addCriterion("yjya_zpjsqr like", value, "yjyaZpjsqr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrNotLike(String value) {
            addCriterion("yjya_zpjsqr not like", value, "yjyaZpjsqr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrIn(List<String> values) {
            addCriterion("yjya_zpjsqr in", values, "yjyaZpjsqr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrNotIn(List<String> values) {
            addCriterion("yjya_zpjsqr not in", values, "yjyaZpjsqr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrBetween(String value1, String value2) {
            addCriterion("yjya_zpjsqr between", value1, value2, "yjyaZpjsqr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrNotBetween(String value1, String value2) {
            addCriterion("yjya_zpjsqr not between", value1, value2, "yjyaZpjsqr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrqIsNull() {
            addCriterion("yjya_zpjsqrq is null");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrqIsNotNull() {
            addCriterion("yjya_zpjsqrq is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrqEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_zpjsqrq =", value, "yjyaZpjsqrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_zpjsqrq <>", value, "yjyaZpjsqrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrqGreaterThan(Date value) {
            addCriterionForJDBCDate("yjya_zpjsqrq >", value, "yjyaZpjsqrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_zpjsqrq >=", value, "yjyaZpjsqrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrqLessThan(Date value) {
            addCriterionForJDBCDate("yjya_zpjsqrq <", value, "yjyaZpjsqrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_zpjsqrq <=", value, "yjyaZpjsqrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrqIn(List<Date> values) {
            addCriterionForJDBCDate("yjya_zpjsqrq in", values, "yjyaZpjsqrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("yjya_zpjsqrq not in", values, "yjyaZpjsqrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("yjya_zpjsqrq between", value1, value2, "yjyaZpjsqrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsqrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("yjya_zpjsqrq not between", value1, value2, "yjyaZpjsqrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyyIsNull() {
            addCriterion("yjya_zpjyy is null");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyyIsNotNull() {
            addCriterion("yjya_zpjyy is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyyEqualTo(String value) {
            addCriterion("yjya_zpjyy =", value, "yjyaZpjyy");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyyNotEqualTo(String value) {
            addCriterion("yjya_zpjyy <>", value, "yjyaZpjyy");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyyGreaterThan(String value) {
            addCriterion("yjya_zpjyy >", value, "yjyaZpjyy");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyyGreaterThanOrEqualTo(String value) {
            addCriterion("yjya_zpjyy >=", value, "yjyaZpjyy");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyyLessThan(String value) {
            addCriterion("yjya_zpjyy <", value, "yjyaZpjyy");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyyLessThanOrEqualTo(String value) {
            addCriterion("yjya_zpjyy <=", value, "yjyaZpjyy");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyyLike(String value) {
            addCriterion("yjya_zpjyy like", value, "yjyaZpjyy");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyyNotLike(String value) {
            addCriterion("yjya_zpjyy not like", value, "yjyaZpjyy");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyyIn(List<String> values) {
            addCriterion("yjya_zpjyy in", values, "yjyaZpjyy");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyyNotIn(List<String> values) {
            addCriterion("yjya_zpjyy not in", values, "yjyaZpjyy");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyyBetween(String value1, String value2) {
            addCriterion("yjya_zpjyy between", value1, value2, "yjyaZpjyy");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyyNotBetween(String value1, String value2) {
            addCriterion("yjya_zpjyy not between", value1, value2, "yjyaZpjyy");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsshrIsNull() {
            addCriterion("yjya_zpjsshr is null");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsshrIsNotNull() {
            addCriterion("yjya_zpjsshr is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsshrEqualTo(String value) {
            addCriterion("yjya_zpjsshr =", value, "yjyaZpjsshr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsshrNotEqualTo(String value) {
            addCriterion("yjya_zpjsshr <>", value, "yjyaZpjsshr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsshrGreaterThan(String value) {
            addCriterion("yjya_zpjsshr >", value, "yjyaZpjsshr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsshrGreaterThanOrEqualTo(String value) {
            addCriterion("yjya_zpjsshr >=", value, "yjyaZpjsshr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsshrLessThan(String value) {
            addCriterion("yjya_zpjsshr <", value, "yjyaZpjsshr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsshrLessThanOrEqualTo(String value) {
            addCriterion("yjya_zpjsshr <=", value, "yjyaZpjsshr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsshrLike(String value) {
            addCriterion("yjya_zpjsshr like", value, "yjyaZpjsshr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsshrNotLike(String value) {
            addCriterion("yjya_zpjsshr not like", value, "yjyaZpjsshr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsshrIn(List<String> values) {
            addCriterion("yjya_zpjsshr in", values, "yjyaZpjsshr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsshrNotIn(List<String> values) {
            addCriterion("yjya_zpjsshr not in", values, "yjyaZpjsshr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsshrBetween(String value1, String value2) {
            addCriterion("yjya_zpjsshr between", value1, value2, "yjyaZpjsshr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjsshrNotBetween(String value1, String value2) {
            addCriterion("yjya_zpjsshr not between", value1, value2, "yjyaZpjsshr");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjshrqIsNull() {
            addCriterion("yjya_zpjshrq is null");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjshrqIsNotNull() {
            addCriterion("yjya_zpjshrq is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjshrqEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_zpjshrq =", value, "yjyaZpjshrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjshrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_zpjshrq <>", value, "yjyaZpjshrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjshrqGreaterThan(Date value) {
            addCriterionForJDBCDate("yjya_zpjshrq >", value, "yjyaZpjshrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjshrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_zpjshrq >=", value, "yjyaZpjshrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjshrqLessThan(Date value) {
            addCriterionForJDBCDate("yjya_zpjshrq <", value, "yjyaZpjshrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjshrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("yjya_zpjshrq <=", value, "yjyaZpjshrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjshrqIn(List<Date> values) {
            addCriterionForJDBCDate("yjya_zpjshrq in", values, "yjyaZpjshrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjshrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("yjya_zpjshrq not in", values, "yjyaZpjshrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjshrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("yjya_zpjshrq between", value1, value2, "yjyaZpjshrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjshrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("yjya_zpjshrq not between", value1, value2, "yjyaZpjshrq");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjjgIsNull() {
            addCriterion("yjya_zpjjg is null");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjjgIsNotNull() {
            addCriterion("yjya_zpjjg is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjjgEqualTo(String value) {
            addCriterion("yjya_zpjjg =", value, "yjyaZpjjg");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjjgNotEqualTo(String value) {
            addCriterion("yjya_zpjjg <>", value, "yjyaZpjjg");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjjgGreaterThan(String value) {
            addCriterion("yjya_zpjjg >", value, "yjyaZpjjg");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjjgGreaterThanOrEqualTo(String value) {
            addCriterion("yjya_zpjjg >=", value, "yjyaZpjjg");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjjgLessThan(String value) {
            addCriterion("yjya_zpjjg <", value, "yjyaZpjjg");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjjgLessThanOrEqualTo(String value) {
            addCriterion("yjya_zpjjg <=", value, "yjyaZpjjg");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjjgLike(String value) {
            addCriterion("yjya_zpjjg like", value, "yjyaZpjjg");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjjgNotLike(String value) {
            addCriterion("yjya_zpjjg not like", value, "yjyaZpjjg");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjjgIn(List<String> values) {
            addCriterion("yjya_zpjjg in", values, "yjyaZpjjg");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjjgNotIn(List<String> values) {
            addCriterion("yjya_zpjjg not in", values, "yjyaZpjjg");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjjgBetween(String value1, String value2) {
            addCriterion("yjya_zpjjg between", value1, value2, "yjyaZpjjg");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjjgNotBetween(String value1, String value2) {
            addCriterion("yjya_zpjjg not between", value1, value2, "yjyaZpjjg");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyjIsNull() {
            addCriterion("yjya_zpjyj is null");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyjIsNotNull() {
            addCriterion("yjya_zpjyj is not null");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyjEqualTo(String value) {
            addCriterion("yjya_zpjyj =", value, "yjyaZpjyj");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyjNotEqualTo(String value) {
            addCriterion("yjya_zpjyj <>", value, "yjyaZpjyj");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyjGreaterThan(String value) {
            addCriterion("yjya_zpjyj >", value, "yjyaZpjyj");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyjGreaterThanOrEqualTo(String value) {
            addCriterion("yjya_zpjyj >=", value, "yjyaZpjyj");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyjLessThan(String value) {
            addCriterion("yjya_zpjyj <", value, "yjyaZpjyj");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyjLessThanOrEqualTo(String value) {
            addCriterion("yjya_zpjyj <=", value, "yjyaZpjyj");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyjLike(String value) {
            addCriterion("yjya_zpjyj like", value, "yjyaZpjyj");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyjNotLike(String value) {
            addCriterion("yjya_zpjyj not like", value, "yjyaZpjyj");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyjIn(List<String> values) {
            addCriterion("yjya_zpjyj in", values, "yjyaZpjyj");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyjNotIn(List<String> values) {
            addCriterion("yjya_zpjyj not in", values, "yjyaZpjyj");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyjBetween(String value1, String value2) {
            addCriterion("yjya_zpjyj between", value1, value2, "yjyaZpjyj");
            return (Criteria) this;
        }

        public Criteria andYjyaZpjyjNotBetween(String value1, String value2) {
            addCriterion("yjya_zpjyj not between", value1, value2, "yjyaZpjyj");
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