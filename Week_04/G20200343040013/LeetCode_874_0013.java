/**
 * 模拟机器人行走
 */
public int robotSim(int[] commands, int[][] obstacles) {
    int x = 0;
    int y = 0;

    int d = 0;
    int ant = 0;

    Set<String> blockStr = new HashSet<String>();

    for(int[] obstacle : obstacles) {
        blockStr.put(obstacle[0]  + "," + obstacle[1]);
    }
    int[][] dir = {{1,0}, {0,1}, {0, -1}, {-1, 0}}
    for(int command : commands) {
        if (command == -1) {
           d = (d + 1) % 4;
        } else if (command == -2) {
            d = (d + 3) % 4;
        } else if (command > 0) {
            for (int i = 1; i <= command; i++) {
                int newX = d + dir[d][0];
                int newY = d + dir[d][1];
                if(blockStr.contains(newX + "," + newY)) {
                    break;
                } else {
                    ant = Math.max(ant, newX * newX + newY * newY);
                }
            }
        }
    }
    return ant;
}