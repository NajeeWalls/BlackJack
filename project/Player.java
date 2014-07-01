/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Najee The player class should be able to: -Check the value of cards
 * -Add them -Check for busts
 */
public class Player {

    Deck bjDeck;
    ArrayList<Card> hand;
    Card card;
    Integer handValue;

    public Player(Deck deck) {
        hand = new ArrayList();
        bjDeck = deck;
        handValue = 0;

    }

    //gets the value of the incoming cards for this game of blackJack
    public Integer getValue(Card tempcard) {

        /*
         //If the card is an Ace and it would cause a bust,
         //Change the value to 1;
         if (tempcard.rank == 0 & currentValue > 10) {
         return 1;
         }
         */

        switch (tempcard.getRank()) {
            default:
                return 0;
            case 0:
                return 11;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            case 9:
                return 10;
            case 10:
                return 10;
            case 11:
                return 10;
            case 12:
                return 10;
            //ace transfer case
            case 13:
                return 1;


        }

    }

    public void hit() {

        //Add a card from the deck to the
        hand.add(bjDeck.draw());
        handValue = handValue();

    }

    public boolean bust() {
        if (handValue > 21) {
            return true;
            /*Foe each card in the hand
             for (int i = 0; i < hand.size(); i++) {
             if (hand.get(i).rank == 0)
             //change it to a value of 1 (as seen from 14)
             hand.get(i).rank = 14;

             }*/
        } else {
            return false;
        }
    }

    public Integer handValue() {

        int tempValue = 0;
        int realValue = 0;

        //If the value is under 21, even with 11-Ace, just add the hand up
        for (int i = 0; i < hand.size(); i++) {
            tempValue += getValue(hand.get(i));
        }


        //Subtract 10 for each ace in the hand if the value is over 21
        if (tempValue > 21) {
            for (int i = 0; i < hand.size(); i++) {
                if (hand.get(i).rank == 0) {
                    tempValue = tempValue - 10; 
                } 


            }
        }

//If after all of this it's over 21, it's busted.
        return tempValue;

    }

    public String printCardName() {


        String printString = "";
        //Attempted Iterator loops.Need to fine tune to get strings out of class Card
        /*
         Iterator itr = hand.iterator();
         while(itr.hasNext()){
         printString += itr.next() + "\n";
         */
        for (int i = 0; i < hand.size(); i++) {
            printString += "\n" + hand.get(i).cardString();



        }
        return printString;
    }
}
