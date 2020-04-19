class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        left, right = 0, m * n -1
        while left <= right:
            mid_id = (left + right)/2
            row, col = mid_id / n, mid_id % n
            val = matrix[row][col]
            if target == val:
                return True
            elif target < val:
                right -= 1
            else:
                left += 1
        
        return False

input = [[1,3,5,7],[10,11,16,20],[23,30,34,50]]
Solution().searchMatrix(input, 3)