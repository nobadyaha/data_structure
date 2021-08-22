package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr={9,3,6,4,2,7,8,1,5};
      // insertionSort(arr);
        insertionSortUpper(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSortUpper(int[] arr) {
        int e=0;
        int j=0;
        for(int i=1;i<arr.length;i++){
            e=arr[i];
            for(j=i;j-1>=0 && arr[j-1]>e;j--){
                arr[j]=arr[j-1];

            }
            arr[j]=e;

        }
    }

    public static void insertionSort(int[] arr) {
        for(int i=1;i<arr.length;i++){
            for(int j=i;j-1>=0 && arr[j-1]>arr[j];j--){
                swap(arr,j,j-1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
