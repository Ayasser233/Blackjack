
package blackjack;


public class Card {
    private final int suit;
    private final int rank;
    private final int value;

    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
    
    Card(Card c){
    suit = c.suit;
    rank = c.rank;
    value = c.value;
    }
    
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    
    
}
