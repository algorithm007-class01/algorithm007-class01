public class LeetCode_647_0145 {

    /**
     * 647:计算回文子串数量
     * */
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left < 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
