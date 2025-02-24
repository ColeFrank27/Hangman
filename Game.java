import java.util.Scanner;

public class Game {

    public void play() {

        Player player1 = new Player();
        Player player2 = new Player();
        SecretPhrase answer = new SecretPhrase();
        Scanner gameScanner = new Scanner(System.in);

        System.out.println("Welcome to a new game " + player1.getName() + " and " + player2.getName());

        System.out.println("The secret phrase is " + answer.getPhraseLength() + " letters long");

        System.out.println(answer.setPhrase());

        while (!answer.isSolved()) {

            System.out.println("You may now guess(Alternating players each time, player 1 first)");

            String guess = gameScanner.nextLine();

            int points = answer.pointValueForAccurateGuess();

            answer.scoreGuess(guess, points);

            answer.updateKnown(guess);

            System.out.println("The phrase is now " + answer.getKnownPart());

            answer.changeTurn();

            if (answer.getTurn() % 2 == 0) {

                player2.addScore(points);
            }

            if (answer.getTurn() % 2 == 1) {

                player1.addScore(points);
            }

            if (answer.isSolved()) {

                break;
            }
        }

        String winner = "";

        if (player1.getScore() > player2.getScore()) {

            winner = "player1";

        }

        else if (player1.getScore() < player2.getScore()) {

            winner = "player2";
        }

        else {

            winner = " non-existent because it is a tie";
        }

        System.out.println("The winner is " + winner);

    }
}