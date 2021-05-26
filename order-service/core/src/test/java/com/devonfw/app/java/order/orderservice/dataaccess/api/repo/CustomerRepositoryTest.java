package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.devonfw.module.test.common.base.ComponentTest;

/**
 * TODO JURBANEK This type ...
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class CustomerRepositoryTest extends ComponentTest {
  @Inject
  private CustomerRepository customerRepository;

  @Test
  public void shouldRemoveCustomerById() {

    int allEntitiesBeforeDelete = this.customerRepository.findAll().size();
    this.customerRepository.deleteById(31L);
    int allEntitiesAfterDelete = this.customerRepository.findAll().size();

    assertThat(allEntitiesAfterDelete).isEqualByComparingTo(allEntitiesBeforeDelete - 1);
  }

}
