/*
** Data     ：2019-1-17 15:44:19
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length - 2; i++){
            if(i != 0 && num[i] == num[i - 1])//如果元素重复则跳过
                continue;
            int j = i + 1;
            int k = num.length - 1;
            while(j < k){
                if(num[i] + num[j] + num[k] == 0){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    result.add(list);//
                    j ++;
                    k --;//成功了之后将j和k分别向前向后移位
                    while(j < k && num[j] == num[j - 1])//避免j位和j-1位重复
                        j++;
                    while(j < k && num[k] == num[k + 1])//避免k位和k+1位重复
                        k--;
                }else if(num[i] + num[j] + num[k] < 0){//和小于0时，j向右移一位
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }
}