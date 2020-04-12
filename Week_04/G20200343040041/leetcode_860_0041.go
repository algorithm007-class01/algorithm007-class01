package G20200343040041

func lemonadeChange(bills []int) bool {
	five, ten := 0, 0

	for _, v := range bills {
		if v == 5 {
			five++
		} else if v == 10 {
			if five >= 1 {
				five--
				ten++
			} else {
				return false
			}
		} else if v == 20 {
			if five >= 1 && ten >= 1 {
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
