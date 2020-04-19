import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class LeetCode_200_0147 {

    public int numIslands(char[][] grid) {
        int count = 0;
        Map<MyPair, String> visited = new ConcurrentHashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    MyPair p = new MyPair(i, j);
                    if (!visited.containsKey(p)) {
                        count++;
                        dfs(grid, visited, i, j);
                    }
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, Map<MyPair, String> visited, int x, int y) {
        MyPair p = new MyPair(x, y);
        if (visited.containsKey(p)) {
            return;
        }
        visited.put(p, "");
        if ((x + 1) < grid.length && grid[x + 1][y] == '1') {
            MyPair p1 = new MyPair(x + 1, y);
            if (!visited.containsKey(p1)) {
                dfs(grid, visited, x + 1, y);
            }
        }
        if ((x - 1) >= 0 && grid[x - 1][y] == '1') {
            MyPair p1 = new MyPair(x - 1, y);
            if (!visited.containsKey(p1)) {
                dfs(grid, visited, x - 1, y);
            }
        }
        if ((y + 1) < grid[0].length && grid[x][y + 1] == '1') {
            MyPair p1 = new MyPair(x, y + 1);
            if (!visited.containsKey(p1)) {
                dfs(grid, visited, x, y + 1);
            }
        }
        if ((y - 1) >= 0 && grid[x][y - 1] == '1') {
            MyPair p1 = new MyPair(x, y - 1);
            if (!visited.containsKey(p1)) {
                dfs(grid, visited, x, y - 1);
            }
        }
    }

    class MyPair {
        int x;
        int y;

        public MyPair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MyPair)) return false;
            MyPair myPair = (MyPair) o;
            return x == myPair.x &&
                    y == myPair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
//        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};

        System.out.println(new LeetCode_200_0147().numIslands(grid));
//        System.out.println(grid[0].length);
    }
}
