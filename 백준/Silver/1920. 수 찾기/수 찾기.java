import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    HashMap<Integer, Integer> hm = new HashMap<>();
    int n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      hm.put(Integer.parseInt(st.nextToken()), 1);
    }

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      if (hm.containsKey(Integer.parseInt(st.nextToken())))
        sb.append(1);
      else
        sb.append(0);
      sb.append("\n");
    }
    System.out.println(sb);

  }
}