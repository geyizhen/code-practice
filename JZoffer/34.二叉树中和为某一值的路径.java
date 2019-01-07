import java.util.ArrayList;
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
public class Solution {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<Integer> path = new ArrayList<>();
        backtracking(root, target, path);
        return ret;
    }
    
    private void backtracking(TreeNode root, int target, ArrayList<Integer> path){
        if (root == null)
            return;
        path.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            ret.add(new ArrayList<>(path));
            //此处写ret.add(path)是错误
            //如果直接ret.add（path）那么ret的每一次add最终都指向同一个path对象
            //也就是说，虽然当前保存的是对的path对象，但之后这个path对象会被后续的递归修改
            //到最后的时候，得到的是空path，因此需要new一个path来保存当前对象的状态
            //ret.add((ArrayList<Integer>)path.clone());   是可以的
            //
        }else{
            backtracking(root.left, target, path);
            backtracking(root.right, target, path);
        }
        path.remove(path.size() - 1);
        //回溯法，当走到叶节点时，需要把数组中最后一个值去掉才能回到父节点以便添加另外的叶节点
            
    }
}