import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    ArrayList<Integer> cmd = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    while (true) {
      int c = Integer.parseInt(st.nextToken());
      if (c == 0)
        break;
      cmd.add(c);
    }

    int m = cmd.size();

    int[][][] dp = new int[m + 1][5][5];

    int INF = 100000 * 4 + 1;

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j < 5; j++) {
        Arrays.fill(dp[i][j], INF);
      }
    }
    dp[0][0][0] = 0;

    for (int i = 0; i < m; i++) {
      int p = cmd.get(i);

      for (int l = 0; l < 5; l++) {
        for (int r = 0; r < 5; r++) {
          int cur = dp[i][l][r];

          if (cur == INF)
            continue;

          int costL = move(l, p);
          dp[i + 1][p][r] = Math.min(dp[i + 1][p][r], cur + costL);

          int costR = move(r, p);
          dp[i + 1][l][p] = Math.min(dp[i + 1][l][p], cur + costR);

        }
      }
    }

    int ans = INF;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        ans = Math.min(ans, dp[m][i][j]);
      }
    }

    System.out.println(ans);

  }

  public static int move(int x, int y) {
    if (x == y)
      return 1;
    else if (x == 0)
      return 2;
    else if (Math.abs(x - y) == 2)
      return 4;
    return 3;
  }
}