package thinkInJava.util;

import java.util.Map;

/**
 * Created by ALEX on 24.02.16.
 */
public class MapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key=key;
        this.value=value;
    }
    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public V setValue(V value) {
        V old=this.value;
        this.value=value;
        return old;
    }
    public int hashCode() {
        return (key==null ? 0 : key.hashCode()) ^
                (value==null ? 0 : value.hashCode());
    }
    public boolean equals(Object o) {
        if(!(o instanceof MapEntry)) return false;
        MapEntry me = (MapEntry)o;
        return
                (key == null ?
                        me.getKey() == null : key.equals(me.getKey())) &&
                        (value == null ?
                                me.getValue()== null : value.equals(me.getValue()));
    }
    public String toString() { return key + "=" + value; }
}