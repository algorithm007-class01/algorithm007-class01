func plusOne(digits []int) []int {
    for i := len(digits) - 1; i >= 0; i-- {
        digits[i] = (digits[i] + 1) % 10
        if digits[i] != 0 {
            return digits
        }
    }
    digits = make([]int, len(digits) + 1)
    digits[0] = 1
    return digits
}
