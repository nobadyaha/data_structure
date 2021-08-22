package sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort02 {
    public static void main(String[] args) {
        int[] arr= new int[20];
        Random random=new Random();
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(40);
        }
        System.out.println(Arrays.toString(arr));
        quickSort02(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort02(int[] arr, int l, int r) {
        if(l>=r){
            return;
        }

        int p=partition(arr,l,r);
        quickSort02(arr,l,p-1);
        quickSort02(arr,p+1,r);
        //System.out.println(Arrays.toString(arr));

    }

    private static int partition(int[] arr, int l, int r) {
        // swap(arr,1,(int)(Math.random()*(r-l+1)+l));//这句话导致出错
        int v=arr[l];
        int i=l+1;
        int j=r;
        while(true){
            while(i<=r && arr[i]<v){
                i++;
            }
            while(j>=l+1 && arr[j]>v){
                j--;
            }
            if(i>j){
                break;
            }
            swap(arr,i, j);
            j--;
            i++;
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
