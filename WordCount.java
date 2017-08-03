import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {

    public static void main(String[] args) throws IOException {
        new WordCount().count(args[0], Integer.valueOf(args[1]));
    }

    private void count(String fileName, int count) throws IOException {

        validate(count);

        BufferedReader br = readFile(fileName);

        Map<String, Integer> words = calcWords(br);

        Map<String, Integer> wordsSorted = words.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        print(wordsSorted, count);
    }

    private BufferedReader readFile(String fileName) {
        try {
            return new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Map<String, Integer> calcWords(BufferedReader br) throws IOException {
        Map<String, Integer> words = new HashMap<>();
        String input = null;
        while ((input = br.readLine()) != null) {
            if (input.isEmpty()) {
                continue;
            }

            String[] lineWords = input.trim().toLowerCase().replace(".", " ").replaceAll(",", " ").replaceAll("\\s+", " ").split(" ");
            Arrays.stream(lineWords).forEach(lineWord -> words.put(lineWord, words.get(lineWord) == null ? 1 : words.get(lineWord) + 1));
        }

        return words;
    }

    private void print(Map<String, Integer> words, int count) {
        int counter = 0;
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (counter == count) {
                break;
            }
            counter++;
            System.out.print(entry + " ");
        }
    }

    private void validate(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("Invalid count specified: " + count);
        }
    }
}
