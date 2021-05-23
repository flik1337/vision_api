package cn.flik1337.vision.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class CinemaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CinemaExample() {
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

        public Criteria andCinemaIdIsNull() {
            addCriterion("cinema_id is null");
            return (Criteria) this;
        }

        public Criteria andCinemaIdIsNotNull() {
            addCriterion("cinema_id is not null");
            return (Criteria) this;
        }

        public Criteria andCinemaIdEqualTo(Integer value) {
            addCriterion("cinema_id =", value, "cinemaId");
            return (Criteria) this;
        }

        public Criteria andCinemaIdNotEqualTo(Integer value) {
            addCriterion("cinema_id <>", value, "cinemaId");
            return (Criteria) this;
        }

        public Criteria andCinemaIdGreaterThan(Integer value) {
            addCriterion("cinema_id >", value, "cinemaId");
            return (Criteria) this;
        }

        public Criteria andCinemaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cinema_id >=", value, "cinemaId");
            return (Criteria) this;
        }

        public Criteria andCinemaIdLessThan(Integer value) {
            addCriterion("cinema_id <", value, "cinemaId");
            return (Criteria) this;
        }

        public Criteria andCinemaIdLessThanOrEqualTo(Integer value) {
            addCriterion("cinema_id <=", value, "cinemaId");
            return (Criteria) this;
        }

        public Criteria andCinemaIdIn(List<Integer> values) {
            addCriterion("cinema_id in", values, "cinemaId");
            return (Criteria) this;
        }

        public Criteria andCinemaIdNotIn(List<Integer> values) {
            addCriterion("cinema_id not in", values, "cinemaId");
            return (Criteria) this;
        }

        public Criteria andCinemaIdBetween(Integer value1, Integer value2) {
            addCriterion("cinema_id between", value1, value2, "cinemaId");
            return (Criteria) this;
        }

        public Criteria andCinemaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cinema_id not between", value1, value2, "cinemaId");
            return (Criteria) this;
        }

        public Criteria andCinemaNameIsNull() {
            addCriterion("cinema_name is null");
            return (Criteria) this;
        }

        public Criteria andCinemaNameIsNotNull() {
            addCriterion("cinema_name is not null");
            return (Criteria) this;
        }

        public Criteria andCinemaNameEqualTo(String value) {
            addCriterion("cinema_name =", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameNotEqualTo(String value) {
            addCriterion("cinema_name <>", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameGreaterThan(String value) {
            addCriterion("cinema_name >", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameGreaterThanOrEqualTo(String value) {
            addCriterion("cinema_name >=", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameLessThan(String value) {
            addCriterion("cinema_name <", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameLessThanOrEqualTo(String value) {
            addCriterion("cinema_name <=", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameLike(String value) {
            addCriterion("cinema_name like", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameNotLike(String value) {
            addCriterion("cinema_name not like", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameIn(List<String> values) {
            addCriterion("cinema_name in", values, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameNotIn(List<String> values) {
            addCriterion("cinema_name not in", values, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameBetween(String value1, String value2) {
            addCriterion("cinema_name between", value1, value2, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameNotBetween(String value1, String value2) {
            addCriterion("cinema_name not between", value1, value2, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaAddressIsNull() {
            addCriterion("cinema_address is null");
            return (Criteria) this;
        }

        public Criteria andCinemaAddressIsNotNull() {
            addCriterion("cinema_address is not null");
            return (Criteria) this;
        }

        public Criteria andCinemaAddressEqualTo(String value) {
            addCriterion("cinema_address =", value, "cinemaAddress");
            return (Criteria) this;
        }

        public Criteria andCinemaAddressNotEqualTo(String value) {
            addCriterion("cinema_address <>", value, "cinemaAddress");
            return (Criteria) this;
        }

        public Criteria andCinemaAddressGreaterThan(String value) {
            addCriterion("cinema_address >", value, "cinemaAddress");
            return (Criteria) this;
        }

        public Criteria andCinemaAddressGreaterThanOrEqualTo(String value) {
            addCriterion("cinema_address >=", value, "cinemaAddress");
            return (Criteria) this;
        }

        public Criteria andCinemaAddressLessThan(String value) {
            addCriterion("cinema_address <", value, "cinemaAddress");
            return (Criteria) this;
        }

        public Criteria andCinemaAddressLessThanOrEqualTo(String value) {
            addCriterion("cinema_address <=", value, "cinemaAddress");
            return (Criteria) this;
        }

        public Criteria andCinemaAddressLike(String value) {
            addCriterion("cinema_address like", value, "cinemaAddress");
            return (Criteria) this;
        }

        public Criteria andCinemaAddressNotLike(String value) {
            addCriterion("cinema_address not like", value, "cinemaAddress");
            return (Criteria) this;
        }

        public Criteria andCinemaAddressIn(List<String> values) {
            addCriterion("cinema_address in", values, "cinemaAddress");
            return (Criteria) this;
        }

        public Criteria andCinemaAddressNotIn(List<String> values) {
            addCriterion("cinema_address not in", values, "cinemaAddress");
            return (Criteria) this;
        }

        public Criteria andCinemaAddressBetween(String value1, String value2) {
            addCriterion("cinema_address between", value1, value2, "cinemaAddress");
            return (Criteria) this;
        }

        public Criteria andCinemaAddressNotBetween(String value1, String value2) {
            addCriterion("cinema_address not between", value1, value2, "cinemaAddress");
            return (Criteria) this;
        }

        public Criteria andPraiseIsNull() {
            addCriterion("praise is null");
            return (Criteria) this;
        }

        public Criteria andPraiseIsNotNull() {
            addCriterion("praise is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseEqualTo(Double value) {
            addCriterion("praise =", value, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseNotEqualTo(Double value) {
            addCriterion("praise <>", value, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseGreaterThan(Double value) {
            addCriterion("praise >", value, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseGreaterThanOrEqualTo(Double value) {
            addCriterion("praise >=", value, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseLessThan(Double value) {
            addCriterion("praise <", value, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseLessThanOrEqualTo(Double value) {
            addCriterion("praise <=", value, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseIn(List<Double> values) {
            addCriterion("praise in", values, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseNotIn(List<Double> values) {
            addCriterion("praise not in", values, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseBetween(Double value1, Double value2) {
            addCriterion("praise between", value1, value2, "praise");
            return (Criteria) this;
        }

        public Criteria andPraiseNotBetween(Double value1, Double value2) {
            addCriterion("praise not between", value1, value2, "praise");
            return (Criteria) this;
        }

        public Criteria andCinemaTelIsNull() {
            addCriterion("cinema_tel is null");
            return (Criteria) this;
        }

        public Criteria andCinemaTelIsNotNull() {
            addCriterion("cinema_tel is not null");
            return (Criteria) this;
        }

        public Criteria andCinemaTelEqualTo(String value) {
            addCriterion("cinema_tel =", value, "cinemaTel");
            return (Criteria) this;
        }

        public Criteria andCinemaTelNotEqualTo(String value) {
            addCriterion("cinema_tel <>", value, "cinemaTel");
            return (Criteria) this;
        }

        public Criteria andCinemaTelGreaterThan(String value) {
            addCriterion("cinema_tel >", value, "cinemaTel");
            return (Criteria) this;
        }

        public Criteria andCinemaTelGreaterThanOrEqualTo(String value) {
            addCriterion("cinema_tel >=", value, "cinemaTel");
            return (Criteria) this;
        }

        public Criteria andCinemaTelLessThan(String value) {
            addCriterion("cinema_tel <", value, "cinemaTel");
            return (Criteria) this;
        }

        public Criteria andCinemaTelLessThanOrEqualTo(String value) {
            addCriterion("cinema_tel <=", value, "cinemaTel");
            return (Criteria) this;
        }

        public Criteria andCinemaTelLike(String value) {
            addCriterion("cinema_tel like", value, "cinemaTel");
            return (Criteria) this;
        }

        public Criteria andCinemaTelNotLike(String value) {
            addCriterion("cinema_tel not like", value, "cinemaTel");
            return (Criteria) this;
        }

        public Criteria andCinemaTelIn(List<String> values) {
            addCriterion("cinema_tel in", values, "cinemaTel");
            return (Criteria) this;
        }

        public Criteria andCinemaTelNotIn(List<String> values) {
            addCriterion("cinema_tel not in", values, "cinemaTel");
            return (Criteria) this;
        }

        public Criteria andCinemaTelBetween(String value1, String value2) {
            addCriterion("cinema_tel between", value1, value2, "cinemaTel");
            return (Criteria) this;
        }

        public Criteria andCinemaTelNotBetween(String value1, String value2) {
            addCriterion("cinema_tel not between", value1, value2, "cinemaTel");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(String value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(String value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(String value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(String value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(String value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(String value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLike(String value) {
            addCriterion("lat like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotLike(String value) {
            addCriterion("lat not like", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<String> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<String> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(String value1, String value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(String value1, String value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(String value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(String value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(String value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(String value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(String value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(String value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLike(String value) {
            addCriterion("lng like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotLike(String value) {
            addCriterion("lng not like", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<String> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<String> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(String value1, String value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(String value1, String value2) {
            addCriterion("lng not between", value1, value2, "lng");
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