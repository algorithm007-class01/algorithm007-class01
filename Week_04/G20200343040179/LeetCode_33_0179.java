package Week_04.G20200343040179;

/**
 * @author mufan
 * @date 2020/4/14
 */
public class LeetCode_33_0179 {

    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        //定义左指针
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            //前面是升序
            if (nums[mid] >= nums[left]) {
                //target是否在前面的序列中(target<nums[mid]不可能等于,如果是等于的情况下前面就直接return了)
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
