/*
74. 搜索二维矩阵  链接：https://leetcode-cn.com/problems/search-a-2d-matrix
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

示例 1:
输入:
    matrix = [
    [1,   3,  5,  7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
    ]
    target = 3
输出: true
*/


public class SearchA2dMatrix {

    public static void main(String[] args) {
    }

    /**
     * 二分查找
     * 二维矩阵中，每行元素递增，后一行第一个元素大于前一行最后一个元素，整个二维矩阵存储数据递增，
     *
     * 如何找到具体二位数组坐标x = index/n, y = index%n
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        int left = 0, right = m*n - 1, mid;
        while (left <= right){
            mid = (left + right)/2;
            if(matrix[mid/n][mid%n] == target) return true;
            if(matrix[mid/n][mid%n] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }

}