import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {

    public static void main(String[] args) throws IOException {
//        new WordCount().count(args[0], Integer.valueOf(args[1]));
        new WordCount().count("src/lyrics.txt", 5);
//        new WordCount().count("src/test.txt", 3);
    }

    private void count(String fileName, int count) throws IOException {

        validate(count);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String input = null;

        Map<String, Integer> words = new TreeMap<>();

        while ((input = br.readLine()) != null) {
            if (input.isEmpty()) {
                continue;
            }

            String[] lineWords = input.trim().toLowerCase().replace(".", " ").replaceAll(",", " ").replaceAll("\\s+", " ").split(" ");

            for (String word : lineWords) {
                Integer value = words.get(word);
                if (value != null) {
                    words.put(word, ++value);
                } else {
                    words.put(word, 1);
                }

            }
        }

        MyComparator comp = new MyComparator(words);

        Map<String, Integer> wordsSorted = new TreeMap<>(comp);
        wordsSorted.putAll(words);

        print(wordsSorted, count);
    }

    private void print(Map<String, Integer> words, int count) {
        int counter = 0;
        for ( Map.Entry<String, Integer> entry : words.entrySet()) {
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

class MyComparator implements Comparator {

    private Map<String, Integer> map;

    public MyComparator(Map<String, Integer> map) {
        this.map = map;
    }

    public int compare(Object o1, Object o2) {
        return (map.get(o2)).compareTo(map.get(o1));
    }
}
