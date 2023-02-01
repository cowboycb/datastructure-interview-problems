package com.codingfuture.dsip.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Print duplicate characters from String
 */
public class Problem01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a string = ");
        String input = scanner.nextLine();

        if (input == null || input.trim().length() == 0) {
            System.out.println("Please enter a valid string!");
            System.exit(-1);
        }

        if (input.length() == 1) {
            System.out.println("There isn't any duplicated character!");
            System.exit(1);
        }

        Map<String, Integer> mapChars = new HashMap<>();
        
        input.chars()
            .forEach(ch -> {
                String ch1 = String.valueOf((char) ch);
                if (!mapChars.containsKey(ch1)) {
                    mapChars.put(ch1, 0);
                }
                mapChars.put(ch1, mapChars.get(ch1) + 1);
            });

        String result = mapChars.entrySet().stream()
            .filter(entry -> entry.getValue() > 1)
            .map(entry -> entry.getKey() + ":" + entry.getValue())
            .collect(Collectors.joining(", "));
        System.out.println("Duplicated characters: " + result);
    }

}
