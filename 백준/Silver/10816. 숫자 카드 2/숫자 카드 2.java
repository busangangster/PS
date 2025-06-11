import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    HashMap<Integer, Integer> hm = new HashMap<>();

    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      hm.put(tmp, hm.getOrDefault(tmp, 0) + 1);
    }

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      if (hm.containsKey(tmp))
        sb.append(hm.get(tmp));
      else
        sb.append(0);
      sb.append(" ");
    }

    System.out.println(sb);
  }
}