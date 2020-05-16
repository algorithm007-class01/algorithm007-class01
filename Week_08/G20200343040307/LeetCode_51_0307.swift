/*
 * @lc app=leetcode.cn id=51 lang=swift
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
    func solveNQueens(_ n: Int) -> [[String]] {
        guard n > 0 else {
            return []
        }
        var results = [[String]]()
        // 存储每个皇后的 x 坐标
        var cols = [Int]()
        dfsHelper(n, &cols, &results)
        return results
    }
    
    fileprivate func dfsHelper(_ n: Int, _ cols: inout [Int], _ results: inout [[String]]) {
        if cols.count == n {
            results.append(draw(cols))
            return 
        }
        
        for i in 0..<n {
            guard isValid(cols, i) else {
                continue
            }
            cols.append(i)
            dfsHelper(n, &cols, &results)
            cols.removeLast()
        }
    }
    
    
    fileprivate func isValid(_ cols: [Int], _ colIndex: Int) -> Bool {
        for rowIndex in 0..<cols.count {
            // 竖向 
            if colIndex == cols[rowIndex] {
                return false
            }
            // 左对角线
            if cols[rowIndex] - rowIndex == colIndex - cols.count {
                return false
            }
            // 右对角线
            if cols[rowIndex] + rowIndex == colIndex + cols.count {
                return false
            }
        }
        return true
    }
    
    fileprivate func draw(_ cols: [Int]) -> [String] {
        var result = [String]()
        for rowIndex in 0..<cols.count {
            var row = ""
            for j in 0..<cols.count {
                row += cols[rowIndex] == j ? "Q" : "."
            }
            result.append(row)
        }
        return result
    }
}

class Solution {
    var size = 0 
    var count = 0 
    func totalNQueens(_ n: Int) -> Int {
        size = (1 << n) - 1
        dfs(0,0,0)
        return count
    }
    func dfs(_ row: Int, _ ld: Int, _ rd: Int) {
        
        if row == size {
            count += 1
            return
        }
        var pos = size & (~(row|ld|rd))
        while pos != 0 {
            var p = pos&(-pos)
            pos = pos&(pos-1)
            dfs(row|p, (ld|p)<<1, (rd|p)>>1)
        }
    }
}
// @lc code=end

