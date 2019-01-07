/*
** Data     ：2018-12-6 21:13:27
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given1->2->3->4, you should return the list as2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode first  = new ListNode (-1);
        first.next = head;
        ListNode pre = first;
        ListNode cur = head;
        ListNode temp = head;
        while (cur != null && cur.next != null){//保证cur此时不为空且下一个不为空
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;//到此为正常的链表反转
            pre = cur;
            cur = cur.next;
        }
        return first.next;
        
    }
}