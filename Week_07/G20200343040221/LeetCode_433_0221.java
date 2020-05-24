//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。 
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意: 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 所有的目标基因序列必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 示例 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
// 
//
// 示例 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
//

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation_433 {
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final char[] LETTERS = new char[] { 'A', 'C', 'G', 'T' };

    // 双向BFS
    public int minMutation(String start, String end, String[] bank) {
        Set<String> targets = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            targets.add(bank[i]);
        }
        if (!targets.contains(end)) {
            return -1;
        }

        Set<String> beginSet = new HashSet<>();
        beginSet.add(start);

        Set<String> endSet = new HashSet<>();
        endSet.add(end);

        Set<String> visited = new HashSet<>();
        visited.add(start);
        visited.add(end);

        int step = 0;
        while (!beginSet.isEmpty() || !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size() || beginSet.size() == 0) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevelSet = new HashSet<>();
            for (String target : beginSet) {
                char[] chars = target.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char oldChar = chars[j];
                    for (char newChar : LETTERS) {
                        if (oldChar != newChar) {
                            chars[j] = newChar;

                            String newTarget = String.valueOf(chars);
                            if (endSet.contains(newTarget)) {
                                return step + 1;
                            }

                            if (targets.contains(newTarget) && !visited.contains(newTarget)) {
                                nextLevelSet.add(newTarget);
                                visited.add(newTarget);
                            }
                        }
                    }
                    chars[j] = oldChar;
                }
            }

            beginSet = nextLevelSet;
            step += 1;
        }

        return -1;
    }

    // BFS
    public int minMutation1(String start, String end, String[] bank) {
        Set<String> targets = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            targets.add(bank[i]);
        }
        if (!targets.contains(end)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        Set<String> visited = new HashSet<>();
        visited.add(start);

        int step = -1;
        while (!queue.isEmpty()) {
            step += 1;
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String target = queue.poll();
                if (target.equals(end)) {
                    return step;
                }

                char[] chars = target.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char oldChar = chars[j];
                    for (char newChar : LETTERS) {
                        if (oldChar != newChar) {
                            chars[j] = newChar;

                            String newTarget = String.valueOf(chars);
                            if (targets.contains(newTarget) && !visited.contains(newTarget)) {
                                queue.add(newTarget);
                                visited.add(newTarget);
                            }
                        }
                    }
                    chars[j] = oldChar;
                }
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
  