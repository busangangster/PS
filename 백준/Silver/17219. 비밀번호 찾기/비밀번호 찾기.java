import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<String, String> hm = new HashMap<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      hm.put(st.nextToken(), st.nextToken());
    }

    for (int i = 0; i < m; i++) {
      String s = br.readLine();
      sb.append(hm.get(s)).append("\n");
    }

    System.out.println(sb);
  }
}