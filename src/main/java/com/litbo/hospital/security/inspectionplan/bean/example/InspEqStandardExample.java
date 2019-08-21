package com.litbo.hospital.security.inspectionplan.bean.example;

import java.util.ArrayList;
import java.util.List;

public class InspEqStandardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InspEqStandardExample() {
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

        public Criteria andInspPlStandardIdIsNull() {
            addCriterion("insp_pl_standard_id is null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardIdIsNotNull() {
            addCriterion("insp_pl_standard_id is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardIdEqualTo(String value) {
            addCriterion("insp_pl_standard_id =", value, "inspPlStandardId");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardIdNotEqualTo(String value) {
            addCriterion("insp_pl_standard_id <>", value, "inspPlStandardId");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardIdGreaterThan(String value) {
            addCriterion("insp_pl_standard_id >", value, "inspPlStandardId");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardIdGreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_id >=", value, "inspPlStandardId");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardIdLessThan(String value) {
            addCriterion("insp_pl_standard_id <", value, "inspPlStandardId");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardIdLessThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_id <=", value, "inspPlStandardId");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardIdLike(String value) {
            addCriterion("insp_pl_standard_id like", value, "inspPlStandardId");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardIdNotLike(String value) {
            addCriterion("insp_pl_standard_id not like", value, "inspPlStandardId");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardIdIn(List<String> values) {
            addCriterion("insp_pl_standard_id in", values, "inspPlStandardId");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardIdNotIn(List<String> values) {
            addCriterion("insp_pl_standard_id not in", values, "inspPlStandardId");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardIdBetween(String value1, String value2) {
            addCriterion("insp_pl_standard_id between", value1, value2, "inspPlStandardId");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardIdNotBetween(String value1, String value2) {
            addCriterion("insp_pl_standard_id not between", value1, value2, "inspPlStandardId");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardNameIsNull() {
            addCriterion("insp_pl_standard_name is null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardNameIsNotNull() {
            addCriterion("insp_pl_standard_name is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardNameEqualTo(String value) {
            addCriterion("insp_pl_standard_name =", value, "inspPlStandardName");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardNameNotEqualTo(String value) {
            addCriterion("insp_pl_standard_name <>", value, "inspPlStandardName");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardNameGreaterThan(String value) {
            addCriterion("insp_pl_standard_name >", value, "inspPlStandardName");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardNameGreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_name >=", value, "inspPlStandardName");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardNameLessThan(String value) {
            addCriterion("insp_pl_standard_name <", value, "inspPlStandardName");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardNameLessThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_name <=", value, "inspPlStandardName");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardNameLike(String value) {
            addCriterion("insp_pl_standard_name like", value, "inspPlStandardName");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardNameNotLike(String value) {
            addCriterion("insp_pl_standard_name not like", value, "inspPlStandardName");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardNameIn(List<String> values) {
            addCriterion("insp_pl_standard_name in", values, "inspPlStandardName");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardNameNotIn(List<String> values) {
            addCriterion("insp_pl_standard_name not in", values, "inspPlStandardName");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardNameBetween(String value1, String value2) {
            addCriterion("insp_pl_standard_name between", value1, value2, "inspPlStandardName");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardNameNotBetween(String value1, String value2) {
            addCriterion("insp_pl_standard_name not between", value1, value2, "inspPlStandardName");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardDescriptionIsNull() {
            addCriterion("insp_pl_standard_description is null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardDescriptionIsNotNull() {
            addCriterion("insp_pl_standard_description is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardDescriptionEqualTo(String value) {
            addCriterion("insp_pl_standard_description =", value, "inspPlStandardDescription");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardDescriptionNotEqualTo(String value) {
            addCriterion("insp_pl_standard_description <>", value, "inspPlStandardDescription");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardDescriptionGreaterThan(String value) {
            addCriterion("insp_pl_standard_description >", value, "inspPlStandardDescription");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_description >=", value, "inspPlStandardDescription");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardDescriptionLessThan(String value) {
            addCriterion("insp_pl_standard_description <", value, "inspPlStandardDescription");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardDescriptionLessThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_description <=", value, "inspPlStandardDescription");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardDescriptionLike(String value) {
            addCriterion("insp_pl_standard_description like", value, "inspPlStandardDescription");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardDescriptionNotLike(String value) {
            addCriterion("insp_pl_standard_description not like", value, "inspPlStandardDescription");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardDescriptionIn(List<String> values) {
            addCriterion("insp_pl_standard_description in", values, "inspPlStandardDescription");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardDescriptionNotIn(List<String> values) {
            addCriterion("insp_pl_standard_description not in", values, "inspPlStandardDescription");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardDescriptionBetween(String value1, String value2) {
            addCriterion("insp_pl_standard_description between", value1, value2, "inspPlStandardDescription");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardDescriptionNotBetween(String value1, String value2) {
            addCriterion("insp_pl_standard_description not between", value1, value2, "inspPlStandardDescription");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare1IsNull() {
            addCriterion("insp_pl_standard_spare1 is null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare1IsNotNull() {
            addCriterion("insp_pl_standard_spare1 is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare1EqualTo(String value) {
            addCriterion("insp_pl_standard_spare1 =", value, "inspPlStandardSpare1");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare1NotEqualTo(String value) {
            addCriterion("insp_pl_standard_spare1 <>", value, "inspPlStandardSpare1");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare1GreaterThan(String value) {
            addCriterion("insp_pl_standard_spare1 >", value, "inspPlStandardSpare1");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare1GreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_spare1 >=", value, "inspPlStandardSpare1");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare1LessThan(String value) {
            addCriterion("insp_pl_standard_spare1 <", value, "inspPlStandardSpare1");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare1LessThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_spare1 <=", value, "inspPlStandardSpare1");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare1Like(String value) {
            addCriterion("insp_pl_standard_spare1 like", value, "inspPlStandardSpare1");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare1NotLike(String value) {
            addCriterion("insp_pl_standard_spare1 not like", value, "inspPlStandardSpare1");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare1In(List<String> values) {
            addCriterion("insp_pl_standard_spare1 in", values, "inspPlStandardSpare1");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare1NotIn(List<String> values) {
            addCriterion("insp_pl_standard_spare1 not in", values, "inspPlStandardSpare1");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare1Between(String value1, String value2) {
            addCriterion("insp_pl_standard_spare1 between", value1, value2, "inspPlStandardSpare1");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare1NotBetween(String value1, String value2) {
            addCriterion("insp_pl_standard_spare1 not between", value1, value2, "inspPlStandardSpare1");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare2IsNull() {
            addCriterion("insp_pl_standard_spare2 is null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare2IsNotNull() {
            addCriterion("insp_pl_standard_spare2 is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare2EqualTo(String value) {
            addCriterion("insp_pl_standard_spare2 =", value, "inspPlStandardSpare2");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare2NotEqualTo(String value) {
            addCriterion("insp_pl_standard_spare2 <>", value, "inspPlStandardSpare2");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare2GreaterThan(String value) {
            addCriterion("insp_pl_standard_spare2 >", value, "inspPlStandardSpare2");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare2GreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_spare2 >=", value, "inspPlStandardSpare2");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare2LessThan(String value) {
            addCriterion("insp_pl_standard_spare2 <", value, "inspPlStandardSpare2");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare2LessThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_spare2 <=", value, "inspPlStandardSpare2");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare2Like(String value) {
            addCriterion("insp_pl_standard_spare2 like", value, "inspPlStandardSpare2");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare2NotLike(String value) {
            addCriterion("insp_pl_standard_spare2 not like", value, "inspPlStandardSpare2");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare2In(List<String> values) {
            addCriterion("insp_pl_standard_spare2 in", values, "inspPlStandardSpare2");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare2NotIn(List<String> values) {
            addCriterion("insp_pl_standard_spare2 not in", values, "inspPlStandardSpare2");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare2Between(String value1, String value2) {
            addCriterion("insp_pl_standard_spare2 between", value1, value2, "inspPlStandardSpare2");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare2NotBetween(String value1, String value2) {
            addCriterion("insp_pl_standard_spare2 not between", value1, value2, "inspPlStandardSpare2");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare3IsNull() {
            addCriterion("insp_pl_standard_spare3 is null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare3IsNotNull() {
            addCriterion("insp_pl_standard_spare3 is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare3EqualTo(String value) {
            addCriterion("insp_pl_standard_spare3 =", value, "inspPlStandardSpare3");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare3NotEqualTo(String value) {
            addCriterion("insp_pl_standard_spare3 <>", value, "inspPlStandardSpare3");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare3GreaterThan(String value) {
            addCriterion("insp_pl_standard_spare3 >", value, "inspPlStandardSpare3");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare3GreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_spare3 >=", value, "inspPlStandardSpare3");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare3LessThan(String value) {
            addCriterion("insp_pl_standard_spare3 <", value, "inspPlStandardSpare3");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare3LessThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_spare3 <=", value, "inspPlStandardSpare3");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare3Like(String value) {
            addCriterion("insp_pl_standard_spare3 like", value, "inspPlStandardSpare3");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare3NotLike(String value) {
            addCriterion("insp_pl_standard_spare3 not like", value, "inspPlStandardSpare3");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare3In(List<String> values) {
            addCriterion("insp_pl_standard_spare3 in", values, "inspPlStandardSpare3");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare3NotIn(List<String> values) {
            addCriterion("insp_pl_standard_spare3 not in", values, "inspPlStandardSpare3");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare3Between(String value1, String value2) {
            addCriterion("insp_pl_standard_spare3 between", value1, value2, "inspPlStandardSpare3");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare3NotBetween(String value1, String value2) {
            addCriterion("insp_pl_standard_spare3 not between", value1, value2, "inspPlStandardSpare3");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare4IsNull() {
            addCriterion("insp_pl_standard_spare4 is null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare4IsNotNull() {
            addCriterion("insp_pl_standard_spare4 is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare4EqualTo(String value) {
            addCriterion("insp_pl_standard_spare4 =", value, "inspPlStandardSpare4");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare4NotEqualTo(String value) {
            addCriterion("insp_pl_standard_spare4 <>", value, "inspPlStandardSpare4");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare4GreaterThan(String value) {
            addCriterion("insp_pl_standard_spare4 >", value, "inspPlStandardSpare4");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare4GreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_spare4 >=", value, "inspPlStandardSpare4");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare4LessThan(String value) {
            addCriterion("insp_pl_standard_spare4 <", value, "inspPlStandardSpare4");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare4LessThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_spare4 <=", value, "inspPlStandardSpare4");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare4Like(String value) {
            addCriterion("insp_pl_standard_spare4 like", value, "inspPlStandardSpare4");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare4NotLike(String value) {
            addCriterion("insp_pl_standard_spare4 not like", value, "inspPlStandardSpare4");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare4In(List<String> values) {
            addCriterion("insp_pl_standard_spare4 in", values, "inspPlStandardSpare4");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare4NotIn(List<String> values) {
            addCriterion("insp_pl_standard_spare4 not in", values, "inspPlStandardSpare4");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare4Between(String value1, String value2) {
            addCriterion("insp_pl_standard_spare4 between", value1, value2, "inspPlStandardSpare4");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare4NotBetween(String value1, String value2) {
            addCriterion("insp_pl_standard_spare4 not between", value1, value2, "inspPlStandardSpare4");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare5IsNull() {
            addCriterion("insp_pl_standard_spare5 is null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare5IsNotNull() {
            addCriterion("insp_pl_standard_spare5 is not null");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare5EqualTo(String value) {
            addCriterion("insp_pl_standard_spare5 =", value, "inspPlStandardSpare5");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare5NotEqualTo(String value) {
            addCriterion("insp_pl_standard_spare5 <>", value, "inspPlStandardSpare5");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare5GreaterThan(String value) {
            addCriterion("insp_pl_standard_spare5 >", value, "inspPlStandardSpare5");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare5GreaterThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_spare5 >=", value, "inspPlStandardSpare5");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare5LessThan(String value) {
            addCriterion("insp_pl_standard_spare5 <", value, "inspPlStandardSpare5");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare5LessThanOrEqualTo(String value) {
            addCriterion("insp_pl_standard_spare5 <=", value, "inspPlStandardSpare5");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare5Like(String value) {
            addCriterion("insp_pl_standard_spare5 like", value, "inspPlStandardSpare5");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare5NotLike(String value) {
            addCriterion("insp_pl_standard_spare5 not like", value, "inspPlStandardSpare5");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare5In(List<String> values) {
            addCriterion("insp_pl_standard_spare5 in", values, "inspPlStandardSpare5");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare5NotIn(List<String> values) {
            addCriterion("insp_pl_standard_spare5 not in", values, "inspPlStandardSpare5");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare5Between(String value1, String value2) {
            addCriterion("insp_pl_standard_spare5 between", value1, value2, "inspPlStandardSpare5");
            return (Criteria) this;
        }

        public Criteria andInspPlStandardSpare5NotBetween(String value1, String value2) {
            addCriterion("insp_pl_standard_spare5 not between", value1, value2, "inspPlStandardSpare5");
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