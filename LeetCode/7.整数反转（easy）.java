/*
** Data     ：2019-1-17 10:17:22
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
*/
/*//本体关键点是如何判断溢出。
//推荐解答用的是用long类型存储结果，如果结果大于0x7fffffff或者小于0x80000000就溢出
//我的解法是每次计算新的结果时，再用逆运算判断与上一次循环的结果是否相同，不同就溢出
*/
public class Solution {
    public int reverse(int x) {
        int cur = 0;
        int flag;//标记正负号
        if(x < 0){
            flag = -1;
            x = -x;
        }else
            flag = 1;
        while(x != 0){
            int tail = x % 10;//取最后一位
            int res = cur * 10 + tail;
            
            if(res / 10 != cur)//通过逆运算判断与上一次运算结果是否相同，不同则溢出
                return 0;
            cur = res;
            x /= 10;
        }
        return cur * flag;
    }
}