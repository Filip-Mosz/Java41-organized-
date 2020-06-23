package Marcin;

import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Zadanie1. Sprawdź czy podana przez użytkownika liczba jest liczbą pierwszą");
//        System.out.println("Podaj liczbę całkowitą: ");
//        int userInt = new Scanner(System.in).nextInt();
//        System.out.println(isPrime(userInt));
//
//        System.out.println();
//        System.out.println("Zadanie2. Zwróć dwie ostatnie cyfry silni liczby podanej przez użytkownika.");
//        userInt = new Scanner(System.in).nextInt();
//        System.out.println(last2OfFactorial(userInt));
//
//        System.out.println();
//        System.out.println("Zadanie3. Usuń wszystkie samogłoski z podanego przez użytkownika wyrazu");
//        String userWord = new Scanner(System.in).nextLine();
//        System.out.println(vowelRemove(userWord));
//
//        System.out.println();
//        System.out.println("Zadanie4. Napisz metodę która sklei ze sobą dwa łańcuchy biorąc na przemian po jednym znaku z każdego łańcucha. \nNależy wziąć po tyle znaków ile jest w krótszym łańcuchu.");
//        System.out.println("Podaj pierwsze słowo ");
//        String userWord3 = new Scanner(System.in).nextLine();
//        System.out.println("Podaj drugie słowo ");
//        String userWord2 = new Scanner(System.in).nextLine();
//        System.out.println(stringMix(userWord2, userWord3));

        System.out.println();
        System.out.println("Zadanie5. Sprawdź, czy podana liczba 11-cyfrowa jest poprawnym PESELem.");
//        Aby sprawdzić czy dany PESEL jest prawidłowy należy wykonać następujące działania:
//        Pierwszą cyfrę mnożymy przez 1,
//                drugą cyfrę mnożymy przez 3,
//                trzecią cyfrę mnożymy przez 7,
//                czwarta cyfrę mnożymy przez 9,
//                piątą cyfrę mnożymy przez 1,
//                szóstą cyfrę mnożymy przez 3,
//                siódmą cyfrę mnożymy przez 7,
//                ósmą cyfrę mnożymy przez 9,
//                dziewiątą cyfrę mnożymy przez 1,
//                dziesiątą cyfrę mnożymy przez 3,
//                jedenastą cyfrę mnożymy przez 1.
//        Tak uzyskane 11 iloczynów dodajemy do siebie. Jeśli ostatnia cyfra tej sumy jest zerem to podany PESEL jest prawidłowy. Przykład dla numeru PESEL 44051401458
//        4*1 + 4*3 + 0*7 + 5*9 + 1*1 + 4*3 + 0*7 + 1*9 + 4*1 + 5*3 + 8*1 = 4 + 12 + 0 + 45 + 1 + 12 + 0 + 9 + 4 + 15 + 8 = 110
        String pesel = "44051401458";
        System.out.println(pesel);
        System.out.println(isPeselValid(pesel));

        System.out.println("\n6. Napisz program zamieniający liczbę na słowną reprezentację np. 1 -> jeden, 11 -> jedenaście, 111 -> sto jedenaście\n" +
                "(Może być w innym języku)\n");
        int[] intInput = new int[]{-999, 1, 100, 11, 20, 65, - 11, 0, -358};

        for (int i = 0; i < intInput.length; i++) {
            System.out.println(intInput[i] + " " + wordRepresentationTo999(intInput[i]));
        }


    }

    static boolean isPrime(int number) {
        //liczby pierwsze dzielą się bez reszty TYLKO przez 1 i samą siebie (z wyłączeniem 2 są nieparzyste)
// jeśli numer jest podzielny bez reszty, przez jakąkolwiek liczbę mniejszą od siebie NIE jest liczbą pierwszą
        if (number > 1) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    static String last2OfFactorial(int number) {

        long facto = FactorialRecu(number);
        //zrobić regEx'em, łapiącym 2 ostatnie znaki
        Pattern pattern = Pattern.compile(".*(?<result>\\d{2}$)");
        String stringFacto = String.valueOf(FactorialRecu(number));
        Matcher matcher = pattern.matcher(stringFacto);
//        System.out.println("Silnia " + stringFacto);
        matcher.matches(); //jak tego nie ma, to nie działa. HMMM...


        return "Ostatnie dwie cyfry silni z " + number + " to: " + matcher.group("result");
    }

    public static long FactorialRecu(long in) {
        if (in <= 1) {
            return 1;
        }

        return in * FactorialRecu(in - 1);
    }

    static String vowelRemove(String word) {
        StringBuilder resultBuild = new StringBuilder();
        char[] consonants = new char[]{'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't', 'w', 'z', 'v', 'x'};
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < consonants.length; j++) {
                if (word.charAt(i) == consonants[j]) {
                    resultBuild.append(word.charAt(i));
                }
            }
        }

        return resultBuild.toString();
    }

    static String stringMix(String word1, String word2) {
        StringBuilder resultBuild = new StringBuilder();

        int lenght = 0;
        if (word1.length() < word2.length()) {
            lenght = word1.length();
        } else {
            lenght = word2.length();
        }

        for (int i = 0; i < lenght; i++) {
            resultBuild.append(word1.charAt(i));
            resultBuild.append(word2.charAt(i));
        }

        return resultBuild.toString();
    }

    static boolean isPeselValid(String input) {
        String[] pesel = new String[input.length()];
        Pattern peselPattern = Pattern.compile(".*0$");
        int result = 0;
        int[] peselMultiplyRules = new int[]{1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};

        if (input.length() != 11) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            pesel[i] = String.valueOf(input.charAt(i));
            result += Integer.parseInt(pesel[i]) * peselMultiplyRules[i];
        }



//        for (int i = 0; i < peselMultiply.length; i++){
//            result += peselMultiply[i];
//        }


        return peselPattern.matches(".*0$", String.valueOf(result));
    }

    static String wordRepresentationTo999(int intValue) {
        String minus = "";
        String ones = "";
        String tens = "";
        String hundreds = "";
        int intOnes = intValue % 10;
        int intTens = (intValue - ((100 * (intValue / 100))) - intOnes) / 10;
        int intHundreds = intValue / 100;
        String[] onesArray = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teensArray = new String[]{"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tensArray = new String[]{"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        if (intValue == 0){
            return "Zero";
        }

        if (intValue < 0) {
            minus = "minus ";

        } else {
            minus = "";
        }

        if (Math.abs(intHundreds) >= 1) {
            hundreds = onesArray[Math.abs(intHundreds)] + "hundred";
        }

        ones = onesArray[Math.abs(intOnes)];

        if (Math.abs(intTens) >= 1) {
            if (Math.abs(intTens) < 2) {
                tens = teensArray[Math.abs(intTens)];
                ones = "";
            } else {
                tens = tensArray[Math.abs(intTens)];
                ones = onesArray[Math.abs(intOnes)];
            }
        }


//value 235
//value/100 wyciąga setki 2
//value - (100 * (value/100)) / 10 wyciąga dziesiątki 3
//value%10 wyciąga jednostki 5

        //wylapac regexem czy to jednosci, dziesiatki itd; wynik odniesc jako index tablicy

        String result = new StringBuilder().append(minus).append(hundreds).append(tens).append(ones).toString();
        return result;
    }
    static String wordRepresentationTo999ByRegEx(int intValue) {
        String minus = "";
        String ones = "";
        String tens = "";
        String hundreds = "";
        int intOnes = intValue % 10;
        int intTens = (intValue - ((100 * (intValue / 100))) - intOnes) / 10;
        int intHundreds = intValue / 100;
        String[] onesArray = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "WtF?"};
        String[] teensArray = new String[]{"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "WTF?"};
        String[] tensArray = new String[]{"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety", "wtf?"};

        if (intValue == 0){
            return "Zero";
        }

        if (intValue < 0) {
            minus = "minus ";

        } else {
            minus = "";
        }

        if (Math.abs(intHundreds) >= 1) {
            hundreds = onesArray[Math.abs(intHundreds)] + "hundred";
        }

        ones = onesArray[Math.abs(intOnes)];

        if (Math.abs(intTens) >= 1) {
            if (Math.abs(intTens) < 2) {
                tens = teensArray[Math.abs(intTens)];
                ones = "";
            } else {
                tens = tensArray[Math.abs(intTens)];
                ones = onesArray[Math.abs(intOnes)];
            }
        }


//value 235
//value/100 wyciąga setki 2
//value - (100 * (value/100)) / 10 wyciąga dziesiątki 3
//value%10 wyciąga jednostki 5

        //wylapac regexem czy to jednosci, dziesiatki itd; wynik odniesc jako index tablicy

        String result = new StringBuilder().append(minus).append(hundreds).append(tens).append(ones).toString();
        return result;
    }
}
