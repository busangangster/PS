import java.util.*;
import java.io.*;

public class Main {
  public static int N;
  public static int[][] arr;
  public static long[][] dp;
  public static int[] dx = { 0, 1 };
  public static int[] dy = { 1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    dp = new long[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dp[0][0] = 1L;
    move();

    System.out.println(dp[N - 1][N - 1]);

  }

  public static void move() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (arr[i][j] != 0) {
          for (int k = 0; k < 2; k++) {
            int nx = i + dx[k] * arr[i][j];
            int ny = j + dy[k] * arr[i][j];

            if (check(nx, ny)) {
              dp[nx][ny] += dp[i][j];
            }
          }
        }
      }
    }
  }

  public static boolean check(int x, int y) {
    return (0 <= x && x < N && 0 <= y && y < N);
  }

}