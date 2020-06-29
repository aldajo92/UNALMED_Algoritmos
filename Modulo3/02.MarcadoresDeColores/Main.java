import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int[] emptyP = {-1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(b.readLine());
        int M = Integer.parseInt(b.readLine());
        int[][] markers = new int[N][2]; // markers
        int[][] caps = new int[M][2]; // caps
        for (int i = 0; i < N; i++) {
            String[] lines = b.readLine().split(" ");
            int[] values = { Integer.parseInt(lines[0]), Integer.parseInt(lines[1]) };
            markers[i] = values;
        }
        for (int i = 0; i < M; i++) {
            String[] lines = b.readLine().split(" ");
            int[] values = { Integer.parseInt(lines[0]), Integer.parseInt(lines[1]) };
            caps[i] = values;
        }
        // System.out.println(Arrays.deepToString(markers));
        // System.out.println(Arrays.deepToString(caps));
        // System.out.println();
        int[] result = processData(markers, caps, N, M);
        System.out.printf("%s %s\n", result[0], result[1]);
    }

    private static int[] processData(int[][] markers, int[][] caps, int n, int m) {
        Arrays.sort(markers, (int[]a, int[]b) -> {
            return 10*(a[1] - b[1]) + (a[0] - b[0]);
        });
        Arrays.sort(caps, (int[]a, int[]b) -> { 
            return 10*(a[1] - b[1]) + (a[0] - b[0]);
        });

        int[] result;
        result = countFromArrays(markers, caps, n, m);

        return result;
    }

    private static int[] countFromArrays(int[][] arrayA, int[][] arrayB, int sizeA, int sizeB) {
        int counterMatchPerfect = 0;
        int counterMatch = 0;
        int[][] itemsToTryMatch = new int[sizeA][2];
        int indexTry = 0;
        for (int i = 0; i < sizeA; i++) {
            // if(counterMatchPerfect == sizeA) break;
            int[] itemToFind = arrayA[i];
            int index = Arrays.binarySearch(arrayB, itemToFind, (int[] a, int[] b) -> {
                return 10*(a[1] - b[1]) + (a[0] - b[0]);
            });

            if(index >= 0){
                arrayB[index] = emptyP;
                counterMatchPerfect++;
            } else {
                itemsToTryMatch[indexTry] = arrayA[i];
                indexTry++;
            }
        }

        for (int i = 0; i < sizeA; i++) {
            int[] itemToFind = itemsToTryMatch[i];
            if(itemToFind[0] == 0 && itemToFind[1] == 0){
                break;
            }
        
            int index = Arrays.binarySearch(arrayB, itemToFind, (int[] a, int[] b) -> {
                return (a[1] - b[1]);
            });
            if(index >= 0){
                arrayB[index] = emptyP;
                counterMatch++;
            }
        }
        int[] result = {counterMatch + counterMatchPerfect, counterMatchPerfect};
        // System.out.println(Arrays.deepToString(itemsToTryMatch));
        // System.out.println(Arrays.deepToString(arrayB));
        return result;
    }
}