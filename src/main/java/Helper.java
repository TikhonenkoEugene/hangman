import java.util.Random;

public class Helper {

    public static int getRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Максимум должен быть больше или равен минимуму");
        }
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
