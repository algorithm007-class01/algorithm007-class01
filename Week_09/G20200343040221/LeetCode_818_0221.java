//你的赛车起始停留在位置 0，速度为 +1，正行驶在一个无限长的数轴上。（车也可以向负数方向行驶。） 
//
// 你的车会根据一系列由 A（加速）和 R（倒车）组成的指令进行自动驾驶 。 
//
// 当车得到指令 "A" 时, 将会做出以下操作： position += speed, speed *= 2。 
//
// 当车得到指令 "R" 时, 将会做出以下操作：如果当前速度是正数，则将车速调整为 speed = -1 ；否则将车速调整为 speed = 1。 (当前所
//处位置不变。) 
//
// 例如，当得到一系列指令 "AAR" 后, 你的车将会走过位置 0->1->3->3，并且速度变化为 1->2->4->-1。 
//
// 现在给定一个目标位置，请给出能够到达目标位置的最短指令列表的长度。 
//
// 示例 1:
//输入: 
//target = 3
//输出: 2
//解释: 
//最短指令列表为 "AA"
//位置变化为 0->1->3
// 
//
// 示例 2:
//输入: 
//target = 6
//输出: 5
//解释: 
//最短指令列表为 "AAARA"
//位置变化为 0->1->3->7->7->6
// 
//
// 说明: 
//
// 
// 1 <= target（目标位置） <= 10000。 
// 
// Related Topics 堆 动态规划

package leetcode.editor.cn;

import java.util.*;

// 818. 赛车
public class RaceCar_818 {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 暴力BFS
    public int racecar(int target) {
        State initState = new State(0, 1);
        Queue<State> queue = new LinkedList<>();
        queue.add(initState);

        Set<State> visited = new HashSet<>(target < 64 ? 64 : target);
        visited.add(initState);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State state = queue.poll();
                State[] nextStates = state.move();
                if (nextStates[0].getPosition() == target) {
                    return count + 1;
                }

                // 剪枝
                if (nextStates[0].getPosition() < 0) {
                    continue;
                }

                // 去重
                if (!visited.contains(nextStates[0])) {
                    queue.add(nextStates[0]);
                    visited.add(nextStates[0]);
                }
                if (!visited.contains(nextStates[1])) {
                    queue.add(nextStates[1]);
                    visited.add(nextStates[1]);
                }
            }

            count += 1;
        }

        return -1;
    }
}
class State {

    int position;
    int speed;

    public State(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }

    public int getPosition() {
        return position;
    }

    public State[] move() {
        return new State[] {
            new State(position + speed, speed * 2),
            new State(position, speed > 0 ? -1 : 1),
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        State that = (State) o;
        return position == that.position && speed == that.speed;
    }

    @Override
    public int hashCode() {
        return position + speed * speed * 500000;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
