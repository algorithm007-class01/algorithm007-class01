import java.util.HashMap;
import java.util.Map;

/**
 * 做这道题的时候，受到LeetCode 55,跳跃游戏解题思想的启发。
 * 用的是记忆化搜索。
 * 一开始写的是暴力搜索（回溯法），然后演变一下，
 * 记录已被否定的递归树节点，避免重复搜索，做剪枝。
 *
 * 做题的时候，脑海里有个递归树模型就差不多了。
 */
public class LeetCode_403_0201 {

    /**
     * stonesMap 某块石头，以及它之前的步数
     *
     * Map< A, Map < B, C>>
     * A表示石头位置，B表示上次跳跃走的步数，C表示这个节点往下走是否能到达
     */
    Map<Integer, Map<Integer, Boolean>> stonesMap = new HashMap<>();
    int lastStone;

    public boolean canCross(int[] stones) {
        for (int item : stones) {
            stonesMap.put(item, new HashMap<>());
        }
        lastStone = stones[stones.length - 1];
        return backTrack(0, 0);
    }

    private boolean backTrack(int pos, int preStep) {
        if (!stonesMap.containsKey(pos) || !stonesMap.get(pos).getOrDefault(preStep, true)) return false;

        //能到最后一块石头
        if (pos == lastStone) return true;

        // 分别以 k - 1，k, k + 1 步往下搜索
        for (int i = preStep - 1; i <= preStep + 1; i++) {
            if (i > 0 && backTrack(pos + i, i))
                return true;
        }

        /**
         * 如果上面不能得出true返回，
         * 那么表示pos这个位置的石头，以及配合这上次跳跃步数为preStep，是到不了对岸的
          */
        stonesMap.get(pos).put(preStep, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_403_0201().canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }

}
