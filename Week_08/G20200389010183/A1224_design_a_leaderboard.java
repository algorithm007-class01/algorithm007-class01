package com.szp.leetcode.q1201_1250;

import java.util.Iterator;
import java.util.Objects;
import java.util.PriorityQueue;

public class A1224_design_a_leaderboard {
    class Leaderboard {
        class PlayerScore {
            public Integer id;
            public Integer score;
            public PlayerScore(int id, int score){
                this.id = id;
                this.score = score;
            }
            public PlayerScore(int id){
                this.id = id;
            }
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                PlayerScore playerScore = (PlayerScore) o;
                return id.equals(playerScore.id);
            }

            @Override
            public int hashCode() {
                return Objects.hash(id);
            }
        }

        PriorityQueue<PlayerScore> board = new PriorityQueue<>((item1, item2)-> item2.score-item1.score);

        public Leaderboard() {

        }

        public void addScore(int playerId, int score) {
            PlayerScore playerScore = new PlayerScore(playerId, score);
            if(board.contains(playerScore)){
                PlayerScore old = null;
                Object[] playerScores = board.toArray();
                for (int i = 0; i < playerScores.length; i++)
                    if (playerScore.equals(playerScores[i]))
                        old = (PlayerScore)playerScores[i];
                playerScore.score += old.score;
                board.remove(old);
            }
            board.add(playerScore);
        }

        public int top(int K) {
            PlayerScore[] tmp = new PlayerScore[K];
            int sum = 0;
            for (int i = 0; i < K; i++) {
                PlayerScore playerScore = board.poll();
//                System.out.println(playerScore.score);
                sum += playerScore.score;
                tmp[i] = playerScore;
            }
            for (int i = 0; i < K; i++) {
                board.add(tmp[i]);
            }
            return sum;
        }

        public void reset(int playerId) {
            PlayerScore playerScore = new PlayerScore(playerId);
            board.remove(playerScore);
        }
    }

    public static void main(String[] args) {

//        Leaderboard leaderboard = new A1224_design_a_leaderboard().new Leaderboard();
//        leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
//        leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
//        leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
//        leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
//        leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
//        System.out.println(leaderboard.top(1));           // returns 73;
//        leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
//        leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
//        leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
//        System.out.println(leaderboard.top(3));           // returns 141 = 51 + 51 + 39;
//        System.out.println();
//["Leaderboard","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","top","top","top","reset","reset"]
//[[],[1,82],[2,84],[3,47],[4,86],[5,92],[6,74],[7,34],[8,67],[9,76],[10,73],[4],[4],[8],[1],[2]]
//        Leaderboard leaderboard2 = new A1224_design_a_leaderboard().new Leaderboard();
//        leaderboard2.addScore(1,82);   // leaderboard = [[1,73]];
//        leaderboard2.addScore(2,84);   // leaderboard = [[1,73],[2,56]];
//        leaderboard2.addScore(3,47);   // leaderboard = [[1,73],[2,56],[3,39]];
//        leaderboard2.addScore(4,86);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
//        leaderboard2.addScore(5,92);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
//        leaderboard2.addScore(6,74);   // leaderboard = [[1,73]];
//        leaderboard2.addScore(7,34);   // leaderboard = [[1,73],[2,56]];
//        leaderboard2.addScore(8,67);   // leaderboard = [[1,73],[2,56],[3,39]];
//        leaderboard2.addScore(9,76);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
//        leaderboard2.addScore(10,73);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
//        System.out.println(leaderboard2.top(4));           // returns 73;
//        System.out.println(leaderboard2.top(4));           // returns 73;
//        System.out.println(leaderboard2.top(8));           // returns 73;
//        leaderboard2.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
//        leaderboard2.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];

//  ["Leaderboard","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore",
//  "top","reset","reset","addScore","addScore","top","reset","reset","addScore","reset"]
//  [[],[1,13],[2,93],[3,84],[4,6],[5,89],[6,31],[7,7],[8,1],[9,98],[10,42],
//  [5],[1],[2],[3,76],[4,68],[1],[3],[4],[2,70],[2]]
        Leaderboard leaderboard3 = new A1224_design_a_leaderboard().new Leaderboard();
        leaderboard3.addScore(1,13);   // leaderboard = [[1,73]];
        leaderboard3.addScore(2,93);   // leaderboard = [[1,73],[2,56]];
        leaderboard3.addScore(3,84);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard3.addScore(4,6);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard3.addScore(5,89);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        leaderboard3.addScore(6,31);   // leaderboard = [[1,73]];
        leaderboard3.addScore(7,7);   // leaderboard = [[1,73],[2,56]];
        leaderboard3.addScore(8,1);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard3.addScore(9,98);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard3.addScore(10,42);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        System.out.println(leaderboard3.top(5));           // returns 73;
        leaderboard3.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard3.reset(2);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard3.addScore(3,76);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard3.addScore(4,68);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        System.out.println(leaderboard3.top(1));           // returns 73;
        leaderboard3.reset(3);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard3.reset(4);         // leaderboard = [[3,39],[4,51],[5,4]];
        leaderboard3.addScore(2,70);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard3.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];

    }
}
