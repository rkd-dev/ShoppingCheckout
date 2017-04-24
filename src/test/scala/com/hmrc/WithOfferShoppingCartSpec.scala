package com.hmrc


//import com.hmrc.{Fruits, Apple, Orange, NoOfferShoppingCart, WithOfferShoppingCart}
import org.scalatest.FlatSpec

/**
  * Created by RKD on 24/04/2017.
  */
class WithOfferShoppingCartSpec extends FlatSpec{

  var withOfferShoppingCart = new WithOfferShoppingCart

  "With Offer Shopping cart" should " handle the empty list of items" in {

    intercept[NoSuchElementException] {
      withOfferShoppingCart.checkout(List.empty[Fruits])
    }

  }

  "With Offer Shopping cart" should " reject null items" in {
    intercept[NullPointerException] {
      withOfferShoppingCart.checkout(null)
    }
  }

  "With Offer Shopping cart with two apples and two oranges" should " cost £1.10 " in {
    val total = withOfferShoppingCart.checkout(List(Apple, Orange, Apple, Orange))
    assert(total == BigDecimal("1.10"))
  }

  "With Offer Shopping cart with one apple and two oranges" should " cost £1.10 " in {
    val total = withOfferShoppingCart.checkout(List(Apple, Orange, Orange))
    assert(total == BigDecimal("1.10"))
  }

  "With Offer Shopping cart with two apples and three oranges" should " cost £1.10 " in {
    val total = withOfferShoppingCart.checkout(List(Apple, Orange, Apple, Orange, Orange))
    assert(total == BigDecimal("1.10"))
  }

  "With Offer Shopping cart with three apples and one orange" should " cost £1.45 " in {
    val total = withOfferShoppingCart.checkout(List(Apple, Apple, Orange, Apple))
    assert(total == BigDecimal("1.45"))
  }
}
