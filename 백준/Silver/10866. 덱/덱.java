import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    Deque<Integer> dq = new ArrayDeque<Integer>();

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String cmd = st.nextToken();
      if (cmd.equals("push_front")) {
        int x = Integer.parseInt(st.nextToken());
        dq.addFirst(x);
      } else if (cmd.equals("push_back")) {
        int x = Integer.parseInt(st.nextToken());
        dq.addLast(x);
      } else {
        if (cmd.equals("pop_front")) {
          if (dq.isEmpty())
            sb.append(-1);
          else
            sb.append(dq.pollFirst());
        } else if (cmd.equals("pop_back")) {
          if (dq.isEmpty())
            sb.append(-1);
          else
            sb.append(dq.pollLast());
        } else if (cmd.equals("size")) {
          sb.append(dq.size());
        } else if (cmd.equals("empty")) {
          if (dq.isEmpty())
            sb.append(1);
          else
            sb.append(0);
        } else if (cmd.equals("front")) {
          if (dq.isEmpty())
            sb.append(-1);
          else
            sb.append(dq.peekFirst());
        } else if (cmd.equals("back")) {
          if (dq.isEmpty())
            sb.append(-1);
          else
            sb.append(dq.peekLast());
        }
        sb.append("\n");
      }
    }
    System.out.println(sb);
  }
}