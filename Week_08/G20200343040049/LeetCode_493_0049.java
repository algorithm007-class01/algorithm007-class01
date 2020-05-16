class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;

        int[] temp = new int[nums.length];
        return mergeCount(nums, 0, nums.length - 1, temp);
    }

    private int mergeCount(int[] nums, int left, int right, int[] temp) {
        if (left >= right) return 0;

        int mid = (left + right) >> 1;
        int count = mergeCount(nums, left, mid, temp) + mergeCount(nums, mid + 1, right, temp);

        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] > 2 * (long) nums[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        merge(nums, left, mid, right, temp);
        return count;
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right - left + 1);

        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            nums[k++] = temp[i] <= temp[j] ? temp[i++] : temp[j++];
        }
        while (i <= mid) nums[k++] = temp[i++];
        while (j <= right) nums[k++] = temp[j++];
    }
}
