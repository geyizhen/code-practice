/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
/*整体思路：将链表每一个节点对应的复制，再建立复制节点的random连接
  最后再将链表拆分成两个相等的链表
*/


public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null)
            return null;
        RandomListNode cur = pHead;
        //插入新节点
        while (cur != null){
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        //建立random连接
        cur = pHead;
        while(cur != null){
            RandomListNode clone = cur.next;
            if(cur.random != null)
                clone.random = cur.random.next;
            cur = cur.next.next;
        }
        //拆分，将奇数次序的和偶数次序的分别连起来
        cur = pHead;
        RandomListNode CloneHead = pHead.next;
        while(cur.next != null){
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return CloneHead;
    }
}