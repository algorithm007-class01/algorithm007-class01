//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


package com.Simba.algorithm007class01.leetcode.editor.cn.leetcode.editor.cn;

import java.util.LinkedList;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
      //  char[][] a = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        char[][] a=new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int c = solution.numIslands(a);
        System.out.printf(" " + c);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //BFS
        private int rows;
        private int cols;
        public int numIslands(char[][] grid){
            int[][] directions={{-1,0},{0,-1},{1,0},{0,1}};
            rows=grid.length;
            if(rows==0)return 0;
            cols=grid[0].length;
            boolean[][] marked=new boolean[rows][cols];
            int count=0;
            for(int i=0;i<rows;i++){
                for(int j=0; j<cols; j++){
                    //如果是岛屿中的一个点，并且没有被访问过
                    //从坐标（i，j）的点开始进行广度优先遍历
                    if(! marked[i][j] && grid[i][j]=='1'){
                        count++;
                        LinkedList<Integer> queue=new LinkedList<>();
                        //小技巧：把坐标转换为一个数字
                        //否则 得用一个数组存，
                        queue.addLast(i*cols +j);
                        //注意：这里要标记上已经访问过
                        marked[i][j]=true;
                        while (!queue.isEmpty()){
                            int cur=queue.removeFirst();
                            int curX=cur/cols;
                            int curY=cur%cols;
                            //得到四个方向的坐标
                            for(int k=0;k<4;k++){
                                int newX=curX+directions[k][0];
                                int newY=curY+directions[k][1];
                                //如果不越界、没有被访问过、并且还是陆地，我就继续放入队列，放入队列的同时，要记得标记已经访问过
                                if(inArea(newX,newY) && grid[newX][newY] == '1' && !marked[newX][newY]){
                                    queue.addLast(newX * cols+ newY);
                                    //在放入队列以后，要马上标记成已经访问过；而不是在出队的时候再标记
                                    //如果是出队的时候标记，会造成许多重复的结点进入队伍，造成重复操作
                                    marked[newX][newY]=true;
                                }
                            }
                        }
                    }
                }
            }
            return count;
        }

        private boolean inArea(int x, int y) {
            return x>=0 && x<rows && y>=0 && y<cols;
        }
    }









//leetcode submit region end(Prohibit modification and deletion)

}