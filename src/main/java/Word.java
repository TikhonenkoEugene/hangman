public class Word {
    private char[] letters;
    private boolean[] hide;
    private int arrSize;

    public Word(String word) {
        this.arrSize = word.length();
        this.letters = new char[this.arrSize];
        this.hide = new boolean[this.arrSize];

        for (int i = 0; i < arrSize; i++) {
            this.letters[i] = word.toUpperCase().charAt(i);
            this.hide[i] = true;
        }

        int half = arrSize / 2;
        hide[half] = false;

        switch (Helper.getRandomInt(1, 3)) {
            case 1 -> hide[0] = false;
            case 2 -> hide[half + 1] = false;
            case 3 -> hide[arrSize - 1] = false;
        }
    }

    public boolean checkLetter(char letter) {
        boolean result = false;
        for (int i = 0; i < arrSize; i++) {
            if (letters[i] == letter) {
                hide[i] = false;
                result = true;
            }
        }
        return result;
    }

    public boolean isWon() {
        for (int i = 0; i < arrSize; i++) {
            if (hide[i]) {
                return false;
            }
        }
        return true;
    }

    public String getMaskedWord() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrSize; i++) {
            if (hide[i]) {
                stringBuilder.append("_ ");
            }
            else {
                stringBuilder.append(letters[i]).append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }

}
