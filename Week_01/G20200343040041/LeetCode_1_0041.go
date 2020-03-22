package G20200343040041

//两次hash表
//func twoSum(nums []int, target int) []int {
//	hash:=map[int]int{}
//	for i:=0;i<len(nums)-1;i++{
//		hash[nums[i]]=i
//	}
//	res:=make([]int,2)
//	for i:=0;i<len(nums)-1;i++{
//		if key,ok:=hash[target-nums[i]];ok&&i!=key{
//			res[0],res[1]=i,key
//		}
//	}
//	return res
//}

//两数求和 一次hash表
func twoSum(nums []int, target int) []int {
	hash:=make(map[int]int,0)
	for i:=0;i<len(nums);i++{
		complement:=target-nums[i]
		if key,ok:=hash[complement];ok {
			return []int{key,i}
		}
		hash[nums[i]]=i
	}
	return []int{}
}