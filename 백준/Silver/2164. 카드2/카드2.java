import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i=1; i<=n; i++) {
        	q.add(i);
        }
        
        while (q.size() != 1) {
        	q.poll();
        	q.add(q.poll());
        }
        System.out.println(q.peek());
	}
}