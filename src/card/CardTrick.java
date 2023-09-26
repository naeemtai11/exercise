/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * Modifier : Taimur Naeem
 * Student Number: 991708249
 */
package card;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CardTrick {
    
    public static void main(String[] args)
    {
        Card luckyCard = new Card();
luckyCard.setValue(7); // Set the value to 7
luckyCard.setSuit("Hearts"); // Set the suit to Hearts

        Card[] magicHand = new Card[7];
        Random rand = new Random();
        
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1); // Random value between 1 and 13
            c.setSuit(Card.SUITS[rand.nextInt(4)]); // Random suit
            magicHand[i] = c;
        }

        Scanner scanner = new Scanner(System.in);
        int value = 0;
        String suit = "";
        
        try {
            // Asking the user for Card value and suit
            System.out.println("Enter a card value (1-13): ");
            value = scanner.nextInt();
            scanner.nextLine(); // consume the leftover newline
            System.out.println("Enter a suit (Hearts, Diamonds, Spades, Clubs): ");
            suit = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number for the card value.");
            scanner.nextLine(); // consume the invalid input
        }
        
        // Searching the magicHand
        boolean cardFound = false;
        for (Card c : magicHand) {
            if (c.getValue() == value && c.getSuit().equalsIgnoreCase(suit)) {
                cardFound = true;
                break;
            }
        }

        // Reporting the result
        if (cardFound) {
            System.out.println("The card is in the magic hand!");
        } else {
            System.out.println("The card is not in the magic hand.");
        }
    }   
}
