/*
 * @lc app=leetcode.cn id=529 lang=swift
 *
 * [529] 扫雷游戏
 */

// @lc code=start
// DFS
// 判断当前是否为地雷
// 不是，则广度优先
// 每个节点对附近八个节点查询
// 如果附近有地雷，则显示个数并停止查询

// 错误一： 未将当前节点改变状态之后再递归
class Solution {
    func updateBoard(_ board: [[Character]], _ click: [Int]) -> [[Character]] {
            var bbb = board 
            if bbb[click[0]][click[1]] == "M" {
                bbb[click[0]][click[1]] = "X"
                return bbb
            }
            let m = board.count
            let n = board[0].count
            
            helper(&bbb, (click[0], click[1]),m ,n)
            return bbb
    }
    func helper(_ board: inout [[Character]], _ grid: (Int, Int),_ m: Int, _ n: Int) {
        if grid.0 < 0 || grid.0 >= m || grid.1 < 0 || grid.1 >= n || board[grid.0][grid.1] != "E" {
            return 
        }
        var level = [(Int,Int)]()
        var count = 0
        for i in -1...1 {
            for j in -1...1 {
                let newX = grid.0 + i
                let newY = grid.1 + j
                if newX >= 0 && newX < m && newY >= 0 && newY < n {
                    if board[newX][newY] == "M" || board[newX][newY] == "X" {
                        count += 1
                    }else if board[newX][newY] != "B" {
                        level.append((newX, newY))
                    }
                }
            }
        }
        if count == 0 {
            board[grid.0][grid.1] = "B"
            for item in level {
                helper(&board,item ,m ,n)
            }
            // for i in -1...1 {
            //     for j in -1...1 {
            //         helper(&board, (grid.0 + i, grid.1 + j),m ,n)
            //     }
            // }
            
        }else {
            board[grid.0][grid.1] = Character(String(count))
        }
    }
}


class Solution {
    func updateBoard(_ board: [[Character]], _ click: [Int]) -> [[Character]] {
      let rows = board.count, cols = board[0].count
      var currentTuple: (Int, Int) = (click[0], click[1])
      var board = board
    
      var queue = [currentTuple]
      while !queue.isEmpty {
        let (currX, currY) = queue.popLast()!
        if board[currX][currY] == "M" {
          board[currX][currY] = "X" // Game over!
        } else {
          // Get total number of mines surrounding the square
          var count = 0
          for (dx, dy) in [(1, 0), (0, 1), (-1, 0), (0, -1), (1, 1), (-1, -1), (1, -1), (-1, 1)] {
            let (nextX, nextY) = (dx + currX, dy + currY)
            if nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols {
              if ["M", "X"].contains(board[nextX][nextY]) {
                count += 1
              }
            }
          }
          if count > 0 {
            // Terminate search
            board[currX][currY] = Character.init("\(count)")
          } else {
            // Else, perform BFS search
            board[currX][currY] = "B"
            for (dx, dy) in [(1, 0), (0, 1), (-1, 0), (0, -1), (1, 1), (-1, -1), (1, -1), (-1, 1)] {
              let (nextX, nextY) = (dx + currX, dy + currY)
              if nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols {
                if ["E"].contains(board[nextX][nextY]) {
                  queue.append((nextX, nextY))
                  board[nextX][nextY] = "B"
                }
              }
            }
          } 
        } 
      }
      return board
   }
}

// improve 
class Solution {
    func updateBoard(_ board: [[Character]], _ click: [Int]) -> [[Character]] {
        let h = board.count
        let w = board[0].count
        
        var copied = board
        func checkAdjacentPoints(x: Int, y: Int) {
            var numberOfBombs = 0
            
            for i in max(0,x-1)...min(h-1,x+1) {
                for j in max(0,y-1)...min(w-1,y+1) {
                    if i==x, j==y { continue }
                    if copied[i][j] == "M" { numberOfBombs += 1 }
                }
            }
            
            if numberOfBombs == 0 {
                copied[x][y] = "B"
                for i in max(0,x-1)...min(h-1,x+1) {
                    for j in max(0,y-1)...min(w-1,y+1) {
                        if i==x, j==y { continue }
                        if copied[i][j] == "E" { checkAdjacentPoints(x: i, y: j) }
                    }
                }
            } else {
                copied[x][y] = Character("\(numberOfBombs)")
            }
        }
        
        if copied[click[0]][click[1]] == "M" {
            copied[click[0]][click[1]] = "X"
        } else {
            checkAdjacentPoints(x: click[0], y: click[1])
        }
        
        return copied
    }
}

// @lc code=end

