package June13.registrationForm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // 1. Jeśli użytkownik wprowadzi niepoprawne dane powinniśmy wyświetlić "Niepoprawne dane" i zapytać ponownie co chce zrobić? - zwróć uwagę na komentarze przy poszczególnych nextLine
        // 2. Jeśli wszystkie wprowadzone przez użytkownika dane będą prawidłowe należy dodać go do tablicy uczestników, żeby to zrobić najpierw musimy taką stworzyć!
        //   a. Utwórz klasę Student mającą prywatne pola o nazwach odpowiadających temu co wprowadził użytkownik (imie, nazwisko, pesel, numer telefonu, jezyk, czy oplacony)
        //   b. W klasie Student utwórz gettery i settery
        //   c. W klasie Main w metodzie main na samym początku utwórz tablicę typu Student mającą pojemność 20 elementów (tyle maksymalnie będzie liczyła grupa)
        //   d. W tym samym miejscu utwórz zmienną, która będzie przechowywała wartość liczbową o ostatniej zapełnionej pozycji
        //   e. Po wprowadzeniu wszystkich poprawnych danych utwórz obiekt klasy Student i ustaw za pomocą setterów poszczególne pola na właściwe wartości
        //   f. Dodaj element do tablicy na jej następnej niezapełnionej pozycji
        // 3. Dodaj metodę toString() do klasy Student
        // 4. Dodaj obsługę wyświetlania wszystkich studentów zapisanych w liście (opcja 2)
        // 5. Dodaj obsługę wyświetlania tylko studentów, którzy opłacili kurs (dodaj opcję 3)

        Student[] studentsArray = new Student[20];
        int studentsArrayIdx = 0;

        Scanner scanner = new Scanner(System.in);
        String option;
        do {
            System.out.println("Co chcesz zrobić?");
            System.out.println("1. Zapisać się na kurs");
            System.out.println("2. Wyświetlić listę uczestników");
            System.out.println("3. Wyświetlić listę uczestników, którzy opłacili kurs");
            System.out.println("demo. Wstawić kilku losowych kursantów");
            System.out.println("q. Zakończyć");

            option = scanner.nextLine();

            if ("1".equals(option)) {

                System.out.println("Witaj!\nSłyszałem, że chcesz się zapisać na kurs!\nPodaj swoje dane i preferencje");
                System.out.println("Imię i nazwisko"); // nie powinno zawierać żadnych znaków specjalnych, ANI _
                String nameAndSurname = scanner.nextLine();

                if (!nameAndSurname.matches("[A-ZŁŚŻŹ][a-ząćęłńóśźż]+ ([ -]?[A-Z][a-ząćęłńóśźż]+)+")) {
                    fail();
                    continue;
                }

                System.out.println("PESEL"); // powinien składać się z 9 cyfr - nic więcej nie sprawdzamy
                //* zaawansowane wersja - sprawdzamy czy jest poprawny
                String pesel = scanner.nextLine();
                if (!isPeselValid(pesel)) {
                    fail();
                    continue;
                }

                System.out.println("Numer telefonu"); // powinien składać się w sumie z 9 cyfr, może być rozdzielony w dowolnych miejscach spacją lub myślnikiem. Bez numeru kierunkowego
                String phoneNumber = scanner.nextLine();
                if (!phoneNumber.matches("(\\d[ -]?){9}")) {
                    fail();
                    continue;
                }

                System.out.println("Wybrany język (Java, Python lub C++"); // możliwe wpisanie "Java" lub "Python" lub "C++"
                String language = scanner.nextLine();
                if (!language.matches("(Java)|(java)|(Python)|(python)|(c++)|(C++)")) {
                    fail();
                    continue;
                }

                System.out.println("Czy opłaciłeś już kurs?(tak/nie)"); // możliwe wpisanie "tak" lub "nie"
                String paid = scanner.nextLine();
                if (paid.matches("(Tak)|(tak)")) {
                    //true
                } else if (paid.matches("(Nie)|(nie)")) {
                    //false
                } else {
                    fail();
                }

                Student student = new Student();
                student.setNameAndSurname(nameAndSurname);
                student.setPesel(pesel);
                student.setPhone(phoneNumber);
                student.setLanguage(language);
                student.setPaid(paid.matches("(Tak)|(tak)"));

                if (studentsArrayIdx < 20) {
                    studentsArray[studentsArrayIdx++] = student;
                }

            } else if ("2".equals(option)) {
                System.out.println("Oto wszyscy studenci:");
                //tutaj wypisz całą zawartość tablicy
                for (int i = 0; i < studentsArrayIdx; i++){
                    System.out.println(studentsArray[i]);
                }
            }else if ("3".equals(option)) {
                System.out.println("Oto wszyscy studenci, którzy opłacili kurs:");
                //tutaj wypisz całą zawartość tablicy
                for (int i = 0; i < studentsArrayIdx; i++){
                    if (studentsArray[i].isPaid())
                        System.out.println(studentsArray[i]);
                }
            } else if ("demo".equals(option)) {
                System.out.println("Ilu losowych kursantów chcesz stworzyć?");
                int counter = scanner.nextInt();
                for (int i = 0; i < counter; i++) {
                    Student random = Student.studentRandom();
                    if (studentsArrayIdx < 20) {
                        studentsArray[studentsArrayIdx++] = random;
                    }

                }
            }


        } while (!"q".equals(option));
    }

    static void fail() {
        System.out.println("Niewłaściwe dane");
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
}
