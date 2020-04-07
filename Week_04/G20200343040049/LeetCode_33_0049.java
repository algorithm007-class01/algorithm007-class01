class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            // 前半部分有序
            if (nums[mid] > nums[left]) {
                // 如果target在前半部分中
                if (target >= nums[left] && target <= nums[mid]) {
                    // 修改区间为[left, mid]
                    right = mid;
                } else {
                    left = mid + 1;
                }
                //  如果后半部分有序
            } else {
                // 1. 如果target在后半部分中
                // 2. 按照正常逻辑走这里应该取右中间值，因为left = mid
                // （如果最后只剩两个元素，mid取左值，而小于target，会另left = mid，还是另自己等于自己，会造成死循环，所以要取右中间值）
                // 3. 为了和上一个if有同样的左中间值，强行只考虑[mid + 1, right]
                // 4. 这样就可以修改成left = mid + 1，就与上面if中的收缩行为相同。
                if (target >= nums[mid + 1] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        // 最后判断left下标的值是否是目标值
        if (nums[left] != target) return -1;
        return left;
    }
}