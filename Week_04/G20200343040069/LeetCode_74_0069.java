class Solution {
    // 从对角线进行二分查找，如果matrix[i][j] >target,同行向前查找；如果matrix[i][j] <target，去下一行查找.
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        int i =n-1, j=0;
        while(i >= 0 && j<m){
            if(matrix[i][j] == target){
                return true;
            }else if(target < matrix[i][j]){
                i--;
            }else{
                j++;
            }
        }
        return false;
    }
}