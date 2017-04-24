package com.hmrc

//import com.hmrc.{Apple, Fruits, NoOfferShoppingCart, Orange}
import org.scalatest.FlatSpec

/**
  * TDD Test scenarios of Shopping cart without any offer
  * Created by RKD on 24/04/2017.
  */
class NoOfferShoppingCartSpec extends FlatSpec {

  var noOfferShoppingCart = new NoOfferShoppingCart

  "Shopping cart" should " handle the empty list of items" in {

    val total = noOfferShoppingCart.checkout(List.empty[Fruits])
    assert(total == BigDecimal("0"))
  }

  "Shopping cart" should " reject null items" in {
    intercept[NullPointerException] {
      noOfferShoppingCart.checkout(null)
    }
  }

  "Shopping cart with one orange" should " cost £0.60 " in {
    val total = noOfferShoppingCart.checkout(List(Apple))
    assert(total == BigDecimal("0.60"))
  }

  "Shopping cart with one apple" should " cost £0.25 " in {
    val total = noOfferShoppingCart.checkout(List(Orange))
    assert(total == BigDecimal("0.25"))
  }

  "Shopping cart with two apples and two oranges" should " cost £1.70 " in {
    val total = noOfferShoppingCart.checkout(List(Apple, Orange, Apple, Orange))
    assert(total == BigDecimal("1.70"))
  }

  "Shopping cart with three apples and one oranges" should " cost £2.05" in {
    val total = noOfferShoppingCart.checkout(List(Apple, Apple, Orange, Apple))
    assert(total == BigDecimal("2.05"))
  }

  "Shopping cart with two apples and 3 oranges" should " cost £1.95 " in {
    val total = noOfferShoppingCart.checkout(List(Apple, Orange, Apple, Orange, Orange))
    assert(total == BigDecimal("1.95"))
  }



}
