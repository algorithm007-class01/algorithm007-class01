<?php
/**
 * 189.旋转数组，给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
   输出: [5,6,7,1,2,3,4]
   思路：K1 ：删除尾部O(1)，插入头部O(n)。
         K2 ：向左移动。删除头部O(n)，插入尾部O(1)
    疑问？ 实际运行时间  K2 远小于 K1 ，为啥
 */

//删尾部，插头部
function rotate( &$nums , $k ) {

    $len = count( $nums );
    for( $i = 0 ; $i < $k ; $i ++ ) {
        $tmp = $nums[ $len -1 ];
        unset ( $nums[$len -1] );
        array_unshift( $nums , $tmp );
    }
    return $nums;
}

//删头部，插尾部
function rotatedeletehead( &$nums , $k  ) {
    $len = count( $nums );
    if( $k > $len ) {
        $k = $k - $len ;
    }
    $t = $len - $k ;

    for( $i = 0 ; $i < $t ; $i ++ ) {
        $tmp = $nums[$i];
        unset( $nums[$i] );
        $nums[] = $tmp;
    }
    return $nums;
}
?>