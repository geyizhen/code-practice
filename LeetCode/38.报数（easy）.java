/*
** Data     ：2019-1-11 14:55:42
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。

示例 1:

输入: 1
输出: "1"
示例 2:

输入: 4
输出: "1211"
*/
public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        if(n == 1)
            return result;//当n为1时，直接输出
        for(int i = 1; i < n; i++){//重复计算n - 1次
            result = oncecount(result);
        }
        return result;
    }
    public String oncecount(String prev){
        StringBuilder res = new StringBuilder();
        int count = 1;
        char c = prev.charAt(0);
        int len = prev.length();
        for(int i = 1; i < len; i++){
            if(prev.charAt(i) == c){
                count ++;
                continue;//当出现重复字符时，数量+1，同时跳过下列步骤
            }
            res.append(count);
            res.append(c);
            c = prev.charAt(i);
            count = 1;
        }
        //当结束for循环时最后一个字符和它的数量都没有添加至字符串末尾
        res.append(count);
        res.append(c);
        return new String(res);
    }
}