import java.util.*;

public class LeetCode_56_0201 {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) return new int[0][0];

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            List<int[]> list = map.getOrDefault(intervals[i][0], new ArrayList<int[]>());
            list.add(intervals[i]);
            map.put(intervals[i][0], list);
        }
        int[] headEl = new int[map.keySet().size()];
        int idx = 0;
        for (Integer val : map.keySet()) {
            headEl[idx++] = val;
        }
        Arrays.sort(headEl);

        Stack<int[]> resStack = new Stack<>();
        for (int value : headEl) {
            for (int[] b : map.get(value)) {
                if (resStack.size() == 0) {
                    resStack.push(b);
                    continue;
                }
                int[] a = resStack.peek();
                if (a[1] < b[0]) {
                    resStack.push(b);
                } else if (b[1] > a[1]) {
                    resStack.pop();
                    resStack.push(new int[]{a[0], b[1]});
                }
            }
        }
        int[][] res = new int[resStack.size()][];
        int i = 0;
        for (int[] item : resStack) {
            res[i++] = item;
        }
        return res;
    }
}
