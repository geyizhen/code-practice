/*
** Data     ：2018年12月19日15:59:09
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;
        RandomListNode cur = head;
        //复制节点
        while (cur != null){
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        //链接random指针
        cur = head;
        while (cur != null){
            RandomListNode clone = cur.next;
            if (cur.random != null)
                clone.random = cur.random.next;
            cur = cur.next.next;
        }
        //奇偶拆分链表
        cur = head.next;
        RandomListNode clonehead = cur;//偶数位为复制链表
        while(cur.next != null){
            cur.next = cur.next.next;
            cur = cur.next;//跳到下一个偶数位
        }
        return clonehead;
    }
}