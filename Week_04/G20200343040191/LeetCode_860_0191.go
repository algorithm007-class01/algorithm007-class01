func lemonadeChange(bills []int) bool {
    five, ten := 0, 0
    for _, b := range bills {
        if b == 5 {
            five++
        } else if b == 10 {
            if five == 0 {
                return false
            }
            five--
            ten++
        } else {
            if five > 0 && ten > 0 {
                five--
                ten--
            } else if five >= 3 {
                five -= 3
            } else {
                return false
            }
        }
    }
    return true
}
