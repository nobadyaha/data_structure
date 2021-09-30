package sort;

import java.util.Arrays;
import java.util.Random;

public class CountSort {
    public static void main(String[] args) {
        int[] arr= {-7,-3,2,3,11};
//        Random random=new Random();
//        for(int i=0;i<arr.length;i++){
//            arr[i]=random.nextInt(50);
//        }

        System.out.println(Arrays.toString(arr));
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countSort(int[] arr) {
        //max min
        int max=arr[0];
        int min=arr[0];
        for (int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        //创建辅助数组
        int[] temp=new int [max-min+1];
        int offset=min-0;
        //ystem.out.println(offset);
        //遍历原数组 将数字个数统计在新数组中
        for(int i=0;i<arr.length;i++){
            temp[arr[i]-offset]++;
        }
//     System.out.println(temp.toString());
        //遍历新数组temp；将统计结果处理
        int index=0;
        for(int i=1;i<temp.length;i++){
            if(temp[i] >0){
                for(int j=0;j<temp[i];j++){
                    arr[index++]=i+offset;
                }
            }
        }
    }
}
