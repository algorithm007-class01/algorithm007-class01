import java.util.ArrayList;
import java.util.List;

public class LeetCode_77_0147 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k) {
            return result;
        }
        getResult(n, k, 0, 0, null, result);
        return result;
    }

    public void getResult(int n, int k, int level, int cur, List<Integer> levelContainer, List<List<Integer>> result) {
        if (level == k) {
            result.add(new ArrayList<>(levelContainer));
            return;
        }
        if (levelContainer == null) {
            levelContainer = new ArrayList<>();
        }

        for (int i = 1 + cur; i <= n; i++) {
            levelContainer.add(i);
            getResult(n, k, level + 1, i, levelContainer, result);
            levelContainer.remove(levelContainer.size() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_77_0147().combine(4, 2));
    }
}
