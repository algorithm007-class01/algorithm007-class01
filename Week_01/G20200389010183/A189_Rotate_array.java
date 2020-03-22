package com.szp.leetcode.q151_200;

/*
* 四种解法，才实现了一种，
* 1、移动数组K次
* 2、使用额外数据存储移动后数据的对应位数，再复制回来
* 3、环形替换对应数组，
* 4、逆转数组三次，第一次全部逆转，第二次逆转前k个，第三次逆转后length-k个
*
* */
public class A189_Rotate_array {
    public class Solution {
        public void rotate(int[] nums, int k) {
            if(null == nums || nums.length <= 1 || k == 0)
                return;
            //tmp 交换数据临时存储节点，source 交换的源位置，dest交换的目标数据
            int length = nums.length, tmp=nums[0], source = 0, dest;
            k = k % length;

            int visited = 0;
            for (int i = 0; i < length; i++) {
                if(source < length - k)
                    dest = source + k;
                else
                    dest = (source + k) % length;

                int atmp = nums[dest];
                nums[dest] = tmp;
                source = dest;
                tmp = atmp;
// 防止偶数情况下出现循环交换的情况，几个节点循环交换，而其他节点没有被访问如[1,2,3,4,5,6]，k=2，一直在index=1,3,5的下标之间交换
                if(source == visited){
                    source = (source + 1) % length;
                    tmp = nums[source];
                    visited = source;
                }
            }
        }
    }

    public static void main(String[] args) {
        A189_Rotate_array.Solution solution = new A189_Rotate_array().new Solution();

        /*输入: [1,2,3,4,5,6,7] 和 k = 3
        输出: [5,6,7,1,2,3,4]*/
//        int[] nums = new int[]{1,2,3,4,5,6,7};
//        solution.rotate(nums, 3);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }


//        [1,2,3,4,5,6]
//        int[] nums2 = new int[]{1,2,3,4,5,6};
//        solution.rotate(nums2, 2);
//        for (int i = 0; i < nums2.length; i++) {
//            System.out.println(nums2[i]);
//        }

        int[] nums3 = new int[]{1,2,3,4,5,6};
        solution.rotate(nums3, 3);
        for (int i = 0; i < nums3.length; i++) {
            System.out.println(nums3[i]);
        }
    }
}
