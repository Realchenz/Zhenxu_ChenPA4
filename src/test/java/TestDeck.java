import org.junit.Test;

import java.lang.reflect.Field;

public class TestDeck {
    @Test
    public void testShuffle() throws IllegalAccessException, NoSuchFieldException {
        Deck deck = new Deck();
        deck.shuffle();
        Class<?> deckClass = deck.getClass();
        Field deckPileField = deckClass.getDeclaredField("deckPile");
        deckPileField.setAccessible(true);
        Card[] deckPile = (Card[]) deckPileField.get(deck);
        System.out.println(deckPile[0]);
        System.out.println(deckPile[1]);
        System.out.println(deckPile[2]);
        assert deckPile.length == 52;
    }

    @Test
    public void testDrawNextCard(){
        Deck deck = new Deck();
        Card card1 = deck.drawNextCard();
        Card card2 = deck.drawNextCard();
        Card card3 = deck.drawNextCard();
        System.out.println(card1 + " " + card2 + " " + card3);
        assert card1 != null;
    }

    @Test
    public void testDiscard() throws NoSuchFieldException, IllegalAccessException {
        Card card1 = new Card("Hearts", 8);
        Deck deck = new Deck();
        deck.discard(card1);
        Class<?> deckClass = deck.getClass();
        Field discardPileField = deckClass.getDeclaredField("discardPile");
        discardPileField.setAccessible(true);
        Card[] discardPile = (Card[]) discardPileField.get(deck);
        System.out.println(discardPile[0]);
        assert discardPile[0] != null;
    }

}
