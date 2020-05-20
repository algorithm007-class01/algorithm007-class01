package cxl.study.leetcode;

/**
 * 541. 反转字符串 II
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class LeetCode_541_ReverseString2 {

    public String reverseStr(String s, int k) {
        int i=0;
        char[] ch=s.toCharArray();
        while(i<ch.length){
            if (i%(2*k)==0){
                if (i+k-1<ch.length) {
                    for (int j = 0; j < k / 2; j++) {
                        char mid = ch[i + j];
                        ch[i + j]=ch[i+k-1-j];
                        ch[i+k-1-j]=mid;
                    }
                }
                else{
                    for (int j = 0; j < (ch.length-i)/2; j++) {
                        char mid = ch[i + j];
                        ch[i + j]=ch[ch.length-1-j];
                        ch[ch.length-1-j]=mid;
                    }
                }
            }
            i+=k;
        }
        return new String(ch);
    }

}
