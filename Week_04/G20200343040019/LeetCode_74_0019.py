class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return False
        m = len(matrix)
        n = len(matrix[0])
        if  n==0:
            return False
        x = m-1
        for i in range(m):
            if target< matrix[i][0]:
                x = i-1
                break
        i, j = 0, n-1
        while i<=j:
            mid = (i+j)//2
            a, b, c = matrix[x][i], matrix[x][mid], matrix[x][j]
            if b == target:
                return True
            if b>target:
                j = mid-1
            else:
                i = mid+1
    
        return False