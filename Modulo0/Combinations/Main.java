import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        int[] arr = new int[n];
        backTracking(arr, 0, n);
    }

    static void backTracking(int[] arr, int pos, int n){
        if(pos == n){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i = 0; i < 2; i++){
            arr[pos] = i;
            backTracking(arr, pos + 1, n);
        }
    }
}