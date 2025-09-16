import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    Stack<Integer> stack = new Stack<>();
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String cmd = st.nextToken();
      if (cmd.equals("push")) {
        int k = Integer.parseInt(st.nextToken());
        stack.push(k);
      } else if (cmd.equals("top")) {
        if (stack.isEmpty())
          sb.append(-1);
        else
          sb.append(stack.peek());
        sb.append("\n");
      } else if (cmd.equals("size")) {
        sb.append(stack.size());
        sb.append("\n");
      } else if (cmd.equals("empty")) {
        if (stack.isEmpty())
          sb.append(1);
        else
          sb.append(0);
        sb.append("\n");
      } else if (cmd.equals("pop")) {
        if (stack.isEmpty())
          sb.append(-1);
        else
          sb.append(stack.pop());
        sb.append("\n");
      }
    }
    System.out.println(sb);
  }
}