package cn.flik1337.vision.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class TicketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketExample() {
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

        public Criteria andTicketIdIsNull() {
            addCriterion("ticket_id is null");
            return (Criteria) this;
        }

        public Criteria andTicketIdIsNotNull() {
            addCriterion("ticket_id is not null");
            return (Criteria) this;
        }

        public Criteria andTicketIdEqualTo(Integer value) {
            addCriterion("ticket_id =", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotEqualTo(Integer value) {
            addCriterion("ticket_id <>", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThan(Integer value) {
            addCriterion("ticket_id >", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ticket_id >=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThan(Integer value) {
            addCriterion("ticket_id <", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThanOrEqualTo(Integer value) {
            addCriterion("ticket_id <=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdIn(List<Integer> values) {
            addCriterion("ticket_id in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotIn(List<Integer> values) {
            addCriterion("ticket_id not in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdBetween(Integer value1, Integer value2) {
            addCriterion("ticket_id between", value1, value2, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ticket_id not between", value1, value2, "ticketId");
            return (Criteria) this;
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

        public Criteria andQrCodeIsNull() {
            addCriterion("qr_code is null");
            return (Criteria) this;
        }

        public Criteria andQrCodeIsNotNull() {
            addCriterion("qr_code is not null");
            return (Criteria) this;
        }

        public Criteria andQrCodeEqualTo(String value) {
            addCriterion("qr_code =", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotEqualTo(String value) {
            addCriterion("qr_code <>", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeGreaterThan(String value) {
            addCriterion("qr_code >", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("qr_code >=", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLessThan(String value) {
            addCriterion("qr_code <", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLessThanOrEqualTo(String value) {
            addCriterion("qr_code <=", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLike(String value) {
            addCriterion("qr_code like", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotLike(String value) {
            addCriterion("qr_code not like", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeIn(List<String> values) {
            addCriterion("qr_code in", values, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotIn(List<String> values) {
            addCriterion("qr_code not in", values, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeBetween(String value1, String value2) {
            addCriterion("qr_code between", value1, value2, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotBetween(String value1, String value2) {
            addCriterion("qr_code not between", value1, value2, "qrCode");
            return (Criteria) this;
        }

        public Criteria andPosXIsNull() {
            addCriterion("pos_x is null");
            return (Criteria) this;
        }

        public Criteria andPosXIsNotNull() {
            addCriterion("pos_x is not null");
            return (Criteria) this;
        }

        public Criteria andPosXEqualTo(Integer value) {
            addCriterion("pos_x =", value, "posX");
            return (Criteria) this;
        }

        public Criteria andPosXNotEqualTo(Integer value) {
            addCriterion("pos_x <>", value, "posX");
            return (Criteria) this;
        }

        public Criteria andPosXGreaterThan(Integer value) {
            addCriterion("pos_x >", value, "posX");
            return (Criteria) this;
        }

        public Criteria andPosXGreaterThanOrEqualTo(Integer value) {
            addCriterion("pos_x >=", value, "posX");
            return (Criteria) this;
        }

        public Criteria andPosXLessThan(Integer value) {
            addCriterion("pos_x <", value, "posX");
            return (Criteria) this;
        }

        public Criteria andPosXLessThanOrEqualTo(Integer value) {
            addCriterion("pos_x <=", value, "posX");
            return (Criteria) this;
        }

        public Criteria andPosXIn(List<Integer> values) {
            addCriterion("pos_x in", values, "posX");
            return (Criteria) this;
        }

        public Criteria andPosXNotIn(List<Integer> values) {
            addCriterion("pos_x not in", values, "posX");
            return (Criteria) this;
        }

        public Criteria andPosXBetween(Integer value1, Integer value2) {
            addCriterion("pos_x between", value1, value2, "posX");
            return (Criteria) this;
        }

        public Criteria andPosXNotBetween(Integer value1, Integer value2) {
            addCriterion("pos_x not between", value1, value2, "posX");
            return (Criteria) this;
        }

        public Criteria andPosYIsNull() {
            addCriterion("pos_y is null");
            return (Criteria) this;
        }

        public Criteria andPosYIsNotNull() {
            addCriterion("pos_y is not null");
            return (Criteria) this;
        }

        public Criteria andPosYEqualTo(Integer value) {
            addCriterion("pos_y =", value, "posY");
            return (Criteria) this;
        }

        public Criteria andPosYNotEqualTo(Integer value) {
            addCriterion("pos_y <>", value, "posY");
            return (Criteria) this;
        }

        public Criteria andPosYGreaterThan(Integer value) {
            addCriterion("pos_y >", value, "posY");
            return (Criteria) this;
        }

        public Criteria andPosYGreaterThanOrEqualTo(Integer value) {
            addCriterion("pos_y >=", value, "posY");
            return (Criteria) this;
        }

        public Criteria andPosYLessThan(Integer value) {
            addCriterion("pos_y <", value, "posY");
            return (Criteria) this;
        }

        public Criteria andPosYLessThanOrEqualTo(Integer value) {
            addCriterion("pos_y <=", value, "posY");
            return (Criteria) this;
        }

        public Criteria andPosYIn(List<Integer> values) {
            addCriterion("pos_y in", values, "posY");
            return (Criteria) this;
        }

        public Criteria andPosYNotIn(List<Integer> values) {
            addCriterion("pos_y not in", values, "posY");
            return (Criteria) this;
        }

        public Criteria andPosYBetween(Integer value1, Integer value2) {
            addCriterion("pos_y between", value1, value2, "posY");
            return (Criteria) this;
        }

        public Criteria andPosYNotBetween(Integer value1, Integer value2) {
            addCriterion("pos_y not between", value1, value2, "posY");
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