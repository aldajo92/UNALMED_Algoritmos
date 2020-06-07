import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());

        for (int i = 0; i < n; i++) {
            String[] data = b.readLine().split(" ");
            int total = Integer.parseInt(data[0]);
            int[] array = new int[9];
            for (int j = 1; j < data.length; j++) {
                array[j - 1] = Integer.parseInt(data[j]);
            }
            processData(array, total);
            System.out.println(counter);
            counter = 0;
        }
    }

    private static void processData(int[] array, int total) {
        backTracking(array, 0, 8, total);
    }

    static int counter = 0;

    private static void backTracking(int[] arr, int pos, int m, int total) {
        if (pos == m) {
            int sum1 = 0;
            for (int i = 0; i < 4; i++) {
                sum1 += arr[i];
            }

            int sum2 = 0;
            for (int i = 3; i < 7; i++) {
                sum2 += arr[i];
            }

            int sum3 = 0;
            for (int i = 6; i < 10; i++) {
                sum3 += arr[i%9];
            }

            if(sum1 == total && sum2 == total && sum3 == total){
                counter++;
            }
            return;
        }
        for (int i = pos; i <= m ; i++) {
            arr = swap(arr, pos, i);
            backTracking(arr, pos + 1, m, total);
            arr = swap(arr, pos, i);
        }
    }

    static int[] swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return arr;
    }
}