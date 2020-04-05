<?php
/*
* 347 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
* 输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
*/
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $k
     * @return Integer[]
     */
    function topKFrequent($nums, $k) {
        
        $len = count( $nums );
        for( $i=0 ; $i < $len ; $i++ ) {
            $arr[$nums[$i]] +=1;
        }
        $pq = new SplPriorityQueue;
        foreach($arr as $key=>$val) $pq->insert($key,$val);
        $ans = [];
        for($i=0;$i<$k;$i++) $ans[] = $pq->extract();
        return $ans;


    }
}
?>