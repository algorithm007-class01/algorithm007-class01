public class LeetCode_42_0241 {

    /*给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

    上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）

    示例:

        输入: [0,1,0,2,1,0,1,3,2,1,2,1]
        输出: 6*/


    /**
     *  我的解法
     *  少考虑了一些情况
     *  比如[2,3,2,1,2]
     * */
    public int trap(int[] height) {
        int leftIndex = 0;
        int cap = 0;
        for(int i = 1;i<height.length-2;i++){
            if(height[i] < height[leftIndex] && height[i+1] < height[leftIndex]){
                cap += height[leftIndex] - height[i];
            }else{
                leftIndex = i;
            }
        }
        return cap;
    }

    /**
     * 优化
     */
    public int trapCopy(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}
