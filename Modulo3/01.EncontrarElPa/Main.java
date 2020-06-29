import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String[] line = b.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(b.readLine());
        }
        
        int[] result = processData(values, n, k);
        System.out.printf("%s %s\n", result[0], result[1]);
    }

    private static int[] processData(int[] values, int n, int k) {
        Arrays.sort(values);
        int[] result = {values[(k-1) / n], values[(k-1) % n]};
        return result;
    }
}