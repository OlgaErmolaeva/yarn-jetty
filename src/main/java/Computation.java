import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Computation {

    public static void main(String[] args) {
        int[] numbers = new int[100_000_000];
        Random random = new Random();
        for (int i = 0; i < 100_000_000; i++) {
            numbers[i] = random.nextInt();
        }
        Arrays.sort(numbers);
    }
}
