/*
** Data     ：2018年12月18日21:31:10
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
question describe:
Given a singly linked list L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:                L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes' values.
For example,
Given{1,2,3,4}, reorder it to{1,4,2,3}.
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        //设置快慢链表节点取到链表中点
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //断开链表，同时翻转后半段链表
        ListNode mid = slow.next;
        slow.next = null;
        ListNode pre = null;
        while(mid != null){
            ListNode temp = mid.next;
            mid.next = pre;
            pre = mid;
            mid = temp;
        }
        //合并链表
        ListNode first = head;
        mid = pre;
        while(first != null && mid != null){
            ListNode firsttemp = first.next;
            ListNode midtemp = mid.next;
            first.next = mid;
            first = firsttemp;
            mid.next = first;
            mid = midtemp;
        }
    }
}