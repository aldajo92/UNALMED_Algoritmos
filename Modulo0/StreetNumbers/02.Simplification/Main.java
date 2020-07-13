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
            int sum1 = (i * (i - 1) / 2);
            int sum2 = (n * (n + 1) / 2) - (i * (i + 1) / 2);
            if (sum1 == sum2) return i;
        }
        return -1;
    }
}