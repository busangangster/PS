import java.util.*;
import java.io.*;

public class Main {
  public static int N, M, sum, ans;
  public static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    sum = 0;
    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      arr[i] = tmp;
      sum += tmp;

    }
    bs();
    System.out.println(ans);

  }

  public static void bs() {
    int lt = Arrays.stream(arr).max().getAsInt();
    int rt = sum;

    while (lt <= rt) {
      int mid = lt + (rt - lt) / 2;
      if (check(mid)) {
        ans = mid;
        rt = mid - 1;
      } else {
        lt = mid + 1;
      }
    }
  }

  public static boolean check(int target) {
    int cnt = 0;
    int cur = 0;
    for (int i = 0; i < N; i++) {
      if (cur + arr[i] > target) {
        cnt++;
        cur = arr[i];
      } else if (cur + arr[i] == target) {
        cnt++;
        cur = 0;
      } else {
        cur += arr[i];
      }
    }
    if (cur != 0)
      cnt++;
    return cnt <= M;
  }
}
