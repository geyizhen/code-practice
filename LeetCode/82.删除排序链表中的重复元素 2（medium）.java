/*
** Data     ：2018年12月19日22:12:45
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list.

For example,
Given1->2->3->3->4->4->5, return1->2->5.
Given1->1->1->2->3, return2->3.


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
        ListNode dummy = new ListNode (head.val - 1);
        dummy.next = head;
        ListNode cur = head;
        ListNode last = dummy;//
        while(cur != null && cur.next != null ){
            if (cur.val != cur.next.val){
                last = cur;
            }else{
                while(cur.next != null && cur.val == cur.next.val)
                    cur = cur.next;
                last.next = cur.next;//此步可以跳过重复的所有数字
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}