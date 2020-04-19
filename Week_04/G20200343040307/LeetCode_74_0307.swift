/*
 * @lc app=leetcode.cn id=74 lang=swift
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
// 每个数组的第一位二分
// 找到对应数组后，在数组内二分
// 特殊情况， 数组是否为空，是否存在有一个空数组
class Solution {
    func searchMatrix(_ matrix: [[Int]], _ target: Int) -> Bool {
        if matrix.count == 0 || matrix[0].count == 0 {
            return false
        }
        var leftY = 0 
        var rightY = matrix.count - 1
        var y = 0
        // 不包含等于保证循环中不会越界
        while leftY < rightY {
            let mid = leftY + (rightY - leftY)/2
            if matrix[mid][0] == target {
                return true
            }else if matrix[mid][0] < target {
                // 这个地方不能包含等于，等于的情况要放在 leftY = mid + 1 的时候
                if matrix[mid+1][0] > target {
                    leftY = mid
                    break
                }
                leftY = mid + 1
            }else{
                    rightY = mid - 1
                }
        }
        var leftX = 0
        var rightX = matrix[leftY].count - 1
        while leftX <= rightX {
            let mid = leftX + (rightX - leftX)/2
            if matrix[leftY][mid] == target {
                return true
            }else if matrix[leftY][mid] > target {
                rightX = mid - 1
            }else{
                leftX = mid + 1
            }
        }
        return false
    }
}

// 将二维数组看成一个一维数组 横向位置就是   mid%n ,纵向位置就是 mid/2
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if (m == 0) return false;
    int n = matrix[0].length;
    // 二分查找
    int left = 0, right = m * n - 1;
    int pivotIdx, pivotElement;
    while (left <= right) {
      pivotIdx = (left + right) / 2;
      pivotElement = matrix[pivotIdx / n][pivotIdx % n];
      if (target == pivotElement) return true;
      else {
        if (target < pivotElement) right = pivotIdx - 1;
        else left = pivotIdx + 1;
      }
    }
    return false;
  }
}

// @lc code=end

