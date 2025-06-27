import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    long[] dp = new long[n + 1];
    int mod = 15746;

    if (n >= 1) {
      dp[1] = 1;
    }
    if (n >= 2) {
      dp[2] = 2;
    }
    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
    }

    System.out.println(dp[n] % mod);

  }
}