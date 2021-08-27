package test;

import tree.BinarySearchTree;

import java.util.Random;

public class TestTree {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree= new BinarySearchTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(6);
        tree.add(1);
        tree.add(4);
        tree.add(3);
        tree.preOrder();
        System.out.println("=======================================");
        tree.inOrder();
        System.out.println("=======================================");
        tree.postOrder();
        System.out.println("=======================================");
        tree.preOrderNR();
        System.out.println("=======================================");
        tree.inOderNR();
        System.out.println("=======================================");
        tree.levelOrder();
        System.out.println("=======================================");
        System.out.println("min="+tree.minum());
        System.out.println("max="+tree.maxnum());
        //tree.removeMin();
        //System.out.println("min="+tree.minum());
        tree.remove(5);
        System.out.println("=======================================");
        //System.out.println(tree);
        for(Integer num:tree){
            System.out.println(num+" ");
        }
    }
}
