/*
** Data     ：2019-1-8 20:40:55
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
//思路：从后向前遍历，找到第一个前一位比后一位小的数，标记前一位为i，
//再从i+1遍历至结尾找到最后一个比i大的数记为j
//交换i，j 再将i+1到末位翻转即可
public class Solution {
    public void nextPermutation(int[] num) {
        int len = num.length;
        if (num == null || len == 0)
            return;
        int i = len - 2;
        while(i >= 0 && num[i] >= num[i + 1])
            i --;
        if (i >= 0){
            int j = i + 1;
            while (j <= len - 1 && num[j] > num[i])
                j ++;
            j--;
            swap(num, i, j);
        }
        reserve(num, i + 1, len - 1);
    }
    public void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    public void reserve(int[] num, int i, int j){
        while(i < j)
            swap(num, i++, j--);
    }
}