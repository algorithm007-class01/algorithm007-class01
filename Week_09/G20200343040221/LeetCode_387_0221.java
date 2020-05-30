//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 案例: 
//
// 
//s = "leetcode"
//返回 0.
//
//s = "loveleetcode",
//返回 2.
// 
//
// 
//
// 注意事项：您可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 387. 字符串中的第一个唯一字符
public class FirstUniqueCharacterInAString_387 {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        int[] counter = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            counter[ch - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (counter[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        int[] counter = new int[26];
        int[] indexer = new int[26];

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            counter[index]++;

            // 假设第一个字符是'z'，则index是25，那么indexer[25]就应该是0，因为'z'第一次出现在0号位
            // 如果s中只有一个'z'，那么indexer[25]不会被再次修改，会一直为0
            // 如果s中有多个'z'，indexer[25]会被修改为第二个'z'的索引位置。
            // 因为indexer是用于记录只出现一次的字符的位置，所以当'z'出现多次时，indexer中记录的其第一次出现的位置不正确也无妨。
            if (indexer[index] == 0) {
                indexer[index] = i;
            }
        }

        int firstIndex = Integer.MAX_VALUE;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 1 && indexer[i] < firstIndex) {
                firstIndex = indexer[i];
            }
        }
        return firstIndex == Integer.MAX_VALUE ? -1 : firstIndex;
    }

    public int firstUniqChar2(String s) {
        int[] counter = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            counter[ch - 'a']++;
        }

        int firstIndex = Integer.MAX_VALUE;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 1) {
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] - 'a' == i) {
                        if (j < firstIndex) {
                            firstIndex = j;
                        }
                        break;
                    }
                }
            }
        }
        return firstIndex == Integer.MAX_VALUE ? -1 : firstIndex;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
