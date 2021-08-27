package tree;

import 接口.Set;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkSet<E> implements Set<E> {
    private LinkedList<E> list;

    public LinkSet() {
        list=new LinkedList<>();
    }
    //集合就是含有不重复的元素
    @Override
    public void add(E element) {
        if(!list.contains(element)){
            list.add(element);
        }

    }

    @Override
    public void remove(E element) {
        list.remove(element);
    }

    @Override
    public boolean contains(E element) {
        return list.contains(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
