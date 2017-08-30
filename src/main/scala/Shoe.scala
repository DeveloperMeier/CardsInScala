package cards.shoe

import cards.deck.Deck

class Shoe {
  def build(count: Int): IndexedSeq[Deck#Deck] = for {
    i <- Range(0, count)
    cards = new Deck().build
  } yield cards


}
