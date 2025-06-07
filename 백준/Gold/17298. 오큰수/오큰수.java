import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    int[] ans = new int[n];
    int[] arr = new int[n];
    Arrays.fill(ans, -1);
    Stack<Integer> stack = new Stack<>();

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      if (stack.isEmpty()) {
        stack.push(i);
      } else {
        if (arr[stack.peek()] < arr[i]) {
          while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
            ans[stack.peek()] = arr[i];
            stack.pop();
          }
        }
        stack.push(i);

      }
    }
    for (int i = 0; i < n; i++) {
      sb.append(ans[i]).append(" ");
    }
    System.out.println(sb);
  }
}