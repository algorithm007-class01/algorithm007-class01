class Solution {
public:
    int numDecodings(string s) {
        // 分治(子问题) 
        // 一个数字可以有一种编码方法，二个数字有两种编码方法
        //f(i) = f(i - 1) + f(i - 2). 
         // 状态数组
         //dp[i],表示
         // i-对应str[i]结尾
         // dp[i]-对应以str[0..i]结尾的译码方法总数
         // 目标结果dp[size]. 就是以str[size]结束的译码方法总数.
         // dp[0].表示以str[0]为结尾的译码总数，dp[0]只能为1
         // dp[1].表示以str[0..1]为结尾的译码总数, 
        // 状态方程
        // 若s[i] = '0', 若s[i-1] = '1' or '2', 则dp[i] = dp[i-2].否则 return 0.
        //  解释: s[i-1]+ s[i] 唯一被译码，不增加情况
        // 若s[i-1] = '1', dp[i] = dp[i - 1] + dp[i - 2]
        //  解释: s[i-1]与s[i]分开译码, 为dp[i-1],合并译码，为dp[i-2].
        // 若s[i-1] = '2', '1' <= s[i] <= '6', dp[i] = dp[i - 1] + dp[i - 2]. 
        int size = s.size();
        if(s.empty() || s[0] == '0') {
            return 0;
        }
        // 定义状态数组
        vector<int> dp(size + 1);
        // 初始化状态数组.
        dp[0] = 1;
        dp[1] = 1;
        // 定义dp.
        for(int i = 1; i < size; i++) {
            if(s[i] == '0') {
                if(s[i - 1] == '1' || s[i - 1] == '2') {
                    dp[i + 1] = dp[i - 1];
                } else {
                    return 0;
                }
            } else if(s[i - 1] == '1' || (s[i - 1] == '2' && s[i] >= '1' && s[i] <= '6')) {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else {
                dp[i + 1]  = dp[i];
            }
        }
        return dp[size];
    }
};
