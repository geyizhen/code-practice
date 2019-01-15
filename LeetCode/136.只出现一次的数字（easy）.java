/*
** Data     ：2019-1-15 21:03:57
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4
*/
public class Solution {
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        int result = A[0];
        for(int i = 1; i < A.length; i ++)
            result ^= A[i];//使用异或遍历所有的元素
        return result;
    }
}