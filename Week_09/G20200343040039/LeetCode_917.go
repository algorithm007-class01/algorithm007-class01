package G20200343040039

import "unicode"

func reverseOnlyLetters(S string) string {
	var temp string
	var result string
	
	for i := len(S) - 1; i >= 0; i-- {
		if unicode.IsLetter(rune(S[i])) {
			temp += string(S[i])
		}
	}

	for i, j := 0, 0; i < len(S); i++ {
		if unicode.IsLetter(rune(S[i])) {
			result += string(temp[j])
			j++
		} else {
			result += string(S[i])
		}
	}

	return result
}