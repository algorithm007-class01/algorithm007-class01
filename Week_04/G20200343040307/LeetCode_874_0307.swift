/*
 * @lc app=leetcode.cn id=874 lang=swift
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
// 第一遍思路：判断方向，根据距离，遍历整个障碍点数组，计算移动的距离中是否存在障碍点
// 时间复杂度过大 超出时间限制
// 第二遍错误，将 ob 转化为 Int 数组时，最大范围错误
// 直接利用原障碍物数组查找是否包含新坐标也可以
class Solution {
    func robotSim(_ commands: [Int], _ obstacles: [[Int]]) -> Int {
        // 处理障碍点
        let ob = obstacles.reduce(into: Set<Int>()){$0.insert($1[0]*100_000+$1[1])}
        // 前左后右
        let direction = [[0,1],[-1,0],[0,-1],[1,0]]
        var dir = 0 
        var pos = [0, 0]
        var maxDis = 0
        for item in commands {
            if item < 0 {
                if item == -2 {
                    dir = (dir + 1)%4
                }else {
                    dir = (dir + 3)%4
                }
                print("\(dir)")
            }else {
                
                 for i in 0..<item {
                     let new = [pos[0]+direction[dir][0],pos[1]+direction[dir][1]]
                     if ob.contains(new[0]*100_000+new[1]) {
                         break
                     }
                     pos = new  
                 }
                 maxDis = max(maxDis, pos[0]*pos[0]+pos[1]*pos[1])
            }
        }
        // maxDis = max(maxDis, pos[0]*pos[0]+pos[1]*pos[1])        
        return maxDis
    }
}
// @lc code=end
