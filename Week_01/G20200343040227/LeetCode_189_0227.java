
/**
 * url:https://leetcode-cn.com/problems/rotate-array/
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * https://leetcode-cn.com/problems/rotate-array/
 *
 */
public class LeetCode_189_0227 {
    public void rotate(int[] nums, int k) {
        //method1 dumbest solution [additional array]
        //method2 force
    }


    /**
     * The dumbest way
     * additional memory
     *
     * @param nums
     * @param k
     */
    public void method1(int[] nums, int k) {
        //check params
        if (nums == null || nums.length <= 1) return;
        //check  nums length more than the k
        if (k > nums.length) k = k - nums.length;
        //with the help of additional memory
        int[] rs = new int[nums.length + k];
        for (int i = 0; i < rs.length - k; i++) {
            rs[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            rs[i] = rs[rs.length - k + i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rs[i];
        }

        //leetcode 官方题解
        //        int[] a = new int[nums.length];
        //        for (int i = 0; i < nums.length; i++) {
        //            //nice
        //            a[(i + k) % nums.length] = nums[i];
        //        }
        //        for (int i = 0; i < nums.length; i++) {
        //            nums[i] = a[i];
        //        }
        //
        //作者：LeetCode
        //链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    /**
     * The force way
     * additional memory
     * [1,2,3,4,5,6,7]
     * [5,6,7,1,2,3,4]
     *
     * @param nums
     * @param k
     */
    public void method2(int[] nums, int k) {
        //check params
        if (nums == null || nums.length <= 1) return;
        //check  nums length more than the k
        if (k > nums.length) k = k - nums.length;

        int tmp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                tmp = nums[j];
                nums[j] = previous;
                previous = tmp;
            }
        }

    }

    /**
     * 方法 3：环状替换
     *
     * @param nums
     * @param k
     */
    public void method3(int[] nums, int k) {
        //check params
        if (nums == null || nums.length <= 1) return;
        //check  nums length more than the k
        if (k > nums.length) k = k - nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                current = next;
                count++;
            }
            while (start != current);
        }


    }

    /**
     * 方法 4：未想到
     * 翻转借鉴leetcode官方题解
     *
     * @param nums
     * @param k
     */
    public void method4(int[] nums, int k) {
        //check params
        int len = nums.length;
        //check  nums length more than the k
        k %= nums.length;
        if (k > len) k = k - len;
        reverseArr(nums, 0, len - 1);
        reverseArr(nums, 0, k - 1);
        reverseArr(nums, k, len - 1);

    }

    public void reverseArr(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        new LeetCode_189_0227().method2(nums, 3);
        System.out.println();
    }
}
