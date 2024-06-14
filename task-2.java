import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {
    public static void main(String[] args) {
        // Replace "input.txt" with the path to your file
        String filePath = "input.txt";
        
        // TreeMap to store words and their counts
        Map<String, Integer> wordCounts = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Convert line to lowercase and remove punctuation
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
                for (String word : words) {
                    if (word.isEmpty()) {
                        continue;
                    }
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display the word count in alphabetical order
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
