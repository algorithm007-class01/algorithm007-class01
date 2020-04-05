package Week_01;

public class LeetCode_189_0215 {

    //3次反转
    public void rotate(int[] nums, int k) {
        k %=nums.length;//边界问题
        //反转
        reversal(nums,0,nums.length-1);
        reversal(nums,0,k-1);
        reversal(nums,k,nums.length-1);


    }

    private void reversal(int[] nums,int start ,int end){
        while(start<end){
            // 交换元素
            int temp = nums[start];
            nums[start ] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}
