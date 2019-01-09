/*
** Data     ：2018-12-6 21:13:27
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();//最终输出的数组链表
        ArrayList<Integer> last = new ArrayList<>();//上一层数组链表
        if(numRows < 1)
            return result;
        for(int n = 0; n < numRows; n++){
            ArrayList<Integer> res = new ArrayList<>();
            
            if(n > 1)
                last = result.get(n - 1);
            for(int i = 0; i <= n; i++){
                if(i == 0 || i == n){//每一层的首尾都为1
                    res.add(1);
                }else{
                    res.add(last.get(i - 1) + last.get(i));//除了首尾其他的节点由上层计算得出
                }
            }
            result.add(res);//将每一层结果添加到最终的链表数组中
        }
        return result;
        
    }
}