class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1Index = l1;
        ListNode l2Index = l2;
        ListNode result = new ListNode(0);
        ListNode resultIndex = result;
        while (l1Index != null && l2Index != null){
            if ( l1Index.val <= l2Index.val ){
                resultIndex.next = l1Index;
                resultIndex = resultIndex.next;
                l1Index = l1Index.next;
            }else{
                resultIndex.next = l2Index;
                resultIndex = resultIndex.next;
                l2Index = l2Index.next;
            }
        }
        if (l1Index != null){
            resultIndex.next = l1Index;
        }
        if (l2Index != null){
            resultIndex.next = l2Index;
        }
        return result.next;
    }
}