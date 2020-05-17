//给定一个字符串，逐个翻转字符串中的每个单词。
//
// 说明：
//
//
// 无空格字符构成一个单词。
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public String reverseWords(String s) {
        // 将字符串以空格分隔，构造一个字符串数组
        String[] arr = s.split(" ");
        StringBuffer sb = new StringBuffer("");
        int len = arr.length;
        // 从后往前遍历整个数组，将单词逆向加入到StringBuffer实例中
        for (int i = len - 1; i >= 0; i--) {
            // 碰到空就略过
            if ("".equals(arr[i])) {
                continue;
            }
            sb.append(arr[i]).append(" ");
        }
        String res = sb.toString();
        if ("".equals(res)) {
            return res;
        }
        // 将多余的空格截断
        return res.substring(0, res.length() - 1);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
