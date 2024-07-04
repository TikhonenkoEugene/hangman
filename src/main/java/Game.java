public class Game {
    private Word word;
    private int mistakes;
    private boolean won;
    private boolean lose;

    public Game(String[] arr) {
        this.word = new Word(arr[Helper.getRandomInt(0, arr.length - 1)]);
        this.mistakes = 0;
    }

    public boolean isWon() {
        return this.won;
    }

    public boolean isLose() {
        return this.lose;
    }
    public static void printGreetings() {
        System.out.println("Добро пожаловать в игру 'Виселица'");
        System.out.println("===   N - начать новую игру   ===");
        System.out.println("===   Q - выйти из игры       ===");
        System.out.println("=================================");
        System.out.print("Введите команду: ");
    }

    public void printWord() {
        System.out.println("Загаданное слово: " + word.getMaskedWord());
    }

    public void printWon() {
        won = true;
        System.out.println("Вы отгадали слово, поздравляю!");
    }

    public void printLose() {
        lose = true;
        System.out.println(" Вы повешены =) ");
    }

    public void printHangman() {
        System.out.println();
        if (mistakes == 1) {
            System.out.println("  |---|");
            System.out.println("  |   o");
            System.out.println("  |");
            System.out.println("  |");
        }
        else if (mistakes == 2) {
            System.out.println("  |---|");
            System.out.println("  |   o");
            System.out.println("  |   |");
            System.out.println("  |");
        }
        else if (mistakes == 3) {
            System.out.println("  |---|");
            System.out.println("  |   o");
            System.out.println("  |  -|-");
            System.out.println("  |");
        }
        else if (mistakes == 4) {
            System.out.println("  |---|");
            System.out.println("  |   o");
            System.out.println("  |  -|-");
            System.out.println("  |  /");
        }
        else if (mistakes == 5) {
            System.out.println("  |---|");
            System.out.println("  |   o");
            System.out.println("  |  -|-");
            System.out.println("  |  /|");
        }
        printWord();
        System.out.println();
    }

    public void inputLetter(String string) {
        boolean isExist = word.checkLetter(string.charAt(0));
        if (word.isWon()) {
            printWon();
        }
        else {
            if (isExist) {
                System.out.println("Вы угадали букву");
                printWord();
            }
            else {
                mistakes++;
                System.out.println("Вы не угадали букву");
                printHangman();
            }
        }
        if (mistakes >= 5) {
            printLose();
        }
    }
}
