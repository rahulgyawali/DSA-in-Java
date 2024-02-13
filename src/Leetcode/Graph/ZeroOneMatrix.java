package Leetcode.Graph;

import java.util.LinkedList;
import java.util.Queue;
/* 542. 01 Matrix

 * https://leetcode.com/problems/01-matrix/description/
 *
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 *
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 *
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 */

public class ZeroOneMatrix {

    public static class Node {
        int distance;
        int i;
        int j;

        public Node(int distance, int i, int j) {
            this.distance = distance;
            this.i = i;
            this.j = j;
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] distance = new int[m][n];
        int[] row = {1, -1, 0, 0};
        int[] col = {0, 0, 1, -1};
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    Node newNode = new Node(0, i, j);
                    q.add(newNode);
                    distance[i][j] = 0;
                    vis[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            Node temp = q.remove();
            for (int i = 0; i < 4; i++) {
                int x = row[i] + temp.i;
                int y = col[i] + temp.j;
                if (x >= 0 && y >= 0 && x < m && y < n && !vis[x][y]) {
                    Node newNode = new Node(temp.distance + 1, x, y);
                    vis[x][y] = true;
                    distance[x][y] = temp.distance + 1;
                    q.add(newNode);
                }
            }
        }
        return distance;
    }

    public static void print(int[][] mat, String config) {
        System.out.println(config);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        print(mat, "Before");
        int[][] distance = updateMatrix(mat);
        print(distance, "After");
    }
}
