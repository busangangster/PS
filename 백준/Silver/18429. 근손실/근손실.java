import java.util.*;
import java.io.*;

public class Main {
  public static int N, K, ans;
  public static int[] kits;
  public static int[] selected;
  public static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    visited = new boolean[N];
    selected = new int[N];
    kits = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      kits[i] = Integer.parseInt(st.nextToken());
    }

    ans = 0;
    dfs(0, 500);
    System.out.println(ans);

  }

  public static void dfs(int cnt, int sum) {
    if (cnt == N) {
      ans++;
      return;
    }
    if (sum < 500) {
      sum = 500;
      return;
    }

    for (int i = 0; i < N; i++) {
      if (visited[i])
        continue;

      visited[i] = true;
      dfs(cnt + 1, sum + kits[i] - K);
      visited[i] = false;
    }
  }
}