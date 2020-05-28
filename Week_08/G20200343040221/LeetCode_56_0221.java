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

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 56. 合并区间
public class MergeIntervals_56 {

    //public static void main(String[] args) {
    //    Solution solution = new MergeIntervals_56().new Solution();
    //    System.out.println(solution);
    //}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }

        mergeSort(intervals, 0, intervals.length - 1);

        List<int[]> merged = new ArrayList<>(intervals.length);
        int i = 0;
        int[] range = intervals[0];
        while (i < intervals.length - 1) {
            int[] nextRange = intervals[++i];
            if (range[1] >= nextRange[0]) {
                if (range[1] < nextRange[1]) {
                    range[1] = nextRange[1];
                }
            } else {
                merged.add(range);
                range = nextRange;
            }
        }
        merged.add(range);

        return merged.toArray(new int[0][2]);
    }
    private void mergeSort(int[][] intervals, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = begin + ((end - begin) >> 2);
        mergeSort(intervals, begin, mid);
        mergeSort(intervals, mid + 1, end);

        int k = 0;
        int i = begin;
        int j = mid + 1;
        int[][] temp = new int[end - begin + 1][2];
        while (i <= mid && j <= end) {
            temp[k++] = intervals[i][0] < intervals[j][0] ? intervals[i++] : intervals[j++];
        }
        while (i <= mid) {
            temp[k++] = intervals[i++];

        }
        while (j <= end) {
            temp[k++] = intervals[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            intervals[begin + l] = temp[l];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
