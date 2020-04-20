package DailyPractice;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_77_0215 {
    List<List<Integer>> output = new LinkedList<>();
    int n,k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backTrack(1,new LinkedList<Integer>());
        return output;
    }

    private void backTrack(int start, LinkedList<Integer> curr) {
        if (curr.size()==k){
          output.add(new LinkedList(curr));
          return;
        }
        for (int i=start;i<n+1;++i){
            curr.add(i);
            backTrack(i+1, curr);
            curr.removeLast();
        }
    }
}
