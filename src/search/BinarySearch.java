package search;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        int key=0;
        //迭代法
        int index=binarySearch(arr,key);
        System.out.println("index="+index);
        //递归法
        int index2=binarySearch2(arr,key,0,arr.length-1);
        System.out.println("index2="+index2);
    }

    private static int binarySearch2(int[] arr, int key, int low, int high) {
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(arr[mid]==key){
            return mid;
        }
        if(key<arr[mid]){
            high=mid-1;
           return binarySearch2(arr,key,0,high);
        }else{
            return binarySearch2(arr,key,mid+1,high);
        }
    }


    private static int binarySearch(int[] arr, int key) {
        int low=0;
        int high= arr.length-1;
        int mid=(low+high)/2;
        while(arr[mid] !=key){
            //对象比较用equals
            if(arr[mid]>key){
                high=mid-1;
            }else if(arr[mid]<key){
                low=mid+1;
            }
            if(low>high){
                return -1;
            }
            mid=(low+high)/2;
        }
        return mid;
    }
}
