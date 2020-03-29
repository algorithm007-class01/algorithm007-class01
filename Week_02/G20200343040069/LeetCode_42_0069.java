import java.util.HashMap;

public class LeetCode_42_0069 {
    // 1.暴力求解 时间复杂度O(n^2)
    public int trap0321_01(int[] height) {
        // 1.确认边界，如果数组长度为0，返回值为0
        // 2.loop 遍历数组元素，[0,height.length -1]
        // 3.初始化变量max_left=0，max_right=0,ans=0
        // 4.loop 迭代[0,i]得到max_left=Math.max(max_left,height[j]);
        //        迭代[i,height -1]得到max_right=Math.max(max_right,height[j])
        // 5.每个格子积水量求和maxArea求和
        //         maxArea += Math.min(max_left, max_right) - height[i]
        // 两次loop 时间复杂度是O(n^2),空间复杂度O(1)
        int maxArea = 0;
        for (int i = 0; i <height.length ; i++) {
            int max_left=0, max_right=0;
            for (int j = 0; j <= i; j++) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            maxArea += Math.min(max_left, max_right) - height[i];
        }
        return maxArea;
    }

    // 2。动态规划，存储已遍历的结果，优化多余的循环
    public int trap0321_02(int[] height){
        int n = height.length;
        if(n == 0) return 0;
        int maxArea = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        max_left[0] = height[0];
        max_right[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i]);
        }
        for (int i = 1; i < n; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i]);
            int min = Math.min(max_left[i], max_right[i]);
            maxArea += (min - height[i]);
        }
        return maxArea;
    }

    // 3.使用stack优化，减少一次loop 时间复杂度O(n),空间复杂度O(n)
    public int trap0321_03(int[] height) {
        // 1.确认边界，如果数组长度为0，返回值为0
        // 2.loop 从左向右遍历数组元素，[0,height.length -1]
        // 3.使用stack记录已经遍历的元素,即水桶高度
        // 4.如果出现高度上升，栈顶元素出栈。计算蓄水面积并累加
        // 5.入栈
        // 6。返回面积
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i <height.length ; i++) {
            while (stack.peek() != -1 && height[i]>= height[stack.peek()]){
                int top = stack.pop();
                if (stack.peek() == -1) break;

                int distance = i- stack.peek() -1;
                int h = Math.min(height[stack.peek()], height[i]) - height[top];
                maxArea += h * distance;
            }
            stack.push(i);
        }
        return maxArea;
    }

    // 4.双指针,优化stack的存储空间，用变量代替 时间复杂度O(n),空间复杂度O(1)
    public int trap0321_04(int[] height) {
        int i =0,j=height.length-1, plank=0, maxArea = 0;
        while (i<=j){
            plank = plank > Math.min(height[i],height[j]) ? plank : Math.min(height[i],height[j]);
            maxArea = height[i]>=height[j]? maxArea + (plank - height[j--]) :  maxArea + (plank - height[i++]);
        }
        return maxArea;
    }
}
