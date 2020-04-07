class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int start = 0, rows = matrix.length, cols = matrix[0].length;
        int end = rows * cols - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            } else if (matrix[mid / cols][mid % cols] < target) {
                start = mid + 1;
            } else {
                // 这里如果写end = mid 是不可以的，因为等于场景第一个已经判断了
                end = mid - 1;
            }
        }
        return false;
    }

}