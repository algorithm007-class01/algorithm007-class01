class Solution {

    private int count;
    private int[] parent;
    private int row;
    private int col;

    private int[][] directions = {{1,0},{0,1}};

    private void init(int n){
        count = n;
        parent = new int[n];
        for (int i = 0; i < n ; i++) {
            parent[i] = i;
        }
    }

    private int find(int p){
        while (p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private void union(int p , int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;

        parent[rootP] = rootQ;
        count--;
    }

    public int numIslands(char[][] grid) {
        row = grid.length;
        if(row == 0) return 0;

        col = grid[0].length;

        int dummyNode = row*col;
        init(dummyNode + 1);

        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col ; j++) {
                int curIndex = getIndex(i,j);
                if(grid[i][j] == '0' ){
                    union(curIndex,dummyNode);
                    continue;
                }
                if(grid[i][j] == '1'){
                    for (int k = 0; k < directions.length; k++) {
                        int newX =i + directions[k][0];
                        int newY =j+ directions[k][1];
                        if(newX < row && newY < col && grid[newX][newY] == '1' ){
                            union(curIndex,getIndex(newX,newY));
                        }
                    }
                }
            }
        }
        return count - 1;
    }

    private int getIndex(int x, int y){
        return x * col + y;
    }

}