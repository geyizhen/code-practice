/*
** Data     ：2019-1-21 21:06:52
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。

示例 1:

输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出: true
示例 2:

输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
输出: false
*/
//这题感觉有点难，需要纸上推一推
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null)
            return false;
        if(s1.length() + s2.length() != s3.length())
            return false;
        if(s3.length() == 0)
            return true;
        if(s1.length() == 0)
            return s2.equals(s3);
        if(s2.length() == 0)
            return s1.equals(s3);
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        for(int i = 0; i <= len1; i++){
            for(int j = 0; j <= len2; j++){
                if(i == 0 && j == 0)
                    dp[i][j] = true;
                else if(i == 0)
                    dp[i][j] = dp[i][j - 1] && (s3.charAt(i + j - 1) == s2.charAt(j - 1));
                else if(j == 0)
                    dp[i][j] = dp[i - 1][j] && (s3.charAt(i + j - 1) == s1.charAt(i - 1));
                else{
                    dp[i][j] = (dp[i][j - 1] && (s3.charAt(i + j - 1) == s2.charAt(j - 1))) ||
                        (dp[i - 1][j] && (s3.charAt(i + j - 1) == s1.charAt(i - 1)));
                }
            }
        }
        return dp[len1][len2];
    }
}