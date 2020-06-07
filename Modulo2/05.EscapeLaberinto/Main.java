import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        for (int i = 0; i < n; i++) {
            String[] size = b.readLine().split(" ");
            int nr = Integer.parseInt(size[0]);
            int nc = Integer.parseInt(size[1]);
            String[][] matrix = new String[nr][nc];
            int[][] visited = new int[nr][nc];
            for (int j = 0; j < nr; j++) {
                matrix[j] = b.readLine().split(" ");
            }
            processData(matrix, visited, nr, nc);
            if(minPath == 1000000){
                System.out.println(-1);
            } else {
                System.out.println(minPath);
                minPath = 1000000;
            }
        }
    }

    private static void processData(String[][] matrix, int[][] visited, int nr, int nc) {
        // System.out.printf("matrix size: r = %d, c = %d\n", matrix.length, matrix[0].length);
        backtracking(matrix, visited, nr, nc, nr - 1, nc - 1, 0);
    }

    static int minPath = 1000000;

    private static void backtracking(String[][] matrix, int[][] visited, int nr, int nc, int r, int c, int counter) {
        if (c < 0 || r < 0 || r >= nr || c >= nc)
            return;
        if(visited[r][c] == 1) return;
        if (matrix[r][c].equals("#"))
            return;
        if (r == 0 && c == 0) {
            if (counter < minPath) {
                minPath = counter;
            }
            return;
        }
        visited[r][c] = 1;
        backtracking(matrix, visited, nr, nc, r - 1, c, counter + 1);
        backtracking(matrix, visited, nr, nc, r + 1, c, counter + 1);
        backtracking(matrix, visited, nr, nc, r, c - 1, counter + 1);
        backtracking(matrix, visited, nr, nc, r, c + 1, counter + 1);
    }
}