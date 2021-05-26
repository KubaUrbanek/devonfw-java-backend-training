package com.devonfw.app.java.order.orderservice.logic.api.usecase;

import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;

/**
 * TODO JURBANEK This type ...
 *
 */
public interface UcManageItem {
  boolean deleteItem(long itemId);

  ItemEto saveItem(ItemEto item);

  int updateItemPrice(String itemName, double price);
}
