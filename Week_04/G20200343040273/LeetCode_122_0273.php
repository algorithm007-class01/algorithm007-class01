//122. 买卖股票的最佳时机 II
class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) {
        $res = 0;
        $len = count( $prices );
        for( $i = 0 ; $i < $len -1  ; $i++ ) {
            $diff = $prices[$i+1] - $prices[$i];
            if( $diff > 0 ) {
                $res += $diff;
            }
            
        }
        return $res;

    }
}