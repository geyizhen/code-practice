/*
** Data     ：2019-1-17 16:13:44
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/
//解法类似   15.三数之和
//只是增添了一层循环和判断
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int start = 0; start < num.length - 3; start ++){
            if(start != 0 && num[start] == num[start - 1])
                continue;
            for(int i = start + 1; i < num.length - 2; i++){
                if(i != start + 1 && num[i] == num[i - 1])
                    continue;
                int j = i + 1;
                int k = num.length - 1;
                while(j < k){
                    if(num[start] + num[i] + num[j] + num[k] == target){
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[start]);
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        result.add(list);
                        j++;
                        k--;
                        while(j < k && num[j] == num[j - 1])
                            j++;
                        while(j < k && num[k] == num[k + 1])
                            k--;
                    }else if(num[start] + num[i] + num[j] + num[k] < target){
                        j++;
                    }else{
                        k--;
                    }
                }
            }
        }
        return result;
    }
}