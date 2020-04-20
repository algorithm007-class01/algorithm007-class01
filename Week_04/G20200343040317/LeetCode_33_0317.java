class Solution {
    // 技巧
    // 先判断旋转还是选判断有序了，本解法采用先判断旋转，代码要比先判断有序复杂，建议先走Happy Path
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1, mid = 0;
        // 4,5,6,7,0,1,2
        while (left < right) {
            // 这样写的好处，相比较（left+right）/2，
            // 可以防止超大整数计算时候越界,越界的可能性出现在left+right
            mid = left + (right - left) / 2;

            // 要么向前规约，要么向后规约
            // 1) 向前规约 right = mid -1
            // 2) 向后规约 left = mid+1
            // 代码思路：先找出向后规约的场景，剩下的就是向前规约的场景


            if (nums[0] > nums[mid] && target < nums[0] && target > nums[mid]) {
                // 前半部分有旋转，向后规约
                left = mid + 1;
            } else if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                // 注意上面这个 = ，因为mid 可能与0相遇 ，这个= 不能写在上面那个if里面
                // 前半部分有序，向后规约
                left = mid + 1;
            } else {
                // 这个mid 不能在减1了，因为mid 在这里是个位置，否则会漏掉这个数据
                // right = mid -1 ;
                right = mid;
            }
        }
        // -1 没有找到
        return nums[left] == target ? left : -1;

    }
}