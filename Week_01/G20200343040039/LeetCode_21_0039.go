package G20200343040039

type ListNode struct {
	Val int
	Next *ListNode
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	preHead := &ListNode{
		Val:-1,
		Next:nil,
	}
	tempNode := preHead

	for l1 != nil && l2 != nil  {
		if l1.Val <= l2.Val {
			tempNode.Next = l1
			l1 = l1.Next
		} else {
			tempNode.Next = l2
			l2 = l2.Next
		}
		tempNode = tempNode.Next
	}

	if l1 == nil {
		tempNode.Next = l2
	} else {
		tempNode.Next = l1
	}

	return preHead.Next
}