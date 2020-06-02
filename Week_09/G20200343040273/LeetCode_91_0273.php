<?php

/**
* 91 解码方法
*一条包含字母 A-Z 的消息通过以下方式进行了编码：
*/
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