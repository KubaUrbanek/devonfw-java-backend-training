package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;
import com.devonfw.module.test.common.base.ComponentTest;

/**
 * TODO JURBANEK This type ...
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ItemRepositoryTest extends ComponentTest {
  @Inject
  private ItemRepository itemRepository;

  @Test
  public void shouldFindAllItems() {

    // when
    List<ItemEntity> items = this.itemRepository.findAll();
    // then
    assertThat(items).hasSize(1);
  }

  @Test
  public void shouldFindByName() {

    Sort sort = Sort.by("name");
    Pageable pageable = PageRequest.of(0, 20, sort);

    ItemSearchCriteriaTo criteria = new ItemSearchCriteriaTo();
    criteria.setName("spaghetti bolognese");
    criteria.setPageable(pageable);
    List<ItemEntity> result = this.itemRepository.findByCriteria(criteria).getContent();

    assertThat(result.stream().map(item -> item.getName())).isEqualTo(Collections.singletonList("spaghetti bolognese"));

  }

  @Test
  public void shouldFindByNameCaseInsensitiveAndSortByName() {

    Sort sort = Sort.by("name");
    Pageable pageable = PageRequest.of(0, 20, sort);

    ItemSearchCriteriaTo criteria = new ItemSearchCriteriaTo();
    StringSearchConfigTo nameOption = new StringSearchConfigTo();
    nameOption.setIgnoreCase(true);

    criteria.setName("sPaGheTTi");
    criteria.setPageable(pageable);
    List<ItemEntity> result = this.itemRepository.findByNameLike(criteria).getContent();

    assertThat(result.stream().map(item -> item.getName())).isEqualTo(Collections.singletonList("spaghetti bolognese"));

  }

  @Test
  public void shouldChangePriceOfItem() {

    int resultId = this.itemRepository.updateItemPriceWhererName("spaghetti bolognese", 100);
    assertThat(resultId).isEqualTo(1);

  }

}
