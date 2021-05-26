package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.devonfw.app.java.order.orderservice.common.api.OrderStatus;
import com.devonfw.app.java.order.orderservice.dataaccess.api.CustomerEntity;
import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.app.java.order.orderservice.dataaccess.api.OrderEntity;
import com.devonfw.module.test.common.base.ComponentTest;

/**
 * TODO JURBANEK This type ...
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class OrderRepositoryTest extends ComponentTest {

  @Inject
  private OrderRepository orderRepository;

  @Test
  public void shouldFindOrderFromDateAndWithStatus() {

    List<OrderEntity> orders = this.orderRepository.findOrdersByDayAndStatus(LocalDate.of(2019, 3, 15),
        OrderStatus.SERVED.toString());
    assertThat(orders).hasSize(1);
  }

  @Test
  public void shouldCreateTwoOrdersAndOwnerSet() {

    OrderEntity orderEntity = new OrderEntity();
    CustomerEntity owner = new CustomerEntity();
    owner.setFirstname("firstName");
    orderEntity.setOwner(owner);
    Set<ItemEntity> orderPositions = new HashSet();
    ItemEntity itemEntity = new ItemEntity();
    itemEntity.setName("exampleName");
    ItemEntity itemEntity2 = new ItemEntity();
    itemEntity2.setName("exampleName2");

    orderPositions.add(itemEntity);
    orderPositions.add(itemEntity2);

    orderEntity.setOrderPositions(orderPositions);

    orderEntity.setCreationDate(LocalDate.now());
    orderEntity.setStatus(OrderStatus.NEW);
    OrderEntity entity = this.orderRepository.save(orderEntity);

    assertThat(entity.getOrderPositions()).hasSize(2);
    assertThat(Optional.of(entity.getOwner()).map(customer -> customer.getFirstname()).orElse(null))
        .isEqualTo(owner.getFirstname());

  }

}
