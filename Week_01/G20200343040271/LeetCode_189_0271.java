//189. 旋转数组
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
//示例 1:
//    输入: [1,2,3,4,5,6,7] 和 k = 3
//    输出: [5,6,7,1,2,3,4]
//解释:
//    向右旋转 1 步: [7,1,2,3,4,5,6]
//    向右旋转 2 步: [6,7,1,2,3,4,5]
//    向右旋转 3 步: [5,6,7,1,2,3,4]
//示例 2:
//    输入: [-1,-100,3,99] 和 k = 2
//    输出: [3,99,-1,-100]
//解释:
//    向右旋转 1 步: [99,-1,-100,3]
//    向右旋转 2 步: [3,99,-1,-100]
//说明:
//    尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
//    要求使用空间复杂度为 O(1) 的 原地 算法。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/rotate-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


public class MergeTwoSortedLists {
    public static void main(String[] args) {
        
        new MergeTwoSortedLists().mergeTwoLists2();
    }


    // 递归操作
    // 每次找当前两个链表中最小的数，依次将最小值链接
    // 时间复杂度：O(n + m) 空间复杂度：O(n + m)O(n+m)
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        if(l1.val < l2.val){
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists3(l1,l2.next);
            return l2;
        }

    }

    // 双指针，开辟一个新的链表，时间复杂度O(n),空间复杂度O(n)
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null && l2 != null){
            return l2;
        }
        if(l2 == null && l1 != null){
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode result =  head;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                result.next = l1;
                l1 = l1.next;
            }else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }

        result.next = l1 == null?l2:l1;
        return head.next;

        // 对比别人写的  result.next = l1 == null?l2:l1; 代码，
        // 再看看自己写的，有没有觉得很尴尬，特此留下，已做反思之用
//        if(l1 != null){
//            result.next = l1;
//            /*while (l1 != null){
//                result.val = l1.val;
//                l1 = l1.next;
//                result = result.next;
//            }*/
//        }
//        if(l2 != null){
//            /*while (l2 != null){
//                result.val = l2.val;
//                l2 = l2.next;
//                result = result.next;
//            }*/
//            result.next = l2;
//        }

    }

    // 暴力求解，开辟一个新的链表，循环l1,l2两个链表，依次将最小数据插入新链表中
    // 时间复杂度O(n^2),空间复杂度O(n)
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null && l2 != null){
            return l2;
        }
        if(l2 == null && l1 != null){
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode result =  head;
        while (l1 != null){
            while (l2 != null){
                if(l1.val <= l2.val){
                    result.next = l1;
                    l1 = l1.next;
                    result = result.next;
                    break;
                }else {
                    result.next = l2;
                    l2 = l2.next;
                    result = result.next;
                }
            }
        }
        return head.next;
    }


    // 放弃，后续研究，
    // 双指针，不开辟一个新的链表，将所有的数据移动l1链表上，
    // 时间复杂度O(n),空间复杂度O(1)
//    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
//        if(l1 == null && l2 == null){
//            return null;
//        }
//        if(l1 == null && l2 != null){
//            return l2;
//        }
//        if(l2 == null && l1 != null){
//            return l1;
//        }
//
//        while (l1 != null && l2 != null){
//            if(l1.val >= l2.val){
//                ListNode l1next = l1.next;
//                //ListNode l2node = l2;
//                ListNode l2next = l2.next;
//                l1.next = l2;
//                l2.next = l1next;
//                l2 = l2next;
//                l1 = l1next;
//            }else {
//
//                ListNode l1next = l1.next;
//                ListNode l2next = l2.next;
//
//                if(l1next.val >= l2.val){
//                    l1.next = l2;
//                    l2.next = l1next;
//                    l2 = l2next;
//                    l1 = l1next;
//                }else {
//                    l1 = l1.next;
//                }
//
//            }
//        }
//
//        if(l2 != null){
//            l1.next = l2;
//        }
////        if(l2 != null){
////            while (l2 != null){
////                l1.next = l2;
////               l2 = l2.next;
////            }
////        }
//        return l1;
//    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}