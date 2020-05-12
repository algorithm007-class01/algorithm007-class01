class LRUCache {

    HashMap<Integer, Integer> map;
    public LRUCache(int capacity) {
        map = new LinkedCappedHashMap<>(capacity);
    }

    public int get(int key) {
        if(!map.containsKey(key)) return  -1;
        return map.get(key);
    }

    public void set(int key, int value) {
        map.put(key, value);
    }

    private  static  class  LinkedCappedHashMap<K,V> extends LinkedHashMap<K, V>{
        int maximumCapacity;

        public LinkedCappedHashMap( int maximumCapacity) {
            super(16, 0.75f, true);
            this.maximumCapacity = maximumCapacity;
        }

        protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
            return size() > maximumCapacity;
        }
    }
}
