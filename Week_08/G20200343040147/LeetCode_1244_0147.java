import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode_1244_0147 {

    class Leaderboard {

        private Map<Integer,Integer> map;

        private PriorityQueue<Integer> queue;

        public Leaderboard() {
            map = new HashMap<>();
            queue = new PriorityQueue<>((y,x)->map.get(x).compareTo(map.get(y)));
        }

        public void addScore(int playerId, int score) {
            if (map.containsKey(playerId)){
                map.put(playerId,map.get(playerId) + score);
                queue.remove(playerId);
            } else{
                map.put(playerId,score);
            }
            queue.add(playerId);
        }

        public int top(int K) {
            Integer[] pids = new Integer[K];
            int res = 0;
            for (int i = 0; i < K; i++){
                int pid = queue.poll();
                pids[i] = pid;
                res += map.get(pid);
            }
            for (Integer i:pids){
                queue.add(i);
            }
            return res;
        }

        public void reset(int playerId) {
            map.put(playerId,0);
            queue.remove(playerId);
            queue.add(playerId);
        }
    }
}
