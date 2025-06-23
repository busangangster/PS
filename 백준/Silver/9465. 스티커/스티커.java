import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int k = Integer.parseInt(br.readLine());

    while (k-- > 0) {
      int n = Integer.parseInt(br.readLine());

      int[][] arr = new int[2][n];
      int[][] dp = new int[n][3];

      for (int i = 0; i < 2; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      dp[0][0] = arr[0][0];
      dp[0][1] = arr[1][0];
      dp[0][2] = 0;

      for (int i = 1; i < n; i++) {
        dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + arr[0][i];
        dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + arr[1][i];
        dp[i][2] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
      }

      sb.append(Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]))).append("\n");

    }
    System.out.println(sb);

  }
}