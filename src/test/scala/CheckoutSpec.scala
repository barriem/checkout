package org.hmrc.checkout

import org.scalatest.{WordSpec, Matchers}

class CheckoutSpec extends WordSpec with Matchers {

  "Checkout" should {
    "Calculate the basket value for 1 apple and 1 orange" in {
      val basketValue = Checkout.calculateBasketValue(Seq(Apple, Orange))
      basketValue shouldBe BigDecimal("0.85")
    }

    "Calculate the basket value for 3 oranges" in {
      val basketValue = Checkout.calculateBasketValue(Seq(Orange, Orange, Orange))
      basketValue shouldBe BigDecimal("0.50")
    }

    "Calculate the basket value for 4 oranges and 3 apples" in {
      val basketValue = Checkout.calculateBasketValue(Seq(Orange, Orange, Orange, Orange, Apple, Apple, Apple))
      basketValue shouldBe BigDecimal("1.95")
    }

    "Calculate the basket value for 10 oranges and 8 apples" in {
      val basketValue = Checkout.calculateBasketValue(Seq(Apple, Apple, Orange, Apple, Orange, Orange,
        Orange, Orange, Orange, Orange, Orange, Apple, Orange, Orange, Apple, Apple, Apple, Apple))
      basketValue shouldBe BigDecimal("4.15")
    }

    "Calculate the basket value for an empty basket" in {
      val basketValue = Checkout.calculateBasketValue(Nil)
      basketValue shouldBe BigDecimal("0.00")
    }
  }

}
