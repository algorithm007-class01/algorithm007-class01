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


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        Map<Integer,int[]> map = new HashMap<>();
        // 左边的最大值
        int leftMax = -1;
        for (int i=0; i< height.length; i++){
            if(height[i] > leftMax){
                leftMax = height[i];
            }
            int[] data = new int[3];
            data[0] = height[i];
            data[1] = leftMax;
            map.put(i, data);
        }
        int rightMax = -1;
        for (int j=height.length-1; j >=0; j--){
            if(height[j] > rightMax){
                rightMax = height[j];
            }
            map.get(j)[2] = rightMax;
        }
        int sum = 0;
        for (int[] value : map.values()) {
            if (value[0] < value[1] && value[0] < value[2]){
                sum+=Math.min(value[1]-value[0], value[2]-value[0]);
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
