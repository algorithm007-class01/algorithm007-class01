class Solution {
    /**
    * @param Integer[] $nums
    * @param Integer $target
    * @return Integer[]
    */
    function twoSum($nums, $target) {
        $res = [];
        for($i=0;$i<count($nums);$i++) {
            for($j=$i+1;$j<count($nums);$j++) {
                if($nums[$i]+$nums[$j] === $target) {
                    array_push($res, $i);
                    array_push($res, $j);
                } else {
                    continue;
                }
            }
        }
        return $res;
    }
}
