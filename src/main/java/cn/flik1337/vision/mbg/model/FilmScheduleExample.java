package cn.flik1337.vision.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilmScheduleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FilmScheduleExample() {
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

        public Criteria andFilmScheduleIdIsNull() {
            addCriterion("film_schedule_id is null");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleIdIsNotNull() {
            addCriterion("film_schedule_id is not null");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleIdEqualTo(Integer value) {
            addCriterion("film_schedule_id =", value, "filmScheduleId");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleIdNotEqualTo(Integer value) {
            addCriterion("film_schedule_id <>", value, "filmScheduleId");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleIdGreaterThan(Integer value) {
            addCriterion("film_schedule_id >", value, "filmScheduleId");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("film_schedule_id >=", value, "filmScheduleId");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleIdLessThan(Integer value) {
            addCriterion("film_schedule_id <", value, "filmScheduleId");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleIdLessThanOrEqualTo(Integer value) {
            addCriterion("film_schedule_id <=", value, "filmScheduleId");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleIdIn(List<Integer> values) {
            addCriterion("film_schedule_id in", values, "filmScheduleId");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleIdNotIn(List<Integer> values) {
            addCriterion("film_schedule_id not in", values, "filmScheduleId");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleIdBetween(Integer value1, Integer value2) {
            addCriterion("film_schedule_id between", value1, value2, "filmScheduleId");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("film_schedule_id not between", value1, value2, "filmScheduleId");
            return (Criteria) this;
        }

        public Criteria andFilmIdIsNull() {
            addCriterion("film_id is null");
            return (Criteria) this;
        }

        public Criteria andFilmIdIsNotNull() {
            addCriterion("film_id is not null");
            return (Criteria) this;
        }

        public Criteria andFilmIdEqualTo(Integer value) {
            addCriterion("film_id =", value, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdNotEqualTo(Integer value) {
            addCriterion("film_id <>", value, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdGreaterThan(Integer value) {
            addCriterion("film_id >", value, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("film_id >=", value, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdLessThan(Integer value) {
            addCriterion("film_id <", value, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdLessThanOrEqualTo(Integer value) {
            addCriterion("film_id <=", value, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdIn(List<Integer> values) {
            addCriterion("film_id in", values, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdNotIn(List<Integer> values) {
            addCriterion("film_id not in", values, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdBetween(Integer value1, Integer value2) {
            addCriterion("film_id between", value1, value2, "filmId");
            return (Criteria) this;
        }

        public Criteria andFilmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("film_id not between", value1, value2, "filmId");
            return (Criteria) this;
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

        public Criteria andScheduleDateIsNull() {
            addCriterion("schedule_date is null");
            return (Criteria) this;
        }

        public Criteria andScheduleDateIsNotNull() {
            addCriterion("schedule_date is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleDateEqualTo(Date value) {
            addCriterion("schedule_date =", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateNotEqualTo(Date value) {
            addCriterion("schedule_date <>", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateGreaterThan(Date value) {
            addCriterion("schedule_date >", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateGreaterThanOrEqualTo(Date value) {
            addCriterion("schedule_date >=", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateLessThan(Date value) {
            addCriterion("schedule_date <", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateLessThanOrEqualTo(Date value) {
            addCriterion("schedule_date <=", value, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateIn(List<Date> values) {
            addCriterion("schedule_date in", values, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateNotIn(List<Date> values) {
            addCriterion("schedule_date not in", values, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateBetween(Date value1, Date value2) {
            addCriterion("schedule_date between", value1, value2, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleDateNotBetween(Date value1, Date value2) {
            addCriterion("schedule_date not between", value1, value2, "scheduleDate");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeIsNull() {
            addCriterion("schedule_time is null");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeIsNotNull() {
            addCriterion("schedule_time is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeEqualTo(Integer value) {
            addCriterion("schedule_time =", value, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeNotEqualTo(Integer value) {
            addCriterion("schedule_time <>", value, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeGreaterThan(Integer value) {
            addCriterion("schedule_time >", value, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("schedule_time >=", value, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeLessThan(Integer value) {
            addCriterion("schedule_time <", value, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeLessThanOrEqualTo(Integer value) {
            addCriterion("schedule_time <=", value, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeIn(List<Integer> values) {
            addCriterion("schedule_time in", values, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeNotIn(List<Integer> values) {
            addCriterion("schedule_time not in", values, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeBetween(Integer value1, Integer value2) {
            addCriterion("schedule_time between", value1, value2, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andScheduleTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("schedule_time not between", value1, value2, "scheduleTime");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeIsNull() {
            addCriterion("schedule_type is null");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeIsNotNull() {
            addCriterion("schedule_type is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeEqualTo(String value) {
            addCriterion("schedule_type =", value, "scheduleType");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeNotEqualTo(String value) {
            addCriterion("schedule_type <>", value, "scheduleType");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeGreaterThan(String value) {
            addCriterion("schedule_type >", value, "scheduleType");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("schedule_type >=", value, "scheduleType");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeLessThan(String value) {
            addCriterion("schedule_type <", value, "scheduleType");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeLessThanOrEqualTo(String value) {
            addCriterion("schedule_type <=", value, "scheduleType");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeLike(String value) {
            addCriterion("schedule_type like", value, "scheduleType");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeNotLike(String value) {
            addCriterion("schedule_type not like", value, "scheduleType");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeIn(List<String> values) {
            addCriterion("schedule_type in", values, "scheduleType");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeNotIn(List<String> values) {
            addCriterion("schedule_type not in", values, "scheduleType");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeBetween(String value1, String value2) {
            addCriterion("schedule_type between", value1, value2, "scheduleType");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeNotBetween(String value1, String value2) {
            addCriterion("schedule_type not between", value1, value2, "scheduleType");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleStatusIsNull() {
            addCriterion("film_schedule_status is null");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleStatusIsNotNull() {
            addCriterion("film_schedule_status is not null");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleStatusEqualTo(Integer value) {
            addCriterion("film_schedule_status =", value, "filmScheduleStatus");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleStatusNotEqualTo(Integer value) {
            addCriterion("film_schedule_status <>", value, "filmScheduleStatus");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleStatusGreaterThan(Integer value) {
            addCriterion("film_schedule_status >", value, "filmScheduleStatus");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("film_schedule_status >=", value, "filmScheduleStatus");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleStatusLessThan(Integer value) {
            addCriterion("film_schedule_status <", value, "filmScheduleStatus");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("film_schedule_status <=", value, "filmScheduleStatus");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleStatusIn(List<Integer> values) {
            addCriterion("film_schedule_status in", values, "filmScheduleStatus");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleStatusNotIn(List<Integer> values) {
            addCriterion("film_schedule_status not in", values, "filmScheduleStatus");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleStatusBetween(Integer value1, Integer value2) {
            addCriterion("film_schedule_status between", value1, value2, "filmScheduleStatus");
            return (Criteria) this;
        }

        public Criteria andFilmScheduleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("film_schedule_status not between", value1, value2, "filmScheduleStatus");
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