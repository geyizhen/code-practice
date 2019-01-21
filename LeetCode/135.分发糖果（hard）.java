/*
** Data     ：2019-1-21 16:21:26
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。

你需要按照以下要求，帮助老师给这些孩子分发糖果：

每个孩子至少分配到 1 个糖果。
相邻的孩子中，评分高的孩子必须获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？

示例 1:

输入: [1,0,2]
输出: 5
解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
示例 2:

输入: [1,2,2]
输出: 4
解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
*/
import java.util.Arrays;
public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int sum = 0;
        if(len == 0 || ratings == null)
            return len;
        int[] count = new int[len];
        Arrays.fill(count, 1);//初始状态，每个孩子一个糖果
        //for(int i = 0; i < len; i++)
        //    count[i] = 1;
        for(int j = 1; j < len; j++){
            if(ratings[j] > ratings[j - 1])
                count[j] = count[j - 1] + 1;
        }//一次遍历，更改后面的比较数
        for(int k = len - 1; k > 0; k--){
            if(ratings[k - 1] > ratings[k] && count[k - 1] <= count[k])
                count[k - 1] = count[k] + 1;
            sum += count[k];
        }//二次遍历，更改前面的比较数
        //for(int i = 0; i < len; i++)
        //    sum += count[i];
        return sum + count[0];
    }
}