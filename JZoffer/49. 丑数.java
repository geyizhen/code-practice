//把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
//例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。习惯上我们把 1 当做是第一个丑数。
//求按从小到大的顺序的第 N 个丑数。



public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 6)
            return index;
        int i2 = 0, i3 = 0, i5 = 0;
        int num [] = new int[index];
        num [0] = 1;
        for (int i = 1; i < index; i++){
            int next2 = num[i2] * 2;
            int next3 = num[i3] * 3;
            int next5 = num[i5] * 5;
            num[i] = Math.min(next2, Math.min(next3, next5));
            if (num[i] == next2)
                i2++;
            if (num[i] == next3)//此处和下面不能加else，如果num[i]既为next2又为next3，则i2和i3都要加1
                i3++;
            if (num[i] == next5)
                i5++;
        }
        return num[index - 1];
    }
}