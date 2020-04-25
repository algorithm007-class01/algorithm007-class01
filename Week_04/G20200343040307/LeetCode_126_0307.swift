/*
 * @lc app=leetcode.cn id=126 lang=swift
 *
 * [126] 单词接龙 II
 */

// @lc code=start
// 较优解法： BFS + DFS
// 利用 BFS 找到并存储最优路径，利用 DFS 输出路径
// 广度优先查找中 处理当前单词，获取到所有“相邻单词“
// 在所有相邻单词中，需要判断是否合法，是否已经存入深度集合（是否访问）
// 遍历符合要求的新单词，存储相邻关系，和对应深度。判断是否和目标单词相等，然后入队列准备处理
// 全部处理完成之后，得到一个深度集合，一个相邻关系表
// DFS
// 利用相邻关系表，获取到下一级的单词，判断两个单词深度相差是否为一
// 如果差为 1，则继续递归查询
// 为什么会出现差不为一的情况.相邻关系表中只是保证合法性，层级相邻说明是最短路径


// 当初使用 BFS 算法，会比 DFS + BFS 慢很多



// 方法一
class Solution {
    let alphabet = Array("abcdefghijklmnopqrstuvwxyz")

    func findLadders(_ beginWord: String, _ endWord: String, _ wordList: [String]) -> [[String]] {
        // 查询是否在库中
        var dictionary = Set(wordList)
        // 返回的结果
        var result = [[String]]()
        // 记录路径深度
        var distance = [String: Int]()
        // 记录相差为一的附近单词
        var neighbors = [String: [String]]()

        dictionary.insert(beginWord)

        // Get distances and neighbors for each word
        bfs(beginWord, endWord, &dictionary, &distance, &neighbors)

        // Get results of word ledders
        var temp = [String]()
        dfs(beginWord, endWord, &dictionary, &distance, &neighbors, &result, &temp)

        return result
    }

    private func bfs(_ beginWord: String, _ endWord: String, _ dictionary: inout Set<String>, _ distance: inout [String: Int], _ neighbors: inout [String: [String]]) {
        // 初始化所有单词的临近关系，保证在 DFS 查路径时不为空
        for word in dictionary {
            neighbors[word] = [String]()
        }

        var queue = [String]()
        queue.append(beginWord)
        distance[beginWord] = 0

        while !queue.isEmpty {
            var newQueue = [String]()
            var foundEnd = false
            for word in queue {

                let wordDistance = distance[word]!

                let wordNeighbors = getNeighbors(&dictionary, word)
                
                for neighbor in wordNeighbors {
                    neighbors[word]!.append(neighbor)
                    // 记录路径深度的同事，防止重复访问。广度优先访问，在后面重复访问的单词的路径一定更长
                    if distance[neighbor] == nil {
                        distance[neighbor] = wordDistance + 1
                        if neighbor == endWord {
                            foundEnd = true
                        } else {
                            newQueue.append(neighbor)
                        }
                    }
                }
            }
            if foundEnd {
                break
            }
            queue = newQueue
        }
    }

    private func getNeighbors(_ dictionary: inout Set<String>, _ word: String) -> [String] {
        var wordChars = Array(word)
        var result = [String]()
        for i in 0..<word.count {
            let oldChar = wordChars[i]
            for letter in alphabet {
                wordChars[i] = letter
                let newWord = String(wordChars)
                if dictionary.contains(newWord) {
                    result.append(newWord)
                }
            }
            wordChars[i] = oldChar
        }
        return result
    }

    private func dfs(_ beginWord: String, _ endWord: String, _ dictionary: inout Set<String>, _ distance: inout [String: Int], _ neighbors: inout [String: [String]], _ result: inout [[String]], _ temp: inout [String]) {
        temp.append(beginWord)
        if beginWord == endWord {
            result.append(temp)
        } else {
            let wordDistance = distance[beginWord]!
            for neighbor in neighbors[beginWord]! {
                if distance[neighbor]! == wordDistance + 1 {
                    dfs(neighbor, endWord, &dictionary, &distance, &neighbors, &result, &temp)
                }
            }
        }
        temp.removeLast()
    }
}


// 方法二
// 优化一： 数组换成 Set,没有通过
// 优化二： 从 wordList 里 remove ，有明显提高，但是还没有通过
// 优化三： 新增 Int 和 String Extension。通过，时间接近 4000ms
class Solution {
    func findLadders(_ beginWord: String, _ endWord: String, _ wordList: [String]) -> [[String]] {
        var res:[[String]] = [[String]]()
         //加速查找
        var dict:Set<String> = Set<String>(wordList)
        //构建队列
        var p:[String] = [String]()
        //加入源顶点
        p.append(beginWord)
        var paths:[[String]] = [[String]]()
        paths.append(p)
        var level:Int = 1, minLevel:Int = Int.max
        var words:Set<String> = Set<String>()
        while (paths.count != 0)
        {
            var t = paths.removeFirst()
                // 相当于 subVisited 保存的是所有临近单词
                // 大于表示进入了下一层，需要把当前这层的 word 都删去，也就是 visited 
            if t.count > level{
                for w in words{dict.remove(w)}
                words = Set<String>()
                level = t.count
                if level > minLevel {break}
            }
            var last:String = t.last!
            for i in 0..<last.count
            {
                var newLast:String = last
                for ch in 97...122
                {
                    newLast[i] = ch.ASCII
                    if !dict.contains(newLast){continue}
                    words.insert(newLast)
                    if newLast == endWord{
                        res.append(t+[newLast])
                        minLevel = level
                    }else{
                        paths.append(t+[newLast])
                    }
                    // 这种写法并不能通过测试
                    // if diction.contains(new) {
                        //     if new == endWord {
                        //     ans.append(words+[new])
                        //     // found = true
                        //     minLevel = level
                        //     }else   {
                            
                        //     stack.append(words+[new])
                        //     }
                        // }

                }
            }
        }
        return res
    }
}
//String扩展方法
extension String {
    func toCharArray() -> [Character]
    {
        var arr:[Character] = [Character]()
        for char in self
        {
            arr.append(char)
        }
        return arr
    }
    
    //subscript函数可以检索数组中的值
    //直接按照索引方式截取指定索引的字符
    subscript (_ i: Int) -> Character {
        //读取字符
        get {return self[index(startIndex, offsetBy: i)]}
        
        //修改字符
        set
        {
            var str:String = self
            var index = str.index(startIndex, offsetBy: i)
            str.remove(at: index)
            str.insert(newValue, at: index)
            self = str
        }
    }
}
//Int扩展方法  
extension Int
{
    //属性：ASCII值(定义大写为字符值)
    var ASCII:Character 
    {
        get {return Character(UnicodeScalar(self)!)}
    }
}
// @lc code=end

