package G20200343040039

func maxProfit(prices []int) int {
	if prices == nil || len(prices) == 0 {
		return 0
	}
	result := 0

	for i := 1; i < len(prices); i++ {
		if prices[i-1] < prices[i] {
			result += (prices[i] - prices[i-1])
		}
	}

	return result
}