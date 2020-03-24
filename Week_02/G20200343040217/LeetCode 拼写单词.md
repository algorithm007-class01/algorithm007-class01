[题目地址](https://leetcode-cn.com/problems/linked-list-cycle/)



-  :grin: 第一次练习 2020年3月17日 五毒神功
- :shit: 第二次练习 



### Hash 计数



```javascript
/**
 * @param {string[]} words
 * @param {string} chars
 * @return {number}
 */
var countCharacters = function(words, chars) {
    /**
     * define size
     * loop chars -> Map
     * loop words:word
     *     loop word -> Map
     *     loop word -> compare(charsMap, wordMap)
     *     size += word.size
     * return size;
     */

    let size = 0, charMap = new Map();
    for (const char of chars) {
        charMap.set(char, charMap.get(char) ? charMap.get(char) + 1 : 1);
    }

    let wordMap = null;
    for(const word of words) {
        wordMap = new Map();
        for(const w of word) {
            wordMap.set(w, wordMap.get(w) ? wordMap.get(w) + 1 : 1);
        }

        let mark = true;
        for(const w of word) {
            if (!charMap.get(w) || wordMap.get(w) > charMap.get(w)) {
                mark = false;
                break;
            }
        }

        if (mark) {
            size += word.length;
        }
    }

    return size;
};
```



### Java 通过自建Hash 求解

copy 的人家的代码，自己暂时还未尝试过 :notebook:

```java
 public static int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] seen = new int[26];
		//Count char of Chars String
        for (char c : chars.toCharArray())
            seen[c - 'a']++;
		// Comparing each word in words
        for (String word : words) {
			// simple making copy of seen arr
            int[] tSeen = Arrays.copyOf(seen, seen.length); 
            int Tcount = 0;
            for (char c : word.toCharArray()) {
                if (tSeen[c - 'a'] > 0) {
                    tSeen[c - 'a']--;
                    Tcount++;
                }
            }
            if (Tcount == word.length())
                count += Tcount;
        }
        return count;
    }
```



这是一份优雅的代码，逻辑清晰，才有自顶向下的编程方式。:ox::beers:

```javascript
/**
 * @param {string[]} words
 * @param {string} chars
 * @return {number}
 */
var countCharacters = function(words, chars) {
    let total = 0;
    for (let word of words) {
        let map = createMap(chars);       
        if (isWordGood(word, map)) {
            total += word.length;  
        }        
    }
    
    return total;   
};

var createMap = function(chars) {
    let map = {};
    for(let i = 0; i < chars.length; i++) {
        if (!map[chars[i]]) {
            map[chars[i]] = 0;
        } 
        map[chars[i]]++;        
    }
    
    return map;
}

var isWordGood = function(word, map) {
    for (let i = 0; i < word.length; i++) {
        if (!map[word[i]] || map[word[i]] == 0) {
            return false;
        }
        map[word[i]]--;
    }
    
    return true;
}
```



### 易错点

- 没有 size 只有 length
