class Solution{
	public:
		ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
			// 方法一 双辅助指针
			/*
			if(NULL == l1){
				return l2;
			}
			if(NULL == l2){
				return l1;
			}
			ListNode dummy(-1);
			ListNode* prev = &dummy;
			ListNode *pa = l1, *pb = l2;
			while(pa && pb){
				if(pa->val < pb->val){
					prev->next = pa;
					pa = pa->next;
				}else{
					prev->next = pb;
					pb = pb->next;
				}
				prev = prev->next;
			}
			prev->next = pa?pa:pb;
			return dummy.next;
			*/

			// 方法二 无辅助指针
			
			if(NULL == l1){
				return l2;
			}
			if(NULL == l2){
				return l1;
			}
			ListNode dummy(-1);
			ListNode* tail = &dummy; 
			while(l1&&l2){
				ListNode** node = l1->val < l2->val ? &l1: &l2;//取得最小值的地址 
				tail->next = *node;
				*node = (*node)->next;// 更新node
				tail = tail->next;// 更新tail
			}
			tail->next = l1?l1:l2;// 连接上剩下的。
			return dummy.next;
		}
};
