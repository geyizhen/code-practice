/*
** Data     ：2019-1-14 16:19:04
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G
*/
public class Solution {
    public String convert(String s, int nRows) {
        if(s.length() == 0 || s == null || nRows <= 1)
            return s;//返回特殊情况
        StringBuffer[] sb = new StringBuffer[nRows];
        for(int i = 0; i < sb.length; i++)
            sb[i] = new StringBuffer();
        
        int len = s.length();
        int i = 0;
        while(i < len){
            //从上到下
            for(int j = 0; j < nRows && i < len; j++)
                sb[j].append(s.charAt(i++));
            //从下到上
            for(int j = nRows - 2; j > 0 && i < len; j--)
                sb[j].append(s.charAt(i++));
        }
        for(int j = 1; j < nRows; j++){
            sb[0].append(sb[j]);//将各个字符串合并
        }
        return sb[0].toString();
    }
}