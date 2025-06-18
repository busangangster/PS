import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();

    int[] tops = new int[n];
    int[] ans = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      tops[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      if (stack.isEmpty()) {
        stack.push(i);
      } else {
        if (tops[stack.peek()] <= tops[i]) {
          while (!stack.isEmpty() && tops[stack.peek()] <= tops[i]) {
            stack.pop();
          }
          if (!stack.isEmpty()) {
            ans[i] = stack.peek() + 1;
          }
          stack.push(i);
        } else {
          ans[i] = stack.peek() + 1;
          stack.push(i);
        }
      }
    }
    for (int i = 0; i < n; i++) {
      sb.append(ans[i]).append(" ");
    }
    System.out.println(sb);
  }
}