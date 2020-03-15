#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>

using namespace std;

//  Definition for singly-linked list.
struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

/**
 * clarification:将两个有序链表合并成为一个新的有序链表
 * > 分析：1. 类比两个有序数组合并，将数组下标操作换成指针操作；2. 链表的头节点和尾节点的插入和删除是特殊的，可以采用带头节点
 * solutions:
 * > 解法1：使用辅助带头节点，采用迭代法求解，时间复杂度为O(n+m)，空间复杂度为O(1)
 * > 解法2：使用递归进行求解，时间复杂度为O(n+m)，空间复杂度为O(n+m)
 * testCases:两个空链表(NULL,NULL)；一个空链表(NULL,ListNode*l2);2个正常有序链表；
*/

class Solution
{
public:
    /**
     * Solution 1: 迭代
     * > 使用头节点head和移动节点p，head不动，p移动
     * > 迭代条件：l1!=NULL并且l2!=NULL;在迭代结束之后p指向非空节点
    */
    ListNode *mergeTwoLists1(ListNode *l1, ListNode *l2)
    {
        ListNode *head = new ListNode(0);
        ListNode *p = head;
        while (l1 != NULL && l2 != NULL)
        {
            if (l1->val <= l2->val)
            {
                p->next = l1;
                l1 = l1->next;
            }
            else
            {
                p->next = l2;
                l2 = l2->next;
            }
            p = p->next;
        }
        p->next = l1 != NULL ? l1 : l2;
        return head->next;
    }
    /**
     * Solution 2: 递归
     * > 使用递归无法使用中间变量head进行存储，采用第一次节点比较的最小的作为返回，修改这个最小的节点
     * > 递归公式（l1和l2不为空时）：head->a0->...->an->a(n+1)->null;
     *    a(n+1)=l1是上个最小?(an->next,l2):(l1:an->next);
     *    an->next=a(n+1);
     * > 递归边界：
     *    l1为空时，返回l2；
     *    l2为空时，返回l1;
    */
    ListNode *mergeTwoLists2(ListNode *l1, ListNode *l2)
    {
        if (l1 == NULL)
        {
            return l2;
        }
        if (l2 == NULL)
        {
            return l1;
        }
        if (l1->val <= l2->val)
        {
            l1->next = mergeTwoLists2(l1->next, l2);
            return l1;
        }
        else
        {
            l2->next = mergeTwoLists2(l1, l2->next);
            return l2;
        }
    }
    /**
     * 链表递归打印
    */
    void traverse(ListNode *head)
    {
        if (head == NULL)
            return;
        cout << head->val << " ";
        traverse(head->next);
    }
};
int main()
{
    // test cases
    Solution solution;

    // 官方提示的测试用例([1,2,3],[1,2,4])
    ListNode *l1 = new ListNode(1);
    l1->next = new ListNode(2);
    l1->next->next = new ListNode(3);
    ListNode *l2 = new ListNode(1);
    l2->next = new ListNode(2);
    l2->next->next = new ListNode(4);
    ListNode *head = solution.mergeTwoLists1(l1, l2);
    solution.traverse(head);
    cout << endl;

    // (NULL,NULL)
    ListNode *head1 = solution.mergeTwoLists1(NULL, NULL);
    solution.traverse(head1);
    cout << endl;

    // (NULL,[-3,-1,1,3])
    ListNode *l3 = new ListNode(-3);
    l3->next = new ListNode(-1);
    l3->next->next = new ListNode(1);
    l3->next->next->next = new ListNode(3);
    ListNode *head2 = solution.mergeTwoLists1(NULL, l3);
    solution.traverse(head2);
    cout << endl;

    // ([-3,-1,1,3],[-2,0,2,4])
    ListNode *l4 = new ListNode(-3);
    l4->next = new ListNode(-1);
    l4->next->next = new ListNode(1);
    l4->next->next->next = new ListNode(3);
    ListNode *l5 = new ListNode(-2);
    l5->next = new ListNode(-0);
    l5->next->next = new ListNode(2);
    l5->next->next->next = new ListNode(4);
    ListNode *head3 = solution.mergeTwoLists1(l4, l5);
    solution.traverse(head3);
}