/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode {
	var reverseNode, nextNodeTmp *ListNode
	
	for head != nil {
		nextNodeTmp = head.Next
		head.Next = reverseNode
		reverseNode = head
		head = nextNodeTmp
	}

	return reverseNode
}
