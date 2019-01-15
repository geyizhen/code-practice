/*
** Data     ：2019-1-15 20:33:28
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
*/
public class Solution {
    private int maxlen, left;
    
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2)
            return s;
        for(int i = 0; i < s.length() - 1; i ++){
            //考虑两种情况，中间是bb，或者是bab
            palindromic(s, i, i);
            palindromic(s, i, i + 1);
        }
        return s.substring(left, left + maxlen);
    }
    
    private void palindromic(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i --;
            j ++;
        }
        if(maxlen < j - i - 1){
            maxlen = j - i - 1;//将最大回文子串的长度保存到maxlen
            left = i + 1;
        }
        
    }
}