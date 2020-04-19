// 221. 最大正方形
/*
 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

 示例:

 输入:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 输出: 4
 */

class Solution {
    func maximalSquare(matrix: [[Character]]) -> Int {
        guard matrix.count != 0 else {
            return 0
        }
    
        let m = matrix.count
        let n = matrix[0].count
    
        var max_global = 0
        var maxSquareSide = Array(count: m, repeatedValue: (Array(count: n, repeatedValue: 0)))
        
        for i in 0..<m {
            for j in 0..<n {
                guard matrix[i][j] != "0" else {
                    continue;
                }
            
                if i == 0 || j == 0 {
                    maxSquareSide[i][j] = 1
                } else {
                    maxSquareSide[i][j] = min(maxSquareSide[i][j - 1], maxSquareSide[i - 1][j], maxSquareSide[i - 1][j - 1]) + 1
                }
                
                max_global = max(max_global, maxSquareSide[i][j])
            }
        }
        
        return max_global * max_global
    }
}

