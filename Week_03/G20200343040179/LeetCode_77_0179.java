package Week_03.G20200343040179;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mufan
 * @date 2020/3/29
 */
public class LeetCode_77_0179 {
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        findConditions(n, k, 1, new ArrayList<>());
        return res;
    }

    private static void findConditions(int n, int k, int begin, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        //k-list.size包含了元素的本身,所以需要+1
        for (int i = begin; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            findConditions(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
