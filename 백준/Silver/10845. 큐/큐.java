import java.util.*;
import java.io.*;

public class Main {
  public static int n, k, ans;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    Deque<Integer> dq = new ArrayDeque<>();

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String cmd = st.nextToken();
      if (cmd.equals("push")) {
        int k = Integer.parseInt(st.nextToken());
        dq.addLast(k);
      } else if (cmd.equals("pop")) {
        if (dq.isEmpty())
          sb.append(-1);

        else
          sb.append(dq.pollFirst());
        sb.append("\n");
      } else if (cmd.equals("size")) {
        sb.append(dq.size()).append("\n");
      } else if (cmd.equals("empty")) {
        if (dq.isEmpty())
          sb.append(1);
        else
          sb.append(0);
        sb.append("\n");
      } else if (cmd.equals("front")) {
        if (dq.isEmpty())
          sb.append(-1);
        else
          sb.append(dq.peekFirst());
        sb.append("\n");
      } else if (cmd.equals("back")) {
        if (dq.isEmpty())
          sb.append(-1);
        else
          sb.append(dq.peekLast());
        sb.append("\n");
      }
    }
    System.out.println(sb);
  }
}
