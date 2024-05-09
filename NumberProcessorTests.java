import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class NumberProcessorTests {

    @Test
    public void testMin() {
        List<Integer> numbers = Arrays.asList(1, 4, 2, 3);
        assertEquals(1, NumberProcessor._min(numbers));
    }

    @Test
    public void testMax() {
        List<Integer> numbers = Arrays.asList(1, 4, 2, 3);
        assertEquals(4, NumberProcessor._max(numbers));
    }

    @Test
    public void testSum() {
        List<Integer> numbers = Arrays.asList(1, 4, 2, 3);
        assertEquals(10, NumberProcessor._sum(numbers));
    }

    @Test
    public void testMult() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        assertEquals(24, NumberProcessor._mult(numbers));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReadEmptyFile() throws FileNotFoundException {
        NumberProcessor.readNumbersFromFile("empty.txt");
    }

    @Test(expected = FileNotFoundException.class)
    public void testFileNotFound() throws FileNotFoundException {
        NumberProcessor.readNumbersFromFile("nonexistent.txt");
    }
}

