import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      HashMap<String, Integer> hm = new HashMap<>();
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        String b = st.nextToken();
        hm.put(b, hm.getOrDefault(b, 0) + 1);
      }

      int sum = 1;
      for (int val : hm.values()) {
        sum *= (val + 1);
      }

      sb.append(sum - 1).append("\n");
    }
    System.out.println(sb);
  }
}
