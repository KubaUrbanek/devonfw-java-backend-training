package com.devonfw.app.java.order.orderservice.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcManageItem;
import com.devonfw.app.java.order.orderservice.logic.base.usecase.AbstractItemUc;

/**
 * TODO JURBANEK This type ...
 *
 */
@Named
@Validated
@Transactional
public class UcManageItemImpl extends AbstractItemUc implements UcManageItem {

  @Override
  public boolean deleteItem(long itemId) {

    return Optional.ofNullable(this.itemRepository.deleteById(itemId)).map(itemEntity -> true).orElse(false);
  }

  @Override
  public ItemEto saveItem(ItemEto item) {

    ItemEntity entity = getBeanMapper().map(item, ItemEntity.class);
    return getBeanMapper().map(this.itemRepository.save(entity), ItemEto.class);
  }

  @Override
  public int updateItemPrice(String itemName, double price) {

    return this.itemRepository.updateItemPriceWhererName(itemName, price);
  }
}
