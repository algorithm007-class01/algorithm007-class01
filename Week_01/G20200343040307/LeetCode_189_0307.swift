/*
 * @lc app=leetcode.cn id=189 lang=swift
 *
 * [189] 旋转数组
    1. 暴力求解，从末尾取出并删除一位，然后插入到第一位，循环求解
    2. 取出最后一位，将前 n-1 个数全部往后移动一位，替换第一位，循环求解
    3. 从第一位开始，将 k+1 的数据取出并替换，从 k+1 位置继续计算
       根据 （k+1）/nums.count .一次只移动一位。
    1,2,3,4,5,6,7,8，9

    nums.count/k =  0
    k =5
    (k 次内循环)
 */

// @lc code=start
// 解法一： 暴力求解，每次讲最后一位移动到第一位。或利用新数组计算和赋值
// 解法二： 根据 k，依次计算每个元素最终的位置
// 会出现这一种特殊的情况，k%n == 0 的时候，无法遍历到所有元素
class Solution {
    func rotate(_ nums: inout [Int], _ k: Int) {
        //  n 代表的是移动次数，每个元素都只移动一次就等于数组的大小
        var n = nums.count
        // 如果 k > n ,取两者的余数
        var step = k%n
        // 元素个数为 1 和移动位置为 0
        if(n<2 || step<1){
            return
        } 
        var i = step
        while n > 0 {
            // 移动之后的位置
            var j=i
            // 需要移动的元素
            var prev=nums[(i - step)%step]
            while n > 0 {
                n -= 1
                // 交换之后，prev 代表的是原来被覆盖之前的元素
                (prev , nums[j]) = (nums[j], prev)
                // 计算当前 prev 需要移动到的位置
                j = (j + step)%nums.count
                // j == i 的情况，会在 k%n 的时候且 j 完成了一次循环到了最开始的位置
                if (j == i ){
                    break
                }
                    
            }
            i += 1
        }
    }
}

// 解法三： swift 特殊的取巧方法 
//  enumerated 方法并不是依次根据下标读取数组中的元素，而是根据元素而产生的 index

class Solution {
    func rotate(_ nums: inout [Int], _ k: Int) {
        for (index,value) in nums.enumerated(){
            let curIndex = (index + k)%nums.count 
            nums[curIndex] = value
        }
    }
}

// 解法四： 反转
class Solution {
    func rotate(_ nums: inout [Int], _ k: Int) {
        let count = nums.count
        let reverse = k % count
		// improve  应该增加 revers 是否为零判断
        nums.reverse()
        // swift 写法 （ArraySlice）
        nums[0..<reverse].reverse()
        nums[reverse..<count].reverse()
    }
}

// @lc code=end

