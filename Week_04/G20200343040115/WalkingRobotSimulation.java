//机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令： 
//
// 
// -2：向左转 90 度 
// -1：向右转 90 度 
// 1 <= x <= 9：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物。 
//
// 第 i 个障碍物位于网格点 (obstacles[i][0], obstacles[i][1]) 
//
// 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。 
//
// 返回从原点到机器人的最大欧式距离的平方。 
//
// 
//
// 示例 1： 
//
// 输入: commands = [4,-1,3], obstacles = []
//输出: 25
//解释: 机器人将会到达 (3, 4)
// 
//
// 示例 2： 
//
// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出: 65
//解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
// 
//
// 
//
// 提示： 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// 答案保证小于 2 ^ 31 
// 
// Related Topics 贪心算法

  
  package com.Simba.algorithm007class01.leetcode.editor.cn.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
//思路，按照题意判断方向然后行走，其中方向有{北，东，南，西}，初始化北方。
//        -2： 向左90度对应的当前方向往左一个即(dir-1)%4，但是程序-1%4并不能得出3而是-1，所以正确的表示是(dir+3)%4。
//        -1： 向右90度，对应的是方向转向下一个方向，即(dir+1)%4，通过取模来使得在四个方向来回循环转向。
//        x： 正数为前进单位，最简单的方式可以一次一格前进，然后判断是否为障碍物，有则停止，没有则更新当前位置。
//
//        判断障碍物：将障碍物的x和y坐标组合成一个字符串用set保存障碍物，查找的时候只要判断当前坐标组成的串是否在set里即可。

public class WalkingRobotSimulation{
      public static void main(String[] args) {
           Solution solution = new WalkingRobotSimulation().new Solution();
           int[] commands={4,-1,4,-2,4};
           int[][]obstacles={{2,4}};
           int a=solution.robotSim(commands,obstacles);
          System.out.printf(" "+a);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
       Set<String> set=new HashSet<>();
       for(int[] ob:obstacles){
           set.add(ob[0]+" "+ob[1]);
       }

       int[][]dirctions={{0,1},{1,0},{0,-1},{-1,0}};
       int d=0;
       int x=0;
       int y=0;
       int res=0;
       for(int c:commands){
           if(c==-1) d=(d+1)%4;
           else if(c==-2) d=(d+3)%4;
           else {
               while (c-->0 && !set.contains((x+dirctions[d][0])+" "+(y+dirctions[d][1]))){
                   x+=dirctions[d][0];
                   y+=dirctions[d][1];

               }

           }
           res=Math.max(res,x*x+y*y);
       }
       return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

  }