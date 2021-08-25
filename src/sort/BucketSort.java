package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr= new int[20];
        Random random=new Random();
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(50);
        }
        System.out.println(Arrays.toString(arr));
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(int[] arr) {
        //获取最大值 和最小值
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

        //计算桶的数量
        int bucketNum=(max-min)/arr.length+1;
        //创建所有桶
        ArrayList<Integer> [] buckets=new ArrayList[bucketNum];
       for(int i=0;i<buckets.length;i++){
           buckets[i]=new ArrayList<>();
       }
       //遍历元素 进桶
       for(int i=0;i<arr.length;i++){
           buckets[(arr[i]-min)/arr.length].add(arr[i]);
       }
       //对每一个桶进行排序
        for(int i=0;i<buckets.length;i++){
            buckets[i].sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
            //System.out.println(i+": "+buckets[i]);
        }

        //将桶内的元素放回原数组中
        int index=0;
        for(int i=0;i<bucketNum;i++){
//            while (!buckets[i].isEmpty()){
//                arr[index++]=buckets[i].remove(0);//线性表 先进先出
//            }
                for(int j=0;j<buckets[i].size();j++){
                    arr[index++]=buckets[i].get(j++);
                   // j++;
                }
        }

    }
}
