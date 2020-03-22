int removeDuplicates(int* nums, int numsSize){
    if(numsSize == 0) {
        return 0;
    }
    int newArrayIndex = 1;
    int index = 1;
    int walkIndex = numsSize - 1;
    int tmp = nums[0];
    int tmp2;
    while(walkIndex) {
        tmp2 = nums[index];
        if(tmp != tmp2) {
            // no rep
            nums[newArrayIndex] = tmp2;
            tmp = tmp2;
            newArrayIndex += 1;
        }
        index += 1;
        walkIndex -= 1;
    }
    return newArrayIndex;
}