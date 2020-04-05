class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        Set<String> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] + "," + o[1]);
        }

        // max Result
        int maxRes = 0;
        // Motion Direction
        int direction = 0;
        // Robot Location
        int x = 0, y = 0;

        for (int c : commands) {
            if (c == -1) {
                direction = direction == 3 ? 0 : direction + 1;
            } else if (c == -2) {
                direction = direction == 0 ? 3 : direction - 1;
            } else {
                while (c-- > 0 && !set.contains((x + dx[direction]) + "," + (y + dy[direction]))) {
                    x += dx[direction];
                    y += dy[direction];
                }
            }
            maxRes = Math.max(maxRes, x * x + y * y);
        }
        return maxRes;
    }
}
