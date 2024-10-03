package se.gustav.dicegame;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int NUM_ROLLS = 2; // 1.Vi använder final för att göra variabeln konstant, vilket innebär
    //  att värdet på NUM_ROLLS inte kan ändras under programmets gång vilket gör koden mer stabil och förutsägbar.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//2. För att kunna ta in användarinput
        Random random = new Random(); //3.För att vi ska få fram ett slumpmässigt tal, i detta fall ett tal mellan 1-6

        System.out.println("Välkommen till tärningsspelet!"); // 4.Välkomnar användarna

        // 5.createPlayer är statisk metod vilket gör att vi kan anropa den direkt på klassen Player utan att först
        // skapa en instans av Player. Vi gör alltså anropet direkt på klassen Player som Player.createPlayer
        // Inuti den statiska metoden createPlayer, skapas själva instansen av Player 1 o 2 med tilldelning av varibeln 1
        // som motsvarar player1 och 2 som motsvarar player2.
        Player player1 = Player.createPlayer(scanner, 1); // Spelare 1 skapad
        Player player2 = Player.createPlayer(scanner, 2); // Spelare 2 skapad

        // 8. Spelar spelet där varje spelare kastar tärningen
        playGame(player1, player2, random);
        // 9. Parametrar: Metoden tar emot två instanser av klassen Player (spelare 1 och spelare 2)
        // samt en instans av klassen Random. Player-objekten representerar de två spelarna som
        // deltar i spelet, och Random-objektet används för att generera slumpmässiga tärningskast.

        // 15. Visa resultatet och avgör vinnaren
        displayResults(player1, player2);

        scanner.close();
    }

    // 10. Loopen styrs av en konstant variabel NUM_ROLLS, som specificerar hur många kast varje spelare får.
    private static void playGame(Player player1, Player player2, Random random) {
        for (int i = 0; i < NUM_ROLLS; i++) {
            rollDice(player1, random); // Spelare 1 kastar
            rollDice(player2, random); // Spelare 2 kastar
        }
        // 11. Inuti varje iteration av loopen anropas metoden rollDice. Denna metod ansvarar
        // för att hantera varje spelares tärningskast genom att använda Random
        // för att generera ett slumpmässigt tal och sedan uppdatera spelarens poäng.
    }

    // 12. Parametrar: Metoden tar emot en instans av klassen Player och en instans av klassen Random.
    private static void rollDice(Player player, Random random) {
        System.out.println(player.getName() + " kastar tärningen...");
        int roll = random.nextInt(6) + 1; // 13. Anropar random.nextInt(6), lägger till +1 annars kommer
        // slumpmässiga tal genereras mellan 0 och 5 (inte inklusive 6). men tärningen är 1-6 och därav +1
        System.out.println(player.getName() + " fick: " + roll);
        player.addScore(roll); // 14. tärningsresultatet till spelarens totalpoäng genom att anropa spelarens metod addScore.
    }

    // 16. Parametrar: Metoden tar emot två instanser av klassen Player som representerar spelare 1 och spelare 2.
    // Både getName() och getScore() finns definierade som instansmetoder i Player-objektet.
    // Dessa metoder används för att hämta spelarens namn och poäng

    private static void displayResults(Player player1, Player player2) {
        System.out.println("\nResultat:");
        System.out.println(player1.getName() + " totalpoäng: " + player1.getScore());
        System.out.println(player2.getName() + " totalpoäng: " + player2.getScore());
        //17. Metoden skriver sedan ut resultatet för båda spelarna till konsolen.
        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1.getName() + " vinner!");
        } else if (player2.getScore() > player1.getScore()) {
            System.out.println(player2.getName() + " vinner!");
        } else {
            System.out.println("Det blev oavgjort!");
            //18. Vi använder if-else för att avgöra vinnaren eller om
            // det är oavgjort och skriver ut resultatet till konsolen. GTP ->
        }
    }
}
