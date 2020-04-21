/**
* Summary:search-a-2d-matrix
* Parameters:
*   matrix: source matrix
*	target:	target number
* Return: bool-value
*/
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        if (m == 0) return false;
        int n = matrix[0].size();

        int left = 0;
        int right = m * n - 1;
        int pivotIdx, piovtElement;
        while (left <= right) {
            pivotIdx = left + ((right - left) >> 1);
            piovtElement = matrix[pivotIdx / n][pivotIdx % n];
            if (piovtElement > target) {
                right = pivotIdx - 1;
            } else if (piovtElement < target) {
                left = pivotIdx + 1;
            } else {
                return true;
            }
        }
        return false;
    }
};