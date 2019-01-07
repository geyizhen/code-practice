/*
** Data     ：2018年12月19日21:12:48
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given1->2->3->4->5->NULL, m = 2 and n = 4,

return1->4->3->2->5->NULL.

Note: 
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null)
            return head;
        //设置相关辅助节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start = head;
        for (int i = 1; i < m; i++){
            pre = start;
            start = start.next;
        }

        for (int i = 0; i < n - m; i++){//这里的链表翻转和链表完全翻转有所区别，是按照顺序一个个颠倒顺序，有点冒泡排序的感觉
            ListNode temp = start.next;
            start.next = temp.next;
            temp.next = pre.next;//这里只能是pre.next而不能是start是因为start一直是未变的，而pre.next一直在变，符合我们的要求
            pre.next = temp;
        }
        //本题1 2 3 4 5， m=2,n=4
        //循环一次:1 3 2 4 5
        //循环两次:1 4 3 2 5  这一步 3 2 作为一个整体后移
        return dummy.next;
    }
}