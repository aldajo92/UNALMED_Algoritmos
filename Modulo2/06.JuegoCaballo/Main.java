import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 6);
        map.put("G", 7);
        map.put("H", 8);

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        for (int i = 0; i < n; i++) {
            board = new int[8][8];
            String[] line = b.readLine().split(" ");
            int r = map.get(line[0]) - 1;
            int c = Integer.parseInt(line[1]) - 1;
            processData(r, c);
            if(found){
                System.out.println(minMoves);
                found = false;
                minMoves = 100000;
            } else {
                System.out.println("Demasiados movimientos");
            }
        }
    }

    private static void processData(int r, int c) {
        backtracking(r, c, 0);
    }

    static boolean found = false;
    static int minMoves = 100000;

    private static void backtracking(int r, int c, int counter) {
        if(r < 0 || c < 0 || r >= 8 || c >= 8) return;
        if(r == 7 && c == 7){
            if(counter < minMoves){
                minMoves = counter;
            }
            found = true;
            return;
        }
        if(counter >= 7) return;

        backtracking(r+1, c-2, counter+1);
        backtracking(r+1, c+2, counter+1);
        backtracking(r+2, c-1, counter+1);
        backtracking(r+2, c+1, counter+1);

        backtracking(r-1, c-2, counter+1);
        backtracking(r-1, c+2, counter+1);
        backtracking(r-2, c-1, counter+1);
        backtracking(r-2, c+1, counter+1);
    }

}