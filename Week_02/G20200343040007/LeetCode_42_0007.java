//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int size = height.length;
        if (size < 3) return 0;
        int[] left = new int[size];
        left[0] = 0;
        int[] right = new int[size];
        right[size - 1] = 0;
        for (int i = 1; i < size; ++i)
            left[i] = Math.max(height[i - 1], left[i - 1]);
        for (int i = size - 2; i >= 0; --i)
            right[i] = Math.max(height[i + 1], right[i + 1]);
        int result = 0;
        for (int i = 0; i < size; ++i) {
            int min = Math.min(left[i], right[i]);
            if (min > height[i])
                result += min - height[i];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
