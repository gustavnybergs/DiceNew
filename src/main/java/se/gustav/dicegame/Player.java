package se.gustav.dicegame;

import java.util.Scanner;

public class Player {
    private String name; // Spelarens namn
    private int score;   // Spelarens poäng

    // Konstruktorn ansvarar för att skapa en ny instans av klassen Player genom att tilldela ett
    // namn till spelaren och initialisera spelarens poäng till 0. Den används när en ny spelare skapas med new Player(name).
    public Player(String name) { //Den tar en parameter, en sträng, som representerar spelarens namn.
        this.name = name;
        this.score = 0; // Initialiserar spelarens poäng till 0, betyder att varje ny spelare börjar med noll poäng.
        // Konstruktorn tar inte emot en parameter för score eftersom spelarens poäng
        // alltid initialiseras till 0 när en ny spelare skapas.
    }

    // Metoden används för att returnera spelarens namn.
    public String getName() {
        return name;
    }

    // Metoden används för att returnera spelarens poäng.
    public int getScore() {
        return score;
    }

    // Parametrar: Metoden tar en parameter av typen int, som vi kallar points,
    // som representerar det antal poäng som ska läggas till spelarens nuvarande poäng
    public void addScore(int points) {
        score += points; // Öka poängen med det angivna värdet
    }

    // 6. en statisk metod som skapar en ny instans av klassen Player. Den tar två parametrar:
    // en Scanner för att läsa användarinmatning och ett heltal (int playerNumber) som representerar
    // spelarens nummer (spelare 1, spelare 2 osv.).
    public static Player createPlayer(Scanner scanner, int playerNumber) {
        String playerName = "";
        while (playerName.trim().isEmpty()) {
            System.out.print("Ange namn på spelare " + playerNumber + ": ");
            playerName = scanner.nextLine().trim();
            if (playerName.isEmpty()) {
                System.out.println("Namnet får inte vara tomt. Försök igen.");
            }
        }
        //7. En while-loop används för att säkerställa att användaren matar
        // in ett giltigt namn. Så länge spelarens namn är tomt (det vill säga bara mellanslag eller ingen text alls),
        // kommer loopen att fortsätta be användaren om ett namn. trim() används för att ta bort eventuella extra mellanslag
        //  i början eller slutet av inmatningen, och metoden kontrollerar om det resulterande namnet är tomt.



        return new Player(playerName);
        // Här anropar vi new Player(playerName), vilket skapar en ny instans av Player
        // och anropar konstruktorn för att initialisera objektet med spelarens namn och noll poäng.
    }
}
