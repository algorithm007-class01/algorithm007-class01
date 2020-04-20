package cxl.study.leetcode;

import java.util.Arrays;

public class LeetCode_153_0257 {

    public int findMin(int[] nums) {

        return findUnSortArrayIndex(nums);

    }

    public int binarySearch(int[] array){
        int left=0,right = array.length-1;
        int mid = 0;
        while (left <= right){
            mid = (left + right) / 2;
            if(array[mid] == target){
                return mid;
            }
            if(array[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int findUnSortArrayIndex(int[] nums){
        int left=0,right = nums.length - 1;
        int mid = 0;
        while (left < right){
            mid = left + (right-left) /2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else {
                right = mid ;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        LeetCode_153_0257 sortedArray = new LeetCode_153_0257();
        int[] array = {3,4,5,1,2};
        System.out.println(sortedArray.findMin(array));

    }

}
