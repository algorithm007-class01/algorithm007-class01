class Solution {

    // 解法1：利用 Arrays.sort进行排序
    private int mergeSort(int[] nums, int l, int r){
        if(l >= r) return 0;
        int mid = l + (r-l) / 2;
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid+1, r);

        for(int i =l, j = mid+1;i<= mid;i++){
            while(j<=r && nums[i] / 2.0 > nums[j]) j++;
            count+= j - (mid + 1);
        }
        Arrays.sort(nums, l, r+1);
        return count;
    }

    // 解法2：手动实现排序
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int l, int r){
        if(l >= r) return 0;
        int mid = l + (r -l)/2;
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid+1, r);
        int[] cache = new int[r-l+1];
        int i = l, t = l, c = 0;
        for(int j = mid + 1; j<= r; j++, c++){
            while(i <= mid && nums[i] <= 2*((long)nums[j])) i++;
            while(t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
            cache[c] = nums[j];
            count += mid - i + 1;
        }

        while(t <= mid ) cache[c++] = nums[t++];
        System.arraycopy(cache, 0, nums, l, r-l+1);
        return count;
    }
}
