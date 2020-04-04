import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode_47_0147 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return result;
        }
        getResult(0, nums, null, result);
        return result;
    }

    public void getResult(int level, int[] nums, List<Integer> container, List<List<Integer>> result) {
        if (container == null) {
            container = new ArrayList<>();
        }
        if (nums.length == container.size() && !result.contains(container)) {
            result.add(new ArrayList<>(container));
            return;
        }
        //
        List<Integer> t = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (Integer i : container) {
            t.remove(t.lastIndexOf(i));
        }
        for (int i = 0; i < t.size(); i++) {
            container.add(t.get(i));
            getResult(level + 1, nums, container, result);
            container.remove(container.size() - 1);
        }
        //
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2};
        System.out.println(new LeetCode_47_0147().permuteUnique(nums));
    }
}
