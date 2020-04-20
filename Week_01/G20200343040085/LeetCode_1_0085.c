#include <stdio.h>
#include <stdlib.h>

// 先排序，后用双指针
 // 用快速排序
 // 时间复杂度为O(nlogn)
 
void swap(int *a, int *b) {  
    int temp;  
    temp = *a;  
    *a = *b;  
    *b = temp;  
}
void QuickSort(int *arr, int maxlen, int begin, int end, int *indArr) {  
    int i, j;  
    if (begin < end) {  
        i = begin + 1;  
        j = end;        
        while (i < j) {  
            if(arr[i] > arr[begin]) {  
                swap(&arr[i], &arr[j]);
                int tmp = indArr[i];
                indArr[i] = indArr[j];
                indArr[j] = tmp;
                j--;  
            } else {  
                i++; 
            }  
        }  
        if (arr[i] >= arr[begin]) {  
            i--;
        }  
        swap(&arr[begin], &arr[i]);
        printf("6uuu --- %d, %d \n", indArr[begin], indArr[i]);
        int tmp = indArr[begin];
        indArr[begin] = indArr[i];
        indArr[i] = tmp;  
        QuickSort(arr, maxlen, begin, i, indArr);  
        QuickSort(arr, maxlen, j, end, indArr);  
    }  
}  

int* twoSum(int* nums, int numsSize, int target, int* returnSize){
    int leftInd = 0;
    int rightInd = numsSize - 1;
    int indArr[numsSize];
    // static int result[2] = {0};
    int *result =(int *)malloc(sizeof(int)*2);
    for(int i = 0; i < numsSize; ++i) {
      indArr[i] = i;
    }
    QuickSort(nums, numsSize, 0, rightInd, indArr);
    
    while (leftInd != rightInd) {
        int total = nums[leftInd] + nums[rightInd];
        if (total > target) {
            --rightInd;
        } else if (total < target) {
            ++leftInd;
        } else if (total == target) {
            if (indArr[leftInd] > indArr[rightInd]) {
                result[1] = indArr[leftInd];
                result[0] = indArr[rightInd];
            } else {
                result[0] = indArr[leftInd];
                result[1] = indArr[rightInd];
            }
            break;
        }
    }
    *returnSize = 2;
    printf("===%d, %d \n", result[0], result[1]);
    return result;
}
