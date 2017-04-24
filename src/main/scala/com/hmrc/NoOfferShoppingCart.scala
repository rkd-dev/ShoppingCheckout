package com.hmrc

/**
  * It will calculate the total price of the fruits without applying any offer
  * Created by RKD on 24/04/2017.
  */
class NoOfferShoppingCart  {

  def checkout(items: List[Fruits]) = items.foldLeft(BigDecimal(0)) { (total, Fruits) =>
    Fruits.price + total
  }

}
