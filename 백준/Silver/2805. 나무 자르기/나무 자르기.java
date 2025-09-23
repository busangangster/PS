import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, ans;
  public static int[] trees;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    trees = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      trees[i] = Integer.parseInt(st.nextToken());
    }
    bs();
    System.out.println(ans);
  }

  public static void bs() {
    int lt = 0;
    int rt = Arrays.stream(trees).max().getAsInt();

    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (checkPossible(mid)) {
        ans = mid;
        lt = mid + 1;
      } else {
        rt = mid - 1;
      }
    }

  }

  public static boolean checkPossible(int target) {
    long res = 0L;
    for (int tmp : trees) {
      if (tmp > target) {
        res += (tmp - target);
      }
    }
    return res >= M;
  }
}
