import java.util.Scanner;

/**
 * This class represents a casino that plays the game of War.
 * @author  Zhenxu Chen
 * @address zhenxuchen@brandeis.edu
 * @date Oct, 2023
 * @assignment PA4
 */
public class Casino{
    /**
     * the total initial amount of money the user has
     */
    static int userTotal = 100;
    /**
     * the total initial amount of money the computer has
     */
    static int computerTotal = 100;
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        playGame(deck);
    }
    /**
     * play the game
     * @param deck the deck to be used
     */
    static void playGame(Deck deck) {
        System.out.println("Let's play a game of War!");
        System.out.println("Do you want to play another round?" + " (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.trim(); //remove the leading and trailing spaces
        while (input.equals("yes")) {
            System.out.println("Let's play a round!");
            playRound(deck);
            if(userTotal == 0 || computerTotal == 0) {
                System.out.println("Game over! Because one of the players has no money left.");
                break;
            }
            System.out.println("Do you want to play another round?");
            input = scanner.nextLine();
        }
        System.out.println("Thanks for playing!");
    }
    /**
     * play a round
     * @param deck the deck to be used
     */
    static void playRound(Deck deck) {
        System.out.println("You have " + userTotal + " dollars.");
        System.out.println("Computer has " + computerTotal + " dollars.");
        System.out.println("Please bet an amount:");
        Scanner scanner = new Scanner(System.in);
        int bet = scanner.nextInt();
        while(bet > userTotal || bet > computerTotal) {
            System.out.println("You or computer don't have enough money to bet that amount!");
            System.out.println("Please bet an amount:");
            bet = scanner.nextInt();
        }
        System.out.println("You bet " + bet);
        Card card1 = deck.drawNextCard();
        Card card2 = deck.drawNextCard();
        System.out.println("User card: " + card1);
        System.out.println("Computer Card: " + card2);
        if (card1.getValue() > card2.getValue()) {
            System.out.println("User wins!");
            userTotal += bet;
            computerTotal -= bet;
        } else if (card1.getValue() < card2.getValue()) {
            System.out.println("Computer wins!");
            computerTotal += bet;
            userTotal -= bet;
        }
        deck.discard(card1);
        deck.discard(card2);
        System.out.println("User total amount: " + userTotal);
        System.out.println("Computer total amount: " + computerTotal);
    }
}
