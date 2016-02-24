package org.hmrc.checkout

trait Item {
  val price: BigDecimal
}

case object Apple extends Item {
  val price = BigDecimal("0.60")
}

case object Orange extends Item {
  val price = BigDecimal("0.25")
}

object Checkout {
  def calculateBasketValue(items: Seq[Item]): BigDecimal = {
    val apples = items.collect { case apple @ Apple => apple }
    val oranges = items.collect { case orange @ Orange => orange }
    val itemsAfterOffers = buyOneGetOneFree(apples) ++ buyTwoGetOneFree(oranges)
    itemsAfterOffers.map(_.price).foldLeft(BigDecimal("0")) { _ + _ }
  }

  def buyOneGetOneFree(items: Seq[Item]): Seq[Item] = {
    val numberOfItemsAfterOffer = (items.size / 2) + (items.size % 2)
    items.take(numberOfItemsAfterOffer)
  }

  def buyTwoGetOneFree(items: Seq[Item]): Seq[Item] = {
    val numberOfItemsAfterOffer = ((items.size / 3) * 2) + (items.size % 3)
    items.take(numberOfItemsAfterOffer)
  }
}
