import java.util.*;
import java.io.*;

public class Main {
  public static int N, ans;
  public static int[][] eggs;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    eggs = new int[N][2];
    ans = Integer.MIN_VALUE;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      eggs[i][0] = s;
      eggs[i][1] = w;
    }

    dfs(0, 0);
    System.out.println(ans);

  }

  public static void dfs(int idx, int brokenEgg) {
    ans = Math.max(ans, brokenEgg);

    if (idx == N) {
      return;
    }

    if (eggs[idx][0] <= 0) {
      dfs(idx + 1, brokenEgg);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (idx == i || eggs[i][0] <= 0)
        continue;

      int tmp = 0;
      crash(idx, i);

      if (eggs[idx][0] <= 0)
        tmp++;
      if (eggs[i][0] <= 0)
        tmp++;

      dfs(idx + 1, brokenEgg + tmp);

      backTrack(idx, i);

    }

  }

  public static void crash(int idx, int next) {
    eggs[idx][0] -= eggs[next][1];
    eggs[next][0] -= eggs[idx][1];
  }

  public static void backTrack(int idx, int next) {
    eggs[idx][0] += eggs[next][1];
    eggs[next][0] += eggs[idx][1];
  }
}
