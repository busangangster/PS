import java.util.*;
import java.io.*;

public class Main {
  public static int sum;
  public static int[][][] dp = new int[21][21][21];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    while (true) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (a == -1 && b == -1 && c == -1)
        break;

      int res = dfs(a, b, c);
      sb.append("w(" + a + ", " + b + ", " + c + ") = " + res).append("\n");
    }

    System.out.println(sb);
  }

  public static int dfs(int x, int y, int z) {
    if (x <= 0 || y <= 0 || z <= 0)
      return 1;

    if (x > 20 || y > 20 || z > 20)
      return dfs(20, 20, 20);

    if (dp[x][y][z] != 0) {
      return dp[x][y][z];
    }

    int ans = 0;
    if (x < y && y < z) {
      ans = dfs(x, y, z - 1) + dfs(x, y - 1, z - 1) - dfs(x, y - 1, z);
    }

    else {
      ans = dfs(x - 1, y, z) + dfs(x - 1, y - 1, z) + dfs(x - 1, y, z - 1) - dfs(x - 1, y - 1, z - 1);
    }

    dp[x][y][z] = ans;
    return ans;
  }
}