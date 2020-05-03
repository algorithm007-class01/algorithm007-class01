package app;

import java.util.LinkedHashMap;

public class LeetCode_146_0333 {

    class LRUCache extends LinkedHashMap<Integer, Integer>{
        
        private final int capacity;
        //accessorder =true 使LinkedHashMap在put和get时 将访问元素调整到最
        //后位置 实现LRU算法 
        public LRUCache(final int capacity) {
            super(capacity,0.75F,true);
            this.capacity=capacity;
        }
        
        public int get(final int key) {
            return super.getOrDefault(key,-1);
        }
        
        public void put(final int key, final int value) {
            super.put(key,value);
        }
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity; 
        }
    }
    
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}