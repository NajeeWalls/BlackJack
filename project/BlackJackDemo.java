

/**
 *
 * @author nawalls
 */

import java.io.Console;
import java.util.Scanner;
import java.util.ArrayList;




public class BlackJackDemo {

   private static Deck bjDeck;
   private static  boolean endGame = false;

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*Program Testing Area    -----------------------------------

        Deck myDeck = new Deck();
        myDeck.generateDeck(1);
        myDeck.shuffle();
        String hand = "";
        /*
         for(int i = 0; i < myDeck.getSizeDeck(); i++)
         System.out.println(myDeck.cards.get(i));
         */
        /*
        String s = myDeck.cardList();
        System.out.println(s);
        
        for(int i = 0; i < 5; i++)
        {
            hand += myDeck.draw().cardString() + "\n";
        }
        
        System.out.println(hand);
        

        Program Testing Area End --------------------------------- */
       
        
        //Instance and Generate Cards for deck
         bjDeck = new Deck();
         bjDeck.generateDeck(1);
         
         //Randomize Deck Order
         bjDeck.shuffle();
         
         //player and gambler starts with deck.
         Player player1 = new Player(bjDeck);
         Player dealer = new Player(bjDeck);
         
         //Dealer reveals first card
         dealer.hit();
         System.out.println("The dealer's first card is a " + dealer.hand.get(0).cardString());
         
         //Player gets intial 2 cards
         player1.hit();
         player1.hit();
         System.out.println("Player's first 2 cards are: " + player1.hand.get(0).cardString()
                 + " and " +  player1.hand.get(1).cardString()+ "("+ player1.handValue() + ")" );
         
         //Request for user's input
         Scanner command = new Scanner(System.in);
         
         while(!endGame)
         {
         System.out.println("Will you HIT or STAND? Please input command in lowercase");
         String teststring = command.next();
         
         if( "hit".equals(teststring))
         {
             hitCommand(player1);
         }
         
         else if ("stand".equals(teststring))
         {
            standCommand(dealer,player1);
         }
               
         }
         System.out.println("The program has ended, any final words?");
         command.next();           
    }
    
    static public void hitCommand(Player player)
    {
        player.hit();
        System.out.println("You now have " + player.printCardName() + "(" + player.handValue() +")" );
        if(player.bust()) {
            System.out.print("You have busted");
            endGame = true;
        }
    }
    
    static public void standCommand(Player dealer,Player player)
    {
        String tempString = "";
        
        System.out.print("Dealer will now reveal his full hand");
        dealer.hit();
        System.out.print(dealer.printCardName() + "(" + dealer.handValue()+")");
            
        //dealer must always hit until the value of it's cards reaches 17
        while (dealer.handValue() < 17)
        {            
            dealer.hit();
            System.out.println("Dealer hits");
            //Add the last card to tempString for display
            tempString += dealer.hand.get(dealer.hand.size() - 1).cardString() + "\n";
            System.out.println(tempString + "(" + dealer.handValue()+")");           
        }
        
        //If the dealer busts.
        if ( dealer.bust()) {
            System.out.println("Dealer has busted. Player wins this round");
            endGame = true;
        }
       
        //If there's a tie.
        else if(dealer.handValue() == player.handValue())
                {
                    System.out.println("A tie");
                    endGame = true;
                }
       
        //If the player has a higher hand
        else if (dealer.handValue() < player.handValue())
        {
            System.out.println("Player wins");
            endGame = true;
        }
        
        //The final condition; dealer has a higher hand
        else
        {
            System.out.println("Dealer wins");
            endGame = true;
        }
     
        }       
        
    }

        
    
