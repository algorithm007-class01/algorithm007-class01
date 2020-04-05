package DailyPractice;

import java.util.*;

public class LeetCode_347_0215 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //统计次数
        //放入PrioQueue(小堆)，大于k则出一个值
        //
        Map<Integer,Integer> times = new HashMap<>();
        for (int num:nums){
            times.put(num, times.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->times.get(a)-times.get(b));

        for (int n:times.keySet()){
            pq.add(n);
            if (pq.size()>k){
                pq.poll();
            }
        }
        List<Integer> top_k = new LinkedList<>();
        while (!pq.isEmpty()){
            top_k.add(pq.poll());
        }
        Collections.reverse(top_k);
        return top_k;
    }
}
