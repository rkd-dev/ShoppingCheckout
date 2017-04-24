package com.hmrc



/**
  * Created by RKD on 24/04/2017.
  */
trait ShoppingCart {

  def checkout(items: List[Fruits]) : BigDecimal

}
