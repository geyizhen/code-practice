/*
** Data     ：2018-12-6 21:13:27
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

*/
//思路：本题使用Hashmap，key值为排序后的字符串，value值为排序后字符串相同的字符串数组
import java.util.*;
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            String key = sortString(s);//对字符串排序
            if(!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(s);//将易位词存放在排序后key值相同的value值中
        }
        for(String s : map.keySet()){
            ArrayList<String> list = map.get(s);
            if(list.size() > 1)//当存在易位词时
                result.addAll(list);
        }
        return result;
    }
    //对字符串进行排序
    private String sortString(String s){
        char[] str = s.toCharArray();
        Arrays.sort(str);
        return new String(str);
    }
}