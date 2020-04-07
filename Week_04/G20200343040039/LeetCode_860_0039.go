package G20200343040039

func lemonadeChange(bills []int) bool {
	if bills == nil || len(bills) == 0{
		return true
	}
	five := 0
	ten := 0

	for i := 0; i < len(bills); i++ {
		if bills[i] == 5 {
			five++
		} else if bills[i] == 10 {
			if five >= 1 {
				five--
				ten++
			} else {
				return false
			}
		} else {
			if ten > 0 && five > 0 {
				ten--
				five--
			} else if five >= 3 {
				five -= 3
			} else {
				return false
			}
		}
	}

	return true
}