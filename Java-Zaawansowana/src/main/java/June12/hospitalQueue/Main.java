package June12.hospitalQueue;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*
            Twoim zadaniem jest napisanie aplikacji służącej do decydowania o kolejności przyjęć w szpitalu.
            Aplikacja powinna pozwalać na:
                a Rejestrację nowego pacjenta, chyba ze dlugosc kolejki jest wieksza niz 20
                b Pobieranie następnej osoby z kolejki
                c Podglądanie kto jest następny w kolejce
                d Posiadać tryb demo w którym:
                e zamiast ręcznie dodawać osoby aplikacja będzie startowała z 10 osobami w kolejce
            1. Utwórz klasę Patient mającą pola:
                * imie (String)
                * nazwisko (String)
                * jakBardzoZly (int) - opisuje poziom zlosci
                * rozpoznanaChoroba (String)
                * pamietaj o angielskich nazwach, konstruktorze, getterach i setterach jesli potrzebujesz
            2. Utwórz klasę HospitalQueue, która
               a ma pole typu Queue (patientQueue)
               b utwórz metodę add(Patient) -> dodaje pacjenta
               c utwórz metodę Patient next() -> zwracającą kolejną osobę z kolejki i usuwającą ją z niej
               d Patient peek() -> podglądającą kto jest (zwraca kolejną osobę bez usuwania jej z kolejki)
            3. W main stwórz menu:
                a Następny - wywołujące next i wypisujące co zostało z tego next zwrócone
                b Kto następny - wywołujące peek() i wypisujące kto jest następny
                c Nowy pacjent - umożliwiające podanie imienia, nazwiska, złości i rozpoznanej choroby, a następnie wrzucające to na kolejkę (te dane pobierz za pomocą Scannera)
            4.* Zamiast przechowywac rozpoznana chorobe w Stringu trzymaj ja jako klase - razem
            5. Tryb demo:
                a Co 2 sekundy aplikacja dodaje losową osobę (losujemy imię, nazwisko, chorobę z tablicy, jak bardzo zły - losujemy liczbę)
                b Co 2 sekundy + random max 1s aplikacja przyjmuje pacjenta

                todo tu skończyłem
            6. Zamiast przyjmować pacjentów w kolejności naturalnej przyjmuj ich według priorytetu:
                a Metoda next powinna zwracać najpierw osoby o nazwisku “Kowalski” (to nazwisko ordynatora),
                   ** pomyśl w przyszłości o ładowaniu jej z pliku properties za pomocą klasy Properties
                b w następnej kolejności powinna zwracać osoby z czymś poważnym (nazwa choroby "cos powaznego")
                c dalej osoby, których iloczyn jakBardzoZly i zaraźliwość będzie wyższy


         */

//        Patient gruzlik = new Patient("Jan", "Kaszel", 4, "Tuberculosis");
//        Patient chytraBaba = new Patient("Grażyna", "Chwytak", 1, "Kleptomania");
//        Patient symulant = new Patient("Apolonia", "Sciema", 0, "healthy but lonely");
//        Patient wypadkowy = new Patient("Roman", "Wypadek", 10, "multiple bones fracture");
//
//        HospitalQueue szpital = new HospitalQueue();
//        szpital.add(gruzlik);
//        szpital.add(wypadkowy);
//        System.out.println(szpital.peek());
//        System.out.println(szpital.next());
//        System.out.println(szpital.peek());
//        szpital.add(chytraBaba);
//        szpital.add(symulant);

//        System.out.println("\nPacjenci randomowi");
//
//        Patient jakisRandom = new Patient().createRandom();
//        System.out.println(jakisRandom);
//        Patient jakisRandom2 = new Patient().createRandom();
//        System.out.println(jakisRandom2);
//        Patient jakisRandom3 = new Patient().createRandom();
//        System.out.println(jakisRandom3);

        String option = "";
        HospitalQueue queue = new HospitalQueue();
        do {
            System.out.println("Co chcesz zrobić?\n ");
            System.out.println("\"nastepny\" - wywołać następnego pacjenta");
            System.out.println("\"kto nastepny\" - sprawdzić kto jest następny w kolejce");
            System.out.println("\"nowy pacjent\" - zapisać kolejnego pacjenta");
            System.out.println("\"demo\" - uruchomić tryb demonstracyjny");
            System.out.println("\"losowy pacjent\" - stworzyć kilku losowych pacjentów");
            System.out.println("\"q\" - zakończyć działanie programu");
            option = new Scanner(System.in).nextLine();


            if ("nastepny".equalsIgnoreCase(option)) {
                if (queue.length != 0) {
                    System.out.println(queue.next());
                } else {
                    System.out.println("Nie ma nikogo w kolejce.");
                }
                Thread.sleep(3000); //delays execution of next command, throws an exception
            } else if ("kto nastepny".equalsIgnoreCase(option)) {
                if (queue.length != 0) {
                    System.out.println(queue.peek());
                } else {
                    System.out.println("Nikt nie czeka.");
                }
                Thread.sleep(3000); //delays execution of next command, throws an exception
            } else if ("nowy pacjent".equalsIgnoreCase(option)) {
                System.out.println("Podaj imię");
                String name = new Scanner(System.in).nextLine();
                System.out.println("Podaj nazwisko");
                String surname = new Scanner(System.in).nextLine();
                System.out.println("Podaj podejrzenie choroby");
                String diagnosis = new Scanner(System.in).nextLine();
                System.out.println("Podaj poziom zagrożenia życia (0-10)");
                int howBad = new Scanner(System.in).nextInt();

                Patient patient = new Patient(name, surname, howBad, diagnosis);
                queue.add(patient);
            } else if ("losowy pacjent".equalsIgnoreCase(option)) {
                Patient random = new Patient().createRandom();
                queue.add(random);
            } else if ("q".equals(option)) {
                System.out.println("Do Widzenia.");
                Thread.sleep(2000); //delays execution of next command, throws an exception
            } else if ("demo".equalsIgnoreCase(option)){
                LocalTime start = LocalTime.now();
                LocalTime end = start.plusSeconds(20); //it works!

                int counter = 0;
                do{
                    LocalTime ifStart = LocalTime.now();
                    int randomSleep = new Random().nextInt(1000);


                    Thread.sleep(2000);
                    if (LocalTime.now().isAfter(ifStart.plusSeconds(2))){
                        if (queue.length != 0) {
                            System.out.println(LocalTime.now() + "Do gabinetu wchodzi \n" + queue.next());
                        } else {
                            System.out.println(LocalTime.now() + "Nie ma nikogo w kolejce.");
                        }
                    }
                    if (LocalTime.now().isAfter(ifStart.plusSeconds(2))){
                        Patient demoN = new Patient().createRandom();
                        queue.add(demoN);
                        Thread.sleep(randomSleep);
                        System.out.println(LocalTime.now() + " Zapisuje sie nowy pacjent\n" + demoN.toString() + "\n");
                    }

//                        System.out.println("wywołanie nr" + ++counter);
//                        Thread.sleep(2000);
//                    System.out.println(LocalTime.now());
//                    System.out.println(end + "\n");

                } while (!LocalTime.now().isAfter(end)); //boolean works


            }
        } while (!"q".equals(option));
    }
}
