public class Card {
    private final int value;
    private final String suit;
    private final String color;
    /**
     * @param suit
     * suit of the card (Hearts, Diamonds, Clubs, Spades)
     * @param value
     * value of the card
     */
    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
        if (suit.equals("Hearts") || suit.equals("Diamonds")) {
            this.color = "Red";
        } else {
            this.color = "Black";
        }
    }
    /**
     * @return the value
     */
    public int getValue() {
        return this.value;
    }
    /**
     * @return the suit
     */
    public String getSuit() {
        return this.suit;
    }
    /**
     * @return the color
     */
    public String getColor() {
        return this.color;
    }
    public String toString() {
        if(this.value == 1) {
            return Alias.Ace + " of " + this.suit;
        } else if(this.value == 11) {
            return Alias.Jack + " of " +this.suit;
        } else if(this.value == 12) {
            return Alias.Queen + " of " + this.suit;
        } else if(this.value == 13) {
            return Alias.King + " of " + this.suit;
        }
        return this.value + " of " + this.suit;
    }
}
