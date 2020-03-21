//283. 移动零
//        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//        示例:
//            输入: [0,1,0,3,12]
//            输出: [1,3,12,0,0]
//        说明:
//            必须在原数组上操作，不能拷贝额外的数组。
//            尽量减少操作次数。
// https://leetcode-cn.com/problems/move-zeroes/

//3种实现思路：
//1、开辟新数组（不符合本题目要求）
//2、不开辟新数组，使用快慢指针操作，完成后，将慢指针后面的元素全部置0
//3、是思路2的一种，使用快慢指针，慢指针前面是非0元素，快慢指针中间是0元素，在快指针发现非0元素时，将非0元素移动到慢指针位置时候，进行数据交换，操作完之后，慢指针后面的元素全部为0，不需要单独处理

/**
 * 采用思路2：不开辟新数组 时间复杂度：O(n),空间复杂度：O(1)
 * 1、使用两个指针，快指针和慢指针，起始位置指针位置为0
 * 2、快指针扫描数组，遇非0元素，则将值放到慢指针的位置，快、慢指针+1
 * 3、重复上述步骤2，直至快指针到数组结尾，
 * 4、将慢指针后面的元素全部归0
 *
 */
class Solution {
    public void moveZeroes(int[] nums) {
        moveZero4(nums);
    }

    // 首先我们知道在slowIndex和fastIndex直接数据全部为0，
    // 为了避免slowIndex后续的while循环为元素做归0操作，
    // 循环时候，fastIndex所在位置不为空时候，只需和slowIndex对调即可
    public void moveZero4(int[] nums) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if(nums[fastIndex] != 0){
                swap(nums,slowIndex++,fastIndex);
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 不开辟新数组 时间复杂度：O(n),空间复杂度：O(1)
     * 1、使用两个指针，fastIndex快指针和slowIndex慢指针，起始位置指针位置为0
     * 2、fastIndex快指针扫描数组，遇非0元素，则将值放到slowIndex的位置，然后fastIndex+1、slowIndex+1
     * 3、重复上述步骤2，直至fastIndex == nums.length-1，
     * 4、将slowIndex慢指针后面的元素全部归0
     *
     */
    public void moveZero3(int[] nums) {

        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            int a = nums[fastIndex];
            if (a != 0) {
                nums[slowIndex++] = a;
            }
        }

        while (slowIndex < nums.length) {
            nums[slowIndex++] = 0;
        }
    }



    private static void swap(int[] nums, int slowIndex, int fastIndex) {
        int temp = nums[fastIndex];
        nums[fastIndex] = nums[slowIndex];
        nums[slowIndex] = temp;
    }

    /**
     * 时间复杂度：O(n),空间复杂度：O(n)
     * 考虑可以开辟新数组
     */
    public void moveZero2(int[] nums) {
        int[] newNums = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if(a != 0){
                newNums[index++] = a;
            }
        }
        while (index < nums.length){
            newNums[index++] = 0;
        }
    }


    /**
     * 不开辟新数组，时间复杂度：O(n),空间复杂度：O(1)
     * 遍历数组，不为0的移动到数组的前面，记录下标index
     * 遍历结束后，对index之后的值赋值0
     * @param nums
     */
    public void moveZero1(int[] nums){

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if(a != 0){
                nums[idx++] = a;
            }
        }
        while (idx < nums.length){
            nums[idx++] = 0;
        }

        System.out.println(Arrays.toString(nums));

    }

}