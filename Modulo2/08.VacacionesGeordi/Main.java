import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        map.put("sabado", 0);
        map.put("domingo", 1);
        map.put("lunes", 2);
        int[][] values = new int[n][3];
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = b.readLine();
            String[] line = lines[i].split(" ");
            values[i][0] = (map.get(line[0]) * 24 * 60) + (Integer.parseInt(line[1]) * 60) + Integer.parseInt(line[2]);
            values[i][1] = (map.get(line[3]) * 24 * 60) + (Integer.parseInt(line[4]) * 60) + Integer.parseInt(line[5]);
            values[i][2] = values[i][1] - values[i][0];
        }
        System.out.println(processData(n, values));
    }

    public static int processData(int n, int[][] values) {
        Arrays.sort(values, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int counter = 0;
        int restrictionStart = 1380;
        int restrictionEnd = 480;
        int delta = 900;
        int lastEnd = 0;
        for (int i = 0; i < n; i++) {
            if(
                values[i][0] >= lastEnd &&
                (values[i][0]%1440 >= restrictionEnd) && 
                (values[i][0]%1440 < restrictionStart) &&
                (values[i][1]%1440 > restrictionEnd) && 
                (values[i][1]%1440 <= restrictionStart) &&
                values[i][2] <= delta
            ){
                lastEnd = values[i][1];
                counter++;
            }
        }
        return counter;
    }
}