/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
    if (grid.length <= 0) return 0;
    let row = grid.length, col = grid[0].length;

    for (let i = 0; i < row; i++) {
        for (let j = 0; j < col; j++) {
            if (i == 0 && j == 0) continue;
            else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
            else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
            else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
        }
    }

    return grid[row - 1][col - 1];
};

// DP:
//   子问题: min_path(i, j) =  = Math.min(min_path(i-1,j), min_path(i, j-1))
//   状态树: f(i)
//   dp方程: min_path(i, j) =  = Math.min(min_path(i-1,j), min_path(i, j-1))+ grid[i,j]