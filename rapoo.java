import java.util.Scanner;

public class rapoo {
    //de følgende linjer er static, fordi de ellers ikke kan bruges i funktionenerne eller main nedenunder.
    static Scanner scanner = new java.util.Scanner(System.in);
    static String input;
    //dice variablerne er type double, for at kunne bruge random funktionen, der ikke virker med int.
    static double dice1;
    static double dice2;

    //følgende funktion er lavet for ikke at gentage de to linjer igen og igen (3-4 gange) XD.
    static void endGame() {
        System.exit(0);
        scanner.close();
    }

    //en funktion der behandler brugerens input (er ikke helt polished (test-wise) og kan gøres kortere (kode-wise))
    static void userResponse() {
        input = scanner.nextLine(); //tilføj .toLowerCase() på alle lignende (hint fra AI)
        if (input.equals("no")) {
            System.out.println("Are you sure? If you are, then the game will end.");
            input = scanner.nextLine();
            if (input.equals("yes")) {
                System.out.println("Game ended.");
                endGame();
            }else if (input.equals("no")) {
                System.out.println("Okay, the game will continue! Here's the throw:");
                }
            }
    }

    //følgende funktion er lavet for ikke at gentage de to linjer igen og igen (3-4 gange) XD.
    static void rollDice() {
        dice1 = Math.floor(Math.random() *(6 - 1 + 1) + 1);
        dice2 = Math.floor(Math.random() *(6 - 1 + 1) + 1);
        System.out.println("Dice 1:   " + (int) dice1 + "\nDice 2:   " + (int) dice2);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the dice game! Would you like to play? (yes/no)");
        userResponse(); //bruger funktionen skrevet ovenover

        //disse er double da de senere bliver assign'et dice 1 og 2, som er double's (pga. random funktionen)
        double player1Count = 0;
        double player2Count = 0;

        /*
        //første kast
        System.out.println("Player 1 starts! Throw the dice? (yes/no)");
        userResponse();
        player1Count = Math.floor(Math.random() *(12 - 1 + 1) + 1);
        System.out.println(player1Count);
        */

        //spillet udføres her:
        while (true) {
            System.out.println("Player 1's turn! Throw the dice?:");
            userResponse();
            rollDice();
            player1Count += dice1 + dice2;
            System.out.println("player 1 is now at " + (int) player1Count + " points!");

            if (player1Count >= 40 && dice1 == dice2) {
                System.out.println("Player 1 has won this game! \nCongrats player 1! -and better luck next time player 2 🙂");
                endGame();
            }

            System.out.println("Player 2's turn! Would you like throw?");
            userResponse();
            rollDice();
            player2Count += dice1 + dice2;
            System.out.println("player 2 is now at " + (int) player2Count + " points!");

            if (player2Count >= 40 && dice1 == dice2) {
                System.out.println("Player 2 has won this game! \nCongrats player 1! -and better luck next time player 2 🙂");
                endGame();
            }
        }
    }
}