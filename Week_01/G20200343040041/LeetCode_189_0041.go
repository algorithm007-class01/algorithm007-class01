package G20200343040041

func rotate(nums []int, k int)  {
	//处理k值大于数组长度的问题
	k %= len(nums)
	reverse(nums,0,len(nums)-1)
	reverse(nums,0,k-1)
	reverse(nums,k,len(nums)-1)
}

func reverse(nums []int,begin,end int){
	for begin<end{
		tmp:=nums[end]
		nums[end]=nums[begin]
		nums[begin]=tmp
		begin++
		end--
	}
}