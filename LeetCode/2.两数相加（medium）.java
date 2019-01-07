/*
** Data     ：2018-12-24 20:25:20
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;//若其中某链表为空，则直接返回另一个
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        int temp = 0;
        while(l1 != null || l2 != null || temp != 0){
            if (l1 != null){
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                temp += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode (temp % 10);//本位保留除10的余位
            p = p.next;
            temp /= 10;//计算出进位保留到下一个节点
        }
        return dummy.next;
    }
}