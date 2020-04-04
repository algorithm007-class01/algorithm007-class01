class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> map.get(a) - map.get(b));
        List<Integer> list = new ArrayList<>();
        for (int n : nums){
            if (map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else map.put(n, 1);
        }

        for (int i : map.keySet()) {
            if (heap.isEmpty() || heap.size() < k || map.get(i) > map.get(heap.peek()))
                heap.offer(i);
            if (heap.size() > k)
                heap.remove();
        }
        for (int i : heap)
            list.add(i);

        return list;
    }
}