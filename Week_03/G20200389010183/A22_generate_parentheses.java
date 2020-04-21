package com.szp.leetcode.q1_50;

import java.util.ArrayList;
import java.util.List;

public class A22_generate_parentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if(n == 0)
                return res;
            if(n == 1){
                res.add("()");
                return res;
            }
            List<List<String>> result = new ArrayList<>();
            List<String> r0 = new ArrayList<>();
            List<String> r1 = new ArrayList<>();
            r0.add("");
            r1.add("()");
            result.add(r0);
            result.add(r1);

            for(int i = 2; i <= n; i++){
                List<String> list = new ArrayList<>();
                for(int j = 0; j < i; j++){
                    List<String> p = result.get(j);
                    List<String> q = result.get(i-1-j);
                    for(String s1 : p)
                        for(String s2 : q)
                            list.add("(" + s1+ ")" + s2);
                }
                result.add(list);

            }
            return result.get(n);
        }
    }
}
