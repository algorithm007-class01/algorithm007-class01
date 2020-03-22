/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize){
    int m = 0; // 进位
    int n = 0; // plus;
    if(digits[digitsSize - 1] == 9) {
        digits[digitsSize - 1] = 0;
        m = 1;
    }else {
        digits[digitsSize - 1] += 1;
    }
    if(m == 1) {
        for(int index = digitsSize - 2; index >= 0; index -= 1) {
            if(digits[index] == 9) {
                digits[index] = 0;
            }else {
                digits[index]+= 1;
                m = 0;
                break;
            }
        }
    }
    if(m == 1) {
        *returnSize = digitsSize + 1;
        int*ret = calloc(*returnSize, sizeof(int));
        ret[0] = 1;
        for(int index = 1; index < *returnSize; index += 1) {
            ret[index] = 0;
        }
        return ret;
    }else {
        *returnSize = digitsSize;
        int *ret = calloc(*returnSize, sizeof(int));
        for(int index = 0; index < *returnSize; index += 1) {
            ret[index] = digits[index];
        }
        return ret;
    }
}