/*
 * @lc app=leetcode.cn id=42 lang=swift
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
//  因为这道题 LeetCode 并不支持使用 Swift，所以我只使用几个比较典型的测试样例，可能并不完全正确

解法一： 迭代
func levelOrderNodeTree(_ root: Node?) -> [Int] {
        var ans = [Int]()
        var queue = [Node?]()
        
        var tree = root
        queue.append(tree)
        while  !queue.isEmpty {
            tree = queue.removeFirst()
            ans.append(tree!.val!)
            if let children = tree?.children {
                for item in children {
                    queue.append(item)
                }
            }
            // 没有类似 popLast 的 popFirst, 如果和之前格式(前中后序迭代)统一需要这么写
//            if queue.count > 0 {
//                 tree = queue.removeFirst()
//            }else {
//                break
//            }
        }
        return ans
    }


// @lc code=end