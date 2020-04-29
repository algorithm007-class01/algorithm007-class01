package l01.n433;//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
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


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution433 {
    int res = -1;

    /**
     * DFS
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(bank));
        helper(start, end, 0, set);
        return res;
    }

    private void helper(String start, String end, int mod, Set<String> bank) {
        if (start.equals(end)) {
            if (res == -1 || res > mod) {
                res = mod;
                return;
            }
            return;
        }
        if (mod >= bank.size()) {
            return;
        }
        char[] g = {'A', 'T', 'C', 'G'};
        for (int i = 0; i < start.length(); i++) {
            char[] array = start.toCharArray();
            for (char c : g) {
                if (array[i] == c) {
                    continue;
                }
                array[i] = c;

                if (!bank.contains(String.valueOf(array))) {
                    continue;
                }
                helper(String.valueOf(array), end, mod + 1, bank);
            }
        }

    }

    /**
     * BFS
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation1(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (size-- > 0) {
                String s = queue.poll();
                for (String b : bank) {
                    if (visited.contains(b)) {
                        continue;
                    }
                    if (!canConvert(s, b)) {
                        continue;
                    }
                    if (b.equals(end)) {
                        return count;
                    }
                    queue.add(b);
                    visited.add(b);
                }
            }
        }
        return -1;
    }

    /**
     * 双端BFS
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation2(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        Queue<String> queue1 = new LinkedList<>();
        Set<String> visited1 = new HashSet<>();
        visited1.add(start);
        queue1.add(start);
        int count1 = 0;
        Queue<String> queue2 = new LinkedList<>();
        Set<String> visited2 = new HashSet<>();
        queue2.add(end);
        int count2 = 0;


        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count1++;
            int size1 = queue1.size();
            while (size1-- > 0) {
                String s = queue1.poll();
                for (String b : bank) {
                    if (visited1.contains(b)) {
                        continue;
                    }
                    if (!canConvert(s, b)) {
                        continue;
                    }
                    if (visited2.contains(b)) {
                        return count1 + count2;
                    }
                    queue1.add(b);
                    visited1.add(b);
                }

            }
            count2++;
            int size2 = queue2.size();
            while (size2-- > 0) {
                String s = queue2.poll();
                for (String b : bank) {
                    if (visited2.contains(b)) {
                        continue;
                    }
                    if (!canConvert(s, b)) {
                        continue;
                    }
                    if (visited1.contains(b)) {
                        return count1 + count2;
                    }
                    queue2.add(b);
                    visited2.add(b);
                }
            }

        }


        return -1;
    }

    /**
     * 优化双端BFS，每次从较少的队列搜索
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation3(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        Queue<String> queue1 = new LinkedList<>();
        Set<String> visited1 = new HashSet<>();
        visited1.add(start);
        queue1.add(start);
        int count = 0;
        Queue<String> queue2 = new LinkedList<>();
        Set<String> visited2 = new HashSet<>();
        queue2.add(end);


        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.size() > queue2.size()) {
                Queue<String> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
                Set<String> temps = visited1;
                visited1 = visited2;
                visited2 = temps;
            }
            count++;
            int size = queue1.size();
            while (size-- > 0) {
                String s = queue1.poll();
                for (String b : bank) {
                    if (visited1.contains(b)) {
                        continue;
                    }
                    if (!canConvert(s, b)) {
                        continue;
                    }
                    if (visited2.contains(b)) {
                        return count;
                    }
                    queue1.add(b);
                    visited1.add(b);
                }
            }
        }


        return -1;
    }

    private boolean canConvert(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        int res = new Solution433().minMutation("AACCGGTT", "AAACGGTA", bank);

        System.out.println(res);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
