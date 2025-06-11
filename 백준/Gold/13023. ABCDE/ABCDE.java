import java.util.*;
import java.io.*;

public class Main {
  public static int n, m, ans;
  public static boolean[] visited;
  public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n; i++) {
      arr.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr.get(a).add(b);
      arr.get(b).add(a);
    }

    ans = 0;

    for (int i = 0; i < n; i++) {
      visited = new boolean[n];
      visited[i] = true;
      dfs(1, i);
    }

    System.out.println(ans);
  }

  public static void dfs(int depth, int idx) {
    if (ans == 1)
      return;
    if (depth == 5) {
      ans = 1;
      return;
    }

    for (int k : arr.get(idx)) {
      if (!visited[k]) {
        visited[k] = true;
        dfs(depth + 1, k);
        visited[k] = false;
      }
    }
  }
}