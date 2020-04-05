package DailyPractice;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LeetCode_49_0215 {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        long [] uglyNums = new long[]{2,3,5};
        for (long i:uglyNums){
            pq.offer(i);
            set.add(i);
        }
        long num = 1;
        for (int i=1;i<n;i++){
             num  = pq.poll();
            for (int j=0;j<3;j++){
                if (!pq.contains(num*uglyNums[j])){
                    pq.offer(num*uglyNums[j]);
                    set.add(num*uglyNums[j]);
                }
            }
        }
        return (int) num;
    }

    public int nthUglyNumber2(int n) {
        int [] res = new int [n];
        res[0]=1;
        int p2=0,p3=0,p5=0;
        for (int i=1;i<n;i++){
            res[i]=Math.min(res[p2]*2,Math.min(res[p3]*3,res[p5]*5));
            if (res[i]==res[p2]*2) {
                p2++;
            }
            if (res[i]==res[p3]*3) {
                p3++;
            }
            if (res[i]==res[p5]*5) {
                p5++;
            }
        }
        return res[n-1];
    }

}
