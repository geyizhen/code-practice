/*
** Data     ：2018-12-6 21:13:27
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
对链表进行插入排序。
插入排序算法：

插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。
 

示例 1：

输入: 4->2->1->3
输出: 1->2->3->4
示例 2：

输入: -1->5->3->4->0
输出: -1->0->3->4->5
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
//构建一个新的链表进行插入排序操作
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode (0);//构建虚拟节点
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            ListNode nextnode = cur.next;
            pre = dummy;
            while(pre.next != null && pre.next.val < cur.val){
                pre = pre.next;//找到要插入处的前一个节点
            }
            cur.next = pre.next;//进行插入节点操作
            pre.next = cur;
            cur = nextnode;
        }
        return dummy.next;
    }
}