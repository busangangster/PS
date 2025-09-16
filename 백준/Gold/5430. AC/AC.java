import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      String cmd = br.readLine();
      int n = Integer.parseInt(br.readLine());
      Deque<Integer> dq = new ArrayDeque<>();
      String s = br.readLine();
      s = s.substring(1, s.length() - 1);
      String[] arr = s.split(",");

      if (n != 0) {
        for (int i = 0; i < arr.length; i++) {
          dq.offer(Integer.parseInt(arr[i]));
        }
      }

      boolean edge = true;
      boolean error = false;

      for (int i = 0; i < cmd.length(); i++) {
        char tmp = cmd.charAt(i);
        if (tmp == 'R') {
          edge = !edge;
        } else {
          if (dq.isEmpty()) {
            error = true;
            break;
          } else {
            if (edge)
              dq.pollFirst();
            else
              dq.pollLast();
          }
        }
      }
      if (error) {
        sb.append("error");
      } else {
        sb.append("[");
        int r = dq.size();
        for (int i = 0; i < r; i++) {
          if (edge) {
            if (i == r - 1)
              sb.append(dq.pollFirst());

            else
              sb.append(dq.pollFirst()).append(",");

          } else {
            if (i == r - 1)
              sb.append(dq.pollLast());
            else
              sb.append(dq.pollLast()).append(",");
          }

        }
        sb.append("]");
      }
      sb.append("\n");

    }

    System.out.println(sb);

  }
}