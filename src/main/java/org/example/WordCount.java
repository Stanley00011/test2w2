package org.example;

import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        // Initialize a scanner to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Initialize a map to store the word count
        Map<String, Integer> wordCount = new HashMap<>();

        // Read the input string
        System.out.println("Enter a list of words separated by whitespace:");
        String input = scanner.nextLine();

        // Split the input string into an array of words
        String[] words = input.split("\\s+");

        // Count the number of occurrences of each word
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        // Print the word count
        System.out.println("Word count:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.printf("%-15s %d%n", entry.getKey(), entry.getValue());
        }
    }
}
