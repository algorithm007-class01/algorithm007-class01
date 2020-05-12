//给出一个区间的集合，请合并所有重叠的区间。
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int[][] merge(int[][] intervals) {
        // 按照区间较小值进行排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int idx = -1;
        int[][] res = new int[intervals.length][2];
        // 遍历整个数组
        for (int[] interval : intervals) {
            // 划分区间
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 比较区间范围
                res[idx][1] = Math.max(interval[1], res[idx][1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
