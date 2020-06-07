import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        for (int i = 0; i < n; i++) {
            System.out.printf("Caso %d:\n", (i+1));
            int m = Integer.parseInt(b.readLine());
            int[][] values = new int[2][m];
            for (int j = 0; j < m; j++) {
                String[] line = b.readLine().split(" ");
                values[0][j] = Integer.parseInt(line[0]);
                values[1][j] = Integer.parseInt(line[1]);
            }
            processData(values, m);
            if(i < n - 1) System.out.println();
        }
    }

    public static void processData(int[][] values, int m) {
        double[][] solution = new double[m][2];
        for (int i = 0; i < m; i++) {
            double val = (double) values[1][i] / values[0][i];
            solution[i][0] = val;
            solution[i][1] = i + 1;
        }

        Arrays.sort(solution, new Sortbyroll());
        for (int i = 0; i < m; i++) {
            int value = (int) solution[i][1];
            System.out.println(value);
        }
    }

}

class Sortbyroll implements Comparator<double[]> {
    public int compare(double[] a, double[] b) {
        double result = 1000000*(b[0] - a[0]);
        // System.out.println(result);
        return (int) result;
    }
}