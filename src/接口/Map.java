package 接口;



import java.util.List;

public interface Map<K,V> {
    public void put(K key,V value);
    public V remove(K key);
    public boolean contains(K key);
    public V get(K key);
    public void set(K key,V value);
    public int size();
    public boolean isEmpty();
    public Set<K> keySet();
    public List<V> values();
    public Set<Entry<K,V>> entrySet();
    public interface Entry<K,V>{
        public K getKey();
        public V getvalue();
    }
}
