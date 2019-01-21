/*
** Data     ：2018-12-6 21:13:27
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
*/
//从倒数第二行开始，算出后两行所有路径的可能性
//（比如倒数第二行的元素有两个路径可以选择，保存较小的那个值保留在原位置）
//这样一直遍历到第一行即可
import java.util.ArrayList;
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i + 1).size() - 1; j++){
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
                //set(int index, E element)函数为将index处的值换为element
            }
        }
        return triangle.get(0).get(0);
    }
}