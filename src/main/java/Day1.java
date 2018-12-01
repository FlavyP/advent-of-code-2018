import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day1 {

    private static final String FILE_NAME = "src/main/resources/day1input.txt";

    List<Integer> intInput;

    public Day1() {
        try {
            intInput = Files.lines(Paths.get(FILE_NAME)).map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("welp");
        }
    }

    public int partOne() {
        int sum = intInput.stream().mapToInt(x -> x).sum();
        return sum;
    }

    public int partTwo() {
        int sum = 0;
        Set<Integer> sumSet = new HashSet<>();
        for (int i = 0; i < intInput.size(); i++) {
            sum += intInput.get(i);
            if (!sumSet.add(sum)) {
                return sum;
            }
            if (i == intInput.size() - 1) {
                i = -1;
            }
        }
        return -1;
    }
}
