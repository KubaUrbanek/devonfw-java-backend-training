package com.devonfw.app.java.order.orderservice.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcFindItem;
import com.devonfw.app.java.order.orderservice.logic.base.usecase.AbstractItemUc;

/**
 * TODO JURBANEK This type ...
 *
 */
@Named
@Validated
@Transactional
public class UcFindItemImpl extends AbstractItemUc implements UcFindItem {

  @Override
  public ItemEto findItem(long id) {

    return Optional.ofNullable(this.itemRepository.find(id)).map(item -> getBeanMapper().map(item, ItemEto.class))
        .orElse(null);
  }

  @Override
  public Page<ItemEto> findItems(ItemSearchCriteriaTo criteria) {

    Page<ItemEntity> foundEntities = this.itemRepository.findByCriteria(criteria);
    return mapPaginatedEntityList(foundEntities, ItemEto.class);
  }
}
