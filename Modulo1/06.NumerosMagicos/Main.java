import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = b.readLine().split(" ");
            int value = magic(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            System.out.println(value);
        }
    }

    static int magic(int a, int b){
        int counter = 0;
        for (int i = a; i <= b; i++) {
            if(isMagic(i)) counter++;
        }
        return counter;
    }

    static boolean isMagic(int value){
        int sum = 0;
        for (int i = 1; i <= value/2; i++) {
            if(value%i == 0) sum += i;
            if (sum > value) return false;
        }
        if(sum == value) return true;
        return false;
    }
}