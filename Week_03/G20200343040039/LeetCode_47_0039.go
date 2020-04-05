package G20200343040039


func permuteUnique(nums []int) [][]int {
	result := [][]int{}

	back_track_unique(0, nums, &result)

	return result
}

func back_track_unique(index int, nums []int,result *[][]int){
	if index == len(nums){
		subResult := make([]int, len(nums))
		copy(subResult, nums)
		*result = append(*result, subResult)
	}

	m := map[int]int{}
	for i := index;i < len(nums);i++{
		if _,ok:=m[nums[i]];ok{
			continue
		}
		nums[i],nums[index] = nums[index],nums[i]
		back_track_unique(index+1, nums, result)
		nums[i],nums[index] = nums[index],nums[i]
		m[nums[i]]=1
	}
}