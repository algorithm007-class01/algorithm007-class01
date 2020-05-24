<?php

/**
* 917. 仅仅反转字母 
* 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
*/
class Solution {

    /**
     * @param String $S
     * @return String
     */
    function reverseOnlyLetters($S) {
        $stack = [];
        $res = '';
        for ($i = 0; $i < strlen($S); $i++) {
            if ($this->isLetter($S[$i])) array_push($stack, $S[$i]);
        }

        for ($i = 0; $i < strlen($S); $i++) {
            if ($this->isLetter($S[$i])) $res .= array_pop($stack);
            else $res .= $S[$i];
        }

        return $res;
    }

    /**
     * @param string $char
     * @return boolean
     */
    public function isLetter($char)
    {
        if (($char >= 'a' && $char <= 'z') || ($char >= 'A' && $char <= 'Z')) return true;

        return false;
    }
}



?>
