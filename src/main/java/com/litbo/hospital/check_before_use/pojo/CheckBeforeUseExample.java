package com.litbo.hospital.check_before_use.pojo;

import java.util.ArrayList;
import java.util.List;

public class CheckBeforeUseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckBeforeUseExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCheckPersonIsNull() {
            addCriterion("check_person is null");
            return (Criteria) this;
        }

        public Criteria andCheckPersonIsNotNull() {
            addCriterion("check_person is not null");
            return (Criteria) this;
        }

        public Criteria andCheckPersonEqualTo(String value) {
            addCriterion("check_person =", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonNotEqualTo(String value) {
            addCriterion("check_person <>", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonGreaterThan(String value) {
            addCriterion("check_person >", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonGreaterThanOrEqualTo(String value) {
            addCriterion("check_person >=", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonLessThan(String value) {
            addCriterion("check_person <", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonLessThanOrEqualTo(String value) {
            addCriterion("check_person <=", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonLike(String value) {
            addCriterion("check_person like", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonNotLike(String value) {
            addCriterion("check_person not like", value, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonIn(List<String> values) {
            addCriterion("check_person in", values, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonNotIn(List<String> values) {
            addCriterion("check_person not in", values, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonBetween(String value1, String value2) {
            addCriterion("check_person between", value1, value2, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andCheckPersonNotBetween(String value1, String value2) {
            addCriterion("check_person not between", value1, value2, "checkPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonIsNull() {
            addCriterion("record_person is null");
            return (Criteria) this;
        }

        public Criteria andRecordPersonIsNotNull() {
            addCriterion("record_person is not null");
            return (Criteria) this;
        }

        public Criteria andRecordPersonEqualTo(String value) {
            addCriterion("record_person =", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonNotEqualTo(String value) {
            addCriterion("record_person <>", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonGreaterThan(String value) {
            addCriterion("record_person >", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonGreaterThanOrEqualTo(String value) {
            addCriterion("record_person >=", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonLessThan(String value) {
            addCriterion("record_person <", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonLessThanOrEqualTo(String value) {
            addCriterion("record_person <=", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonLike(String value) {
            addCriterion("record_person like", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonNotLike(String value) {
            addCriterion("record_person not like", value, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonIn(List<String> values) {
            addCriterion("record_person in", values, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonNotIn(List<String> values) {
            addCriterion("record_person not in", values, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonBetween(String value1, String value2) {
            addCriterion("record_person between", value1, value2, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordPersonNotBetween(String value1, String value2) {
            addCriterion("record_person not between", value1, value2, "recordPerson");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNull() {
            addCriterion("record_time is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("record_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(String value) {
            addCriterion("record_time =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(String value) {
            addCriterion("record_time <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(String value) {
            addCriterion("record_time >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(String value) {
            addCriterion("record_time >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(String value) {
            addCriterion("record_time <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(String value) {
            addCriterion("record_time <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLike(String value) {
            addCriterion("record_time like", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotLike(String value) {
            addCriterion("record_time not like", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<String> values) {
            addCriterion("record_time in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<String> values) {
            addCriterion("record_time not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(String value1, String value2) {
            addCriterion("record_time between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(String value1, String value2) {
            addCriterion("record_time not between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andProjectsIsNull() {
            addCriterion("projects is null");
            return (Criteria) this;
        }

        public Criteria andProjectsIsNotNull() {
            addCriterion("projects is not null");
            return (Criteria) this;
        }

        public Criteria andProjectsEqualTo(String value) {
            addCriterion("projects =", value, "projects");
            return (Criteria) this;
        }

        public Criteria andProjectsNotEqualTo(String value) {
            addCriterion("projects <>", value, "projects");
            return (Criteria) this;
        }

        public Criteria andProjectsGreaterThan(String value) {
            addCriterion("projects >", value, "projects");
            return (Criteria) this;
        }

        public Criteria andProjectsGreaterThanOrEqualTo(String value) {
            addCriterion("projects >=", value, "projects");
            return (Criteria) this;
        }

        public Criteria andProjectsLessThan(String value) {
            addCriterion("projects <", value, "projects");
            return (Criteria) this;
        }

        public Criteria andProjectsLessThanOrEqualTo(String value) {
            addCriterion("projects <=", value, "projects");
            return (Criteria) this;
        }

        public Criteria andProjectsLike(String value) {
            addCriterion("projects like", value, "projects");
            return (Criteria) this;
        }

        public Criteria andProjectsNotLike(String value) {
            addCriterion("projects not like", value, "projects");
            return (Criteria) this;
        }

        public Criteria andProjectsIn(List<String> values) {
            addCriterion("projects in", values, "projects");
            return (Criteria) this;
        }

        public Criteria andProjectsNotIn(List<String> values) {
            addCriterion("projects not in", values, "projects");
            return (Criteria) this;
        }

        public Criteria andProjectsBetween(String value1, String value2) {
            addCriterion("projects between", value1, value2, "projects");
            return (Criteria) this;
        }

        public Criteria andProjectsNotBetween(String value1, String value2) {
            addCriterion("projects not between", value1, value2, "projects");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("\"status\" is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("\"status\" is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("\"status\" =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("\"status\" <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("\"status\" >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("\"status\" >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("\"status\" <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("\"status\" <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("\"status\" like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("\"status\" not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("\"status\" in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("\"status\" not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("\"status\" between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("\"status\" not between", value1, value2, "status");
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
    }

    /**
     */
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