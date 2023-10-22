/**
 * This class represents a deck of cards that can be used to play the game of War.
 * @author  Zhenxu Chen
 * @address zhenxuchen@brandeis.edu
 * @date Oct, 2023
 * @assignment PA4
 */
public class Deck {
    private Card[] deckPile; //declare the deck
    private Card[] discardPile; //declare the discard pile
    /**
     * Constructor:
     * initialize the deck and the discard pile
     */
    public Deck() {
        this.deckPile = new Card[52];
        for (int i = 0; i < this.deckPile.length; i++) {
            if (i < 13) {
                this.deckPile[i] = new Card("Hearts", i + 1);
            } else if (i < 26) {
                this.deckPile[i] = new Card("Diamonds", i - 12);
            } else if (i < 39) {
                this.deckPile[i] = new Card("Clubs", i - 25);
            } else {
                this.deckPile[i] = new Card("Spades", i - 38);
            }
        }
        this.discardPile = new Card[52];
    }
    /**
     * shuffle the deck by Fisher–Yates shuffle algorithm
     */
    public void shuffle() {
        for (int i = 0; i < this.deckPile.length-1; i++) {
            int random = (int) (i + Math.random() * (this.deckPile.length-i));
            if(deckPile[i] == null || deckPile[random] == null) {
                continue;
            }
            Card temp = this.deckPile[i];
            this.deckPile[i] = this.deckPile[random];
            this.deckPile[random] = temp;
        }
    }
    /**
     * @return the next card in the deck
     */
    public Card drawNextCard() {
        for (int i = 0; i < this.deckPile.length; i++) {
            if (this.deckPile[i] != null) {
                Card temp = this.deckPile[i];
                this.deckPile[i] = null;
                return temp;
            }
        }
        this.deckPile = discardPile;
        discardPile = new Card[52];
        shuffle();
        return drawNextCard();
    }
    /**
     * discard the card to the discard pile
     * @param card
     * the card to be discarded
     */
    public void discard(Card card) {
        for (int i = 0; i < this.discardPile.length; i++) {
            if (this.discardPile[i] == null) {
                this.discardPile[i] = card;
                break;
            }
        }
    }

}
