class Solution {

    public int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++){
            res = (res << 1) + ((n>>i) & 1);
        }
        return res;
    }
}