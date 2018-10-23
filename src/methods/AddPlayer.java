package methods;

import comparators.Player;

import java.util.Scanner;

public class AddPlayer {
    private static Scanner sc = new Scanner(System.in);
    public static Player createPlayer(){
        System.out.println("Podaj imię");
        String name = sc.nextLine();
        System.out.println("Podaj nazwisko");
        String surname = sc.nextLine();
        System.out.println("Podaj wynik");
        int score = sc.nextInt();
        sc.nextLine();
        if(score>9999)
            throw new TooHighScoreException();
        Player player = new Player(name, surname, score);
        return player;
    }
}
