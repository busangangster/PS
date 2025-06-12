import java.util.*;
import java.io.*;

public class Main {
  public static int n;
  public static int[][] arr, dp;
  public static int[] dx = { 0, 1, 0, -1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    int ans = Integer.MIN_VALUE;

    arr = new int[n][n];
    dp = new int[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        ans = Math.max(ans, dfs(i, j));
      }
    }

    System.out.println(ans);
  }

  public static int dfs(int x, int y) {
    if (dp[x][y] != 0)
      return dp[x][y];

    dp[x][y] = 1;
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (check(nx, ny) && arr[x][y] < arr[nx][ny]) {
        dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
      }

    }
    return dp[x][y];
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < n && 0 <= y && y < n);
  }
}