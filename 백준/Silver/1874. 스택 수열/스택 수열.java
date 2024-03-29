import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        
        int cnt = 1;
        for (int i=0; i<n; i++) {
        	int num = Integer.parseInt(br.readLine());
        	
        	while (cnt <= num) {
        		stack.push(cnt);
        		cnt++;
        		sb.append("+").append("\n");
        	}
    		
    		if (stack.peek() == num) {
    			stack.pop();
    			sb.append("-").append("\n");
    		}	
        }

        if (!stack.isEmpty()) {
        	System.out.println("NO");
        }
        else {
        	System.out.println(sb);	
        }
        
	}
}