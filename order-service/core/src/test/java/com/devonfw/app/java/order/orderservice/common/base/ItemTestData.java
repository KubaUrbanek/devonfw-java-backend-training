package com.devonfw.app.java.order.orderservice.common.base;

import com.devonfw.app.java.order.common.builders.ItemEtoBuilder;

/**
 * TODO JURBANEK This type ...
 *
 */
public interface ItemTestData {
  ItemEtoBuilder CHEESE = new ItemEtoBuilder().name("cheese").price(12.50);

  ItemEtoBuilder SOUP = new ItemEtoBuilder().name("soup").price(50.50);
}
