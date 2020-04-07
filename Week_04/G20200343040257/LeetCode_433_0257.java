package cxl.study.leetcode;


import java.util.*;

/**
 * 433. 最小基因变化
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */
public class LeetCode_433_0257 {

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        Set<String> bankSet = new HashSet<>();
        Collections.addAll(bankSet, bank);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        char[] acgt = {'A', 'T', 'C', 'G'};
        int times = 0;

        while (!queue.isEmpty()) {

            int currentLevelSize = queue.size();

            while (currentLevelSize-- > 0) {

                String current = queue.poll();
                if (current.equals(end)) {
                    return times;
                }
                char[] currentChars = current.toCharArray();
                for (int i = 0; i < currentChars.length; i++) {
                    char temp = currentChars[i];
                    for (char c : acgt) {
                        currentChars[i] = c;
                        String changedStr = new String(currentChars);
                        if (!visited.contains(changedStr) && bankSet.contains(changedStr)) {
                            visited.add(changedStr);
                            queue.offer(changedStr);
                        }
                    }
                    currentChars[i] = temp;
                }
            }
            times++;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode_433_MinimumGeneticMutation minimumGeneticMutation = new LeetCode_433_MinimumGeneticMutation();
        System.out.println(minimumGeneticMutation.minMutation("AACCGGTT", "AACCGCTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
    }


}
