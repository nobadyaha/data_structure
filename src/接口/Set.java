package 接口;

public interface Set<E> extends Iterable<E>{
    public void add(E element);
    public void remove(E element);
    public boolean contains(E element);
    public int size();
    public boolean isEmpty();
}
