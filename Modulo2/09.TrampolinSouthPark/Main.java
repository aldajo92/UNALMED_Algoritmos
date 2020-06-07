import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] positions = new int[5002];

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(b.readLine());
            int[][] values = new int[m][2];
            for (int j = 0; j < m; j++) {
                String[] line = b.readLine().split(" ");
                values[j][0] = Integer.parseInt(line[0]);
                values[j][1] = Integer.parseInt(line[1]);
            }
            int result = processData(values, m);
            System.out.printf("Caso %d: %d\n", i + 1, result);
        }
    }

    static int processData(int[][] values, int m) {
        Arrays.sort(values, (int[] a, int[] b) -> b[1] - a[1]);
        int maxPos = 0;
        for (int i = 0; i < m; i++) {
            int pos = (values[i][0]/10);
            if(positions[pos] == 0){
                positions[pos] = values[i][1];
                maxPos = Math.max(maxPos, pos);
            } else {
                while(positions[getCyclicPos(pos, m)] > 0){
                    pos--;
                }
                positions[getCyclicPos(pos, m)] = values[i][1];
            }
        }
        int result = 0;
        for (int i = maxPos + 1; i < m; i++) {
            result += positions[i];
        }
        positions = new int[5002];
        return result;
    }
    
    static int getCyclicPos(int pos, int m){
        int nPos = pos;
        if(pos < 0){
            nPos = m + pos;
        }
        return nPos;
    }
}