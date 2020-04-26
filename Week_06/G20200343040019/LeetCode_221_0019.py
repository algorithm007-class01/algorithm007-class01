class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or not matrix[0]:
            return 0
        dp = [[0 for _ in range(len(matrix[0]))] for _ in range(len(matrix))]
        res = 0
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if matrix[i][j] == "1":
                    if i==0 or j==0:
                        dp[i][j] = 1
                        continue
                    dp[i][j] = min( dp[i-1][j-1], dp[i][j-1], dp[i-1][j])+1
            
            res = max(res, max(dp[i]))
        
        return res**2

        # if not matrix or not matrix[0]:
        #     return 0
        # def checkWidth(i,j,width):
        #     checklist = set()
        #     for w in range(1,width+1):    
        #         res = w-1
        #         for x in range(i,i+w):
        #             for y in range(j, j+w):
        #                 if (x,y) not in checklist:
        #                     checklist.add((x,y))
        #                     if matrix[x][y]=='0':
        #                         return res
        #     return width
        # def search(i,j):
        #     maxl = min(len(matrix)-i, len(matrix[i])-j)
        #     width = checkWidth(i,j, maxl)
        #     return width

        # dic = {"default":0}

        # for i in range(len(matrix)):
        #     for j in range(len(matrix[i])):
        #         if matrix[i][j] == "1":
        #             dic[(i,j)] = search(i,j)
        # print(dic)
        # return max(dic.values())**2
                                