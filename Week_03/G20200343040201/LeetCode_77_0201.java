package myself;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_77_0201 {

    List<List<Integer>> res = new ArrayList<>();
    int range = 0;
    int maxLevel = 0;

    public List<List<Integer>> combine(int n, int k) {
        range = n;
        maxLevel = k;
        recur(0, 0, new ArrayList<>());
        return res;
    }

    /**
     * @param level 递归的层次
     * @param preLevelNum 上一级添加的数字，用来减去一些递归的分支
     * @param tempRes 中间结果
     */
    private void recur(int level, int preLevelNum, List<Integer> tempRes) {
        // terminator
        if (level == maxLevel) {
            res.add(new ArrayList<>(tempRes));
            return;
        }
        /**
         * i为preLevelNum + 1，是因为后面放进去的，要比前面的数要大
         */
        for (int i = preLevelNum + 1; i <= range; i++) {
            tempRes.add(i);
            recur(level + 1, i, tempRes);
            tempRes.remove(tempRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_77_0201().combine(4, 3));
    }

}
