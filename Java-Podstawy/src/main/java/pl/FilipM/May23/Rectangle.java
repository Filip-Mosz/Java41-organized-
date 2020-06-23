package pl.FilipM.May23;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        System.out.println("Podaj wysokość");
        int h = new Scanner(System.in).nextInt();
        System.out.println("Podaj szerokość");
        int w = new Scanner(System.in).nextInt();

        Rectangle(h, w);
        System.out.println();
        System.out.println("Oraz fajniejszy");
        System.out.println();
        RectangleUltra(h, w);
    }

    public static void Rectangle(int h, int w) {
        for (int i = 0; i <= h; i++){
            for(int j = 0; j <= w; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void RectangleUltra(int h, int w) {
        for (int i = 0; i <= h; i++){
            for(int j = 0; j <= w; j++){
                if(i == 0 || i == h){
                    System.out.print("-");
                } else if(j == 0 || j == w){
                    System.out.print("|");
                } else System.out.print("*");
            }
            System.out.println();
        }
    }
}
