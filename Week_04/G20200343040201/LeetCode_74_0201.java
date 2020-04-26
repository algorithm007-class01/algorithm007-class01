package myself;

public class LeetCode_74_0201 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int colCount = matrix[0].length;
        if (colCount == 0) return false;
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][colCount - 1]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    private boolean binarySearch(int[] matrix, int target) {
        int left = 0, right = matrix.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == matrix[mid])
                return true;
            else if (target < matrix[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
