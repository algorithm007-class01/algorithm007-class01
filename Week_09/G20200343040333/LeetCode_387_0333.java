package app;

public class LeetCode_387_0333 {
    public int firstUniqChar(String s) {
        
        if(null==s||s.length()==0) return -1;
        int[] charCnt=new int[128]; 
        char[] cArray=s.toCharArray();
        for(char c:cArray){
            charCnt[c]++;
        }
        int pos=0;
        boolean hasSingleWord=false;
        for(char c:cArray){
            if(charCnt[c]==1){
                hasSingleWord=true;
                break;
            }
            ++pos;
        }
        return hasSingleWord?pos:-1;
    }
}