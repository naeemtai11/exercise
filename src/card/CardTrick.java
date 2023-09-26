/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then searches the array of cards for the match to the luckyCard.
 * @author srinivsi
 * Modifier : Taimur Naeem
 * Student Number: 991708249
 */
package card;

import java.util.Random;

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
        
        // Searching the magicHand
        boolean cardFound = false;
        for (Card c : magicHand) {
            if (c.getValue() == luckyCard.getValue() && c.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                cardFound = true;
                break;
            }
        }

        // Reporting the result
        if (cardFound) {
            System.out.println("Lucky card is in the magic hand! You win!");
        } else {
            System.out.println("Lucky card is not in the magic hand. You lose.");
        }
    }   
}
