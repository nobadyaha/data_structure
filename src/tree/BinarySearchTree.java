package tree;

import javax.swing.text.html.HTMLDocument;
import java.net.PortUnreachableException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> implements Iterable<E>{
    //结点定义
    private class Node{
        public E e;
        public Node left,right;
        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }
    }
    //二分搜索树的根节点指针
    private Node root;
    //元素个数
    private int size;

    public BinarySearchTree(){
        root=null;
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0 && root==null;
    }
    public void add(E e){
        root=add(root,e);
    }
    //
    public Node add(Node node,E e){
        if(node==null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){
            node.left=add(node.left,e);
        }
        else if(e.compareTo(node.e)>0){
            node.right=add(node.right,e);
        }
        return node;
    }
    //
    public boolean contains(E e){
       return contains(root,e);

    }
    private boolean contains(Node node,E e){
        if(node==null){
            return false;
        }
        if(e.compareTo(node.e)==0){
            return true;
        }
        if(e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }

    //前序遍历 根左右
    public void preOrder(){
        preOrder(root);
    }
    //递归实现
    public void preOrder(Node node){
       if(node==null){
           return;
       }
       System.out.print(node.e+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //非递归实现
    public void preOrderNR(){
        LinkedList<Node> stack=new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur=stack.pop();
            System.out.println(cur.e);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }

        }
    }
    //中序遍历
    public void inOrder(){
        inOrder(root);
    }
    public void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.e+" ");
        inOrder(node.right);
    }
    public void inOderNR(){
        LinkedList<Node> stack=new LinkedList<>();
        Node p=root;
        while(p!=null){
            stack.push(p);
            p=p.left;
        }

        while(!stack.isEmpty()){
            Node cur=stack.pop();
            System.out.println(cur.e);
            if(cur.right!=null){
               p=cur.right;
               while(p!=null){
                   stack.push(p);
                   p=p.left;
               }
            }

        }
    }
    //后序遍历
    public void postOrder(){
        postOrder(root);
    }
    public void postOrder(Node node){
        if(node==null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e+" ");
    }
    public void levelOrder(){
        LinkedList<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            System.out.println(cur.e);
            if(cur.right!=null){
                queue.offer(cur.right);
            }
            if(cur.left!=null){
                queue.offer(cur.left);
            }
        }
    }
    //返回最小值 最左边的叶子节点
    public E minum(){
        //迭代方法
//        if(isEmpty()){
//            throw new IllegalArgumentException("BST is empty");
//
//        }
//        Node  p=root;
//        while(p.left!=null){
//            p=p.left;
//        }
//        return p.e;
        //递归法
        if(isEmpty()){
            throw new IllegalArgumentException("BST is empty");
        }
        return minum(root).e;
    }
    //返回以node为根节点的最小值节点
    private Node minum(Node node){
        if(node.left==null){
            return node;
        }
       return minum(node.left);
    }

    //返回最大值 最右边的叶子节点
    public E maxnum(){
        //递归法
        if(isEmpty()){
            throw new IllegalArgumentException("BST is empty");
        }
        return maxnum(root).e;
    }
    //返回以node为根节点的最小值节点
    private Node maxnum(Node node){
        if(node.right==null){
            return node;
        }
        return maxnum(node.right);
    }
    //删除最小值
    public E removeMin(){
        E ret=minum();
        removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if(node.left==null){
            //删除node, right成为node
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
       node.left= removeMin(node.left);
        return node;
    }

    public void remove(E e){
        root=remove(root,e);
    }

    private Node remove(Node node, E e) {
        if(node==null){
            return  null;
        }
        if(e.compareTo(node.e)<0){
            node.left=remove(node.left,e);
        }else if(e.compareTo(node.e)>0){
            node.right=remove(node.right,e);
            return node;
        }else{
            if(node.left==null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }

            if(node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            //左右都不为空//不太懂
            Node successor=minum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node.left=node.right=null;
            return successor;
        }
        return null;
    }

    @Override
    public String toString() {
        if(isEmpty()){
            return null;
        }
        StringBuilder sb =new StringBuilder();
        inOderByString(root,sb);
        return sb.toString();
    }

    private void inOderByString(Node node, StringBuilder sb) {
        if(node==null){
            return;
        }
        inOderByString(node.left,sb);
        sb.append(node.e+" ");
        inOderByString(node.right,sb);
    }

    @Override
    public Iterator<E> iterator() {
        return new BSTIterator();
    }
    private class BSTIterator implements Iterator<E>{
        private LinkedList<E> list=new LinkedList<>();

        public BSTIterator(){
            LinkedList<Node> stack=new LinkedList<>();
            Node p=root;
            while(p!=null){
                stack.push(p);
                p=p.left;
            }

            while(!stack.isEmpty()){
                Node cur=stack.pop();
                list.add(cur.e);

                if(cur.right!=null){
                    p=cur.right;
                    while(p!=null){
                        stack.push(p);
                        p=p.left;
                    }
                }

            }
        }
        @Override
        public boolean hasNext() {
            return !list.isEmpty();
        }

        @Override
        public E next() {
            return list.removeFirst();
        }
    }

}
