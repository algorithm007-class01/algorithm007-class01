public class LeetCode_72_0201 {
    /**
     * 抄自王争老师的：42 | 动态规划实战：如何实现搜索引擎中的拼写纠错功能
     * https://time.geekbang.org/column/article/75794
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int n = word1.length();
        int m = word2.length();
        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();
        int[][] minDist = new int[n][m];
        for (int j = 0; j < m; ++j) {
            if (a[0] == b[j])
                minDist[0][j] = j;
            else if (j != 0)
                minDist[0][j] = minDist[0][j - 1] + 1;
            else
                minDist[0][j] = 1;
        }

        for (int i = 0; i < n; ++i) {
            if (a[i] == b[0])
                minDist[i][0] = i;
            else if (i != 0)
                minDist[i][0] = minDist[i - 1][0] + 1;
            else
                minDist[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i] == b[j])
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
                else
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
            }
        }
        return minDist[n - 1][m - 1];
    }

    private int min(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }

}
