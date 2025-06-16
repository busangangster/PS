import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int pos = 0;

    for (int i = 1; i <= n; i++) {
      stack.push(i);
      sb.append("+").append("\n");
      while (!stack.isEmpty() && stack.peek() == arr[pos]) {
        stack.pop();
        sb.append("-").append("\n");
        pos++;
      }
    }

    if (stack.isEmpty()) {
      System.out.println(sb);
    } else {
      System.out.println("NO");
    }

  }
}