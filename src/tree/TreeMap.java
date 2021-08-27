package tree;

import 接口.Map;
import 接口.Set;

import java.util.LinkedList;
import java.util.List;

//底层由二分搜索树实现的映射
public class TreeMap<K extends Comparable<K>,V> implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        Node left,right;

        public Node(){
            this(null,null);
        }
        public Node(K key,V value){
            this.key=key;
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }

    private Node root;
    private int size;

    public TreeMap(){
        root=null;
        size=0;
    }

    //以Node为根的二分搜索树中查键为key的那个结点对象
    private Node getNode(Node node,K key){
        if(node==null){
            return null;
        }
        if(key.compareTo(node.key)<0){
            return getNode(node.left,key);
        }else if (key.compareTo(node.key)>0){
            return getNode(node.right,key);
        }else {
            return node;
        }
    }



    @Override
    public void put(K key, V value) {
        root= put(root,key,value);
    }

    //在以node为根结点的二分搜索树中插入键值对
    private Node put(Node node, K key, V value) {
        if(node==null){
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)<0){
            node.left=put(node.left,key,value);
        }else if (key.compareTo(node.key)>0){
            node.right= put(node.right,key,value);
        }else {
            node.value=value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node delNode=getNode(root,key);
        if (delNode!=null){
            root=remove(root,key);
            return delNode.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if(node==null){
            return null;
        }
        if (key.compareTo(node.key)<0){
            node.left=remove(node.left,key);
            return node;
        }else if (key.compareTo(node.key)>0){
            node.right=remove(node.right,key);
            return node;
        }else {
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
            Node successor= minnum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node.left=node.right=null;
            return successor;
        }
    }

    private Node removeMin(Node node) {
        if(node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }

    private Node minnum(Node node) {
        if (node.left==null){
            return node;
        }
        return minnum(node.left);
    }

    @Override
    public boolean contains(K key) {

        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key) {
        Node n=getNode(root,key);
        return n==null?null:n.value;
    }

    @Override
    public void set(K key, V value) {
        Node n=getNode(root,key);
        if(n==null){
            throw new IllegalArgumentException("key is not exist");
        }
        n.value=value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0&&root==null;
    }

    @Override
    public Set<K> keySet() {
        TreeSet<K> set=new TreeSet<>();
        inOrderKeySet(root,set);
        return set;
    }


    private void inOrderKeySet(Node node, TreeSet<K> set) {
        if(node==null){
            return;
        }
        inOrderKeySet(node.left,set);
        set.add(node.key);
        inOrderKeySet(node.right,set);
    }

    @Override
    public List<V> values() {
        LinkedList<V> list=new LinkedList<>();
        inOrderValue(root,list);
        return list;
    }

    private void inOrderValue(Node node, LinkedList<V> list) {
        if(node==null){
            return;
        }
        inOrderValue(node.left,list);
        list.add(node.value);
        inOrderValue(node.right,list);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        LinkSet<Entry<K,V>> entries=new  LinkSet<Entry<K,V>>();
        inOrderEnterSet(root,entries);

        return entries;
    }

    private void inOrderEnterSet(Node node, LinkSet<Entry<K,V>> entries) {
        if(node==null){
            return;
        }
        inOrderEnterSet(node.left,entries);
        entries.add(new BSTEntry<>(node.key,node.value));
        inOrderEnterSet(node.right,entries);

    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append('[');
        if(isEmpty()){
            sb.append(']');
        }else {
            Set<Entry<K,V>> set=entrySet();
            for(Entry<K,V> entry:set){
                sb.append(entry);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append(']');
        }
        return sb.toString();
    }
    private class BSTEntry<K ,V> implements Entry<K, V>{


        private  K key;
        private  V value;

        public BSTEntry(K key,V value){
            this.key=key;
            this.value=value;
        }
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getvalue() {
            return value;
        }


        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "("+key.toString()+":"+value.toString()+")";
        }
    }


}


