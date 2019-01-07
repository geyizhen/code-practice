/*
把它理解为一个矩阵
1  A1 A2 A3 A4
A0 1  A2 A3 A4
A0 A1 1  A3 A4
A0 A1 A2 1  A4
A0 A1 A2 A3 1 



*/


import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        int n = A.length;
        int [] B = new int [n];
        for (int i = 0, result = 1; i < n; i++){//第一个循环计算矩阵每一行1左边所有数的乘积
            B[i] = result;
            result *= A[i];
        }
        for (int i = n - 1, result = 1; i >= 0; i--){//第二个循环计算矩阵每一行1右边左右数的乘积
            B[i] *= result;
            result *= A[i];
        }
        return B;
        

    }
}