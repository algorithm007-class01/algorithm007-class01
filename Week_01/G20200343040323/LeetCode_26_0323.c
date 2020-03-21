
int removeDuplicates(int* nums, int numsSize){
    if ( nums == NULL || numsSize == 0) {
        return numsSize;
    }
    int p = 0;
    int q = p+1;
    while (q < numsSize) {
        if (nums[p] != nums[q]) {
            //交换
            nums[p+1] = nums[q];
            p++;
        }
        q++;
    }
    return p+1;
}
