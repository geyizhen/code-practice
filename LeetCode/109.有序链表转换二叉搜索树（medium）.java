/*
** Data     ：2018年12月19日18:36:08
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode (head.val);
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        ListNode mid = null;
        while (fast != null && fast.next != null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        mid = slow;
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(mid.next);
        root.left = sortedListToBST(head);
        
        return root;
    }
}