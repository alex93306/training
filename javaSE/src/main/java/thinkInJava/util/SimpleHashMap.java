package thinkInJava.util;

import java.util.*;

/**
 * Created by ALEX on 25.02.16.
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
    static final int SIZE = 997;

    LinkedList<MapEntry<K,V>>[] buckets=new LinkedList[SIZE];

    public V put(K k, V v) {
        V oldValue=null;

        int index = Math.abs(k.hashCode())% SIZE;

        if(buckets[index] == null) {
            buckets[index]=new LinkedList<MapEntry<K, V>>();

        }
        LinkedList<MapEntry<K,V>> bucket=buckets[index];
        MapEntry<K,V> pair=new MapEntry<K, V>(k,v);

        boolean found=false;
        for(MapEntry<K,V> it: bucket) {
            if(pair.getKey().equals(it.getKey())) {
                oldValue=it.getValue();
                it.setValue(v);
                found=true;

                break;
            }
        }
        if(!found) {
            bucket.add(pair);
        }
        return oldValue;

    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode())% SIZE;

        if(buckets[index] == null) {
            return null;
        }
        for(MapEntry<K,V> iPair: buckets[index]) {
            if(iPair.getKey().equals(key))
                return iPair.getValue();
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {

        Set<Entry<K,V>>  set = new HashSet<Entry<K, V>>();

        for(LinkedList<MapEntry<K,V>> bucket : buckets) {
            if(bucket == null) {
                continue;
            }
            for(MapEntry<K, V> mpair: bucket) {
                set.add(mpair);
            }
        }

        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String,String> m =new SimpleHashMap<String,String>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.get("ERITREA"));
        System.out.println(m.entrySet());
    }
}
