class Solution {

    /**
     * @param Integer[] $digits
     * @return Integer[]
     */
    public function plusOne($digits) {
        // 01. 获取长度
        $length = count($digits);
        for($i= $length-1; $i>=0; $i--){
            if($digits[$i] === 9){
                $digits[$i] = 0;
                continue;
            }
            $digits[$i] += 1;
            break;
        }
        if($digits[0] == 0){
            $digits[0] = 1;
            $digits[$len] = 0;
        }
        return $digits;
    }
}