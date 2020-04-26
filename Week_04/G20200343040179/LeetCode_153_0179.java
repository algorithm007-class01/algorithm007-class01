package Week_04.G20200343040179;

import java.util.*;

/**
 * @author mufan
 * @date 2020/4/14
 */
public class LeetCode_153_0179 {
    /**
     * 1.最小的数可能在左边,也可能在右边
     * 2.当数据没有进行旋转的时候最小数在左边(left < mid < right)
     * 3.当旋转点位于原始数组中位数后边则最小数在左边(left > mid mid < right)
     * 4.当旋转点位于原始数组中位数前面则最小数在右边(left < mid mid > right)
     * 从上面可以看出来,如果单纯的判断left 与 mid ,最小值无法确定在左边还是右边,无法确定最小值的范围
     * 所以需要归类去处理,先判断mid是否大于right,则最小值在右边，其余的情况在左边。
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                //如果是nums[mid]>nums[right]的情况下,证明nums[mid+1]往后的某个值开始一定是升序
                left = mid + 1;
            } else {
                //如果在左半边,因为取的是左中位数,所以这里right!=mid-1 而是right=mid
                right = mid;
            }
        }
        return nums[left];
    }

}
