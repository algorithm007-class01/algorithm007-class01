package LeetCode_26_0177;

/**
 *  leet-code-26. 删除排序数组中的重复项
 */


public class Solution {


    public static void main(String[] args) {
             int[] nums = new int []{1,1,2};
        Solution t = new Solution();
        System.out.println(t.getDistinctElementArrayLength(nums));

    }

    //nums = [0,0,1,1,1,2,2,3,3,4],
    public  int  getDistinctElementArrayLength(int []nums){

        if (nums.length==0) {
            return 0;
        }
        else {
            int i=0;
            for (int j = 1;j< nums.length;j++) {
                if (nums[i]==nums[j]) {
                    continue;
                }
                else {
                    nums[i+1]=nums[j];
                    i++;

                }

            }
            return i+1;

        }


    }
}
