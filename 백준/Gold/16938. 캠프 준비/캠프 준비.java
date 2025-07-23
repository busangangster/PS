import java.util.*;
import java.io.*;

public class Main {
  public static int N, L, R, X, ans;
  public static boolean[] selected;
  public static int[] problems;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    problems = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      problems[i] = Integer.parseInt(st.nextToken());
    }

    selected = new boolean[N];
    ans = 0;

    subset(0);
    System.out.println(ans);
  }

  public static void subset(int cnt) {
    if (cnt == N) {
      if (cal())
        ans++;
      return;
    }

    selected[cnt] = true;
    subset(cnt + 1);

    selected[cnt] = false;
    subset(cnt + 1);
  }

  public static boolean cal() {
    int sum = 0;
    int getTrue = 0;
    int hardest = Integer.MIN_VALUE;
    int easiest = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      if (selected[i]) {
        sum += problems[i];
        getTrue++;
        hardest = Math.max(hardest, problems[i]);
        easiest = Math.min(easiest, problems[i]);
      }
    }
    if (getTrue < 2)
      return false;
    if (hardest - easiest < X)
      return false;
    if (sum < L || sum > R)
      return false;

    return true;
  }
}