package cn.flik1337.vision.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class FilmBroadcastExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FilmBroadcastExample() {
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

        public Criteria andFilmBroadcastIdIsNull() {
            addCriterion("film_broadcast_id is null");
            return (Criteria) this;
        }

        public Criteria andFilmBroadcastIdIsNotNull() {
            addCriterion("film_broadcast_id is not null");
            return (Criteria) this;
        }

        public Criteria andFilmBroadcastIdEqualTo(Integer value) {
            addCriterion("film_broadcast_id =", value, "filmBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFilmBroadcastIdNotEqualTo(Integer value) {
            addCriterion("film_broadcast_id <>", value, "filmBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFilmBroadcastIdGreaterThan(Integer value) {
            addCriterion("film_broadcast_id >", value, "filmBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFilmBroadcastIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("film_broadcast_id >=", value, "filmBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFilmBroadcastIdLessThan(Integer value) {
            addCriterion("film_broadcast_id <", value, "filmBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFilmBroadcastIdLessThanOrEqualTo(Integer value) {
            addCriterion("film_broadcast_id <=", value, "filmBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFilmBroadcastIdIn(List<Integer> values) {
            addCriterion("film_broadcast_id in", values, "filmBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFilmBroadcastIdNotIn(List<Integer> values) {
            addCriterion("film_broadcast_id not in", values, "filmBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFilmBroadcastIdBetween(Integer value1, Integer value2) {
            addCriterion("film_broadcast_id between", value1, value2, "filmBroadcastId");
            return (Criteria) this;
        }

        public Criteria andFilmBroadcastIdNotBetween(Integer value1, Integer value2) {
            addCriterion("film_broadcast_id not between", value1, value2, "filmBroadcastId");
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

        public Criteria andFilmPosterIsNull() {
            addCriterion("film_poster is null");
            return (Criteria) this;
        }

        public Criteria andFilmPosterIsNotNull() {
            addCriterion("film_poster is not null");
            return (Criteria) this;
        }

        public Criteria andFilmPosterEqualTo(String value) {
            addCriterion("film_poster =", value, "filmPoster");
            return (Criteria) this;
        }

        public Criteria andFilmPosterNotEqualTo(String value) {
            addCriterion("film_poster <>", value, "filmPoster");
            return (Criteria) this;
        }

        public Criteria andFilmPosterGreaterThan(String value) {
            addCriterion("film_poster >", value, "filmPoster");
            return (Criteria) this;
        }

        public Criteria andFilmPosterGreaterThanOrEqualTo(String value) {
            addCriterion("film_poster >=", value, "filmPoster");
            return (Criteria) this;
        }

        public Criteria andFilmPosterLessThan(String value) {
            addCriterion("film_poster <", value, "filmPoster");
            return (Criteria) this;
        }

        public Criteria andFilmPosterLessThanOrEqualTo(String value) {
            addCriterion("film_poster <=", value, "filmPoster");
            return (Criteria) this;
        }

        public Criteria andFilmPosterLike(String value) {
            addCriterion("film_poster like", value, "filmPoster");
            return (Criteria) this;
        }

        public Criteria andFilmPosterNotLike(String value) {
            addCriterion("film_poster not like", value, "filmPoster");
            return (Criteria) this;
        }

        public Criteria andFilmPosterIn(List<String> values) {
            addCriterion("film_poster in", values, "filmPoster");
            return (Criteria) this;
        }

        public Criteria andFilmPosterNotIn(List<String> values) {
            addCriterion("film_poster not in", values, "filmPoster");
            return (Criteria) this;
        }

        public Criteria andFilmPosterBetween(String value1, String value2) {
            addCriterion("film_poster between", value1, value2, "filmPoster");
            return (Criteria) this;
        }

        public Criteria andFilmPosterNotBetween(String value1, String value2) {
            addCriterion("film_poster not between", value1, value2, "filmPoster");
            return (Criteria) this;
        }

        public Criteria andFilmVideoIsNull() {
            addCriterion("film_video is null");
            return (Criteria) this;
        }

        public Criteria andFilmVideoIsNotNull() {
            addCriterion("film_video is not null");
            return (Criteria) this;
        }

        public Criteria andFilmVideoEqualTo(String value) {
            addCriterion("film_video =", value, "filmVideo");
            return (Criteria) this;
        }

        public Criteria andFilmVideoNotEqualTo(String value) {
            addCriterion("film_video <>", value, "filmVideo");
            return (Criteria) this;
        }

        public Criteria andFilmVideoGreaterThan(String value) {
            addCriterion("film_video >", value, "filmVideo");
            return (Criteria) this;
        }

        public Criteria andFilmVideoGreaterThanOrEqualTo(String value) {
            addCriterion("film_video >=", value, "filmVideo");
            return (Criteria) this;
        }

        public Criteria andFilmVideoLessThan(String value) {
            addCriterion("film_video <", value, "filmVideo");
            return (Criteria) this;
        }

        public Criteria andFilmVideoLessThanOrEqualTo(String value) {
            addCriterion("film_video <=", value, "filmVideo");
            return (Criteria) this;
        }

        public Criteria andFilmVideoLike(String value) {
            addCriterion("film_video like", value, "filmVideo");
            return (Criteria) this;
        }

        public Criteria andFilmVideoNotLike(String value) {
            addCriterion("film_video not like", value, "filmVideo");
            return (Criteria) this;
        }

        public Criteria andFilmVideoIn(List<String> values) {
            addCriterion("film_video in", values, "filmVideo");
            return (Criteria) this;
        }

        public Criteria andFilmVideoNotIn(List<String> values) {
            addCriterion("film_video not in", values, "filmVideo");
            return (Criteria) this;
        }

        public Criteria andFilmVideoBetween(String value1, String value2) {
            addCriterion("film_video between", value1, value2, "filmVideo");
            return (Criteria) this;
        }

        public Criteria andFilmVideoNotBetween(String value1, String value2) {
            addCriterion("film_video not between", value1, value2, "filmVideo");
            return (Criteria) this;
        }

        public Criteria andFilmStageIsNull() {
            addCriterion("film_stage is null");
            return (Criteria) this;
        }

        public Criteria andFilmStageIsNotNull() {
            addCriterion("film_stage is not null");
            return (Criteria) this;
        }

        public Criteria andFilmStageEqualTo(String value) {
            addCriterion("film_stage =", value, "filmStage");
            return (Criteria) this;
        }

        public Criteria andFilmStageNotEqualTo(String value) {
            addCriterion("film_stage <>", value, "filmStage");
            return (Criteria) this;
        }

        public Criteria andFilmStageGreaterThan(String value) {
            addCriterion("film_stage >", value, "filmStage");
            return (Criteria) this;
        }

        public Criteria andFilmStageGreaterThanOrEqualTo(String value) {
            addCriterion("film_stage >=", value, "filmStage");
            return (Criteria) this;
        }

        public Criteria andFilmStageLessThan(String value) {
            addCriterion("film_stage <", value, "filmStage");
            return (Criteria) this;
        }

        public Criteria andFilmStageLessThanOrEqualTo(String value) {
            addCriterion("film_stage <=", value, "filmStage");
            return (Criteria) this;
        }

        public Criteria andFilmStageLike(String value) {
            addCriterion("film_stage like", value, "filmStage");
            return (Criteria) this;
        }

        public Criteria andFilmStageNotLike(String value) {
            addCriterion("film_stage not like", value, "filmStage");
            return (Criteria) this;
        }

        public Criteria andFilmStageIn(List<String> values) {
            addCriterion("film_stage in", values, "filmStage");
            return (Criteria) this;
        }

        public Criteria andFilmStageNotIn(List<String> values) {
            addCriterion("film_stage not in", values, "filmStage");
            return (Criteria) this;
        }

        public Criteria andFilmStageBetween(String value1, String value2) {
            addCriterion("film_stage between", value1, value2, "filmStage");
            return (Criteria) this;
        }

        public Criteria andFilmStageNotBetween(String value1, String value2) {
            addCriterion("film_stage not between", value1, value2, "filmStage");
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