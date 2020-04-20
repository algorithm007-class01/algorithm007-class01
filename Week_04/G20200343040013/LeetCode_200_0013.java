/**
 * 岛屿数量
 */
public int numIslands(char[][] gird) {

    int count = 0;

    for(int i = 0; i < gird.length; i++) {
        for (int j = 0; j < gird[0].length; j ++) {
            if (gird[i][j] == '1') {
                count++;
                dfs(gird, i, j);
            }
        }
    }
    return count;
}

public void dfs(char[][] gird, int i, int j) {
    if ( i < 0 || j < 0 || i >= gird.length || j >= gird[0].length || gird[i][j] != '1') {
        return;
    }

    gird[i][j] = 0;

    dfs(gird, i, j + 1);
    dfs(gird, i, j - 1);
    dfs(gird, i + 1, j);
    dfs(gird, i -1, j);
}