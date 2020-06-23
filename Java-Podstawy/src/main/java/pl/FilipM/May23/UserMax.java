package pl.FilipM.May23;

import java.util.Scanner;

public class UserMax {
    public static void main(String[] args) {
        System.out.println("ile liczb chcesz podać?");
        int tabLength = new Scanner(System.in).nextInt();

        int userInt;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < tabLength; i++) {
            System.out.print("Podaj liczbę:");
            userInt = new Scanner(System.in).nextInt();
            if (userInt > max) {
                max = userInt;
            }
        }

        System.out.println("Najwyższa z podanych liczb to: " + max);
    }

//    public static int userMax(int[] ints) {
//        int max = ints[0];
//        for (int i = 1; i < ints.length; i++) {
//            if (ints[i] > max) {
//                max = ints[i];
//            }
//        }
//        return max;
//    }
}
