package pl.FilipM.May23;

//Palindrom
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Z1: Stwórz metodę sprawdzającą czy podane do niej słowo jest\n" +
                "palindromem.");

        //Scanner scan = new Scanner(System.in);
        System.out.println("Napisz coś, a ja powiemi Ci, czy to palindrom:_");
        String userInput = new Scanner(System.in).nextLine();
        System.out.println(isPalinrdome(userInput));
    }

    public static boolean isPalinrdome(String input) {
        String revert = input.replaceAll("\\s", "").toLowerCase();
        int l = revert.length();
                for(int i = 0; i < l/2;i++){
                    if(revert.charAt(i) != revert.charAt(l -1 - i)){
                        return false;
                    }
                }

        return true;
    }
}

