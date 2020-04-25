
//最小路径和
public int minPathSum(int[][] grid) {
	int n = grid.length;

	if (n == 0) {
		return 0;
	}
	int m = grid[0].length;

	int[][] dp = new int[n+1][m+1];
	for (int i = n-1; i >= 0; i--) {
		for (int j = m-1; j >= 0; j-- ) {
			if (i == n-1) {
				dp[i][j] = dp[i][j+1] + grid[i][j];
			} else if (j == m-1) {
				dp[i][j] = dp[i+1][j] + grid[i][j];
			} else {
				dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + dp[i][j];
			}
		}
	}
	return dp[0][0];
}

public int numDecoding(String s) {
	if (s == null || s.length() == 0) {
		return 0;
	}

	int n = s.length();
	int[] dp = new int[n+1];
	dp[0] = 1;
	dp[1] = s.charAt(0) != 0 ? 1 : 0;

	for (int i = 2; i <=n ; i++) {
		int one = Integer.valueOf(s.substring(i-1, i));
		int two = Integer.valueOf(s.substring(i-2, i));

		if (one >= 1 && one <= 9) {
			dp[i] += dp[i-1];
		}

		if (two >= 10 && two <= 26) {
			dp[i] += dp[i-2];
		}
	}
	return dp[n];
}