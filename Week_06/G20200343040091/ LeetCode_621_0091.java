class Solution {

    public int leastInterval(char[] tasks, int n) {
      if (tasks.length <= 1 || n < 1) {
        return tasks.length;
      }
      int[] counts = new int[26];
      for (int i = 0; i < tasks.length; i++) {
        counts[tasks[i] - 'A']++;
      }
      Arrays.sort(counts);
      int maxCount = counts[25];
      int retCount = (maxCount - 1) * (n + 1) + 1;
      int i = 24;
      while (i >= 0 && counts[i] == maxCount) {
        retCount++;
        i--;
      }
      return Math.max(retCount, tasks.length);
    }

  }