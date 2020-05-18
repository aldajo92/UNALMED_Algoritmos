import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //before: static int[] amountSecuence = new int[500001];
    static int[] amountSecuence = new int[500002];
    static int lastCalculated = 1;
    public static void main(String[] args) throws IOException {
        amountSecuence[lastCalculated] = 1;
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = b.readLine().split(" ");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            calculateSecuence2(B);
            int result = amountSecuence[B] - amountSecuence[A-1];
            System.out.println(result);
        }
    }

    public static void calculateSecuence2(int B){
        // when array to B position is not calculated
        if(B > lastCalculated){
            int ni = lastCalculated;
            int currentAmount = amountSecuence[lastCalculated] - 1;
            while(ni <= B){
                int next = ni + countDivisors(ni);
                currentAmount++;
                for (int i = ni; i < next; i++) {
                    // System.out.printf("%s -> %s\n", B, i);
                    if(i > 500000) break;
                    amountSecuence[i] = currentAmount;
                    // System.out.print(amountSecuence[i] + " ");
                }
                ni = next;
                lastCalculated = next;
            }
            if(lastCalculated < 500000){
                amountSecuence[lastCalculated] = currentAmount + 1;
            }
        }
        // System.out.println();
        // System.out.println(lastCalculated);
    }

    static int countDivisors(int n) 
    { 
        int cnt = 0; 
        for (int i = 1; i <= Math.sqrt(n); i++) { 
            if (n % i == 0) { 
                if (n / i == i) cnt++; 
                else cnt = cnt + 2;
            }
        } 
        return cnt; 
    } 
}

// static int divisorsOf(int a){
    //     if(a == 1) return 1;
    //     if(a == 2) return 2;
    //     int amount = 2;
    //     for (int i = 2; i <= a/2; i++) {  
    //         if(a%i == 0) amount++;
    //     }
    //     return amount;
    // }