package com.litbo.hospital.security.specialequipment.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SpecialEquipmentEmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpecialEquipmentEmployeeExample() {
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

        public Criteria andUserXmIsNull() {
            addCriterion("user_xm is null");
            return (Criteria) this;
        }

        public Criteria andUserXmIsNotNull() {
            addCriterion("user_xm is not null");
            return (Criteria) this;
        }

        public Criteria andUserXmEqualTo(String value) {
            addCriterion("user_xm =", value, "userXm");
            return (Criteria) this;
        }

        public Criteria andUserXmNotEqualTo(String value) {
            addCriterion("user_xm <>", value, "userXm");
            return (Criteria) this;
        }

        public Criteria andUserXmGreaterThan(String value) {
            addCriterion("user_xm >", value, "userXm");
            return (Criteria) this;
        }

        public Criteria andUserXmGreaterThanOrEqualTo(String value) {
            addCriterion("user_xm >=", value, "userXm");
            return (Criteria) this;
        }

        public Criteria andUserXmLessThan(String value) {
            addCriterion("user_xm <", value, "userXm");
            return (Criteria) this;
        }

        public Criteria andUserXmLessThanOrEqualTo(String value) {
            addCriterion("user_xm <=", value, "userXm");
            return (Criteria) this;
        }

        public Criteria andUserXmLike(String value) {
            addCriterion("user_xm like", value, "userXm");
            return (Criteria) this;
        }

        public Criteria andUserXmNotLike(String value) {
            addCriterion("user_xm not like", value, "userXm");
            return (Criteria) this;
        }

        public Criteria andUserXmIn(List<String> values) {
            addCriterion("user_xm in", values, "userXm");
            return (Criteria) this;
        }

        public Criteria andUserXmNotIn(List<String> values) {
            addCriterion("user_xm not in", values, "userXm");
            return (Criteria) this;
        }

        public Criteria andUserXmBetween(String value1, String value2) {
            addCriterion("user_xm between", value1, value2, "userXm");
            return (Criteria) this;
        }

        public Criteria andUserXmNotBetween(String value1, String value2) {
            addCriterion("user_xm not between", value1, value2, "userXm");
            return (Criteria) this;
        }

        public Criteria andBmNameIsNull() {
            addCriterion("bm_name is null");
            return (Criteria) this;
        }

        public Criteria andBmNameIsNotNull() {
            addCriterion("bm_name is not null");
            return (Criteria) this;
        }

        public Criteria andBmNameEqualTo(String value) {
            addCriterion("bm_name =", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameNotEqualTo(String value) {
            addCriterion("bm_name <>", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameGreaterThan(String value) {
            addCriterion("bm_name >", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameGreaterThanOrEqualTo(String value) {
            addCriterion("bm_name >=", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameLessThan(String value) {
            addCriterion("bm_name <", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameLessThanOrEqualTo(String value) {
            addCriterion("bm_name <=", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameLike(String value) {
            addCriterion("bm_name like", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameNotLike(String value) {
            addCriterion("bm_name not like", value, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameIn(List<String> values) {
            addCriterion("bm_name in", values, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameNotIn(List<String> values) {
            addCriterion("bm_name not in", values, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameBetween(String value1, String value2) {
            addCriterion("bm_name between", value1, value2, "bmName");
            return (Criteria) this;
        }

        public Criteria andBmNameNotBetween(String value1, String value2) {
            addCriterion("bm_name not between", value1, value2, "bmName");
            return (Criteria) this;
        }

        public Criteria andSpemSgzzfwIsNull() {
            addCriterion("spem_sgzzfw is null");
            return (Criteria) this;
        }

        public Criteria andSpemSgzzfwIsNotNull() {
            addCriterion("spem_sgzzfw is not null");
            return (Criteria) this;
        }

        public Criteria andSpemSgzzfwEqualTo(String value) {
            addCriterion("spem_sgzzfw =", value, "spemSgzzfw");
            return (Criteria) this;
        }

        public Criteria andSpemSgzzfwNotEqualTo(String value) {
            addCriterion("spem_sgzzfw <>", value, "spemSgzzfw");
            return (Criteria) this;
        }

        public Criteria andSpemSgzzfwGreaterThan(String value) {
            addCriterion("spem_sgzzfw >", value, "spemSgzzfw");
            return (Criteria) this;
        }

        public Criteria andSpemSgzzfwGreaterThanOrEqualTo(String value) {
            addCriterion("spem_sgzzfw >=", value, "spemSgzzfw");
            return (Criteria) this;
        }

        public Criteria andSpemSgzzfwLessThan(String value) {
            addCriterion("spem_sgzzfw <", value, "spemSgzzfw");
            return (Criteria) this;
        }

        public Criteria andSpemSgzzfwLessThanOrEqualTo(String value) {
            addCriterion("spem_sgzzfw <=", value, "spemSgzzfw");
            return (Criteria) this;
        }

        public Criteria andSpemSgzzfwLike(String value) {
            addCriterion("spem_sgzzfw like", value, "spemSgzzfw");
            return (Criteria) this;
        }

        public Criteria andSpemSgzzfwNotLike(String value) {
            addCriterion("spem_sgzzfw not like", value, "spemSgzzfw");
            return (Criteria) this;
        }

        public Criteria andSpemSgzzfwIn(List<String> values) {
            addCriterion("spem_sgzzfw in", values, "spemSgzzfw");
            return (Criteria) this;
        }

        public Criteria andSpemSgzzfwNotIn(List<String> values) {
            addCriterion("spem_sgzzfw not in", values, "spemSgzzfw");
            return (Criteria) this;
        }

        public Criteria andSpemSgzzfwBetween(String value1, String value2) {
            addCriterion("spem_sgzzfw between", value1, value2, "spemSgzzfw");
            return (Criteria) this;
        }

        public Criteria andSpemSgzzfwNotBetween(String value1, String value2) {
            addCriterion("spem_sgzzfw not between", value1, value2, "spemSgzzfw");
            return (Criteria) this;
        }

        public Criteria andSpemZczhIsNull() {
            addCriterion("spem_zczh is null");
            return (Criteria) this;
        }

        public Criteria andSpemZczhIsNotNull() {
            addCriterion("spem_zczh is not null");
            return (Criteria) this;
        }

        public Criteria andSpemZczhEqualTo(String value) {
            addCriterion("spem_zczh =", value, "spemZczh");
            return (Criteria) this;
        }

        public Criteria andSpemZczhNotEqualTo(String value) {
            addCriterion("spem_zczh <>", value, "spemZczh");
            return (Criteria) this;
        }

        public Criteria andSpemZczhGreaterThan(String value) {
            addCriterion("spem_zczh >", value, "spemZczh");
            return (Criteria) this;
        }

        public Criteria andSpemZczhGreaterThanOrEqualTo(String value) {
            addCriterion("spem_zczh >=", value, "spemZczh");
            return (Criteria) this;
        }

        public Criteria andSpemZczhLessThan(String value) {
            addCriterion("spem_zczh <", value, "spemZczh");
            return (Criteria) this;
        }

        public Criteria andSpemZczhLessThanOrEqualTo(String value) {
            addCriterion("spem_zczh <=", value, "spemZczh");
            return (Criteria) this;
        }

        public Criteria andSpemZczhLike(String value) {
            addCriterion("spem_zczh like", value, "spemZczh");
            return (Criteria) this;
        }

        public Criteria andSpemZczhNotLike(String value) {
            addCriterion("spem_zczh not like", value, "spemZczh");
            return (Criteria) this;
        }

        public Criteria andSpemZczhIn(List<String> values) {
            addCriterion("spem_zczh in", values, "spemZczh");
            return (Criteria) this;
        }

        public Criteria andSpemZczhNotIn(List<String> values) {
            addCriterion("spem_zczh not in", values, "spemZczh");
            return (Criteria) this;
        }

        public Criteria andSpemZczhBetween(String value1, String value2) {
            addCriterion("spem_zczh between", value1, value2, "spemZczh");
            return (Criteria) this;
        }

        public Criteria andSpemZczhNotBetween(String value1, String value2) {
            addCriterion("spem_zczh not between", value1, value2, "spemZczh");
            return (Criteria) this;
        }

        public Criteria andSpemQfrqIsNull() {
            addCriterion("spem_qfrq is null");
            return (Criteria) this;
        }

        public Criteria andSpemQfrqIsNotNull() {
            addCriterion("spem_qfrq is not null");
            return (Criteria) this;
        }

        public Criteria andSpemQfrqEqualTo(Date value) {
            addCriterionForJDBCDate("spem_qfrq =", value, "spemQfrq");
            return (Criteria) this;
        }

        public Criteria andSpemQfrqNotEqualTo(Date value) {
            addCriterionForJDBCDate("spem_qfrq <>", value, "spemQfrq");
            return (Criteria) this;
        }

        public Criteria andSpemQfrqGreaterThan(Date value) {
            addCriterionForJDBCDate("spem_qfrq >", value, "spemQfrq");
            return (Criteria) this;
        }

        public Criteria andSpemQfrqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("spem_qfrq >=", value, "spemQfrq");
            return (Criteria) this;
        }

        public Criteria andSpemQfrqLessThan(Date value) {
            addCriterionForJDBCDate("spem_qfrq <", value, "spemQfrq");
            return (Criteria) this;
        }

        public Criteria andSpemQfrqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("spem_qfrq <=", value, "spemQfrq");
            return (Criteria) this;
        }

        public Criteria andSpemQfrqIn(List<Date> values) {
            addCriterionForJDBCDate("spem_qfrq in", values, "spemQfrq");
            return (Criteria) this;
        }

        public Criteria andSpemQfrqNotIn(List<Date> values) {
            addCriterionForJDBCDate("spem_qfrq not in", values, "spemQfrq");
            return (Criteria) this;
        }

        public Criteria andSpemQfrqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("spem_qfrq between", value1, value2, "spemQfrq");
            return (Criteria) this;
        }

        public Criteria andSpemQfrqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("spem_qfrq not between", value1, value2, "spemQfrq");
            return (Criteria) this;
        }

        public Criteria andSpemYxqsqIsNull() {
            addCriterion("spem_yxqsq is null");
            return (Criteria) this;
        }

        public Criteria andSpemYxqsqIsNotNull() {
            addCriterion("spem_yxqsq is not null");
            return (Criteria) this;
        }

        public Criteria andSpemYxqsqEqualTo(Date value) {
            addCriterionForJDBCDate("spem_yxqsq =", value, "spemYxqsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxqsqNotEqualTo(Date value) {
            addCriterionForJDBCDate("spem_yxqsq <>", value, "spemYxqsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxqsqGreaterThan(Date value) {
            addCriterionForJDBCDate("spem_yxqsq >", value, "spemYxqsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxqsqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("spem_yxqsq >=", value, "spemYxqsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxqsqLessThan(Date value) {
            addCriterionForJDBCDate("spem_yxqsq <", value, "spemYxqsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxqsqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("spem_yxqsq <=", value, "spemYxqsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxqsqIn(List<Date> values) {
            addCriterionForJDBCDate("spem_yxqsq in", values, "spemYxqsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxqsqNotIn(List<Date> values) {
            addCriterionForJDBCDate("spem_yxqsq not in", values, "spemYxqsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxqsqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("spem_yxqsq between", value1, value2, "spemYxqsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxqsqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("spem_yxqsq not between", value1, value2, "spemYxqsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxjsqIsNull() {
            addCriterion("spem_yxjsq is null");
            return (Criteria) this;
        }

        public Criteria andSpemYxjsqIsNotNull() {
            addCriterion("spem_yxjsq is not null");
            return (Criteria) this;
        }

        public Criteria andSpemYxjsqEqualTo(Date value) {
            addCriterionForJDBCDate("spem_yxjsq =", value, "spemYxjsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxjsqNotEqualTo(Date value) {
            addCriterionForJDBCDate("spem_yxjsq <>", value, "spemYxjsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxjsqGreaterThan(Date value) {
            addCriterionForJDBCDate("spem_yxjsq >", value, "spemYxjsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxjsqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("spem_yxjsq >=", value, "spemYxjsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxjsqLessThan(Date value) {
            addCriterionForJDBCDate("spem_yxjsq <", value, "spemYxjsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxjsqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("spem_yxjsq <=", value, "spemYxjsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxjsqIn(List<Date> values) {
            addCriterionForJDBCDate("spem_yxjsq in", values, "spemYxjsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxjsqNotIn(List<Date> values) {
            addCriterionForJDBCDate("spem_yxjsq not in", values, "spemYxjsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxjsqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("spem_yxjsq between", value1, value2, "spemYxjsq");
            return (Criteria) this;
        }

        public Criteria andSpemYxjsqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("spem_yxjsq not between", value1, value2, "spemYxjsq");
            return (Criteria) this;
        }

        public Criteria andSpemDabhIsNull() {
            addCriterion("spem_dabh is null");
            return (Criteria) this;
        }

        public Criteria andSpemDabhIsNotNull() {
            addCriterion("spem_dabh is not null");
            return (Criteria) this;
        }

        public Criteria andSpemDabhEqualTo(String value) {
            addCriterion("spem_dabh =", value, "spemDabh");
            return (Criteria) this;
        }

        public Criteria andSpemDabhNotEqualTo(String value) {
            addCriterion("spem_dabh <>", value, "spemDabh");
            return (Criteria) this;
        }

        public Criteria andSpemDabhGreaterThan(String value) {
            addCriterion("spem_dabh >", value, "spemDabh");
            return (Criteria) this;
        }

        public Criteria andSpemDabhGreaterThanOrEqualTo(String value) {
            addCriterion("spem_dabh >=", value, "spemDabh");
            return (Criteria) this;
        }

        public Criteria andSpemDabhLessThan(String value) {
            addCriterion("spem_dabh <", value, "spemDabh");
            return (Criteria) this;
        }

        public Criteria andSpemDabhLessThanOrEqualTo(String value) {
            addCriterion("spem_dabh <=", value, "spemDabh");
            return (Criteria) this;
        }

        public Criteria andSpemDabhLike(String value) {
            addCriterion("spem_dabh like", value, "spemDabh");
            return (Criteria) this;
        }

        public Criteria andSpemDabhNotLike(String value) {
            addCriterion("spem_dabh not like", value, "spemDabh");
            return (Criteria) this;
        }

        public Criteria andSpemDabhIn(List<String> values) {
            addCriterion("spem_dabh in", values, "spemDabh");
            return (Criteria) this;
        }

        public Criteria andSpemDabhNotIn(List<String> values) {
            addCriterion("spem_dabh not in", values, "spemDabh");
            return (Criteria) this;
        }

        public Criteria andSpemDabhBetween(String value1, String value2) {
            addCriterion("spem_dabh between", value1, value2, "spemDabh");
            return (Criteria) this;
        }

        public Criteria andSpemDabhNotBetween(String value1, String value2) {
            addCriterion("spem_dabh not between", value1, value2, "spemDabh");
            return (Criteria) this;
        }

        public Criteria andSpemFzjgIsNull() {
            addCriterion("spem_fzjg is null");
            return (Criteria) this;
        }

        public Criteria andSpemFzjgIsNotNull() {
            addCriterion("spem_fzjg is not null");
            return (Criteria) this;
        }

        public Criteria andSpemFzjgEqualTo(String value) {
            addCriterion("spem_fzjg =", value, "spemFzjg");
            return (Criteria) this;
        }

        public Criteria andSpemFzjgNotEqualTo(String value) {
            addCriterion("spem_fzjg <>", value, "spemFzjg");
            return (Criteria) this;
        }

        public Criteria andSpemFzjgGreaterThan(String value) {
            addCriterion("spem_fzjg >", value, "spemFzjg");
            return (Criteria) this;
        }

        public Criteria andSpemFzjgGreaterThanOrEqualTo(String value) {
            addCriterion("spem_fzjg >=", value, "spemFzjg");
            return (Criteria) this;
        }

        public Criteria andSpemFzjgLessThan(String value) {
            addCriterion("spem_fzjg <", value, "spemFzjg");
            return (Criteria) this;
        }

        public Criteria andSpemFzjgLessThanOrEqualTo(String value) {
            addCriterion("spem_fzjg <=", value, "spemFzjg");
            return (Criteria) this;
        }

        public Criteria andSpemFzjgLike(String value) {
            addCriterion("spem_fzjg like", value, "spemFzjg");
            return (Criteria) this;
        }

        public Criteria andSpemFzjgNotLike(String value) {
            addCriterion("spem_fzjg not like", value, "spemFzjg");
            return (Criteria) this;
        }

        public Criteria andSpemFzjgIn(List<String> values) {
            addCriterion("spem_fzjg in", values, "spemFzjg");
            return (Criteria) this;
        }

        public Criteria andSpemFzjgNotIn(List<String> values) {
            addCriterion("spem_fzjg not in", values, "spemFzjg");
            return (Criteria) this;
        }

        public Criteria andSpemFzjgBetween(String value1, String value2) {
            addCriterion("spem_fzjg between", value1, value2, "spemFzjg");
            return (Criteria) this;
        }

        public Criteria andSpemFzjgNotBetween(String value1, String value2) {
            addCriterion("spem_fzjg not between", value1, value2, "spemFzjg");
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