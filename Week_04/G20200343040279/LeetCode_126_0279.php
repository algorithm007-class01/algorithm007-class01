<?php

/**
 *单词接龙 I
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

    每次转换只能改变一个字母。
    转换过程中的中间单词必须是字典中的单词。

说明:

    如果不存在这样的转换序列，返回 0。
    所有单词具有相同的长度。
    所有单词只由小写字母组成。
    字典中不存在重复的单词。
    你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
 */
class Solution {

    /**
     * @param String $beginWord
     * @param String $endWord
     * @param String[] $wordList
     * @return Integer
     */
    function ladderLength($beginWord, $endWord, $wordList) {
        if (!in_array($endWord, $wordList)) return 0;
        $wordKv = array_flip($wordList); // 交换数组中的键和值。查询和删除key比value效率高
        $s1[] = $beginWord;
        $s2[] = $endWord; // 双向BFS
        $n = strlen($beginWord);
        $step = 0;
        while (!empty($s1)) {
            $step ++;
            if (count($s1) > count($s2)) {//依次双向BFS实现,始终使用变量s1去运算。
                $tmp = $s1;
                $s1 = $s2;
                $s2 = $tmp;
            }
            $s = [];
            foreach ($s1 as $word_1) {
                for ($i = 0; $i < $n; $i++) {
                    $word1 = $word_1;
                    for ($ch = ord('a'); $ch <= ord('z'); $ch++) {
                        $word1[$i] = chr($ch);
                        if (in_array($word1, $s2)) return $step + 1;
                        if (!array_key_exists($word1, $wordKv)) continue;
                        unset($wordKv[$word1]);
                        $s[] = $word1;
                    }
                }
            }
            $s1 = $s;
        }
        return 0;
    }
}