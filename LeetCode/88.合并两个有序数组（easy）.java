/*
** Data     ：2018-12-6 21:13:27
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
*/
//思路：从后往前比，把大的元素放到队末，如果A还剩下，那不用管；如果B还剩下，将其复制到A的前端
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1;//A的末位
        int j = n - 1;//B的末位
        int index = m + n - 1;//总的末位
        while(i >= 0 && j >= 0){
            if (A[i] >= B[j]){
                A[index--] = A[i--];
            }else{
                A[index--] = B[j--];
            }
        }
        while(j >= 0)
            A[index--] = B[j--];  
    }
}