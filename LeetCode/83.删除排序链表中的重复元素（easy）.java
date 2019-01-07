/*
** Data     ：2018年12月19日21:40:51
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given1->1->2, return1->2.
Given1->1->2->3->3, return1->2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (cur.next != null){
            if (cur.next.val == cur.val){
                cur.next = cur.next.next;//若当前节点与后一节点重复，则当前节点的next直接与再后一个节点相连
            }else
                cur = cur.next;
        }
        return dummy.next;
    }
}