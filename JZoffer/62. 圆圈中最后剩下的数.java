/*
使用数组来模拟环
*/
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        int array [] = new int [n];
        int i = -1, count = n, step = 0;
        while(count > 0){//跳出循环后最后一个元素也被设为了-1，所以最后返回i即为最后一个
            i++;        //指向被删除元素的下一个
            if (i == n) //如果到达数组尾部则置为数组头
                i = 0;
            if (array[i] == -1) continue;//跳过被删除的元素
            step ++;                    //记录已走的步数
            if (step == m){             //找到待删除的元素
                array[i] = -1;
                step = 0;
                count--;
            }
        }
        return i;
    }
}