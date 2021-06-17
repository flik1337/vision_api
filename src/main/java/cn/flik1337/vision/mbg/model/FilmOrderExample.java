package cn.flik1337.vision.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilmOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FilmOrderExample() {
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

        public Criteria andFilmOrderIdIsNull() {
            addCriterion("film_order_id is null");
            return (Criteria) this;
        }

        public Criteria andFilmOrderIdIsNotNull() {
            addCriterion("film_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andFilmOrderIdEqualTo(String value) {
            addCriterion("film_order_id =", value, "filmOrderId");
            return (Criteria) this;
        }

        public Criteria andFilmOrderIdNotEqualTo(String value) {
            addCriterion("film_order_id <>", value, "filmOrderId");
            return (Criteria) this;
        }

        public Criteria andFilmOrderIdGreaterThan(String value) {
            addCriterion("film_order_id >", value, "filmOrderId");
            return (Criteria) this;
        }

        public Criteria andFilmOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("film_order_id >=", value, "filmOrderId");
            return (Criteria) this;
        }

        public Criteria andFilmOrderIdLessThan(String value) {
            addCriterion("film_order_id <", value, "filmOrderId");
            return (Criteria) this;
        }

        public Criteria andFilmOrderIdLessThanOrEqualTo(String value) {
            addCriterion("film_order_id <=", value, "filmOrderId");
            return (Criteria) this;
        }

        public Criteria andFilmOrderIdLike(String value) {
            addCriterion("film_order_id like", value, "filmOrderId");
            return (Criteria) this;
        }

        public Criteria andFilmOrderIdNotLike(String value) {
            addCriterion("film_order_id not like", value, "filmOrderId");
            return (Criteria) this;
        }

        public Criteria andFilmOrderIdIn(List<String> values) {
            addCriterion("film_order_id in", values, "filmOrderId");
            return (Criteria) this;
        }

        public Criteria andFilmOrderIdNotIn(List<String> values) {
            addCriterion("film_order_id not in", values, "filmOrderId");
            return (Criteria) this;
        }

        public Criteria andFilmOrderIdBetween(String value1, String value2) {
            addCriterion("film_order_id between", value1, value2, "filmOrderId");
            return (Criteria) this;
        }

        public Criteria andFilmOrderIdNotBetween(String value1, String value2) {
            addCriterion("film_order_id not between", value1, value2, "filmOrderId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andActualMoneyIsNull() {
            addCriterion("actual_money is null");
            return (Criteria) this;
        }

        public Criteria andActualMoneyIsNotNull() {
            addCriterion("actual_money is not null");
            return (Criteria) this;
        }

        public Criteria andActualMoneyEqualTo(Integer value) {
            addCriterion("actual_money =", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyNotEqualTo(Integer value) {
            addCriterion("actual_money <>", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyGreaterThan(Integer value) {
            addCriterion("actual_money >", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("actual_money >=", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyLessThan(Integer value) {
            addCriterion("actual_money <", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("actual_money <=", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyIn(List<Integer> values) {
            addCriterion("actual_money in", values, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyNotIn(List<Integer> values) {
            addCriterion("actual_money not in", values, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyBetween(Integer value1, Integer value2) {
            addCriterion("actual_money between", value1, value2, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("actual_money not between", value1, value2, "actualMoney");
            return (Criteria) this;
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

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Integer value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Integer value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andFetchStatusIsNull() {
            addCriterion("fetch_status is null");
            return (Criteria) this;
        }

        public Criteria andFetchStatusIsNotNull() {
            addCriterion("fetch_status is not null");
            return (Criteria) this;
        }

        public Criteria andFetchStatusEqualTo(Integer value) {
            addCriterion("fetch_status =", value, "fetchStatus");
            return (Criteria) this;
        }

        public Criteria andFetchStatusNotEqualTo(Integer value) {
            addCriterion("fetch_status <>", value, "fetchStatus");
            return (Criteria) this;
        }

        public Criteria andFetchStatusGreaterThan(Integer value) {
            addCriterion("fetch_status >", value, "fetchStatus");
            return (Criteria) this;
        }

        public Criteria andFetchStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("fetch_status >=", value, "fetchStatus");
            return (Criteria) this;
        }

        public Criteria andFetchStatusLessThan(Integer value) {
            addCriterion("fetch_status <", value, "fetchStatus");
            return (Criteria) this;
        }

        public Criteria andFetchStatusLessThanOrEqualTo(Integer value) {
            addCriterion("fetch_status <=", value, "fetchStatus");
            return (Criteria) this;
        }

        public Criteria andFetchStatusIn(List<Integer> values) {
            addCriterion("fetch_status in", values, "fetchStatus");
            return (Criteria) this;
        }

        public Criteria andFetchStatusNotIn(List<Integer> values) {
            addCriterion("fetch_status not in", values, "fetchStatus");
            return (Criteria) this;
        }

        public Criteria andFetchStatusBetween(Integer value1, Integer value2) {
            addCriterion("fetch_status between", value1, value2, "fetchStatus");
            return (Criteria) this;
        }

        public Criteria andFetchStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("fetch_status not between", value1, value2, "fetchStatus");
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