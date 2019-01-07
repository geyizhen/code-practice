/*
** Data     ：2018-12-27 16:19:25
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0)
            return res;
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;
        while(top <= bottom && left <= right){
            //右移
            for (int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            //下移
            for (int j = top + 1; j <= bottom; j++){
                res.add(matrix[j][right]);
            }
            //左移
            if (top != bottom)
                for (int i = right - 1; i >= left; i--){
                    res.add(matrix[bottom][i]);
                }
            //上移
            if (left != right)
                for (int j = bottom - 1; j >= top + 1; j --){
                    res.add(matrix[j][left]);
                    }
            top ++;
            right --;
            bottom --;
            left ++;
        }
        return res;
    }
}