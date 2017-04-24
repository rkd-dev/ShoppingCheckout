package com.hmrc

/**
  * It calculates the discounted amount based on offer and fruit name
  * Created by RKD on 24/04/2017.
  */
class WithOfferShoppingCart extends ShoppingCart {

  def checkout(items: List[Fruits]) : BigDecimal = {
    /*
    Convert the List of Fruits to Map of Fruit name and amount
    e.g. for input List(Apple, Apple, Orange, Apple), it will
    output Map(Orange -> 1, Apple ->3
     */
    val fruitMap: Map[Fruits, Int] = items groupBy (fruit => fruit) mapValues (_.size)

    /*
    Finds number of apples and calculates the discounted amount
     */
    val appleCount: Int = fruitMap(Apple)
    val appleDiscountAmount: BigDecimal = Apple.discountAmount(appleCount)

    /*
    Finds number of apples and calculates the discounted amount
     */
    val orangeCount: Int = fruitMap(Orange)
    val orangeDiscountAmount: BigDecimal = Orange.discountAmount(orangeCount)


    val noDiscount = new NoOfferShoppingCart
    val noDiscountAmount = noDiscount.checkout(items)

    /*
    Returns the total amount to pay after discount
     */
    noDiscountAmount - (appleDiscountAmount + orangeDiscountAmount)
  }

}
