/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:
    输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
*/
public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    /**
     * 方法 2：动态编程, 时间复杂度：O(n) 空间复杂度：O(n) 额外空间
     * 在方法1中，每次循环的时候，内部都需要重复找左右两侧最高值，实际左右两侧的高度值分别遍历一次，将他们缓存即可，这样避免了内部循环；
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if(height == null || height.length <= 2){
            return -1;
        }
        int total = 0;
        int size = height.length;

        int[] left_maxs = new int[size];
        int[] right_maxs = new int[size];

        for (int i = 1; i < size ; i++) {
            left_maxs[i] = Math.max(height[i],left_maxs[i-1]);
        }

        for (int i = size -2; i >=0 ; i--) {
            right_maxs[i] = Math.max(height[i],right_maxs[i+1]);
        }

        for (int i = 0; i < size -1; i++) {
            total += (Math.min(left_maxs[i], right_maxs[i]) - height[i]);
        }

        return total;

    }

    /**
     * 暴力求解
     * 时间复杂度： O(n^2) 空间复杂度 O(1)
     *
     * 思路：
     * 遍历所有柱子，每次循环找到当前柱子所能存储的最大容量，累加这个容量，直至遍历结束；
     * 那么这个累加后的容量即为所有柱子能容纳的最大值
     *
     * 关键点：如何找到当前柱子所能存储的最大容量？
     * 1、找到当前柱子的左右边两边最高柱子，那么这两者间最小的高度即为当前柱子存储容量的最高高度，
     * 2、用上述找到的最高高度，减去当前柱子的高度，那么这个高度差即为当前柱子所能存储容量的最高高度值，因为宽度为1，所以这个高度差即为当前柱子所能存储的最大容量
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int total = 0;
        int size = height.length;
        // 最左边的柱子没有左边界，无法存储容量，索引必须1开始，
        // 最右边的柱子没有右边界，无法存储容量，遍历最大值size-1
        for(int i =1; i < size-1 ; i++ ){
            int left_max = 0;
            int right_max = 0;
            // 遍历到左边界
            for (int j = i; j >= 0; j--) {
                left_max = Math.max(left_max, height[j]);
            }
            // 遍历到右边界
            for (int j = i; j < size; j++) {
                right_max = Math.max(right_max, height[j]);
            }
            total = total + (Math.min(left_max, right_max) - height[i]);
        }
        return total;
    }
}