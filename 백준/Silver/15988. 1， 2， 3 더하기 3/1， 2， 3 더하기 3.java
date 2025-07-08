import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());
    long[] dp = new long[1000001];

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    int mod = 1000000009;

    for (int i = 4; i <= 1000000; i++) {
      dp[i] = (dp[i - 1] % mod) + (dp[i - 2] % mod) + (dp[i - 3] % mod);
    }

    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      sb.append(dp[n] % mod).append("\n");
    }

    System.out.println(sb);
  }
}