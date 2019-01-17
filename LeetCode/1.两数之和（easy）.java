/*
** Data     ：2019-1-17 15:00:41
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
*/
//构造hashmap，将target - number[i]的值作为key，将i的值作为value
//遍历到一个新的数只需要判断map.containsKey是否存在即可
import java.util.*;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        int len = numbers.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < len; i++){
            if(map.containsKey(numbers[i])){
                index[0] = map.get(numbers[i]) + 1;//注意返回的index要加1
                index[1] = i + 1;
                break;
            }else{
                map.put(target - numbers[i], i);
            }
        }
        return index;
    }
}