import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(b.readLine());
            int[][] matrix = new int[m][m];
            for (int r = 0; r < m; r++) {
                String[] line = b.readLine().split(" ");
                for (int c = 0; c < m; c++) {
                    matrix[r][c] = Integer.parseInt(line[c]);
                }
            }
            processArray(matrix, m);
            System.out.println(base);
            base = 0;
            isContinue = true;
        }
    }

    public static void processArray(int[][] matrix, int m){
        int[] arr = new int[m];
        for (int i = 0; i <= m; i++) {
            if(isContinue){
                backTracking(matrix, arr, i, 0, m);
            }
        }
    }

    static int result = 1000;
    static int base = -1;
    static boolean isContinue = true;
    public static void backTracking(int[][] matrix, int[] arr, int b, int pos, int m){
        if(pos == m){
            // System.out.printf("%s = %s", Arrays.toString(arr), b);
            for (int i = 0; i < m; i++) {
                for (int j = i+1; j < m; j++) {
                    if (matrix[i][j] == 1 && (arr[i] == arr[j])){
                        // System.out.println(" skip");
                        return;
                    }
                }
            }
            // System.out.println(" correct");
            base = b;
            isContinue = false;
            return;
        }
        for (int i = 0; i < b; i++) {
            arr[pos] = i;
            if(isContinue){
                backTracking(matrix, arr, b, pos+1, m);
            }
        }
    }
}