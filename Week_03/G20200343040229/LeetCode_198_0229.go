func rob(nums []int) int {
    size := len(nums)
    if size == 0 {
        return 0
    }

    money1 := 0
    money2 := nums[0]
    for i := 1; i < size; i++ {
        money1, money2 = max(money1, money2), money2 + nums[i]
    }

    return max(money1, money2)
}

func max(money1, money2 int) int {
    if money1 > money2 {
        return money1
    }

    return money2
}
