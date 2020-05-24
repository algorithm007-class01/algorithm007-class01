//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 
//的朋友。所谓的朋友圈，是指所有朋友的集合。 
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
//必须输出所有学生中的已知的朋友圈总数。 
//
// 示例 1: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出: 2 
//说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回2。
// 
//
// 示例 2: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出: 1
//说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
// 
//
// 注意： 
//
// 
// N 在[1,200]的范围内。 
// 对于所有学生，有M[i][i] = 1。 
// 如果有M[i][j] = 1，则有M[j][i] = 1。 
// 
// Related Topics 深度优先搜索 并查集

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class FriendCircles_547 {

//    public static void main(String[] args) {
//        Solution solution = new FriendCircles_547().new Solution();
//        System.out.println(solution);
//    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 基于并查集
    public int findCircleNum(int[][] M) {
        int len = M.length;
        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getCount();
    }

    // 基于BFS
    public int findCircleNum1(int[][] M) {
        int r = 0;
        boolean[] visited = new boolean[M.length];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i]) {
                continue;
            }

            r += 1;
            visited[i] = true;

            queue.clear();
            queue.add(i);

            while (!queue.isEmpty()) {
                Integer index = queue.poll();
                for (int j = 0; j < M.length; j++) {
                    if (M[index][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
        }

        return r;
    }

    // 基于DFS
    public int findCircleNum2(int[][] M) {
        int r = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                r += 1;
            }
        }
        return r;
    }
    // 基于DFS将i的朋友和i的朋友的朋友...都修改为visited
    private void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
}

class UnionFind {

    /**
     * 集合的个数
     */
    private int count = 0;
    private int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            // 初始化时，元素与元素之间尚未建立关系
            // 每个元素都在一个独立的集合中
            // 所以每个元素的父都是自己
            parent[i] = i;
        }
    }

    /**
     * 查找p的根，查找过程中，顺便优化p的根的查找路径
     *
     * @param p
     * @return
     */
    public int find(int p) {
        while (p != parent[p]) {
            // 如果p的父不是自己，那么将p的父修改为p的父的父。
            parent[p] = parent[parent[p]];
            // 向上查找，将p修改为p的父
            p = parent[p];
        }
        return p;
    }

    /**
     * 合并两个集合
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        // 一个集合的所有子元素具有同一个根元素
        // 将两个集合的根元素修改为同一个元素，这两个集合就被合并了
        parent[rootQ] = rootP;

        count--;
    }

    public int getCount() {
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
  