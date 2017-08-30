package cards.shoe

import cards.deck.Deck.Deck
import cards.deck.DeckHandler

class Shoe {
  def build(count: Int): IndexedSeq[Deck] = for {
    i <- Range(0, count)
    cards = new DeckHandler().build
  } yield cards


}
