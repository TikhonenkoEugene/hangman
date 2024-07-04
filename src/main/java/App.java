import java.util.Scanner;

public class App {
    private static State state = State.COMMAND;
    private static String[] words = new String[]{
            "ЧЕЛОВЕК",
            "ТЕЛЕФОН",
            "ПИРОЖОК"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = null;
        Game.printGreetings();
        boolean play = true;

        while (play) {
            if (game != null && (game.isWon() | game.isLose())) {
                state = State.ASK;
                System.out.println();
                System.out.println("Хотите повторить игру?");
                System.out.println("[Y]es или [N]o");
            }

            String string = scanner.nextLine().toUpperCase();
            switch (state) {
                case COMMAND -> {
                    if (string.equals("N")) {
                        state = State.LETTER;
                        game = new Game(words);
                        game.printWord();
                    }
                    else if (string.equals("Q")) {
                        System.out.println("Выход из игры");
                        scanner.close();
                        play = false;
                    }
                    else {
                        System.out.println("Err: The command is not supported!");
                    }
                }
                case ASK -> {
                    if (string.equals("Y")) {
                        state = State.LETTER;
                        game = new Game(words);
                        game.printWord();
                    }
                    else if (string.equals("N")) {
                        System.out.println("Выход из игры");
                        scanner.close();
                        play = false;
                    }
                    else {
                        System.out.println("Err: The command is not supported!");
                    }
                }
                case LETTER -> {
                    if (string.length() > 1) {
                        System.out.println("Введите одну букву");
                    }
                    else {
                        game.inputLetter(string);
                    }
                }
            }
        }
    }
}
