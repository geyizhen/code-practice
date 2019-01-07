/*
** Data     ：2018-12-6 21:13:27
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1
说明:

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
*/
//空间复杂度为O(n)，则表示不能for循环叠加
//本题思路为将对应的值交换至对应的序号上，从头进行遍历判断序号和值是否一一对应，如果不对应则返回该序号
public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i ++){//遍历，交换，使序号和值一一对应
            while(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]){
                swap(A, i, A[i] - 1);
            }
        }
        for (int i = 0; i < n; i++){//二次遍历，返回序号与值不对应的序号
            if (A[i]  != i + 1)
                return i + 1;
        }
        return n + 1;
    }
    private void swap(int[] A, int a, int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}