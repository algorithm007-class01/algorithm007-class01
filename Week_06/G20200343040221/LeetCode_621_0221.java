//给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务
//都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。 
//
// 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。 
//
// 你需要计算完成所有任务所需要的最短时间。 
//
// 
//
// 示例 ： 
//
// 输入：tasks = ["A","A","A","B","B","B"], n = 2
//输出：8
//解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
//     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 
//
// 
//
// 提示： 
//
// 
// 任务的总个数为 [1, 10000]。 
// n 的取值范围为 [0, 100]。 
// 
// Related Topics 贪心算法 队列 数组

package leetcode.editor.cn;

import java.util.*;

public class TaskScheduler_621 {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 桶
    // https://leetcode-cn.com/problems/task-scheduler/solution/ren-wu-diao-du-qi-by-leetcode/
    // https://leetcode-cn.com/problems/task-scheduler/solution/tong-si-xiang-jian-ji-gao-xiao-by-hzhu212/
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }

        Arrays.sort(map);

        int maxVal = map[25] - 1;
        int idleSlots = maxVal * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idleSlots -= Math.min(maxVal, map[i]);
        }

        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }

    // 优先队列
    public int leastInterval1(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                queue.add(map[i]);
            }
        }

        int time = 0;
        while (queue.size() > 0) {
            int count = Math.min(queue.size(), n + 1);
            List<Integer> temp = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                int remainTaskCount = queue.poll() - 1;
                if (remainTaskCount > 0) {
                    temp.add(remainTaskCount);
                }
            }

            time += temp.isEmpty() ? count : Math.max(count, n + 1);

            queue.addAll(temp);
        }
        return time;
    }

    // 排序
    public int leastInterval2(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }

        Arrays.sort(map);

        int time = 0;
        int interval = n + 1;
        while (true) {
            int intervalTaskCount = 0;
            for (int i = map.length - 1; i >= 0; i--) {
                if (intervalTaskCount >= interval || map[i] == 0) {
                    break;
                }
                intervalTaskCount++;
                map[i] -= 1;
                time += 1;
            }

            if (intervalTaskCount == 0) {
                break;
            }

            if (intervalTaskCount >= interval) {
                Arrays.sort(map);
            } else if (map[map.length - 1] > 0) {
                time += (interval - intervalTaskCount);
            }
        }

        return time;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
  