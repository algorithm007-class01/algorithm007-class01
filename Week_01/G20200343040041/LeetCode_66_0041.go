package G20200343040041

//数字加一
func plusOne(digits []int) []int {
	n:=len(digits)
	for i:=n-1;i>=0;i-- {
		if digits[i]==9{
			digits[i]=0
			continue
		}
		digits[i]++
		return digits
	}
	//最高位进位
	res:=make([]int,n+1)
	res[0]=1
	return res
}