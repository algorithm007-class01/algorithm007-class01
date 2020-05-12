//给你两个数组，arr1 和 arr2，
//
//
// arr2 中的元素各不相同
// arr2 中的每个元素都出现在 arr1 中
//
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
// 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

// Related Topics 排序 数组


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 数组中元素的取值范围为0~1000，共1001种取值
        // 利用桶排序
        int[] bucket = new int[1001];
        // 记录桶中相同元素的数目
        for (int num : arr1) {
            bucket[num]++;
        }
        // 由于重新排序不会改变原数组的长度，所以可以利用原数组
        int i = 0;
        // 将arr2中的数据依序放入到arr1中
        for (int num : arr2) {
            while (bucket[num] > 0) {
                bucket[num]--;
                arr1[i++] = num;
            }
        }
        // 只存在于arr1中的元素按照桶序号取出，进行二次遍历
        for (int j = 0; j < 1001; j++) {
            while (bucket[j] > 0) {
                arr1[i++] = j;
                bucket[j]--;
            }
        }
        return arr1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
