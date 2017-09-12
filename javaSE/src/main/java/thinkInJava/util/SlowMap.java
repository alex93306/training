package thinkInJava.util;

import java.util.*;

/**
 * Created by ALEX on 24.02.16.
 */
public class SlowMap<K, V> extends AbstractMap<K,V> {

    private List<K> keys=new ArrayList<K>();
    private List<V> values=new ArrayList<V>();

    @Override
    public V put(K key, V value) {
        V oldValue=get(key);
        if(keys.contains(key)) {
            values.set(keys.indexOf(key), value);
        }

        keys.add(key);
        values.add(value);
        return oldValue;

    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> set=new HashSet<Entry<K, V>>();
        Iterator<K> ki=keys.iterator();
        Iterator<V> vi=values.iterator();
        while(ki.hasNext()) {
            set.add(new MapEntry<K,V>(ki.next(), vi.next()));
        }

        return  set;
    }
}
