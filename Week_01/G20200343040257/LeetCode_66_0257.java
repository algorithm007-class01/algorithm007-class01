

/**
 * 66. 加一
 * https://leetcode-cn.com/problems/plus-one/
 */
public class LeetCode_66_PlusOne {

    /**
     * 解法 递归+1
     */
    public int[] plusOne1(int[] digits) {
       return addOne(digits,digits.length-1);
    }

    /**
     * 如果当前数字小于9则加一返回，如果等于9则继续循环
     * 对于99，999这种情况只需返回一个第一个元素为1其他元素均为0的新数组即可
     */
    public int[] plusOne2(int[] digits){
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }

    private int[] addOne(int[] nums,int index){
        int result = nums[index] +1;
        if (result == 10) {
            if(index == 0){
                int[] newNumber = new int[nums.length + 1];
                newNumber[0] = 1;
               return newNumber;
            }
            nums[index] = 0;
            return addOne(nums,index-1);
        }else {
            nums[index] = result;
        }
        return nums;
    }

}
