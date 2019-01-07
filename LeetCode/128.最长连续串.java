/*
** Data     ：2018-12-25 21:39:04
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/

/*
qusetion describe:
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given[100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
*/
//解法一：未考虑时间复杂度
/*
import java.util.*;
public class Solution {
    public int longestConsecutive(int[] num) {
        int n = num.length;
        if (n <= 1)
            return n;
        Arrays.sort(num);//将数组排序
        int cur = 1;
        int length = 0;
        for (int i = 1; i < num.length; i++){
            if (num[i] == num [i - 1])//此题如果有重复的数字不会对连续数字串造成影响，如0,1,1,2则返回3
                continue;
            if (num[i] - num[i - 1] == 1){
                cur ++;
            }else{
                if (cur > length){
                    length = cur;
                }
                cur = 1;
            }
        }
        if (cur > length)
            length = cur;
        return length;
    }
}*/
//方法二：时间复杂度为O(n)
import java.util.*;
public class Solution {
    public int longestConsecutive(int[] num) {
        Map<Integer, Integer> countForNum = new HashMap<>();//创建hashmap
        for (int n : num){
            countForNum.put(n, 1);
        }
        for (int n : num){
            forward(countForNum, n);
        }
        return MaxCount(countForNum);
    }
    //此函数计算num中的元素他后面连续自然数的个数，hashmap中key值为num，value为连续自然数的个数
    //此处采用递归求解
    private int forward(Map<Integer, Integer> countForNum, int num){
        if (!countForNum.containsKey(num))
            return 0;
        int cnt = countForNum.get(num);
        if (cnt > 1){
            return cnt;
        }
        cnt = forward(countForNum, num + 1) + 1;//判断是否有比该num大1的自然数存在
        countForNum.put(num, cnt);//Hashmap.put函数直接覆盖key值的Value，所以最后只需要遍历hashmap中的value即可
        return cnt;
    }
    //遍历hashmap的value值，最大即为所求
    private int MaxCount(Map<Integer, Integer> countForNum){
        int max = 0;
        for (int n : countForNum.keySet()){
            max = Math.max(max, countForNum.get(n));
        }
        return max;
    }
}