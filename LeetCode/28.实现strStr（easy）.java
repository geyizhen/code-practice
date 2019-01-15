/*
** Data     ：2019-1-14 11:28:17
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
*/
public class Solution {
    public String strStr(String haystack, String needle) {
        int len1 = haystack.length();//主串长度
        int len2 = needle.length();//模式串长度
        if(len2 == 0)
            return haystack;
        for(int i = 0; i < len1; i++){
            if(len1 - i + 1 < len2)//当主串剩余长度小于模式串长度时，返回null
                return null;
            int k = i;
            int j = 0;
            while(k < len1 && j < len2 && needle.charAt(j) == haystack.charAt(k)){
                //主串字符与模式串字符一一判断
                j ++;
                k ++;
                if(j == len2)
                    return haystack.substring(i);//返回相同字符串
            }
        }
        return null;
    }
}