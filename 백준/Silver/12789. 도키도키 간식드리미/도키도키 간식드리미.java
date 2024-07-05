import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack<Integer> stack = new Stack<>();
        Deque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        int now = Integer.MAX_VALUE;
        boolean flag = true;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            now = Integer.min(k, now);
            dq.add(k);
        }

        while (!dq.isEmpty()) {
            if (dq.peekFirst() == now) {
                dq.pollFirst();
                now++;
            } else if (!stack.isEmpty() && stack.peek() == now) {
                stack.pop();
                now++;
            } else {
                stack.add(dq.pollFirst());
            }
        }
        
        while (!stack.isEmpty()) {
            if (stack.peek() == now) {
                stack.pop();
                now++;
            } else {
                flag = false;
                break;
            }
        }
        
        if (flag)
            System.out.println("Nice");
        else System.out.println("Sad");
        
    }
}