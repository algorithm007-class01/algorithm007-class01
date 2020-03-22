package leetcode;

public class LeetCode_189_0223 {

    public void rotate(int[] nums, int k) {
        int N = nums.length;
        int[] a = new int[N+1];
        for(int i = 0; i < N; i++){
            a[(i+k) % N] = nums[i];
        }

        for(int i = 0; i < N; i++){
            nums[i] = a[i];
        }
    }
}
