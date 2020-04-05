package geek;

public class algorithm007 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[j+1] = nums[i];
                j++;
            }
        }
        return  j + 1;
    }
}
