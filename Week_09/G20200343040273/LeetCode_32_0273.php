<?php

/*
* 32. 最长有效括号
* 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
*/

class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function longestValidParentheses($s) {
        $len = 0;
        if (empty($s)) return $len;

        $stack = [-1];
        for ($i = 0; $i < strlen($s); $i++) {
            if ($s[$i] == '(') {
                $stack[] = $i;
            } else {
                array_pop($stack);
                if (empty($stack)) {
                    $stack[] = $i;
                } else {
                    $len = max($len, $i - end($stack));
                }
            }
        }

        return $len;
    }
}

?>

