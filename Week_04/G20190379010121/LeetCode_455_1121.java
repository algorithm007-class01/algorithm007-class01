class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int glen =  g.length;
        int slen = s.length;
        int i = 0,j =0;
        for(;i < glen && j < slen; ){
            if(g[i] <= s[j]){
                j ++;
                i ++;
            }else{
                j ++;
            }
        }
        return i;
    }
}