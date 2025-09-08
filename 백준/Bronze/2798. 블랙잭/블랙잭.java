import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, ans;
  public static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    ans = Integer.MIN_VALUE;
    dfs(0, 0, 0);
    System.out.println(ans);

  }

  public static void dfs(int start, int cnt, int sum) {
    if (cnt == 3) {
      if (sum == M) {
        System.out.println(M);
        System.exit(0);
      }
      if (sum <= M) {
        ans = Math.max(ans, sum);
      }
      return;
    }

    for (int i = start; i < N; i++) {
      dfs(i + 1, cnt + 1, sum + arr[i]);
    }
  }
}