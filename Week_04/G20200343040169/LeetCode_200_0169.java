/** 
 * 广度优先
 */
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int count = 0;
        for(int r = 0; r< rowLen; r++){
            for(int c = 0; c < colLen; c++){
                //将岛屿元素标记为水状态，总数加一
                if(grid[r][c] == '1'){
                    count ++;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(colLen * r + c);
                    while(!neighbors.isEmpty()){
                        int id = neighbors.remove();
                        int row = id / colLen;
                        int col = id % rowLen;
                        //如果上边元素为岛，加入队列并标记为水状态
                        if(row - 1 >= 0 && grid[row - 1][col] == '1'){
                            neighbors.add((row - 1) * colLen + col);
                            grid[row - 1][col] = '0';
                        }
                        //如果下边元素为岛，加入队列并标记为水状态
                        if(row + 1 < rowLen && grid[row + 1][col] == '1'){
                            neighbors.add((row + 1) * colLen + col);
                            grid[row + 1][col] = '0';
                        }
                        //如果左边元素为岛，加入队列并标记为水状态
                        if(col - 1 >= 0 && grid[row][col - 1] == '1'){
                            neighbors.add(row * colLen + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        //如果右边元素为岛，加入队列并标记为水状态
                        if(col + 1 < colLen && grid[row][col + 1] == '1'){
                            neighbors.add(row * colLen + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }

            }
        }
        return count;
    }
}