import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, ans;
  public static int[] budgets;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    budgets = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      budgets[i] = Integer.parseInt(st.nextToken());
    }

    M = Integer.parseInt(br.readLine());

    bs();
    System.out.println(ans);

  }

  public static void bs() {
    int lt = 0;
    int rt = Arrays.stream(budgets).max().getAsInt();

    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (check(mid)) {
        ans = mid;
        lt = mid + 1;
      } else {
        rt = mid - 1;
      }
    }
  }

  public static boolean check(int target) {
    int res = 0;
    for (int tmp : budgets) {
      if (tmp <= target)
        res += tmp;
      else
        res += target;
    }
    return res <= M;
  }
}
