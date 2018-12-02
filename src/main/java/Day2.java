import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day2 {

    private static final String FILE_NAME = "src/main/resources/day2input.txt";

    List<String> input;

    public Day2() {
        try {
            input = Files.lines(Paths.get(FILE_NAME)).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("welp");
        }
    }

    public int partOne() {
        int twoLetterWord = 0;
        int threeLetterWord = 0;
        for (String word : input) {
            boolean twoLetterCounted = false;
            boolean threeLetterCounted = false;
            Map<Character, Integer> letterMap = new HashMap<>();
            for (Character c : word.toCharArray()) {
                if (letterMap.get(c) != null) {
                    letterMap.put(c, letterMap.get(c) + 1);
                } else {
                    letterMap.put(c, 1);
                }
            }
            System.out.println("WORD = " + word);
            for (Character c : letterMap.keySet()) {
                if (letterMap.get(c) == 2 && !twoLetterCounted) {
                    twoLetterWord++;
                    System.out.println("CHAR = " + c);
                    System.out.println("CHAR COUNT = " + letterMap.get(c));
                    System.out.println("TOTAL 2 LETTER = " + twoLetterWord);
                    twoLetterCounted = true;
                    continue;
                } else if (letterMap.get(c) == 3 && !threeLetterCounted) {
                    threeLetterWord++;
                    System.out.println("CHAR = " + c);
                    System.out.println("CHAR COUNT = " + letterMap.get(c));
                    System.out.println("TOTAL 3 LETTER = " + threeLetterWord);
                    threeLetterCounted = true;
                    continue;
                }
            }
            System.out.println("----------------------------------");
        }
        return twoLetterWord * threeLetterWord;
    }

    public String partTwo() {
        for (String word1 : input) {
            for (String word2 : input) {
                int charDiff = 0;
                StringBuffer sb = new StringBuffer();
                for (int x = 0; x < word1.length(); x++) {
                    if (word1.charAt(x) == word2.charAt(x)) {
                        sb.append(word1.charAt(x));
                    } else {
                        charDiff++;
                    }
                    if (charDiff > 1) {
                        break;
                    }
                }
                if (charDiff == 1) {
                    System.out.println(word1);
                    System.out.println(word2);
                    return sb.toString();
                }
            }
        }
        return "";
    }
}
