/*
** Data     ：2019-1-8 21:55:57
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
*/
import java.util.Arrays;
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);//将数组排序
        int len = num.length;
        int sum = 0;
        int diff = Math.abs(num[0] + num[1] + num[len - 1] - target);
        int res = num[0] + num[1] + num[len - 1];
        if (len < 3)
            return 0;
        for (int i = 0; i < len - 2; i++){
            int start = i + 1;
            int end = len - 1;
            while(start < end){
                sum = num[i] + num[start] + num[end];
                if (Math.abs(sum - target) < diff){
                    diff = Math.abs(sum - target);
                    res = sum;
                    }
                if (sum > target){
                    end --;//若比target大，则末位向前一位
                }else{
                    start ++;//若比target小，则前位向后移位
                }
            }
        }
        return res;
    }
}