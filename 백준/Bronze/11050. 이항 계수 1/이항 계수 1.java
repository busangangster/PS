import java.util.*;
import java.io.*;

public class Main {
  public static int n, k, ans;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    ans = 0;
    dfs(0, 0);
    System.out.println(ans);

  }

  public static void dfs(int start, int cnt) {
    if (cnt == k) {
      ans++;
      return;
    }

    for (int i = start; i < n; i++) {
      dfs(i + 1, cnt + 1);
    }
  }
}
