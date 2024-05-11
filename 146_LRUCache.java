import java.util.LinkedHashMap;
import java.util.Map;
class LRUCache {
    LinkedHashMap<Integer,Integer> cache;
    int size;
    public LRUCache(int capacity) {
        size=capacity;
        cache=new LinkedHashMap<>(size,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > size;
                }
        };
    }       
        
    public int get(int key) {
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        cache.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */