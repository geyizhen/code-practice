/*
** Data     ：2018-12-6 21:13:27
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]
进阶：

你可以优化你的算法到 O(k) 空间复杂度吗？
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();//创建一个新的数组
        result.add(1);//第一个元素为1
        for(int i = 1; i < rowIndex + 1; i++){//开始循环生成每一行
            for(int j = i - 1; j > 0; j--){//从高位到低位循环复用了空间
                int temp = result.get(j) + result.get(j - 1);
                result.set(j, temp);//将两数之和添加到数组中
            }
            result.add(1);//添加每一行的最后一个元素1
        }
        return result;
    }
}