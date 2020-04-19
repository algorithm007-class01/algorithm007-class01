package G20200343040043

// 860. 柠檬水找零
// 题目：https://leetcode-cn.com/problems/lemonade-change/

// 解法
// 支付10块，有5块成功，支付20，先找10块和5块的

func lemonadeChange(bills []int) bool {
	coinMap := make(map[int]int)
	for _, bill := range bills {
		if bill == 5 {
			coinMap[5]++
		} else if bill == 10 && coinMap[5] > 0 {
			coinMap[5]--
			coinMap[10]++
		} else if bill == 20 && coinMap[10] > 0 && coinMap[5] > 0 {
			coinMap[10]--
			coinMap[5]--
		} else if coinMap[5] > 2 {
			coinMap[5] -= 3
		} else {
			return false
		}
	}
	return true
}

// times: 1
