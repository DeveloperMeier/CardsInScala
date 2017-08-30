package cards.card

class Card(suit: CardSuite, value: CardValue, orientation: CardOrientation) {
  def getSuite = suit
  def getValue = value
  def getOrientation = orientation

  def print: Unit = {
    println(value.display + suit.display)
  }

  def flip: Card = {
    orientation match {
      case Up => new Card(suit, value, Down)
      case Down => new Card(suit, value, Up)
    }
  }
}


trait CardSuite {
  val display: String
}

object Cards {
  val possibleSuites: Seq[CardSuite] = Seq(Heart, Spade, Club, Diamond)
}

case object Heart extends CardSuite {
  val display = "♥"
}
case object Spade extends CardSuite {
  val display = "♠"
}
case object Club extends CardSuite {
  val display = "♣"
}
case object Diamond extends CardSuite {
  val display = "◆"
}

trait CardOrientation

case object Up extends CardOrientation
case object Down extends CardOrientation


trait CardValue {
  val value: Int
  val display: String
}

object Values {
  val possibleValues: Seq[CardValue] = Seq(Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King)
}

case object Ace extends CardValue {
  val value = 1
  val display = "A"
}
case object Two extends CardValue {
  val value = 2
  val display = "2"

}
case object Three extends CardValue {
  val value = 3
  val display = "3"
}
case object Four extends CardValue {
  val value = 4
  val display = "4"
}
case object Five extends CardValue {
  val value = 5
  val display = "5"
}
case object Six extends CardValue {
  val value = 6
  val display = "6"
}
case object Seven extends CardValue {
  val value = 7
  val display = "7"
}
case object Eight extends CardValue {
  val value = 8
  val display = "8"
}
case object Nine extends CardValue {
  val value = 9
  val display = "9"
}
case object Ten extends CardValue {
  val value = 10
  val display = "10"
}
case object Jack extends CardValue {
  val value = 11
  val display = "J"
}
case object Queen extends CardValue {
  val value = 12
  val display = "Q"
}
case object King extends CardValue {
  val value = 13
  val display = "K"
}
