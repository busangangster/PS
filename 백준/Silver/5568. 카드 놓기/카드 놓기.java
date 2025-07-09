import java.util.*;
import java.io.*;

public class Main {
  public static int n, k, ans;
  public static String[] numbers;
  public static boolean[] visited;
  public static String[] selected;
  public static HashSet<String> hs = new HashSet<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    k = Integer.parseInt(br.readLine());

    numbers = new String[n];
    visited = new boolean[n];
    selected = new String[n];

    for (int i = 0; i < n; i++) {
      numbers[i] = br.readLine();
    }

    ans = 0;
    perm(0);
    System.out.println(ans);
  }

  public static void perm(int cnt) {
    if (cnt == k) {
      String s = "";
      for (int i = 0; i < k; i++) {
        s += selected[i];
      }
      if (!hs.contains(s)) {
        hs.add(s);
        ans++;
      }
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        selected[cnt] = numbers[i];
        visited[i] = true;
        perm(cnt + 1);
        visited[i] = false;
      }
    }
  }
}