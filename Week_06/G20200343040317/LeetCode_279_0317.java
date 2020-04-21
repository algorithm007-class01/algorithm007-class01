class Solution {
    public int numSquares(int n) {
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        final Set<Integer> visited = new HashSet<>();
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int j = 1; j * j <= node; j++) {
                    final int next = node - j * j;
                    if (next == 0) {
                        return level;
                    }
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }

        }
        return 0;
    }
}