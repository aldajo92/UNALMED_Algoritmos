import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int min = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        for (int i = 0; i < n; i++) {
            String line = b.readLine();
            String[] values = line.split(" ");
            // System.out.println(Arrays.toString(values));
            int total = Integer.parseInt(values[0]);
            int m = Integer.parseInt(values[1]);
            int result = solve(values, total, m);
            System.out.println(result);
            min = 1000000;
        }
    }

    static int solve(String[] values, int total, int m){
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(values[i + 2]);
        }
        // System.out.println(Arrays.toString(arr));

        int[] arrBin = new int[m];
        backTracking(arr, arrBin, 0, m, total);
        return min;
    }

    static void backTracking(int[] arr, int[] arrBin, int pos, int n, int total) {
        if (pos == n) {
            // System.out.println(Arrays.toString(arr));
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i]*arrBin[i];
            }
            // System.out.println(min);
            if(total - sum >= 0){
                min = Math.min(min, total- sum);
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            arrBin[pos] = i;
            backTracking(arr, arrBin, pos + 1, n, total);
        }
    }

    // static int[] convertToArray(String[] arr){
    //     int[] result = new int[arr.length];
    //     for (int i = 0; i < arr.length; i++) {
    //         arr[i] = int
    //     }
    //     return result;
    // }
}