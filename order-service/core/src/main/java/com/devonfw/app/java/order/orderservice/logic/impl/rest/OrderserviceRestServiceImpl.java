package com.devonfw.app.java.order.orderservice.logic.impl.rest;

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
@Named("OrderserviceRestService")
public class OrderserviceRestServiceImpl implements OrderserviceRestService {
  @Inject
  private Orderservice orderService;

  @Override
  public ItemEto findItemById(long id) {

    return this.orderService.findItem(id);
  }

  @Override
  public OrderCto saveOrder(OrderCto order) {

    // TODO Auto-generated method stub
    return this.orderService.saveOrder(order);
  }

  @Override
  public ItemEto findByName(String name) {

    // TODO Auto-generated method stub
    return null;
  }

}
