/*
** Data     ：2019-1-10 10:59:55
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"
*/
//思路：创建StringBuilder字符串，从后往前按位进行计算，最后再将字符串翻转

/*tips：String：适用于少量的字符串操作的情况
　　    StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
　　    StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况
*/
 
public class Solution {
    public String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        int carry = 0;
        StringBuilder str = new StringBuilder();
        while(carry == 1 || m >= 0 || n >= 0){
            if(m >= 0 && a.charAt(m --) == '1')
                carry ++;
            if(n >= 0 && b.charAt(n --) == '1')
                carry ++;
            str.append(carry % 2);
            carry /= 2;
        }
        return str.reverse().toString();
    }
}