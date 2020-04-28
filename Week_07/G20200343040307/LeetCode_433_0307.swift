/*
 * @lc app=leetcode.cn id=433 lang=swift
 *
 * [433] 最小基因变化
 */

// @lc code=start
// 单向 BFS
class Solution {
    func minMutation(_ start: String, _ end: String, _ bank: [String]) -> Int {
        
        if !bank.contains(end) {
            return -1
        }
        // if let index = banks.firstIndex(of: start) {
        //     banks.remove(at: index)
        // }
        var stackStart = [String]()
        var stackEnd = [String]()
        let sum = ["A","C","G","T"]
        
        var step = 0
        stackStart.append(start)
        stackEnd.append(end)
        var banks = bank
        while !stackStart.isEmpty && !stackEnd.isEmpty {
                step += 1
                var tmpStack = [String]()
                if stackStart.count > stackEnd.count {
                    tmpStack = stackStart
                    stackStart = stackEnd
                    stackEnd = tmpStack
                }
                var count = stackStart.count
                while count > 0 {
                    count -= 1
                    let str = stackStart.removeFirst()
                    var strArray = Array(str).map({String($0)})
                    for i in 0..<strArray.count {
                        print("\(i)+ \(strArray.count)")
                        let tmpChar = strArray[i]
                        for j in 0...3 {
                            strArray[i] = sum[j]

                            let redStr = strArray.reduce("",+)
                            if stackEnd.contains(redStr) {
                                return step
                            }else if let index = banks.firstIndex(of: redStr) {
                                banks.remove(at: index)
                                stackStart.append(redStr)
                            }
                        }
                        strArray[i] = tmpChar
                    }
                }
        }
        return -1
    }
}
// 双向 BFS
class Solution {
    func minMutation(_ start: String, _ end: String, _ bank: [String]) -> Int {
        
        if !bank.contains(end) {
            return -1
        }
        var stackStart = [String]()
        var stackEnd = [String]()
        let sum = ["A","C","G","T"]
        
        var step = 0
        stackStart.append(start)
        stackEnd.append(end)
        var banks = bank
        while !stackStart.isEmpty && !stackEnd.isEmpty {
                step += 1
                var tmpStack = [String]()
                if stackStart.count > stackEnd.count {
                    tmpStack = stackStart
                    stackStart = stackEnd
                    stackEnd = tmpStack
                }
                var count = stackStart.count
                while count > 0 {
                    count -= 1
                    let str = stackStart.removeFirst()
                    var strArray = Array(str).map({String($0)})
                    for i in 0..<strArray.count {
                        print("\(i)+ \(strArray.count)")
                        let tmpChar = strArray[i]
                        for j in 0...3 {
                            strArray[i] = sum[j]

                            let redStr = strArray.reduce("",+)
                            if stackEnd.contains(redStr) {
                                return step
                            }else if let index = banks.firstIndex(of: redStr) {
                                banks.remove(at: index)
                                stackStart.append(redStr)
                            }
                        }
                        strArray[i] = tmpChar
                    }
                }
        }
        return -1
    }
}

// DFS
class Solution {

    func minMutation(_ start: String, _ end: String, _ bank: [String]) -> Int {
        var stack = [String]()
        var stepMin = 100
        dfs(&stack, 0, &stepMin,start,end,bank)
        return stepMin == 100 ? -1 : stepMin
    }

    func dfs( _ reverse: inout [String], _ step:  Int,_ minStep: inout Int, _ current: String ,_ end: String,_ bank: [String]) {
        if current == end {
            minStep = min(minStep, step)
        }
        for item in bank {
            var diff = 0
            let currArray = Array(current).map({String($0)})
            let itemArray = Array(item).map({String($0)})
            for i in 0..<item.count {
                print("\(currArray[i])+\(itemArray[i])")
                if currArray[i] != itemArray[i] {
                    diff += 1
                    if diff > 1{
                        break
                    }
                }
            }

            if diff == 1 && !reverse.contains(item) {
                reverse.append(item)
                dfs(&reverse, step+1, &minStep ,item,end,bank)
                reverse.removeLast()
            } 
        }
    }
}
// @lc code=end

