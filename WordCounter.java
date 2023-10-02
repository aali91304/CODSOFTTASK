import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java .util.Scanner;
public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Prompt the user
        System.out.println("Enter text or provide a file path to count words:");

        // Step 2: Read the input text or file
        String input = scanner.nextLine();

        // Step 3: Split the string into an array of words
        String[] words = getWords(input);

        // Step 4: Initialize a counter variable
        int wordCount = 0;

        // Step 5: Iterate through the array of words and count
        for (String word : words) {
            // Additional step (7): Ignore common words (stop words)
            if (!isStopWord(word)) {
                wordCount++;
            }
        }

        // Step 6: Display the total count of words to the user
        System.out.println("Total word count: " + wordCount);

        // Additional steps (8): Provide statistics
        displayWordStatistics(words);

        scanner.close();
    }

    // Step 3: Split the string into an array of words
    private static String[] getWords(String input) {
        // Assuming words are separated by space or punctuation
        return input.split("[\\s\\p{Punct}]+");
    }

    // Additional step (7): Check if a word is a stop word
    private static boolean isStopWord(String word) {
        // Add your list of stop words here
        String[] stopWords = {"the", "and", "is", "in", "of", "to", "a", "for"};
        for (String stopWord : stopWords) {
            if (stopWord.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }

    // Additional steps (8): Display word statistics
    private static void displayWordStatistics(String[] words) {
        // Additional step (8): Count unique words and their frequency
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            if (!isStopWord(word)) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        // Display unique word count
        System.out.println("Unique word count: " + wordFrequency.size());

        // Display word frequency
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
