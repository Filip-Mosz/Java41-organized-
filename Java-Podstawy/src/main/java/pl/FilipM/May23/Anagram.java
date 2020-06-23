package pl.FilipM.May23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        System.out.println("Napisz dwa słowa, a ja powiemi Ci, czy to anagramy.");
        System.out.print("Pierwsze słowo ");
        String word1 = new Scanner(System.in).nextLine();
        System.out.print("Drugie słowo ");
        String word2 = new Scanner(System.in).nextLine();
        System.out.println(isAnagram(word1, word2));
        System.out.println(isAnagramByArray(word1, word2));

    }

    public static String isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return "To na pewno nie jest anagram";
        }

        int l = word1.length();
        List<Character> word2List = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            word2List.add(word2.charAt(i));
        }

        for (int i = 0; i < l; i++) {
            if(word2List.contains(word2.charAt(i))){
                word2List.remove(Character.valueOf(word2.charAt(i)));
            } else{
                return "To nie jest anagram";
            }

        }
        return "To anagram";
    }

    public static String isAnagramByArray(String word1, String word2){
        char[] firstWord = word1.toLowerCase().toCharArray();
        char[] secondWord = word2.toLowerCase().toCharArray();

        Arrays.sort(firstWord); //ukłąda zawartość w kolejności
        Arrays.sort(secondWord);
        if(Arrays.equals(firstWord, secondWord)){
            return "To anagram";
        }

return "To nie jest anagram";
    }
}
