class Solution {

    // 思路1. 暴力求解，将元素一个个的移动
    // 思路2. 并没有思路。。
    // 看了国际版LeetCode Discuss 比较喜欢的解题思路，三次翻转🙃
    // nums = "----->-->"; k =3
    // result = "-->----->";
    // reverse "----->-->" we can get "<--<-----"
    // reverse "<--" we can get "--><-----"
    // reverse "<-----" we can get "-->----->"
    // this visualization help me figure it out :)
    // 看到这个很形象，通俗易懂
    public void rotate(int[] nums, int k) {
        // k 可能大于 len
        k %= nums.length;
        // 第一次，整个数组反转
        reverse(nums,0,nums.length-1);
        // 第二次，0 ~ k-1 反转
        reverse(nums,0,k-1);
        // 第三次，k - len-1 反转
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums,int start,int end){
        for( ; start < end ; start++, end-- ){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}