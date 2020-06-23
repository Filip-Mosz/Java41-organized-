package pl.FilipM.May23;

import java.util.Arrays;

//tego Bubble sorta zrobiłem kilka dni temu po sugestii Tomka. Ale spełnia warunek minimalnej liczby przebiegów a ja chcę zaoszczędzić ciut czasu.
//nie robi pustych przebiegów (tylko jeden żeby się upewnić, ze kolejność jest w porządku)
public class BubbleSort {

    public static void main(String[] args) {
        int[] tabela = new int[]{89, 23, 46, 21, 56, 18, 9, 42, 80, 13, 10, 67};
        System.out.println(Arrays.toString(tabela));
        int[] tabelaSorted = BubbleSort.sort(tabela);
        //System.out.println(Arrays.toString(tabela));
        System.out.println(Arrays.toString(tabelaSorted));
    }


    public static int[] sort(int[] tab) {
        int temp = 0;

        int bubblesCount = tab.length - 1;

        for (int count = 0; count < tab.length; count++) {
            boolean sorted = false;
            for (int i = 0; i < bubblesCount; i++) { //zmienna bubblesCount mozna zastapic i - counter

                if (tab[i] > tab[i + 1]) {
                    temp = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = temp;
                    sorted = true;
                }

            }
            bubblesCount--;
            if (!sorted) {
                System.out.println("Posortowano w " + count + " przebiegach.");
                break;
            }

        }

        return tab;
    }
}
