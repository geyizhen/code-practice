/*
** Data     ：2019-1-21 20:10:58
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。

一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

示例 1:

输入: S = "rabbbit", T = "rabbit"
输出: 3
解释:

如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
(上箭头符号 ^ 表示选取的字母)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
示例 2:

输入: S = "babgbag", T = "bag"
输出: 5
解释:

如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 
(上箭头符号 ^ 表示选取的字母)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
*/
/*
rabbbit rabbit
    0   r   a   b   b   b   i   t
0   1   1   1   1   1   1   1   1
r   0   1   1   1   1   1   1   1
a   0   0   1   1   1   1   1   1
b   0   0   0   1   2   3   3   3
b   0   0   0   1   2   3   3   3   
i   0   0   0   0   0   0   3   3
t   0   0   0   0   0   0   0   3

babgbag bag
    0   b   a   b   g   b   a   g
0   1   1   1   1   1   1   1   1
b   0   1   1   2   2   3   3   3
a   0   0   1   1   1   1   4   4
g   0   0   0   0   1   1   1   5
*/
public class Solution {
    public int numDistinct(String S, String T) {
        if(S.length() == 0 || T.length() == 0 || S == null || T == null)
            return 0;
        int slen = S.length();
        int tlen = T.length();
        int[][] dp = new int[tlen + 1][slen + 1];
        for(int i = 0; i <= slen; i ++)
            dp[0][i] = 1;
        for(int j = 1; j <= tlen; j ++)
            dp[j][0] = 0;
        for(int j = 1; j <= tlen; j ++){
            for(int i = 1; i <= slen; i ++){
                dp[j][i] = dp[j][i - 1];
                if(S.charAt(i - 1) == T.charAt(j - 1))
                    dp[j][i] += dp[j - 1][i - 1];
            }
        }
        return dp[tlen][slen];
    }
}