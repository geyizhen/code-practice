/*
** Data     ：2019-1-15 22:18:35
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
*/
//思路：将strs按照ASIIC码排序，只需要比较首尾两个字符串即可
import java.util.Arrays;
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null) return null;
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];//声明异常情况
        Arrays.sort(strs);//对字符串数组进行排序
        int len = strs.length;
        int n = Math.min(strs[0].length(), strs[len - 1].length());
        int count = 0;
        for(int i = 0; i < n; i++){
            if(strs[0].charAt(i) == strs[len - 1].charAt(i))
                count ++;
            else break;//当字符不一样时立即跳出
        }
        return strs[0].substring(0, count);
    }
}