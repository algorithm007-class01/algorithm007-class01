import java.util.*;

public class LeetCode_51_0201 {

    int N;
    List<List<String>> res = new ArrayList<>();
    Set<Integer> column = new HashSet<>();
    int[][] square;

    public List<List<String>> solveNQueens(int n) {
        N = n;
        square = new int[n+1][n+1];
        dfs(1, new LinkedList<>());
        return res;
    }

    private void dfs(int level, LinkedList<Integer> tempRes) {
        if (level == N + 1) {
            res.add(convert2Res(tempRes));
        }
        for (int i = 1; i <= N; i++) {
            if (column.contains(i) || square[level][i] > 0) {
                continue;
            }
            tempRes.add(i);
            column.add(i);
            int r = level + 1, c = i - 1;
            while (r <=N && c >= 1) {
                square[r++][c--]++;
            }
            r = level + 1; c = i + 1;
            while (r <= N && c <= N) {
                square[r++][c++]++;
            }
            // drill down
            dfs(level + 1, tempRes);
            // reverse state
            tempRes.removeLast();
            column.remove(i);
            r = level + 1; c = i - 1;
            while (r <=N && c >= 1) {
                square[r++][c--]--;
            }
            r = level + 1; c = i + 1;
            while (r <= N && c <= N) {
                square[r++][c++]--;
            }
        }
    }

    private List<String> convert2Res(List<Integer> tempRes) {
        List<String> res = new ArrayList<>();
        for (Integer item : tempRes) {
            StringBuilder temp = new StringBuilder();
            int count = item - 1;
            while (count-- > 0) temp.append(".");
            temp.append("Q");
            count = N - item;
            while (count-- > 0) temp.append(".");
            res.add(temp.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_51_0201().solveNQueens(6));
    }

}
