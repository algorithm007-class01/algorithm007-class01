/**
 * 做这道题思路，思路受了200-Number-of-Islands这道题目的启发。
 * 用的DFS
 *
 */
public class LeetCode_547_0201 {

    int n;  //边界

    public int findCircleNum(int[][] M) {
        n = M.length;
        int circleNum = 0;
        for (int r = 0; r < n; r++) {
            for (int c = r; c < n; c++) {
                if (M[r][c] == 1) {
                    /**
                     * 一次DFS，就将一批是朋友的，都置为0。
                     * 再发现有1的，那就是另一个朋友圈了
                     */
                    circleNum++;
                    dfs(r, M);

                }
            }
        }
        return circleNum;
    }

    private void dfs(int r, int[][] M) {
        for (int i = 0; i < M.length; i++) {
            if (M[r][i] == 1) {
                /**
                 * M[r][i]和 M[i][r]，表示的是同一关系。所以同时置为0
                  */
                M[r][i] = 0;
                M[i][r] = 0;

                dfs(i, M);
            }
        }
    }
}
