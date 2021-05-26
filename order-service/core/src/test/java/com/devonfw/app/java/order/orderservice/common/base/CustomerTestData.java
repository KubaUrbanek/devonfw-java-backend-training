package com.devonfw.app.java.order.orderservice.common.base;

import com.devonfw.app.java.order.common.builders.CustomerEtoBuilder;

/**
 * TODO JURBANEK This type ...
 *
 */
public interface CustomerTestData {
  CustomerEtoBuilder CUSTOMER_1 = new CustomerEtoBuilder().firstname("Ktos").lastname("Ktosiowy");
}
