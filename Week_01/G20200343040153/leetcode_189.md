#### 学习笔记
*** 
###### 189 旋转数组 
***

* 环状替换

```angular2
    public function execute(&$nums, $k)
    {
        $len    = count($nums);
        $k      = $k % $len;
        $count  = 0;
        for ( $start = 0; $count < $len; $start++ ) {
            $current    = $start;
            $prev       = $nums[$start];
            do {
                $next = ($current + $k) % $len;
                $temp = $nums[$next];
                $nums[$next] = $prev;
                $prev = $temp;
                $current = $next;
                $count ++;
            } while ( $start != $current );
        }
    }
```

* 反转

```angular2
    public function rotate(&$nums, $k)
    {
        $len    = count($nums);
        $k      %= $len;
        $this->reverse($nums, 0, $len - 1);
        $this->reverse($nums, 0, $k - 1);
        $this->reverse($nums, $k, $len - 1);
    }

    private function reverse(&$nums, $start, $end)
    {
        while ( $start < $end ) {
            $temp           = $nums[$start];
            $nums[$start]   = $nums[$end];
            $nums[$end]     = $temp;
            $start++;
            $end--;
        }
    }
```




