package Leetcode.Graph;

/*
 * https://leetcode.com/problems/surrounded-regions/
 *
 * 130. Surrounded Regions
 *
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Constraints:
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 *
 */
public class SurroundedRegions {
    public static void dfs(int x, int y, int m, int n, boolean[][] vis, char[][] board) {
        vis[x][y] = true;
        int[] row = {1, -1, 0, 0};
        int[] col = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int rx = row[i] + x;
            int ry = col[i] + y;
            if (rx >= 0 && ry >= 0 && rx < m && ry < n && !vis[rx][ry] && board[rx][ry] == 'O') {
                dfs(rx, ry, m, n, vis, board);
            }
        }
    }

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            if (!vis[0][j] && board[0][j] == 'O') {
                dfs(0, j, m, n, vis, board);
            }
            if (!vis[m - 1][j] && board[m - 1][j] == 'O') {
                dfs(m - 1, j, m, n, vis, board);
            }

        }
        for (int i = 0; i < m; i++) {
            if (!vis[i][0] && board[i][0] == 'O') {
                dfs(i, 0, m, n, vis, board);
            }
            if (!vis[i][n - 1] && board[i][n - 1] == 'O') {
                dfs(i, n - 1, m, n, vis, board);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void print(char[][] board, String config) {
        System.out.println(config);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        char[][] board = {{'X', 'X', 'X', 'X' }, {'X', 'O', 'O', 'X' }, {'X', 'X', 'O', 'X' }, {'X', 'O', 'X', 'X' }};
        print(board, "Before");
        solve(board);
        print(board, "After");
    }


}
