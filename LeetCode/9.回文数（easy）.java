/*
** Data     ：2019-1-9 11:14:43
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
*/
//复制这个数，通过不断地取余，还原这个数，如果一样则为回文数
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int t = x;
        int temp = 0;
        while(t != 0){
            temp = 10 * temp + t % 10;
            t = t / 10;
        }
        return temp == x;
    }
}