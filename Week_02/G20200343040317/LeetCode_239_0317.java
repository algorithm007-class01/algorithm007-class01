class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 对入参进行校验
        if (k * nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        // 对头放最大元素，后面一次是小元素
        final ArrayDeque<Integer> window = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // 如果对头的元素已经在窗口外，需要清理掉
            if (i >= k && window.peek() <= i - k) {
                window.poll();
            }
            // 实际能够维护一个对头是最大值的队列
            // 因为在其入队前有一波比较删除操作
            while (!window.isEmpty() && nums[window.getLast()] <= nums[i]) {
                window.pollLast();
            }
            window.add(i);
            // i = k-1 是第一个窗口
            if (i >= k - 1) {
                // 此时最大元素还不能弹出来
                result[i - k + 1] = nums[window.peek()];
            }
        }
        return result;
    }
}