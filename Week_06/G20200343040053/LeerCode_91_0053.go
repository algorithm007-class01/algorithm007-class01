package leetcode_week05_G20200343040053

//【91. 解码方法】

//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
// 示例 1:
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
//
//
// 示例 2:
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//
// Related Topics 字符串 动态规划

//leetcode submit region begin(Prohibit modification and deletion)
func numDecodings(s string) int {
	sLenght := len(s)
	if s == "" || s == "0" || s[0] == '0' {
		return 0
	}
	dp := make([]int, sLenght)

	dp[0] = 1
	for i := 1; i < sLenght; i++ {
		if s[i] != '0' {
			dp[i] = dp[i-1]
		}
		if s[i-1] == '1' || (s[i-1] == '2') && s[i] <= '6' {
			if i >= 2 {
				dp[i] += dp[i-2]
			} else {
				dp[i]++
			}
		}
	}
	return dp[sLenght-1]
}

//leetcode submit region end(Prohibit modification and deletion)
