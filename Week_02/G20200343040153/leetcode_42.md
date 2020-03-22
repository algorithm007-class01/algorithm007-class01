
###### 42 接雨水
***

* 双指针法

```angular2
    function trap($height) {
            $left = 0;
            $right = count($height) - 1;
            $ans = 0;
            $max_left = $max_right = 0;
            while ( $left < $right ) {
                if ( $height[$left] < $height[$right] ) {
                    $height[$left] >= $max_left ? ($max_left = $height[$left]) : $ans += ($max_left - $height[$left]);
                    ++$left;
                } else {
                    $height[$right] >= $max_right ? ($max_right = $height[$right]) : $ans += ($max_right - $height[$right]);
                    --$right;
                }
            }
            return $ans;
        }
```