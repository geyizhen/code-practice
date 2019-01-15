/*
** Data     ：2019-1-15 20:54:24
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/
/*思路：
    "滑动窗口" 
    比方说 abcabccc 当你右边扫描到abca的时候你得把第一个a删掉得到bca，
    然后"窗口"继续向右滑动，每当加到一个新char的时候，左边检查有无重复的char，
    然后如果没有重复的就正常添加，
    有重复的话就左边扔掉一部分（从最左到重复char这段扔掉），在这个过程中记录最大窗口长度
*/
import java.util.HashMap;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        //使用HashMap存放已遍历的字符
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;//记录窗口的左侧起点
        int maxlen = 0;//记录最大的滑动窗口值
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            left = Math.max(left, (map.containsKey(c))? map.get(c) + 1: 0);
            maxlen = Math.max(maxlen, i - left + 1);
            map.put(c, i);//更新HashMap
        }
        return maxlen;
    }
}