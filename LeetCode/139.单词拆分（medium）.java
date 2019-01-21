/*
** Data     ：2019-1-21 15:18:14
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
*/
//状态转移方程：
//f(i)表示s[0,i]是否可以分词
import java.util.*;
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] array = new boolean[len + 1];
        array[0] = true;
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < i; j++)
                if(array[j] == true && dict.contains(s.substring(j, i)))
                //从上一个true开始到当前位置，如果包含字典里的词，则将该位置置为true
                    array[i] = true;
        }
        return array[len];
    }
}