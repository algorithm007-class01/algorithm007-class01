package G20200343040041


func moveZeroes(nums []int) {
	if len(nums)==0{
		return
	}
	cur:=0
	for _, v := range nums {
		if v!=0{
			nums[cur]=v
			cur++
		}
	}
	for cur<len(nums){
		nums[cur]=0
		cur++
	}
}
