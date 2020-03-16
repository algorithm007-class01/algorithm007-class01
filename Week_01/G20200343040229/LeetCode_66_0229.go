/*
 * 数字加1涉及到进位问题，而进位的情况是数字为9，特殊情况是数字全为9。
 * 例：199——》200；1299——》1300；99——》100；1288——》1289
 * 所以，重点只需要逆序判断连续9的情况。
 */
func plusOne(digits []int) []int {
    i := 0
    for i = len(digits) - 1; i > -1; i-- {
        if digits[i] != 9 {
            break
        } 
        digits[i] = 0
    }

    if i == -1 {
        digits[0] = 1
        digits = append(digits, 0)
        //digits = append([]int{1}, digits...}
    } else {
        digits[i] += 1
    }

    return digits
}
