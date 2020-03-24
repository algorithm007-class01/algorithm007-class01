
###### 49 字母异位词分组
***

* 排序数组分类

```angular2
    function groupAnagrams($strs) {
        $map = [];
        foreach ($strs as $str) {
            $arr = str_split($str);
            sort($arr);
            $tmp_str = implode("", $arr);
            $map[$tmp_str][] = $str;
        }
        return array_values($map);
    }
```

* 哈希计数分类

```angular2
    function groupAnagrams($strs) {
        $data = [];
        $prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103];
        foreach ($strs as $str) {
            $strlen = 1;
            for ($i = 0; $i < strlen($str); $i++) {
                $strlen *= $prime[ord($str[$i]) - 97];
            }
            $data[$strlen][] = $str;
        }
        return array_values($data);
    }
```




