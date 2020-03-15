
public class LeetCode_6_0303 {

    public void solution(){
        int[] nums = {0,1,0,3,5,8};
//        int[] nums = {1};
        long a = System.nanoTime();
//        moveZeroes(nums);
        moveZeroes1(nums);
        System.out.println(System.nanoTime()-a);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    /**
     * 滚雪球
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i=0; i< nums.length; i++) {
            if(nums[i] == 0){
                count++;
            }else if (count > 0) {
                nums[i-count] = nums[i];
                nums[i] = 0;
            }
        }
    }

    /**
     * 双指针
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j++;
            }
        }

    }
}