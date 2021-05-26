package com.devonfw.app.java.order.orderservice.common.base;

import java.time.LocalDate;

import com.devonfw.app.java.order.common.builders.OrderEtoBuilder;
import com.devonfw.app.java.order.orderservice.common.api.OrderStatus;

/**
 * TODO JURBANEK This type ...
 *
 */
public interface OrderTestData {
  OrderEtoBuilder ORDER_1 = new OrderEtoBuilder().creationDate(LocalDate.now()).price(20.50).status(OrderStatus.NEW);
}
