func hasGroupsSizeX(deck []int) bool {
	array := [10000]int{0}

	for _, value := range deck {
		array[value]++
	}

	g := -1
	for i := 0; i < 10000; i++ {
		if array[i] > 0 {
			g = array[i]
		} else {
			g = gcd(g, array[i])
		}
	}
	return g >= 2
}

func gcd(x, y int) int {
	if x == 0 {
		return y
	} 

	return gcd(y % x, x)
}