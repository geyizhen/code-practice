/*
** Data     ：2018年12月18日21:06:58
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/

/*
question describe ： 
Sort a linked list in O(n log n) time using constant space complexity.
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

 //tip：使用归并排序
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);//取链表中点
        ListNode midNext = mid.next;
        mid.next = null;//断开链表
        return mergeSort(sortList(head), sortList(midNext));
        
    }
    private ListNode getMid(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode quick = head;
        while(quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;//慢节点走一步，快节点走两步，最终慢节点的值为链表中点
        }
        return slow;
    }
    private ListNode mergeSort(ListNode n1, ListNode n2){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode node1 = n1;
        ListNode node2 = n2;
        while(node1 != null && node2 != null){
            if(node1.val < node2.val){
                cur.next = node1;
                node1 = node1.next;
            }else{
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        cur.next = (node1 == null)? node2: node1;
        return head.next;
    }
}