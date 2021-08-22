package sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
//        int[] arr= new int[20];
      /*  Random random=new Random();
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(1000);
        }
        */

        int[] arr={9,3,6,4,2,7,8,1,5};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if(l>=r){
            return;
        }


        /*if(r-l<=10){
            ShellSort.shellSort(arr,l,r);
            return;
        }

         */
        int mid=(l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        if(arr[mid]>arr[mid+1]){
            merge(arr,1,mid,r);
        }
        merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] aux=new int[r-l+1];
        for(int i= l;i<=r;i++){
            aux[i-l]=arr[i];
        }
        int i=l;
        int j=mid+1;
        for(int k=l;k<=r;k++){
            if(i>mid){
                arr[k]=aux[j-l];//
                j++;
            }else if(j>r){
                arr[k]=aux[i-l];
                i++;
            }else if(aux[i-l]<aux[j-l]){
                arr[k]=aux[i-l];
                i++;
            }else{
                arr[k]=aux[j-l];
                j++;
            }
            //System.out.println(Arrays.toString(arr));
        }
    }
}
