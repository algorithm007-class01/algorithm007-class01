

//最小编辑距离
public int minDistance(String word1, String word2) {
	int n = word1.length();
	int m = word2.length();

	if (n * m == 0) {
		return n+m;
	}

	int[][] dp = new int[n+1][m+1];

	for (int i = 0; i <= n; i++) {
		dp[i][0] = i;
	}

	for (int j = 0; j <= m; j++) {
		dp[0][j] = j;
	}
	for (int i = 1; i < n+1; i++) {
		for (int j = 1; j< m+1 ; j++) {
			int down = dp[i-1][j] + 1;
			int left = dp[i][j-1] + 1;
			int lefe_down = dp[i-1][j-1];
			if (word1.charAt(i-1) != word2.charAt(j-1)) {
				lefe_down += 1;
			}

			dp[i][j] = Math.min(lefe_down, Math.min(left, down));
		}
	}
	return dp[n][m]; 
}