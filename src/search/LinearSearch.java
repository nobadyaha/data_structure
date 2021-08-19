package search;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr={3,6,3,6,9,4,22,457,78};
        int key=8;
        int index=linearSearch(arr,key);
        System.out.println(index);
    }

    private static int linearSearch(int[] arr, int key) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
}
