/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/


//设 A 的长度为a+c，B的长度为b+c，其中c为尾部公共部分长度，可知a+c+b=b+c+a。
//对A进行遍历到链表尾部之后对B进行遍历；另一个指针对B进行遍历到尾部后对A进行遍历，
//当他们相遇即 == 的时候，一定是在公共节点

//类似追及问题

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while(l1 != l2){
            l1 = (l1 == null)? pHead2 : l1.next;
            l2 = (l2 == null)? pHead1 : l2.next;
        }
        
        return l1;
        
        
 
    }
}