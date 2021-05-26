package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.LikePatternSyntax;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * TODO JURBANEK This type ...
 *
 */
public interface ItemRepository extends DefaultRepository<ItemEntity> {
  @Modifying
  @Transactional
  @Query(value = "UPDATE Item item SET item.price = :price WHERE item.name = :name", nativeQuery = true)
  int updateItemPriceWhererName(@Param("name") String name, @Param("price") double price);

  ItemEntity deleteById(long id);

  default Page<ItemEntity> findByCriteria(ItemSearchCriteriaTo criteria) {

    ItemEntity alias = newDslAlias();
    JPAQuery<ItemEntity> query = newDslQuery(alias);

    String name = criteria.getName();
    if (name != null && !name.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
    }

    // TODO: implement also expression for description and price

    // TODO: implement also sorting using addOrderBy

    // TODO: return found items using QueryUtil
    return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
  }

  default Page<ItemEntity> findByNameLike(ItemSearchCriteriaTo criteria) {

    ItemEntity alias = newDslAlias();
    JPAQuery<ItemEntity> query = newDslQuery(alias);

    String name = criteria.getName();
    if (name != null && !name.isEmpty()) {
      QueryUtil.get().whereLike(query, $(alias.getName()), name, LikePatternSyntax.SQL, true, true);
    }

    return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
  }
}
