<?php

function merge(&$nums1, $m, $nums2, $n) {
    for ($i = 0; $i < $n; $i++) {
        $nums1[$m+$i] = $nums2[$i];
    }
    sort($nums1);
}

