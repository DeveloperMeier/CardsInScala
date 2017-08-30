package cards.deck

import cards.card._

class Deck {


  def build: Seq[Card] = {
      // Deck not complete, build it
      for {
        i <- Cards.possibleSuites
        s <- Values.possibleValues
        c = new Card(i, s, Down)
      } yield (c)
    }

  def validate(cards: Seq[Card]): Boolean = {
    (cards.size == 52 && cards.filter(_.getSuite == Heart).size == 13 &&
      cards.filter(_.getSuite == Spade).size == 13 && cards.filter(_.getSuite == Diamond).size == 13 &&
      cards.filter(_.getSuite == Club).size == 13)
  }

  def shuffle(cards: Seq[Card]): Seq[Card] = ???

  def deal(cards: Seq[Card], playerCount: Int, cardsEach: Int): Map[Int, Seq[Card]] = {
    //val shuffled = shuffle(cards)
    cards.foldLeft[(Int, Map[Int, Seq[Card]])](0 -> Map.empty) {
      case ((nextPlayer: Int, dealt: Map[Int, Seq[Card]]), nextCard) => {
        val psCards = dealt.getOrElse(nextPlayer, Seq.empty)
        if (psCards.size < cardsEach) ((nextPlayer + 1) % playerCount) -> (dealt + (nextPlayer -> (psCards :+ nextCard))) else
          nextPlayer -> dealt
      }
    }._2
  }
}
