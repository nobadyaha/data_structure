package test;

import sort.*;

import java.util.Arrays;
import java.util.Random;

public class TestSort {
    //完全随机
    public static int[] gettotalRandom(){
        Random random=new Random();
        int[] arr=new int[1000];
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(1000);
        }
        return arr;
    }
    //大致有序
    public static int[] getMaybeSorted(){
        Random random=new Random();
        int[] arr=new int[1000];
        for(int i=0;i<arr.length;i++){
            arr[i]=i+random.nextInt(10);
        }
        return arr;
    }
    //方差小
    public static int[] getLittleVarianceSorted(){
        Random random=new Random();
        int[] arr=new int[100000];
        for(int i=0;i<arr.length;i++){
            arr[i]=100+random.nextInt(10);
        }
        return arr;
    }
    public static void main(String[] args) {
        //int[] arr1=gettotalRandom();
        //int[] arr1=getMaybeSorted();
        int[] arr1=getLittleVarianceSorted();
        int[] arr2= Arrays.copyOf(arr1,arr1.length);
        int[] arr3= Arrays.copyOf(arr1,arr1.length);
        int[] arr4= Arrays.copyOf(arr1,arr1.length);
        int[] arr5= Arrays.copyOf(arr1,arr1.length);
        int[] arr6= Arrays.copyOf(arr1,arr1.length);
        int[] arr7= Arrays.copyOf(arr1,arr1.length);
        int[] arr8= Arrays.copyOf(arr1,arr1.length);
        testSelectionSort(arr1);
        testBubbleSort(arr2);
        testInsertionSort(arr3);
        testShellSort(arr4);
        testMergeSort(arr5);
        testHeapSort(arr6);
        testQuickSort01(arr7);
        testQuickSort02(arr8);
    }

    private static void testQuickSort02(int[] arr8) {
        long startTime = System.currentTimeMillis();
        QuickSort02.quickSort02(arr8,0,arr8.length-1);
        long endTime = System.currentTimeMillis();
        System.out.println("quickSort02 time cost=" + (endTime - startTime));

    }

    private static void testQuickSort01(int[] arr7) {
        long startTime = System.currentTimeMillis();
        QuickSort01.quickSort01(arr7,0,arr7.length-1);
        long endTime = System.currentTimeMillis();
        System.out.println("quickSort01 time cost=" + (endTime - startTime));
    }

    private static void testHeapSort(int[] arr6) {
        long startTime = System.currentTimeMillis();
        HeapSort.heapSort(arr6);
        long endTime = System.currentTimeMillis();
        System.out.println("heapSort time cost=" + (endTime - startTime));
    }

    private static void testMergeSort(int[] arr5) {
        long startTime = System.currentTimeMillis();
        MergeSort.mergeSort(arr5,0,arr5.length-1);
        long endTime = System.currentTimeMillis();
        System.out.println("mergeSort time cost=" + (endTime - startTime));
    }

    private static void testShellSort(int[] arr4) {
        long startTime = System.currentTimeMillis();
        ShellSort.shellSort(arr4);
        long endTime = System.currentTimeMillis();
        System.out.println("shellSort time cost=" + (endTime - startTime));
    }

    private static void testBubbleSort(int[] arr2) {
        long startTime = System.currentTimeMillis();
        BubbleSort.bubbleSort(arr2);
        long endTime = System.currentTimeMillis();
        System.out.println("BubbleSort time cost=" + (endTime - startTime));
    }

    private static void testSelectionSort(int[] arr1) {
        long startTime = System.currentTimeMillis();
        SelectionSort.selectionSort(arr1);
        long endTime = System.currentTimeMillis();
        System.out.println("selectionSort time cost=" + (endTime - startTime));
    }

    private static void testInsertionSort(int[] arr3) {
        long startTime = System.currentTimeMillis();
        InsertionSort.insertionSort(arr3);
        long endTime = System.currentTimeMillis();
        System.out.println("insertionSort time cost=" + (endTime - startTime));

    }


}
