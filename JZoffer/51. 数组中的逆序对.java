//使用递归把数组n分成n个小数组，在采用归并排序（分治法）进行排序
//使用归并进行升序排序

public class Solution {
    private long cnt = 0;
    private int[] tem;// 在这里声明辅助数组，而不是在 merge() 递归函数中声明
    
    public int InversePairs(int [] array) {
        tem = new int [array.length];
        mergesort(array, 0, array.length - 1);
        return (int) (cnt % 1000000007);
    }
    
    private void mergesort(int [] array, int a, int b){
        if (a == b)
            return;
        int mid = a +(b - a)/2;
        mergesort(array, a, mid);
        mergesort(array, mid+1, b);
        merge(array, a, mid, b);
    }
    
    private void merge(int [] array, int a, int mid, int b){
        int i = a, j = mid + 1, k = a;
        while(i <= mid || j <= b){
            if (i > mid)//若前数组已遍历完，则把后数组直接加到辅助数组中
                tem[k] = array[j++];
            else if (j > b)//若后数组已遍历完，则把前数组加到辅助数组中
                tem[k] = array[i++];
            else if (array[i] < array[j])//若前数组元素小于后数组元素，则把前元素加入辅助数组，并后移一位
                tem[k] = array[i++];
            else{//若前数组元素大于后数组元素，则前数组后续元素也必然大于后数组元素，则把后数组元素加入辅助数组
                tem[k] = array[j++];
                cnt += mid - i + 1;
            }
            k++;
        }
        for(i = a; i <= b; i++)
            array[i] = tem[i];
    }
}