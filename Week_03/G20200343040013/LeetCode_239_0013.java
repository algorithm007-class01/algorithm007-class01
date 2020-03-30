
public int[] maxInWindows(int[] nums, int k) {
    if(nums.length == 0 || k == 0 || nums.length < k) {
        return new int[0];
    }
    int n = nums.length;
    int[] ints = new int[n - k + 1];
    int j = 0;
    Deque<Integer> deque = new LinkedList();

    for(int i = 0; i < nums.length; i ++) {
        while(!deque.isEmpty && nums[i] > nums[deque.peekLast()]) {
            deque.pollLast();
        }

        deque.offer(i);

        if(deque.peekFirst() == i - k) {
            deque.pollFirst();
        }

        if(i >= k - 1) {
            ints[j++] = nums[deque.peek()];
        }
    }
    return ints;
}