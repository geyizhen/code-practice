/*
** Data     ：2018-12-6 21:13:27
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
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
import java.util.*;
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0)
            return null;
        int k = lists.size();
        ListNode newhead = lists.get(0);
        for(int i = 1; i < k; i ++){
            newhead = newmerge(newhead, lists.get(i));
        }
        return newhead;
    }
    private ListNode newmerge(ListNode L1, ListNode L2){
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while(L1 != null && L2 != null){
            if (L1.val < L2.val){
                pre.next = L1;
                L1 = L1.next;
                pre = pre.next;
            }else{
                pre.next = L2;
                L2 = L2.next;
                pre = pre.next;
            }
        }
        pre.next = L1 == null ? L2: L1;
        return dummy.next;
    }
}
