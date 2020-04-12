package G20200343040041

//二分查找
func search(nums []int, target int) int {
	lo, hi := 0, len(nums)-1
	//循环退出条件
	//注意是 low<=high，而不是 low<high; 例如数组长度为1时，则无法运行
	for lo <= hi {
		//mid 的取值
		//两者之和就有可能会溢出
		mid := lo + (hi-lo)>>1
		//low 和 high 的更新
		//直接写成 low=mid 或者 high=mid，就可能会发生死循环
		if nums[mid] == target {
			return mid
		} else if nums[mid] < target {
			lo = mid + 1
		} else {
			hi = mid - 1
		}
	}
	return -1
}
