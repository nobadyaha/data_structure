package sort;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr= new int[20];
        Random random=new Random();
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(40);
        }
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    private static int len;
    public static void heapSort(int[] arr) {
        len=arr.length;
        //将传入的数组堆化
        heapify(arr);
        for(int i=len-1;i>=0;i--){
            swap(arr,0,i);
            len--;
            heapify(arr);
        }
    }


    private static void heapify(int[] arr) {

        for(int i=len-1;i>=0;i--){
            siftDown(arr,i);
        }
    }

    private static void siftDown(int[] arr, int k) {
       while(leftChild(k)<len){
           int j=leftChild(k);
           if(j+1<len && arr[j+1]>arr[j]){
               j=rightChild(k);
           }
           if(arr[k]<arr[j]){
               swap(arr,k,j);
               k=j;
           }else{
               break;
           }
       }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static int leftChild(int i){
        return i*2+1;
    }

    private static int rightChild(int i){
        return i*2+2;
    }

    private static int parent(int i){
        return (i-1)/2;
    }
}
