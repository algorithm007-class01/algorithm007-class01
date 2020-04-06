public class LeetCode_74_0147 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int left = 0;
        int right = matrix.length * matrix[0].length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int m = middle / matrix[0].length;
            int n = middle % matrix[0].length;
            if (matrix[m][n] > target) {
                right = middle - 1;
            } else if (matrix[m][n] < target) {
                left = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
