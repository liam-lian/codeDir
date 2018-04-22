package hash;
/*
 *   Created by zview@qq.com on 18-4-13.
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class LRUCache extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity,1,true);
        this.capacity=capacity;
    }

    public int get(int key) {
        return Optional.ofNullable(super.get(key)).orElse(-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() >= capacity;
    }
}
