//使用cnt来统计一个元素出现的次数，当遍历到的元素与统计元素相等时，
//cnt+1，若不相同则cnt-1，且当cnt==0时，保存当前元素并置cnt=1
//Boyer-Moore majority Vote algorithm 摩尔投票算法




public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int maj = array[0];
        for(int i = 1, cnt = 1; i < array.length; i ++){
            if (array[i] == maj)
                cnt++;
            else
                cnt--;
            if (cnt == 0)
            {
                maj = array[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        for(int i = 0; i < array.length; i++){
            if (maj == array[i])
                cnt ++;
        }
        if(cnt > array.length/2)
            return maj;
        else
            return 0;
    }
}