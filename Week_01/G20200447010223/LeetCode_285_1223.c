void moveZeroes(int* nums, int numsSize){
    int leftSpace = 0;
    int walkIndex = 0;
    while(leftSpace != 0) {
        if(nums[walkIndex] == 0) {
            leftSpace += 1;
        }
        walkIndex += 1;
    }
    while(walkIndex < numsSize) {
        if(nums[walkIndex] != 0) {
            nums[walkIndex - leftSpace] = nums[walkIndex];
        } else {
            leftSpace += 1;
        }
        walkIndex += 1;
    }
    int fillSpaceStartIndex = numsSize - leftSpace;
    while(fillSpaceStartIndex < numsSize) {
        nums[fillSpaceStartIndex] = 0;
        fillSpaceStartIndex += 1;
    }
}