class Solution {
	public:
		int numDecodings(string s) {
		
		// 若s[i] = '0', 若s[i-1] = '1' or '2', 则dp[i] = dp[i-2].否则 return 0.
        	//  解释: s[i-1]+ s[i] 唯一被译码，不增加情况
        	// 若s[i-1] = '1', dp[i] = dp[i - 1] + dp[i - 2]
        	//  解释: s[i-1]与s[i]分开译码, 为dp[i-1],合并译码，为dp[i-2].
        	// 若s[i-1] = '2', '1' <= s[i] <= '6', dp[i] = dp[i - 1] + dp[i - 2].\
		// 分治(子问题)
		// 定义状态数组/初始化状态数组
		// 定义dp
		if(
		
		}
};
