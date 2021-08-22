package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr={9,1,3,2,4,6,5,8,7,0};
        shellSort(arr);
        System.out.println("arr="+ Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        for(int gap=arr.length/2;gap>0;gap=gap/2){
            for(int i=gap;i<arr.length;i++){
                int j=i;
                int e=arr[i];
                while(j-gap>=0 && arr[j-gap]>e){
                    arr[j]=arr[j-gap];
                    j=j-gap;
                }
                arr[j]=e;
            }
        }
    }
}
