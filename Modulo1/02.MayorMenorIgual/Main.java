import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        for (int i = 0; i < n; i++) {
            String[] values = b.readLine().split(" ");
            int value1 = Integer.parseInt(values[0]);
            int value2 = Integer.parseInt(values[1]);
            System.out.println((value1 > value2) ? ">" : (value1 < value2) ? "<" : "=");
        }
    }
}