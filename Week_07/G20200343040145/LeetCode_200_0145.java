import java.util.Arrays;

public class LeetCode_200_0145 {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int x = grid.length;
        int y = grid[0].length;

        int[] nums = new int[x * y];
        Arrays.fill(nums, -1);

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(grid[i][j] == '1') {
                    grid[i][j] = '0';

                    //判断下侧是否有陆地
                    if(i < (x - 1) && grid[i + 1][j] == '1') {
                        union(nums, i * y + j, (i + 1) * y + j);
                    }

                    //判断右侧是否有陆地
                    if(j < (y - 1) && grid[i][j + 1] == '1') {
                        union(nums, i * y + j, i * y + j + 1);
                    }
                } else {
                    nums[i * y + j] = -2;
                }
            }
        }

        int count = 0;
        for(int num : nums) {
            if(num == -1) count++;
        }

        return count;
    }

    public int find(int[] parents, int i) {
        if(parents[i] == -1) {
            return i;
        }

        return find(parents, parents[i]);
    }

    public void union(int[] parents, int x, int y) {
        int xset = find(parents, x);
        int yset = find(parents, y);
        if(xset != yset) {
            parents[xset] = yset;
        }
    }
}
