[题目地址](https://leetcode-cn.com/problems/top-k-frequent-elements/)



- 😣 第一次练习 2020年3月19日 听了老师的讲解使用有线队列。整体思路还是有点的，不过空间和时间度都有点高。
- :shit: 第二次练习 



### 优先队列

解题代码

```java
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        /**
         * 1. count -> TreeMap(ele, num)
         * 2. new -> PriorityQueue(comparateor)
         * 3. loop keyset e
         *      if pq.size < k
         *          pq.enqueue
         *      else if pq.getFront() < e
         *          pq.remove ; pq.equeue
         * 4. define list -> while pq.isEmpty pq.remove
         */
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Integer num : map.keySet()) {
            if (pq.size() < k)
                pq.add(num);
            else if (map.get(pq.peek()) < map.get(num)) {
                pq.remove();
                pq.add(num);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!pq.isEmpty())
            list.add(pq.remove());

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
```



### 易错点

- 在优先队列满时，比较优先队列的最小值时，需要对比是的他们在map中的次数，而不是直接就和最小值进行比较

	
