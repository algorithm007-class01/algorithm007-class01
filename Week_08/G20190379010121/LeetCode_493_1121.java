class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    private int mergeSort(int[] nums,int left,int right){
        if(left >= right){
            return 0;
        }
        int mid = left + (right- left )/2;
        int cnt = mergeSort(nums,left,mid) + mergeSort(nums,mid+1,right);
        for(int i = left,j = mid + 1;i <= mid ;i ++){
            while(j <= right && nums[i]/2.0 > nums[j]){
                j ++;
            }
            cnt += j-(mid + 1);
        }
        Arrays.sort(nums,left,right + 1);
        return cnt;
    }
}
class Solution {


    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return mergeSort(nums,0,nums.length-1);
    }

    public int mergeSort(int[] nums,int left,int right){
        if(right <= left ){
            return 0;
        }
        int mid = (left+right) >> 1;
        int count = mergeSort(nums,left,mid)+mergeSort(nums,mid+1,right);
        // 中间数组用于合并
        int[] cache = new int[right-left+1];
        int i = left, j = mid+1, k = 0, tmp = left;
        while(j <= right){
            while(tmp <= mid && nums[tmp] <= 2 * (long)nums[j]) tmp++;
            while(i <= mid   &&  nums[i]  <   nums[j] ) cache[k++] = nums[i++];
            cache[k++] = nums[j++];
            count += mid - tmp + 1 ;
        }
        while(i <= mid) cache[k++] = nums[i++];
        System.arraycopy(cache,0,nums,left,right- left +1);
        return count;
    }

}