package dfs;

/*
 *   Created by zhuang.lian@qunar.com on 18-8-3.
 */
public class SurroundedRegions {



    public void solve(char[][] board) {
        if(board==null ||board.length==0||board[0].length==0){
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            if(board[0][i]=='O'){
                dfs(0,i,board);
            }
            if(board[board.length-1][i]=='O'){
                dfs(board.length-1,i,board);
            }
        }
        for (int i = 1; i < board.length-1; i++) {
            if(board[i][0]=='O'){
                dfs(i,0,board);
            }
            if(board[i][board[0].length-1]=='O'){
                dfs(i,board[0].length-1,board);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='z'){
                    board[i][j]='O';
                }else {
                    board[i][j]='X';
                }
            }
        }
    }
    private void dfs(int m, int n, char[][] board) {
        board[m][n] = 'z';
        if (m > 0 && board[m - 1][n] == 'O') {
            dfs(m - 1, n, board);
        }

        if (n > 0 && board[m][n - 1] == 'O') {
            dfs(m, n - 1, board);
        }

        if (m < board.length - 1 && board[m + 1][n] == 'O') {
            dfs(m + 1, n, board);
        }

        if (n < board[0].length - 1 && board[m][n + 1] == 'O') {
            dfs(m - 1, n, board);
        }
    }
}
