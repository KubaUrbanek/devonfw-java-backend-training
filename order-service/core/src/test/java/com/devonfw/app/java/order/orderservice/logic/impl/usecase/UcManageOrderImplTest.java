package com.devonfw.app.java.order.orderservice.logic.impl.usecase;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.transaction.annotation.Transactional;

import com.devonfw.app.java.order.orderservice.common.base.CustomerTestData;
import com.devonfw.app.java.order.orderservice.common.base.ItemTestData;
import com.devonfw.app.java.order.orderservice.common.base.OrderTestData;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderCto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderEto;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcManageOrder;
import com.devonfw.module.test.common.base.ComponentTest;

/**
 * TODO JURBANEK This type ...
 *
 */
@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UcManageOrderImplTest extends ComponentTest {

  @Inject
  private UcManageOrder ucManageOrder;

  @Test
  public void shouldSaveOrderCto() {

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

    OrderCto savedOrderCto = this.ucManageOrder.saveOrder(orderCto);

    assertThat(savedOrderCto).isNotNull();
    assertThat(savedOrderCto.getOrder()).isEqualToComparingFieldByField(orderCto.getOrder());
    assertThat(savedOrderCto.getOrderPositions()).isNotEmpty();
    assertThat(savedOrderCto.getOrderPositions().size()).isEqualTo(2);
    assertThat(savedOrderCto.getOwner()).isEqualToComparingFieldByField(orderCto.getOwner());

  }

}
