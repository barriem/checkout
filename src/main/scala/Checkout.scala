package org.hmrc.checkout

object Checkout {
  def calculateBasketValue(items: Seq[String]): BigDecimal = {
    val prices = items.map {
      case "apple" => BigDecimal("0.60")
      case "orange" => BigDecimal("0.25")
      case _ => BigDecimal("0")
    }
    prices.foldLeft(BigDecimal("0")) { _ + _ }
  }
}
