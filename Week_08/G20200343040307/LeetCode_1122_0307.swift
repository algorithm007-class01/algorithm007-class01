/*
 * @lc app=leetcode.cn id=1122 lang=swift
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    func relativeSortArray(_ arr1: [Int], _ arr2: [Int]) -> [Int] {
        var res = [Int](repeating: 0, count: 1001)
        var maxNum = 0

        for num in arr1 {
            res[num] += 1
            maxNum = max(maxNum, num)
        }

        var ans = [Int]()
        for tmp in arr2 {
            while res[tmp] > 0{
                ans.append(tmp)
                res[tmp] -= 1
            }
        }

        for i in 0...maxNum {
            while res[i] > 0 {
                ans.append(i)
                res[i] -= 1
            }
        }
        return ans
    }
}

// swift 特别解法
class Solution {
    func relativeSortArray(_ arr1: [Int], _ arr2: [Int]) -> [Int] {
				
        let order: [Int: Int] = arr2.enumerated().reduce(into: [:]) { result, next in
            let (i, n) = next
            result[n] = i 
        }
        
        return arr1.sorted(by: { lhs, rhs in
            switch (order[lhs], order[rhs]) {
            case (nil, nil):
                return lhs < rhs
            case (nil, _):
                return false
            case (_, nil):
                return true
            case (let left?, let right?):
                return left < right
            }
        })
    }
}
// @lc code=end

