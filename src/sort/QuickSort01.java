package sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort01 {
    public static void main(String[] args) {
        int[] arr= new int[20];
        Random random=new Random();
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(40);
        }
        System.out.println(Arrays.toString(arr));
        quickSort01(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    //单路快排
    public static void quickSort01(int[] arr, int l, int r) {
        if(l>r){
            return;
        }

        //优化？nonono
       /*
        if(r-l<=10){
            ShellSort.shellSort(arr);
            return;
        }

        */


        int p=partition(arr,l,r);
        quickSort01(arr,l,p-1);
        quickSort01(arr,p+1,r);

    }

    private static int partition(int[] arr, int l, int r) {
        //优化
        swap(arr,1,(int)(Math.random()*(r-l+1)+l));
        int v=arr[l];
        int j=l;
        for(int i=l+1;i<=r;i++){

            if(arr[i]<v){
                swap(arr,i,j+1);
                j++;
            }
        }
        swap(arr,l,j);
        return j;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
