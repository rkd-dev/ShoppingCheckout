package com.hmrc

/**
  * Fruits, Apple, Orange are defined here
  * Created by RKD on 24/04/2017.
  */
sealed trait Fruits {
  def name: String
  val price: BigDecimal
}

case object Apple extends Fruits {
  override def name: String = "Apple"
  override val price: BigDecimal = 0.60
}

case object Orange extends Fruits {
  override def name: String = "Orange"
  override val price: BigDecimal = 0.25
}