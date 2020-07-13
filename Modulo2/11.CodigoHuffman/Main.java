import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(b.readLine());
            char[] data = new char[m];
            int[] freq = new int[m];
            for (int j = 0; j < m; j++) {
                String[] line = b.readLine().split(" ");
                data[j] = line[0].charAt(0);
                freq[j] = Integer.parseInt(line[1]);
            }
            sb.append(String.format("Caso %d:\n", i+1));
            processData(data, freq, m, sb);
            if (i < n-1 ) sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void processData(char[] data, int[] freq, int n, StringBuilder sb) {
        PriorityQueue<HuffmanNode> q = 
            new PriorityQueue<HuffmanNode>(n, (HuffmanNode x, HuffmanNode y) ->  x.freq - y.freq );
            for (int i = 0; i < n; i++) { 
                HuffmanNode hn = new HuffmanNode(); 
                hn.ch = data[i]; 
                hn.freq = freq[i]; 
      
                hn.left = null; 
                hn.right = null; 

                q.add(hn); 
            }

            HuffmanNode root = null;

            while (q.size() > 1) { 
                HuffmanNode x = q.poll();
                HuffmanNode y = q.poll();
      
                HuffmanNode f = new HuffmanNode(); 
                f.freq = x.freq + y.freq; 
                f.ch = '-'; 
      
                f.left = x; 
                f.right = y; 
      
                root = f; 
                q.add(f);
            }
            printCode(root, "", sb);
    }

    public static void printCode(HuffmanNode root, String s, StringBuilder sb) { 
        if (root.left == null && root.right == null && Character.isLetter(root.ch)) {
            sb.append(String.format("%c %s\n", root.ch, s));
            return; 
        }
        printCode(root.left, s + "0", sb); 
        printCode(root.right, s + "1", sb); 
    }
}

class HuffmanNode { 
    int freq; 
    char ch; 
  
    HuffmanNode left; 
    HuffmanNode right; 
} 