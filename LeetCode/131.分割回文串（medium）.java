/*
** Data     ：2019-1-9 21:44:16
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例

输入 aab
输出
[
  [aa,b],
  [a,a,b]
]
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> partitions = new ArrayList<>();//最终输出的数组
        ArrayList<String> tempPartition = new ArrayList<>();//每一行的字符串数组
        doPartition(s, partitions, tempPartition);
        return partitions;
    }
    //进行分割的函数
    private void doPartition(String s, ArrayList<ArrayList<String>> partitions, ArrayList<String> tempPartition){
        if(s.length() == 0){//当读入的字符串长度为0时，则表明分割已经到了最后，即分割完成
            partitions.add(new ArrayList<>(tempPartition));//将临时字符串添加至最终输出的数组中
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(isPalindrome(s, 0, i)){
                tempPartition.add(s.substring(0, i + 1));//将前段已经判断为回文串的部分添加至临时字符串
                doPartition(s.substring(i + 1), partitions, tempPartition);//递归
                tempPartition.remove(tempPartition.size() - 1);//递归的结束以后删掉临时数组中的元素，在下一个for循环中重新使用
            }
        }
        
    }
    //判断字符串是否为回文串
    private boolean isPalindrome(String s, int begin, int end){
        while(begin < end){
            if(s.charAt(begin++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}