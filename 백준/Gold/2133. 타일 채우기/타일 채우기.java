import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n + 1];

    if (n % 2 != 0) {
      System.out.println(0);
    } else {
      dp[0] = 1;
      if (n >= 2) {
        dp[2] = 3;
      }
      for (int i = 4; i <= n; i += 2) {
        dp[i] = dp[i - 2] * 3;
        for (int j = i - 4; j >= 0; j -= 2) {
          dp[i] += dp[j] * 2;
        }
      }

      System.out.println(dp[n]);
    }
  }
}