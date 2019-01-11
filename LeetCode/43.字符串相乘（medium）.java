/*
** Data     ：2019-1-11 12:52:51
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
*/
//大数相乘
public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuilder sb = new StringBuilder();
        int[] temp = new int[n1 + n2];
        //每一位单独相乘之后进行想加但是不进位
        for(int i = n1 - 1; i >= 0; i--){
            for(int j = n2 - 1; j >= 0; j--)
                temp[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        }
        int carry = 0;
        //开始考虑进位
        for(int i = temp.length - 1; i >= 0; i--){
            temp[i] += carry;
            carry = temp[i]/10;
            temp[i] = temp[i]%10;
        }
        //输出字符串
        int left = 0;//忽略开头的0
        while(left < temp.length - 1 && temp[left] == 0)
            left ++;
        for(; left < temp.length; left ++)
            sb.append(temp[left]);
        return new String(sb);
    }
}