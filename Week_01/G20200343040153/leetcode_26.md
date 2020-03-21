#### 学习笔记
*** 
###### 26 删除排序数组中的重复项 
***

* 排序后循环求解

```angular2
    public function execute(&$nums) {
        $len = count($nums);
        if ( $len < 1 ) {
            return $len;
        }
        // 从小到大进行排序
        sort($nums);
        // 记录上一次的值
        $prev_num = $nums[0];
        for ( $i = 1; $i < $len; $i++ ) {
            // 判断当前值与上一次的值是否相同，相同删除当前值
            if ( $nums[$i] == $prev_num ) {
                unset($nums[$i]);
                continue;
            }
            // 不同修改上一次的值
            $prev_num = $nums[$i];
        }
    }
```

* 双指针法

```angular2
    public function execute(&$nums)
    {
        $prev   = 0;
        $len    = count($nums);
        for ( $i = 1; $i < $len; $i++ ) {
            if ( $nums[$prev] != $nums[$i] ) {
                $nums[$prev++] = $nums[$i];
            }
        }
        // 按短指针截取指定长度的有效数组
        $nums = array_slice($nums, 0, $prev + 1);
        return $prev + 1;
    }
```




