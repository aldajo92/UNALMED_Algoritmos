import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        map.put("HOLA", "ESPANOL");
        map.put("HALLO", "ALEMAN");
        map.put("HELLO", "INGLES");
        map.put("CIAO", "ITALIANO");
        map.put("BONJOUR", "FRANCES");
        map.put("ZDRAVSTVUJTE", "RUSO");

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int counter = 1;
        while ((line = b.readLine()) != "#") {
            if(line.equals("#")) break;
            String idiom = map.get(line);
            if (idiom == null)
                idiom = "DESCONOCIDO";
            System.out.println(String.format("Palabra %d: %s", counter++, idiom));
        }
    }
}