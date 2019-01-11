/*
** Data     ：2019-1-10 11:25:34
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指由字母组成，但不包含任何空格的字符串。

示例:

输入: "Hello World"
输出: 5
*/
public class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int count = 0;
        if(len == 0)
            return 0;
        while(len > 0){//从后往前遍历
            if(s.charAt(len - 1) != ' '){
                count ++;
            }else{//直到找到空格为止
                if(count != 0)//忽略掉最后一个字符为空格的特殊情况
                    break;
            }
            len --;
        }
        return count;
    }
}