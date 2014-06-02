

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author nawalls
 */
public class Card {
    
    int rank;
    int suit;
    
     private static String [] suits = {"Spades","Diamonds","Hearts","Clubs"};
     private static String[] ranks = {"Ace","2","3","4","5","6","7"
            ,"8","9","10","Jack","Queen","King"};
    
    
    public Card()
    {
        
    }
    
    public Card(int suit, int rank)
    {
     this.rank = rank;
     this.suit = suit;
    }
    
    public String cardString()
    {
        return ranks[rank] + " of " + suits[suit];
    }

    public int getRank()
    {
        return rank;
    }
    
    public int getSuit()
    {
        return suit;
    }
    
    }

            
    
  
