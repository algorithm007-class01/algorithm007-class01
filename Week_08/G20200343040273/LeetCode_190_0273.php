<?php
/***
 * 190. 颠倒二进制位
 */
class Solution {
    /**
     * @param Integer $n
     * @return Integer
     */
    function reverseBits($n) {
        
        $res = 0;
        for( $i = 0 ; $i < 32 ; $i ++ ) {
            $res = ( $res << 1 ) + ( $n & 1 ) ;
            $n = $n >> 1;
        }
        return $res;
    }
}
?>