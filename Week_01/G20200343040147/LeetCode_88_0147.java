import java.util.Arrays;

public class LeetCode_88_0147 {

    /**
     * 1、从尾端插入小的数组，重新排序
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 2、双层循环，比较大小，移动数组
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            boolean isAdd = true;
            for (int j = 0; j < m; j++) {
                if (nums2[i] < nums1[j]) {
                    System.arraycopy(nums1, j, nums1, j + 1, nums1.length - j - 1);
                    nums1[j] = nums2[i];
                    m = m + 1;
                    isAdd = false;
                    break;
                }
            }
            if (isAdd) {
                nums1[m++] = nums2[i];
            }

        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};

        int[] nums2 = {2, 5, 6};

        int m = 3, n = 3;

        new LeetCode_88_0147().merge2(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));

    }

}
