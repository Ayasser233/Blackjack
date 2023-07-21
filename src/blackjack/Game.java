package blackjack;

import java.util.*;

public class Game {

    public Player players[] = new Player[4];
    public Card cards[] = new Card[52];
    static int idx = 0;
    public int Highscore;
    Random rand = new Random();
    Scanner in = new Scanner(System.in);

    public Game() {
    }

    public void setPlayerinfromation() {

        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                players[i] = new Player("dealer");
            } else {
                System.out.println("Enter the player name " + (i + 1) + " :");
                players[i] = new Player(in.next());
            }
            for (int x = 0; x < 2; x++) {
                players[i].cards[x] = drawRandomly();
            }
        }
    }   

    public Card drawRandomly() {

        int randomChoice;
        while (true) {
            randomChoice = rand.nextInt(52);
            if (cards[randomChoice] != null) {
                Card temp = new Card(cards[randomChoice]);
                cards[randomChoice] = null;

                return temp;

            }
        }
    }

    public void deckaaray() {

        for (int suit = 0; suit < 4; suit++) {
            int value = 1;
            for (int rank = 0; rank < 13; rank++) {

                cards[idx] = new Card(suit, rank, value);
                idx++;

                if (value < 10) {
                    value++;
                } else {
                    value = 10;
                }
            }
        }
    }

    public void calcScore() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 11; ++j) {
                if (players[i].cards[j] != null) {
                    players[i].score += players[i].cards[j].getValue();
                }
            }
        }
    }

    public int maxScore() {

        for (int i = 0; i < 4; i++) {
            if (players[i].score > Highscore && players[i].score <= 21 ) {
                Highscore = players[i].score;
                
            }
        }
        return Highscore;
    }
    public boolean dealerScore(){
        return players[3].score > maxScore() || players[3].score >= 21;
    }
}
