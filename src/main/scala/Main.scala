package cards

import cards.deck.Deck.Deck
import cards.deck.DeckHandler
import cards.shoe.Shoe

object Main {

  def main(args: Array[String]):Unit = {
    val d = new DeckHandler()
    val filledDeck: Deck = d.build
    println(d.validate(filledDeck))
    d.deal(filledDeck, 10, 5).map(c => {
      val playerId = c._1
      val cards = c._2.map(c => c.getValue.display + c.getSuite.display)
      println(s"Player ${playerId} has ${cards}")
    })
    val shoe = new Shoe().build(40)
    println(shoe)
  }
}