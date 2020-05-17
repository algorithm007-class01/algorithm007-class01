package app;

public class LeetCode_557_0333 {
    class Solution {
        public String reverseWords(String s) {
            if(null==s) return "";
            if(s.length()==1) return s;
            return betterAns(s);
        }
        private String betterAns(String s){
            StringBuffer sb=new StringBuffer();
            int left=0;
            int right=0;
            int len=s.length();
            while(right<len){
                if(!(right+1==len||s.charAt(right+1)==' ')){
                    right++;
                    continue;
                }
                if(sb.length()>0) sb.append(" ");
                //System.out.println(right);
                char[] charArr=s.substring(left,right+1).toCharArray();
                int start=0;
                int end=charArr.length-1;
                while(start<end){
                    char temp=charArr[start];
                    charArr[start]=charArr[end];
                    charArr[end]=temp;
                    ++start;
                    --end;
                }
                sb.append(new String(charArr));
                left+=charArr.length+1;
                ++right;
            }
            return sb.toString();
        }
        private String dealSplit(String s){
            String arr[]=s.split(" ");
            StringBuffer sb=new StringBuffer();
            for(String sOne:arr){
                if(sb.length()>0) sb.append(" ");
                char[] charArr=sOne.toCharArray();
                int start=0;
                int end=charArr.length-1;
                while(start<end){
                    char temp=charArr[start];
                    charArr[start]=charArr[end];
                    charArr[end]=temp;
                    ++start;
                    --end;
                }
                sb.append(new String(charArr));
            }
            return sb.toString();
        }
    }
}