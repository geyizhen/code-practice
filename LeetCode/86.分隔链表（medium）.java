/*
** Data     ：2018年12月19日21:27:45
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given1->4->3->2->5->2and x = 3,
return1->2->2->4->3->5.
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
//思路：创建两个链表，分别把比x小的节点和其他节点链接到两个链表上
//然后再把两个链表连起来
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;
        ListNode lesshead = new ListNode (0);//创建小链表
        ListNode morehead = new ListNode (0);//创建大链表
        ListNode temp = head;
        ListNode cur1 = lesshead;
        ListNode cur2 = morehead;
        while (temp != null){
            if (temp.val < x){
                cur1.next = temp;
                cur1 = cur1.next;
            }else{
                cur2.next = temp;
                cur2 = cur2.next;
            }
            temp = temp.next;
        }
        cur1.next = morehead.next;//连接两个链表
        cur2.next = null;
        return lesshead.next;
    }
}