import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n;
        while((n = Integer.parseInt(b.readLine())) > 0){
            int[] values = new int[n];
            for (int j = 0; j < n; j++) {
                values[j] = Integer.parseInt(b.readLine());
            }
            
            System.out.println(processData(values, n));
        }
    }

    private static int processData(int[] values, int n) {
        PriorityQueue<HuffmanNode> q = 
        new PriorityQueue<>(n, (HuffmanNode x, HuffmanNode y) ->  x.freq - y.freq );
            for (int i = 0; i < n; i++) { 
                HuffmanNode hn = new HuffmanNode();
                hn.freq = values[i]; 
      
                hn.left = null; 
                hn.right = null; 

                q.add(hn); 
            }

            int total = 0;
            while (q.size() > 1) { 
                HuffmanNode x = q.poll();
                HuffmanNode y = q.poll();
      
                HuffmanNode f = new HuffmanNode();
                f.freq = x.freq + y.freq;
      
                f.left = x; 
                f.right = y; 
      
                q.add(f);
                total += f.freq;
            }
            return total;
    }
}

class HuffmanNode { 
    int freq; 
  
    HuffmanNode left; 
    HuffmanNode right; 
} 