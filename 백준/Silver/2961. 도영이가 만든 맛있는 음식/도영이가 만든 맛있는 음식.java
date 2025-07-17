import java.util.*;
import java.io.*;

public class Main {
  public static int n, ans;
  public static boolean[] selected;
  public static ArrayList<int[]> arr = new ArrayList<int[]>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    selected = new boolean[n];
    ans = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr.add(new int[] { s, b });
    }

    subset(0);
    System.out.println(ans);

  }

  public static void subset(int cnt) {
    if (cnt == n) {
      int bitter = 1;
      int sour = 0;

      for (int i = 0; i < n; i++) {
        if (selected[i]) {
          bitter *= arr.get(i)[0];
          sour += arr.get(i)[1];
        }
      }

      if (bitter != 0 && sour != 0) {
        ans = Math.min(ans, Math.abs(bitter - sour));
      }

      return;

    }

    selected[cnt] = true;
    subset(cnt + 1);

    selected[cnt] = false;
    subset(cnt + 1);

  }
}