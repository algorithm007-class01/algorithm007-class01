//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学

  
  package com.Simba.algorithm007class01.leetcode.editor.cn.leetcode.editor.cn;
  public class PowerOfTwo{
      public static void main(String[] args) {
           Solution solution = new PowerOfTwo().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
//        // 第一种：2 的幂在二进制中是有一个 1 后跟一些 0
//        //我们通过 x & (-x) 保留了最右边的 1，并将其他位设置为 0 若 x 为 2 的幂，则它的二进制表示中只包含一个 1，则有 x & (-x) = x
//        if(n ==0)return false;
//        long x=n;
//        return (x &(-x) )== x;


        //第二种解法：2 的幂二进制表示只含有一个 1。
        //x & (x - 1) 操作会将 2 的幂设置为 0，因此判断是否为 2 的幂是：判断 x & (x - 1) == 0。
       if(n ==0)return false;
       long x=n;
       return (x & (x-1))==0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }