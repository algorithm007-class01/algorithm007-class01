class Solution {
    // 大根堆
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length * k == 0) {
            return new int[0];
        }
        final PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i = 0; i < arr.length; i++) {
            // 如下写法是有问题的，如果碰巧连续的k个都是较大数据，那么结果就是错误的
            // queue.offer(arr[i]);
            // if (queue.size() > k) {
            // queue.poll();
            // }
            // 我们应该先比较一下，让大的不要入堆
            if (queue.size() < k) {
                queue.offer(arr[i]);
            } else if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }

        }
        final int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll();
        }
        return result;
    }
}