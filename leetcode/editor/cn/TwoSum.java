 //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

  
  package vscodetest.algorithm007-class01.leetcode.editor.en;
  public class TwoSum{
      public static void main(String[] args) {
           Solution solution = new TwoSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
            int[]nums2=Arrays.copyOf(nums, nums.length);
            Arrays.sort(nums2);
            int start=0;
            int end=nums.length-1;
            int sum=start+end;
            int a=0;int b=0;
            while(start<end){
                if(sum<target){
                    start++;
                }else if(sum>target){
                    end--;
                }else{
                    a=nums2[start];
                    b=nums2[end];
                }
            }
            int[]res=new int[2];
            for(int i=0;i<nums.length;i++){
                if(a==nums[i]){
                    res[0]=i;
                }
            }
            for(int i=0;i<nums.length;i++){
                if(b==nums[i]&& i!=res[0]){
                    res[1]=i;
                }
            }
            return res;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

  }