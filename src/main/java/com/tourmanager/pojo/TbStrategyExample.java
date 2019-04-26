package com.tourmanager.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbStrategyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbStrategyExample() {
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

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andLogoIsNull() {
            addCriterion("logo is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("logo is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("logo =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("logo <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("logo >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("logo >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("logo <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("logo <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("logo like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("logo not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(List<String> values) {
            addCriterion("logo in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(List<String> values) {
            addCriterion("logo not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("logo between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("logo not between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andCitytypeIsNull() {
            addCriterion("citytype is null");
            return (Criteria) this;
        }

        public Criteria andCitytypeIsNotNull() {
            addCriterion("citytype is not null");
            return (Criteria) this;
        }

        public Criteria andCitytypeEqualTo(String value) {
            addCriterion("citytype =", value, "citytype");
            return (Criteria) this;
        }

        public Criteria andCitytypeNotEqualTo(String value) {
            addCriterion("citytype <>", value, "citytype");
            return (Criteria) this;
        }

        public Criteria andCitytypeGreaterThan(String value) {
            addCriterion("citytype >", value, "citytype");
            return (Criteria) this;
        }

        public Criteria andCitytypeGreaterThanOrEqualTo(String value) {
            addCriterion("citytype >=", value, "citytype");
            return (Criteria) this;
        }

        public Criteria andCitytypeLessThan(String value) {
            addCriterion("citytype <", value, "citytype");
            return (Criteria) this;
        }

        public Criteria andCitytypeLessThanOrEqualTo(String value) {
            addCriterion("citytype <=", value, "citytype");
            return (Criteria) this;
        }

        public Criteria andCitytypeLike(String value) {
            addCriterion("citytype like", value, "citytype");
            return (Criteria) this;
        }

        public Criteria andCitytypeNotLike(String value) {
            addCriterion("citytype not like", value, "citytype");
            return (Criteria) this;
        }

        public Criteria andCitytypeIn(List<String> values) {
            addCriterion("citytype in", values, "citytype");
            return (Criteria) this;
        }

        public Criteria andCitytypeNotIn(List<String> values) {
            addCriterion("citytype not in", values, "citytype");
            return (Criteria) this;
        }

        public Criteria andCitytypeBetween(String value1, String value2) {
            addCriterion("citytype between", value1, value2, "citytype");
            return (Criteria) this;
        }

        public Criteria andCitytypeNotBetween(String value1, String value2) {
            addCriterion("citytype not between", value1, value2, "citytype");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStartageIsNull() {
            addCriterion("startage is null");
            return (Criteria) this;
        }

        public Criteria andStartageIsNotNull() {
            addCriterion("startage is not null");
            return (Criteria) this;
        }

        public Criteria andStartageEqualTo(String value) {
            addCriterion("startage =", value, "startage");
            return (Criteria) this;
        }

        public Criteria andStartageNotEqualTo(String value) {
            addCriterion("startage <>", value, "startage");
            return (Criteria) this;
        }

        public Criteria andStartageGreaterThan(String value) {
            addCriterion("startage >", value, "startage");
            return (Criteria) this;
        }

        public Criteria andStartageGreaterThanOrEqualTo(String value) {
            addCriterion("startage >=", value, "startage");
            return (Criteria) this;
        }

        public Criteria andStartageLessThan(String value) {
            addCriterion("startage <", value, "startage");
            return (Criteria) this;
        }

        public Criteria andStartageLessThanOrEqualTo(String value) {
            addCriterion("startage <=", value, "startage");
            return (Criteria) this;
        }

        public Criteria andStartageLike(String value) {
            addCriterion("startage like", value, "startage");
            return (Criteria) this;
        }

        public Criteria andStartageNotLike(String value) {
            addCriterion("startage not like", value, "startage");
            return (Criteria) this;
        }

        public Criteria andStartageIn(List<String> values) {
            addCriterion("startage in", values, "startage");
            return (Criteria) this;
        }

        public Criteria andStartageNotIn(List<String> values) {
            addCriterion("startage not in", values, "startage");
            return (Criteria) this;
        }

        public Criteria andStartageBetween(String value1, String value2) {
            addCriterion("startage between", value1, value2, "startage");
            return (Criteria) this;
        }

        public Criteria andStartageNotBetween(String value1, String value2) {
            addCriterion("startage not between", value1, value2, "startage");
            return (Criteria) this;
        }

        public Criteria andEndageIsNull() {
            addCriterion("endage is null");
            return (Criteria) this;
        }

        public Criteria andEndageIsNotNull() {
            addCriterion("endage is not null");
            return (Criteria) this;
        }

        public Criteria andEndageEqualTo(String value) {
            addCriterion("endage =", value, "endage");
            return (Criteria) this;
        }

        public Criteria andEndageNotEqualTo(String value) {
            addCriterion("endage <>", value, "endage");
            return (Criteria) this;
        }

        public Criteria andEndageGreaterThan(String value) {
            addCriterion("endage >", value, "endage");
            return (Criteria) this;
        }

        public Criteria andEndageGreaterThanOrEqualTo(String value) {
            addCriterion("endage >=", value, "endage");
            return (Criteria) this;
        }

        public Criteria andEndageLessThan(String value) {
            addCriterion("endage <", value, "endage");
            return (Criteria) this;
        }

        public Criteria andEndageLessThanOrEqualTo(String value) {
            addCriterion("endage <=", value, "endage");
            return (Criteria) this;
        }

        public Criteria andEndageLike(String value) {
            addCriterion("endage like", value, "endage");
            return (Criteria) this;
        }

        public Criteria andEndageNotLike(String value) {
            addCriterion("endage not like", value, "endage");
            return (Criteria) this;
        }

        public Criteria andEndageIn(List<String> values) {
            addCriterion("endage in", values, "endage");
            return (Criteria) this;
        }

        public Criteria andEndageNotIn(List<String> values) {
            addCriterion("endage not in", values, "endage");
            return (Criteria) this;
        }

        public Criteria andEndageBetween(String value1, String value2) {
            addCriterion("endage between", value1, value2, "endage");
            return (Criteria) this;
        }

        public Criteria andEndageNotBetween(String value1, String value2) {
            addCriterion("endage not between", value1, value2, "endage");
            return (Criteria) this;
        }

        public Criteria andClicksIsNull() {
            addCriterion("clicks is null");
            return (Criteria) this;
        }

        public Criteria andClicksIsNotNull() {
            addCriterion("clicks is not null");
            return (Criteria) this;
        }

        public Criteria andClicksEqualTo(Integer value) {
            addCriterion("clicks =", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotEqualTo(Integer value) {
            addCriterion("clicks <>", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksGreaterThan(Integer value) {
            addCriterion("clicks >", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksGreaterThanOrEqualTo(Integer value) {
            addCriterion("clicks >=", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksLessThan(Integer value) {
            addCriterion("clicks <", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksLessThanOrEqualTo(Integer value) {
            addCriterion("clicks <=", value, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksIn(List<Integer> values) {
            addCriterion("clicks in", values, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotIn(List<Integer> values) {
            addCriterion("clicks not in", values, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksBetween(Integer value1, Integer value2) {
            addCriterion("clicks between", value1, value2, "clicks");
            return (Criteria) this;
        }

        public Criteria andClicksNotBetween(Integer value1, Integer value2) {
            addCriterion("clicks not between", value1, value2, "clicks");
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