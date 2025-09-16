import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> hm = new HashMap<>();

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      hm.put(s, hm.getOrDefault(s, 0) + 1);
    }

    for (int i = 0; i < M; i++) {
      String s = br.readLine();
      hm.put(s, hm.getOrDefault(s, 0) + 1);
    }

    ArrayList<String> ans = new ArrayList<>();

    for (String s : hm.keySet()) {
      if (hm.get(s) == 2) {
        ans.add(s);
      }
    }

    Collections.sort(ans);

    System.out.println(ans.size());
    for (String s : ans) {
      System.out.println(s);
    }
  }
}