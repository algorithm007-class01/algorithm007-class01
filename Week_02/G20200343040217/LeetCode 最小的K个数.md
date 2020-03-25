[题目地址](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)



- 😣 第一次练习 2020年3月20日 思路还是比较清晰，这个题的解法应该很多，但是为了更加熟悉优先队列，就采用优先队列的解法来解 :ox::beers:
- :shit: 第二次练习 



### 优先队列，建立最小堆

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ret = new int[k];

        if (arr.length == 0 || k == 0)
            return ret;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : arr) {
            if (pq.size() < k)
                pq.add(i);
            else if (i < pq.peek()) {
                pq.remove();
                pq.add(i);
            }
        }

        int index = 0;
        while(!pq.isEmpty())
            ret[index ++] = pq.remove();

        return ret;
    }
}
```



### 快排变形



### 易错点

- 注意判断条件为空的情况
