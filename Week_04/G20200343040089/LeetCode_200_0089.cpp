/**
* Summary :	number-of-islands
* Parameters :
*   grid : islands vector
* 	i 	 : x-axis coordinate
*	j	 : y-axis coordinate
* Return : islands size
*/
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int counter = 0;
        for (int i = 0; i < grid.size(); ++i) {
            for (int j = 0; j < grid[i].size(); ++j) {
                if ('1' == grid[i][j]) {
                    ++counter;
                    DFS(grid, i, j);
                }
            }
        }
        return counter;
    }
private:
    void DFS(vector<vector<char>>& grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.size() || j >= grid[0].size() || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFS(grid, i - 1, j);
        DFS(grid, i + 1, j);
        DFS(grid, i, j - 1);
        DFS(grid, i, j + 1);
    }
};