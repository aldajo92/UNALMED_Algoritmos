import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] beris = {10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        for (int i = 0; i < n; i++) {
            long value = Long.parseLong(b.readLine());
            String result = processData(value);
            if(!result.isEmpty()){
                System.out.println(result);
            }
        }
    }

    static String processData(long value){
        StringBuilder sb = new StringBuilder();
        long currentValue = value;
        long bi = 0;
        for (int i = 0; i < beris.length; i++) {
            bi = currentValue/beris[i];
            if(bi > 0){
                sb.append(String.format("%d:%d", bi, beris[i]));
                if(i < beris.length - 1){
                    sb.append(" ");
                }
            }
            currentValue = currentValue%beris[i];
            if(currentValue == 0) break;
        }
        return sb.toString();
    }
}