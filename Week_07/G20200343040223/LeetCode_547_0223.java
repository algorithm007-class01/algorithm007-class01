package leetcode;

public class LeetCode_547_0223 {

    //DFS 朋友圈问题
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M[0].length; j++) {
            if (M[i][j] == 0 || visited[j]) continue;
            visited[i] = true;
            dfs(M, visited, j);
        }
    }
}
