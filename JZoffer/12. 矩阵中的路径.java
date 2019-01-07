/*本题使用回溯法，遍历每一个点找到起点，对该点的上下左右进行遍历，如果下一个点正确则继续遍历周围四个点，
  若错误则回溯到上一个正确的点，判断其他方向的点
*/

public class Solution {
    //使用final关键字定义的变量无法进行修改，编译时已静态绑定，提高效率
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows;//行
    private int cols;//列
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (rows == 0 || cols == 0)
            return false;
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];//创建布尔型数组判断字符是否已经被使用
        char[][] array = buildMatrix(matrix);//将读取的字符串构造成字符数组
        
        //遍历字符串数组，使用回溯法判断
        for(int i = 0; i < rows; i ++)
            for(int j = 0; j < cols; j++)
                if (backtracking(array, str, marked, 0, i, j))//只要找到一条路径即成功
                    return true;
        return false;//否则找不到该路径
    
    }
    //pathlen:目标字符串的长度 
    private boolean backtracking(char[][] array, char[] str, boolean[][] marked, int pathlen, int r, int c){
        if (pathlen == str.length)
            return true;//此时表示0至str.length - 1均已匹配成功，则成功找到路径
        if(r < 0 || r >= rows || c < 0 || c >= cols || array[r][c] != str[pathlen] || marked[r][c])
            return false;//若发生数组越界、字符不匹配、字符已被使用，则返回失败
        marked[r][c] = true;//上述两者均未发生，则标记此字符已被占用
        //对next进行遍历，即对该字符的上下左右四个方向，与匹配字符串的下一个字符进行匹配
        for(int [] n : next)
            if (backtracking(array, str, marked, pathlen + 1, r + n[0], c + n[1]))
                return true;//若匹配成功返回true
        marked[r][c] = false;//若匹配失败，则将标记的占用复位
        return false;
    }
    
    //字符串构造字符数组
    private char[][] buildMatrix(char[] matrix){
        char[][] array = new char[rows][cols];
        int index = 0;
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                array[i][j] = matrix[index++];
        return array;
    }


}