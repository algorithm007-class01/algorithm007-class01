/*
 * @lc app=leetcode.cn id=493 lang=swift
 *
 * [493] 翻转对
 */

// @lc code=start
class Solution {
    func reversePairs(_ nums: [Int]) -> Int {
        var ans = nums 
        return mergeSort(&ans, 0, nums.count-1)
    }

    func mergeSort(_ ans: inout [Int], _ left: Int, _ right : Int) -> Int{
        if left >= right {
            return 0
        }
        let mid = left + (right-left)/2
        var count = mergeSort(&ans, left, mid) + mergeSort(&ans, mid+1, right)
        var j = mid+1
        var i = left

        //var cache = [Int](repeating: 0,count: right-left+1)
				var cache = [Int]()
        var t = left
				// improve 
        // var tmp = 0
        while j <= right  {
            while ans[i] <= ans[j]*2 && i <= mid {
                i += 1
            }
            while ans[t] <= ans[j] && t <= mid {
                //cache[tmp] = ans[t]
								cache.append(ans[t])
                t += 1
                //tmp += 1
            }
            //cache[tmp] = ans[j]
            //tmp += 1
						cache.append(ans[j])
            j += 1
            count += (mid-i+1)
        }
        while t <= mid {
            //cache[tmp] = ans[t]
						cache.append(ans[t])
            t += 1
            //tmp += 1
        }
        for j in left...right {
            ans[j] = cache[j-left]
        }
        // merge(&ans, left, right)超出时间限制
        return count 
    }

    func merge(_ ans: inout [Int], _ left: Int, _ right: Int) {
        var tmp = ans
        let mid = left + (right-left)/2

        var fir = left
        var sec = mid + 1
        for i in left...right {
            if sec > right {
                ans[i] = tmp[fir]
                fir+=1
            }else if fir > mid {
                ans[i] = tmp[sec]
                sec += 1
            }else if tmp[fir] < tmp[sec] {
                ans[i] = tmp[fir]
                fir+=1
            }else {
                ans[i] = tmp[sec]
                sec += 1
            }
        }

    }
}
// @lc code=end

