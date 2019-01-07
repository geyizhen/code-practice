/*
** Data     ：2018-12-26 20:55:01
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
*/
public class Solution {
    public void sortColors(int[] A) {
        int start = 0;
        int end = A.length - 1;
        for (int i = 0; i <= end; i++){//从前往后进行遍历，遇到0则交换至前端，遇到2则交换至尾端，，
            if (A[i] == 0){
                A[i] = A[start];
                A[start] = 0;
                start ++;
            }else if (A[i] == 2){
                A[i] = A[end];
                A[end] = 2;
                end --;
                i--;//注意2进行交换时有可能交换来的还是2，所以i要减一位，在进行i++操作时候对i在进行一次判断
            }
        }
    }
}