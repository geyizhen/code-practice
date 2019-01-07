/*
** Data     ：2018-12-27 10:27:33
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len - 1] += 1;//将1加至末位
        int carry = 0;//创建进位
        for (int i = len - 1; i >= 0; i--){
            digits[i] = digits[i] + carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        int[] res = new int[len + 1];
        if (carry == 0){
            return digits;//如果最高位无进位则直接返回即可
        }else if (carry == 1){//若最高位有进位，则需要重新声明一个数组，位数比之前多一位，且第一位为1，后面全为0
            res[0] = 1;
            for (int i = 1; i < res.length; i++){
                res[i] = digits[i - 1];
            }
        }
        return res;
    }
}