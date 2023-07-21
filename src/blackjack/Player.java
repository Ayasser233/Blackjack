
package blackjack;


public class Player {
    
    static int counter = 0;
    private String Name;
    public Card[] cards = new Card[11];
    public int score=0;


    public Player(String Name) {
        this.Name = Name;
        
    }

 
    public String getName() {
        return Name;
    }

   
}
    
    

