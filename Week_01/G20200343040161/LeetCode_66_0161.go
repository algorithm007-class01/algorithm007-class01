package G20200343040161

func plusOne(digits []int) []int {
	if digits == nil || len(digits) == 0 {
		return digits
	}

	need := true
	for i := len(digits)-1; i >= 0; i-- {
		if !need {
			break
		}
		if digits[i] == 9 {
			digits[i] = 0
		} else {
			digits[i]++
			need = false
		}
	}

	if digits[0] == 0 {
		digits[0] = 1
		digits = append(digits, 0)
	}

	return digits
}