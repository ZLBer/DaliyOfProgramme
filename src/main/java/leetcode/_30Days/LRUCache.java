package leetcode._30Days;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    MyLRUCache myLRUCache;
    public LRUCache(int capacity) {
   myLRUCache=new MyLRUCache(capacity);
    }

    public int get(int key) {
   if(myLRUCache.containsKey(key)) return myLRUCache.get(key);
   else return -1;
    }

    public void put(int key, int value) {
     myLRUCache.put(key,value);
    }
    class MyLRUCache extends LinkedHashMap<Integer,Integer> {
         int capacity;

        public MyLRUCache(int capacity) {
            super(16, (float) 0.75,true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            if(size()>capacity) return true;
            return false;
        }
    }
}
