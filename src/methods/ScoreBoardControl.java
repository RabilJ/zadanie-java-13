package methods;

import comparators.NameComparator;
import comparators.Player;
import comparators.ScoreComparator;
import comparators.SurnameComparator;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ScoreBoardControl {
    private static Scanner sc = new Scanner(System.in);
    private List<Player> players = new ArrayList<>();


    public void MainLoop() throws IOException {
        BufferedWriter bfw = new BufferedWriter(new FileWriter("board.csv"));
        String safeWord;
        System.out.println("Dodaj gracza");

        do {
            boolean check1 = true;
            while (check1) {

                try {
                    Player player = AddPlayer.createPlayer();
                    players.add(player);
                    check1 = false;
                } catch (TooHighScoreException ex) {
                    System.out.println("Wynik nie może przekroczyć 9999, spróbuj ponownie");
                } catch (InputMismatchException ex1) {
                    System.out.println("Wprowadziłeś błędne dane, spróbuj ponownie");
                }
            }
            System.out.println("Naciśnij enter, żeby dodać kolejnego gracza lub  wpisz stop, by przejść do następnego punktu");
            safeWord = sc.nextLine();
        } while (!safeWord.equals("stop"));

        System.out.println("Po jakiej wartości chcesz posortować listę? Imie/Nazwisko/Wynik");
        String choice = sc.nextLine();
        while (!choice.equals("Imie")&&!choice.equals("Nazwisko")&&!choice.equals("Wynik")) {
            System.out.println("Nie mamy takiej opcji sortowania. Wpisz Imie/Nazwisko/Wynik");
            choice = sc.nextLine();
        }
        switch (choice) {
            case "Imie":
                Collections.sort(players, new NameComparator());
                for (Player player : players) {
                    bfw.write(player.getName() + ";" + player.getSurname() + ";" + player.getScore());
                    bfw.newLine();
                }
                bfw.flush();
                bfw.close();
                System.out.println("Zapisano do pliki.csv");
                break;
            case "Nazwisko":
                Collections.sort(players, new SurnameComparator());
                for (Player player : players) {
                    bfw.write(player.getSurname() + ";" + player.getName() + ";" + player.getScore());
                    bfw.newLine();
                }
                bfw.flush();
                bfw.close();
                System.out.println("Zapisano do pliki.csv");
                break;
            case "Wynik":
                Collections.sort(players, new ScoreComparator());
                for (Player player : players) {
                    bfw.write(player.getScore() + ";" + player.getName() + ";" + player.getSurname());
                    bfw.newLine();
                }
                bfw.flush();
                bfw.close();
                System.out.println("Zapisano do board.csv");
                break;
        }
        sc.close();
    }
}