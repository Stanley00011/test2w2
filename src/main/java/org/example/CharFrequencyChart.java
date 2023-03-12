package org.example;

import java.io.*;
import java.util.*;

public class CharFrequencyChart {
    public static void main(String[] args) throws IOException {
        // Ask user for filename to read
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();

        // Read file contents into a string
        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (fileScanner.hasNext()) {
            sb.append(fileScanner.nextLine());
        }
        fileScanner.close();
        String document = sb.toString().toLowerCase();

        // Compute frequency of each alphabet character
        int[] frequencies = new int[26];
        for (char c : document.toCharArray()) {
            if (Character.isLetter(c)) {
                frequencies[c - 'a']++;
            }
        }

        // Generate bar-chart plot of frequencies
        System.out.println("Character frequencies:");
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            System.out.printf("%c: %s\n", c, "*".repeat(frequencies[i]));
        }
    }
}

