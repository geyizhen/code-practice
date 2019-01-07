/*
** Data     ：2018-12-6 21:13:27
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
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
    public TreeNode sortedArrayToBST(int[] num) {
        return toBST(num, 0, num.length - 1);
    }
    private TreeNode toBST(int[] num, int start, int end){
        if (start > end)
            return null;
        int mid = (start + end + 1)/2;//这里+1或者不加都行，不加的话有一个测试通不过
                                      //[1,3],不加的话为[1,*,3],加的话为[3,1]，其实我感觉都一样
        TreeNode root = new TreeNode (num[mid]);
        root.left = toBST(num, start, mid - 1);
        root.right = toBST(num, mid + 1, end);
        return root;
    }
}