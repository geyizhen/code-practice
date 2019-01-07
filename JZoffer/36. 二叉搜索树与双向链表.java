/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
/*思考：left为一直遍历到最左边的节点，即头结点
       right为所有右节点
*/
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null)
            return pRootOfTree;
        //将左子树构造成双链表
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        //定位至左子树双链表最后一个节点
        while(p != null && p.right != null){
            p = p.right;
        }
        //若左链表不为空，则将其与根节点相连
        if (left != null){
            p.right = pRootOfTree;
            pRootOfTree.left = p; 
        }
        //将右子树构造成双链表，并返回链表头结点
        TreeNode right = Convert(pRootOfTree.right);
        //若右子树链表不为空，将该链表加至根节点之后
        if (right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null? left: pRootOfTree;
    }
}