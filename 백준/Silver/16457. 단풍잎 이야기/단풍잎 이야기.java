import java.util.*;
import java.io.*;

public class Main {
  public static int n, m, k, ans;
  public static int[] keys;
  public static boolean[] chosen;
  public static int[][] quest;
  public static HashSet<Integer> hs;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    keys = new int[2 * n + 1];
    for (int i = 0; i <= 2 * n; i++) {
      keys[i] = i;
    }

    chosen = new boolean[2 * n + 1];
    ans = Integer.MIN_VALUE;

    quest = new int[m][k];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < k; j++) {
        quest[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 1);
    System.out.println(ans);
  }

  public static void dfs(int cnt, int start) {
    if (cnt == n) {
      int res = game();
      ans = Math.max(res, ans);
      return;
    }

    for (int i = start; i <= 2 * n; i++) {
      chosen[i] = true;
      dfs(cnt + 1, i + 1);
      chosen[i] = false;
    }
  }

  public static int game() {
    int cnt = 0;
    boolean flag = true;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < k; j++) {
        if (!chosen[quest[i][j]]) {
          flag = false;
          break;
        }
      }
      if (flag) {
        cnt++;
      }
      flag = true;
    }

    return cnt;
  }
}