package cards.deck

import cards.card._

import scala.util.Random

object Deck {
  type Deck = Seq[Card]
}

class DeckHandler {
  import Deck._


  def build: Deck = {
      // Deck not complete, build it
      for {
        i <- Cards.possibleSuites
        s <- Values.possibleValues
        c = new Card(i, s, Down)
      } yield (c)
    }

  def validate(cards: Deck): Boolean = {
    (cards.size == 52 && cards.filter(_.getSuite == Heart).size == 13 &&
      cards.filter(_.getSuite == Spade).size == 13 && cards.filter(_.getSuite == Diamond).size == 13 &&
      cards.filter(_.getSuite == Club).size == 13)
  }

  def shuffle(cards: Deck): Deck = Random.shuffle(cards)

  def deal(cards: Deck, playerCount: Int, cardsEach: Int): Map[Int, Deck] = {
    shuffle(cards).foldLeft[(Int, Map[Int, Deck])](0 -> Map.empty) {
      case ((nextPlayer: Int, dealt: Map[Int, Seq[Card]]), nextCard) => {
        val psCards = dealt.getOrElse(nextPlayer, Seq.empty)
        if (psCards.size < cardsEach) ((nextPlayer + 1) % playerCount) -> (dealt + (nextPlayer -> (psCards :+ nextCard))) else
          nextPlayer -> dealt
      }
    }._2
  }
}
