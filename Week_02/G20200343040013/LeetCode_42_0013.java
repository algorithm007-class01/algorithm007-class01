
class Trap {

    public int trap3(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int current = 0;
        while(current < nums.length) {
            while (!stack.empty() && nums[current] > stack.peek()) {
                int h = nums[stack.pop()];
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(nums[current], nums[stack.peek()]);
                sum = sum + distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }
}