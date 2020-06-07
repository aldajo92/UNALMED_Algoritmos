import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = b.readLine();
            matrix[i] = stringToArray(line);
        }
        int[] array = new int[n];
        for (int i = 0; i < matrix.length; i++) {
            array[i] = i;
        }
        processData(matrix, array, 0, n);
        if(minTotal < 1000000){
            System.out.println(minTotal);
        } else {
            System.out.println("imposible");
        }
        minTotal = 1000000;
    }

    public static void processData(int[][] matrix, int[] arr, int pos, int m){
        backTracking(matrix, arr, pos, m-1);
    }

    static int minTotal = 1000000;
    public static void backTracking(int[][] matrix, int[] arr, int pos, int m){
        if(pos == m){
            // System.out.println(Arrays.toString(arr));
            int total = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                int r = arr[i];
                int c = arr[i+1];
                int city = matrix[r][c];
                if(city > 0){
                    total += city;
                } else {
                    return;
                }
            }
            if(total < minTotal) minTotal = total;
            return;
        }
        for (int i = pos; i <= m ; i++) {
            arr = swap(arr, pos, i);
            backTracking(matrix, arr, pos + 1, m);
            arr = swap(arr, pos, i);
        }
    }

    static int[] swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return arr;
    }

    public static int[] stringToArray(String strDatos) {
        StringTokenizer tokens = new StringTokenizer(strDatos);
        int n = tokens.countTokens();
        int[] result = new int[n];
        int count = 0;
        while(tokens.hasMoreTokens()){
            String val = tokens.nextToken();
            if(val.equals("n.a")){
                result[count] = 0;
            } else {
                result[count] = Integer.parseInt(val);
            }
            count++;
        }
        return result;
    }
}