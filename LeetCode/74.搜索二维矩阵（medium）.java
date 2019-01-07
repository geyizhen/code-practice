/*
** Data     ：2018-12-6 21:13:27
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true
*/
//思路：从右上角开始搜索，如果数值相等则返回true，如果target小于元素值，则左移，如果target大于元素值，则下移
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int r = 0;
        int c = col - 1;
        while(r < row && c >= 0){
            if (target == matrix[r][c])
                return true;
            if (target > matrix[r][c]){
                r++;
            }else{
                c--;
            }
        }
        return false;
    }
}