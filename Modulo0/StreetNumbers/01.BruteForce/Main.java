import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        System.out.println(calculateMidNumber(n));
    }

    static int calculateMidNumber(int n){
        if (n < 3) return -1;
        for (int i = 2; i <= n - 1; i++){
            int sum1 = 0;
            for (int j = 1; j < i; j++) {
                sum1 += j;
            }
            int sum2 = 0;
            for (int j = i + 1; j <= n; j++) {
                sum2 += j;
            }
            if (sum1 == sum2) return i;
        }
        return -1;
    }
}