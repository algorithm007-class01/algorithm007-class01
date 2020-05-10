class Solution {

    // 解法1:循环32次，判断每1位情况
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0;i < 32;i++){
            if((n >> i) & 1 == 1){
                count++;
            }
        }
        return count;
    }

    // 解法2:消除最低位的1
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n &= n-1;
        }
        return count;
    }
}