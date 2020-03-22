import java.util.Arrays;

public class LeetCode_66_0147 {

    /**
     * 暴力法，倒序遍历，加1
     */
    public int[] plusOne(int[] digits) {

        int[] tmp = new int[digits.length + 1];
        System.arraycopy(digits, 0, tmp, 1, digits.length);

        int diff = 1;
        for (int i = tmp.length - 1; i >= 0; i--) {
            if ((tmp[i] + diff) < 10) {
                tmp[i] += diff;
                break;
            }
            tmp[i] = tmp[i] + diff - 10;
            diff = 1;
        }

        if (tmp[0] == 0) {
            int[] result = new int[digits.length];
            System.arraycopy(tmp, 1, result, 0, result.length);
            return result;
        }
        return tmp;

    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 9};
//        int[] nums = {6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 3};
        int[] r = new LeetCode_66_0147().plusOne(nums);
        System.out.println(Arrays.toString(r));
    }
}
