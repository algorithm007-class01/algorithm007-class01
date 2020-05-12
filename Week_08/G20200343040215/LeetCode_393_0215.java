import java.util.Arrays;

public class LeetCode_393_0215 {
    private int res ;
    public int reversePairs(int[] nums) {
        res = 0;
        if (nums.length<=1){
            return res;
        }

        myMerge(nums,0,nums.length-1);
        return res;

    }

    private void myMerge(int[] nums, int low, int high) {
        if (low>=high){
            return;
        }
        int mid  =low+ (high-low)/2;
        myMerge(nums, low, mid);
        myMerge(nums, mid+1, high);
        int count = 0;
        for (int l = low, r = mid+1; l <= mid;) {
            if (r > high || (long)nums[l] <= 2*(long)nums[r]) {
                l++;
                res += count;
            } else {
                r++;
                count++;
            }
        }

        Arrays.sort(nums,low,high+1);

    }
}
