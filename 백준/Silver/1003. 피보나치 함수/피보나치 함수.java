import java.util.*;
import java.io.*;

public class Main {
  public static int zero, one;
  public static int[][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    dp = new int[41][2];
    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[1][0] = 0;
    dp[1][1] = 1;

    for (int i = 2; i <= 40; i++) {
      dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
      dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
    }

    for (int i = 0; i < n; i++) {
      int tmp = Integer.parseInt(br.readLine());
      sb.append(dp[tmp][0] + " " + dp[tmp][1]).append("\n");
    }
    System.out.println(sb);

  }

}