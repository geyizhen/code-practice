/*
** Data     ：2019-1-17 11:19:55
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:

输入: n = 3, k = 3
输出: "213"
示例 2:

输入: n = 4, k = 9
输出: "2314"
*/
import java.util.*;
public class Solution {
    public String getPermutation(int n, int k) {
        
        k --;//从0开始
        List<Integer> list = new ArrayList<Integer>();
        int factorial = 1;//阶乘因子
        for(int i = 2; i < n; i++)
            factorial *= i;//计算n - 1的阶乘数，因为k永远到不了n的阶乘
        for(int i = 1; i <= n; i++)
            list.add(i);//list集为可以用的数字集
        StringBuilder res = new StringBuilder();
        int times = n - 1;//次数，0到n - 1可以循环n次
        while(times >= 0){
            int index = k / factorial;
            res.append(list.get(index));//将对应的数字添加至字符串
            list.remove(index);//删除该用过的数字
            
            k %= factorial;//取余
            if(times != 0)//当times为0的时候要避开，除数不能为0
                factorial = factorial / times;
            times--;//次数减1
        }
        return res.toString();
    }
}