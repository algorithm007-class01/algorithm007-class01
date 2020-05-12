//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        int size = intervals.length;
        fastSort(0, size - 1, intervals);
        int index = 0;
        for (int i = 0; i < size; ++i) {
            int j = i;
            int max = 0;
            while (j < size && intervals[i][1] >= intervals[j][0]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                j++;
            }
            intervals[index++] = intervals[i];
            i = j - 1;
        }
        int[][] result = new int[index][2];
        for (int i = 0; i < index; ++i)
            result[i] = intervals[i];
        return result;
    }

    private void fastSort(int l, int r, int[][] nums) {
        if (l >= r) return;
        int target = nums[r][0];
        int index = l;
        for (int i = l; i <=r; ++i)
            if (nums[i][0] <= target) {
                int[] temp = nums[i];
                nums[i] = nums[index];
                nums[index++] = temp;
            }
        index--;
            fastSort(l, index - 1, nums);
            fastSort(index + 1, r, nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
