class Solution {
    public int findCircleNum(int[][] M) {
        final boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] m, boolean[] visited, int level) {
        for (int i = 0; i < m.length; i++) {
            if (m[level][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(m, visited, i);
            }
        }
    }
}