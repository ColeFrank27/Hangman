import java.util.Scanner;

public class Player {

    private int score = 0;
    private String name;
    private static Scanner sc = new Scanner(System.in);

    public Player() {
        System.out.println("Input the player's names");
        this.name = sc.nextLine();
        this.score = 0;

    }

    public void setName() {
        System.out.println("Input the name of the player");
        String userName = sc.nextLine();
        name = userName;

    }

    public void addScore(int points) {

        score += points;
    }

    public int getScore() {

        return score;
    }

    public String getName() {

        return name;

    }

}