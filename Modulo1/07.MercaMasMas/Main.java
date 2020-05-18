import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(b.readLine());
            String[] numbers = b.readLine().split(" ");
            if (m < 3) {
                System.out.println(0);
            } else {
                int[] sorted = convertToIntArray(numbers);
                sort(sorted);
                int maxDiscount = 0;
                for (int j = m%3; j < m; j += 3) {
                    maxDiscount += sorted[j];
                }
                System.out.println(maxDiscount);
            }

        }
    }

    static int[] convertToIntArray(String[] arr) {
        int[] sorted = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sorted[i] = Integer.parseInt(arr[i]);
        }
        return sorted;
    }
    static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}