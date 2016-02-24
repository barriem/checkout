package org.hmrc.checkout

import org.scalatest.{WordSpec, Matchers}

class CheckoutSpec extends WordSpec with Matchers {

  "Checkout" should {
    "Calculate the basket value for 1 apple and 1 orange" in {
      val basketValue = Checkout.calculateBasketValue(Seq("apple", "orange"))
      basketValue shouldBe BigDecimal("0.85")
    }

    "Calculate the basket value for 3 oranges" in {
      val basketValue = Checkout.calculateBasketValue(Seq("orange", "orange", "orange"))
      basketValue shouldBe BigDecimal("0.75")
    }

    "Calculate the basket value for an empty basket" in {
      val basketValue = Checkout.calculateBasketValue(Nil)
      basketValue shouldBe BigDecimal("0.00")
    }
  }

}
