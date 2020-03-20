class Solution {

    /**
    * @param Integer[] $digits
    * @return Integer[]
    */
    public function plusOne($digits) {
        $p = count($digits) - 1;
        $arrRes = $this->checkData($digits, $p);
        return $arrRes;
    }

    public function checkData($digits, $p) {
        if($digits[$p] === 9) {
            $digits[$p] = 0;
            if($p > 0) {
                $digits = $this->checkData($digits, --$p);
            } else {
                array_unshift($digits, 1);
            }
        } else {
            ++$digits[$p];
        }
        return $digits;
    }
}