package search;

import java.util.Arrays;

public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 2;
        int index = fibonacciSearch(arr, key);
        System.out.println("index=" + index);
    }

    private static int fibonacciSearch(int[] arr, int key) {
        int[] f = getFibonacci();
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int k = 0;

        while (high > f[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, f[k]);
       // System.out.println("temp.lenght="+temp.length);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
       // System.out.println("temp.lenght="+temp.length);
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            System.out.println("mid="+mid);
            if (key < temp[mid]) {
                high = mid - 1;
                k -= 1;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }

        return -1;
    }
    public static int[] getFibonacci () {
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
}

