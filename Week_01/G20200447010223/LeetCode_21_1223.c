/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode *mergeTwoLists(struct ListNode *l1, struct ListNode *l2)
{
    if (l1 == NULL)
    {
        return l2;
    }
    if (l2 == NULL)
    {
        return l1;
    }
    struct ListNode *head, *returnHead;
    if (l1->val < l2->val)
    {
        head = l1;
        l1 = l1->next;
    }
    else
    {
        head = l2;
        l2 = l2->next;
    }
    returnHead = head;
    while (l1 != NULL && l2 != NULL)
    {
        if (l1->val < l2->val)
        {
            head->next = l1;
            head = head->next;
            l1 = l1->next;
        }
        else
        {
            head->next = l2;
            head = head->next;
            l2 = l2->next;
        }
    }
    if (l1 == NULL)
    {
        l1 = l2;
    }
    head->next = l1;
    return returnHead;
}