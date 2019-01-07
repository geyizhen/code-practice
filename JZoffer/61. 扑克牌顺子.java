//五张牌，其中大小鬼为癞子，牌面大小为 0。判断这五张牌是否能组成顺子。

import java.util.Arrays;
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length != 5)//确定为五张牌
            return false;
        int cnt = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == 0)
                cnt++;//计算癞子数量
        }
        for (int j = cnt; j < numbers.length - 1; j++){
            if (numbers[j + 1] == numbers[j])
                return false;
            cnt -= numbers[j + 1] - numbers[j] -1;//使用癞子去补全顺子空缺
        }
        return (cnt >= 0);

    }
}