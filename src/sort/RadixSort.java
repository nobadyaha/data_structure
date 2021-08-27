//package sort;
//
//
//import java.util.Arrays;
//import java.util.Random;
//
//public class RadixSort {
//    public static void main(String[] args) {
//        int[] arr= new int[20];
//        Random random=new Random();
//        for(int i=0;i<arr.length;i++){
//            arr[i]=random.nextInt(50);
//        }
//        System.out.println(Arrays.toString(arr));
//        radixSort(arr);
//        System.out.println(Arrays.toString(arr));
//    }
//
//    private static <ArrayLoopQUeue> void radixSort(int[] arr) {
//        //获取最大值 和最小值
//        int max=arr[0];
//        int min=arr[0];
//        for (int i=1;i<arr.length;i++){
//            if(arr[i]>max){
//                max=arr[i];
//            }
//            if(arr[i]<min){
//                min=arr[i];
//            }
//        }
//        //计算位数
//        int radix=(max+" ").length();
//
//        //创建桶
//        ArrayLoopQUeue<Integer>[] buckets=new ArrayLoopQUeue[10];
//        for(int i=0;i<buckets.length;i++){
//            buckets[i]=new ArrayLoopQUeue<>();
//        }
//
//        for(int r=1;r<=radix;r++){
//            for(int i=0;i<arr.length;i++){
//              buckets[getIndex(arr[i],r)].add(arr[i]);
//            }
//            int index=0;
//            for(int i=0;i<buckets.length;i++){
//                while (!buckets[i].isempty){
//                    arr[index++]=buckets[i].poll();
//                }
//            }
//        }
//
//    }
//
//    private static int getIndex(int num, int r) {
//        int ret=0;
//        for(int i=1;i<=r;i++){
//            ret=num%10;
//            num/=10;
//        }
//        return ret;
//    }
//}
