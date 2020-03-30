class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums.length * k == 0) {
            return new ArrayList<>();
        }
        final HashMap<Integer, Integer> store = new HashMap<>();
        // 统计频率
        for (int i = 0; i < nums.length; i++) {
            store.put(nums[i], store.getOrDefault(nums[i], 0) + 1);
        }
        final PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((entry1, entry2) -> (Integer.compare(entry2.getKey(), entry1.getKey())));
        for (Map.Entry<Integer, Integer> entry : store.entrySet()) {
            heap.add(new HashMap.SimpleEntry<>(entry.getValue(), entry.getKey()));
        }
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(heap.poll().getValue());
        }
        return result;
    }
}