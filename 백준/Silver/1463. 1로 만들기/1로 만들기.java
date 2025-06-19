import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[1000001];
    dp[1] = 0;

    for (int i = 2; i <= 1000000; i++) {
      dp[i] = dp[i - 1] + 1;

      if (i % 2 == 0) {
        dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
      }

      if (i % 3 == 0) {
        dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
      }
    }

    System.out.println(dp[n]);

  }
}