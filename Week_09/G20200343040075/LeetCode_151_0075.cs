/*
 * @lc app=leetcode.cn id=151 lang=csharp
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
using System.Collections.Generic;
using System.Text;

public class Solution {
    /// <summary>
    /// 拆分单词，从后往前加入新字符串中
    /// </summary>
    /// <param name="s"></param>
    /// <returns></returns>
    public string ReverseWords2 (string s) {
        if (string.IsNullOrEmpty (s)) {
            return string.Empty;
        }
        s = s.Trim ();
        string[] arr = s.Split (' ');
        StringBuilder sb = new StringBuilder ();
        for (int i = arr.Length - 1; i >= 0; i--) {
            if (!string.IsNullOrEmpty (arr[i])) {
                sb.Append (arr[i]);
                if (i != 0) {
                    sb.Append (" ");
                }
            }
        }
        return sb.ToString ();
    }

    /// <summary>
    /// 双指针
    /// </summary>
    /// <param name="s"></param>
    /// <returns></returns>
    public string ReverseWords (string s) {
        // if (string.IsNullOrEmpty (s)) {
        //     return string.Empty;
        // }
        int left = 0, right = s.Length - 1;
        while (left <= right && s[left] == ' ') left++;
        while (left <= right && s[right] == ' ') right--;

        List<string> list = new List<string> ();
        StringBuilder sb = new StringBuilder ();
        while (left <= right) {
            char c = s[left];
            if (c != ' ') {
                sb.Append (c);
            } else {
                if (sb.Length > 0) {
                    list.Insert (0, sb.ToString ());
                    sb.Clear ();
                }
            }
            left++;
        }
        if (sb.Length > 0) {
            list.Insert (0, sb.ToString ());
        }
        return string.Join (" ", list);
    }
}
// @lc code=end

static int Main (string[] args) {
    System.Console.WriteLine (new Solution ().ReverseWords ("the sky is blue"));
    System.Console.WriteLine (new Solution ().ReverseWords ("  hello world!  "));
    System.Console.WriteLine (new Solution ().ReverseWords ("a good   example"));
    return 0;
}
// Main (null);