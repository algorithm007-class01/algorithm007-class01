package G20200343040041

func maxProfit(prices []int) int {
	profit, n := 0, len(prices)
	if n <= 1 {
		return 0
	}
	for i := 1; i < n; i++ {
		tmp := prices[i] - prices[i-1]
		if tmp > 0 {
			profit += tmp
		}
	}
	return profit
}
