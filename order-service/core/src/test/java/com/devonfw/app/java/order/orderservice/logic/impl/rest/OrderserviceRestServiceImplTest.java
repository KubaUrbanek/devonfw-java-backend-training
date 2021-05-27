package com.devonfw.app.java.order.orderservice.logic.impl.rest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.devonfw.app.java.order.orderservice.common.base.CustomerTestData;
import com.devonfw.app.java.order.orderservice.common.base.ItemTestData;
import com.devonfw.app.java.order.orderservice.common.base.OrderTestData;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderCto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderEto;
import com.devonfw.app.java.order.orderservice.service.api.rest.OrderserviceRestService;
import com.devonfw.module.test.common.base.ComponentTest;

/**
 * TODO JURBANEK This type ...
 *
 */
@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class OrderserviceRestServiceImplTest extends ComponentTest {

  @Inject
  private OrderserviceRestService service;

  @Test
  public void shouldSaveOrderCto() {

    // given
    OrderCto orderCto = prepareOrderCto();
    // when
    OrderCto result = this.service.saveOrder(orderCto);
    // then
    Set<ItemEto> expected = this.service.findItemByName("cheese");

    assertThat(expected).hasSize(1);
    assertThat(expected.stream().findFirst().map(item -> item.getName()).get()).isEqualTo("cheese");
  }

  private OrderCto prepareOrderCto() {

    CustomerEto owner = CustomerTestData.MICKEY_MOUSE.build();
    Set<ItemEto> orderPositions = new HashSet<>(Arrays.asList(ItemTestData.CHEESE.build(), ItemTestData.CORN.build()));
    OrderEto order = OrderTestData.ORDER_NEW.build();
    order.setOwnerId(owner.getId());
    OrderCto orderCto = new OrderCto();
    orderCto.setOrderPositions(orderPositions);
    orderCto.setOrder(order);
    orderCto.setOwner(owner);
    return orderCto;
  }
}
