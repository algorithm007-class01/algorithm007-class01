package com.studyWeek2;

import java.util.ArrayDeque;

public class LeetCode239 {
    int nums[];

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        this.nums = nums;
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            deque(i, k, deque);
            deque.addLast(i);
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        int[] output = new int[len - k + 1];
        output[0] = nums[maxIndex];
        for (int i = k; i < len; i++) {
            deque(i, k, deque);
            deque.addLast(i);
            output[i - k + 1] = nums[deque.getFirst()];
        }
        return output;
    }

    public void deque(int i, int k, ArrayDeque<Integer> arrayDeque) {
        if (!arrayDeque.isEmpty() && arrayDeque.getFirst() == i - k) {
            arrayDeque.removeFirst();
        }
        while (!arrayDeque.isEmpty() && nums[i] > nums[arrayDeque.getLast()]) {
            arrayDeque.removeLast();
        }
    }
}
