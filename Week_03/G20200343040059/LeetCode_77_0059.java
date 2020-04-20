import java.util.ArrayList;
import java.util.List;

public class LeetCode_77_0059 {

    private static List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();

        if (k == 0) {
            return res;
        }

        combination(1, n, k, new ArrayList<>());
        return res;
    }

    public static void combination(int start, int n, int k, ArrayList<Integer> temp) {

        // 满足条件后返回
        if (temp.size() >= k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // 遍历所有数
        for (int i = start; i <= n; i++) {
            // 数字存起来
            temp.add(i);
            // 下一个递归
            combination(i + 1, n, k, temp);
            // 本次递归结束后把数去掉
            temp.remove(temp.size() - 1);
        }
    }
}
