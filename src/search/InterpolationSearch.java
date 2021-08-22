package search;

public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr={1,3,4,6,8,9,12,45,67,74,98,99};
        int key=4;
        int index=interpolationSearch(arr,key,0,arr.length-1);
        System.out.println("index="+index);
    }

    private static int interpolationSearch(int[] arr, int key, int low, int high) {
        if(low>high){
            return -1;
        }
        int mid=low+(int)(1.0*(key-arr[low])/(arr[high]-arr[low])*(high-low));//有点像归一化
        System.out.println("mid="+mid);
        if(mid<low || mid>high){
            return -1;
        }
        if(arr[mid]==key){
            return mid;
        }else if(arr[mid]>key){
            return interpolationSearch(arr,key,low,mid-1);
        }else{
            return interpolationSearch(arr,key,mid+1,high);
        }
    }
}
