package com.szp.leetcode.q601_650;

public class A647_palindromic_substrings {
    public int countSubstrings(String s) {
        if(null == s || s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        int len = s.length(),res = 0;
        for(int i = 0; i < len; i++){
            int left = i;
            int right = i;
            while(left>=0 && right < len && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                res++;
            }
            left = i;
            right = i+1;
            while(left>=0 && right < len && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                res++;
            }
        }
        return res;
    }
}
