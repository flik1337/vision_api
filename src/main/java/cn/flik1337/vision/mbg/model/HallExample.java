package cn.flik1337.vision.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class HallExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HallExample() {
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

        public Criteria andHallIdIsNull() {
            addCriterion("hall_id is null");
            return (Criteria) this;
        }

        public Criteria andHallIdIsNotNull() {
            addCriterion("hall_id is not null");
            return (Criteria) this;
        }

        public Criteria andHallIdEqualTo(Integer value) {
            addCriterion("hall_id =", value, "hallId");
            return (Criteria) this;
        }

        public Criteria andHallIdNotEqualTo(Integer value) {
            addCriterion("hall_id <>", value, "hallId");
            return (Criteria) this;
        }

        public Criteria andHallIdGreaterThan(Integer value) {
            addCriterion("hall_id >", value, "hallId");
            return (Criteria) this;
        }

        public Criteria andHallIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hall_id >=", value, "hallId");
            return (Criteria) this;
        }

        public Criteria andHallIdLessThan(Integer value) {
            addCriterion("hall_id <", value, "hallId");
            return (Criteria) this;
        }

        public Criteria andHallIdLessThanOrEqualTo(Integer value) {
            addCriterion("hall_id <=", value, "hallId");
            return (Criteria) this;
        }

        public Criteria andHallIdIn(List<Integer> values) {
            addCriterion("hall_id in", values, "hallId");
            return (Criteria) this;
        }

        public Criteria andHallIdNotIn(List<Integer> values) {
            addCriterion("hall_id not in", values, "hallId");
            return (Criteria) this;
        }

        public Criteria andHallIdBetween(Integer value1, Integer value2) {
            addCriterion("hall_id between", value1, value2, "hallId");
            return (Criteria) this;
        }

        public Criteria andHallIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hall_id not between", value1, value2, "hallId");
            return (Criteria) this;
        }

        public Criteria andHallNameIsNull() {
            addCriterion("hall_name is null");
            return (Criteria) this;
        }

        public Criteria andHallNameIsNotNull() {
            addCriterion("hall_name is not null");
            return (Criteria) this;
        }

        public Criteria andHallNameEqualTo(String value) {
            addCriterion("hall_name =", value, "hallName");
            return (Criteria) this;
        }

        public Criteria andHallNameNotEqualTo(String value) {
            addCriterion("hall_name <>", value, "hallName");
            return (Criteria) this;
        }

        public Criteria andHallNameGreaterThan(String value) {
            addCriterion("hall_name >", value, "hallName");
            return (Criteria) this;
        }

        public Criteria andHallNameGreaterThanOrEqualTo(String value) {
            addCriterion("hall_name >=", value, "hallName");
            return (Criteria) this;
        }

        public Criteria andHallNameLessThan(String value) {
            addCriterion("hall_name <", value, "hallName");
            return (Criteria) this;
        }

        public Criteria andHallNameLessThanOrEqualTo(String value) {
            addCriterion("hall_name <=", value, "hallName");
            return (Criteria) this;
        }

        public Criteria andHallNameLike(String value) {
            addCriterion("hall_name like", value, "hallName");
            return (Criteria) this;
        }

        public Criteria andHallNameNotLike(String value) {
            addCriterion("hall_name not like", value, "hallName");
            return (Criteria) this;
        }

        public Criteria andHallNameIn(List<String> values) {
            addCriterion("hall_name in", values, "hallName");
            return (Criteria) this;
        }

        public Criteria andHallNameNotIn(List<String> values) {
            addCriterion("hall_name not in", values, "hallName");
            return (Criteria) this;
        }

        public Criteria andHallNameBetween(String value1, String value2) {
            addCriterion("hall_name between", value1, value2, "hallName");
            return (Criteria) this;
        }

        public Criteria andHallNameNotBetween(String value1, String value2) {
            addCriterion("hall_name not between", value1, value2, "hallName");
            return (Criteria) this;
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

        public Criteria andSeatInfoIsNull() {
            addCriterion("seat_info is null");
            return (Criteria) this;
        }

        public Criteria andSeatInfoIsNotNull() {
            addCriterion("seat_info is not null");
            return (Criteria) this;
        }

        public Criteria andSeatInfoEqualTo(String value) {
            addCriterion("seat_info =", value, "seatInfo");
            return (Criteria) this;
        }

        public Criteria andSeatInfoNotEqualTo(String value) {
            addCriterion("seat_info <>", value, "seatInfo");
            return (Criteria) this;
        }

        public Criteria andSeatInfoGreaterThan(String value) {
            addCriterion("seat_info >", value, "seatInfo");
            return (Criteria) this;
        }

        public Criteria andSeatInfoGreaterThanOrEqualTo(String value) {
            addCriterion("seat_info >=", value, "seatInfo");
            return (Criteria) this;
        }

        public Criteria andSeatInfoLessThan(String value) {
            addCriterion("seat_info <", value, "seatInfo");
            return (Criteria) this;
        }

        public Criteria andSeatInfoLessThanOrEqualTo(String value) {
            addCriterion("seat_info <=", value, "seatInfo");
            return (Criteria) this;
        }

        public Criteria andSeatInfoLike(String value) {
            addCriterion("seat_info like", value, "seatInfo");
            return (Criteria) this;
        }

        public Criteria andSeatInfoNotLike(String value) {
            addCriterion("seat_info not like", value, "seatInfo");
            return (Criteria) this;
        }

        public Criteria andSeatInfoIn(List<String> values) {
            addCriterion("seat_info in", values, "seatInfo");
            return (Criteria) this;
        }

        public Criteria andSeatInfoNotIn(List<String> values) {
            addCriterion("seat_info not in", values, "seatInfo");
            return (Criteria) this;
        }

        public Criteria andSeatInfoBetween(String value1, String value2) {
            addCriterion("seat_info between", value1, value2, "seatInfo");
            return (Criteria) this;
        }

        public Criteria andSeatInfoNotBetween(String value1, String value2) {
            addCriterion("seat_info not between", value1, value2, "seatInfo");
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