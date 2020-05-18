import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException{
        HashMap<String, Integer> map = new HashMap<>();
        map.put("SSS", 0);
        map.put("SSC", 1);
        map.put("SCS", 2);
        map.put("SCC", 3);
        map.put("CSS", 4);
        map.put("CSC", 5);
        map.put("CCS", 6);
        map.put("CCC", 7);

        int[] result = new int[8];

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        for (int i = 0; i < n; i++) {
            int g = Integer.parseInt(b.readLine());
            String s = b.readLine();

            for (int j = 0; j < s.length()-2; j++) {
                String subs = s.substring(j, j+3);
                int pos = map.get(subs);
                result[pos] = result[pos] + 1;
            }

            StringBuilder builder = new StringBuilder();
            builder.append(g);
            for (int value : result) {
                builder.append(" ");
                builder.append(value);
            }
            System.out.println(builder.toString());
            result = new int[8];
        }
    }
}