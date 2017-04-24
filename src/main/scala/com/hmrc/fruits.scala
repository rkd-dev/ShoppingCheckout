package com.hmrc

/**
  * Fruits, Apple, Orange are defined here
  * Created by RKD on 24/04/2017.
  */
sealed trait Fruits {
  def name: String
  val price: BigDecimal

  /*
   Added to find discount amount after application of offer
   */
  def TwoForOneOffer (totalFruit: Int ) : BigDecimal = {
    val discountQuantity =  totalFruit - (totalFruit%2)
    (discountQuantity/2) * price
  }
  def ThreeForTwoOffer (totalFruit: Int ) : BigDecimal = {
    val discountQuantity =  totalFruit - (totalFruit%3)
    (discountQuantity/3) * price
  }
}

case object Apple extends Fruits {
  override def name: String = "Apple"
  override val price: BigDecimal = 0.60
  /*
  Added to apply buy one get on offer on Apple
   */
  def discountAmount (totalItem : Int) : BigDecimal =  TwoForOneOffer(totalItem)
}

case object Orange extends Fruits {
  override def name: String = "Orange"
  override val price: BigDecimal = 0.25

  /*
  Added to apply three for two offer on Orange
   */
  def discountAmount (totalItem : Int) : BigDecimal =  ThreeForTwoOffer(totalItem)
}