

public List<Integer> topKFrequent(int[] nums, int k) {
    if(nums.length == 0 || k == 0 || nums.length < k) {
        return new ArrayList();
    }

    Map<Integer, Integer> map = new HashMap();

    PriorityQueue<Integer> pq = new PriorityQueue((v1, v2) -> map.get(v1) - map.get(v2));

    for(int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for(int i : map.keySet()) {
        pq.offer(i);
        if(pq.size > k) {
            pq.poll();
        }
    }

    List<Integer> list = new ArrayList();

    while(!pq.isEmpty()) {
        list.add(pq.poll());
    }

    return list;
}