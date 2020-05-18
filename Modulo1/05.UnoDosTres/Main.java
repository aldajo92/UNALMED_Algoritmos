import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String uno = "uno#";
        String dos = "dos#";
        String tres = "tres";

        HashMap<String, Integer> mapNumbers = new HashMap<>();
        mapNumbers.put(uno, 1);
        mapNumbers.put(dos, 2);
        mapNumbers.put(tres, 3);

        HashMap<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(b.readLine());
        for (int i = 0; i < n; i++) {
            map.put(uno, 0);
            map.put(dos, 0);
            map.put(tres, 0);

            int maxCounter = 0;
            String word = "";

            String line = b.readLine();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                char c1 = uno.charAt(j);
                char c2 = dos.charAt(j);
                char c3 = tres.charAt(j);

                if (c == c1) {
                    Integer value = map.get(uno) + 1;
                    if (value > maxCounter){
                        maxCounter = value;
                        word = uno;
                    }
                    map.put(uno, value);
                }

                if (c == c2) {
                    Integer value = map.get(dos) + 1;
                    if (value > maxCounter){
                        maxCounter = value;
                        word = dos;
                    }
                    map.put(dos, value);
                }

                if (c == c3) {
                    Integer value = map.get(tres) + 1;
                    if (value > maxCounter){
                        maxCounter = value;
                        word = tres;
                    }
                    map.put(tres, value);
                }
            }
            System.out.printf("%s\n",mapNumbers.get(word));
        }
    }
}