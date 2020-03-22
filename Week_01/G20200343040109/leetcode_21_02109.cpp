//leetcode_21_0109.cpp
//合并有序链表-----这个暂时未完成

#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
 };


//l2插入到l1
//两种边界情况要考虑:
//一是l2插入的元素比l1里面所有的都小
//二是l2插入的元素比l1里面所有的都大
ListNode* mergeTwoLists(ListNode* l1, ListNode* l2)
{
    //方法1：递归
    int l2Value = l2->val;
    ListNode* pHead = l1;
    ListNode* pPrevious = NULL;//记录上一个node
    while(pHead && l2Value > pHead->val )//有可能l2的值比l1所有的都大，这个时候pHead可能为空
    {
        pPrevious = pHead;
        pHead = pHead->next;
    }

    ListNode* l2Next = l2->next;//先把l2的下一个节点记录下来

    if(!pPrevious)//l2的节点的val比l1节点val小，要放在前面
    {
        l2->next = pHead;
        pPrevious = l2;

    }
    else//把l2节点放在pPrevious和pHead之间
    {
        ListNode* pTemp = pPrevious->next;
        pPrevious->next = l2;
        l2->next = pHead;
    }

    if(NULL == l2->next)//最后一个
    {
        return l1;
    }

    return mergeTwoLists(pPrevious, l2Next);
}

 int main(void)
 {
     
 }
