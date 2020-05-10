/*
 * @lc app=leetcode.cn id=1122 lang=csharp
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
public class Solution {
    /// <summary>
    /// 1.统计arr1数字出现次数
    /// 2.根据arr2数字出现顺序一次加入数组
    /// 3.剩余未排列数字按顺序加入
    /// </summary>
    /// <param name="arr1"></param>
    /// <param name="arr2"></param>
    /// <returns></returns>
    public int[] RelativeSortArray (int[] arr1, int[] arr2) {
        int[] arr = new int[1001];
        foreach (int item in arr1)
            arr[item]++;
        int[] res = new int[arr1.Length];
        int i = 0;
        foreach (int item in arr2) {
            for (int j = 0; j < arr[item]; j++) {
                res[i++] = item;
            }
            arr[item] = 0;
        }
        for (int k = 0; k < 1001; k++) {
            if (arr[k] > 0) {
                for (int j = 0; j < arr[k]; j++) {
                    res[i++] = k;
                }
                if (i >= arr1.Length) break;
            }
        }
        return res;
    }
}
// @lc code=end