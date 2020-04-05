/* 快排
func sortArray(nums []int) []int {
    quickSort(nums, 0, len(nums) - 1)
    return nums
}

func quickSort(nums []int, left, right int){
	if left >= right {
		return 
	}

	cur := left + 1
	lo := left
	for ;cur <= right; cur++ {
		if nums[cur] > nums[left] {
			continue
		}
		nums[cur], nums[lo + 1] = nums[lo + 1], nums[cur]
		lo++
	}
	nums[left], nums[lo] = nums[lo], nums[left]
	quickSort(nums, left, lo - 1)
	quickSort(nums, lo + 1, right)
}
*/

/* 调用内置函数
func sortArray(nums []int) []int {
    sort.Ints(nums)
    return nums
}
*/

/* 暴力破解 
func sortArray(nums []int) []int {
    size := len(nums)
    for i := 0; i < size - 1; i++ {
        for j := i + 1; j < size; j++ {
            if nums[i] > nums[j] {
                nums[i], nums[j] = nums[j], nums[i]
            }
        }
    }
    return nums
}
*/


func sortArray(nums []int) []int {
	counter := [100010]int{0}

	for _, value := range nums {
		counter[value + 50000]++
	}
	res := []int{}
	for i := 0; i < 100010; i++ {
		if counter[i] == 0 {
			continue
		}
		for j := 0; j < counter[i]; j++ {
			res = append(res, i - 50000)
		}
	}
	return res
}
