<?php
class Solution {

    private $arr = [];
    /**
     * @param Integer $n
     * @return String[]
     */
    function generateParenthesis($n) {
        $this->kuohao(0,0,$n,'');
        return $this->arr;
    }

    function kuohao($left, $right, $n, $s){

        //处理边界条件，左括号和右括号都用完了
        if($left == $n && $right == $n){
            $this->arr[] = $s;
            return;
        }

        //添加左括号的条件 左括号还没用完
        if($left <= $n){
            $arr[] = $this->kuohao($left + 1, $right, $n, $s."(");
        }

        //添加右括号的条件，左括号比右括号多
        if($left > $right){
            $arr[] = $this->kuohao($left, $right + 1, $n, $s.")");
        }
    }
}

?>