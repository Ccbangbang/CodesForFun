import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        while (true) {
            System.out.println("Choose your game mode:");
            System.out.println("1: Single Card - High Card Wins");
            System.out.println("2: Texas Hold'em");
            System.out.println("3: Exit");

            int choice = scanner.nextInt();

            if (choice == 3) {
                System.out.println("Exiting game...");
                break;
            }

            switch (choice) {
                case 1:
                    game.setDealStrategy(new SingleCompare());
                    break;
                case 2:
                    game.setDealStrategy(new Texas());
                    break;
                default:
                    System.out.println("Invalid choice, defaulting to Single Card mode.");
                    game.setDealStrategy(new SingleCompare());
            }

            // Reset the deck and players' hands for each round
            game.resetGame();

            game.addPlayer(new Player("Alice"));
            game.addPlayer(new Player("Bob"));
            game.addPlayer(new Player("Zhichao"));

            game.start();
            game.showHands();

            System.out.println("Do you want to play another round? (yes/no)");
            scanner.nextLine(); // Consume the newline character left by nextInt()
            String continueGame = scanner.nextLine();

            if (!continueGame.equalsIgnoreCase("yes")) {
                System.out.println("Exiting game...");
                break;
            }
        }

        scanner.close();
    }
}
