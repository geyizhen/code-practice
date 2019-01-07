/*
** Data     ：2018年12月20日10:36:07
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
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
//分别遍历两个链表，进行比较后取小值添加至新链表中
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newhead = new ListNode(0);
        ListNode temp = newhead;
        while (cur1 != null && cur2 != null){
            if (cur1.val < cur2.val){
                temp.next = cur1;
                temp = temp.next;
                cur1 = cur1.next;
            }else{
                temp.next = cur2;
                temp = temp.next;
                cur2 = cur2.next;
            }
        }
        temp.next = cur1 == null? cur2 : cur1;
        return newhead.next;
    }
}