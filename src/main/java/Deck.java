/**
 * This class represents a deck of cards that can be used to play the game of War.
 * @author  Zhenxu Chen
 * @address zhenxuchen@brandeis.edu
 * @date Oct, 2023
 * @assignment PA4
 */
public class Deck {
    private Card[] deck; //declare the deck
    private Card[] discard; //declare the discard pile
    /**
     * Constructor:
     * initialize the deck and the discard pile
     */
    public Deck() {
        this.deck = new Card[52];
        for (int i = 0; i < this.deck.length; i++) {
            if (i < 13) {
                this.deck[i] = new Card("Hearts", i + 1);
            } else if (i < 26) {
                this.deck[i] = new Card("Diamonds", i - 12);
            } else if (i < 39) {
                this.deck[i] = new Card("Clubs", i - 25);
            } else {
                this.deck[i] = new Card("Spades", i - 38);
            }
        }
        this.discard = new Card[52];
    }
    /**
     * shuffle the deck by Fisher–Yates shuffle algorithm
     */
    public void shuffle() {
        for (int i = 0; i < this.deck.length-1; i++) {
            int random = (int) (i + Math.random() * (this.deck.length-i));
            if(deck[i] == null || deck[random] == null) {
                continue;
            }
            Card temp = this.deck[i];
            this.deck[i] = this.deck[random];
            this.deck[random] = temp;
        }
    }
    /**
     * @return the next card in the deck
     */
    public Card drawNextCard() {
        for (int i = 0; i < this.deck.length; i++) {
            if (this.deck[i] != null) {
                Card temp = this.deck[i];
                this.deck[i] = null;
                return temp;
            }
        }
        this.deck = discard;
        discard = new Card[52];
        shuffle();
        return drawNextCard();
    }
    /**
     * discard the card to the discard pile
     * @param card
     * the card to be discarded
     */
    public void discard(Card card) {
        for (int i = 0; i < this.discard.length; i++) {
            if (this.discard[i] == null) {
                this.discard[i] = card;
                break;
            }
        }
    }

}
