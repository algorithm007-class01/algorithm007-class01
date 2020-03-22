/**
 * 栈
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int current = 0;
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        while(current < n){
            while(!stack.empty() && height[current] > height[stack.peek()]){
                int h = height[stack.pop()];
                if(stack.empty())
                {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()],height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current++);
        }
        return sum;
    }
}

/**
 * 动态规划
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        int[] max_right = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        int max_left = 0;
        for(int i = 1; i< n-1; i++){
            max_left = Math.max(max_left,height[i - 1]);
            int min = Math.min(max_left,max_right[i]);
            if(min > height[i]){
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}

/**
 * 双指针法
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] < max_left){
                    sum = sum + max_left - height[left];
                }else{
                    max_left = height[left];
                }
                left ++;
            }else{
                if(height[right] < max_right){
                    sum = sum + max_right - height[right];
                }else{
                    max_right = height[right];
                }
                right --;
            }
        }
        return sum;
    }
}