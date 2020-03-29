package app;
public class LeetCode_242_0333{
    public boolean isAnagram(String s, String t) {
        if(null==s||null==t||s.length()!=t.length()) return false;
        if(s.length()==0) return true;
        int count[]=new int[26];
        char[] sc=s.toCharArray();
        char[] tc=t.toCharArray();
        for(int i=0;i<sc.length;i++){
            ++count[sc[i]-'a'];
            --count[tc[i]-'a'];
        }
        for(int i=0;i<count.length;i++){
            if(count[i]!=0) return false;
        }
        return true;
    }
}