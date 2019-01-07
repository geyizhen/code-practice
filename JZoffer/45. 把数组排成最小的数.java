
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;//引入比较器的类

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        int n = numbers.length;
        String num [] = new String[n];
        for (int i = 0; i < n; i++){
            //num[i] = String.valueOf(numbers[i]);
            num[i] = numbers[i] + "";
        }
        Arrays.sort(num, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        // 可以看成是一个排序问题，在比较两个字符串 S1 和 S2 的大小时，
        // 应该比较的是 S1+S2 和 S2+S1 的大小，如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，
        // 否则应该把 S2 排在前面。
        // (o1, o2) -> (o1 + o2)为java8的lambda表达式特性，意为输入o1,o2，输出o1+o2
        // o1.compareTo(o2)  若o1<o2,则为-1;若o1=o2，则为0;若o1>o2，则为1.

        String ret = "";
        for(String str : num)
            ret += str;
        return ret;
        

    }
}
