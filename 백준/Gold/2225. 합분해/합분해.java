import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    long[][] dp = new long[N + 1][K + 1];
    int mod = 1000000000;

    for (int i = 1; i <= K; i++) {
      dp[1][i] = i;
    }

    for (int i = 2; i <= N; i++) {
      dp[i][1] = 1;
    }

    for (int i = 2; i <= N; i++) {
      for (int j = 2; j <= K; j++) {
        dp[i][j] = ((dp[i][j - 1] % mod) + (dp[i - 1][j]) % mod) % mod;
      }
    }

    System.out.println(dp[N][K]);

  }
}