package sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort03 {
    public static void main(String[] args) {
        int[] arr= new int[20];
        Random random=new Random();
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(40);
        }
        System.out.println(Arrays.toString(arr));
        quickSort03(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort03(int[] arr, int l, int r) {
        if(l>=r){
            return;
        }
        swap(arr,1,(int)(Math.random()*(r-l+1)+l));
        int v=arr[l];
        int lt=l;
        int gt=r+1;
        int i=l+1;
        while(i<gt){
            if(arr[i]<v){
                swap(arr,lt+1,i);
                lt++;
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
