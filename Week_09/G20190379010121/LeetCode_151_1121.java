class Solution {
    public String reverseWords(String s) {
        //删除前后空格
        s = s.trim();
        //如果为空直接返回
        if (s.equals("")) return s;
        //按照空格划分
        String[] str = s.split(" ");
        int n = str.length;
        StringBuilder result = new StringBuilder();
        //从后往前遍历数组，
        for (int i = n - 1;i >= 0;i--){
            //防止出现多个空格
            if (str[i].length() != 0) {
                result.append(str[i]).append(" ");
            }

        }
        //删除结尾多余空格
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

}