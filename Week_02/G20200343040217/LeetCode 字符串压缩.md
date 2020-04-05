[题目地址](https://leetcode-cn.com/problems/compress-string-lcci/)



- 😣 第一次练习 2020年3月16日 看题解，但是这个题和某一题，感觉特别像，移动零
- :shit: 第二次练习 



### 双指针

这解法都快是一种常用操作了

解题代码

```javascript
/**
 * @param {string} S
 * @return {string}
 */
var compressString = function(S) {
    // 双指针解法
    let result = "";
    let j = 0, i = 0;
    while(j < S.length - 1) {
        if (S[j] !== S[j + 1]) {
            result = result + S[j] + (j - i + 1);
            i = j + 1;
        }
        j ++;
    }

    result = result + S[j] + (j - i + 1);
    return result.length >= S.length ? S : result;
};
```



### 易错点

- 认真读题，**若压缩后的字符串没有变短，则还是返回原来的长度**。

	![](https://gitee.com/xiaoxiunique/picgo-image/raw/master/carbon (1).png)

- 判断长度的时候应该是 长度 - 1

	```javascript
	while(j < S.length - 1)
	```

	
