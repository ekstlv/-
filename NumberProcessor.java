import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberProcessor {

    public static List<Integer> readNumbersFromFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        List<Integer> numbers = new ArrayList<>();
        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }
        scanner.close();
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("The file is empty or contains no valid integers.");
        }
        return numbers;
    }

    public static int _min(List<Integer> numbers) {
        return numbers.stream().min(Integer::compare).orElseThrow(IllegalStateException::new);
    }

    public static int _max(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).orElseThrow(IllegalStateException::new);
    }

    public static long _sum(List<Integer> numbers) {
        return numbers.stream().mapToLong(Integer::longValue).sum();
    }

    public static long _mult(List<Integer> numbers) {
        return numbers.stream().mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b);
    }
}
