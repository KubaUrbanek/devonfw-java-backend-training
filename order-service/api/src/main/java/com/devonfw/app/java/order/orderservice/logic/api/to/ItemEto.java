package com.devonfw.app.java.order.orderservice.logic.api.to;

import com.devonfw.app.java.order.orderservice.common.api.Item;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * TODO JURBANEK This type ...
 *
 */
public class ItemEto extends AbstractEto implements Item {
  private String name;

  private String description;

  private double price;

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
