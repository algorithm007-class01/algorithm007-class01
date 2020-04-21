class Solution {
    // BFS
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        Set<Integer> queue = new HashSet<>();
        queue.add(0);
        final HashSet<Integer> visited = new HashSet<>();
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            visited.addAll(queue);
            Set<Integer> next = new HashSet<>();
            for (int idx : queue) {
                for (int i = idx + 1; i <= nums[idx] + idx && i < nums.length; i++) {
                    if (i == nums.length - 1) {
                        return level;
                    }
                    if (!visited.contains(i)) {
                        next.add(i);
                    }
                }
            }
            queue = next;
        }
        return level;
    }
}