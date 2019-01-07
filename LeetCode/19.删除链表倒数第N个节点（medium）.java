/*
** Data     ：2018-12-24 19:48:27
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
Given a linked list, remove the n th node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note: 
Given n will always be valid.
Try to do this in one pass.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null)
            return null;
        ListNode dummy = new ListNode(head.val - 1);
        ListNode pre = dummy;
        ListNode cur = head;
        dummy.next = head;
        int num = 1;
        while(cur.next != null){
            num++;
            cur = cur.next;
        }
        num = num - n + 1;
        for (int i = 1; i < num; i ++){
            pre = pre.next;//找到该节点前一个节点
        }
        pre.next = pre.next.next;//将next直接置为下下一个
        return dummy.next;
    }
}