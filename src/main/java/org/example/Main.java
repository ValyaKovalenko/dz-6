package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"мама", "папа", "їж їжак желе"};
        char[] uniqueLetters = findUniqueLettersInEvenWords(words);
        System.out.println(Arrays.toString(uniqueLetters));
    }

    public static char[] findUniqueLettersInEvenWords(String[] words) {
        List<String> evenWords = new ArrayList<>();

        // Знаходимо перші два слова, в яких кожен символ трапляється парну кількість разів
        int count = 0;
        for (String word : words) {
            if (isEvenCharacterCount(word)) {
                evenWords.add(word);
                count++;
                if (count >= 2) {
                    break;
                }
            }
        }

        // Знаходимо набір унікальних символів в цих словах
        Set<Character> uniqueLettersSet = new HashSet<>();
        for (String evenWord : evenWords) {
            for (char ch : evenWord.toCharArray()) {
                uniqueLettersSet.add(ch);
            }
        }

        // Перетворюємо набір унікальних символів в масив char
        Character[] uniqueLettersArray = uniqueLettersSet.toArray(new Character[0]);
        char[] result = new char[uniqueLettersArray.length];
        for (int i = 0; i < uniqueLettersArray.length; i++) {
            result[i] = uniqueLettersArray[i];
        }

        return result;
    }

    // Перевіряємо, чи має слово парну кількість кожного символу
    private static boolean isEvenCharacterCount(String word) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char ch : word.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        for (int count : charCountMap.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}