package com.litbo.hospital.security.inspectionplan.bean.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class InspEqPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InspEqPlanExample() {
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

        public Criteria andInspPlIdIsNull() {
            addCriterion("insp_pl_id is null");
            return (Criteria) this;
        }

        public Criteria andInspPlIdIsNotNull() {
            addCriterion("insp_pl_id is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlIdEqualTo(String value) {
            addCriterion("insp_pl_id =", value, "inspPlId");
            return (Criteria) this;
        }

        public Criteria andInspPlIdNotEqualTo(String value) {
            addCriterion("insp_pl_id <>", value, "inspPlId");
            return (Criteria) this;
        }

        public Criteria andInspPlIdGreaterThan(String value) {
            addCriterion("insp_pl_id >", value, "inspPlId");
            return (Criteria) this;
        }

        public Criteria andInspPlIdGreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_id >=", value, "inspPlId");
            return (Criteria) this;
        }

        public Criteria andInspPlIdLessThan(String value) {
            addCriterion("insp_pl_id <", value, "inspPlId");
            return (Criteria) this;
        }

        public Criteria andInspPlIdLessThanOrEqualTo(String value) {
            addCriterion("insp_pl_id <=", value, "inspPlId");
            return (Criteria) this;
        }

        public Criteria andInspPlIdLike(String value) {
            addCriterion("insp_pl_id like", value, "inspPlId");
            return (Criteria) this;
        }

        public Criteria andInspPlIdNotLike(String value) {
            addCriterion("insp_pl_id not like", value, "inspPlId");
            return (Criteria) this;
        }

        public Criteria andInspPlIdIn(List<String> values) {
            addCriterion("insp_pl_id in", values, "inspPlId");
            return (Criteria) this;
        }

        public Criteria andInspPlIdNotIn(List<String> values) {
            addCriterion("insp_pl_id not in", values, "inspPlId");
            return (Criteria) this;
        }

        public Criteria andInspPlIdBetween(String value1, String value2) {
            addCriterion("insp_pl_id between", value1, value2, "inspPlId");
            return (Criteria) this;
        }

        public Criteria andInspPlIdNotBetween(String value1, String value2) {
            addCriterion("insp_pl_id not between", value1, value2, "inspPlId");
            return (Criteria) this;
        }

        public Criteria andInspPlEqSbbhIsNull() {
            addCriterion("insp_pl_eq_sbbh is null");
            return (Criteria) this;
        }

        public Criteria andInspPlEqSbbhIsNotNull() {
            addCriterion("insp_pl_eq_sbbh is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlEqSbbhEqualTo(String value) {
            addCriterion("insp_pl_eq_sbbh =", value, "inspPlEqSbbh");
            return (Criteria) this;
        }

        public Criteria andInspPlEqSbbhNotEqualTo(String value) {
            addCriterion("insp_pl_eq_sbbh <>", value, "inspPlEqSbbh");
            return (Criteria) this;
        }

        public Criteria andInspPlEqSbbhGreaterThan(String value) {
            addCriterion("insp_pl_eq_sbbh >", value, "inspPlEqSbbh");
            return (Criteria) this;
        }

        public Criteria andInspPlEqSbbhGreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_eq_sbbh >=", value, "inspPlEqSbbh");
            return (Criteria) this;
        }

        public Criteria andInspPlEqSbbhLessThan(String value) {
            addCriterion("insp_pl_eq_sbbh <", value, "inspPlEqSbbh");
            return (Criteria) this;
        }

        public Criteria andInspPlEqSbbhLessThanOrEqualTo(String value) {
            addCriterion("insp_pl_eq_sbbh <=", value, "inspPlEqSbbh");
            return (Criteria) this;
        }

        public Criteria andInspPlEqSbbhLike(String value) {
            addCriterion("insp_pl_eq_sbbh like", value, "inspPlEqSbbh");
            return (Criteria) this;
        }

        public Criteria andInspPlEqSbbhNotLike(String value) {
            addCriterion("insp_pl_eq_sbbh not like", value, "inspPlEqSbbh");
            return (Criteria) this;
        }

        public Criteria andInspPlEqSbbhIn(List<String> values) {
            addCriterion("insp_pl_eq_sbbh in", values, "inspPlEqSbbh");
            return (Criteria) this;
        }

        public Criteria andInspPlEqSbbhNotIn(List<String> values) {
            addCriterion("insp_pl_eq_sbbh not in", values, "inspPlEqSbbh");
            return (Criteria) this;
        }

        public Criteria andInspPlEqSbbhBetween(String value1, String value2) {
            addCriterion("insp_pl_eq_sbbh between", value1, value2, "inspPlEqSbbh");
            return (Criteria) this;
        }

        public Criteria andInspPlEqSbbhNotBetween(String value1, String value2) {
            addCriterion("insp_pl_eq_sbbh not between", value1, value2, "inspPlEqSbbh");
            return (Criteria) this;
        }

        public Criteria andInspPlNameIsNull() {
            addCriterion("insp_pl_name is null");
            return (Criteria) this;
        }

        public Criteria andInspPlNameIsNotNull() {
            addCriterion("insp_pl_name is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlNameEqualTo(String value) {
            addCriterion("insp_pl_name =", value, "inspPlName");
            return (Criteria) this;
        }

        public Criteria andInspPlNameNotEqualTo(String value) {
            addCriterion("insp_pl_name <>", value, "inspPlName");
            return (Criteria) this;
        }

        public Criteria andInspPlNameGreaterThan(String value) {
            addCriterion("insp_pl_name >", value, "inspPlName");
            return (Criteria) this;
        }

        public Criteria andInspPlNameGreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_name >=", value, "inspPlName");
            return (Criteria) this;
        }

        public Criteria andInspPlNameLessThan(String value) {
            addCriterion("insp_pl_name <", value, "inspPlName");
            return (Criteria) this;
        }

        public Criteria andInspPlNameLessThanOrEqualTo(String value) {
            addCriterion("insp_pl_name <=", value, "inspPlName");
            return (Criteria) this;
        }

        public Criteria andInspPlNameLike(String value) {
            addCriterion("insp_pl_name like", value, "inspPlName");
            return (Criteria) this;
        }

        public Criteria andInspPlNameNotLike(String value) {
            addCriterion("insp_pl_name not like", value, "inspPlName");
            return (Criteria) this;
        }

        public Criteria andInspPlNameIn(List<String> values) {
            addCriterion("insp_pl_name in", values, "inspPlName");
            return (Criteria) this;
        }

        public Criteria andInspPlNameNotIn(List<String> values) {
            addCriterion("insp_pl_name not in", values, "inspPlName");
            return (Criteria) this;
        }

        public Criteria andInspPlNameBetween(String value1, String value2) {
            addCriterion("insp_pl_name between", value1, value2, "inspPlName");
            return (Criteria) this;
        }

        public Criteria andInspPlNameNotBetween(String value1, String value2) {
            addCriterion("insp_pl_name not between", value1, value2, "inspPlName");
            return (Criteria) this;
        }

        public Criteria andInspPlCreateTimeIsNull() {
            addCriterion("insp_pl_create_time is null");
            return (Criteria) this;
        }

        public Criteria andInspPlCreateTimeIsNotNull() {
            addCriterion("insp_pl_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("insp_pl_create_time =", value, "inspPlCreateTime");
            return (Criteria) this;
        }

        public Criteria andInspPlCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("insp_pl_create_time <>", value, "inspPlCreateTime");
            return (Criteria) this;
        }

        public Criteria andInspPlCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("insp_pl_create_time >", value, "inspPlCreateTime");
            return (Criteria) this;
        }

        public Criteria andInspPlCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insp_pl_create_time >=", value, "inspPlCreateTime");
            return (Criteria) this;
        }

        public Criteria andInspPlCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("insp_pl_create_time <", value, "inspPlCreateTime");
            return (Criteria) this;
        }

        public Criteria andInspPlCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insp_pl_create_time <=", value, "inspPlCreateTime");
            return (Criteria) this;
        }

        public Criteria andInspPlCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("insp_pl_create_time in", values, "inspPlCreateTime");
            return (Criteria) this;
        }

        public Criteria andInspPlCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("insp_pl_create_time not in", values, "inspPlCreateTime");
            return (Criteria) this;
        }

        public Criteria andInspPlCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insp_pl_create_time between", value1, value2, "inspPlCreateTime");
            return (Criteria) this;
        }

        public Criteria andInspPlCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insp_pl_create_time not between", value1, value2, "inspPlCreateTime");
            return (Criteria) this;
        }

        public Criteria andInspPlPlannerIsNull() {
            addCriterion("insp_pl_planner is null");
            return (Criteria) this;
        }

        public Criteria andInspPlPlannerIsNotNull() {
            addCriterion("insp_pl_planner is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlPlannerEqualTo(String value) {
            addCriterion("insp_pl_planner =", value, "inspPlPlanner");
            return (Criteria) this;
        }

        public Criteria andInspPlPlannerNotEqualTo(String value) {
            addCriterion("insp_pl_planner <>", value, "inspPlPlanner");
            return (Criteria) this;
        }

        public Criteria andInspPlPlannerGreaterThan(String value) {
            addCriterion("insp_pl_planner >", value, "inspPlPlanner");
            return (Criteria) this;
        }

        public Criteria andInspPlPlannerGreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_planner >=", value, "inspPlPlanner");
            return (Criteria) this;
        }

        public Criteria andInspPlPlannerLessThan(String value) {
            addCriterion("insp_pl_planner <", value, "inspPlPlanner");
            return (Criteria) this;
        }

        public Criteria andInspPlPlannerLessThanOrEqualTo(String value) {
            addCriterion("insp_pl_planner <=", value, "inspPlPlanner");
            return (Criteria) this;
        }

        public Criteria andInspPlPlannerLike(String value) {
            addCriterion("insp_pl_planner like", value, "inspPlPlanner");
            return (Criteria) this;
        }

        public Criteria andInspPlPlannerNotLike(String value) {
            addCriterion("insp_pl_planner not like", value, "inspPlPlanner");
            return (Criteria) this;
        }

        public Criteria andInspPlPlannerIn(List<String> values) {
            addCriterion("insp_pl_planner in", values, "inspPlPlanner");
            return (Criteria) this;
        }

        public Criteria andInspPlPlannerNotIn(List<String> values) {
            addCriterion("insp_pl_planner not in", values, "inspPlPlanner");
            return (Criteria) this;
        }

        public Criteria andInspPlPlannerBetween(String value1, String value2) {
            addCriterion("insp_pl_planner between", value1, value2, "inspPlPlanner");
            return (Criteria) this;
        }

        public Criteria andInspPlPlannerNotBetween(String value1, String value2) {
            addCriterion("insp_pl_planner not between", value1, value2, "inspPlPlanner");
            return (Criteria) this;
        }

        public Criteria andInspPlAuditorIsNull() {
            addCriterion("insp_pl_auditor is null");
            return (Criteria) this;
        }

        public Criteria andInspPlAuditorIsNotNull() {
            addCriterion("insp_pl_auditor is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlAuditorEqualTo(String value) {
            addCriterion("insp_pl_auditor =", value, "inspPlAuditor");
            return (Criteria) this;
        }

        public Criteria andInspPlAuditorNotEqualTo(String value) {
            addCriterion("insp_pl_auditor <>", value, "inspPlAuditor");
            return (Criteria) this;
        }

        public Criteria andInspPlAuditorGreaterThan(String value) {
            addCriterion("insp_pl_auditor >", value, "inspPlAuditor");
            return (Criteria) this;
        }

        public Criteria andInspPlAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_auditor >=", value, "inspPlAuditor");
            return (Criteria) this;
        }

        public Criteria andInspPlAuditorLessThan(String value) {
            addCriterion("insp_pl_auditor <", value, "inspPlAuditor");
            return (Criteria) this;
        }

        public Criteria andInspPlAuditorLessThanOrEqualTo(String value) {
            addCriterion("insp_pl_auditor <=", value, "inspPlAuditor");
            return (Criteria) this;
        }

        public Criteria andInspPlAuditorLike(String value) {
            addCriterion("insp_pl_auditor like", value, "inspPlAuditor");
            return (Criteria) this;
        }

        public Criteria andInspPlAuditorNotLike(String value) {
            addCriterion("insp_pl_auditor not like", value, "inspPlAuditor");
            return (Criteria) this;
        }

        public Criteria andInspPlAuditorIn(List<String> values) {
            addCriterion("insp_pl_auditor in", values, "inspPlAuditor");
            return (Criteria) this;
        }

        public Criteria andInspPlAuditorNotIn(List<String> values) {
            addCriterion("insp_pl_auditor not in", values, "inspPlAuditor");
            return (Criteria) this;
        }

        public Criteria andInspPlAuditorBetween(String value1, String value2) {
            addCriterion("insp_pl_auditor between", value1, value2, "inspPlAuditor");
            return (Criteria) this;
        }

        public Criteria andInspPlAuditorNotBetween(String value1, String value2) {
            addCriterion("insp_pl_auditor not between", value1, value2, "inspPlAuditor");
            return (Criteria) this;
        }

        public Criteria andInspPlNoteIsNull() {
            addCriterion("insp_pl_note is null");
            return (Criteria) this;
        }

        public Criteria andInspPlNoteIsNotNull() {
            addCriterion("insp_pl_note is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlNoteEqualTo(String value) {
            addCriterion("insp_pl_note =", value, "inspPlNote");
            return (Criteria) this;
        }

        public Criteria andInspPlNoteNotEqualTo(String value) {
            addCriterion("insp_pl_note <>", value, "inspPlNote");
            return (Criteria) this;
        }

        public Criteria andInspPlNoteGreaterThan(String value) {
            addCriterion("insp_pl_note >", value, "inspPlNote");
            return (Criteria) this;
        }

        public Criteria andInspPlNoteGreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_note >=", value, "inspPlNote");
            return (Criteria) this;
        }

        public Criteria andInspPlNoteLessThan(String value) {
            addCriterion("insp_pl_note <", value, "inspPlNote");
            return (Criteria) this;
        }

        public Criteria andInspPlNoteLessThanOrEqualTo(String value) {
            addCriterion("insp_pl_note <=", value, "inspPlNote");
            return (Criteria) this;
        }

        public Criteria andInspPlNoteLike(String value) {
            addCriterion("insp_pl_note like", value, "inspPlNote");
            return (Criteria) this;
        }

        public Criteria andInspPlNoteNotLike(String value) {
            addCriterion("insp_pl_note not like", value, "inspPlNote");
            return (Criteria) this;
        }

        public Criteria andInspPlNoteIn(List<String> values) {
            addCriterion("insp_pl_note in", values, "inspPlNote");
            return (Criteria) this;
        }

        public Criteria andInspPlNoteNotIn(List<String> values) {
            addCriterion("insp_pl_note not in", values, "inspPlNote");
            return (Criteria) this;
        }

        public Criteria andInspPlNoteBetween(String value1, String value2) {
            addCriterion("insp_pl_note between", value1, value2, "inspPlNote");
            return (Criteria) this;
        }

        public Criteria andInspPlNoteNotBetween(String value1, String value2) {
            addCriterion("insp_pl_note not between", value1, value2, "inspPlNote");
            return (Criteria) this;
        }

        public Criteria andInspPlStatusIsNull() {
            addCriterion("insp_pl_status is null");
            return (Criteria) this;
        }

        public Criteria andInspPlStatusIsNotNull() {
            addCriterion("insp_pl_status is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlStatusEqualTo(String value) {
            addCriterion("insp_pl_status =", value, "inspPlStatus");
            return (Criteria) this;
        }

        public Criteria andInspPlStatusNotEqualTo(String value) {
            addCriterion("insp_pl_status <>", value, "inspPlStatus");
            return (Criteria) this;
        }

        public Criteria andInspPlStatusGreaterThan(String value) {
            addCriterion("insp_pl_status >", value, "inspPlStatus");
            return (Criteria) this;
        }

        public Criteria andInspPlStatusGreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_status >=", value, "inspPlStatus");
            return (Criteria) this;
        }

        public Criteria andInspPlStatusLessThan(String value) {
            addCriterion("insp_pl_status <", value, "inspPlStatus");
            return (Criteria) this;
        }

        public Criteria andInspPlStatusLessThanOrEqualTo(String value) {
            addCriterion("insp_pl_status <=", value, "inspPlStatus");
            return (Criteria) this;
        }

        public Criteria andInspPlStatusLike(String value) {
            addCriterion("insp_pl_status like", value, "inspPlStatus");
            return (Criteria) this;
        }

        public Criteria andInspPlStatusNotLike(String value) {
            addCriterion("insp_pl_status not like", value, "inspPlStatus");
            return (Criteria) this;
        }

        public Criteria andInspPlStatusIn(List<String> values) {
            addCriterion("insp_pl_status in", values, "inspPlStatus");
            return (Criteria) this;
        }

        public Criteria andInspPlStatusNotIn(List<String> values) {
            addCriterion("insp_pl_status not in", values, "inspPlStatus");
            return (Criteria) this;
        }

        public Criteria andInspPlStatusBetween(String value1, String value2) {
            addCriterion("insp_pl_status between", value1, value2, "inspPlStatus");
            return (Criteria) this;
        }

        public Criteria andInspPlStatusNotBetween(String value1, String value2) {
            addCriterion("insp_pl_status not between", value1, value2, "inspPlStatus");
            return (Criteria) this;
        }

        public Criteria andInspPlExecutorTypeIsNull() {
            addCriterion("insp_pl_executor_type is null");
            return (Criteria) this;
        }

        public Criteria andInspPlExecutorTypeIsNotNull() {
            addCriterion("insp_pl_executor_type is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlExecutorTypeEqualTo(String value) {
            addCriterion("insp_pl_executor_type =", value, "inspPlExecutorType");
            return (Criteria) this;
        }

        public Criteria andInspPlExecutorTypeNotEqualTo(String value) {
            addCriterion("insp_pl_executor_type <>", value, "inspPlExecutorType");
            return (Criteria) this;
        }

        public Criteria andInspPlExecutorTypeGreaterThan(String value) {
            addCriterion("insp_pl_executor_type >", value, "inspPlExecutorType");
            return (Criteria) this;
        }

        public Criteria andInspPlExecutorTypeGreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_executor_type >=", value, "inspPlExecutorType");
            return (Criteria) this;
        }

        public Criteria andInspPlExecutorTypeLessThan(String value) {
            addCriterion("insp_pl_executor_type <", value, "inspPlExecutorType");
            return (Criteria) this;
        }

        public Criteria andInspPlExecutorTypeLessThanOrEqualTo(String value) {
            addCriterion("insp_pl_executor_type <=", value, "inspPlExecutorType");
            return (Criteria) this;
        }

        public Criteria andInspPlExecutorTypeLike(String value) {
            addCriterion("insp_pl_executor_type like", value, "inspPlExecutorType");
            return (Criteria) this;
        }

        public Criteria andInspPlExecutorTypeNotLike(String value) {
            addCriterion("insp_pl_executor_type not like", value, "inspPlExecutorType");
            return (Criteria) this;
        }

        public Criteria andInspPlExecutorTypeIn(List<String> values) {
            addCriterion("insp_pl_executor_type in", values, "inspPlExecutorType");
            return (Criteria) this;
        }

        public Criteria andInspPlExecutorTypeNotIn(List<String> values) {
            addCriterion("insp_pl_executor_type not in", values, "inspPlExecutorType");
            return (Criteria) this;
        }

        public Criteria andInspPlExecutorTypeBetween(String value1, String value2) {
            addCriterion("insp_pl_executor_type between", value1, value2, "inspPlExecutorType");
            return (Criteria) this;
        }

        public Criteria andInspPlExecutorTypeNotBetween(String value1, String value2) {
            addCriterion("insp_pl_executor_type not between", value1, value2, "inspPlExecutorType");
            return (Criteria) this;
        }

        public Criteria andInspPlTypeIsNull() {
            addCriterion("insp_pl_type is null");
            return (Criteria) this;
        }

        public Criteria andInspPlTypeIsNotNull() {
            addCriterion("insp_pl_type is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlTypeEqualTo(String value) {
            addCriterion("insp_pl_type =", value, "inspPlType");
            return (Criteria) this;
        }

        public Criteria andInspPlTypeNotEqualTo(String value) {
            addCriterion("insp_pl_type <>", value, "inspPlType");
            return (Criteria) this;
        }

        public Criteria andInspPlTypeGreaterThan(String value) {
            addCriterion("insp_pl_type >", value, "inspPlType");
            return (Criteria) this;
        }

        public Criteria andInspPlTypeGreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_type >=", value, "inspPlType");
            return (Criteria) this;
        }

        public Criteria andInspPlTypeLessThan(String value) {
            addCriterion("insp_pl_type <", value, "inspPlType");
            return (Criteria) this;
        }

        public Criteria andInspPlTypeLessThanOrEqualTo(String value) {
            addCriterion("insp_pl_type <=", value, "inspPlType");
            return (Criteria) this;
        }

        public Criteria andInspPlTypeLike(String value) {
            addCriterion("insp_pl_type like", value, "inspPlType");
            return (Criteria) this;
        }

        public Criteria andInspPlTypeNotLike(String value) {
            addCriterion("insp_pl_type not like", value, "inspPlType");
            return (Criteria) this;
        }

        public Criteria andInspPlTypeIn(List<String> values) {
            addCriterion("insp_pl_type in", values, "inspPlType");
            return (Criteria) this;
        }

        public Criteria andInspPlTypeNotIn(List<String> values) {
            addCriterion("insp_pl_type not in", values, "inspPlType");
            return (Criteria) this;
        }

        public Criteria andInspPlTypeBetween(String value1, String value2) {
            addCriterion("insp_pl_type between", value1, value2, "inspPlType");
            return (Criteria) this;
        }

        public Criteria andInspPlTypeNotBetween(String value1, String value2) {
            addCriterion("insp_pl_type not between", value1, value2, "inspPlType");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodIsNull() {
            addCriterion("insp_pl_period is null");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodIsNotNull() {
            addCriterion("insp_pl_period is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodEqualTo(String value) {
            addCriterion("insp_pl_period =", value, "inspPlPeriod");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodNotEqualTo(String value) {
            addCriterion("insp_pl_period <>", value, "inspPlPeriod");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodGreaterThan(String value) {
            addCriterion("insp_pl_period >", value, "inspPlPeriod");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_period >=", value, "inspPlPeriod");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodLessThan(String value) {
            addCriterion("insp_pl_period <", value, "inspPlPeriod");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodLessThanOrEqualTo(String value) {
            addCriterion("insp_pl_period <=", value, "inspPlPeriod");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodLike(String value) {
            addCriterion("insp_pl_period like", value, "inspPlPeriod");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodNotLike(String value) {
            addCriterion("insp_pl_period not like", value, "inspPlPeriod");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodIn(List<String> values) {
            addCriterion("insp_pl_period in", values, "inspPlPeriod");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodNotIn(List<String> values) {
            addCriterion("insp_pl_period not in", values, "inspPlPeriod");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodBetween(String value1, String value2) {
            addCriterion("insp_pl_period between", value1, value2, "inspPlPeriod");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodNotBetween(String value1, String value2) {
            addCriterion("insp_pl_period not between", value1, value2, "inspPlPeriod");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodicUnitIsNull() {
            addCriterion("insp_pl_periodic_unit is null");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodicUnitIsNotNull() {
            addCriterion("insp_pl_periodic_unit is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodicUnitEqualTo(Integer value) {
            addCriterion("insp_pl_periodic_unit =", value, "inspPlPeriodicUnit");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodicUnitNotEqualTo(Integer value) {
            addCriterion("insp_pl_periodic_unit <>", value, "inspPlPeriodicUnit");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodicUnitGreaterThan(Integer value) {
            addCriterion("insp_pl_periodic_unit >", value, "inspPlPeriodicUnit");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodicUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("insp_pl_periodic_unit >=", value, "inspPlPeriodicUnit");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodicUnitLessThan(Integer value) {
            addCriterion("insp_pl_periodic_unit <", value, "inspPlPeriodicUnit");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodicUnitLessThanOrEqualTo(Integer value) {
            addCriterion("insp_pl_periodic_unit <=", value, "inspPlPeriodicUnit");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodicUnitIn(List<Integer> values) {
            addCriterion("insp_pl_periodic_unit in", values, "inspPlPeriodicUnit");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodicUnitNotIn(List<Integer> values) {
            addCriterion("insp_pl_periodic_unit not in", values, "inspPlPeriodicUnit");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodicUnitBetween(Integer value1, Integer value2) {
            addCriterion("insp_pl_periodic_unit between", value1, value2, "inspPlPeriodicUnit");
            return (Criteria) this;
        }

        public Criteria andInspPlPeriodicUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("insp_pl_periodic_unit not between", value1, value2, "inspPlPeriodicUnit");
            return (Criteria) this;
        }

        public Criteria andInspPlLastTimeIsNull() {
            addCriterion("insp_pl_last_time is null");
            return (Criteria) this;
        }

        public Criteria andInspPlLastTimeIsNotNull() {
            addCriterion("insp_pl_last_time is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlLastTimeEqualTo(Date value) {
            addCriterionForJDBCDate("insp_pl_last_time =", value, "inspPlLastTime");
            return (Criteria) this;
        }

        public Criteria andInspPlLastTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("insp_pl_last_time <>", value, "inspPlLastTime");
            return (Criteria) this;
        }

        public Criteria andInspPlLastTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("insp_pl_last_time >", value, "inspPlLastTime");
            return (Criteria) this;
        }

        public Criteria andInspPlLastTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insp_pl_last_time >=", value, "inspPlLastTime");
            return (Criteria) this;
        }

        public Criteria andInspPlLastTimeLessThan(Date value) {
            addCriterionForJDBCDate("insp_pl_last_time <", value, "inspPlLastTime");
            return (Criteria) this;
        }

        public Criteria andInspPlLastTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insp_pl_last_time <=", value, "inspPlLastTime");
            return (Criteria) this;
        }

        public Criteria andInspPlLastTimeIn(List<Date> values) {
            addCriterionForJDBCDate("insp_pl_last_time in", values, "inspPlLastTime");
            return (Criteria) this;
        }

        public Criteria andInspPlLastTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("insp_pl_last_time not in", values, "inspPlLastTime");
            return (Criteria) this;
        }

        public Criteria andInspPlLastTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insp_pl_last_time between", value1, value2, "inspPlLastTime");
            return (Criteria) this;
        }

        public Criteria andInspPlLastTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insp_pl_last_time not between", value1, value2, "inspPlLastTime");
            return (Criteria) this;
        }

        public Criteria andInspPlChangeReasonIsNull() {
            addCriterion("insp_pl_change_reason is null");
            return (Criteria) this;
        }

        public Criteria andInspPlChangeReasonIsNotNull() {
            addCriterion("insp_pl_change_reason is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlChangeReasonEqualTo(String value) {
            addCriterion("insp_pl_change_reason =", value, "inspPlChangeReason");
            return (Criteria) this;
        }

        public Criteria andInspPlChangeReasonNotEqualTo(String value) {
            addCriterion("insp_pl_change_reason <>", value, "inspPlChangeReason");
            return (Criteria) this;
        }

        public Criteria andInspPlChangeReasonGreaterThan(String value) {
            addCriterion("insp_pl_change_reason >", value, "inspPlChangeReason");
            return (Criteria) this;
        }

        public Criteria andInspPlChangeReasonGreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_change_reason >=", value, "inspPlChangeReason");
            return (Criteria) this;
        }

        public Criteria andInspPlChangeReasonLessThan(String value) {
            addCriterion("insp_pl_change_reason <", value, "inspPlChangeReason");
            return (Criteria) this;
        }

        public Criteria andInspPlChangeReasonLessThanOrEqualTo(String value) {
            addCriterion("insp_pl_change_reason <=", value, "inspPlChangeReason");
            return (Criteria) this;
        }

        public Criteria andInspPlChangeReasonLike(String value) {
            addCriterion("insp_pl_change_reason like", value, "inspPlChangeReason");
            return (Criteria) this;
        }

        public Criteria andInspPlChangeReasonNotLike(String value) {
            addCriterion("insp_pl_change_reason not like", value, "inspPlChangeReason");
            return (Criteria) this;
        }

        public Criteria andInspPlChangeReasonIn(List<String> values) {
            addCriterion("insp_pl_change_reason in", values, "inspPlChangeReason");
            return (Criteria) this;
        }

        public Criteria andInspPlChangeReasonNotIn(List<String> values) {
            addCriterion("insp_pl_change_reason not in", values, "inspPlChangeReason");
            return (Criteria) this;
        }

        public Criteria andInspPlChangeReasonBetween(String value1, String value2) {
            addCriterion("insp_pl_change_reason between", value1, value2, "inspPlChangeReason");
            return (Criteria) this;
        }

        public Criteria andInspPlChangeReasonNotBetween(String value1, String value2) {
            addCriterion("insp_pl_change_reason not between", value1, value2, "inspPlChangeReason");
            return (Criteria) this;
        }

        public Criteria andInspPlPlanExecuteTimeIsNull() {
            addCriterion("insp_pl_plan_execute_time is null");
            return (Criteria) this;
        }

        public Criteria andInspPlPlanExecuteTimeIsNotNull() {
            addCriterion("insp_pl_plan_execute_time is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlPlanExecuteTimeEqualTo(Date value) {
            addCriterionForJDBCDate("insp_pl_plan_execute_time =", value, "inspPlPlanExecuteTime");
            return (Criteria) this;
        }

        public Criteria andInspPlPlanExecuteTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("insp_pl_plan_execute_time <>", value, "inspPlPlanExecuteTime");
            return (Criteria) this;
        }

        public Criteria andInspPlPlanExecuteTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("insp_pl_plan_execute_time >", value, "inspPlPlanExecuteTime");
            return (Criteria) this;
        }

        public Criteria andInspPlPlanExecuteTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insp_pl_plan_execute_time >=", value, "inspPlPlanExecuteTime");
            return (Criteria) this;
        }

        public Criteria andInspPlPlanExecuteTimeLessThan(Date value) {
            addCriterionForJDBCDate("insp_pl_plan_execute_time <", value, "inspPlPlanExecuteTime");
            return (Criteria) this;
        }

        public Criteria andInspPlPlanExecuteTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insp_pl_plan_execute_time <=", value, "inspPlPlanExecuteTime");
            return (Criteria) this;
        }

        public Criteria andInspPlPlanExecuteTimeIn(List<Date> values) {
            addCriterionForJDBCDate("insp_pl_plan_execute_time in", values, "inspPlPlanExecuteTime");
            return (Criteria) this;
        }

        public Criteria andInspPlPlanExecuteTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("insp_pl_plan_execute_time not in", values, "inspPlPlanExecuteTime");
            return (Criteria) this;
        }

        public Criteria andInspPlPlanExecuteTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insp_pl_plan_execute_time between", value1, value2, "inspPlPlanExecuteTime");
            return (Criteria) this;
        }

        public Criteria andInspPlPlanExecuteTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insp_pl_plan_execute_time not between", value1, value2, "inspPlPlanExecuteTime");
            return (Criteria) this;
        }

        public Criteria andInspPlEqStandardsIsNull() {
            addCriterion("insp_pl_eq_standards is null");
            return (Criteria) this;
        }

        public Criteria andInspPlEqStandardsIsNotNull() {
            addCriterion("insp_pl_eq_standards is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlEqStandardsEqualTo(String value) {
            addCriterion("insp_pl_eq_standards =", value, "inspPlEqStandards");
            return (Criteria) this;
        }

        public Criteria andInspPlEqStandardsNotEqualTo(String value) {
            addCriterion("insp_pl_eq_standards <>", value, "inspPlEqStandards");
            return (Criteria) this;
        }

        public Criteria andInspPlEqStandardsGreaterThan(String value) {
            addCriterion("insp_pl_eq_standards >", value, "inspPlEqStandards");
            return (Criteria) this;
        }

        public Criteria andInspPlEqStandardsGreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_eq_standards >=", value, "inspPlEqStandards");
            return (Criteria) this;
        }

        public Criteria andInspPlEqStandardsLessThan(String value) {
            addCriterion("insp_pl_eq_standards <", value, "inspPlEqStandards");
            return (Criteria) this;
        }

        public Criteria andInspPlEqStandardsLessThanOrEqualTo(String value) {
            addCriterion("insp_pl_eq_standards <=", value, "inspPlEqStandards");
            return (Criteria) this;
        }

        public Criteria andInspPlEqStandardsLike(String value) {
            addCriterion("insp_pl_eq_standards like", value, "inspPlEqStandards");
            return (Criteria) this;
        }

        public Criteria andInspPlEqStandardsNotLike(String value) {
            addCriterion("insp_pl_eq_standards not like", value, "inspPlEqStandards");
            return (Criteria) this;
        }

        public Criteria andInspPlEqStandardsIn(List<String> values) {
            addCriterion("insp_pl_eq_standards in", values, "inspPlEqStandards");
            return (Criteria) this;
        }

        public Criteria andInspPlEqStandardsNotIn(List<String> values) {
            addCriterion("insp_pl_eq_standards not in", values, "inspPlEqStandards");
            return (Criteria) this;
        }

        public Criteria andInspPlEqStandardsBetween(String value1, String value2) {
            addCriterion("insp_pl_eq_standards between", value1, value2, "inspPlEqStandards");
            return (Criteria) this;
        }

        public Criteria andInspPlEqStandardsNotBetween(String value1, String value2) {
            addCriterion("insp_pl_eq_standards not between", value1, value2, "inspPlEqStandards");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare1IsNull() {
            addCriterion("insp_pl_sprare1 is null");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare1IsNotNull() {
            addCriterion("insp_pl_sprare1 is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare1EqualTo(String value) {
            addCriterion("insp_pl_sprare1 =", value, "inspPlSprare1");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare1NotEqualTo(String value) {
            addCriterion("insp_pl_sprare1 <>", value, "inspPlSprare1");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare1GreaterThan(String value) {
            addCriterion("insp_pl_sprare1 >", value, "inspPlSprare1");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare1GreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_sprare1 >=", value, "inspPlSprare1");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare1LessThan(String value) {
            addCriterion("insp_pl_sprare1 <", value, "inspPlSprare1");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare1LessThanOrEqualTo(String value) {
            addCriterion("insp_pl_sprare1 <=", value, "inspPlSprare1");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare1Like(String value) {
            addCriterion("insp_pl_sprare1 like", value, "inspPlSprare1");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare1NotLike(String value) {
            addCriterion("insp_pl_sprare1 not like", value, "inspPlSprare1");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare1In(List<String> values) {
            addCriterion("insp_pl_sprare1 in", values, "inspPlSprare1");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare1NotIn(List<String> values) {
            addCriterion("insp_pl_sprare1 not in", values, "inspPlSprare1");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare1Between(String value1, String value2) {
            addCriterion("insp_pl_sprare1 between", value1, value2, "inspPlSprare1");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare1NotBetween(String value1, String value2) {
            addCriterion("insp_pl_sprare1 not between", value1, value2, "inspPlSprare1");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare2IsNull() {
            addCriterion("insp_pl_sprare2 is null");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare2IsNotNull() {
            addCriterion("insp_pl_sprare2 is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare2EqualTo(String value) {
            addCriterion("insp_pl_sprare2 =", value, "inspPlSprare2");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare2NotEqualTo(String value) {
            addCriterion("insp_pl_sprare2 <>", value, "inspPlSprare2");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare2GreaterThan(String value) {
            addCriterion("insp_pl_sprare2 >", value, "inspPlSprare2");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare2GreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_sprare2 >=", value, "inspPlSprare2");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare2LessThan(String value) {
            addCriterion("insp_pl_sprare2 <", value, "inspPlSprare2");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare2LessThanOrEqualTo(String value) {
            addCriterion("insp_pl_sprare2 <=", value, "inspPlSprare2");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare2Like(String value) {
            addCriterion("insp_pl_sprare2 like", value, "inspPlSprare2");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare2NotLike(String value) {
            addCriterion("insp_pl_sprare2 not like", value, "inspPlSprare2");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare2In(List<String> values) {
            addCriterion("insp_pl_sprare2 in", values, "inspPlSprare2");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare2NotIn(List<String> values) {
            addCriterion("insp_pl_sprare2 not in", values, "inspPlSprare2");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare2Between(String value1, String value2) {
            addCriterion("insp_pl_sprare2 between", value1, value2, "inspPlSprare2");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare2NotBetween(String value1, String value2) {
            addCriterion("insp_pl_sprare2 not between", value1, value2, "inspPlSprare2");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare3IsNull() {
            addCriterion("insp_pl_sprare3 is null");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare3IsNotNull() {
            addCriterion("insp_pl_sprare3 is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare3EqualTo(String value) {
            addCriterion("insp_pl_sprare3 =", value, "inspPlSprare3");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare3NotEqualTo(String value) {
            addCriterion("insp_pl_sprare3 <>", value, "inspPlSprare3");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare3GreaterThan(String value) {
            addCriterion("insp_pl_sprare3 >", value, "inspPlSprare3");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare3GreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_sprare3 >=", value, "inspPlSprare3");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare3LessThan(String value) {
            addCriterion("insp_pl_sprare3 <", value, "inspPlSprare3");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare3LessThanOrEqualTo(String value) {
            addCriterion("insp_pl_sprare3 <=", value, "inspPlSprare3");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare3Like(String value) {
            addCriterion("insp_pl_sprare3 like", value, "inspPlSprare3");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare3NotLike(String value) {
            addCriterion("insp_pl_sprare3 not like", value, "inspPlSprare3");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare3In(List<String> values) {
            addCriterion("insp_pl_sprare3 in", values, "inspPlSprare3");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare3NotIn(List<String> values) {
            addCriterion("insp_pl_sprare3 not in", values, "inspPlSprare3");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare3Between(String value1, String value2) {
            addCriterion("insp_pl_sprare3 between", value1, value2, "inspPlSprare3");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare3NotBetween(String value1, String value2) {
            addCriterion("insp_pl_sprare3 not between", value1, value2, "inspPlSprare3");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare4IsNull() {
            addCriterion("insp_pl_sprare4 is null");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare4IsNotNull() {
            addCriterion("insp_pl_sprare4 is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare4EqualTo(String value) {
            addCriterion("insp_pl_sprare4 =", value, "inspPlSprare4");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare4NotEqualTo(String value) {
            addCriterion("insp_pl_sprare4 <>", value, "inspPlSprare4");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare4GreaterThan(String value) {
            addCriterion("insp_pl_sprare4 >", value, "inspPlSprare4");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare4GreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_sprare4 >=", value, "inspPlSprare4");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare4LessThan(String value) {
            addCriterion("insp_pl_sprare4 <", value, "inspPlSprare4");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare4LessThanOrEqualTo(String value) {
            addCriterion("insp_pl_sprare4 <=", value, "inspPlSprare4");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare4Like(String value) {
            addCriterion("insp_pl_sprare4 like", value, "inspPlSprare4");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare4NotLike(String value) {
            addCriterion("insp_pl_sprare4 not like", value, "inspPlSprare4");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare4In(List<String> values) {
            addCriterion("insp_pl_sprare4 in", values, "inspPlSprare4");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare4NotIn(List<String> values) {
            addCriterion("insp_pl_sprare4 not in", values, "inspPlSprare4");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare4Between(String value1, String value2) {
            addCriterion("insp_pl_sprare4 between", value1, value2, "inspPlSprare4");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare4NotBetween(String value1, String value2) {
            addCriterion("insp_pl_sprare4 not between", value1, value2, "inspPlSprare4");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare5IsNull() {
            addCriterion("insp_pl_sprare5 is null");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare5IsNotNull() {
            addCriterion("insp_pl_sprare5 is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare5EqualTo(String value) {
            addCriterion("insp_pl_sprare5 =", value, "inspPlSprare5");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare5NotEqualTo(String value) {
            addCriterion("insp_pl_sprare5 <>", value, "inspPlSprare5");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare5GreaterThan(String value) {
            addCriterion("insp_pl_sprare5 >", value, "inspPlSprare5");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare5GreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_sprare5 >=", value, "inspPlSprare5");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare5LessThan(String value) {
            addCriterion("insp_pl_sprare5 <", value, "inspPlSprare5");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare5LessThanOrEqualTo(String value) {
            addCriterion("insp_pl_sprare5 <=", value, "inspPlSprare5");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare5Like(String value) {
            addCriterion("insp_pl_sprare5 like", value, "inspPlSprare5");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare5NotLike(String value) {
            addCriterion("insp_pl_sprare5 not like", value, "inspPlSprare5");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare5In(List<String> values) {
            addCriterion("insp_pl_sprare5 in", values, "inspPlSprare5");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare5NotIn(List<String> values) {
            addCriterion("insp_pl_sprare5 not in", values, "inspPlSprare5");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare5Between(String value1, String value2) {
            addCriterion("insp_pl_sprare5 between", value1, value2, "inspPlSprare5");
            return (Criteria) this;
        }

        public Criteria andInspPlSprare5NotBetween(String value1, String value2) {
            addCriterion("insp_pl_sprare5 not between", value1, value2, "inspPlSprare5");
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