void moveZeroes(int* nums, int numsSize){
    int lastZeroInd = 0;
    for (int i = 0; i < numsSize; ++i) {
        if (nums[i] != 0) {
            int tmp = nums[lastZeroInd];
            nums[lastZeroInd++] = nums[i];
            nums[i] = tmp;
        }
    }
}
