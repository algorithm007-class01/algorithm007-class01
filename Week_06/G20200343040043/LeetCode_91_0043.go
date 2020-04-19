package G20200343040043

// 91. 解码方法
// 题目：https://leetcode-cn.com/problems/decode-ways/

// 解法
// 记录上次和当前，如果在11～26之间，dp[i-1], dp[i] = dp[i-1], dp[i-1] + dp[i-2], (10、20)除外不新增
// 测试用例的边界条件很多，多判断！！！解码失败的全返回0

func numDecodings(s string) int {
	if s == "0" || s == "" {
		return 0
	}
	lastS := s[0:1]
	if lastS == "0" {
		return 0
	}
	pre, cur := 1, 1
	for i := 1; i < len(s); i++ {
		curS := s[i : i+1]
		if curS == "0" {
			if lastS < "3" && lastS > "0" {
				cur = pre
			} else {
				return 0
			}
		} else if lastS == "2" && curS < "7" {
			pre, cur = cur, cur+pre
		} else if lastS == "1" {
			pre, cur = cur, cur+pre
		} else {
			pre = cur
		}

		lastS = curS

	}
	return cur
}

// times: 1
