/*
** Data     ：2018-12-6 21:13:27
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
public class Solution {
    private static final int [][] next = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};//设置上下左右移动的数组
    private int cnt = 0;
    private int rows;
    private int cols;
    private int threshold;
    private int[][] digitSum;//创立数组，数组的值为横纵坐标各位数字之和
    
    public int movingCount(int threshold, int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initDigitSum();//计算横纵坐标各位数字之和的函数
        boolean [][] marked = new boolean[rows][cols];//创建判断是否已被标记的数组
        dfs(marked, 0, 0);//深度优先搜索，使用回溯法对每个点及其周围四个点进行判断
        return cnt;
    }
    private void dfs(boolean[][] marked, int r, int c){
        if(r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c])
            return;
        marked[r][c] = true;//标记该点已经过判断
        if(digitSum[r][c] > threshold)
            return;
        cnt ++;
        for (int [] n : next)//对该点上下左右四个点进行判断
            dfs(marked, r + n[0], c + n[1]);
    }
    
    private void initDigitSum(){
        int[] digitSumOne = new int[Math.max(rows, cols)];
        for(int i = 0; i < digitSumOne.length; i ++){
            int n = i;
            while(n > 0){
                digitSumOne[i] += n % 10;
                n /= 10;
            }
        }
        this.digitSum = new int[rows][cols];
        for(int i = 0; i < this.rows; i++)
            for(int j = 0; j < this.cols; j++)
                this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
    }
}