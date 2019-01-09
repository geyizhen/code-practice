/*
** Data     ：2019-1-8 20:56:45
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 1:

给定 nums = [3,2,2,3], val = 3,

函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

你不需要考虑数组中超出新长度后面的元素。
*/
public class Solution {
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        for (int i = 0; i < len; i++){
            if (A[i] == elem){
                int temp = A[i];
                A[i] = A[len - 1];
                A[len - 1] = temp;
                len --;
                i --;//将i减一对这个数进行再一次的判断
            }
        }
        return len;
    }
}