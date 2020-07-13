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
        double i = Math.sqrt(n * (n + 1)/2);
        if(i == Math.floor(i)) return (int) i;
        return -1;
    }
}