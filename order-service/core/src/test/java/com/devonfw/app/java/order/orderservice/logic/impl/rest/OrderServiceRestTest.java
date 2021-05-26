package com.devonfw.app.java.order.orderservice.logic.impl.rest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.devonfw.app.java.order.SpringBootApp;
import com.devonfw.app.java.order.general.service.base.test.RestServiceTest;
import com.devonfw.app.java.order.general.service.impl.rest.OrderServiceRestTestConfig;
import com.devonfw.app.java.order.orderservice.common.base.CustomerTestData;
import com.devonfw.app.java.order.orderservice.common.base.ItemTestData;
import com.devonfw.app.java.order.orderservice.common.base.OrderTestData;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderCto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderEto;
import com.devonfw.app.java.order.orderservice.service.api.rest.OrderserviceRestService;

/**
 * TODO JURBANEK This type ...
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { SpringBootApp.class, OrderServiceRestTestConfig.class })
public class OrderServiceRestTest extends RestServiceTest {
  @Inject
  private OrderserviceRestService orderServiceRest;

  @Test
  public void shouldFindItemByName() {

    // given
    OrderCto order = prepareCtoData();
    OrderCto result = this.orderServiceRest.saveOrder(order);
    long firstItemId = result.getOrderPositions().stream().findFirst().map(ItemEto::getId).get();
    // when
    ItemEto item = this.orderServiceRest.findItemById(firstItemId);
    // then
    assertThat(item).isNotNull();
    assertThat(Optional.of(item).map(itemEto -> itemEto.getId()).get()).isEqualTo(firstItemId);
  }

  /**
   * @return
   */
  private OrderCto prepareCtoData() {

    long ownerId = 1L;
    CustomerEto customerEto = CustomerTestData.CUSTOMER_1.createNew();
    customerEto.setId(ownerId);
    OrderEto orderEto = OrderTestData.ORDER_1.ownerId(ownerId).createNew();
    ItemEto itemEto = ItemTestData.SOUP.createNew();
    ItemEto itemEto2 = ItemTestData.CHEESE.createNew();
    Set<ItemEto> items = new HashSet<>();
    items.add(itemEto);
    items.add(itemEto2);
    OrderCto orderCto = new OrderCto();
    orderCto.setOrder(orderEto);
    orderCto.setOwner(customerEto);
    orderCto.setOrderPositions(items);
    return orderCto;
  }
}
