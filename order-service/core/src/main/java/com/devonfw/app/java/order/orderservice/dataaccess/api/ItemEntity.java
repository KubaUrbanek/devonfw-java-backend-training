package com.devonfw.app.java.order.orderservice.dataaccess.api;

import javax.persistence.Entity;

import com.devonfw.app.java.order.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.app.java.order.orderservice.common.api.Item;

/**
 * TODO JURBANEK This type ...
 */
@Entity(name = "item")
public class ItemEntity extends ApplicationPersistenceEntity implements Item {

  private String name;

  private String description;

  private double price;

  private static final long serialVersionUID = 1L;

  /**
   * @return name
   */
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return description
   */
  @Override
  public String getDescription() {

    return this.description;
  }

  /**
   * @param description new value of {@link #getdescription}.
   */
  @Override
  public void setDescription(String description) {

    this.description = description;
  }

  /**
   * @return price
   */
  @Override
  public double getPrice() {

    return this.price;
  }

  /**
   * @param price new value of {@link #getprice}.
   */
  @Override
  public void setPrice(double price) {

    this.price = price;
  }

}
