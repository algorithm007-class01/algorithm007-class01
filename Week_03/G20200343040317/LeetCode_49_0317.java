class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> s = new HashSet<>();

        long[] primes = new long[]{2, 3, 5};
        for (int i = 0; i < primes.length; i++) {
            pq.offer(primes[i]);
            s.add(primes[i]);
        }
        long small = 1;
        // 这里n 的意义更代表在pq中取n次，实际s中的个数已经大于n个了
        for (int i = 1; i < n; i++) {
            small = pq.poll();
            for (int j = 0; j < 3; j++) {
                long mult = small * primes[j];
                if (!s.contains(mult)) {
                    s.add(mult);
                    pq.offer(mult);
                }

            }
        }
        return (int) small;
    }
}