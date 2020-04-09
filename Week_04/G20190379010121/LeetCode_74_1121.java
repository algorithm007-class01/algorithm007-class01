class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //O(log(mn))
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        return findRow(matrix,target,0,matrix.length-1);
    }
    private boolean findRow(int[][] matrix, int target,int left,int right){
        if(left > right){
            return false;
        }
        int midrow = (left + right )/2;
        int collen = matrix[midrow].length;
        if(matrix[midrow][0]<= target && matrix[midrow][collen-1] >= target){
            return findCol(matrix,target,midrow,0,collen-1);
        }else if(matrix[midrow][0] > target){
            return findRow(matrix,target,left,midrow-1);
        }else {
            return findRow(matrix,target,midrow+1,right);
        }
    }
    private boolean findCol(int[][] matrix, int target,int row,int left,int right){
        if(left > right){
            return false;
        }
        int mid = (left + right)/2;
        int val = matrix[row][mid];
        if(val == target){
            return true;
        }else if(val >target){
            return findCol(matrix,target,row,left,mid-1);
        }else{
            return findCol(matrix,target,row,mid+ 1,right);
        }
    }
}