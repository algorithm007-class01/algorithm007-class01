<?php
/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
把每个字符串排序之后比较，如果一样就是异位词
 */
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function groupAnagrams($strs) {
        $map = array();
        for( $i = 0 ; $i < count( $strs ) ; $i ++ ) {
            $arr = str_split( $strs[$i] );
            sort( $arr  );
            $x = implode('', $arr);
            $map[ $x ][$i] = $strs[$i];
            
        }
        return $map;
    }
}
$strs = ["eat", "tea", "tan", "ate", "nat", "bat"];
$class  = new Solution;
$s = $class->groupAnagrams( $strs );
var_dump($s);
?>