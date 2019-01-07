/*
** Data     ：2018-12-25 21:11:50
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:
Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.

A region is captured by flipping all'O's into'X's in that surrounded region .

For example,

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

*/
//本题采用DFS，深度优先搜索来进行思考
//首先判断四条边，如果四条边有O，则此O置为*，再搜索这个O相邻的字符，若为O则也置为*,直到周围没有O为止
//DFS结束后遍历所有元素，此时若元素为O，则被包围，置为X；若元素为*，则置为O
public class Solution {
    public int rowNum = 0;
    public int colNum = 0;
        
    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1)
            return;
        rowNum = board.length;
        colNum = board[0].length;
        for (int i = 0; i < colNum; i++){
            dfs(board, 0, i);//矩阵的最上边
            dfs(board, rowNum - 1, i);//矩阵的最下边
        }
        for (int i = 0; i < rowNum; i++){
            dfs(board, i, 0);//矩阵的最左边
            dfs(board, i, colNum - 1);//矩阵的最右边
        }
        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < colNum; j++){
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < colNum; j++){
                if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    
    private void dfs(char[] [] board, int row, int col){
        if(board[row][col] == 'O'){
            board[row][col] = '*';
            if (row > 1)
                dfs(board, row - 1, col);//从下往上
            if (row < rowNum - 1)
                dfs(board, row + 1, col);//从上往下
            if (col > 1)
                dfs(board, row, col - 1);//从右往左
            if (col < colNum - 1)
                dfs(board, row, col + 1);//从左往右
        }
    }
}
