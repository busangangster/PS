import java.util.*;
import java.io.*;

public class Main {
  public static int K, N;
  public static long ans;
  public static int[] lines;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    K = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    lines = new int[K];
    for (int i = 0; i < K; i++) {
      lines[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(lines);
    bs();
    System.out.println(ans);
  }

  public static void bs() {
    long lt = 1L;
    long rt = lines[K - 1];

    while (lt <= rt) {
      long mid = lt + (rt - lt) / 2;
      if (check(mid)) {
        ans = mid;
        lt = mid + 1;
      } else
        rt = mid - 1;
    }
  }

  public static boolean check(long target) {
    long res = 0L;
    for (int tmp : lines) {
      res += tmp / target;
      if (res >= N)
        return true;
    }
    return false;
  }
}
