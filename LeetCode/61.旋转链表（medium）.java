/*
** Data     ：2018年12月20日14:40:32
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given1->2->3->4->5->NULLand k =2,
return4->5->1->2->3->NULL.
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
//解题思路：统计出节点个数num，将链表首尾相连，再从第num-n%num处断开
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null)
            return head;
        ListNode cur = head;
        ListNode newhead = cur;
        int num = 1;
        for (; cur.next != null; num++){
            cur = cur.next;
        }
        cur.next = head;
        num = num - (n % num);
        for (int i = 0; i < num; i++){
            cur = cur.next;
        }
        newhead = cur.next;
            
        cur.next = null;
        return newhead;
    }
}