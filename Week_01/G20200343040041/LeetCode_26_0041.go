package G20200343040041

//删除排序数组中的重复项
//快慢指针
//	慢指针记录不重复元素的最后一个值的下表
//	快指针遍历原数组，且始终应该快于慢指针
//时间复杂度O(n)
//空间复杂度O(1)
func removeDuplicates(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	i := 0
	for j := 1; j < len(nums); j++ {
		if nums[i] != nums[j] {
			i++
			nums[i] = nums[j]
		}
	}
	return i + 1
}

/*下面为相关题型*/

//删除排序数组中的重复项 II
func removeDuplicates2(nums []int) int {
	i := 0
	for j := 0; j < len(nums); j++ {
		if i < 2 || nums[j] > nums[i-2] {
			nums[i] = nums[j]
			i++
		}
	}
	return i
}

//K duplicates
//前提：数组已经排序
//只需保证每两个不同元素的下标差小于等于k
//即当前元素与i-k的元素比较，如果大于则保留
//func removeDuplicatesk(nums []int) int {
//	i := 0
//	for j := 0; j < len(nums); j++ {
//		if i < k || nums[j] > nums[i-k] {
//			nums[i] = nums[j]
//			i++
//		}
//	}
//	return i
//}

//删除排序链表中的重复项
//简单的链表的下标移动，注意Next的判空
func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil {
		return head
	}
	cur := head
	for cur != nil {
		if cur.Next == nil {
			break
		} else if cur.Val == cur.Next.Val {
			cur.Next = cur.Next.Next
		} else {
			cur = cur.Next
		}
	}

	return head
}

//删除排序链表中的重复项 II
//有重复的全部删除
//Input: 1->2->3->3->4->4->5
//Output: 1->2->5
func deleteDuplicates2(head *ListNode) *ListNode {
	if head == nil {
		return head
	}
	var dummy ListNode
	dummy.Next = head
	cur := &dummy
	for cur.Next != nil && cur.Next.Next != nil {
		if cur.Next.Val == cur.Next.Next.Val {
			tmp := cur.Next
			for tmp != nil && tmp.Next != nil && tmp.Val == tmp.Next.Val {
				tmp = tmp.Next
			}
			cur.Next = tmp.Next
		} else {
			cur = cur.Next
		}
	}
	return dummy.Next
}
