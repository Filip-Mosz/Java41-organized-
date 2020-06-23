package pl.FilipM.May23;

public class BinarySearch {
    public static int search(int[] ints, int num) {
        int left = 0;
        int right = ints.length;



        while (true) {
            if (left >= right) { //punkt 5
                return -1;
            }
            int middle = (left + right) / 2;
            if (ints[middle] == num) {
                return middle;
            } else if (ints[middle] > num) {
                right--;// = middle - 1;
            } else if (ints[middle] < num) {
                left = middle + 1;
            }
        }

    }
}
