/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    let m = matrix.length;
    if(m == 0) return false;
    let n = matrix[0].length;
    let low = 0;
    let high = m*n - 1;
    while(low<=high){
        let mid = (low+high)>>1;
        let row = Math.floor(mid/n);
        let col = mid%n;
        let valMid = matrix[row][col];
        if(valMid < target){
            low = mid + 1;
        }else if(valMid > target){
            high = mid -1;
        }else if(valMid == target){
            return true;
        }
    }
    return false;
};
