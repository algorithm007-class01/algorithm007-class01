#include <stdio.h>
#include <stdlib.h>
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize){
    int *result = (int *)malloc(sizeof(int) * (digitsSize + 1));
    int size = 0;
    int offset = 1;
    if (digitsSize <= 0) {
        return NULL;
    }
    for (int i = digitsSize - 1; i >= 0; --i) {
        int tmp = digits[i] + offset;
        ++size;
        if (tmp >= 10) {
            result[i + 1] = tmp % 10;
            offset = 1;
        } else {
            offset = 0;
            result[i + 1] = tmp;
        }
    }
    *returnSize = size + offset;
    if (offset == 0) {
        result[0] = 0;
        return result + 1;
    } else {
        result[0] = 1;
        return result;
    }
}
