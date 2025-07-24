import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      int N = Integer.parseInt(br.readLine());
      TreeMap<Integer, Integer> tm = new TreeMap<>();

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        String cmd = st.nextToken();
        int val = Integer.parseInt(st.nextToken());

        if (cmd.equals("I")) {
          tm.put(val, tm.getOrDefault(val, 0) + 1);
        } else {
          if (!tm.isEmpty()) {
            if (val == 1) {
              if (tm.get(tm.lastKey()) >= 2) {
                tm.put(tm.lastKey(), tm.get(tm.lastKey()) - 1);
              } else {
                tm.remove(tm.lastKey());
              }
            } else {
              if (tm.get(tm.firstKey()) >= 2) {
                tm.put(tm.firstKey(), tm.get(tm.firstKey()) - 1);
              } else {
                tm.remove(tm.firstKey());
              }
            }
          }
        }
      }
      if (tm.isEmpty()) {
        sb.append("EMPTY");
      } else {
        sb.append(tm.lastKey() + " " + tm.firstKey());
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}