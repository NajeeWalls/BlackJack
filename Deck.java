


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Random;

/**
 * Reference
 * http://www.dreamincode.net/forums/topic/110380-deck-of-cards-using-various-methods/
 * This was a great help
 * 
 * @author nawalls
 */
public class Deck {

    private ArrayList<Card> cards;

    Deck() {
 
    
    }


    public void generateDeck(int n) {
        cards = new ArrayList<Card>();
        //Complexity for Deck generation is (52n)
        {
        for(int i = 0; i < n; i++){
            for (int s = 0; s <= 3; s++) {
                for (int r = 0; r <= 12; r++) {
                    cards.add(new Card(s, r));
                }
            }
        }
    }
    }
    //Returns each string in the deck each on it's own line
    public String cardList()
    {
        String cardString = "";
        Card tempCard;
        for (int i = 0; i < cards.size(); i++)
        {
            tempCard = cards.get(i);
            cardString += tempCard.cardString() + "\n";
        }       
        return cardString;           
    }

    public Integer getSizeDeck() {
        return cards.size();
    }
    
    public Card draw() {        
        //Remove card from top of deck
        //Return the name of the card
        return cards.remove(0);
    }
    
    public void shuffle(){
        int index1;
        int index2;
        Card tempCard;
        
        Random x = new Random();
           
        //swaps the places of two indexes 100 times.
        for(int i=0; i<200; i++)
        {
        //get indexs of two cards
        index1 = x.nextInt(cards.size() - 1);
        index2 = x.nextInt(cards.size() - 1);
            
        //Card1 moves to tempcard
        tempCard = cards.get(index2);
        
        //Card2 moves to Card1
        cards.set(index2, cards.get(index1));
        
        //Tempcard(which was Card1) moves to Card2
        cards.set(index1, tempCard);
        }
    }
}
