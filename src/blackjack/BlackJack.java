package blackjack;

import java.util.*;

public class BlackJack {

    static Game obj = new Game();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        GUI gui = new GUI();
        obj.deckaaray();
        obj.setPlayerinfromation();
        obj.calcScore();
        obj.maxScore();
        obj.dealerScore();
        gui.runGUI(obj.cards, obj.players[0].cards, obj.players[1].cards, obj.players[2].cards, obj.players[3].cards);
        hitORstand(gui);
        Dealer(gui);
        Display();
    }

    static void hitORstand(GUI gui) {
        int counter = 2;

        for (int i = 0; i < 3; ++i) {
            System.out.println("player " + obj.players[i].getName() + " turn's");
            OUTER:
            while (true) {
                System.out.println("HIT or STAND");
                char h = in.next().charAt(0);
                switch (h) {
                    case 'h':
                    case 'H':
                        obj.players[i].cards[counter] = obj.drawRandomly();
                        gui.updatePlayerHand(obj.players[i].cards[counter], i);
                        obj.players[i].score += obj.players[i].cards[counter].getValue();
                        counter++;
                        break;
                    case 's':
                    case 'S':
                        break OUTER;
                    default:
                        break OUTER;
                }

                
                if (obj.players[i].score > 21) {
                    System.out.println("the player" + obj.players[i].getName() + " is busted");
                    break;

                } else if (obj.players[i].score == 21) {
                    System.out.println("the player " + obj.players[i].getName() + " is blackjack");
                    break;
                }

            }

        }
    }

    public static void Dealer(GUI gui) {
        int j = 2;

        System.out.println(obj.players[3].getName() + " turn's: ");
        while (obj.players[3].score <= obj.Highscore || obj.players[3].score < 21) {
            if (obj.players[3].score > obj.maxScore()) {
                System.out.println(obj.players[3].getName() + " is winner");
                break;
            } else {
                obj.players[3].cards[j] = obj.drawRandomly();
                gui.updateDealerHand(obj.players[3].cards[j], obj.cards);
                obj.players[3].score += obj.players[3].cards[j].getValue();

                
                if (obj.players[3].score == 21) {

                    System.out.println(obj.players[3].getName() + " is Blackjack");

                    break;
                }
                j++;
            }
           
        }
    }

    public static void Display() {
        int counter = 0;
        System.out.println(obj.Highscore);
        System.out.println(obj.maxScore());
        for (int i = 0; i < 4; i++) {
            if (obj.players[i].score == 21) {
                counter += 1;
            } else if (obj.players[i].score == obj.Highscore && obj.Highscore != 21) {
                counter += 1;
            }

        }
        if (counter > 1) {
            System.out.println("Push");
        } else {
            for (int i = 0; i < 4; i++) {
                if (obj.players[i].score == 21 || obj.players[i].score == obj.maxScore()) {
                    System.out.println(obj.players[i].getName() + " is winner");
                    break;
                }
            }
        }

    }

}
