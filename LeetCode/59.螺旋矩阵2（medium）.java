/*
** Data     ：2018-12-27 16:53:41
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        int t = 1;//给元素赋值的序号
        int right = n - 1, bottom = n - 1;
        int top = 0, left = 0;
        while(left <= right && top <= bottom){//限定循环条件
            for (int i = left; i <= right; i++)
                res[top][i] = t ++;
            for (int j = top + 1; j <= bottom; j++)
                res[j][right] = t ++;
            if (left != right)
                for (int i = right - 1; i >= left; i--)
                    res[bottom][i] = t ++;
            if (top != bottom)
                for (int j = bottom - 1; j >= top + 1; j--)//注意这里是 bottom-1和top+1，因为旋转到最左边的时候上下两个元素都已经被赋值了
                    res[j][left] = t++;
            top ++;
            bottom --;
            left ++;
            right --;
        }
        return res;
        
    }
}