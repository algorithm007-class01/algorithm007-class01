/*
 * @lc app=leetcode.cn id=33 lang=swift
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
// 问题： 找出了六种情况，但是没有总结出对应的逻辑
class Solution {
    func search(_ nums: [Int], _ target: Int) -> Int {
        
    if nums.count == 0 {
        return -1
    }
    
    if nums.count == 1{
        if target == nums[0] {
            return  0
        }else{
            return -1
        }
    }
    
    var low = 0
    var high = nums.count - 1
    while high >= low {
        let mid = low + ((high - low)/2)
        
        if nums[mid] == target {
            return mid
        }
        // 左边正确升序
        if (nums[mid] >= nums[low]) {
//            target 在左边范围内
            if (nums[low] <= target && target <= nums[mid] ) {
                high = mid - 1
            }else{ // 在右边范围
                low = mid + 1
            }
        }else{ //右边为正确升序
            if (nums[mid] <= target && target <= nums[high] ) {
                low = mid + 1
            }else{ // 在左边范围
                high = mid - 1
            }
        }
    }
    return -1
        
    }
}

// 二分查找旋转点，二分查找 target
class Solution {
    func search(_ nums: [Int], _ target: Int) -> Int {
        // 1 - find minimum value to calculate rotation
        
        var low = 0, high = nums.count - 1
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.

        while low < high {
            let middle = low + (high - low) / 2
            if nums[middle] > nums[high] {                  
				// smaller numbers are to the right side
				low = middle + 1
            } else {        // smaller numbers are to the left side including middle
                high = middle
            }
        }
        
        let rot = low // number of elements that were rotated
        
        // 2 - do a binary search, correcting for rotation
        
        low = 0
        high = nums.count - 1
        while low <= high {
            let middle = low + (high - low) / 2
            let idx = (middle + rot) % nums.count   // correcting for rotation
            if nums[idx] == target {
                return idx
            }
            if target < nums[idx] {
                high = middle - 1
            } else {
                low = middle + 1
            }
        }
        return -1
    }
}


// other language  判断 target 和 mid 是否在同一个升序区间来二分查找
int search(vector<int>& nums, int target) {
    int lo = 0, hi = nums.size();
    while (lo < hi) {
        int mid = (lo + hi) / 2;
        
        double num = (nums[mid] < nums[0]) == (target < nums[0])
                   ? nums[mid]
                   : target < nums[0] ? -INFINITY : INFINITY;
                   
        if (num < target)
            lo = mid + 1;
        else if (num > target)
            hi = mid;
        else
            return mid;
    }
    return -1;
}

// @lc code=end

