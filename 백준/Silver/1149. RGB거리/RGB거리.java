import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());

    int[][] arr = new int[n][3];
    int[][] dp = new int[n][3];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dp[0] = arr[0];
    dp[1] = arr[1];
    dp[2] = arr[2];

    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
      dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
      dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
    }

    System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));

  }
}