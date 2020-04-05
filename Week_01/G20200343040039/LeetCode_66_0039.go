package G20200343040039

func plusOne(digits []int) []int {
	//999
	//129
	//192
	for i := len(digits)-1; i >= 0; i-- {
		if digits[i]+1 == 10 {
			digits[i] = 0
		} else {
			digits[i] += 1
			break;
		}
	}

	if digits[0] == 0 {
		newDigits := make([]int, len(digits)+1)
		newDigits[0] = 1
		return newDigits
	}

	return digits
}