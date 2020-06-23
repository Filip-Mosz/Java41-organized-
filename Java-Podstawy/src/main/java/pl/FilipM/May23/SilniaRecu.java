package pl.FilipM.May23;

import java.util.Scanner;

public class SilniaRecu {
    public static void main(String[] args) {
        System.out.print("Podaj liczbę: ");
        long factor = new Scanner(System.in).nextInt();
        System.out.println(factor + "! = " + FactorialRecu(factor));
    }

    public static long FactorialRecu(long in){
        if(in <= 1){
            return 1;
        }

        return in*FactorialRecu(in-1);
    }
}