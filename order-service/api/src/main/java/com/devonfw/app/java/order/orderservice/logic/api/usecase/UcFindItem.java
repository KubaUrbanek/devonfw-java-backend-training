package com.devonfw.app.java.order.orderservice.logic.api.usecase;

import org.springframework.data.domain.Page;

import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;

/**
 * TODO JURBANEK This type ...
 *
 */
public interface UcFindItem {
  ItemEto findItem(long id);

  Page<ItemEto> findItems(ItemSearchCriteriaTo criteria);
}
