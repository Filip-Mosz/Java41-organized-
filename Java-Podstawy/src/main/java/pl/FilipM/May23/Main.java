package pl.FilipM.May23;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Listy: ");

        StringListElement firstElement = new StringListElement("Ala");
        StringListElement secondElement = new StringListElement("ma");
        StringListElement thirdElement = new StringListElement("kota");

        firstElement.setNext(secondElement);
        secondElement.setNext(thirdElement);

        System.out.println(firstElement.getValue());
        System.out.println(firstElement.getNext().getValue());
        System.out.println(firstElement.getNext().getNext().getValue());

        String first = firstElement.getValue();
        String second = secondElement.getValue();
        String third = thirdElement.getValue();

        StringListElement current = firstElement;
        int length = 0;
        while (current != null) {
            length++;
            current = current.getNext();
        }

        String[] tabOfList = new String[length];
        while (current != null) {
            length++;
            current = current.getNext();
        }

        int[] tabela = new int[]{89, 23, 46, 21, 56, 18, 9, 42, 80, 13, 10, 67};
        int[] tabelaSorted = BubbleSort.sort(tabela);
        System.out.println(Arrays.toString(tabelaSorted));
        System.out.println("szukany element znajduje sié na indeksie: " + BinarySearch.search(tabelaSorted, 80));
        System.out.println("szukany element znajduje sié na indeksie: " + BinarySearch.search(tabelaSorted, 67));
        System.out.println("to ma sié wywalic: " + BinarySearch.search(tabelaSorted, 99));
        System.out.println("to ma sié wywalic: " + BinarySearch.search(tabelaSorted, 0));

        Stack stack = new Stack();
        stack.push(4);
        stack.push(6);
        stack.push(7);

        System.out.println("Na wierzchu stosu znajduje sié: " + stack.peek());
        System.out.println();
        System.out.println("Lista dwukierunkowa");

        StringList jif = new StringList();
        jif.add("Java");
        jif.add("jest");
        jif.add("fajna");

        System.out.println(jif.getLenght());
        jif.addAt("nie",1);
        jif.addAt("?", 5);
        // TODO: 2020-05-24 coś tu się srogo powaliło 
        System.out.println(jif.toString());


    }
}
