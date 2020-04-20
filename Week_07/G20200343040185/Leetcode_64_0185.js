var minPathSum = function(grid) {
  for (let i = 1; i < grid[0].length; i++) {
    grid[0][i] = grid[0][i] + grid[0][i - 1];
  }
  for (let i = 1; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (j === 0) grid[i][0] = grid[i - 1][0] + grid[i][0];
      else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
    }
  }
  return grid[grid.length - 1][grid[grid.length - 1].length - 1];
};