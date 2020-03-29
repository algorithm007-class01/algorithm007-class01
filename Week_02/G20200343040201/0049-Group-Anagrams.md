https://leetcode-cn.com/problems/group-anagrams/

## 1 题目内容

给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

```
输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```


说明：

- 所有输入均为小写字母。
- 不考虑答案输出的顺序。



## 2 我的思考与实现



这题其实曾经有做过，所以有印象。**关键点是对字符做一个排序，然后用哈希表降低查询的时间复杂度。**

也有一点判重，去重的意味在里面。哈希表好像在一些题目里面，经常用来判重或者去重。



### 方法1

```java
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String item : strs) {
        char[] charArr = item.toCharArray();
        //对字符串中的字符排序，方便统一哈希表的key
        Arrays.sort(charArr);
        String key = new String(charArr);
        if (map.containsKey(key)) {
            List<String> list = map.get(key);
            list.add(item);
        } else {
            List<String> list = new LinkedList<>();
            list.add(item);
            map.put(key, list);
        }
    }
    List<List<String>> res = new ArrayList<>();
    for (Map.Entry item : map.entrySet()) {
        res.add((List<String>) item.getValue());
    }
    return res;
}
```

#### 复杂度

- 时间复杂度: $ O(nklog k) $ 

  > 遍历是一次，假设最长的字符串长度为k，字符串排序的复杂度是 O(klogk)。哈希表，插入，查询时间复杂度是O(1). 所以整体是

- 空间复杂度: $ O(nk)  $

  > 每个遍历都新建了一个字符串







## 3 官方解答

https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/



### 方法一：哈希表-用排序后的字符串作为key

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
```

我的点评

> 与我的方法一样，不过它最后，直接使用了 hashmap的values方法和 ArrayList构造方法。代码简洁了很多。 我去看了ans.values()的实现，里面用了一个AbstractCollection的toArray 方法新建了一个数组，然后用迭代器赋值，与我最后的遍历Map.Entry时间复杂度一致的。 
>
> 空间复杂度上，toArray方法虽然new了一个新的Objetc数组，但是这个数组最后在ArrayList的构造方法中，引用赋给了ArrayList的elementData，直接作为了ArrayList的底层数据结构。所以调用Array List构造方法，没有额外多出空间复杂度。
>
> 所以，这种写法，值得学习下，new ArrayList(ans.values());。



### 方法二：哈希表-使用字母表

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
```

#### 复杂度分析

- 时间复杂度：O(NK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。计算每个字符串的字符串大小是线性的，我们统计每个字符串。

- 空间复杂度：O(N)，可以认为是52N，因为每次都建一个长度为的String作为key



#### 我的点评

> 这个解法，很巧妙的用了“所有输入均为小写字母”。使用字母表数组，然后使用字母计数拼起来的字符串作为key。这样就避免了对字符串排序的O(nlogn)的时间复杂度。
>
> **最近做了两道"每日一题"，里面也有巧用英文字母表的题目。所以，以后如果看到，"所有输入均为字母"这样的条件。可以留个心眼，思考下借用字母表数组的做法。**



另外：从时间复杂度分析上讲，解法2其实是要比解法1的要低的。但是解法2在leetcode上，解法2耗时其实是更高的。可能是，leetcode的test case 规模和长度不够吧？我也不敢清楚...

