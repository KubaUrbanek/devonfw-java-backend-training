package com.devonfw.app.java.order.orderservice.logic.impl.rest;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import com.devonfw.app.java.order.orderservice.logic.api.Orderservice;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderCto;
import com.devonfw.app.java.order.orderservice.service.api.rest.OrderserviceRestService;

/**
 * TODO JURBANEK This type ...
 *
 */
@Named
public class OrderserviceRestServiceImpl implements OrderserviceRestService {

  @Inject
  private Orderservice orderService;

  @Override
  public Set<ItemEto> findItemByName(String name) {

    return this.orderService.findByName(name);
  }

  @Override
  public OrderCto saveOrder(OrderCto order) {

    // TODO Auto-generated method stub
    return this.orderService.saveOrder(order);
  }

}
