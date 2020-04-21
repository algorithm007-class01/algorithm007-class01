<?php
/*
*   91. 解码方法 
一条包含字母 A-Z 的消息通过以下方式进行了编码：1-26

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。

类似于爬楼梯 ，1步 或者 2步 到顶，只是有特殊条件
1.只有1个数字0 ， 不能编码 ，返回0
2.只有一个数字 ，>0 ,返回1
3.当前位置为0 ， i-1 == 1  or i-1 ==2 , dp[i] = dp[i-2] ,其他则不能编码 返回0
4. i-1 ==1  ，和当前位置可以组合编码，也可以单独编码  dp[i] = dp[i-1] + dp[i-2]
5. i-1 ==2 , 1<i<=6 ,可以组合也可以单独编码  dp[i] = dp[i-1] + dp[i-2]  
6. 其他 单独编码 dp[i] = dp[i-1]
**/
class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function numDecodings($s) {
        $count = strlen( $s );
        if( $s[0] == 0 ) return 0;
        if( $count == 1 ) return  $count;
        $dp[0] = 1;$dp[-1]=1;
        for( $i = 1 ; $i < $count ; $i++ ) {
            if( $s[$i] == 0 ) {
                if( $s[$i-1] == 1 || $s[$i-1] == 2 ) {
                    $dp[$i] = $dp[$i-2];
                }else{
                    return 0;
                }
                
            }else if( $s[$i-1] == 1 || ( $s[$i-1]== 2 && $s[$i] >=1 && $s[$i] <=6 )) {
                $dp[$i] = $dp[$i-1] + $dp[$i-2];
            }else{
                $dp[$i] = $dp[$i-1];
            }
        }
        return $dp[$count-1];

    }
}

?>